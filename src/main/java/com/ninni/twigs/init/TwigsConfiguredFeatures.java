//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.ninni.twigs.init;

import com.ninni.twigs.Twigs;
import net.minecraft.core.Registry;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.resources.ResourceLocation;
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

    public static final ConfiguredFeature<RandomPatchConfiguration, ?> PATCH_TWIG = registerConfiguredFeature("patch_twig", Feature.RANDOM_PATCH.configured(createRandomPatchConfiguration(BlockStateProvider.simple(TwigsBlocks.TWIG.get().defaultBlockState().getBlock()), 3)));
    public static final ConfiguredFeature<RandomPatchConfiguration, ?> PATCH_PEBBLE = registerConfiguredFeature("patch_pebble", Feature.RANDOM_PATCH.configured(createRandomPatchConfiguration(BlockStateProvider.simple(TwigsBlocks.PEBBLE.get().defaultBlockState().getBlock()), 2)));
    public static final ConfiguredFeature<?, ?> ORE_RHYOLITE = registerConfiguredFeature("ore_rhyolite", Feature.ORE.configured(new OreConfiguration(new TagMatchTest(BlockTags.BASE_STONE_OVERWORLD), TwigsBlocks.RHYOLITE.get().defaultBlockState(), 45)));
    public static final ConfiguredFeature<?, ?> ORE_SCHIST = registerConfiguredFeature("ore_schist", Feature.ORE.configured(new OreConfiguration(new TagMatchTest(BlockTags.BASE_STONE_OVERWORLD), TwigsBlocks.SCHIST.get().defaultBlockState(), 64)));
    public static final ConfiguredFeature<?, ?> ORE_BLOODSTONE = registerConfiguredFeature("ore_bloodstone", Feature.ORE.configured(new OreConfiguration(new TagMatchTest(BlockTags.BASE_STONE_NETHER), TwigsBlocks.BLOODSTONE.get().defaultBlockState(), 64)));

    private static RandomPatchConfiguration createRandomPatchConfiguration(BlockStateProvider block, int tries) {
        return FeatureUtils.simpleRandomPatchConfiguration(tries, Feature.SIMPLE_BLOCK.configured(new SimpleBlockConfiguration(block)).onlyWhenEmpty());
    }

    public static <C extends FeatureConfiguration, F extends Feature<C>, CF extends ConfiguredFeature<C, F>> CF registerConfiguredFeature(String name, CF configuredFeature) {
        ResourceLocation ID = new ResourceLocation(Twigs.MOD_ID, name);
        if (BuiltinRegistries.CONFIGURED_FEATURE.keySet().contains(ID))
            throw new IllegalStateException("The Configured Feature " + name + "already exists in the registry");

        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, ID, configuredFeature);
        return configuredFeature;
    }
}
