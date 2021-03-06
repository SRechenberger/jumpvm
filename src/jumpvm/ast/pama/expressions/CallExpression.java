/*
 * JumpVM: The Java Unified Multi Paradigm Virtual Machine.
 * Copyright (C) 2013 Tim Wiederhake
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see http://www.gnu.org/licenses/.
 */

package jumpvm.ast.pama.expressions;

import java.util.ArrayList;

import jumpvm.ast.pama.Expression;
import jumpvm.ast.pama.Type;
import jumpvm.ast.pama.types.ArrayType;
import jumpvm.ast.pama.types.FunctionType;
import jumpvm.ast.pama.types.RecordType;
import jumpvm.compiler.Location;
import jumpvm.compiler.pama.PaMaAstWalker;
import jumpvm.exception.CompileException;
import jumpvm.vm.PaMa;

/** Call {@link Expression}. */
public class CallExpression extends Expression {
    /** Default serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /** Function / Procedure name. */
    private final String identifier;

    /** Arguments. */
    private final ArrayList<Expression> expressionList;

    /**
     * Create a new CallExpression.
     *
     * @param begin begin
     * @param end end
     * @param identifier function / procedure name
     * @param expressionList arguments
     */
    public CallExpression(final Location begin, final Location end, final String identifier, final ArrayList<Expression> expressionList) {
        super(begin, end);
        this.identifier = identifier;
        this.expressionList = expressionList;

        for (final Expression expression : expressionList) {
            add(expression);
        }
    }

    /**
     * Returns the list of argument expressions.
     *
     * @return the list of argument expressions
     */
    public final ArrayList<Expression> getExpressionList() {
        return expressionList;
    }

    /**
     * Returns the function / procedure name.
     *
     * @return the function / procedure name
     */
    public final String getIdentifier() {
        return identifier;
    }

    @Override
    public final int getMaxStackSize() {
        int offset = PaMa.FRAME_SIZE;
        int size = 0;
        for (int i = 0; i < expressionList.size(); ++i) {
            final Expression expression = expressionList.get(i);
            final Type type = expression.getType().getResolvedType();
            size = Math.max(size, offset + expression.getMaxStackSize());
            if (expression.isReference()) {
                offset += 1;
            } else if (type instanceof RecordType) {
                offset += type.getSize();
            } else if (type instanceof ArrayType) {
                final int descriptorSize = ((ArrayType) type).getDescriptorSize();
                size = Math.max(size, offset + descriptorSize);
                offset += descriptorSize;
            } else if (type instanceof FunctionType) {
                offset += type.getSize();
            } else {
                offset += 1;
            }
        }
        return size;
    }

    @Override
    public final void process(final PaMaAstWalker treewalker) throws CompileException {
        treewalker.process(this);
    }

    @Override
    public final String toString() {
        return identifier;
    }
}
