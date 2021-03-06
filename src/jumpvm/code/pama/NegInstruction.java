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

package jumpvm.code.pama;

import jumpvm.ast.pama.PaMaAstNode;
import jumpvm.exception.ExecutionException;
import jumpvm.memory.objects.BasicValueObject;
import jumpvm.memory.objects.StackObject;
import jumpvm.vm.PaMa;

/**
 * Numerical negative.
 *
 * <pre>
 * STORE[SP] := - STORE[SP];
 * </pre>
 */
public class NegInstruction extends PaMaInstruction {
    /**
     * Create a new NegInstruction.
     *
     * @param sourceNode AstNode that is responsible for this instruction's creation
     */
    public NegInstruction(final PaMaAstNode sourceNode) {
        super(sourceNode);
    }

    @Override
    public final void execute(final PaMa vm) throws ExecutionException {
        final StackObject object = vm.pop();
        vm.push(new BasicValueObject(-object.getIntValue(), null, null));
    }

    @Override
    public final String getDisplayHoverText() {
        return "Numerical negative";
    }

    @Override
    public final String getMnemonic() {
        return "neg";
    }

    @Override
    public final String getParameter() {
        return null;
    }
}
