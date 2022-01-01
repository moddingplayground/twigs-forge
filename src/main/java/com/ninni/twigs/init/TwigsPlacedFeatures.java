package com.ninni.twigs.init;

import com.ninni.twigs.Twigs;
import net.minecraft.core.Registry;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.placement.BiomeFilter;
import net.minecraft.world.level.levelgen.placement.CountPlacement;
import net.minecraft.world.level.levelgen.placement.HeightRangePlacement;
import net.minecraft.world.level.levelgen.placement.InSquarePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;
import net.minecraft.world.level.levelgen.placement.RarityFilter;

import java.util.List;

public class TwigsPlacedFeatures {
    public static final PlacedFeature PATCH_TWIG = register("patch_twig", TwigsConfiguredFeatures.PATCH_TWIG.placed(InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome()));
    public static final PlacedFeature PATCH_PEBBLE = register("patch_pebble", TwigsConfiguredFeatures.PATCH_PEBBLE.placed(InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome()));
    public static final PlacedFeature ORE_RHYOLITE_LOWER = register("ore_rhyolite_lower", TwigsConfiguredFeatures.ORE_RHYOLITE.placed(commonOrePlacement(2, HeightRangePlacement.uniform(VerticalAnchor.bottom(), VerticalAnchor.absolute(16)))));
    public static final PlacedFeature ORE_SCHIST_UPPER = register("ore_schist_upper", TwigsConfiguredFeatures.ORE_SCHIST.placed(rareOrePlacement(6, HeightRangePlacement.uniform(VerticalAnchor.absolute(64), VerticalAnchor.absolute(128)))));
    public static final PlacedFeature ORE_SCHIST_LOWER = register("ore_schist_lower", TwigsConfiguredFeatures.ORE_SCHIST.placed(commonOrePlacement(2, HeightRangePlacement.uniform(VerticalAnchor.absolute(0), VerticalAnchor.absolute(60)))));
    public static final PlacedFeature ORE_BLOODSTONE_NETHER = register("ore_bloodstone_nether", TwigsConfiguredFeatures.ORE_BLOODSTONE.placed(commonOrePlacement(2, HeightRangePlacement.uniform(VerticalAnchor.absolute(5), VerticalAnchor.absolute(225)))));

    public static PlacedFeature register(String name, PlacedFeature feature) {
        ResourceLocation ID = new ResourceLocation(Twigs.MOD_ID, name);
        if (BuiltinRegistries.PLACED_FEATURE.keySet().contains(ID))
            throw new IllegalArgumentException("The Placed Feature" + name + "already exists in registry");

        Registry.register(BuiltinRegistries.PLACED_FEATURE, ID, feature);
        return feature;
    }

    /*
    Extracted from OrePlacements
     */
    private static List<PlacementModifier> orePlacement(PlacementModifier p_195347_, PlacementModifier p_195348_) {
        return List.of(p_195347_, InSquarePlacement.spread(), p_195348_, BiomeFilter.biome());
    }

    private static List<PlacementModifier> commonOrePlacement(int p_195344_, PlacementModifier p_195345_) {
        return orePlacement(CountPlacement.of(p_195344_), p_195345_);
    }

    private static List<PlacementModifier> rareOrePlacement(int p_195350_, PlacementModifier p_195351_) {
        return orePlacement(RarityFilter.onAverageOnceEvery(p_195350_), p_195351_);
    }


}


