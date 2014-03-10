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

package jumpvm.code.wima;

import jumpvm.ast.AstNode;
import jumpvm.code.Instruction;
import jumpvm.exception.ExecutionException;
import jumpvm.vm.JumpVM;

/**
 * WiMa instruction.
 */
public abstract class WiMaInstruction extends Instruction {
    /**
     * Create a new WiMaInstruction.
     * 
     * @param sourceNode AstNode that is responsible for this instruction's creation
     */
    public WiMaInstruction(final AstNode<?> sourceNode) {
        super(sourceNode);
    }

    @Override
    public final void execute(final JumpVM jumpVM) throws ExecutionException {
    }
}