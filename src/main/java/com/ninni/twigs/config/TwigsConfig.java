package com.ninni.twigs.config;

import com.ninni.twigs.Twigs;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Twigs.MOD_ID)
public class TwigsConfig {

    public static final ForgeConfigSpec.Builder builder = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec COMMON;
    public static final ForgeConfigSpec.BooleanValue generateTwigs;
    public static final ForgeConfigSpec.BooleanValue generatePebbles;
    public static final ForgeConfigSpec.BooleanValue generateRhyolite;
    public static final ForgeConfigSpec.BooleanValue generateBloodstone;
    public static final ForgeConfigSpec.BooleanValue generateSchist;

    static {
        generateTwigs = builder.define("Generates Twigs", true);
        generatePebbles = builder.define("Generates Pebbles", true);
        generateRhyolite = builder.define("Generates Rhyolite", true);
        generateBloodstone = builder.define("Generates Bloodstone", true);
        generateSchist = builder.define("Generates Schist", true);

        COMMON = builder.build();
    }

}
