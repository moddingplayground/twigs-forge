package com.ninni.twigs.init;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.impl.biome.modification.BuiltInRegistryKeys;
import net.minecraft.world.biome.BiomeKeys;
import net.minecraft.world.gen.GenerationStep;

@SuppressWarnings({"UnstableApiUsage", "deprecation"})
public class TwigsBiomes {
    static {
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.MEADOW, BiomeKeys.GROVE, BiomeKeys.SNOWY_SLOPES, BiomeKeys.JAGGED_PEAKS, BiomeKeys.FROZEN_PEAKS, BiomeKeys.STONY_PEAKS), GenerationStep.Feature.UNDERGROUND_ORES, BuiltInRegistryKeys.get(TwigsConfiguredFeatures.ORE_SCHIST));
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.NETHER_WASTES, BiomeKeys.WARPED_FOREST, BiomeKeys.CRIMSON_FOREST, BiomeKeys.SOUL_SAND_VALLEY), GenerationStep.Feature.UNDERGROUND_ORES, BuiltInRegistryKeys.get(TwigsConfiguredFeatures.ORE_BLOODSTONE));
        BiomeModifications.addFeature(BiomeSelectors.all(), GenerationStep.Feature.UNDERGROUND_ORES, BuiltInRegistryKeys.get(TwigsConfiguredFeatures.ORE_RHYOLITE));
    }
}
