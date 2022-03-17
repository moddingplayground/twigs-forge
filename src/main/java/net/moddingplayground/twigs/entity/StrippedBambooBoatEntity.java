package net.moddingplayground.twigs.entity;

import net.moddingplayground.twigs.init.TwigsBlocks;
import net.moddingplayground.twigs.init.TwigsEntityTypes;
import net.moddingplayground.twigs.init.TwigsItems;
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
        return TwigsItems.STRIPPED_BAMBOO_BOAT.get();
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

        public static BoatType byId(int id) {
            BoatType[] aboat$type = values();
            if (id < 0 || id >= aboat$type.length) {
                id = 0;
            }

            return aboat$type[id];
        }

        public static BoatType byName(String name) {
            BoatType[] types = values();
            for (BoatType type : types) {
                if (type.getName().equals(name)) return type;
            }
            return types[0];
        }
    }
}
