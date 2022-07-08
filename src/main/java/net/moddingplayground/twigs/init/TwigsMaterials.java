package net.moddingplayground.twigs.init;

import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;

public class TwigsMaterials {

    public static final Material FLOOR_LAYER = new Material.Builder(MaterialColor.PODZOL).noCollider().notSolidBlocking().nonSolid().destroyOnPush().flammable().build();

}
