package net.moddingplayground.twigs.data;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.data.recipes.SimpleCookingRecipeBuilder;
import net.minecraft.data.recipes.SingleItemRecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.moddingplayground.twigs.Twigs;
import net.moddingplayground.twigs.init.TwigsBlocks;
import org.jetbrains.annotations.NotNull;

import java.util.function.Consumer;

public class TwigsRecipeProvider extends RecipeProvider {

    public TwigsRecipeProvider(DataGenerator dataGenerator) {
        super(dataGenerator);
    }

    @Override
    protected void buildCraftingRecipes(Consumer<FinishedRecipe> consumer) {
        generic2x2(TwigsBlocks.PEBBLE.get(), Blocks.COBBLESTONE, 1).save(consumer, conversionFileName(Blocks.COBBLESTONE, TwigsBlocks.PEBBLE.get()));
        chequer2x2(Blocks.DIRT, TwigsBlocks.PEBBLE.get(), TwigsBlocks.ROCKY_DIRT.get(), 2).save(consumer);
        shapeless(TwigsBlocks.TWIG.get(), Items.STICK, 2).group("sticks").save(consumer, conversionFileName(Items.STICK, TwigsBlocks.TWIG.get()));
        shapeless(TwigsBlocks.SEA_SHELL.get(), Items.BONE_MEAL, 2).save(consumer, conversionFileName(Items.BONE_MEAL, TwigsBlocks.SEA_SHELL.get()));

        azaleaConversion(Items.AZALEA, Items.FLOWERING_AZALEA).save(consumer, conversionFileName(Items.FLOWERING_AZALEA, TwigsBlocks.AZALEA_FLOWERS.get()));
        azaleaConversion(Items.AZALEA_LEAVES, Items.FLOWERING_AZALEA_LEAVES).save(consumer, conversionFileName(Items.FLOWERING_AZALEA_LEAVES, TwigsBlocks.AZALEA_FLOWERS.get()));

        // mossy bricks
        shapeless(Items.VINE, Items.BRICKS, TwigsBlocks.MOSSY_BRICKS.get(), 2).save(consumer);
        shapeless(Items.VINE, TwigsBlocks.COBBLESTONE_BRICKS.get(), TwigsBlocks.MOSSY_COBBLESTONE_BRICKS.get(), 2).save(consumer);

        // blackstone bricks
        shapeless(Items.POLISHED_BLACKSTONE_BRICKS, Items.TWISTING_VINES, TwigsBlocks.TWISTING_POLISHED_BLACKSTONE_BRICKS.get(), 1).save(consumer);
        shapeless(Items.POLISHED_BLACKSTONE_BRICKS, Items.WEEPING_VINES, TwigsBlocks.WEEPING_POLISHED_BLACKSTONE_BRICKS.get(), 1).save(consumer);

        // stones
        chequer2x2(Items.RED_SAND, Items.QUARTZ, TwigsBlocks.RHYOLITE.get(), 2).save(consumer);
        chequer2x2(Items.CLAY_BALL, Items.QUARTZ, TwigsBlocks.SCHIST.get(), 2).save(consumer);
        chequer2x2(Items.IRON_NUGGET, Items.QUARTZ, TwigsBlocks.BLOODSTONE.get(), 2).save(consumer);

        // paper lantern
        ringSurrounding(Items.PAPER, Items.TORCH, TwigsBlocks.PAPER_LANTERN.get(), 2).group("paper_lantern").save(consumer);
        paperLantern(Items.ALLIUM, TwigsBlocks.ALLIUM_PAPER_LANTERN.get().asItem()).save(consumer);
        paperLantern(Items.BLUE_ORCHID, TwigsBlocks.BLUE_ORCHID_PAPER_LANTERN.get().asItem()).save(consumer);
        paperLantern(Items.CRIMSON_ROOTS, TwigsBlocks.CRIMSON_ROOTS_PAPER_LANTERN.get().asItem()).save(consumer);
        paperLantern(Items.DANDELION, TwigsBlocks.DANDELION_PAPER_LANTERN.get().asItem()).save(consumer);

        // lamps
        lamp(Items.TORCH, TwigsBlocks.LAMP.get().asItem()).save(consumer);
        lamp(Items.SOUL_TORCH, TwigsBlocks.SOUL_LAMP.get().asItem()).save(consumer);

        // shroomlamps
        sandwich(Items.CRIMSON_PLANKS, Items.SHROOMLIGHT, TwigsBlocks.CRIMSON_SHROOMLAMP.get(), 3).group("shroomlamp").save(consumer);
        sandwich(Items.WARPED_PLANKS, Items.SHROOMLIGHT, TwigsBlocks.WARPED_SHROOMLAMP.get(), 3).group("shroomlamp").save(consumer);

        // bamboo
        generic2x2(TwigsBlocks.BAMBOO_LEAVES.get(), TwigsBlocks.BAMBOO_THATCH.get(), 2).save(consumer);
        generic3x3(Items.BAMBOO, TwigsBlocks.BUNDLED_BAMBOO.get(), 3).save(consumer);
        shapeless(TwigsBlocks.BUNDLED_BAMBOO.get(), Items.BAMBOO, 3).save(consumer);
        stonecutting(consumer, TwigsBlocks.BUNDLED_BAMBOO.get(), TwigsBlocks.STRIPPED_BUNDLED_BAMBOO.get());

        stonecutting(consumer, Blocks.BAMBOO, TwigsBlocks.STRIPPED_BAMBOO.get());

        stonecutSave(TwigsBlocks.STRIPPED_BUNDLED_BAMBOO.get(), TwigsBlocks.STRIPPED_BAMBOO.get(), 4).save(consumer, conversionFileName(TwigsBlocks.STRIPPED_BAMBOO.get().asItem(), TwigsBlocks.STRIPPED_BUNDLED_BAMBOO.get().asItem()) + "_stonecutting");
        stonecutSave(TwigsBlocks.BUNDLED_BAMBOO.get(), TwigsBlocks.STRIPPED_BAMBOO.get(), 4).save(consumer, conversionFileName(TwigsBlocks.STRIPPED_BAMBOO.get().asItem(), TwigsBlocks.BUNDLED_BAMBOO.get().asItem()) + "_stonecutting");

        planks(TwigsBlocks.STRIPPED_BAMBOO.get(), TwigsBlocks.STRIPPED_BAMBOO_PLANKS.get()).save(consumer);
        generic3x1(TwigsBlocks.STRIPPED_BAMBOO.get(), TwigsBlocks.STRIPPED_BAMBOO_MAT.get(),2).save(consumer);
        stairBuilder(TwigsBlocks.STRIPPED_BAMBOO_STAIRS.get(), Ingredient.of(TwigsBlocks.STRIPPED_BAMBOO_PLANKS.get())).unlockedBy(getHasName(TwigsBlocks.STRIPPED_BAMBOO_PLANKS.get()), has(TwigsBlocks.STRIPPED_BAMBOO_PLANKS.get())).save(consumer);
        slab(consumer, TwigsBlocks.STRIPPED_BAMBOO_SLAB.get(), TwigsBlocks.STRIPPED_BAMBOO_PLANKS.get());
        ShapedRecipeBuilder.shaped(TwigsBlocks.STRIPPED_BAMBOO_FENCE.get(), 3).define('#', TwigsBlocks.STRIPPED_BAMBOO_PLANKS.get()).define('S', Items.STICK).pattern("#S#").pattern("#S#").unlockedBy(getHasName(TwigsBlocks.STRIPPED_BAMBOO_PLANKS.get()), has(TwigsBlocks.STRIPPED_BAMBOO_PLANKS.get())).save(consumer);
        ShapedRecipeBuilder.shaped(TwigsBlocks.STRIPPED_BAMBOO_FENCE_GATE.get()).define('#', TwigsBlocks.STRIPPED_BAMBOO_PLANKS.get()).define('S', Items.STICK).pattern("S#S").pattern("S#S").unlockedBy(getHasName(TwigsBlocks.STRIPPED_BAMBOO_PLANKS.get()), has(TwigsBlocks.STRIPPED_BAMBOO_PLANKS.get())).save(consumer);
        ShapedRecipeBuilder.shaped(TwigsBlocks.STRIPPED_BAMBOO_DOOR.get(), 3).define('#', TwigsBlocks.STRIPPED_BAMBOO_PLANKS.get()).pattern("##").pattern("##").pattern("##").unlockedBy(getHasName(TwigsBlocks.STRIPPED_BAMBOO_PLANKS.get()), has(TwigsBlocks.STRIPPED_BAMBOO_PLANKS.get())).save(consumer);
        ShapedRecipeBuilder.shaped(TwigsBlocks.STRIPPED_BAMBOO_TRAPDOOR.get()).define('#', TwigsBlocks.STRIPPED_BAMBOO_PLANKS.get()).pattern("###").pattern("###").unlockedBy(getHasName(TwigsBlocks.STRIPPED_BAMBOO_PLANKS.get()), has(TwigsBlocks.STRIPPED_BAMBOO_PLANKS.get())).save(consumer);
        ShapedRecipeBuilder.shaped(TwigsBlocks.STRIPPED_BAMBOO_PRESSURE_PLATE.get()).define('#', TwigsBlocks.STRIPPED_BAMBOO_PLANKS.get()).pattern("##").unlockedBy(getHasName(TwigsBlocks.STRIPPED_BAMBOO_PLANKS.get()), has(TwigsBlocks.STRIPPED_BAMBOO_PLANKS.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(TwigsBlocks.STRIPPED_BAMBOO_BUTTON.get()).requires(Ingredient.of(TwigsBlocks.STRIPPED_BAMBOO_PLANKS.get())).group("wooden_button").unlockedBy(getHasName(TwigsBlocks.STRIPPED_BAMBOO_PLANKS.get()), has(TwigsBlocks.STRIPPED_BAMBOO_PLANKS.get())).save(consumer);

        // tables
        table(TwigsBlocks.OAK_TABLE.get().asItem(), Blocks.OAK_PLANKS.asItem(), Blocks.OAK_SLAB.asItem()).save(consumer);
        table(TwigsBlocks.SPRUCE_TABLE.get().asItem(), Blocks.SPRUCE_PLANKS.asItem(), Blocks.SPRUCE_SLAB.asItem()).save(consumer);
        table(TwigsBlocks.BIRCH_TABLE.get().asItem(), Blocks.BIRCH_PLANKS.asItem(), Blocks.BIRCH_SLAB.asItem()).save(consumer);
        table(TwigsBlocks.JUNGLE_TABLE.get().asItem(), Blocks.JUNGLE_PLANKS.asItem(), Blocks.JUNGLE_SLAB.asItem()).save(consumer);
        table(TwigsBlocks.ACACIA_TABLE.get().asItem(), Blocks.ACACIA_PLANKS.asItem(), Blocks.ACACIA_SLAB.asItem()).save(consumer);
        table(TwigsBlocks.DARK_OAK_TABLE.get().asItem(), Blocks.DARK_OAK_PLANKS.asItem(), Blocks.DARK_OAK_SLAB.asItem()).save(consumer);
        table(TwigsBlocks.MANGROVE_TABLE.get().asItem(), Blocks.MANGROVE_PLANKS.asItem(), Blocks.MANGROVE_SLAB.asItem()).save(consumer);
        table(TwigsBlocks.CRIMSON_TABLE.get().asItem(), Blocks.CRIMSON_PLANKS.asItem(), Blocks.CRIMSON_SLAB.asItem()).save(consumer);
        table(TwigsBlocks.WARPED_TABLE.get().asItem(), Blocks.WARPED_PLANKS.asItem(), Blocks.WARPED_SLAB.asItem()).save(consumer);
        table(TwigsBlocks.STRIPPED_BAMBOO_TABLE.get().asItem(), TwigsBlocks.STRIPPED_BAMBOO_PLANKS.get().asItem(), TwigsBlocks.STRIPPED_BAMBOO_SLAB.get().asItem()).save(consumer);

        // ender mesh
        eye(TwigsBlocks.ENDER_MESH.get().asItem(), Items.ENDER_PEARL, Items.OBSIDIAN, 16).save(consumer);

        stairBuilder(TwigsBlocks.MOSSY_BRICK_STAIRS.get(), Ingredient.of(TwigsBlocks.MOSSY_BRICKS.get())).unlockedBy(getHasName(TwigsBlocks.MOSSY_BRICKS.get()), has(TwigsBlocks.MOSSY_BRICKS.get())).save(consumer);
        stonecutting(consumer, TwigsBlocks.MOSSY_BRICKS.get(), TwigsBlocks.MOSSY_BRICK_STAIRS.get());
        slab(consumer, TwigsBlocks.MOSSY_BRICK_SLAB.get(), TwigsBlocks.MOSSY_BRICKS.get());
        stonecutting(consumer, TwigsBlocks.MOSSY_BRICKS.get(), TwigsBlocks.MOSSY_BRICK_SLAB.get(), 2);
        wall(consumer, TwigsBlocks.MOSSY_BRICK_WALL.get(), TwigsBlocks.MOSSY_BRICKS.get());
        stonecutting(consumer, TwigsBlocks.MOSSY_BRICKS.get(), TwigsBlocks.MOSSY_BRICK_WALL.get());

        ShapedRecipeBuilder.shaped(TwigsBlocks.CHISELED_BRICKS.get()).define('#', Blocks.BRICK_SLAB).pattern("#").pattern("#").unlockedBy(getHasName(Blocks.BRICK_SLAB), has(Blocks.BRICK_SLAB)).save(consumer);
        stonecutSave(Blocks.BRICKS, TwigsBlocks.CHISELED_BRICKS.get()).group("brick_chiseled").save(consumer, conversionFileName(TwigsBlocks.CHISELED_BRICKS.get(), Blocks.BRICKS) + "_stonecutting");
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(Blocks.BRICKS), TwigsBlocks.CRACKED_BRICKS.get(), 0.1F, 200).unlockedBy(getHasName(Blocks.BRICKS), has(Blocks.BRICKS)).save(consumer);

        generic2x2(Blocks.POLISHED_BASALT, TwigsBlocks.POLISHED_BASALT_BRICKS.get(), 4).save(consumer);
        stonecutting(consumer, Blocks.POLISHED_BASALT, TwigsBlocks.POLISHED_BASALT_BRICKS.get());
        generic2x2(Blocks.SMOOTH_BASALT, TwigsBlocks.SMOOTH_BASALT_BRICKS.get(), 4).save(consumer);
        stonecutting(consumer, Blocks.SMOOTH_BASALT, TwigsBlocks.SMOOTH_BASALT_BRICKS.get());
        stairBuilder(TwigsBlocks.SMOOTH_BASALT_BRICK_STAIRS.get(), Ingredient.of(TwigsBlocks.SMOOTH_BASALT_BRICKS.get())).unlockedBy(getHasName(TwigsBlocks.SMOOTH_BASALT_BRICKS.get()), has(TwigsBlocks.SMOOTH_BASALT_BRICKS.get())).save(consumer);
        stonecutting(consumer, TwigsBlocks.SMOOTH_BASALT_BRICKS.get(), TwigsBlocks.SMOOTH_BASALT_BRICK_STAIRS.get());
        slab(consumer, TwigsBlocks.SMOOTH_BASALT_BRICK_SLAB.get(), TwigsBlocks.SMOOTH_BASALT_BRICKS.get());
        stonecutting(consumer, TwigsBlocks.SMOOTH_BASALT_BRICKS.get(), TwigsBlocks.SMOOTH_BASALT_BRICK_SLAB.get(), 2);
        wall(consumer, TwigsBlocks.SMOOTH_BASALT_BRICK_WALL.get(), TwigsBlocks.SMOOTH_BASALT_BRICKS.get());
        stonecutting(consumer, TwigsBlocks.SMOOTH_BASALT_BRICKS.get(), TwigsBlocks.SMOOTH_BASALT_BRICK_WALL.get());

        generic2x2(Blocks.COBBLESTONE, TwigsBlocks.COBBLESTONE_BRICKS.get(), 4).save(consumer);
        stonecutting(consumer, Blocks.COBBLESTONE, TwigsBlocks.COBBLESTONE_BRICKS.get());
        stairBuilder(TwigsBlocks.COBBLESTONE_BRICK_STAIRS.get(), Ingredient.of(TwigsBlocks.COBBLESTONE_BRICKS.get())).unlockedBy(getHasName(TwigsBlocks.COBBLESTONE_BRICKS.get()), has(TwigsBlocks.COBBLESTONE_BRICKS.get())).save(consumer);
        stonecutting(consumer, TwigsBlocks.COBBLESTONE_BRICKS.get(), TwigsBlocks.COBBLESTONE_BRICK_STAIRS.get());
        slab(consumer, TwigsBlocks.COBBLESTONE_BRICK_SLAB.get(), TwigsBlocks.COBBLESTONE_BRICKS.get());
        stonecutting(consumer, TwigsBlocks.COBBLESTONE_BRICKS.get(), TwigsBlocks.COBBLESTONE_BRICK_SLAB.get(), 2);
        wall(consumer, TwigsBlocks.COBBLESTONE_BRICK_WALL.get(), TwigsBlocks.COBBLESTONE_BRICKS.get());
        stonecutting(consumer, TwigsBlocks.COBBLESTONE_BRICKS.get(), TwigsBlocks.COBBLESTONE_BRICK_WALL.get());

        SimpleCookingRecipeBuilder.smelting(Ingredient.of(TwigsBlocks.COBBLESTONE_BRICKS.get()), TwigsBlocks.CRACKED_COBBLESTONE_BRICKS.get(), 0.1F, 200).unlockedBy(getHasName(TwigsBlocks.COBBLESTONE_BRICKS.get()), has(TwigsBlocks.COBBLESTONE_BRICKS.get())).save(consumer);

        stonecutting(consumer, Blocks.MOSSY_COBBLESTONE, TwigsBlocks.MOSSY_COBBLESTONE_BRICKS.get());
        stairBuilder(TwigsBlocks.MOSSY_COBBLESTONE_BRICK_STAIRS.get(), Ingredient.of(TwigsBlocks.MOSSY_COBBLESTONE_BRICKS.get())).unlockedBy(getHasName(TwigsBlocks.MOSSY_COBBLESTONE_BRICKS.get()), has(TwigsBlocks.MOSSY_COBBLESTONE_BRICKS.get())).save(consumer);
        stonecutting(consumer, TwigsBlocks.MOSSY_COBBLESTONE_BRICKS.get(), TwigsBlocks.MOSSY_COBBLESTONE_BRICK_STAIRS.get());
        slab(consumer, TwigsBlocks.MOSSY_COBBLESTONE_BRICK_SLAB.get(), TwigsBlocks.MOSSY_COBBLESTONE_BRICKS.get());
        stonecutting(consumer, TwigsBlocks.MOSSY_COBBLESTONE_BRICKS.get(), TwigsBlocks.MOSSY_COBBLESTONE_BRICK_SLAB.get(), 2);
        wall(consumer, TwigsBlocks.MOSSY_COBBLESTONE_BRICK_WALL.get(), TwigsBlocks.MOSSY_COBBLESTONE_BRICKS.get());
        stonecutting(consumer, TwigsBlocks.MOSSY_COBBLESTONE_BRICKS.get(), TwigsBlocks.MOSSY_COBBLESTONE_BRICK_WALL.get());

        generic2x2(Blocks.AMETHYST_BLOCK, TwigsBlocks.POLISHED_AMETHYST.get(), 4).save(consumer);
        stonecutting(consumer, Blocks.AMETHYST_BLOCK, TwigsBlocks.POLISHED_AMETHYST.get());
        stairBuilder(TwigsBlocks.POLISHED_AMETHYST_STAIRS.get(), Ingredient.of(TwigsBlocks.POLISHED_AMETHYST.get())).unlockedBy(getHasName(TwigsBlocks.POLISHED_AMETHYST.get()), has(TwigsBlocks.POLISHED_AMETHYST.get())).save(consumer);
        stonecutting(consumer, Blocks.AMETHYST_BLOCK, TwigsBlocks.POLISHED_AMETHYST_STAIRS.get());
        stonecutting(consumer, TwigsBlocks.POLISHED_AMETHYST.get(), TwigsBlocks.POLISHED_AMETHYST_STAIRS.get());
        slab(consumer, TwigsBlocks.POLISHED_AMETHYST_SLAB.get(), TwigsBlocks.POLISHED_AMETHYST.get());
        stonecutting(consumer, Blocks.AMETHYST_BLOCK, TwigsBlocks.POLISHED_AMETHYST_SLAB.get(), 2);
        stonecutting(consumer, TwigsBlocks.POLISHED_AMETHYST.get(), TwigsBlocks.POLISHED_AMETHYST_SLAB.get(), 2);
        ShapedRecipeBuilder.shaped(TwigsBlocks.CHISELED_POLISHED_AMETHYST.get()).define('#', TwigsBlocks.POLISHED_AMETHYST_SLAB.get()).pattern("#").pattern("#").unlockedBy(getHasName(TwigsBlocks.POLISHED_AMETHYST_SLAB.get()), has(TwigsBlocks.POLISHED_AMETHYST_SLAB.get())).save(consumer);

        generic2x2(TwigsBlocks.POLISHED_AMETHYST.get(), TwigsBlocks.POLISHED_AMETHYST_BRICKS.get(), 4).save(consumer);
        stonecutting(consumer, Blocks.AMETHYST_BLOCK, TwigsBlocks.POLISHED_AMETHYST_BRICKS.get());
        stonecutting(consumer, TwigsBlocks.POLISHED_AMETHYST.get(), TwigsBlocks.POLISHED_AMETHYST_BRICKS.get());
        stairBuilder(TwigsBlocks.POLISHED_AMETHYST_BRICK_STAIRS.get(), Ingredient.of(TwigsBlocks.POLISHED_AMETHYST_BRICKS.get())).unlockedBy(getHasName(TwigsBlocks.POLISHED_AMETHYST_BRICKS.get()), has(TwigsBlocks.POLISHED_AMETHYST_BRICKS.get())).save(consumer);
        stonecutting(consumer, Blocks.AMETHYST_BLOCK, TwigsBlocks.POLISHED_AMETHYST_BRICK_STAIRS.get());
        stonecutting(consumer, TwigsBlocks.POLISHED_AMETHYST.get(), TwigsBlocks.POLISHED_AMETHYST_BRICK_STAIRS.get());
        stonecutting(consumer, TwigsBlocks.POLISHED_AMETHYST_BRICKS.get(), TwigsBlocks.POLISHED_AMETHYST_BRICK_STAIRS.get());
        slab(consumer, TwigsBlocks.POLISHED_AMETHYST_BRICK_SLAB.get(), TwigsBlocks.POLISHED_AMETHYST_BRICKS.get());
        stonecutting(consumer, Blocks.AMETHYST_BLOCK, TwigsBlocks.POLISHED_AMETHYST_BRICK_SLAB.get(), 2);
        stonecutting(consumer, TwigsBlocks.POLISHED_AMETHYST.get(), TwigsBlocks.POLISHED_AMETHYST_BRICK_SLAB.get(), 2);
        stonecutting(consumer, TwigsBlocks.POLISHED_AMETHYST_BRICKS.get(), TwigsBlocks.POLISHED_AMETHYST_BRICK_SLAB.get(), 2);
        wall(consumer, TwigsBlocks.POLISHED_AMETHYST_BRICK_WALL.get(), TwigsBlocks.POLISHED_AMETHYST_BRICKS.get());
        stonecutting(consumer, Blocks.AMETHYST_BLOCK, TwigsBlocks.POLISHED_AMETHYST_BRICK_WALL.get());
        stonecutting(consumer, TwigsBlocks.POLISHED_AMETHYST.get(), TwigsBlocks.POLISHED_AMETHYST_BRICK_WALL.get());
        stonecutting(consumer, TwigsBlocks.POLISHED_AMETHYST_BRICKS.get(), TwigsBlocks.POLISHED_AMETHYST_BRICK_WALL.get());

        SimpleCookingRecipeBuilder.smelting(Ingredient.of(TwigsBlocks.POLISHED_AMETHYST_BRICKS.get()), TwigsBlocks.CRACKED_POLISHED_AMETHYST_BRICKS.get(), 0.1F, 200).unlockedBy(getHasName(TwigsBlocks.POLISHED_AMETHYST_BRICKS.get()), has(TwigsBlocks.POLISHED_AMETHYST_BRICKS.get())).save(consumer);

        stairBuilder(TwigsBlocks.TWISTING_POLISHED_BLACKSTONE_BRICK_STAIRS.get(), Ingredient.of(TwigsBlocks.TWISTING_POLISHED_BLACKSTONE_BRICKS.get())).unlockedBy(getHasName(TwigsBlocks.TWISTING_POLISHED_BLACKSTONE_BRICKS.get()), has(TwigsBlocks.TWISTING_POLISHED_BLACKSTONE_BRICKS.get())).save(consumer);
        stonecutting(consumer, TwigsBlocks.TWISTING_POLISHED_BLACKSTONE_BRICKS.get(), TwigsBlocks.TWISTING_POLISHED_BLACKSTONE_BRICK_STAIRS.get());
        slab(consumer, TwigsBlocks.TWISTING_POLISHED_BLACKSTONE_BRICK_SLAB.get(), TwigsBlocks.TWISTING_POLISHED_BLACKSTONE_BRICKS.get());
        stonecutting(consumer, TwigsBlocks.TWISTING_POLISHED_BLACKSTONE_BRICKS.get(), TwigsBlocks.TWISTING_POLISHED_BLACKSTONE_BRICK_SLAB.get(), 2);
        wall(consumer, TwigsBlocks.TWISTING_POLISHED_BLACKSTONE_BRICK_WALL.get(), TwigsBlocks.TWISTING_POLISHED_BLACKSTONE_BRICKS.get());
        stonecutting(consumer, TwigsBlocks.TWISTING_POLISHED_BLACKSTONE_BRICKS.get(), TwigsBlocks.TWISTING_POLISHED_BLACKSTONE_BRICK_WALL.get());

        stairBuilder(TwigsBlocks.WEEPING_POLISHED_BLACKSTONE_BRICK_STAIRS.get(), Ingredient.of(TwigsBlocks.WEEPING_POLISHED_BLACKSTONE_BRICKS.get())).unlockedBy(getHasName(TwigsBlocks.WEEPING_POLISHED_BLACKSTONE_BRICKS.get()), has(TwigsBlocks.WEEPING_POLISHED_BLACKSTONE_BRICKS.get())).save(consumer);
        stonecutting(consumer, TwigsBlocks.WEEPING_POLISHED_BLACKSTONE_BRICKS.get(), TwigsBlocks.WEEPING_POLISHED_BLACKSTONE_BRICK_STAIRS.get());
        slab(consumer, TwigsBlocks.WEEPING_POLISHED_BLACKSTONE_BRICK_SLAB.get(), TwigsBlocks.WEEPING_POLISHED_BLACKSTONE_BRICKS.get());
        stonecutting(consumer, TwigsBlocks.WEEPING_POLISHED_BLACKSTONE_BRICKS.get(), TwigsBlocks.WEEPING_POLISHED_BLACKSTONE_BRICK_SLAB.get(), 2);
        wall(consumer, TwigsBlocks.WEEPING_POLISHED_BLACKSTONE_BRICK_WALL.get(), TwigsBlocks.WEEPING_POLISHED_BLACKSTONE_BRICKS.get());
        stonecutting(consumer, TwigsBlocks.WEEPING_POLISHED_BLACKSTONE_BRICKS.get(), TwigsBlocks.WEEPING_POLISHED_BLACKSTONE_BRICK_WALL.get());

        stairBuilder(TwigsBlocks.TUFF_STAIRS.get(), Ingredient.of(Blocks.TUFF)).unlockedBy(getHasName(Blocks.TUFF), has(Blocks.TUFF)).save(consumer);
        stonecutting(consumer, Blocks.TUFF, TwigsBlocks.TUFF_STAIRS.get());
        slab(consumer, TwigsBlocks.TUFF_SLAB.get(), Blocks.TUFF);
        stonecutting(consumer, Blocks.TUFF, TwigsBlocks.TUFF_SLAB.get(), 2);
        wall(consumer, TwigsBlocks.TUFF_WALL.get(), Blocks.TUFF);
        stonecutting(consumer, Blocks.TUFF, TwigsBlocks.TUFF_WALL.get());

        generic2x2(Blocks.TUFF, TwigsBlocks.POLISHED_TUFF.get(), 4).save(consumer);
        stonecutting(consumer, Blocks.TUFF, TwigsBlocks.POLISHED_TUFF.get());
        stairBuilder(TwigsBlocks.POLISHED_TUFF_STAIRS.get(), Ingredient.of(TwigsBlocks.POLISHED_TUFF.get())).unlockedBy(getHasName(TwigsBlocks.POLISHED_TUFF.get()), has(TwigsBlocks.POLISHED_TUFF.get())).save(consumer);
        stonecutting(consumer, Blocks.TUFF, TwigsBlocks.POLISHED_TUFF_STAIRS.get());
        stonecutting(consumer, TwigsBlocks.POLISHED_TUFF.get(), TwigsBlocks.POLISHED_TUFF_STAIRS.get());
        slab(consumer, TwigsBlocks.POLISHED_TUFF_SLAB.get(), TwigsBlocks.POLISHED_TUFF.get());
        stonecutting(consumer, Blocks.TUFF, TwigsBlocks.POLISHED_TUFF_SLAB.get(), 2);
        stonecutting(consumer, TwigsBlocks.POLISHED_TUFF.get(), TwigsBlocks.POLISHED_TUFF_SLAB.get(), 2);

        generic2x2(TwigsBlocks.POLISHED_TUFF.get(), TwigsBlocks.POLISHED_TUFF_BRICKS.get(), 4).save(consumer);
        stonecutting(consumer, Blocks.TUFF, TwigsBlocks.POLISHED_TUFF_BRICKS.get());
        stonecutting(consumer, TwigsBlocks.POLISHED_TUFF.get(), TwigsBlocks.POLISHED_TUFF_BRICKS.get());
        stairBuilder(TwigsBlocks.POLISHED_TUFF_BRICK_STAIRS.get(), Ingredient.of(TwigsBlocks.POLISHED_TUFF_BRICKS.get())).unlockedBy(getHasName(TwigsBlocks.POLISHED_TUFF_BRICKS.get()), has(TwigsBlocks.POLISHED_TUFF_BRICKS.get())).save(consumer);
        stonecutting(consumer, Blocks.TUFF, TwigsBlocks.POLISHED_TUFF_BRICK_STAIRS.get());
        stonecutting(consumer, TwigsBlocks.POLISHED_TUFF.get(), TwigsBlocks.POLISHED_TUFF_BRICK_STAIRS.get());
        stonecutting(consumer, TwigsBlocks.POLISHED_TUFF_BRICKS.get(), TwigsBlocks.POLISHED_TUFF_BRICK_STAIRS.get());
        slab(consumer, TwigsBlocks.POLISHED_TUFF_BRICK_SLAB.get(), TwigsBlocks.POLISHED_TUFF_BRICKS.get());
        stonecutting(consumer, Blocks.TUFF, TwigsBlocks.POLISHED_TUFF_BRICK_SLAB.get(), 2);
        stonecutting(consumer, TwigsBlocks.POLISHED_TUFF.get(), TwigsBlocks.POLISHED_TUFF_BRICK_SLAB.get(), 2);
        stonecutting(consumer, TwigsBlocks.POLISHED_TUFF_BRICKS.get(), TwigsBlocks.POLISHED_TUFF_BRICK_SLAB.get(), 2);
        wall(consumer, TwigsBlocks.POLISHED_TUFF_BRICK_WALL.get(), TwigsBlocks.POLISHED_TUFF_BRICKS.get());
        stonecutting(consumer, Blocks.TUFF, TwigsBlocks.POLISHED_TUFF_BRICK_WALL.get());
        stonecutting(consumer, TwigsBlocks.POLISHED_TUFF.get(), TwigsBlocks.POLISHED_TUFF_BRICK_WALL.get());
        stonecutting(consumer, TwigsBlocks.POLISHED_TUFF_BRICKS.get(), TwigsBlocks.POLISHED_TUFF_BRICK_WALL.get());

        SimpleCookingRecipeBuilder.smelting(Ingredient.of(TwigsBlocks.POLISHED_TUFF_BRICKS.get()), TwigsBlocks.CRACKED_POLISHED_TUFF_BRICKS.get(), 0.1F, 200).unlockedBy(getHasName(TwigsBlocks.POLISHED_TUFF_BRICKS.get()), has(TwigsBlocks.POLISHED_TUFF_BRICKS.get())).save(consumer);

        stairBuilder(TwigsBlocks.CALCITE_STAIRS.get(), Ingredient.of(Blocks.CALCITE)).unlockedBy(getHasName(Blocks.CALCITE), has(Blocks.CALCITE)).save(consumer);
        stonecutting(consumer, Blocks.CALCITE, TwigsBlocks.CALCITE_STAIRS.get());
        slab(consumer, TwigsBlocks.CALCITE_SLAB.get(), Blocks.CALCITE);
        stonecutting(consumer, Blocks.CALCITE, TwigsBlocks.CALCITE_SLAB.get(), 2);
        wall(consumer, TwigsBlocks.CALCITE_WALL.get(), Blocks.CALCITE);
        stonecutting(consumer, Blocks.CALCITE, TwigsBlocks.CALCITE_WALL.get());

        generic2x2(Blocks.CALCITE, TwigsBlocks.POLISHED_CALCITE.get(), 4).save(consumer);
        stonecutting(consumer, Blocks.CALCITE, TwigsBlocks.POLISHED_CALCITE.get());
        stairBuilder(TwigsBlocks.POLISHED_CALCITE_STAIRS.get(), Ingredient.of(TwigsBlocks.POLISHED_CALCITE.get())).unlockedBy(getHasName(TwigsBlocks.POLISHED_CALCITE.get()), has(TwigsBlocks.POLISHED_CALCITE.get())).save(consumer);
        stonecutting(consumer, Blocks.CALCITE, TwigsBlocks.POLISHED_CALCITE_STAIRS.get());
        stonecutting(consumer, TwigsBlocks.POLISHED_CALCITE.get(), TwigsBlocks.POLISHED_CALCITE_STAIRS.get());
        slab(consumer, TwigsBlocks.POLISHED_CALCITE_SLAB.get(), TwigsBlocks.POLISHED_CALCITE.get());
        stonecutting(consumer, Blocks.CALCITE, TwigsBlocks.POLISHED_CALCITE_SLAB.get(), 2);
        stonecutting(consumer, TwigsBlocks.POLISHED_CALCITE.get(), TwigsBlocks.POLISHED_CALCITE_SLAB.get(), 2);

        generic2x2(TwigsBlocks.POLISHED_CALCITE.get(), TwigsBlocks.POLISHED_CALCITE_BRICKS.get(), 4).save(consumer);
        stonecutting(consumer, Blocks.CALCITE, TwigsBlocks.POLISHED_CALCITE_BRICKS.get());
        stonecutting(consumer, TwigsBlocks.POLISHED_CALCITE.get(), TwigsBlocks.POLISHED_CALCITE_BRICKS.get());
        stairBuilder(TwigsBlocks.POLISHED_CALCITE_BRICK_STAIRS.get(), Ingredient.of(TwigsBlocks.POLISHED_CALCITE_BRICKS.get())).unlockedBy(getHasName(TwigsBlocks.POLISHED_CALCITE_BRICKS.get()), has(TwigsBlocks.POLISHED_CALCITE_BRICKS.get())).save(consumer);
        stonecutting(consumer, Blocks.CALCITE, TwigsBlocks.POLISHED_CALCITE_BRICK_STAIRS.get());
        stonecutting(consumer, TwigsBlocks.POLISHED_CALCITE.get(), TwigsBlocks.POLISHED_CALCITE_BRICK_STAIRS.get());
        stonecutting(consumer, TwigsBlocks.POLISHED_CALCITE_BRICKS.get(), TwigsBlocks.POLISHED_CALCITE_BRICK_STAIRS.get());
        slab(consumer, TwigsBlocks.POLISHED_CALCITE_BRICK_SLAB.get(), TwigsBlocks.POLISHED_CALCITE_BRICKS.get());
        stonecutting(consumer, Blocks.CALCITE, TwigsBlocks.POLISHED_CALCITE_BRICK_SLAB.get(), 2);
        stonecutting(consumer, TwigsBlocks.POLISHED_CALCITE.get(), TwigsBlocks.POLISHED_CALCITE_BRICK_SLAB.get(), 2);
        stonecutting(consumer, TwigsBlocks.POLISHED_CALCITE_BRICKS.get(), TwigsBlocks.POLISHED_CALCITE_BRICK_SLAB.get(), 2);
        wall(consumer, TwigsBlocks.POLISHED_CALCITE_BRICK_WALL.get(), TwigsBlocks.POLISHED_CALCITE_BRICKS.get());
        stonecutting(consumer, Blocks.CALCITE, TwigsBlocks.POLISHED_CALCITE_BRICK_WALL.get());
        stonecutting(consumer, TwigsBlocks.POLISHED_CALCITE.get(), TwigsBlocks.POLISHED_CALCITE_BRICK_WALL.get());
        stonecutting(consumer, TwigsBlocks.POLISHED_CALCITE_BRICKS.get(), TwigsBlocks.POLISHED_CALCITE_BRICK_WALL.get());

        SimpleCookingRecipeBuilder.smelting(Ingredient.of(TwigsBlocks.POLISHED_CALCITE_BRICKS.get()), TwigsBlocks.CRACKED_POLISHED_CALCITE_BRICKS.get(), 0.1F, 200).unlockedBy(getHasName(TwigsBlocks.POLISHED_CALCITE_BRICKS.get()), has(TwigsBlocks.POLISHED_CALCITE_BRICKS.get())).save(consumer);

        ShapedRecipeBuilder.shaped(TwigsBlocks.COPPER_PILLAR.get())
                       .define('#', Blocks.CUT_COPPER_SLAB)
                       .pattern("#")
                       .pattern("#")
                       .unlockedBy(getHasName(Blocks.CUT_COPPER_SLAB), has(Blocks.CUT_COPPER_SLAB)).save(consumer);
        ShapedRecipeBuilder.shaped(TwigsBlocks.EXPOSED_COPPER_PILLAR.get())
                .define('#', Blocks.EXPOSED_CUT_COPPER_SLAB)
                .pattern("#")
                .pattern("#")
                .unlockedBy(getHasName(Blocks.EXPOSED_CUT_COPPER_SLAB), has(Blocks.EXPOSED_CUT_COPPER_SLAB)).save(consumer);
        ShapedRecipeBuilder.shaped(TwigsBlocks.WEATHERED_COPPER_PILLAR.get())
                        .define('#', Blocks.WEATHERED_CUT_COPPER_SLAB)
                                .pattern("#").pattern("#").unlockedBy(getHasName(Blocks.WEATHERED_CUT_COPPER_SLAB), has(Blocks.WEATHERED_CUT_COPPER_SLAB)).save(consumer);
        ShapedRecipeBuilder.shaped(TwigsBlocks.OXIDIZED_COPPER_PILLAR.get())
                        .define('#', Blocks.OXIDIZED_CUT_COPPER_SLAB)
                                .pattern("#").pattern("#").unlockedBy(getHasName(Blocks.OXIDIZED_CUT_COPPER_SLAB), has(Blocks.OXIDIZED_CUT_COPPER_SLAB)).save(consumer);
        ShapedRecipeBuilder.shaped(TwigsBlocks.WAXED_COPPER_PILLAR.get())
                        .define('#', Blocks.WAXED_CUT_COPPER_SLAB)
                                .pattern("#").pattern("#").unlockedBy(getHasName(Blocks.WAXED_CUT_COPPER_SLAB), has(Blocks.WAXED_CUT_COPPER_SLAB)).save(consumer);
        ShapedRecipeBuilder.shaped(TwigsBlocks.WAXED_EXPOSED_COPPER_PILLAR.get())
                        .define('#', Blocks.WAXED_EXPOSED_CUT_COPPER_SLAB)
                                .pattern("#").pattern("#").unlockedBy(getHasName(Blocks.WAXED_EXPOSED_CUT_COPPER_SLAB), has(Blocks.WAXED_EXPOSED_CUT_COPPER_SLAB)).save(consumer);
        ShapedRecipeBuilder.shaped(TwigsBlocks.WAXED_WEATHERED_COPPER_PILLAR.get())
                        .define('#', Blocks.WAXED_WEATHERED_CUT_COPPER_SLAB)
                                .pattern("#").pattern("#").unlockedBy(getHasName(Blocks.WAXED_WEATHERED_CUT_COPPER_SLAB), has(Blocks.WAXED_WEATHERED_CUT_COPPER_SLAB)).save(consumer);
        ShapedRecipeBuilder.shaped(TwigsBlocks.WAXED_OXIDIZED_COPPER_PILLAR.get())
                        .define('#', Blocks.WAXED_OXIDIZED_CUT_COPPER_SLAB)
                                .pattern("#").pattern("#").unlockedBy(getHasName(Blocks.WAXED_OXIDIZED_CUT_COPPER_SLAB), has(Blocks.WAXED_OXIDIZED_CUT_COPPER_SLAB)).save(consumer);

        stonecutting(consumer, Blocks.COPPER_BLOCK, TwigsBlocks.COPPER_PILLAR.get());
        stonecutting(consumer, Blocks.EXPOSED_COPPER, TwigsBlocks.EXPOSED_COPPER_PILLAR.get());
        stonecutting(consumer, Blocks.WEATHERED_COPPER, TwigsBlocks.WEATHERED_COPPER_PILLAR.get());
        stonecutting(consumer, Blocks.OXIDIZED_COPPER, TwigsBlocks.OXIDIZED_COPPER_PILLAR.get());

        stonecutting(consumer, Blocks.WAXED_COPPER_BLOCK, TwigsBlocks.WAXED_COPPER_PILLAR.get());
        stonecutting(consumer, Blocks.WAXED_EXPOSED_COPPER, TwigsBlocks.WAXED_EXPOSED_COPPER_PILLAR.get());
        stonecutting(consumer, Blocks.WAXED_WEATHERED_COPPER, TwigsBlocks.WAXED_WEATHERED_COPPER_PILLAR.get());
        stonecutting(consumer, Blocks.WAXED_OXIDIZED_COPPER, TwigsBlocks.WAXED_OXIDIZED_COPPER_PILLAR.get());

        stairBuilder(TwigsBlocks.RHYOLITE_STAIRS.get(), Ingredient.of(TwigsBlocks.RHYOLITE.get())).unlockedBy(getHasName(TwigsBlocks.RHYOLITE.get()), has(TwigsBlocks.RHYOLITE.get())).save(consumer);
        stonecutting(consumer, TwigsBlocks.RHYOLITE.get(), TwigsBlocks.RHYOLITE_STAIRS.get());
        slab(consumer, TwigsBlocks.RHYOLITE_SLAB.get(), TwigsBlocks.RHYOLITE.get());
        stonecutting(consumer, TwigsBlocks.RHYOLITE.get(), TwigsBlocks.RHYOLITE_SLAB.get(), 2);
        wall(consumer, TwigsBlocks.RHYOLITE_WALL.get(), TwigsBlocks.RHYOLITE.get());
        stonecutting(consumer, TwigsBlocks.RHYOLITE.get(), TwigsBlocks.RHYOLITE_WALL.get());

        generic2x2(TwigsBlocks.RHYOLITE.get(), TwigsBlocks.POLISHED_RHYOLITE.get(), 4).save(consumer);
        stonecutting(consumer, TwigsBlocks.RHYOLITE.get(), TwigsBlocks.POLISHED_RHYOLITE.get());
        stairBuilder(TwigsBlocks.POLISHED_RHYOLITE_STAIRS.get(), Ingredient.of(TwigsBlocks.POLISHED_RHYOLITE.get())).unlockedBy(getHasName(TwigsBlocks.POLISHED_RHYOLITE.get()), has(TwigsBlocks.POLISHED_RHYOLITE.get())).save(consumer);
        stonecutting(consumer, TwigsBlocks.RHYOLITE.get(), TwigsBlocks.POLISHED_RHYOLITE_STAIRS.get());
        stonecutting(consumer, TwigsBlocks.POLISHED_RHYOLITE.get(), TwigsBlocks.POLISHED_RHYOLITE_STAIRS.get());
        slab(consumer, TwigsBlocks.POLISHED_RHYOLITE_SLAB.get(), TwigsBlocks.POLISHED_RHYOLITE.get());
        stonecutting(consumer, TwigsBlocks.RHYOLITE.get(), TwigsBlocks.POLISHED_RHYOLITE_SLAB.get(), 2);
        stonecutting(consumer, TwigsBlocks.POLISHED_RHYOLITE.get(), TwigsBlocks.POLISHED_RHYOLITE_SLAB.get(), 2);

        generic2x2(TwigsBlocks.POLISHED_RHYOLITE.get(), TwigsBlocks.POLISHED_RHYOLITE_BRICKS.get(), 4).save(consumer);
        stonecutting(consumer, TwigsBlocks.RHYOLITE.get(), TwigsBlocks.POLISHED_RHYOLITE_BRICKS.get());
        stonecutting(consumer, TwigsBlocks.POLISHED_RHYOLITE.get(), TwigsBlocks.POLISHED_RHYOLITE_BRICKS.get());
        stairBuilder(TwigsBlocks.POLISHED_RHYOLITE_BRICK_STAIRS.get(), Ingredient.of(TwigsBlocks.POLISHED_RHYOLITE_BRICKS.get())).unlockedBy(getHasName(TwigsBlocks.POLISHED_RHYOLITE_BRICKS.get()), has(TwigsBlocks.POLISHED_RHYOLITE_BRICKS.get())).save(consumer);
        stonecutting(consumer, TwigsBlocks.RHYOLITE.get(), TwigsBlocks.POLISHED_RHYOLITE_BRICK_STAIRS.get());
        stonecutting(consumer, TwigsBlocks.POLISHED_RHYOLITE.get(), TwigsBlocks.POLISHED_RHYOLITE_BRICK_STAIRS.get());
        stonecutting(consumer, TwigsBlocks.POLISHED_RHYOLITE_BRICKS.get(), TwigsBlocks.POLISHED_RHYOLITE_BRICK_STAIRS.get());
        slab(consumer, TwigsBlocks.POLISHED_RHYOLITE_BRICK_SLAB.get(), TwigsBlocks.POLISHED_RHYOLITE_BRICKS.get());
        stonecutting(consumer, TwigsBlocks.RHYOLITE.get(), TwigsBlocks.POLISHED_RHYOLITE_BRICK_SLAB.get(), 2);
        stonecutting(consumer, TwigsBlocks.POLISHED_RHYOLITE.get(), TwigsBlocks.POLISHED_RHYOLITE_BRICK_SLAB.get(), 2);
        stonecutting(consumer, TwigsBlocks.POLISHED_RHYOLITE_BRICKS.get(), TwigsBlocks.POLISHED_RHYOLITE_BRICK_SLAB.get(), 2);
        wall(consumer, TwigsBlocks.POLISHED_RHYOLITE_BRICK_WALL.get(), TwigsBlocks.POLISHED_RHYOLITE_BRICKS.get());
        stonecutting(consumer, TwigsBlocks.RHYOLITE.get(), TwigsBlocks.POLISHED_RHYOLITE_BRICK_WALL.get());
        stonecutting(consumer, TwigsBlocks.POLISHED_RHYOLITE.get(), TwigsBlocks.POLISHED_RHYOLITE_BRICK_WALL.get());
        stonecutting(consumer, TwigsBlocks.POLISHED_RHYOLITE_BRICKS.get(), TwigsBlocks.POLISHED_RHYOLITE_BRICK_WALL.get());

        SimpleCookingRecipeBuilder.smelting(Ingredient.of(TwigsBlocks.POLISHED_RHYOLITE_BRICKS.get()), TwigsBlocks.CRACKED_POLISHED_RHYOLITE_BRICKS.get(), 0.1F, 200).unlockedBy(getHasName(TwigsBlocks.POLISHED_RHYOLITE_BRICKS.get()), has(TwigsBlocks.POLISHED_RHYOLITE_BRICKS.get())).save(consumer);

        stairBuilder(TwigsBlocks.SCHIST_STAIRS.get(), Ingredient.of(TwigsBlocks.SCHIST.get())).unlockedBy(getHasName(TwigsBlocks.SCHIST.get()), has(TwigsBlocks.SCHIST.get())).save(consumer);
        stonecutting(consumer, TwigsBlocks.SCHIST.get(), TwigsBlocks.SCHIST_STAIRS.get());
        slab(consumer, TwigsBlocks.SCHIST_SLAB.get(), TwigsBlocks.SCHIST.get());
        stonecutting(consumer, TwigsBlocks.SCHIST.get(), TwigsBlocks.SCHIST_SLAB.get(), 2);
        wall(consumer, TwigsBlocks.SCHIST_WALL.get(), TwigsBlocks.SCHIST.get());
        stonecutting(consumer, TwigsBlocks.SCHIST.get(), TwigsBlocks.SCHIST_WALL.get());

        generic2x2(TwigsBlocks.SCHIST.get(), TwigsBlocks.POLISHED_SCHIST.get(), 4).save(consumer);
        stonecutting(consumer, TwigsBlocks.SCHIST.get(), TwigsBlocks.POLISHED_SCHIST.get());
        stairBuilder(TwigsBlocks.POLISHED_SCHIST_STAIRS.get(), Ingredient.of(TwigsBlocks.POLISHED_SCHIST.get())).unlockedBy(getHasName(TwigsBlocks.POLISHED_SCHIST.get()), has(TwigsBlocks.POLISHED_SCHIST.get())).save(consumer);
        stonecutting(consumer, TwigsBlocks.SCHIST.get(), TwigsBlocks.POLISHED_SCHIST_STAIRS.get());
        stonecutting(consumer, TwigsBlocks.POLISHED_SCHIST.get(), TwigsBlocks.POLISHED_SCHIST_STAIRS.get());
        slab(consumer, TwigsBlocks.POLISHED_SCHIST_SLAB.get(), TwigsBlocks.POLISHED_SCHIST.get());
        stonecutting(consumer, TwigsBlocks.SCHIST.get(), TwigsBlocks.POLISHED_SCHIST_SLAB.get(), 2);
        stonecutting(consumer, TwigsBlocks.POLISHED_SCHIST.get(), TwigsBlocks.POLISHED_SCHIST_SLAB.get(), 2);

        generic2x2(TwigsBlocks.POLISHED_SCHIST.get(), TwigsBlocks.POLISHED_SCHIST_BRICKS.get(), 4).save(consumer);
        stonecutting(consumer, TwigsBlocks.SCHIST.get(), TwigsBlocks.POLISHED_SCHIST_BRICKS.get());
        stonecutting(consumer, TwigsBlocks.POLISHED_SCHIST.get(), TwigsBlocks.POLISHED_SCHIST_BRICKS.get());
        stairBuilder(TwigsBlocks.POLISHED_SCHIST_BRICK_STAIRS.get(), Ingredient.of(TwigsBlocks.POLISHED_SCHIST_BRICKS.get())).unlockedBy(getHasName(TwigsBlocks.POLISHED_SCHIST_BRICKS.get()), has(TwigsBlocks.POLISHED_SCHIST_BRICKS.get())).save(consumer);
        stonecutting(consumer, TwigsBlocks.SCHIST.get(), TwigsBlocks.POLISHED_SCHIST_BRICK_STAIRS.get());
        stonecutting(consumer, TwigsBlocks.POLISHED_SCHIST.get(), TwigsBlocks.POLISHED_SCHIST_BRICK_STAIRS.get());
        stonecutting(consumer, TwigsBlocks.POLISHED_SCHIST_BRICKS.get(), TwigsBlocks.POLISHED_SCHIST_BRICK_STAIRS.get());
        slab(consumer, TwigsBlocks.POLISHED_SCHIST_BRICK_SLAB.get(), TwigsBlocks.POLISHED_SCHIST_BRICKS.get());
        stonecutting(consumer, TwigsBlocks.SCHIST.get(), TwigsBlocks.POLISHED_SCHIST_BRICK_SLAB.get(), 2);
        stonecutting(consumer, TwigsBlocks.POLISHED_SCHIST.get(), TwigsBlocks.POLISHED_SCHIST_BRICK_SLAB.get(), 2);
        stonecutting(consumer, TwigsBlocks.POLISHED_SCHIST_BRICKS.get(), TwigsBlocks.POLISHED_SCHIST_BRICK_SLAB.get(), 2);
        wall(consumer, TwigsBlocks.POLISHED_SCHIST_BRICK_WALL.get(), TwigsBlocks.POLISHED_SCHIST_BRICKS.get());
        stonecutting(consumer, TwigsBlocks.SCHIST.get(), TwigsBlocks.POLISHED_SCHIST_BRICK_WALL.get());
        stonecutting(consumer, TwigsBlocks.POLISHED_SCHIST.get(), TwigsBlocks.POLISHED_SCHIST_BRICK_WALL.get());
        stonecutting(consumer, TwigsBlocks.POLISHED_SCHIST_BRICKS.get(), TwigsBlocks.POLISHED_SCHIST_BRICK_WALL.get());

        SimpleCookingRecipeBuilder.smelting(Ingredient.of(TwigsBlocks.POLISHED_SCHIST_BRICKS.get()), TwigsBlocks.CRACKED_POLISHED_SCHIST_BRICKS.get(), 0.1F, 200).unlockedBy(getHasName(TwigsBlocks.POLISHED_SCHIST_BRICKS.get()), has(TwigsBlocks.POLISHED_SCHIST_BRICKS.get())).save(consumer);

        stairBuilder(TwigsBlocks.BLOODSTONE_STAIRS.get(), Ingredient.of(TwigsBlocks.BLOODSTONE.get())).unlockedBy(getHasName(TwigsBlocks.BLOODSTONE.get()), has(TwigsBlocks.BLOODSTONE.get())).save(consumer);
        stonecutting(consumer, TwigsBlocks.BLOODSTONE.get(), TwigsBlocks.BLOODSTONE_STAIRS.get());
        slab(consumer, TwigsBlocks.BLOODSTONE_SLAB.get(), TwigsBlocks.BLOODSTONE.get());
        stonecutting(consumer, TwigsBlocks.BLOODSTONE.get(), TwigsBlocks.BLOODSTONE_SLAB.get(), 2);
        wall(consumer, TwigsBlocks.BLOODSTONE_WALL.get(), TwigsBlocks.BLOODSTONE.get());
        stonecutting(consumer, TwigsBlocks.BLOODSTONE.get(), TwigsBlocks.BLOODSTONE_WALL.get());

        generic2x2(TwigsBlocks.BLOODSTONE.get(), TwigsBlocks.POLISHED_BLOODSTONE.get(), 4).save(consumer);
        stonecutting(consumer, TwigsBlocks.BLOODSTONE.get(), TwigsBlocks.POLISHED_BLOODSTONE.get());
        stairBuilder(TwigsBlocks.POLISHED_BLOODSTONE_STAIRS.get(), Ingredient.of(TwigsBlocks.POLISHED_BLOODSTONE.get())).unlockedBy(getHasName(TwigsBlocks.POLISHED_BLOODSTONE.get()), has(TwigsBlocks.POLISHED_BLOODSTONE.get())).save(consumer);
        stonecutting(consumer, TwigsBlocks.BLOODSTONE.get(), TwigsBlocks.POLISHED_BLOODSTONE_STAIRS.get());
        stonecutting(consumer, TwigsBlocks.POLISHED_BLOODSTONE.get(), TwigsBlocks.POLISHED_BLOODSTONE_STAIRS.get());
        slab(consumer, TwigsBlocks.POLISHED_BLOODSTONE_SLAB.get(), TwigsBlocks.POLISHED_BLOODSTONE.get());
        stonecutting(consumer, TwigsBlocks.BLOODSTONE.get(), TwigsBlocks.POLISHED_BLOODSTONE_SLAB.get(), 2);
        stonecutting(consumer, TwigsBlocks.POLISHED_BLOODSTONE.get(), TwigsBlocks.POLISHED_BLOODSTONE_SLAB.get(), 2);

        generic2x2(TwigsBlocks.POLISHED_BLOODSTONE.get(), TwigsBlocks.POLISHED_BLOODSTONE_BRICKS.get(), 4).save(consumer);
        stonecutting(consumer, TwigsBlocks.BLOODSTONE.get(), TwigsBlocks.POLISHED_BLOODSTONE_BRICKS.get());
        stonecutting(consumer, TwigsBlocks.POLISHED_BLOODSTONE.get(), TwigsBlocks.POLISHED_BLOODSTONE_BRICKS.get());
        stairBuilder(TwigsBlocks.POLISHED_BLOODSTONE_BRICK_STAIRS.get(), Ingredient.of(TwigsBlocks.POLISHED_BLOODSTONE_BRICKS.get())).unlockedBy(getHasName(TwigsBlocks.POLISHED_BLOODSTONE_BRICKS.get()), has(TwigsBlocks.POLISHED_BLOODSTONE_BRICKS.get())).save(consumer);
        stonecutting(consumer, TwigsBlocks.BLOODSTONE.get(), TwigsBlocks.POLISHED_BLOODSTONE_BRICK_STAIRS.get());
        stonecutting(consumer, TwigsBlocks.POLISHED_BLOODSTONE.get(), TwigsBlocks.POLISHED_BLOODSTONE_BRICK_STAIRS.get());
        stonecutting(consumer, TwigsBlocks.POLISHED_BLOODSTONE_BRICKS.get(), TwigsBlocks.POLISHED_BLOODSTONE_BRICK_STAIRS.get());
        slab(consumer, TwigsBlocks.POLISHED_BLOODSTONE_BRICK_SLAB.get(), TwigsBlocks.POLISHED_BLOODSTONE_BRICKS.get());
        stonecutting(consumer, TwigsBlocks.BLOODSTONE.get(), TwigsBlocks.POLISHED_BLOODSTONE_BRICK_SLAB.get(), 2);
        stonecutting(consumer, TwigsBlocks.POLISHED_BLOODSTONE.get(), TwigsBlocks.POLISHED_BLOODSTONE_BRICK_SLAB.get(), 2);
        stonecutting(consumer, TwigsBlocks.POLISHED_BLOODSTONE_BRICKS.get(), TwigsBlocks.POLISHED_BLOODSTONE_BRICK_SLAB.get(), 2);
        wall(consumer, TwigsBlocks.POLISHED_BLOODSTONE_BRICK_WALL.get(), TwigsBlocks.POLISHED_BLOODSTONE_BRICKS.get());
        stonecutting(consumer, TwigsBlocks.BLOODSTONE.get(), TwigsBlocks.POLISHED_BLOODSTONE_BRICK_WALL.get());
        stonecutting(consumer, TwigsBlocks.POLISHED_BLOODSTONE.get(), TwigsBlocks.POLISHED_BLOODSTONE_BRICK_WALL.get());
        stonecutting(consumer, TwigsBlocks.POLISHED_BLOODSTONE_BRICKS.get(), TwigsBlocks.POLISHED_BLOODSTONE_BRICK_WALL.get());

        SimpleCookingRecipeBuilder.smelting(Ingredient.of(TwigsBlocks.POLISHED_BLOODSTONE_BRICKS.get()), TwigsBlocks.CRACKED_POLISHED_BLOODSTONE_BRICKS.get(), 0.1F, 200).unlockedBy(getHasName(TwigsBlocks.POLISHED_BLOODSTONE_BRICKS.get()), has(TwigsBlocks.POLISHED_BLOODSTONE_BRICKS.get())).save(consumer);

        ShapedRecipeBuilder.shaped(TwigsBlocks.STRIPPED_BAMBOO_SIGN.get(), 3)
                .define('#', TwigsBlocks.STRIPPED_BAMBOO_PLANKS.get())
                .define('X', Items.STICK)
                .pattern("###")
                .pattern("###")
                .pattern(" X ")
                .unlockedBy(getHasName(TwigsBlocks.STRIPPED_BAMBOO_PLANKS.get()), has(TwigsBlocks.STRIPPED_BAMBOO_PLANKS.get())).save(consumer);

        verticalSlab(consumer, TwigsBlocks.BAMBOO_THATCH_VERTICAL_SLAB.get(), TwigsBlocks.BAMBOO_THATCH_SLAB.get());
        verticalSlab(consumer, TwigsBlocks.STRIPPED_BAMBOO_PLANKS_VERTICAL_SLAB.get(), TwigsBlocks.STRIPPED_BAMBOO_SLAB.get());
        verticalSlab(consumer, TwigsBlocks.MOSSY_BRICK_VERTICAL_SLAB.get(), TwigsBlocks.MOSSY_BRICK_SLAB.get());
        verticalSlab(consumer, TwigsBlocks.SMOOTH_BASALT_BRICK_VERTICAL_SLAB.get(), TwigsBlocks.SMOOTH_BASALT_BRICK_SLAB.get());
        verticalSlab(consumer, TwigsBlocks.COBBLESTONE_BRICK_VERTICAL_SLAB.get(), TwigsBlocks.COBBLESTONE_BRICK_SLAB.get());
        verticalSlab(consumer, TwigsBlocks.MOSSY_COBBLESTONE_BRICK_VERTICAL_SLAB.get(), TwigsBlocks.MOSSY_COBBLESTONE_BRICK_SLAB.get());
        verticalSlab(consumer, TwigsBlocks.POLISHED_AMETHYST_BRICK_VERTICAL_SLAB.get(), TwigsBlocks.POLISHED_AMETHYST_BRICK_SLAB.get());
        verticalSlab(consumer, TwigsBlocks.POLISHED_AMETHYST_VERTICAL_SLAB.get(), TwigsBlocks.POLISHED_AMETHYST_SLAB.get());
        verticalSlab(consumer, TwigsBlocks.TWISTING_POLISHED_BLACKSTONE_BRICK_VERTICAL_SLAB.get(), TwigsBlocks.TWISTING_POLISHED_BLACKSTONE_BRICK_SLAB.get());
        verticalSlab(consumer, TwigsBlocks.WEEPING_POLISHED_BLACKSTONE_BRICK_VERTICAL_SLAB.get(), TwigsBlocks.WEEPING_POLISHED_BLACKSTONE_BRICK_SLAB.get());
        verticalSlab(consumer, TwigsBlocks.TUFF_VERTICAL_SLAB.get(), TwigsBlocks.TUFF_SLAB.get());
        verticalSlab(consumer, TwigsBlocks.POLISHED_TUFF_VERTICAL_SLAB.get(), TwigsBlocks.POLISHED_TUFF_SLAB.get());
        verticalSlab(consumer, TwigsBlocks.POLISHED_TUFF_BRICK_VERTICAL_SLAB.get(), TwigsBlocks.POLISHED_TUFF_BRICK_SLAB.get());
        verticalSlab(consumer, TwigsBlocks.CALCITE_VERTICAL_SLAB.get(), TwigsBlocks.CALCITE_SLAB.get());
        verticalSlab(consumer, TwigsBlocks.POLISHED_CALCITE_VERTICAL_SLAB.get(), TwigsBlocks.POLISHED_CALCITE_SLAB.get());
        verticalSlab(consumer, TwigsBlocks.POLISHED_CALCITE_BRICK_VERTICAL_SLAB.get(), TwigsBlocks.POLISHED_CALCITE_BRICK_SLAB.get());
        verticalSlab(consumer, TwigsBlocks.RHYOLITE_VERTICAL_SLAB.get(), TwigsBlocks.RHYOLITE_SLAB.get());
        verticalSlab(consumer, TwigsBlocks.POLISHED_RHYOLITE_VERTICAL_SLAB.get(), TwigsBlocks.POLISHED_RHYOLITE_SLAB.get());
        verticalSlab(consumer, TwigsBlocks.POLISHED_RHYOLITE_BRICK_VERTICAL_SLAB.get(), TwigsBlocks.POLISHED_RHYOLITE_BRICK_SLAB.get());
        verticalSlab(consumer, TwigsBlocks.SCHIST_VERTICAL_SLAB.get(), TwigsBlocks.SCHIST_SLAB.get());
        verticalSlab(consumer, TwigsBlocks.POLISHED_SCHIST_VERTICAL_SLAB.get(), TwigsBlocks.POLISHED_SCHIST_SLAB.get());
        verticalSlab(consumer, TwigsBlocks.POLISHED_SCHIST_BRICK_VERTICAL_SLAB.get(), TwigsBlocks.POLISHED_SCHIST_BRICK_SLAB.get());
        verticalSlab(consumer, TwigsBlocks.BLOODSTONE_VERTICAL_SLAB.get(), TwigsBlocks.BLOODSTONE_SLAB.get());
        verticalSlab(consumer, TwigsBlocks.POLISHED_BLOODSTONE_VERTICAL_SLAB.get(), TwigsBlocks.POLISHED_BLOODSTONE_SLAB.get());
        verticalSlab(consumer, TwigsBlocks.POLISHED_BLOODSTONE_BRICK_VERTICAL_SLAB.get(), TwigsBlocks.POLISHED_BLOODSTONE_BRICK_SLAB.get());
    }

    private void verticalSlab(Consumer<FinishedRecipe> consumer, Block verticalSlab, Block ingredient) {
        ShapedRecipeBuilder.shaped(verticalSlab, 3).define('#', ingredient).pattern("#").pattern("#").pattern("#").unlockedBy(getHasName(ingredient), has(ingredient)).save(consumer);
        stonecutting(consumer, ingredient, verticalSlab);
    }

    private void wall(Consumer<FinishedRecipe> consumer, Block wall, Block ingredient) {
        ShapedRecipeBuilder.shaped(wall, 6)
                .define('#', ingredient)
                .pattern("###")
                .pattern("###")
                .unlockedBy(getHasName(ingredient), has(ingredient)).save(consumer);
    }

    public static ShapedRecipeBuilder sandwich(ItemLike outside, ItemLike inside, ItemLike to, int count) {
        return ShapedRecipeBuilder.shaped(to, count)
                .define('#', outside)
                .define('X', inside)
                .pattern("###")
                .pattern("XXX")
                .pattern("###")
                .unlockedBy(getHasName(outside), has(outside))
                .unlockedBy(getHasName(inside), has(inside));
    }

    static ShapelessRecipeBuilder planks(ItemLike from, ItemLike to) {
        return ShapelessRecipeBuilder.shapeless(to, 4)
                .requires(from)
                .group("planks")
                .unlockedBy(getHasName(from), has(from));
    }

    static ShapedRecipeBuilder generic3x1(ItemLike from, ItemLike to, int count) {
        return ShapedRecipeBuilder.shaped(to, count)
                .define('#', from)
                .pattern("###")
                .unlockedBy(getHasName(from), has(from));
    }

    static ShapedRecipeBuilder ringSurrounding(ItemLike outside, ItemLike inside, ItemLike to, int count) {
        return ShapedRecipeBuilder.shaped(to, count)
                .define('#', outside)
                .define('X', inside)
                .pattern("###")
                .pattern("#X#")
                .pattern("###")
                .unlockedBy(getHasName(outside), has(outside))
                .unlockedBy(getHasName(inside), has(inside));
    }

    public static ShapelessRecipeBuilder azaleaConversion(Item from, Item to) {
        return ShapelessRecipeBuilder.shapeless(to)
                .requires(from)
                .requires(TwigsBlocks.AZALEA_FLOWERS.get(), 3)
                .unlockedBy(getHasName(TwigsBlocks.AZALEA_FLOWERS.get()), has(TwigsBlocks.AZALEA_FLOWERS.get()));
    }

    public static ShapelessRecipeBuilder paperLantern(Item content, Item lantern) {
        return ShapelessRecipeBuilder.shapeless(lantern)
                .group("paper_lantern")
                .requires(content)
                .requires(TwigsBlocks.PAPER_LANTERN.get())
                .unlockedBy(getHasName(content), has(content))
                .unlockedBy(getHasName(TwigsBlocks.PAPER_LANTERN.get()), has(TwigsBlocks.PAPER_LANTERN.get()));
    }

    public static ShapedRecipeBuilder lamp(Item torch, Item lamp) {
        return ShapedRecipeBuilder.shaped(lamp)
                .group("lamp")
                .pattern("###")
                .pattern("NTN")
                .pattern("NCN")
                .define('#', Items.IRON_INGOT)
                .define('N', Items.IRON_NUGGET)
                .define('T', torch)
                .define('C', ItemTags.COALS)
                .unlockedBy(getHasName(Items.IRON_INGOT), has(Items.IRON_INGOT))
                .unlockedBy(getHasName(Items.IRON_NUGGET), has(Items.IRON_NUGGET))
                .unlockedBy(getHasName(torch), has(torch))
                .unlockedBy("has_coal", has(ItemTags.COALS));
    }

    public static ShapedRecipeBuilder table(Item table, Item planks, Item slab) {
        return ShapedRecipeBuilder.shaped(table)
                .group("table")
                .pattern("SSS")
                .pattern("P P")
                .pattern("P P")
                .define('S', slab)
                .define('P', planks)
                .unlockedBy(getHasName(planks), has(planks))
                .unlockedBy(getHasName(slab), has(slab));
    }

    public static ShapedRecipeBuilder eye(Item output, Item inside, Item outside, int count) {
        return ShapedRecipeBuilder.shaped(output, count)
                .pattern(" # ")
                .pattern("#X#")
                .pattern(" # ")
                .define('X', inside)
                .define('#', outside)
                .unlockedBy(getHasName(inside), has(inside))
                .unlockedBy(getHasName(outside), has(outside));
    }

    static ShapelessRecipeBuilder shapeless(ItemLike one, ItemLike two, ItemLike to, int count) {
        return ShapelessRecipeBuilder.shapeless(to, count).requires(one).requires(two).unlockedBy(getHasName(one), has(one)).unlockedBy(getHasName(two), has(two));
    }

    static ShapelessRecipeBuilder shapeless(ItemLike from, ItemLike to, int count) {
        return ShapelessRecipeBuilder.shapeless(to, count).requires(from).unlockedBy(getHasName(from), has(from));
    }

    static ShapedRecipeBuilder generic3x3(ItemLike from, ItemLike to, int count) {
        return ShapedRecipeBuilder.shaped(to, count)
                .define('#', from)
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .unlockedBy(getHasName(from), has(from));
    }

    private ShapedRecipeBuilder generic2x2(ItemLike from, ItemLike to, int count) {
        return ShapedRecipeBuilder.shaped(to, count)
                .define('#', from)
                .pattern("##")
                .pattern("##")
                .unlockedBy(getHasName(from), has(from));
    }

    public ShapedRecipeBuilder chequer2x2(ItemLike one, ItemLike two, ItemLike to, int count) {
        return ShapedRecipeBuilder.shaped(to, count)
                .define('#', one)
                .define('X', two)
                .pattern("#X")
                .pattern("X#")
                .unlockedBy(getHasName(one), has(one))
                .unlockedBy(getHasName(two), has(two));
    }

    private static SingleItemRecipeBuilder stonecutSave(ItemLike from, ItemLike to) {
        return stonecutSave(from, to, 1);
    }

    private static SingleItemRecipeBuilder stonecutSave(ItemLike from, ItemLike to, int count) {
        return SingleItemRecipeBuilder.stonecutting(Ingredient.of(from), to, count).unlockedBy(getHasName(from), has(from));
    }

    private static void stonecutting(Consumer<FinishedRecipe> consumer, ItemLike from, ItemLike to, int count) {
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(from), to, count).unlockedBy(getHasName(from), has(from)).save(consumer, conversionFileName(to, from) + "_stonecutting");
    }

    private static void stonecutting(Consumer<FinishedRecipe> consumer, ItemLike from, ItemLike to) {
        stonecutting(consumer, from, to, 1);
    }

    @NotNull
    private static ResourceLocation conversionFileName(ItemLike to, ItemLike from) {
        return new ResourceLocation(Twigs.MOD_ID, getConversionRecipeName(to, from));
    }
}
