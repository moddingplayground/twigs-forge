package net.moddingplayground.twigs.init;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.moddingplayground.twigs.Twigs;

public class TwigsItemTags {

    public static final TagKey<Item> TABLES = register("tables");
    public static final TagKey<Item> PAPER_LANTERNS = register("paper_lanterns");

    private static TagKey<Item> register(String name) {
        return TagKey.create(Registry.ITEM_REGISTRY, new ResourceLocation(Twigs.MOD_ID, name));
    }

}
