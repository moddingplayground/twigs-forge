package net.moddingplayground.twigs.init;

import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.moddingplayground.twigs.Twigs;

@Mod.EventBusSubscriber(modid = Twigs.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class TwigsParticleTypes {

    public static final DeferredRegister<ParticleType<?>> PARTICLE_TYPES = DeferredRegister.create(ForgeRegistries.PARTICLE_TYPES, Twigs.MOD_ID);

    public static final RegistryObject<SimpleParticleType> ITEM_PEBBLE = PARTICLE_TYPES.register("item_pebble", () -> new SimpleParticleType(false));

}
