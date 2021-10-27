package com.ninni.twigs.mixin;


import com.ninni.twigs.Twigs;
import net.minecraft.sound.MusicSound;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.GenerationSettings;
import net.minecraft.world.biome.OverworldBiomeCreator;
import net.minecraft.world.biome.SpawnSettings;
import net.minecraft.world.gen.GenerationStep;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;



@Mixin(OverworldBiomeCreator.class)
public class OverworldBiomeCreatorMixin {
    private static void twigs$addMountainOres(GenerationSettings.Builder builder) {
        builder.feature(GenerationStep.Feature.UNDERGROUND_DECORATION, Twigs.ORE_SCHIST);
    }
    @Inject(method = "method_39152(Lnet/minecraft/world/biome/Biome$Precipitation;Lnet/minecraft/world/biome/Biome$Category;FFLnet/minecraft/world/biome/SpawnSettings$Builder;Lnet/minecraft/world/biome/GenerationSettings$Builder;Lnet/minecraft/sound/MusicSound;)Lnet/minecraft/world/biome/Biome;", locals = LocalCapture.CAPTURE_FAILHARD, at = @At("HEAD"))
    private static void createWindsweptHills(Biome.Precipitation precipitation, Biome.Category category, float f, float g, SpawnSettings.Builder builder, GenerationSettings.Builder builder2, MusicSound musicSound, CallbackInfoReturnable<Biome> cir) {
        twigs$addMountainOres(builder2);
    }
    @Inject(method = "method_39151(Lnet/minecraft/world/biome/Biome$Precipitation;Lnet/minecraft/world/biome/Biome$Category;FFIILnet/minecraft/world/biome/SpawnSettings$Builder;Lnet/minecraft/world/biome/GenerationSettings$Builder;Lnet/minecraft/sound/MusicSound;)Lnet/minecraft/world/biome/Biome;", locals = LocalCapture.CAPTURE_FAILHARD, at = @At("HEAD"))
    private static void createMeadow(Biome.Precipitation precipitation, Biome.Category category, float f, float g, int i, int j, SpawnSettings.Builder builder, GenerationSettings.Builder builder2, MusicSound musicSound, CallbackInfoReturnable<Biome> cir) {
        twigs$addMountainOres(builder2);
    }
    @Inject(method = "method_39152(Lnet/minecraft/world/biome/Biome$Precipitation;Lnet/minecraft/world/biome/Biome$Category;FFLnet/minecraft/world/biome/SpawnSettings$Builder;Lnet/minecraft/world/biome/GenerationSettings$Builder;Lnet/minecraft/sound/MusicSound;)Lnet/minecraft/world/biome/Biome;", locals = LocalCapture.CAPTURE_FAILHARD, at = @At("HEAD"))
    private static void createGrove(Biome.Precipitation precipitation, Biome.Category category, float f, float g, SpawnSettings.Builder builder, GenerationSettings.Builder builder2, MusicSound musicSound, CallbackInfoReturnable<Biome> cir) {
        twigs$addMountainOres(builder2);
    }
    @Inject(method = "method_39152(Lnet/minecraft/world/biome/Biome$Precipitation;Lnet/minecraft/world/biome/Biome$Category;FFLnet/minecraft/world/biome/SpawnSettings$Builder;Lnet/minecraft/world/biome/GenerationSettings$Builder;Lnet/minecraft/sound/MusicSound;)Lnet/minecraft/world/biome/Biome;", locals = LocalCapture.CAPTURE_FAILHARD, at = @At("HEAD"))
    private static void createSnowySlopes(Biome.Precipitation precipitation, Biome.Category category, float f, float g, SpawnSettings.Builder builder, GenerationSettings.Builder builder2, MusicSound musicSound, CallbackInfoReturnable<Biome> cir) {
        twigs$addMountainOres(builder2);
    }
    @Inject(method = "method_39152(Lnet/minecraft/world/biome/Biome$Precipitation;Lnet/minecraft/world/biome/Biome$Category;FFLnet/minecraft/world/biome/SpawnSettings$Builder;Lnet/minecraft/world/biome/GenerationSettings$Builder;Lnet/minecraft/sound/MusicSound;)Lnet/minecraft/world/biome/Biome;", locals = LocalCapture.CAPTURE_FAILHARD, at = @At("HEAD"))
    private static void createJaggedPeaks(Biome.Precipitation precipitation, Biome.Category category, float f, float g, SpawnSettings.Builder builder, GenerationSettings.Builder builder2, MusicSound musicSound, CallbackInfoReturnable<Biome> cir) {
        twigs$addMountainOres(builder2);
    }
    @Inject(method = "method_39152(Lnet/minecraft/world/biome/Biome$Precipitation;Lnet/minecraft/world/biome/Biome$Category;FFLnet/minecraft/world/biome/SpawnSettings$Builder;Lnet/minecraft/world/biome/GenerationSettings$Builder;Lnet/minecraft/sound/MusicSound;)Lnet/minecraft/world/biome/Biome;", locals = LocalCapture.CAPTURE_FAILHARD, at = @At("HEAD"))
    private static void createFrozenPeaks(Biome.Precipitation precipitation, Biome.Category category, float f, float g, SpawnSettings.Builder builder, GenerationSettings.Builder builder2, MusicSound musicSound, CallbackInfoReturnable<Biome> cir) {
        twigs$addMountainOres(builder2);
    }
    @Inject(method = "method_39152(Lnet/minecraft/world/biome/Biome$Precipitation;Lnet/minecraft/world/biome/Biome$Category;FFLnet/minecraft/world/biome/SpawnSettings$Builder;Lnet/minecraft/world/biome/GenerationSettings$Builder;Lnet/minecraft/sound/MusicSound;)Lnet/minecraft/world/biome/Biome;", locals = LocalCapture.CAPTURE_FAILHARD, at = @At("HEAD"))
    private static void createStonyPeaks(Biome.Precipitation precipitation, Biome.Category category, float f, float g, SpawnSettings.Builder builder, GenerationSettings.Builder builder2, MusicSound musicSound, CallbackInfoReturnable<Biome> cir) {
        twigs$addMountainOres(builder2);
    }
}
