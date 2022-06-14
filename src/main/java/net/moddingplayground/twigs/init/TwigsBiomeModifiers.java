package net.moddingplayground.twigs.init;

import com.mojang.serialization.Codec;
import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.moddingplayground.twigs.Twigs;
import net.moddingplayground.twigs.world.TwigsBiomeModifier;

@Mod.EventBusSubscriber(modid = Twigs.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class TwigsBiomeModifiers {

    public static final DeferredRegister<Codec<? extends BiomeModifier>> BIOME_MODIFIERS = DeferredRegister.create(ForgeRegistries.Keys.BIOME_MODIFIER_SERIALIZERS, Twigs.MOD_ID);

    public static final RegistryObject<Codec<? extends BiomeModifier>> TWIGS_BIOME_MODIFIER = BIOME_MODIFIERS.register("twigs_biome_modifier", () -> Codec.unit(TwigsBiomeModifier::new));

}
