package net.moddingplayground.twigs.init;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraftforge.common.util.ForgeSoundType;
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

    public static final ForgeSoundType PETRIFIED_LICHEN = new ForgeSoundType(1.0F, 1.0f, () -> SoundEvents.DEEPSLATE_BRICKS_BREAK, () -> SoundEvents.DEEPSLATE_BRICKS_STEP, () -> SoundEvents.DEEPSLATE_BRICKS_PLACE, () -> SoundEvents.DEEPSLATE_BRICKS_HIT, () -> SoundEvents.DEEPSLATE_BRICKS_FALL);
    public static final ForgeSoundType ENDER_MESH = new ForgeSoundType(1.0F, 1.0F, () -> SoundEvents.SCULK_VEIN_BREAK, () -> SoundEvents.STONE_STEP, () -> SoundEvents.SCULK_VEIN_PLACE, () -> SoundEvents.SCULK_VEIN_HIT, () -> SoundEvents.STONE_FALL);

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
