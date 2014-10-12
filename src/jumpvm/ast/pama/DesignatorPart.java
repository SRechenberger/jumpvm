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

package jumpvm.ast.pama;

import jumpvm.compiler.Location;

/** Part of a PaMa {@link Designator}. */
public abstract class DesignatorPart extends PaMaAstNode {
    /** Default serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /** Deduced type of this subexpression. */
    private Type type;

    /**
     * Create a new DesignatorPart.
     *
     * @param begin begin
     * @param end end
     */
    public DesignatorPart(final Location begin, final Location end) {
        super(begin, end);
    }

    /**
     * Returns the maximum stack usage on execution.
     *
     * @return the maximum stack usage on execution
     */
    public abstract int getMaxStackSize();

    /**
     * Returns the type of this subexpression.
     *
     * @return the type of this subexpression
     */
    public final Type getType() {
        return type;
    }

    /**
     * Sets the type of this subexpression.
     *
     * @param type type of this subexpression
     */
    public final void setType(final Type type) {
        this.type = type;
    }
}