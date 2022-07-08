package net.moddingplayground.twigs.entity;

import net.minecraft.core.particles.ItemParticleOption;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.util.RandomSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import net.moddingplayground.twigs.init.TwigsBlocks;
import net.moddingplayground.twigs.init.TwigsEntityTypes;

public class PebbleEntity extends ThrowableItemProjectile {
    public PebbleEntity(EntityType<? extends PebbleEntity> type, Level world) {
        super(type, world);
    }

    public PebbleEntity(Level world, LivingEntity owner) {
        super(TwigsEntityTypes.PEBBLE.get(), owner, world);
    }

    public PebbleEntity(Level world, double x, double y, double z) {
        super(TwigsEntityTypes.PEBBLE.get(), x, y, z, world);
    }

    @Override
    protected Item getDefaultItem() {
        return TwigsBlocks.PEBBLE.get().asItem();
    }

    @Override
    protected void onHit(HitResult hit) {
        super.onHit(hit);

        if (!this.level.isClientSide()) {
            ItemStack stack = this.getItem();
            RandomSource random = this.level.random;
            ItemEntity itemEntity = new ItemEntity(this.level, this.getX(), this.getY(), this.getZ(), stack.isEmpty() ? new ItemStack(this.getDefaultItem()) : stack, random.nextDouble() * 0.2D - 0.1D, this.isUnderWater() ? 0.0D : 0.2D, random.nextDouble() * 0.2D - 0.1D
            );
            itemEntity.setDefaultPickUpDelay();
            this.level.addFreshEntity(itemEntity);

            this.level.broadcastEntityEvent(this, (byte) 3);
            this.discard();
        }
    }

    @Override
    protected void doWaterSplashEffect() {
        this.setDeltaMovement(this.getDeltaMovement().multiply(1.0D, -1 / 2.0D, 1.0D).scale(0.932D));
        super.doWaterSplashEffect();
    }

    @Override
    protected void onHitEntity(EntityHitResult hit) {
        super.onHitEntity(hit);
        Entity entity = hit.getEntity();
        entity.hurt(DamageSource.thrown(this, this.getOwner()), 1.0F);
    }

    @Override
    public void handleEntityEvent(byte status) {
        if (status == 3) {
            ParticleOptions particle = this.getParticle();
            for (int i = 0; i < 8; i++) this.level.addParticle(particle, this.getX(), this.getY(), this.getZ(), 0.0, 0.0, 0.0);
        }
    }

    private ParticleOptions getParticle() {
        ItemStack itemstack = this.getItemRaw();
        return itemstack.isEmpty() ? ParticleTypes.ITEM_SNOWBALL : new ItemParticleOption(ParticleTypes.ITEM, itemstack);
    }

}
