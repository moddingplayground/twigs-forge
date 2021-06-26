package com.ninni.twigs;

import com.ninni.twigs.init.TwigsBlocks;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;

public class TwigsClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
    BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getTranslucent(),
                TwigsBlocks.PAPER_LANTERN,
                TwigsBlocks.ALLIUM_PAPER_LANTERN,
                TwigsBlocks.BLUE_ORCHID_PAPER_LANTERN,
                TwigsBlocks.DANDELION_PAPER_LANTERN,
                TwigsBlocks.CRIMSON_ROOTS_PAPER_LANTERN,
                TwigsBlocks.AZALEA_DOOR,
                TwigsBlocks.AZALEA_TRAPDOOR
        );
    }
}
