package net.moddingplayground.twigs.block.vanilla;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.WallSignBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.moddingplayground.twigs.init.TwigsBlockEntities;

public class TwigsWallSignBlock extends WallSignBlock {

    public TwigsWallSignBlock(BlockBehaviour.Properties properties, WoodType type) {
        super(properties, type);
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return TwigsBlockEntities.TWIGS_SIGN.get().create(pos, state);
    }

}
