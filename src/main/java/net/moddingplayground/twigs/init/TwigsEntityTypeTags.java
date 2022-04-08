package net.moddingplayground.twigs.init;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EntityType;
import net.moddingplayground.twigs.Twigs;

public class TwigsEntityTypeTags {

    public static final TagKey<EntityType<?>> BAMBOO_LEAVES_SLOW_IMMUNE = register("bamboo_leaves_slow_immune");

    private static TagKey<EntityType<?>> register(String id) {
        return TagKey.create(Registry.ENTITY_TYPE_REGISTRY, new ResourceLocation(Twigs.MOD_ID, id));
    }

}
