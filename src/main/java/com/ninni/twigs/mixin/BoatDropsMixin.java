package com.ninni.twigs.mixin;

import com.ninni.twigs.entity.BoatItems;
import com.ninni.twigs.entity.CustomBoatType;
import net.minecraft.entity.vehicle.BoatEntity;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin(BoatEntity.class)
public class BoatDropsMixin {
    /**
     * @author dopadream
     */
    @Overwrite
    public Item asItem() {
        if (((BoatEntity)(Object)this).getBoatType() == CustomBoatType.STRIPPED_BAMBOO) {
            return BoatItems.STRIPPED_BAMBOO_BOAT;
        }

        switch (((BoatEntity)(Object)this).getBoatType()) {
            case OAK:
            default:
                return Items.OAK_BOAT;
            case SPRUCE:
                return Items.SPRUCE_BOAT;
            case BIRCH:
                return Items.BIRCH_BOAT;
            case JUNGLE:
                return Items.JUNGLE_BOAT;
            case ACACIA:
                return Items.ACACIA_BOAT;
            case DARK_OAK:
                return Items.DARK_OAK_BOAT;
        }
    }
}
