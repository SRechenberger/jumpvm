/*
 * LiMa: Minimal LISP Machine for the 
 * JumpVM: The Java Unified Multi Paradigm Virtual Machine by Tim Wiederhake.
 *
 * Copyright (C) 2015 Sascha Rechenberger
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

package jumpvm.code.lima;

import jumpvm.ast.AstNode;
import jumpvm.code.Instruction;
import jumpvm.exception.ExecutionException;
import jumpvm.memory.objects.MemoryObject;
import jumpvm.vm.JumpVM;
import jumpvm.vm.LiMa;

public class LiMaInstruction extends Instruction {

	public LiMaInstruction(final AstNode<?> sourceNode) {
        super(sourceNode);
    }


	@Override
    public final void execute(final JumpVM jumpVM) throws ExecutionException {
        if (!(jumpVM instanceof LiMa)) {
            throw new ExecutionException(this, "wrong VM");
        }

        execute((LiMa) jumpVM);
    }

    public abstract void execute(final LiMa vm) throws ExecutionException;
}