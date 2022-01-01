package com.ninni.twigs.entity;

import com.ninni.twigs.init.TwigsBlocks;
import com.ninni.twigs.init.TwigsEntityTypes;
import com.ninni.twigs.init.TwigsItems;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.network.NetworkHooks;

public class StrippedBambooBoatEntity extends Boat {

    private static final EntityDataAccessor<Integer> BOAT_TYPE = SynchedEntityData.defineId(StrippedBambooBoatEntity.class, EntityDataSerializers.INT);

    public StrippedBambooBoatEntity(EntityType<? extends Boat> type, Level p_38291_) {
        super(type, p_38291_);
        this.blocksBuilding = true;
    }

    public StrippedBambooBoatEntity(Level world, double x, double y, double z) {
        this(TwigsEntityTypes.STRIPPED_BAMBOO_BOAT.get(), world);
        this.setPos(x, y, z);
        this.setDeltaMovement(Vec3.ZERO);
        this.xo = x;
        this.yo = y;
        this.zo = z;
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(BOAT_TYPE, BoatType.STRIPPED_BAMBOO.ordinal());
    }

    @Override
    public Item getDropItem() {
        switch (this.getBoatTypeDropItem()) {
            case STRIPPED_BAMBOO:
            default:
                return TwigsItems.STRIPPED_BAMBOO_BOAT.get();
        }
    }

    public void setBoatType(BoatType type) {
        this.entityData.set(BOAT_TYPE, type.ordinal());
    }

    @Override
    protected void addAdditionalSaveData(CompoundTag tag) {
        super.addAdditionalSaveData(tag);
        tag.putString("Type", this.getBoatTypeDropItem().getName());
    }

    @Override
    protected void readAdditionalSaveData(CompoundTag tag) {
        super.readAdditionalSaveData(tag);
        if (tag.contains("Type", 8)) {
            this.setBoatType(BoatType.byName(tag.getString("Type")));
        }
    }

    public BoatType getBoatTypeDropItem() {
        return BoatType.byId(this.entityData.get(BOAT_TYPE));
    }

    @Override
    public Packet<?> getAddEntityPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }

    public enum BoatType {
        STRIPPED_BAMBOO(TwigsBlocks.STRIPPED_BAMBOO_PLANKS.get(), "stripped_bamboo");
;
        private final String name;
        private final Block planks;

        BoatType(Block block, String name) {
            this.name = name;
            this.planks = block;
        }

        public String getName() {
            return this.name;
        }

        public Block getPlanks() {
            return this.planks;
        }

        public String toString() {
            return this.name;
        }

        public static BoatType byId(int p_38431_) {
            BoatType[] aboat$type = values();
            if (p_38431_ < 0 || p_38431_ >= aboat$type.length) {
                p_38431_ = 0;
            }

            return aboat$type[p_38431_];
        }

        public static BoatType byName(String p_38433_) {
            BoatType[] aboat$type = values();

            for(int i = 0; i < aboat$type.length; ++i) {
                if (aboat$type[i].getName().equals(p_38433_)) {
                    return aboat$type[i];
                }
            }

            return aboat$type[0];
        }
    }
}

