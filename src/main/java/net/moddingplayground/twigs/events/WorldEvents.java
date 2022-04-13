package net.moddingplayground.twigs.events;

import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraftforge.common.world.BiomeGenerationSettingsBuilder;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;
import net.moddingplayground.twigs.Twigs;
import net.moddingplayground.twigs.config.TwigsConfig;
import net.moddingplayground.twigs.init.TwigsPlacedFeatures;

@Mod.EventBusSubscriber(modid = Twigs.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class WorldEvents {

    @SubscribeEvent
    public void onBiomeLoad(BiomeLoadingEvent event) {
        ResourceLocation name = event.getName();
        Biome.BiomeCategory category = event.getCategory();
        BiomeGenerationSettingsBuilder builder = event.getGeneration();
        boolean overworld = !(category == Biome.BiomeCategory.NETHER || category == Biome.BiomeCategory.THEEND || category == Biome.BiomeCategory.NONE);
        boolean nether = category == Biome.BiomeCategory.NETHER;
        if (event.getName() != null) {
            ResourceKey<Biome> key = ResourceKey.create(ForgeRegistries.Keys.BIOMES, event.getName());
            boolean mountain = Biomes.MEADOW == key || Biomes.WINDSWEPT_HILLS == key || Biomes.FROZEN_PEAKS == key || Biomes.JAGGED_PEAKS == key || Biomes.GROVE == key || Biomes.STONY_PEAKS == key || Biomes.SNOWY_SLOPES == key || Biomes.WINDSWEPT_FOREST == key || Biomes.WINDSWEPT_GRAVELLY_HILLS == key;
            boolean twigsSpawnables = Biomes.FOREST == key || Biomes.FLOWER_FOREST == key || Biomes.DARK_FOREST == key || Biomes.BIRCH_FOREST == key || Biomes.OLD_GROWTH_BIRCH_FOREST == key || Biomes.WINDSWEPT_FOREST == key || Biomes.TAIGA == key;
            boolean pebblesSpawnables = Biomes.SAVANNA == key || Biomes.PLAINS == key || Biomes.MEADOW == key || Biomes.STONY_SHORE == key || Biomes.TAIGA == key;
            boolean seaShellsSpawnables = Biomes.BEACH == key || Biomes.SNOWY_BEACH == key || Biomes.STONY_SHORE == key;
            if (TwigsConfig.generateRhyolite.get() && overworld) {
                builder.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, TwigsPlacedFeatures.ORE_RHYOLITE_LOWER);
            }
            if (TwigsConfig.generateBloodstone.get() && nether) {
                builder.addFeature(GenerationStep.Decoration.TOP_LAYER_MODIFICATION, TwigsPlacedFeatures.ORE_BLOODSTONE_NETHER);
            }
            if (TwigsConfig.generateSchist.get() && mountain) {
                builder.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, TwigsPlacedFeatures.ORE_SCHIST_UPPER);
                builder.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, TwigsPlacedFeatures.ORE_SCHIST_LOWER);
            }
            if (TwigsConfig.generateTwigs.get() && twigsSpawnables) {
                builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, TwigsPlacedFeatures.PATCH_TWIG);
            }
            if (TwigsConfig.generatePebbles.get() && pebblesSpawnables) {
                builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, TwigsPlacedFeatures.PATCH_PEBBLE);
            }
            if (TwigsConfig.generateSeaShells.get() && seaShellsSpawnables) {
                builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, TwigsPlacedFeatures.PATCH_SEA_SHELL);
            }
        }
    }

}
