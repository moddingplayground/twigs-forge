package net.moddingplayground.twigs.block;

import com.google.common.base.Suppliers;
import com.google.common.collect.BiMap;
import com.google.common.collect.ImmutableBiMap;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.WeatheringCopper;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.moddingplayground.twigs.init.TwigsBlocks;

import java.util.Optional;
import java.util.Random;
import java.util.function.Supplier;

@SuppressWarnings("deprecation")
public class PillarOxidizableBlock extends RotatedPillarBlock implements WeatheringCopper {
    private final WeatherState level;
    public static Supplier<BiMap<Block, Block>> NEXT_BY_BLOCK = Suppliers.memoize(() -> {
        return ImmutableBiMap.<Block, Block>builder()
                .put(TwigsBlocks.COPPER_PILLAR.get(), TwigsBlocks.EXPOSED_COPPER_PILLAR.get())
                .put(TwigsBlocks.EXPOSED_COPPER_PILLAR.get(), TwigsBlocks.WEATHERED_COPPER_PILLAR.get())
                .put(TwigsBlocks.WEATHERED_COPPER_PILLAR.get(), TwigsBlocks.OXIDIZED_COPPER_PILLAR.get())
                .build();
    });
    public static final Supplier<BiMap<Block, Block>> PREVIOUS_BY_BLOCK = Suppliers.memoize(() -> {
        return NEXT_BY_BLOCK.get().inverse();
    });

    public PillarOxidizableBlock(WeatheringCopper.WeatherState level, BlockBehaviour.Properties settings) {
        super(settings);
        this.level = level;
    }

    @Override
    public void randomTick(BlockState state, ServerLevel world, BlockPos pos, RandomSource random) {
        this.onRandomTick(state, world, pos, random);
    }

    @Override
    public boolean isRandomlyTicking(BlockState state) {
        return Optional.ofNullable(NEXT_BY_BLOCK.get().get(state.getBlock())).isPresent();
    }

    @Override
    public Optional<BlockState> getNext(BlockState state) {
        return Optional.ofNullable(NEXT_BY_BLOCK.get().get(state.getBlock())).map((block) -> block.withPropertiesOf(state));
    }

    public static Optional<BlockState> getPreviousState(BlockState state) {
        return Optional.ofNullable(PREVIOUS_BY_BLOCK.get().get(state.getBlock())).map((block) -> block.withPropertiesOf(state));
    }

    @Override
    public WeatherState getAge() {
        return this.level;
    }
}
