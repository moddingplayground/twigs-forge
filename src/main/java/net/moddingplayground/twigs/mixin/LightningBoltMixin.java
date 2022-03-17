package net.moddingplayground.twigs.mixin;

import net.moddingplayground.twigs.block.PillarOxidizableBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.WeatheringCopper;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Optional;

@Mixin(LightningBolt.class)
public class LightningBoltMixin {

    @Inject(at = @At("HEAD"), method = "randomStepCleaningCopper", cancellable = true)
    private static void randomStepCleaningCopper(Level world, BlockPos pos, CallbackInfoReturnable<Optional<BlockPos>> cir) {
        for(BlockPos blockpos : BlockPos.randomInCube(world.random, 10, pos, 1)) {
            BlockState blockstate = world.getBlockState(blockpos);
            if (blockstate.getBlock() instanceof PillarOxidizableBlock || blockstate.getBlock() instanceof WeatheringCopper) {
                WeatheringCopper.getPrevious(blockstate).ifPresent((state) -> {
                    world.setBlockAndUpdate(blockpos, state);
                });
                PillarOxidizableBlock.getPreviousState(blockstate).ifPresent(state -> {
                    world.setBlockAndUpdate(blockpos, state);
                });
                world.levelEvent(3002, blockpos, -1);
                cir.setReturnValue(Optional.of(blockpos));
            }
        }

        cir.setReturnValue(Optional.empty());
    }

}
