package net.moddingplayground.twigs.data;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BiomeTagsProvider;
import net.minecraft.world.level.biome.Biomes;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.moddingplayground.twigs.Twigs;
import net.moddingplayground.twigs.init.TwigsBiomeTags;
import org.jetbrains.annotations.Nullable;

public class TwigsBiomeTagsProvider extends BiomeTagsProvider {

    public TwigsBiomeTagsProvider(DataGenerator p_211094_, @Nullable ExistingFileHelper existingFileHelper) {
        super(p_211094_, Twigs.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags() {
        this.tag(TwigsBiomeTags.SPAWNS_BLOODSTONE).add(Biomes.NETHER_WASTES, Biomes.WARPED_FOREST, Biomes.CRIMSON_FOREST, Biomes.SOUL_SAND_VALLEY, Biomes.BASALT_DELTAS);
        this.tag(TwigsBiomeTags.SPAWNS_PEBBLE).add(Biomes.PLAINS, Biomes.SUNFLOWER_PLAINS, Biomes.MEADOW, Biomes.RIVER, Biomes.MUSHROOM_FIELDS, Biomes.STONY_SHORE, Biomes.TAIGA, Biomes.OLD_GROWTH_PINE_TAIGA, Biomes.OLD_GROWTH_SPRUCE_TAIGA, Biomes.WINDSWEPT_FOREST, Biomes.WINDSWEPT_HILLS, Biomes.WINDSWEPT_GRAVELLY_HILLS, Biomes.WINDSWEPT_SAVANNA, Biomes.SAVANNA, Biomes.SAVANNA_PLATEAU, Biomes.SWAMP, Biomes.MANGROVE_SWAMP);
        this.tag(TwigsBiomeTags.SPAWNS_RHYOLITE).add(Biomes.PLAINS, Biomes.SUNFLOWER_PLAINS, Biomes.SNOWY_PLAINS, Biomes.ICE_SPIKES, Biomes.DESERT, Biomes.SWAMP, Biomes.MANGROVE_SWAMP, Biomes.FOREST, Biomes.FLOWER_FOREST, Biomes.BIRCH_FOREST, Biomes.DARK_FOREST, Biomes.OLD_GROWTH_BIRCH_FOREST, Biomes.OLD_GROWTH_PINE_TAIGA, Biomes.OLD_GROWTH_SPRUCE_TAIGA, Biomes.TAIGA, Biomes.SNOWY_TAIGA, Biomes.SAVANNA, Biomes.SAVANNA_PLATEAU, Biomes.WINDSWEPT_HILLS, Biomes.WINDSWEPT_GRAVELLY_HILLS, Biomes.WINDSWEPT_FOREST, Biomes.WINDSWEPT_SAVANNA, Biomes.JUNGLE, Biomes.SPARSE_JUNGLE, Biomes.BAMBOO_JUNGLE, Biomes.BADLANDS, Biomes.ERODED_BADLANDS, Biomes.WOODED_BADLANDS, Biomes.MEADOW, Biomes.GROVE, Biomes.SNOWY_SLOPES, Biomes.FROZEN_PEAKS, Biomes.JAGGED_PEAKS, Biomes.STONY_PEAKS, Biomes.RIVER, Biomes.FROZEN_RIVER, Biomes.BEACH, Biomes.SNOWY_BEACH, Biomes.STONY_SHORE, Biomes.WARM_OCEAN, Biomes.LUKEWARM_OCEAN, Biomes.DEEP_LUKEWARM_OCEAN, Biomes.OCEAN, Biomes.DEEP_OCEAN, Biomes.COLD_OCEAN, Biomes.DEEP_COLD_OCEAN, Biomes.FROZEN_OCEAN, Biomes.DEEP_FROZEN_OCEAN, Biomes.MUSHROOM_FIELDS, Biomes.DRIPSTONE_CAVES, Biomes.LUSH_CAVES, Biomes.DEEP_DARK);
        this.tag(TwigsBiomeTags.SPAWNS_SCHIST).add(Biomes.MEADOW, Biomes.SNOWY_SLOPES, Biomes.FROZEN_PEAKS, Biomes.JAGGED_PEAKS, Biomes.STONY_PEAKS);
        this.tag(TwigsBiomeTags.SPAWNS_TWIG).add(Biomes.FOREST, Biomes.FLOWER_FOREST, Biomes.DARK_FOREST, Biomes.BIRCH_FOREST, Biomes.OLD_GROWTH_BIRCH_FOREST, Biomes.TAIGA, Biomes.OLD_GROWTH_PINE_TAIGA, Biomes.OLD_GROWTH_SPRUCE_TAIGA, Biomes.SWAMP, Biomes.MANGROVE_SWAMP);
    }
}
