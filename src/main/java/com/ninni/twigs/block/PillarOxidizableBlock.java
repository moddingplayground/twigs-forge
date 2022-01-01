package com.ninni.twigs.block;

import com.google.common.base.Suppliers;
import com.google.common.collect.BiMap;
import com.google.common.collect.ImmutableBiMap;
import com.ninni.twigs.api.WeatheringPillar;
import com.ninni.twigs.init.TwigsBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.WeatheringCopper;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;

import java.util.Optional;
import java.util.Random;
import java.util.function.Supplier;

@SuppressWarnings("deprecation")
public class PillarOxidizableBlock extends RotatedPillarBlock implements WeatheringCopper {
    private final WeatherState level;
    Supplier<BiMap<Block, Block>> NEXT_BY_BLOCK = Suppliers.memoize(() -> {
        return ImmutableBiMap.<Block, Block>builder().put(TwigsBlocks.COPPER_PILLAR.get(), TwigsBlocks.EXPOSED_COPPER_PILLAR.get()).put(TwigsBlocks.EXPOSED_COPPER_PILLAR.get(), TwigsBlocks.WEATHERED_COPPER_PILLAR.get()).put(TwigsBlocks.WEATHERED_COPPER_PILLAR.get(), TwigsBlocks.OXIDIZED_COPPER_PILLAR.get()).build();
    });

    public PillarOxidizableBlock(WeatheringCopper.WeatherState level, BlockBehaviour.Properties settings) {
        super(settings);
        this.level = level;
    }

    @Override
    public void randomTick(BlockState state, ServerLevel world, BlockPos pos, Random random) {
        this.onRandomTick(state, world, pos, random);
    }

    @Override
    public boolean isRandomlyTicking(BlockState state) {
        return WeatheringPillar.getNext(state.getBlock()).isPresent();
    }

    @Override
    public Optional<BlockState> getNext(BlockState state) {
        return Optional.ofNullable(NEXT_BY_BLOCK.get().get(state.getBlock())).map((block) -> block.withPropertiesOf(state));
    }

    public WeatherState getAge() {
        return this.level;
    }
}