package com.ninni.twigs.mixin;

import com.ninni.twigs.Twigs;
import com.ninni.twigs.entity.BoatItems;
import com.ninni.twigs.entity.CustomBoatType;
import com.ninni.twigs.init.TwigsBlocks;
import net.minecraft.block.Block;
import net.minecraft.entity.vehicle.BoatEntity;
import org.objectweb.asm.Opcodes;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.gen.Invoker;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.ArrayList;
import java.util.Arrays;

@Mixin(BoatEntity.Type.class)
public class BoatTypeMixin {
    @SuppressWarnings("InvokerTarget")
    @Invoker("<init>")
    private static BoatEntity.Type newType(String internalName, int internalId, Block baseBlock, String name) {
        throw new AssertionError();
    }

    @SuppressWarnings("ShadowTarget")
    @Shadow
    @Final
    @Mutable
    private static BoatEntity.Type[] field_7724;

    @SuppressWarnings("UnresolvedMixinReference")
    @Inject(method = "<clinit>", at = @At(value = "FIELD",

            opcode = Opcodes.PUTSTATIC,
            target = "Lnet/minecraft/entity/vehicle/BoatEntity$Type;field_7724:[Lnet/minecraft/entity/vehicle/BoatEntity$Type;",
            shift = At.Shift.AFTER))
    private static void addCustomBoatType(CallbackInfo ci) {
        var types = new ArrayList<>(Arrays.asList(field_7724));
        var last = types.get(types.size() - 1);

        var stripped_bamboo = newType("STRIPPED_BAMBOO", last.ordinal() + 1, Twigs.STRIPPED_BAMBOO_PLANKS, "stripped_bamboo");
        CustomBoatType.STRIPPED_BAMBOO = stripped_bamboo;
        types.add(stripped_bamboo);

        BoatItems.registerBoats();

        field_7724 = types.toArray(new BoatEntity.Type[0]);
    }
}
