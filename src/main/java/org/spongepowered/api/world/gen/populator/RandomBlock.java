/*
 * This file is part of SpongeAPI, licensed under the MIT License (MIT).
 *
 * Copyright (c) SpongePowered <https://www.spongepowered.org>
 * Copyright (c) contributors
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package org.spongepowered.api.world.gen.populator;

import org.spongepowered.api.block.BlockState;
import org.spongepowered.api.block.BlockType;
import org.spongepowered.api.util.VariableAmount;
import org.spongepowered.api.world.Location;
import org.spongepowered.api.world.gen.Populator;

import com.google.common.base.Predicate;

/**
 * Represents a populator which creates random distributions of singular blocks,
 * such as fire in the nether and water in the walls of caves.
 */
public interface RandomBlock extends Populator {

    /**
     * Gets the {@link BlockState} that this populator will randomly distribute.
     * 
     * @return The block state
     */
    BlockState getBlock();

    /**
     * Sets the {@link BlockState} that this populator will randomly distribute.
     * 
     * @param block The new block state
     */
    void setBlock(BlockState block);

    /**
     * Gets the number of blocks to attempt to spawn per chunk, must be greater
     * than zero.
     * 
     * @return The number to spawn
     */
    VariableAmount getAttemptsPerChunk();

    /**
     * Sets the number of blocks to attempt to spawn per chunk, must be greater
     * than zero.
     * 
     * @param count The new number to spawn
     */
    void setAttemptsPerChunk(VariableAmount count);

    VariableAmount getHeightRange();

    void setHeightRange(VariableAmount height);

    /**
     * Gets the {@link Predicate} that this populator used to determine of a
     * given {@link Location} is valid to attempt to place a block at.
     * 
     * @return The targeted block predicate
     */
    Predicate<Location> getPlacementTarget();

    /**
     * Sets the {@link Predicate} that this populator used to determine of a
     * given {@link Location} is valid to attempt to place a blockat.
     * 
     * @param target The new targeted block predicate
     */
    void getPlacementTarget(Predicate<Location> target);

    /**
     * A builder for constructing {@link RandomBlock} populators.
     */
    interface Builder {

        /**
         * Sets the {@link BlockState} that this populator will randomly
         * distribute.
         * 
         * @param block The new block state
         * @return This builder, for chaining
         */
        Builder block(BlockState block);

        /**
         * Sets the number of blocks to attempt to spawn per chunk, must be
         * greater than zero.
         * 
         * @param count The new number to spawn
         * @return This builder, for chaining
         */
        Builder perChunk(VariableAmount count);

        /**
         * Sets the {@link Predicate} that this populator used to determine of a
         * given {@link BlockType} is valid to attempt to place a block of fire
         * on top of.
         * 
         * @param target The new targeted block predicate
         * @return This builder, for chaining
         */
        Builder placementTarget(Predicate<Location> target);

		Builder height(VariableAmount height);

        /**
         * Resets this builder to the default values.
         * 
         * @return This builder, for chaining
         */
        Builder reset();

        /**
         * Builds a new instance of a {@link RandomBlock} populator with the
         * settings set within the builder.
         * 
         * @return A new instance of the populator
         * @throws IllegalStateException If there are any settings left unset
         *         which do not have default values
         */
        RandomBlock build() throws IllegalStateException;

    }

}
