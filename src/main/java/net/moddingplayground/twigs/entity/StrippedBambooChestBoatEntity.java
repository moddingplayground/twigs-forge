package net.moddingplayground.twigs.entity;

import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.Containers;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.HasCustomInventoryScreen;
import net.minecraft.world.entity.SlotAccess;
import net.minecraft.world.entity.monster.piglin.PiglinAi;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.entity.vehicle.ContainerEntity;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ChestMenu;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.GameEvent;
import net.moddingplayground.twigs.init.TwigsEntityTypes;
import net.moddingplayground.twigs.init.TwigsItems;

import javax.annotation.Nullable;

public class StrippedBambooChestBoatEntity extends StrippedBambooBoatEntity implements HasCustomInventoryScreen, ContainerEntity {
    private NonNullList<ItemStack> itemStacks = NonNullList.withSize(27, ItemStack.EMPTY);
    @Nullable
    private ResourceLocation lootTable;
    private long lootTableSeed;

    public StrippedBambooChestBoatEntity(EntityType<? extends Boat> type, Level world) {
        super(type, world);
    }

    public StrippedBambooChestBoatEntity(Level world, double x, double y, double z) {
        this(TwigsEntityTypes.STRIPPED_BAMBOO_CHEST_BOAT.get(), world);
        this.setPos(x, y, z);
        this.xo = x;
        this.yo = y;
        this.zo = z;
    }

    @Override
    protected float getSinglePassengerXOffset() {
        return 0.15F;
    }

    @Override
    protected int getMaxPassengers() {
        return 1;
    }

    @Override
    protected void addAdditionalSaveData(CompoundTag tag) {
        super.addAdditionalSaveData(tag);
        this.addChestVehicleSaveData(tag);
    }

    @Override
    protected void readAdditionalSaveData(CompoundTag tag) {
        super.readAdditionalSaveData(tag);
        this.readChestVehicleSaveData(tag);
    }

    @Override
    public void destroy(DamageSource source) {
        super.destroy(source);
        this.chestVehicleDestroyed(source, this.level, this);
    }

    @Override
    public Item getDropItem() {
        return TwigsItems.STRIPPED_BAMBOO_CHEST_BOAT.get();
    }

    @Override
    public void remove(Entity.RemovalReason reason) {
        if (!this.level.isClientSide && reason.shouldDestroy()) {
            Containers.dropContents(this.level, this, this);
        }

        super.remove(reason);
    }

    @Override
    public InteractionResult interact(Player player, InteractionHand hand) {
        return this.canAddPassenger(player) && !player.isSecondaryUseActive() ? super.interact(player, hand) : this.interactWithChestVehicle(this::gameEvent, player);
    }

    @Override
    public void openCustomInventoryScreen(Player player) {
        player.openMenu(this);
        if (!player.level.isClientSide) {
            this.gameEvent(GameEvent.CONTAINER_OPEN, player);
            PiglinAi.angerNearbyPiglins(player, true);
        }

    }

    public void clearContent() {
        this.clearChestVehicleContent();
    }

    public int getContainerSize() {
        return 27;
    }

    public ItemStack getItem(int index) {
        return this.getChestVehicleItem(index);
    }

    public ItemStack removeItem(int index, int count) {
        return this.removeChestVehicleItem(index, count);
    }

    public ItemStack removeItemNoUpdate(int index) {
        return this.removeChestVehicleItemNoUpdate(index);
    }

    public void setItem(int index, ItemStack p_219886_) {
        this.setChestVehicleItem(index, p_219886_);
    }

    @Override
    public SlotAccess getSlot(int slot) {
        return this.getChestVehicleSlot(slot);
    }

    @Override
    public void setChanged() {
    }

    @Override
    public boolean stillValid(Player player) {
        return this.isChestVehicleStillValid(player);
    }

    @Override
    @Nullable
    public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
        if (this.lootTable != null && player.isSpectator()) {
            return null;
        } else {
            this.unpackLootTable(inventory.player);
            return ChestMenu.threeRows(id, inventory, this);
        }
    }

    public void unpackLootTable(@Nullable Player player) {
        this.unpackChestVehicleLootTable(player);
    }

    @Nullable
    public ResourceLocation getLootTable() {
        return this.lootTable;
    }

    @Override
    public void setLootTable(@Nullable ResourceLocation location) {
        this.lootTable = location;
    }

    @Override
    public long getLootTableSeed() {
        return this.lootTableSeed;
    }

    @Override
    public void setLootTableSeed(long seed) {
        this.lootTableSeed = seed;
    }

    @Override
    public NonNullList<ItemStack> getItemStacks() {
        return this.itemStacks;
    }

    @Override
    public void clearItemStacks() {
        this.itemStacks = NonNullList.withSize(this.getContainerSize(), ItemStack.EMPTY);
    }
}
