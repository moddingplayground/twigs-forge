package com.ninni.twigs.init;

import com.ninni.twigs.Twigs;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class TwigsWoodType {

    public static final WoodType STRIPPED_BAMBOO = WoodType.register(new WoodType(Twigs.MOD_ID + ":stripped_bamboo"));

    @OnlyIn(Dist.CLIENT)
    public static void init() {
        Sheets.addWoodType(STRIPPED_BAMBOO);
    }

}
