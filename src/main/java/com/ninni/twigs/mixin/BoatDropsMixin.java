package com.ninni.twigs.mixin;

import com.ninni.twigs.entity.CustomBoatItem;
import net.minecraft.entity.vehicle.BoatEntity;
import net.minecraft.item.Item;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import static com.ninni.twigs.entity.CustomBoatType.STRIPPED_BAMBOO;

@Mixin(BoatEntity.class)
public class BoatDropsMixin {
    @Inject(method = "asItem", at = @At("HEAD"), cancellable = true)
    public void asItem(CallbackInfoReturnable<Item> cir) {
        if (((BoatEntity)(Object)this).getBoatType() == STRIPPED_BAMBOO) {
            cir.setReturnValue(CustomBoatItem.STRIPPED_BAMBOO_BOAT);
        }
    }
}
