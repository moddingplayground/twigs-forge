package com.ninni.twigs.client;

import com.ninni.twigs.Twigs;
import com.ninni.twigs.init.TwigsBlocks;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Twigs.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class TwigsRendererManager {

    public static void init() {
        ItemBlockRenderTypes.setRenderLayer(TwigsBlocks.AZALEA_FLOWERS.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(TwigsBlocks.PEBBLE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(TwigsBlocks.TWIG.get(), RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(TwigsBlocks.POTTED_AZALEA_FLOWERS.get(), RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(TwigsBlocks.OAK_TABLE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(TwigsBlocks.SPRUCE_TABLE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(TwigsBlocks.BIRCH_TABLE.get(), RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(TwigsBlocks.ACACIA_TABLE.get(), RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(TwigsBlocks.JUNGLE_TABLE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(TwigsBlocks.DARK_OAK_TABLE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(TwigsBlocks.CRIMSON_TABLE.get(), RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(TwigsBlocks.WARPED_TABLE.get(), RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(TwigsBlocks.STRIPPED_BAMBOO_TABLE.get(), RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(TwigsBlocks.PAPER_LANTERN.get(), RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(TwigsBlocks.ALLIUM_PAPER_LANTERN.get(), RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(TwigsBlocks.BLUE_ORCHID_PAPER_LANTERN.get(), RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(TwigsBlocks.DANDELION_PAPER_LANTERN.get(), RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(TwigsBlocks.CRIMSON_ROOTS_PAPER_LANTERN.get(), RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(TwigsBlocks.BAMBOO_LEAVES.get(), RenderType.cutoutMipped());
    }

}
