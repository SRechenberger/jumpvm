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

package jumpvm.vm;


import jumpvm.memory.Register;
import jumpvm.memory.Stack;


public class LiMa extends JumpVM {

    private final Stack stack; 

    private final Heap heap;

    private final Register stackPointer;

    private final Register markPointer;

    public LiMa(){
        this.stackPointer = new Register("SP", "Stack Pointer", -1);

        this.markPointer = new Register("MP", "Mark Pointer", -1);

        this.stack = new Stack(stackPointer, "Construction");

        this.heap = new Heap("List");

        addDisplayMemory(stackPointer);
        addDisplayMemory(stack);
        addDisplayMemory(heap);
    }

    public final Register getStackPointer(){
        return stackPointer;
    }

    public final Register getMarkPointer(){
        return markPointer;
    }

    public final Heap getHeap(){
        return heap;
    }

    public final Stack getStack(){
        return stack;
    }

}