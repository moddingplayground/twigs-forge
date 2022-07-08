package net.moddingplayground.twigs.client.renderers;

import com.mojang.datafixers.util.Pair;
import net.minecraft.client.model.BoatModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.renderer.entity.BoatRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.moddingplayground.twigs.Twigs;
import org.jetbrains.annotations.NotNull;

@OnlyIn(Dist.CLIENT)
public class StrippedBambooBoatRenderer extends BoatRenderer {
    private final Pair<ResourceLocation, BoatModel> stripped_bamboo;

    public StrippedBambooBoatRenderer(EntityRendererProvider.Context context, boolean hasChest) {
        super(context, hasChest);
        this.stripped_bamboo = Pair.of(this.getTexture(hasChest), new BoatModel(context.bakeLayer(createModelLayerLocation(hasChest)), hasChest));
    }

    @NotNull
    public static ModelLayerLocation createModelLayerLocation(boolean hasChest) {
        return new ModelLayerLocation(new ResourceLocation(Twigs.MOD_ID, hasChest ? "chest_boat/stripped_bamboo" : "boat/stripped_bamboo"), "main");
    }

    public ResourceLocation getTexture(boolean hasChest) {
        if (hasChest) {
            return new ResourceLocation(Twigs.MOD_ID, "textures/entity/chest_boat/stripped_bamboo.png");
        }
        return new ResourceLocation(Twigs.MOD_ID, "textures/entity/boat/stripped_bamboo.png");
    }

    @Override
    public Pair<ResourceLocation, BoatModel> getModelWithLocation(Boat boat) {
        return this.stripped_bamboo;
    }
}
