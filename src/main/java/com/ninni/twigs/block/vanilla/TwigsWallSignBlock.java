package com.ninni.twigs.block.vanilla;

import com.ninni.twigs.init.TwigsBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.WallSignBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.WoodType;

import java.util.Objects;

public class TwigsWallSignBlock extends WallSignBlock {

    public TwigsWallSignBlock(BlockBehaviour.Properties properties, WoodType type) {
        super(properties, type);
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return TwigsBlockEntities.TWIGS_SIGN.get().create(pos, state);
    }

//    @Override
//    public final Identifier getLootTableId() {
//        Identifier correctedLootTableId = new Identifier(MOD_ID, "blocks/" + this.getSignType().getName() + "_sign");
//        if (!Objects.equals(this.lootTableId, correctedLootTableId)) {
//            this.lootTableId = correctedLootTableId;
//        }
//
//        return this.lootTableId;
//    }
}
