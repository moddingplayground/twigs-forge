package com.ninni.twigs.init;


import com.ninni.twigs.Twigs;
import com.ninni.twigs.block.BambooMatBlock;
import com.ninni.twigs.block.LampBlock;
import com.ninni.twigs.block.PaperLanternBlock;
import com.ninni.twigs.block.StrippedBamboo;
import com.ninni.twigs.block.vanilla.*;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.state.property.Properties;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.BlockView;

import java.util.function.ToIntFunction;

@SuppressWarnings("unused")
public class TwigsBlocks {
    public static final Block LAMP = register("lamp", new LampBlock(AbstractBlock.Settings.of(Material.METAL).requiresTool().strength(4.5F).sounds(BlockSoundGroup.LANTERN).luminance(createLightLevelFromLitBlockState(18))));
    public static final Block SOUL_LAMP = register("soul_lamp", new LampBlock(FabricBlockSettings.copyOf(TwigsBlocks.LAMP).luminance(createLightLevelFromLitBlockState(17)).breakByTool(FabricToolTags.PICKAXES)));
    public static final Block CHISELED_BRICKS = register("chiseled_bricks", new Block(FabricBlockSettings.copyOf(Blocks.BRICKS).breakByTool(FabricToolTags.PICKAXES)));
    public static final Block CRACKED_BRICKS = register("cracked_bricks", new Block(FabricBlockSettings.copyOf(Blocks.BRICKS).breakByTool(FabricToolTags.PICKAXES)));
    public static final Block MOSSY_BRICKS = register("mossy_bricks", new Block(FabricBlockSettings.copyOf(Blocks.BRICKS).breakByTool(FabricToolTags.PICKAXES)));
    public static final Block MOSSY_BRICK_STAIRS = register("mossy_brick_stairs", new PublicStairsBlock(MOSSY_BRICKS.getDefaultState(), FabricBlockSettings.copyOf(MOSSY_BRICKS)));
    public static final Block MOSSY_BRICK_SLAB = register("mossy_brick_slab", new SlabBlock(FabricBlockSettings.copyOf(MOSSY_BRICKS)));
    public static final Block MOSSY_BRICK_WALL = register("mossy_brick_wall", new WallBlock(FabricBlockSettings.copyOf(MOSSY_BRICKS)));
    public static final Block POLISHED_BASALT_BRICKS = register("polished_basalt_bricks", new PillarBlock(FabricBlockSettings.copyOf(Blocks.POLISHED_BASALT)));
    public static final Block SMOOTH_BASALT_BRICKS = register("smooth_basalt_bricks", new Block(FabricBlockSettings.copyOf(Blocks.SMOOTH_BASALT).breakByTool(FabricToolTags.PICKAXES)));
    public static final Block SMOOTH_BASALT_BRICK_STAIRS = register("smooth_basalt_brick_stairs", new PublicStairsBlock(SMOOTH_BASALT_BRICKS.getDefaultState(), FabricBlockSettings.copyOf(SMOOTH_BASALT_BRICKS)));
    public static final Block SMOOTH_BASALT_BRICK_SLAB = register("smooth_basalt_brick_slab", new SlabBlock(FabricBlockSettings.copyOf(SMOOTH_BASALT_BRICKS)));
    public static final Block SMOOTH_BASALT_BRICK_WALL = register("smooth_basalt_brick_wall", new WallBlock(FabricBlockSettings.copyOf(SMOOTH_BASALT_BRICKS)));
    public static final Block COBBLESTONE_BRICKS = register("cobblestone_bricks", new Block(FabricBlockSettings.copyOf(Blocks.COBBLESTONE).breakByTool(FabricToolTags.PICKAXES)));
    public static final Block COBBLESTONE_BRICK_STAIRS = register("cobblestone_brick_stairs", new PublicStairsBlock(COBBLESTONE_BRICKS.getDefaultState(), FabricBlockSettings.copyOf(COBBLESTONE_BRICKS)));
    public static final Block COBBLESTONE_BRICK_SLAB = register("cobblestone_brick_slab", new SlabBlock(FabricBlockSettings.copyOf(COBBLESTONE_BRICKS)));
    public static final Block COBBLESTONE_BRICK_WALL = register("cobblestone_brick_wall", new WallBlock(FabricBlockSettings.copyOf(COBBLESTONE_BRICKS)));
    public static final Block CRACKED_COBBLESTONE_BRICKS = register("cracked_cobblestone_bricks", new Block(FabricBlockSettings.copyOf(Blocks.COBBLESTONE).breakByTool(FabricToolTags.PICKAXES)));
    public static final Block MOSSY_COBBLESTONE_BRICKS = register("mossy_cobblestone_bricks", new Block(FabricBlockSettings.copyOf(Blocks.COBBLESTONE).breakByTool(FabricToolTags.PICKAXES)));
    public static final Block MOSSY_COBBLESTONE_BRICK_STAIRS = register("mossy_cobblestone_brick_stairs", new PublicStairsBlock(COBBLESTONE_BRICKS.getDefaultState(), FabricBlockSettings.copyOf(COBBLESTONE_BRICKS)));
    public static final Block MOSSY_COBBLESTONE_BRICK_SLAB = register("mossy_cobblestone_brick_slab", new SlabBlock(FabricBlockSettings.copyOf(COBBLESTONE_BRICKS)));
    public static final Block MOSSY_COBBLESTONE_BRICK_WALL = register("mossy_cobblestone_brick_wall", new WallBlock(FabricBlockSettings.copyOf(COBBLESTONE_BRICKS)));
    public static final Block POLISHED_AMETHYST_BRICKS = register("polished_amethyst_bricks", new Block(FabricBlockSettings.copyOf(Blocks.AMETHYST_BLOCK).breakByTool(FabricToolTags.PICKAXES)));
    public static final Block POLISHED_AMETHYST_BRICK_STAIRS = register("polished_amethyst_brick_stairs", new PublicStairsBlock(POLISHED_AMETHYST_BRICKS.getDefaultState(), FabricBlockSettings.copyOf(POLISHED_AMETHYST_BRICKS)));
    public static final Block POLISHED_AMETHYST_BRICK_SLAB = register("polished_amethyst_brick_slab", new SlabBlock(FabricBlockSettings.copyOf(POLISHED_AMETHYST_BRICKS)));
    public static final Block POLISHED_AMETHYST_BRICK_WALL = register("polished_amethyst_brick_wall", new WallBlock(FabricBlockSettings.copyOf(POLISHED_AMETHYST_BRICKS)));
    public static final Block CRACKED_POLISHED_AMETHYST_BRICKS = register("cracked_polished_amethyst_bricks", new Block(FabricBlockSettings.copyOf(Blocks.AMETHYST_BLOCK).breakByTool(FabricToolTags.PICKAXES)));
    public static final Block POLISHED_AMETHYST = register("polished_amethyst", new Block(FabricBlockSettings.copyOf(Blocks.AMETHYST_BLOCK).breakByTool(FabricToolTags.PICKAXES)));
    public static final Block CHISELED_POLISHED_AMETHYST = register("chiseled_polished_amethyst", new Block(FabricBlockSettings.copyOf(Blocks.AMETHYST_BLOCK).breakByTool(FabricToolTags.PICKAXES)));
    public static final Block POLISHED_AMETHYST_STAIRS = register("polished_amethyst_stairs", new PublicStairsBlock(POLISHED_AMETHYST.getDefaultState(), FabricBlockSettings.copyOf(POLISHED_AMETHYST)));
    public static final Block POLISHED_AMETHYST_SLAB = register("polished_amethyst_slab", new SlabBlock(FabricBlockSettings.copyOf(POLISHED_AMETHYST)));
    public static final Block TWISTING_POLISHED_BLACKSTONE_BRICKS = register("twisting_polished_blackstone_bricks", new Block(FabricBlockSettings.copyOf(Blocks.POLISHED_BLACKSTONE_BRICKS).breakByTool(FabricToolTags.PICKAXES)));
    public static final Block TWISTING_POLISHED_BLACKSTONE_BRICK_STAIRS = register("twisting_polished_blackstone_brick_stairs", new PublicStairsBlock(TWISTING_POLISHED_BLACKSTONE_BRICKS.getDefaultState(), FabricBlockSettings.copyOf(TWISTING_POLISHED_BLACKSTONE_BRICKS)));
    public static final Block TWISTING_POLISHED_BLACKSTONE_BRICK_SLAB = register("twisting_polished_blackstone_brick_slab", new SlabBlock(FabricBlockSettings.copyOf(TWISTING_POLISHED_BLACKSTONE_BRICKS)));
    public static final Block TWISTING_POLISHED_BLACKSTONE_BRICK_WALL = register("twisting_polished_blackstone_brick_wall", new WallBlock(FabricBlockSettings.copyOf(TWISTING_POLISHED_BLACKSTONE_BRICKS)));
    public static final Block WEEPING_POLISHED_BLACKSTONE_BRICKS = register("weeping_polished_blackstone_bricks", new Block(FabricBlockSettings.copyOf(Blocks.POLISHED_BLACKSTONE_BRICKS).breakByTool(FabricToolTags.PICKAXES)));
    public static final Block WEEPING_POLISHED_BLACKSTONE_BRICK_STAIRS = register("weeping_polished_blackstone_brick_stairs", new PublicStairsBlock(WEEPING_POLISHED_BLACKSTONE_BRICKS.getDefaultState(), FabricBlockSettings.copyOf(WEEPING_POLISHED_BLACKSTONE_BRICKS)));
    public static final Block WEEPING_POLISHED_BLACKSTONE_BRICK_SLAB = register("weeping_polished_blackstone_brick_slab", new SlabBlock(FabricBlockSettings.copyOf(WEEPING_POLISHED_BLACKSTONE_BRICKS)));
    public static final Block WEEPING_POLISHED_BLACKSTONE_BRICK_WALL = register("weeping_polished_blackstone_brick_wall", new WallBlock(FabricBlockSettings.copyOf(WEEPING_POLISHED_BLACKSTONE_BRICKS)));
    public static final Block PAPER_LANTERN = register("paper_lantern", new PaperLanternBlock(FabricBlockSettings.copyOf(AbstractBlock.Settings.of(Material.WOOL).strength(0.5f, 0.0f).sounds(BlockSoundGroup.WOOL).blockVision(AbstractBlock.AbstractBlockState::hasEmissiveLighting).luminance(value -> 10).nonOpaque())));
    public static final Block ALLIUM_PAPER_LANTERN = register("allium_paper_lantern", new PaperLanternBlock(FabricBlockSettings.copyOf(AbstractBlock.Settings.of(Material.WOOL).strength(0.5f, 0.0f).sounds(BlockSoundGroup.WOOL).blockVision(AbstractBlock.AbstractBlockState::hasEmissiveLighting).luminance(value -> 10).nonOpaque())));
    public static final Block BLUE_ORCHID_PAPER_LANTERN = register("blue_orchid_paper_lantern", new PaperLanternBlock(FabricBlockSettings.copyOf(AbstractBlock.Settings.of(Material.WOOL).strength(0.5f, 0.0f).sounds(BlockSoundGroup.WOOL).blockVision(AbstractBlock.AbstractBlockState::hasEmissiveLighting).luminance(value -> 10).nonOpaque())));
    public static final Block CRIMSON_ROOTS_PAPER_LANTERN = register("crimson_roots_paper_lantern", new PaperLanternBlock(FabricBlockSettings.copyOf(AbstractBlock.Settings.of(Material.WOOL).strength(0.5f, 0.0f).sounds(BlockSoundGroup.WOOL).blockVision(AbstractBlock.AbstractBlockState::hasEmissiveLighting).luminance(value -> 10).nonOpaque())));
    public static final Block DANDELION_PAPER_LANTERN = register("dandelion_paper_lantern", new PaperLanternBlock(FabricBlockSettings.copyOf(AbstractBlock.Settings.of(Material.WOOL).strength(0.5f, 0.0f).sounds(BlockSoundGroup.WOOL).blockVision(AbstractBlock.AbstractBlockState::hasEmissiveLighting).luminance(value -> 10).nonOpaque())));
    public static final Block ROCKY_DIRT = register("rocky_dirt", new Block(FabricBlockSettings.copyOf(Blocks.DIRT).breakByTool(FabricToolTags.SHOVELS)));
    public static final Block STRIPPED_BAMBOO = register("stripped_bamboo", new StrippedBamboo(FabricBlockSettings.copyOf(Blocks.BAMBOO).breakByTool(FabricToolTags.AXES)));
    public static final Block STRIPPED_BAMBOO_MAT = register("stripped_bamboo_mat", new BambooMatBlock(FabricBlockSettings.copyOf(Blocks.WHITE_CARPET).sounds(BlockSoundGroup.SCAFFOLDING)));
    public static final Block STRIPPED_BAMBOO_PLANKS = register("stripped_bamboo_planks", new Block(FabricBlockSettings.copyOf(Blocks.OAK_PLANKS).sounds(BlockSoundGroup.SCAFFOLDING)));
    public static final Block STRIPPED_BAMBOO_STAIRS = register("stripped_bamboo_stairs", new PublicStairsBlock(STRIPPED_BAMBOO_PLANKS.getDefaultState(), FabricBlockSettings.copyOf(STRIPPED_BAMBOO_PLANKS)));
    public static final Block STRIPPED_BAMBOO_SLAB = register("stripped_bamboo_slab", new SlabBlock(FabricBlockSettings.copyOf(STRIPPED_BAMBOO_PLANKS)));
    public static final Block STRIPPED_BAMBOO_FENCE = register("stripped_bamboo_fence", new FenceBlock(FabricBlockSettings.copyOf(STRIPPED_BAMBOO_PLANKS)));
    public static final Block STRIPPED_BAMBOO_FENCE_GATE = register("stripped_bamboo_fence_gate", new FenceGateBlock(FabricBlockSettings.copyOf(STRIPPED_BAMBOO_PLANKS)));
    public static final Block STRIPPED_BAMBOO_DOOR = register("stripped_bamboo_door", new PublicDoorBlock(FabricBlockSettings.copyOf(STRIPPED_BAMBOO_PLANKS)));
    public static final Block STRIPPED_BAMBOO_TRAPDOOR = register("stripped_bamboo_trapdoor", new PublicTrapdoorBlock(FabricBlockSettings.copyOf(STRIPPED_BAMBOO_PLANKS)));
    public static final Block STRIPPED_BAMBOO_BUTTON = register("stripped_bamboo_button", new PublicWoodenButtonBlock(FabricBlockSettings.copyOf(STRIPPED_BAMBOO_PLANKS)));
    public static final Block STRIPPED_BAMBOO_PRESSURE_PLATE = register("stripped_bamboo_pressure_plate", new PublicPressurePlateBlock(PressurePlateBlock.ActivationRule.EVERYTHING, FabricBlockSettings.copyOf(STRIPPED_BAMBOO_PLANKS)));
    public static final Block BAMBOO_THATCH = register("bamboo_thatch", new Block(FabricBlockSettings.copyOf(Blocks.ACACIA_LEAVES).sounds(BlockSoundGroup.GRASS).breakByTool(FabricToolTags.HOES)));
    public static final Block BAMBOO_THATCH_STAIRS = register("bamboo_thatch_stairs", new PublicStairsBlock(BAMBOO_THATCH.getDefaultState(), FabricBlockSettings.copyOf(BAMBOO_THATCH)));
    public static final Block BAMBOO_THATCH_SLAB = register("bamboo_thatch_slab", new SlabBlock(FabricBlockSettings.copyOf(BAMBOO_THATCH)));

    private static ToIntFunction<BlockState> createLightLevelFromLitBlockState(int litLevel) {
        return (state) -> (Boolean)state.get(Properties.LIT) ? litLevel : 0;
    }

    private static Block register(String id, Block block, boolean registerItem) {
        Block registered = Registry.register(Registry.BLOCK, new Identifier(Twigs.MOD_ID, id), block);
        if (registerItem) {
            Registry.register(Registry.ITEM, new Identifier(Twigs.MOD_ID, id), new BlockItem(registered, new FabricItemSettings().group(Twigs.ITEM_GROUP)));
        }
        return registered;
    }
    private static Block register(String id, Block block) {
        return register(id, block, true);
    }
}