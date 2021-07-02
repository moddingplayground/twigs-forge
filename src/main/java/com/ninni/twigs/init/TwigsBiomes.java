package com.ninni.twigs.init;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.impl.biome.modification.BuiltInRegistryKeys;
import net.minecraft.world.biome.BiomeKeys;
import net.minecraft.world.gen.GenerationStep;

@SuppressWarnings({"UnstableApiUsage", "deprecation"})
public class TwigsBiomes {
    static {
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.MOUNTAINS, BiomeKeys.WOODED_MOUNTAINS, BiomeKeys.GRAVELLY_MOUNTAINS, BiomeKeys.MODIFIED_GRAVELLY_MOUNTAINS, BiomeKeys.MOUNTAIN_EDGE), GenerationStep.Feature.UNDERGROUND_ORES, BuiltInRegistryKeys.get(TwigsConfiguredFeatures.ORE_SCHIST));
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.NETHER_WASTES, BiomeKeys.WARPED_FOREST, BiomeKeys.CRIMSON_FOREST, BiomeKeys.SOUL_SAND_VALLEY), GenerationStep.Feature.UNDERGROUND_ORES, BuiltInRegistryKeys.get(TwigsConfiguredFeatures.ORE_BLOODSTONE));
    }
}
