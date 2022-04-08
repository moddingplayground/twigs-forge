package net.moddingplayground.twigs.init;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import net.moddingplayground.twigs.Twigs;

public class TwigsBlockTags {

    public static final TagKey<Block> TABLES = register("tables");
    public static final TagKey<Block> PAPER_LANTERN = register("paper_lanterns");

    private static TagKey<Block> register(String name) {
        return TagKey.create(Registry.BLOCK_REGISTRY, new ResourceLocation(Twigs.MOD_ID, name));
    }

}
