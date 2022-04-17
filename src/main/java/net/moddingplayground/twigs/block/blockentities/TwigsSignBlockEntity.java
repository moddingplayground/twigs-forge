package net.moddingplayground.twigs.block.blockentities;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.SignBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.moddingplayground.twigs.init.TwigsBlockEntities;

public class TwigsSignBlockEntity extends SignBlockEntity {

    public TwigsSignBlockEntity(BlockPos pos, BlockState state) {
        super(pos, state);
    }

    @Override
    public BlockEntityType<?> getType() {
        return TwigsBlockEntities.TWIGS_SIGN.get();
    }

}
