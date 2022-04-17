package net.moddingplayground.twigs.init;

import net.minecraft.client.renderer.Sheets;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.moddingplayground.twigs.Twigs;

public class TwigsWoodType {

    public static final WoodType STRIPPED_BAMBOO = WoodType.register(new WoodType(Twigs.MOD_ID + ":stripped_bamboo"));

    @OnlyIn(Dist.CLIENT)
    public static void init() {
        Sheets.addWoodType(STRIPPED_BAMBOO);
    }

}
