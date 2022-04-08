//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package net.moddingplayground.twigs.init;

import net.moddingplayground.twigs.Twigs;
import net.minecraft.core.Holder;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.RandomPatchConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;

public class TwigsConfiguredFeatures {

    public static void init() {
    }

    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> PATCH_TWIG = registerConfiguredFeature("patch_twig", Feature.RANDOM_PATCH, createRandomPatchConfiguration(BlockStateProvider.simple(TwigsBlocks.TWIG.get().defaultBlockState().getBlock()), 3));
    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> PATCH_PEBBLE = registerConfiguredFeature("patch_pebble", Feature.RANDOM_PATCH, createRandomPatchConfiguration(BlockStateProvider.simple(TwigsBlocks.PEBBLE.get().defaultBlockState().getBlock()), 2));
    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> PATCH_SEA_SHELL = registerConfiguredFeature("patch_sea_shell", Feature.RANDOM_PATCH, createRandomPatchConfiguration(BlockStateProvider.simple(TwigsBlocks.SEA_SHELL.get().defaultBlockState().getBlock()), 2));
    public static final Holder<ConfiguredFeature<OreConfiguration, ?>> ORE_RHYOLITE = registerConfiguredFeature("ore_rhyolite", Feature.ORE, new OreConfiguration(new TagMatchTest(BlockTags.BASE_STONE_OVERWORLD), TwigsBlocks.RHYOLITE.get().defaultBlockState(), 45));
    public static final Holder<ConfiguredFeature<OreConfiguration, ?>> ORE_SCHIST = registerConfiguredFeature("ore_schist", Feature.ORE, new OreConfiguration(new TagMatchTest(BlockTags.BASE_STONE_OVERWORLD), TwigsBlocks.SCHIST.get().defaultBlockState(), 64));
    public static final Holder<ConfiguredFeature<OreConfiguration, ?>> ORE_BLOODSTONE = registerConfiguredFeature("ore_bloodstone", Feature.ORE, new OreConfiguration(new TagMatchTest(BlockTags.BASE_STONE_NETHER), TwigsBlocks.BLOODSTONE.get().defaultBlockState(), 64));

    public static <FC extends FeatureConfiguration, F extends Feature<FC>> Holder<ConfiguredFeature<FC, ?>> registerConfiguredFeature(String id, F feature, FC featureConfiguration) {
        return BuiltinRegistries.registerExact(BuiltinRegistries.CONFIGURED_FEATURE, Twigs.MOD_ID  + ":" + id, new ConfiguredFeature<>(feature, featureConfiguration));
    }

    private static RandomPatchConfiguration createRandomPatchConfiguration(BlockStateProvider block, int tries) {
        return FeatureUtils.simpleRandomPatchConfiguration(tries, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(block)));
    }
}
