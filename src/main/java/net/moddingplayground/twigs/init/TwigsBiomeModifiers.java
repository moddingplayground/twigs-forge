package net.moddingplayground.twigs.init;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.moddingplayground.twigs.Twigs;
import net.moddingplayground.twigs.world.AddFeaturesWithConditionBiomeModifier;

@Mod.EventBusSubscriber(modid = Twigs.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class TwigsBiomeModifiers {

    public static final DeferredRegister<Codec<? extends BiomeModifier>> BIOME_MODIFIERS = DeferredRegister.create(ForgeRegistries.Keys.BIOME_MODIFIER_SERIALIZERS, Twigs.MOD_ID);

    public static final RegistryObject<Codec<AddFeaturesWithConditionBiomeModifier>> ADD_FEATURES_WITH_CONDITION_BIOME_MODIFIER = BIOME_MODIFIERS.register("add_features_with_condition_biome_modifier", () -> RecordCodecBuilder.create(builder -> builder.group(Biome.LIST_CODEC.fieldOf("omit").forGetter(AddFeaturesWithConditionBiomeModifier::biomes), Biome.LIST_CODEC.fieldOf("biomes").forGetter(AddFeaturesWithConditionBiomeModifier::biomes), PlacedFeature.LIST_CODEC.fieldOf("features").forGetter(AddFeaturesWithConditionBiomeModifier::features), GenerationStep.Decoration.CODEC.fieldOf("step").forGetter(AddFeaturesWithConditionBiomeModifier::step)).apply(builder, AddFeaturesWithConditionBiomeModifier::new)));

}
