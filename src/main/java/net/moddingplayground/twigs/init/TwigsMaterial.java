package net.moddingplayground.twigs.init;

import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;

public class TwigsMaterial {

    public static Material layerMaterial(MaterialColor color) {
        return new Material.Builder(color).noCollider().notSolidBlocking().nonSolid().destroyOnPush().flammable().build();
    }

}
