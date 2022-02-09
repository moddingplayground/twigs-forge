package com.ninni.twigs.mixin;

import com.ninni.twigs.block.StrippedBambooBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.phys.Vec3;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(BlockBehaviour.BlockStateBase.class)
public class BlockStateBaseMixin {

    @Inject(at = @At("HEAD"), method = "getOffset", cancellable = true)
    public void getOffset(BlockGetter world, BlockPos pos, CallbackInfoReturnable<Vec3> cir) {
        BlockBehaviour.BlockStateBase $this = (BlockBehaviour.BlockStateBase) (Object) this;
        if ($this.getBlock() instanceof StrippedBambooBlock && !$this.getValue(StrippedBambooBlock.FROM_BAMBOO)) {
            cir.setReturnValue(Vec3.ZERO);
        }
    }

}
