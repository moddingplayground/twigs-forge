//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.ninni.twigs.init;

import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;

public class TwigsConfiguredFeatures {

    public static final ConfiguredFeature<RandomPatchFeatureConfig, ?> PATCH_TWIG;
    public static final ConfiguredFeature<RandomPatchFeatureConfig, ?> PATCH_PEBBLE;


    public TwigsConfiguredFeatures() {
    }

    private static RandomPatchFeatureConfig createRandomPatchFeatureConfig(BlockStateProvider block, int tries) {
        return ConfiguredFeatures.createRandomPatchFeatureConfig(tries, Feature.SIMPLE_BLOCK.configure(new SimpleBlockFeatureConfig(block)).withInAirFilter());
    }


    static {
        PATCH_TWIG = ConfiguredFeatures.register("patch_twig", Feature.RANDOM_PATCH.configure(createRandomPatchFeatureConfig(BlockStateProvider.of(TwigsBlocks.TWIG.getDefaultState().getBlock()), 16)));
        PATCH_PEBBLE = ConfiguredFeatures.register("patch_pebble", Feature.RANDOM_PATCH.configure(createRandomPatchFeatureConfig(BlockStateProvider.of(TwigsBlocks.PEBBLE.getDefaultState().getBlock()), 8)));
    }
}
