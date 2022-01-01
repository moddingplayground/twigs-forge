package com.ninni.twigs.init;

import com.ninni.twigs.Twigs;
import com.ninni.twigs.entity.StrippedBambooBoatEntity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

@Mod.EventBusSubscriber(modid = Twigs.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class TwigsEntityTypes {

    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITIES, Twigs.MOD_ID);

    public static final RegistryObject<EntityType<StrippedBambooBoatEntity>> STRIPPED_BAMBOO_BOAT = ENTITY_TYPES.register("stripped_bamboo_boat", () -> EntityType.Builder.<StrippedBambooBoatEntity>of(StrippedBambooBoatEntity::new, MobCategory.MISC).sized(1.375F, 0.5625F).clientTrackingRange(10).build(new ResourceLocation(Twigs.MOD_ID, "stripped_bamboo_boat").toString()));

}
