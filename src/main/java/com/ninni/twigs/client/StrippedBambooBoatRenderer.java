package com.ninni.twigs.client;

import com.google.common.collect.ImmutableMap;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.datafixers.util.Pair;
import com.mojang.math.Quaternion;
import com.mojang.math.Vector3f;
import com.ninni.twigs.Twigs;
import com.ninni.twigs.entity.StrippedBambooBoatEntity;
import net.minecraft.client.model.BoatModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.Map;
import java.util.stream.Stream;

@OnlyIn(Dist.CLIENT)
public class StrippedBambooBoatRenderer extends EntityRenderer<StrippedBambooBoatEntity> {
    private final Map<StrippedBambooBoatEntity.BoatType, Pair<ResourceLocation, BoatModel>> boatResources;

    public StrippedBambooBoatRenderer(EntityRendererProvider.Context context) {
        super(context);
        this.boatResources = Stream.of(StrippedBambooBoatEntity.BoatType.values()).collect(ImmutableMap.toImmutableMap((type) -> type, (boatType) -> Pair.of(new ResourceLocation(Twigs.MOD_ID, "textures/entity/boat/" + boatType.getName() + ".png"), new BoatModel(context.bakeLayer(createBoatLayerLocation(boatType))))));
    }

    public static ModelLayerLocation createBoatLayerLocation(StrippedBambooBoatEntity.BoatType type) {
        return new ModelLayerLocation(new ResourceLocation(Twigs.MOD_ID, "boat/" + type.getName()), "main");
    }

    @Override
    public void render(StrippedBambooBoatEntity entity, float yaw, float partialTicks, PoseStack matrixStack, MultiBufferSource bufferSource, int packedLight) {
        matrixStack.pushPose();
        matrixStack.translate(0.0D, 0.375D, 0.0D);
        matrixStack.mulPose(Vector3f.YP.rotationDegrees(180.0F - yaw));
        float f = (float)entity.getHurtTime() - partialTicks;
        float f1 = entity.getDamage() - partialTicks;
        if (f1 < 0.0F) {
            f1 = 0.0F;
        }

        if (f > 0.0F) {
            matrixStack.mulPose(Vector3f.XP.rotationDegrees(Mth.sin(f) * f * f1 / 10.0F * (float)entity.getHurtDir()));
        }

        float f2 = entity.getBubbleAngle(partialTicks);
        if (!Mth.equal(f2, 0.0F)) {
            matrixStack.mulPose(new Quaternion(new Vector3f(1.0F, 0.0F, 1.0F), entity.getBubbleAngle(partialTicks), true));
        }

        Pair<ResourceLocation, BoatModel> pair = this.boatResources.get(entity.getBoatTypeDropItem());
        ResourceLocation resourcelocation = pair.getFirst();
        BoatModel boatmodel = pair.getSecond();
        matrixStack.scale(-1.0F, -1.0F, 1.0F);
        matrixStack.mulPose(Vector3f.YP.rotationDegrees(90.0F));
        boatmodel.setupAnim(entity, partialTicks, 0.0F, -0.1F, 0.0F, 0.0F);
        VertexConsumer vertexconsumer = bufferSource.getBuffer(boatmodel.renderType(resourcelocation));
        boatmodel.renderToBuffer(matrixStack, vertexconsumer, packedLight, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
        if (!entity.isUnderWater()) {
            VertexConsumer vertexconsumer1 = bufferSource.getBuffer(RenderType.waterMask());
            boatmodel.waterPatch().render(matrixStack, vertexconsumer1, packedLight, OverlayTexture.NO_OVERLAY);
        }

        matrixStack.popPose();
        super.render(entity, yaw, partialTicks, matrixStack, bufferSource, packedLight);
    }

    @Override
    public ResourceLocation getTextureLocation(StrippedBambooBoatEntity entity) {
        return this.boatResources.get(entity.getBoatTypeDropItem()).getFirst();
    }
}
