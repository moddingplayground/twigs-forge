package com.ninni.twigs.events;

import com.ninni.twigs.Twigs;
import com.ninni.twigs.client.StrippedBambooBoatRenderer;
import com.ninni.twigs.entity.StrippedBambooBoatEntity;
import com.ninni.twigs.init.TwigsBlockEntities;
import com.ninni.twigs.init.TwigsEntityTypes;
import net.minecraft.client.model.BoatModel;
import net.minecraft.client.renderer.blockentity.SignRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Twigs.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientEvents {

    @SubscribeEvent
    public static void registerEntityRenderer(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(TwigsEntityTypes.STRIPPED_BAMBOO_BOAT.get(), StrippedBambooBoatRenderer::new);
        event.registerBlockEntityRenderer(TwigsBlockEntities.TWIGS_SIGN.get(), SignRenderer::new);
    }

    @SubscribeEvent
    public static void registerEntityModelLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(StrippedBambooBoatRenderer.createBoatLayerLocation(StrippedBambooBoatEntity.BoatType.STRIPPED_BAMBOO), BoatModel::createBodyModel);
    }

}
