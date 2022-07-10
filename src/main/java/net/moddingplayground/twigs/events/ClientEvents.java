package net.moddingplayground.twigs.events;

import net.minecraft.client.model.BoatModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.SignRenderer;
import net.minecraft.client.renderer.entity.ThrownItemRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.client.event.RegisterParticleProvidersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.moddingplayground.twigs.Twigs;
import net.moddingplayground.twigs.client.particles.TwigsBreakingItemParticle;
import net.moddingplayground.twigs.client.renderers.StrippedBambooBoatRenderer;
import net.moddingplayground.twigs.init.TwigsBlockEntities;
import net.moddingplayground.twigs.init.TwigsBlocks;
import net.moddingplayground.twigs.init.TwigsEntityTypes;
import net.moddingplayground.twigs.init.TwigsParticleTypes;
import net.moddingplayground.twigs.init.TwigsWoodType;

@Mod.EventBusSubscriber(modid = Twigs.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientEvents {

    @SubscribeEvent
    public static void onClientSetup(final FMLClientSetupEvent event) {
        event.enqueueWork(TwigsWoodType::init);
        ItemBlockRenderTypes.setRenderLayer(TwigsBlocks.TWIG.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(TwigsBlocks.PEBBLE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(TwigsBlocks.SEA_SHELL.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(TwigsBlocks.AZALEA_FLOWERS.get(), RenderType.cutout());
    }

    @SubscribeEvent
    public static void registerEntityRenderer(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(TwigsEntityTypes.STRIPPED_BAMBOO_BOAT.get(), context -> new StrippedBambooBoatRenderer(context, false));
        event.registerEntityRenderer(TwigsEntityTypes.STRIPPED_BAMBOO_CHEST_BOAT.get(), context -> new StrippedBambooBoatRenderer(context, true));
        event.registerEntityRenderer(TwigsEntityTypes.PEBBLE.get(), ThrownItemRenderer::new);
        event.registerBlockEntityRenderer(TwigsBlockEntities.TWIGS_SIGN.get(), SignRenderer::new);
    }

    @SubscribeEvent
    public static void registerEntityModelLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(new ModelLayerLocation(new ResourceLocation(Twigs.MOD_ID, "boat/stripped_bamboo"), "main"), () -> BoatModel.createBodyModel(false));
        event.registerLayerDefinition(new ModelLayerLocation(new ResourceLocation(Twigs.MOD_ID, "chest_boat/stripped_bamboo"), "main"), () -> BoatModel.createBodyModel(true));
    }

    @SubscribeEvent
    public static void registerParticleFactories(RegisterParticleProvidersEvent event) {
        event.register(TwigsParticleTypes.ITEM_PEBBLE.get(), new TwigsBreakingItemParticle.PebbleProvider());
    }
}
