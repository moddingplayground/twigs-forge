package net.moddingplayground.twigs.world;

import com.mojang.serialization.Codec;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderSet;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraftforge.common.world.BiomeGenerationSettingsBuilder;
import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.common.world.ModifiableBiomeInfo;
import net.moddingplayground.twigs.init.TwigsBiomeModifiers;

public record AddFeaturesWithConditionBiomeModifier(HolderSet<Biome> omit, HolderSet<Biome> biomes, HolderSet<PlacedFeature> features, GenerationStep.Decoration step) implements BiomeModifier {

    @Override
    public void modify(Holder<Biome> biome, Phase phase, ModifiableBiomeInfo.BiomeInfo.Builder builder) {
        if (phase == Phase.ADD && this.biomes.contains(biome)) {
            if (this.omit.contains(biome)) {
                return;
            }
            BiomeGenerationSettingsBuilder generationSettings = builder.getGenerationSettings();
            this.features.forEach(holder -> generationSettings.addFeature(this.step, holder));
        }
    }

    @Override
    public Codec<? extends BiomeModifier> codec() {
        return TwigsBiomeModifiers.ADD_FEATURES_WITH_CONDITION_BIOME_MODIFIER.get();
    }

}
