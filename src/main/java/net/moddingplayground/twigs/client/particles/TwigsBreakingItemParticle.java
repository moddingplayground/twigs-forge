package net.moddingplayground.twigs.client.particles;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.BreakingItemParticle;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleProvider;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.moddingplayground.twigs.init.TwigsItems;

@OnlyIn(Dist.CLIENT)
public class TwigsBreakingItemParticle extends BreakingItemParticle {

    public TwigsBreakingItemParticle(ClientLevel world, double x, double y, double z, ItemStack stack) {
        super(world, x, y, z, stack);
    }

    @OnlyIn(Dist.CLIENT)
    public static class PebbleProvider implements ParticleProvider<SimpleParticleType> {

        @Override
        public Particle createParticle(SimpleParticleType parameters, ClientLevel world, double x, double y, double z, double velocityX, double velocityY, double velocityZ) {
            return new TwigsBreakingItemParticle(world, x, y, z, new ItemStack(TwigsItems.PEBBLE.get()));
        }

    }
}
