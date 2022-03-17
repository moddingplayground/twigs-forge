package net.moddingplayground.twigs.init;

import net.moddingplayground.twigs.Twigs;
import net.minecraft.core.Holder;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.BiomeFilter;
import net.minecraft.world.level.levelgen.placement.CountPlacement;
import net.minecraft.world.level.levelgen.placement.HeightRangePlacement;
import net.minecraft.world.level.levelgen.placement.InSquarePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;
import net.minecraft.world.level.levelgen.placement.RarityFilter;

import java.util.List;

public class TwigsPlacedFeatures {

    public static void init() {
    }

    public static final Holder<PlacedFeature> PATCH_TWIG = registerPlacedFeature("patch_twig", TwigsConfiguredFeatures.PATCH_TWIG, InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome());
    public static final Holder<PlacedFeature> PATCH_PEBBLE = registerPlacedFeature("patch_pebble", TwigsConfiguredFeatures.PATCH_PEBBLE, InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome());
    public static final Holder<PlacedFeature> ORE_RHYOLITE_LOWER = registerPlacedFeature("ore_rhyolite_lower", TwigsConfiguredFeatures.ORE_RHYOLITE, commonOrePlacement(2, HeightRangePlacement.uniform(VerticalAnchor.bottom(), VerticalAnchor.absolute(16))));
    public static final Holder<PlacedFeature> ORE_SCHIST_UPPER = registerPlacedFeature("ore_schist_upper", TwigsConfiguredFeatures.ORE_SCHIST, rareOrePlacement(6, HeightRangePlacement.uniform(VerticalAnchor.absolute(64), VerticalAnchor.absolute(128))));
    public static final Holder<PlacedFeature> ORE_SCHIST_LOWER = registerPlacedFeature("ore_schist_lower", TwigsConfiguredFeatures.ORE_SCHIST, commonOrePlacement(2, HeightRangePlacement.uniform(VerticalAnchor.absolute(0), VerticalAnchor.absolute(60))));
    public static final Holder<PlacedFeature> ORE_BLOODSTONE_NETHER = registerPlacedFeature("ore_bloodstone_nether", TwigsConfiguredFeatures.ORE_BLOODSTONE, commonOrePlacement(2, HeightRangePlacement.uniform(VerticalAnchor.absolute(5), VerticalAnchor.absolute(225))));

    public static Holder<PlacedFeature> registerPlacedFeature(String string, Holder<? extends ConfiguredFeature<?, ?>> holder, List<PlacementModifier> list) {
        return BuiltinRegistries.registerExact(BuiltinRegistries.PLACED_FEATURE, Twigs.MOD_ID + ":" + string, new PlacedFeature(Holder.hackyErase(holder), List.copyOf(list)));
    }

    public static Holder<PlacedFeature> registerPlacedFeature(String string, Holder<? extends ConfiguredFeature<?, ?>> holder, PlacementModifier ... placementModifiers) {
        return registerPlacedFeature(string, holder, List.of(placementModifiers));
    }

    /*
    Extracted from OrePlacements
     */
    private static List<PlacementModifier> orePlacement(PlacementModifier modifier, PlacementModifier modifier2) {
        return List.of(modifier, InSquarePlacement.spread(), modifier2, BiomeFilter.biome());
    }

    private static List<PlacementModifier> commonOrePlacement(int count, PlacementModifier modifier) {
        return orePlacement(CountPlacement.of(count), modifier);
    }

    private static List<PlacementModifier> rareOrePlacement(int chance, PlacementModifier modifier) {
        return orePlacement(RarityFilter.onAverageOnceEvery(chance), modifier);
    }


}
