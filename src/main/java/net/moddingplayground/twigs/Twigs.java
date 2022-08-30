package net.moddingplayground.twigs;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.crafting.CraftingHelper;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.moddingplayground.twigs.config.TwigsConfig;
import net.moddingplayground.twigs.crafting.conditions.QuarkCondition;
import net.moddingplayground.twigs.events.MiscEvents;
import net.moddingplayground.twigs.events.WorldEvents;
import net.moddingplayground.twigs.init.TwigsBlockEntities;
import net.moddingplayground.twigs.init.TwigsBlocks;
import net.moddingplayground.twigs.init.TwigsConfiguredFeatures;
import net.moddingplayground.twigs.init.TwigsEntityTypes;
import net.moddingplayground.twigs.init.TwigsItems;
import net.moddingplayground.twigs.init.TwigsPlacedFeatures;
import net.moddingplayground.twigs.init.TwigsVanillaIntegration;

@Mod(Twigs.MOD_ID)
public class Twigs {
    public static final String MOD_ID = "twigs";
    public static final CreativeModeTab ITEM_GROUP = new CreativeModeTab(new ResourceLocation(MOD_ID, "item_group").toString()) {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(TwigsBlocks.TWIG.get());
        }
    };

    public Twigs() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        modEventBus.addListener(this::setup);

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
        event.enqueueWork(() -> {
            TwigsVanillaIntegration.init();
            TwigsConfiguredFeatures.init();
            TwigsPlacedFeatures.init();
        });

        CraftingHelper.register(new QuarkCondition.Serializer());
    }

}
