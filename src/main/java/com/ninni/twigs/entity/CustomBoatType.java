package com.ninni.twigs.entity;

import net.minecraft.entity.vehicle.BoatEntity;

public class CustomBoatType  {
    static {
        BoatEntity.Type.values();
    }

    public static BoatEntity.Type STRIPPED_BAMBOO;
}
