package net.moddingplayground.twigs.init;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.moddingplayground.twigs.Twigs;
import net.moddingplayground.twigs.entity.PebbleEntity;
import net.moddingplayground.twigs.entity.StrippedBambooBoatEntity;
import net.moddingplayground.twigs.entity.StrippedBambooChestBoatEntity;

@Mod.EventBusSubscriber(modid = Twigs.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class TwigsEntityTypes {

    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, Twigs.MOD_ID);

    public static final RegistryObject<EntityType<StrippedBambooBoatEntity>> STRIPPED_BAMBOO_BOAT = ENTITY_TYPES.register("stripped_bamboo_boat", () -> EntityType.Builder.<StrippedBambooBoatEntity>of(StrippedBambooBoatEntity::new, MobCategory.MISC).sized(1.375F, 0.5625F).clientTrackingRange(10).build(new ResourceLocation(Twigs.MOD_ID, "stripped_bamboo_boat").toString()));
    public static final RegistryObject<EntityType<StrippedBambooChestBoatEntity>> STRIPPED_BAMBOO_CHEST_BOAT = ENTITY_TYPES.register("stripped_bamboo_chest_boat", () -> EntityType.Builder.<StrippedBambooChestBoatEntity>of(StrippedBambooChestBoatEntity::new, MobCategory.MISC).sized(1.375F, 0.5625F).clientTrackingRange(10).build(new ResourceLocation(Twigs.MOD_ID, "stripped_bamboo_chest_boat").toString()));
    public static final RegistryObject<EntityType<PebbleEntity>> PEBBLE = ENTITY_TYPES.register("pebble", () -> EntityType.Builder.<PebbleEntity>of(PebbleEntity::new, MobCategory.MISC).sized(0.25F, 0.25F).clientTrackingRange(4).updateInterval(10).build(new ResourceLocation(Twigs.MOD_ID, "pebble").toString()));

}
