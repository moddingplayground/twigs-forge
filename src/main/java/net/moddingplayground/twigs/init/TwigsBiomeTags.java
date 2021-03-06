package net.moddingplayground.twigs.init;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.biome.Biome;
import net.moddingplayground.twigs.Twigs;

public class TwigsBiomeTags {

    public static final TagKey<Biome> SPAWNS_TWIG = create("spawns_twig");
    public static final TagKey<Biome> SPAWNS_PEBBLE = create("spawns_pebble");
    public static final TagKey<Biome> SPAWNS_SEA_SHELL = create("spawns_sea_shell");
    public static final TagKey<Biome> DOES_NOT_SPAWN_RHYOLITE = create("does_not_spawn_rhyolite");
    public static final TagKey<Biome> SPAWNS_BLOODSTONE = create("spawns_bloodstone");
    public static final TagKey<Biome> SPAWNS_SCHIST = create("spawns_schist");

    private static TagKey<Biome> create(String id) {
        return TagKey.create(Registry.BIOME_REGISTRY, new ResourceLocation(Twigs.MOD_ID, id));
    }

}
