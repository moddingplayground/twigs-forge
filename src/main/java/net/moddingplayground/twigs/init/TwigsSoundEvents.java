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

    public static final ForgeSoundType TWIG = new ForgeSoundType(1.0F, 1.0F, () -> SoundEvents.WOOD_BREAK, () -> SoundEvents.WOOD_STEP, () -> SoundEvents.WOOD_PLACE, () -> SoundEvents.WOOD_HIT, () -> SoundEvents.WOOD_FALL);
    public static final ForgeSoundType PEBBLE = new ForgeSoundType(1.0F, 1.0F, () -> SoundEvents.STONE_BREAK, () -> SoundEvents.STONE_STEP, () -> SoundEvents.STONE_PLACE, () -> SoundEvents.STONE_HIT, () -> SoundEvents.STONE_FALL);
    public static final ForgeSoundType SEA_SHELL = new ForgeSoundType(1.0F, 1.0F, () -> SoundEvents.BONE_BLOCK_BREAK, () -> SoundEvents.BONE_BLOCK_STEP, () -> SoundEvents.BONE_BLOCK_PLACE, () -> SoundEvents.BONE_BLOCK_HIT, () -> SoundEvents.BONE_BLOCK_FALL);
    public static final ForgeSoundType PAPER_LANTERN = new ForgeSoundType(1.0F, 1.0F, () -> SoundEvents.BAMBOO_BREAK, () -> SoundEvents.BAMBOO_STEP, () -> SoundEvents.BAMBOO_PLACE, () -> SoundEvents.BAMBOO_HIT, () -> SoundEvents.BAMBOO_FALL);
    public static final ForgeSoundType BAMBOO_LEAVES = new ForgeSoundType(1.0F, 1.0F, () -> SoundEvents.AZALEA_LEAVES_BREAK, () -> SoundEvents.AZALEA_LEAVES_STEP, () -> SoundEvents.AZALEA_LEAVES_PLACE, () -> SoundEvents.AZALEA_LEAVES_HIT, () -> SoundEvents.AZALEA_LEAVES_FALL);
    public static final ForgeSoundType STRIPPED_BAMBOO = new ForgeSoundType(1.0F, 1.0F, () -> SoundEvents.SCAFFOLDING_BREAK, () -> SoundEvents.SCAFFOLDING_STEP, () -> SoundEvents.SCAFFOLDING_PLACE, () -> SoundEvents.SCAFFOLDING_HIT, () -> SoundEvents.SCAFFOLDING_FALL);
    public static final ForgeSoundType LAMP = new ForgeSoundType(1.0F, 1.0F, () -> SoundEvents.LANTERN_BREAK, () -> SoundEvents.LANTERN_STEP, () -> SoundEvents.LANTERN_PLACE, () -> SoundEvents.LANTERN_HIT, () -> SoundEvents.LANTERN_FALL);
    public static final ForgeSoundType ROCKY_DIRT = new ForgeSoundType(1.0F, 1.0F, () -> SoundEvents.TUFF_BREAK, () -> SoundEvents.TUFF_STEP, () -> SoundEvents.TUFF_PLACE, () -> SoundEvents.TUFF_HIT, () -> SoundEvents.TUFF_FALL);
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
