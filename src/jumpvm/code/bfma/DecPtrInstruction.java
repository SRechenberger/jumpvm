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

package jumpvm.code.bfma;

import jumpvm.ast.bfma.BfMaAstNode;
import jumpvm.exception.ExecutionException;
import jumpvm.memory.Register;
import jumpvm.vm.BfMa;

/**
 * Decrement the cell pointer.
 * 
 * <pre>
 * --ptr;
 * </pre>
 */
public class DecPtrInstruction extends BfMaInstruction {
    /**
     * Create a new DecPtrInstruction.
     * 
     * @param sourceNode AstNode that is responsible for this instruction's creation
     */
    public DecPtrInstruction(final BfMaAstNode sourceNode) {
        super(sourceNode);
    }

    @Override
    protected final void execute(final BfMa vm) throws ExecutionException {
        final Register cellPointer = vm.getCellPointer();
        final int value = cellPointer.getValue() - 1;
        cellPointer.setValue(Math.max(0, value));
    }

    @Override
    public final String getDisplayHoverText() {
        return "Decrement the cell pointer";
    }

    @Override
    public final String getMnemonic() {
        return "&lt;";
    }

    @Override
    public final String getParameter() {
        return null;
    }
}
