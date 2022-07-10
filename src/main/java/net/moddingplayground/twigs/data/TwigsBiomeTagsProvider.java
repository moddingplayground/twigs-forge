package net.moddingplayground.twigs.data;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BiomeTagsProvider;
import net.minecraft.tags.BiomeTags;
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
        this.tag(TwigsBiomeTags.SPAWNS_BLOODSTONE).addTag(BiomeTags.IS_NETHER);
        this.tag(TwigsBiomeTags.SPAWNS_PEBBLE).addTags(BiomeTags.IS_RIVER, BiomeTags.IS_SAVANNA, BiomeTags.IS_TAIGA, BiomeTags.IS_BEACH).add(Biomes.PLAINS, Biomes.SUNFLOWER_PLAINS, Biomes.MEADOW, Biomes.MUSHROOM_FIELDS, Biomes.WINDSWEPT_FOREST, Biomes.WINDSWEPT_HILLS, Biomes.WINDSWEPT_GRAVELLY_HILLS, Biomes.STONY_SHORE, Biomes.SWAMP);
        this.tag(TwigsBiomeTags.DOES_NOT_SPAWN_RHYOLITE);
        this.tag(TwigsBiomeTags.SPAWNS_SCHIST).addTag(BiomeTags.IS_MOUNTAIN);
        this.tag(TwigsBiomeTags.SPAWNS_TWIG).add(Biomes.FOREST, Biomes.FLOWER_FOREST, Biomes.DARK_FOREST, Biomes.BIRCH_FOREST, Biomes.OLD_GROWTH_BIRCH_FOREST, Biomes.TAIGA, Biomes.OLD_GROWTH_PINE_TAIGA, Biomes.OLD_GROWTH_SPRUCE_TAIGA, Biomes.SWAMP, Biomes.MANGROVE_SWAMP);
        this.tag(TwigsBiomeTags.SPAWNS_SEA_SHELL).addTag(BiomeTags.IS_BEACH).add(Biomes.STONY_SHORE);
    }
}
