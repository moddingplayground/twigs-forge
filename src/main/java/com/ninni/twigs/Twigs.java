package com.ninni.twigs;

import com.ninni.twigs.client.TwigsRendererManager;
import com.ninni.twigs.events.MiscEvents;
import com.ninni.twigs.events.WorldEvents;
import com.ninni.twigs.init.TwigsBlockEntities;
import com.ninni.twigs.init.TwigsBlocks;
import com.ninni.twigs.init.TwigsEntityTypes;
import com.ninni.twigs.init.TwigsItems;
import com.ninni.twigs.init.TwigsVanillaIntegration;
import com.ninni.twigs.init.TwigsWoodType;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(Twigs.MOD_ID)
public class Twigs {
	public static final String MOD_ID = "twigs";
	public static final CreativeModeTab ITEM_GROUP = new CreativeModeTab("item_group") {
		@Override
		public ItemStack makeIcon() {
			return new ItemStack(TwigsBlocks.TWIG.get());
		}
	};

	public Twigs() {
		IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
		modEventBus.addListener(this::setup);
		modEventBus.addListener(this::clientSetup);

		TwigsBlocks.BLOCKS.register(modEventBus);
		TwigsItems.ITEMS.register(modEventBus);
		TwigsBlockEntities.BLOCK_ENTITIES.register(modEventBus);
		TwigsEntityTypes.ENTITY_TYPES.register(modEventBus);

		MinecraftForge.EVENT_BUS.register(new MiscEvents());
		MinecraftForge.EVENT_BUS.register(new WorldEvents());

		MinecraftForge.EVENT_BUS.register(this);
	}

	private void setup(final FMLCommonSetupEvent event) {
		TwigsVanillaIntegration.init();
	}

	private void clientSetup(final FMLClientSetupEvent event) {
		event.enqueueWork(TwigsWoodType::init);
		TwigsRendererManager.init();
	}

	public void onInitialize() {
		//im sorry I know its scuffed ill make the block registry more organized later

//		if (BuiltinRegistries.PLACED_FEATURE.getKey(PATCH_TWIG).isPresent()) {
//			BiomeModifications.addFeature(context -> (context.getBiomeKey().equals(BiomeKeys.FOREST) || context.getBiomeKey().equals(BiomeKeys.FLOWER_FOREST) || context.getBiomeKey().equals(BiomeKeys.DARK_FOREST) || context.getBiomeKey().equals(BiomeKeys.BIRCH_FOREST) || context.getBiomeKey().equals(BiomeKeys.OLD_GROWTH_BIRCH_FOREST) || context.getBiomeKey().equals(BiomeKeys.WINDSWEPT_FOREST) || context.getBiomeKey().equals(BiomeKeys.TAIGA)), GenerationStep.Feature.VEGETAL_DECORATION,
//					BuiltinRegistries.PLACED_FEATURE.getKey(PATCH_TWIG).get());
//		}
//		if (BuiltinRegistries.PLACED_FEATURE.getKey(PATCH_PEBBLE).isPresent()) {
//			BiomeModifications.addFeature(context -> (context.getBiomeKey().equals(BiomeKeys.SAVANNA) || context.getBiomeKey().equals(BiomeKeys.PLAINS) || context.getBiomeKey().equals(BiomeKeys.MEADOW) || context.getBiomeKey().equals(BiomeKeys.STONY_SHORE) || context.getBiomeKey().equals(BiomeKeys.TAIGA)), GenerationStep.Feature.VEGETAL_DECORATION,
//				BuiltinRegistries.PLACED_FEATURE.getKey(PATCH_PEBBLE).get());
//		}
	}
}
