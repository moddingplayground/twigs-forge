package net.moddingplayground.twigs.init;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.moddingplayground.twigs.Twigs;

@Mod.EventBusSubscriber(modid = Twigs.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class TwigsSoundEvents {
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, Twigs.MOD_ID);

    public static final RegistryObject<SoundEvent> BLOCK_LAMP_LIGHT = lamp("light");
    public static final RegistryObject<SoundEvent> BLOCK_LAMP_EXTINGUISH = lamp("extinguish");

    public static final RegistryObject<SoundEvent> BLOCK_FLOWERING_AZALEA_SHEAR = block("flowering_azalea", "shear");

    public static final RegistryObject<SoundEvent> BLOCK_BAMBOO_STRIP_SHEAR = block("bamboo", "strip_shear");
    public static final RegistryObject<SoundEvent> ENTITY_PEBBLE_THROW = register("entity.pebble.throw");

    private static RegistryObject<SoundEvent> lamp(String id) {
        return block("lamp", id);
    }

    private static RegistryObject<SoundEvent> block(String block, String id) {
        return register("block.%s.%s".formatted(block, id));
    }

    private static RegistryObject<SoundEvent> register(String id) {
        return SOUND_EVENTS.register(id, () -> new SoundEvent(new ResourceLocation(Twigs.MOD_ID, id)));
    }
}
