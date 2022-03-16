package com.ninni.twigs;

import com.ninni.twigs.client.TwigsRendererManager;
import com.ninni.twigs.config.TwigsConfig;
import com.ninni.twigs.events.MiscEvents;
import com.ninni.twigs.events.WorldEvents;
import com.ninni.twigs.init.TwigsBlockEntities;
import com.ninni.twigs.init.TwigsBlocks;
import com.ninni.twigs.init.TwigsConfiguredFeatures;
import com.ninni.twigs.init.TwigsEntityTypes;
import com.ninni.twigs.init.TwigsItems;
import com.ninni.twigs.init.TwigsPlacedFeatures;
import com.ninni.twigs.init.TwigsVanillaIntegration;
import com.ninni.twigs.init.TwigsWoodType;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
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

		ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, TwigsConfig.COMMON);
	}

	private void setup(final FMLCommonSetupEvent event) {
		TwigsVanillaIntegration.init();
		event.enqueueWork(() -> {
			TwigsConfiguredFeatures.init();
			TwigsPlacedFeatures.init();
		});
	}

	private void clientSetup(final FMLClientSetupEvent event) {
		event.enqueueWork(TwigsWoodType::init);
		TwigsRendererManager.init();
	}

}
