package net.moddingplayground.twigs.world;

import com.mojang.serialization.Codec;
import net.minecraft.core.Holder;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraftforge.common.world.BiomeGenerationSettingsBuilder;
import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.common.world.ModifiableBiomeInfo;
import net.moddingplayground.twigs.init.TwigsBiomeModifiers;
import net.moddingplayground.twigs.init.TwigsBiomeTags;
import net.moddingplayground.twigs.init.TwigsPlacedFeatures;

public class TwigsBiomeModifier implements BiomeModifier {

    @Override
    public void modify(Holder<Biome> biome, Phase phase, ModifiableBiomeInfo.BiomeInfo.Builder builder) {
        BiomeGenerationSettingsBuilder biomeGenerationSettingsBuilder = builder.getGenerationSettings();
        if (phase == Phase.ADD) {
            if (biome.is(BiomeTags.IS_OVERWORLD) && !biome.is(TwigsBiomeTags.DOES_NOT_SPAWN_RHYOLITE)) {
                biomeGenerationSettingsBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, TwigsPlacedFeatures.ORE_RHYOLITE_LOWER);
            }
            if (biome.is(TwigsBiomeTags.SPAWNS_BLOODSTONE)) {
                biomeGenerationSettingsBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, TwigsPlacedFeatures.ORE_BLOODSTONE_NETHER);
            }
            if (biome.is(TwigsBiomeTags.SPAWNS_SCHIST)) {
                biomeGenerationSettingsBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, TwigsPlacedFeatures.ORE_SCHIST_UPPER);
                biomeGenerationSettingsBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, TwigsPlacedFeatures.ORE_SCHIST_LOWER);
            }
            if (biome.is(TwigsBiomeTags.SPAWNS_TWIG)) {
                biomeGenerationSettingsBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, TwigsPlacedFeatures.PATCH_TWIG);
            }
            if (biome.is(TwigsBiomeTags.SPAWNS_PEBBLE)) {
                biomeGenerationSettingsBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, TwigsPlacedFeatures.PATCH_PEBBLE);
            }
            if (biome.is(TwigsBiomeTags.SPAWNS_SEA_SHELL)) {
                biomeGenerationSettingsBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, TwigsPlacedFeatures.PATCH_SEA_SHELL);
            }
        }
    }

    @Override
    public Codec<? extends BiomeModifier> codec() {
        return TwigsBiomeModifiers.TWIGS_BIOME_MODIFIER.get();
    }

}
