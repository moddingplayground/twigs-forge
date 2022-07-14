package net.moddingplayground.twigs.mixin;

import com.google.common.base.Suppliers;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderSet;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.MultifaceBlock;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.MultifaceGrowthFeature;
import net.minecraft.world.level.levelgen.feature.configurations.MultifaceGrowthConfiguration;
import net.moddingplayground.twigs.init.TwigsBlocks;
import net.moddingplayground.twigs.mixin.access.FeatureContextAccessor;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

import java.util.function.Supplier;

@Mixin(MultifaceGrowthFeature.class)
public class MultifaceGrowthFeatureMixin {
    private static @Unique
    final Supplier<MultifaceGrowthConfiguration> TWIGS_PETRIFIED_LICHEN_REPLACEMENT_CONFIG = Suppliers.memoize(() -> new MultifaceGrowthConfiguration(
            (MultifaceBlock) TwigsBlocks.PETRIFIED_LICHEN.get(), 20, true, true, true, 0.5F,
            HolderSet.direct(Block::builtInRegistryHolder, Blocks.STONE, Blocks.ANDESITE, Blocks.DIORITE, Blocks.GRANITE, Blocks.DRIPSTONE_BLOCK, Blocks.CALCITE, Blocks.TUFF, Blocks.DEEPSLATE)
    ));

    @SuppressWarnings("unchecked")
    @ModifyVariable(method = "place", at = @At(value = "HEAD", ordinal = 0), argsOnly = true)
    private FeaturePlaceContext<MultifaceGrowthConfiguration> onGenerate(FeaturePlaceContext<MultifaceGrowthConfiguration> context) {
        BlockPos origin = context.origin();

        // replace glow lichen below y0
        if (origin.getY() < 0) {
            MultifaceGrowthConfiguration config = context.config();
            if (config.placeBlock == Blocks.GLOW_LICHEN) {
                FeatureContextAccessor<MultifaceGrowthConfiguration> accessor = (FeatureContextAccessor<MultifaceGrowthConfiguration>) context;
                accessor.setConfig(TWIGS_PETRIFIED_LICHEN_REPLACEMENT_CONFIG.get());
            }
        }

        return context;
    }
}
