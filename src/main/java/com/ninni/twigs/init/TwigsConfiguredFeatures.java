package com.ninni.twigs.init;

import com.ninni.twigs.Twigs;
import net.minecraft.block.BlockState;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.feature.*;

public class TwigsConfiguredFeatures {
    public static final ConfiguredFeature<?, ?> ORE_SCHIST = register("ore_schist", Feature.ORE.configure(new OreFeatureConfig(OreFeatureConfig.Rules.BASE_STONE_OVERWORLD, States.SCHIST, 50)).uniformRange(YOffset.fixed(0), YOffset.fixed(79)).spreadHorizontally().repeat(20));
    public static final ConfiguredFeature<?, ?> ORE_BLOODSTONE = register("ore_bloodstone", Feature.ORE.configure(new OreFeatureConfig(OreFeatureConfig.Rules.NETHERRACK, States.BLOODSTONE, 33)).uniformRange(YOffset.fixed(0), YOffset.fixed(79)).spreadHorizontally().repeat(5));

    private static <FC extends FeatureConfig> ConfiguredFeature<FC, ?> register(String id, ConfiguredFeature<FC, ?> configuredFeature) {
        return Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new Identifier(Twigs.MOD_ID, id), configuredFeature);
    }

    private static class States {
        public static final BlockState SCHIST = TwigsBlocks.SCHIST.getDefaultState();
        public static final BlockState BLOODSTONE = TwigsBlocks.BLOODSTONE.getDefaultState();
    }
}
