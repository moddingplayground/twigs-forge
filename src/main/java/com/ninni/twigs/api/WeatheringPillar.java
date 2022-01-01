package com.ninni.twigs.api;

import com.google.common.base.Suppliers;
import com.google.common.collect.BiMap;
import com.google.common.collect.ImmutableBiMap;
import com.ninni.twigs.init.TwigsBlocks;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.ChangeOverTimeBlock;
import net.minecraft.world.level.block.state.BlockState;

import java.util.Optional;
import java.util.function.Supplier;

public interface WeatheringPillar extends ChangeOverTimeBlock<WeatheringPillar.PillarState> {
    Supplier<BiMap<Block, Block>> NEXT_BY_BLOCK = Suppliers.memoize(() -> {
        return ImmutableBiMap.<Block, Block>builder().put(TwigsBlocks.COPPER_PILLAR.get(), TwigsBlocks.EXPOSED_COPPER_PILLAR.get()).put(TwigsBlocks.EXPOSED_COPPER_PILLAR.get(), TwigsBlocks.WEATHERED_COPPER_PILLAR.get()).put(TwigsBlocks.WEATHERED_COPPER_PILLAR.get(), TwigsBlocks.OXIDIZED_COPPER_PILLAR.get()).build();
    });
    Supplier<BiMap<Block, Block>> PREVIOUS_BY_BLOCK = Suppliers.memoize(() -> {
        return NEXT_BY_BLOCK.get().inverse();
    });

    static Optional<Block> getPrevious(Block block) {
        return Optional.ofNullable(PREVIOUS_BY_BLOCK.get().get(block));
    }

    static Block getFirst(Block blocks) {
        Block block = blocks;

        for(Block block1 = PREVIOUS_BY_BLOCK.get().get(blocks); block1 != null; block1 = PREVIOUS_BY_BLOCK.get().get(block1)) {
            block = block1;
        }

        return block;
    }

    static Optional<BlockState> getPrevious(BlockState state) {
        return getPrevious(state.getBlock()).map((block) -> {
            return block.withPropertiesOf(state);
        });
    }

    static Optional<Block> getNext(Block block) {
        return Optional.ofNullable(NEXT_BY_BLOCK.get().get(block));
    }

    static BlockState getFirst(BlockState state) {
        return getFirst(state.getBlock()).withPropertiesOf(state);
    }

    default Optional<BlockState> getNext(BlockState state) {
        return getNext(state.getBlock()).map((block) -> {
            return block.withPropertiesOf(state);
        });
    }

    default float getChanceModifier() {
        return this.getAge() == WeatheringPillar.PillarState.UNAFFECTED ? 0.75F : 1.0F;
    }

    public static enum PillarState {
        UNAFFECTED,
        EXPOSED,
        WEATHERED,
        OXIDIZED;
    }
}
