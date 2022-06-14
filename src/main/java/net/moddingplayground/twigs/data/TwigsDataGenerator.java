package net.moddingplayground.twigs.data;

import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.forge.event.lifecycle.GatherDataEvent;
import net.moddingplayground.twigs.Twigs;

@Mod.EventBusSubscriber(modid = Twigs.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class TwigsDataGenerator {

    @SubscribeEvent
    public static void onGatherData(GatherDataEvent event) {
        DataGenerator dataGenerator = event.getGenerator();
        ExistingFileHelper helper = event.getExistingFileHelper();
        dataGenerator.addProvider(event.includeServer(), new TwigsItemTagsProvider(dataGenerator, helper));
        dataGenerator.addProvider(event.includeServer(), new TwigsBlockTagsProvider(dataGenerator, helper));
        dataGenerator.addProvider(event.includeServer(), new TwigsEntityTypeTagsProvider(dataGenerator, helper));
        dataGenerator.addProvider(event.includeServer(), new TwigsBiomeTagsProvider(dataGenerator, helper));
    }

}
