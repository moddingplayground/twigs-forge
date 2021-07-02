package com.ninni.twigs.init;


import com.ninni.twigs.Twigs;
import com.ninni.twigs.block.BambooMatBlock;
import com.ninni.twigs.block.LampBlock;
import com.ninni.twigs.block.PaperLanternBlock;
import com.ninni.twigs.block.vanilla.*;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.state.property.Properties;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

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
    public static final Block SCHIST = register("schist", new Block(FabricBlockSettings.copyOf(Blocks.CALCITE).breakByTool(FabricToolTags.PICKAXES)));
    public static final Block SCHIST_STAIRS = register("schist_stairs", new PublicStairsBlock(SCHIST.getDefaultState(), FabricBlockSettings.copyOf(SCHIST)));
    public static final Block SCHIST_SLAB = register("schist_slab", new SlabBlock(FabricBlockSettings.copyOf(SCHIST)));
    public static final Block SCHIST_WALL = register("schist_wall", new WallBlock(FabricBlockSettings.copyOf(SCHIST)));
    public static final Block POLISHED_SCHIST = register("polished_schist", new Block(FabricBlockSettings.copyOf(SCHIST).breakByTool(FabricToolTags.PICKAXES)));
    public static final Block POLISHED_SCHIST_STAIRS = register("polished_schist_stairs", new PublicStairsBlock(POLISHED_SCHIST.getDefaultState(), FabricBlockSettings.copyOf(POLISHED_SCHIST)));
    public static final Block POLISHED_SCHIST_SLAB = register("polished_schist_slab", new SlabBlock(FabricBlockSettings.copyOf(POLISHED_SCHIST)));
    public static final Block POLISHED_SCHIST_BRICKS = register("polished_schist_bricks", new Block(FabricBlockSettings.copyOf(SCHIST).breakByTool(FabricToolTags.PICKAXES)));
    public static final Block POLISHED_SCHIST_BRICK_STAIRS = register("polished_schist_brick_stairs", new PublicStairsBlock(POLISHED_SCHIST_BRICKS.getDefaultState(), FabricBlockSettings.copyOf(POLISHED_SCHIST_BRICKS)));
    public static final Block POLISHED_SCHIST_BRICK_SLAB = register("polished_schist_brick_slab", new SlabBlock(FabricBlockSettings.copyOf(POLISHED_SCHIST_BRICKS)));
    public static final Block POLISHED_SCHIST_BRICK_WALL = register("polished_schist_brick_wall", new WallBlock(FabricBlockSettings.copyOf(POLISHED_SCHIST_BRICKS)));
    public static final Block CRACKED_POLISHED_SCHIST_BRICKS = register("cracked_polished_schist_bricks", new Block(FabricBlockSettings.copyOf(POLISHED_SCHIST_BRICKS).breakByTool(FabricToolTags.PICKAXES)));
    public static final Block BLOODSTONE = register("bloodstone", new Block(FabricBlockSettings.copyOf(Blocks.BASALT).breakByTool(FabricToolTags.PICKAXES)));
    public static final Block BLOODSTONE_STAIRS = register("bloodstone_stairs", new PublicStairsBlock(BLOODSTONE.getDefaultState(), FabricBlockSettings.copyOf(BLOODSTONE)));
    public static final Block BLOODSTONE_SLAB = register("bloodstone_slab", new SlabBlock(FabricBlockSettings.copyOf(BLOODSTONE)));
    public static final Block BLOODSTONE_WALL = register("bloodstone_wall", new WallBlock(FabricBlockSettings.copyOf(BLOODSTONE)));
    public static final Block POLISHED_BLOODSTONE = register("polished_bloodstone", new Block(FabricBlockSettings.copyOf(BLOODSTONE).breakByTool(FabricToolTags.PICKAXES)));
    public static final Block POLISHED_BLOODSTONE_STAIRS = register("polished_bloodstone_stairs", new PublicStairsBlock(POLISHED_BLOODSTONE.getDefaultState(), FabricBlockSettings.copyOf(POLISHED_BLOODSTONE)));
    public static final Block POLISHED_BLOODSTONE_SLAB = register("polished_bloodstone_slab", new SlabBlock(FabricBlockSettings.copyOf(POLISHED_BLOODSTONE)));
    public static final Block POLISHED_BLOODSTONE_BRICKS = register("polished_bloodstone_bricks", new Block(FabricBlockSettings.copyOf(BLOODSTONE).breakByTool(FabricToolTags.PICKAXES)));
    public static final Block POLISHED_BLOODSTONE_BRICK_STAIRS = register("polished_bloodstone_brick_stairs", new PublicStairsBlock(POLISHED_BLOODSTONE_BRICKS.getDefaultState(), FabricBlockSettings.copyOf(POLISHED_BLOODSTONE_BRICKS)));
    public static final Block POLISHED_BLOODSTONE_BRICK_SLAB = register("polished_bloodstone_brick_slab", new SlabBlock(FabricBlockSettings.copyOf(POLISHED_BLOODSTONE_BRICKS)));
    public static final Block POLISHED_BLOODSTONE_BRICK_WALL = register("polished_bloodstone_brick_wall", new WallBlock(FabricBlockSettings.copyOf(POLISHED_BLOODSTONE_BRICKS)));
    public static final Block CRACKED_POLISHED_BLOODSTONE_BRICKS = register("cracked_polished_bloodstone_bricks", new Block(FabricBlockSettings.copyOf(POLISHED_BLOODSTONE_BRICKS).breakByTool(FabricToolTags.PICKAXES)));
    public static final Block RHYOLITE = register("rhyolite", new PillarBlock(FabricBlockSettings.copyOf(Blocks.DEEPSLATE).breakByTool(FabricToolTags.PICKAXES)));
    public static final Block RHYOLITE_STAIRS = register("rhyolite_stairs", new PublicStairsBlock(RHYOLITE.getDefaultState(), FabricBlockSettings.copyOf(RHYOLITE)));
    public static final Block RHYOLITE_SLAB = register("rhyolite_slab", new SlabBlock(FabricBlockSettings.copyOf(RHYOLITE)));
    public static final Block RHYOLITE_WALL = register("rhyolite_wall", new WallBlock(FabricBlockSettings.copyOf(RHYOLITE)));
    public static final Block POLISHED_RHYOLITE = register("polished_rhyolite", new Block(FabricBlockSettings.copyOf(RHYOLITE).breakByTool(FabricToolTags.PICKAXES)));
    public static final Block POLISHED_RHYOLITE_STAIRS = register("polished_rhyolite_stairs", new PublicStairsBlock(POLISHED_RHYOLITE.getDefaultState(), FabricBlockSettings.copyOf(POLISHED_RHYOLITE)));
    public static final Block POLISHED_RHYOLITE_SLAB = register("polished_rhyolite_slab", new SlabBlock(FabricBlockSettings.copyOf(POLISHED_RHYOLITE)));
    public static final Block POLISHED_RHYOLITE_BRICKS = register("polished_rhyolite_bricks", new Block(FabricBlockSettings.copyOf(RHYOLITE).breakByTool(FabricToolTags.PICKAXES)));
    public static final Block POLISHED_RHYOLITE_BRICK_STAIRS = register("polished_rhyolite_brick_stairs", new PublicStairsBlock(POLISHED_RHYOLITE_BRICKS.getDefaultState(), FabricBlockSettings.copyOf(POLISHED_RHYOLITE_BRICKS)));
    public static final Block POLISHED_RHYOLITE_BRICK_SLAB = register("polished_rhyolite_brick_slab", new SlabBlock(FabricBlockSettings.copyOf(POLISHED_RHYOLITE_BRICKS)));
    public static final Block POLISHED_RHYOLITE_BRICK_WALL = register("polished_rhyolite_brick_wall", new WallBlock(FabricBlockSettings.copyOf(POLISHED_RHYOLITE_BRICKS)));
    public static final Block CRACKED_POLISHED_RHYOLITE_BRICKS = register("cracked_polished_rhyolite_bricks", new Block(FabricBlockSettings.copyOf(POLISHED_RHYOLITE_BRICKS).breakByTool(FabricToolTags.PICKAXES)));
    public static final Block TUFF_STAIRS = register("tuff_stairs", new PublicStairsBlock(Blocks.TUFF.getDefaultState(), FabricBlockSettings.copyOf(Blocks.BASALT)));
    public static final Block TUFF_SLAB = register("tuff_slab", new SlabBlock(FabricBlockSettings.copyOf(Blocks.TUFF)));
    public static final Block TUFF_WALL = register("tuff_wall", new WallBlock(FabricBlockSettings.copyOf(Blocks.TUFF)));
    public static final Block POLISHED_TUFF = register("polished_tuff", new Block(FabricBlockSettings.copyOf(Blocks.TUFF).breakByTool(FabricToolTags.PICKAXES)));
    public static final Block POLISHED_TUFF_STAIRS = register("polished_tuff_stairs", new PublicStairsBlock(POLISHED_TUFF.getDefaultState(), FabricBlockSettings.copyOf(POLISHED_TUFF)));
    public static final Block POLISHED_TUFF_SLAB = register("polished_tuff_slab", new SlabBlock(FabricBlockSettings.copyOf(POLISHED_TUFF)));
    public static final Block POLISHED_TUFF_BRICKS = register("polished_tuff_bricks", new Block(FabricBlockSettings.copyOf(Blocks.TUFF).breakByTool(FabricToolTags.PICKAXES)));
    public static final Block POLISHED_TUFF_BRICK_STAIRS = register("polished_tuff_brick_stairs", new PublicStairsBlock(POLISHED_TUFF_BRICKS.getDefaultState(), FabricBlockSettings.copyOf(POLISHED_TUFF_BRICKS)));
    public static final Block POLISHED_TUFF_BRICK_SLAB = register("polished_tuff_brick_slab", new SlabBlock(FabricBlockSettings.copyOf(POLISHED_TUFF_BRICKS)));
    public static final Block POLISHED_TUFF_BRICK_WALL = register("polished_tuff_brick_wall", new WallBlock(FabricBlockSettings.copyOf(POLISHED_TUFF_BRICKS)));
    public static final Block CRACKED_POLISHED_TUFF_BRICKS = register("cracked_polished_tuff_bricks", new Block(FabricBlockSettings.copyOf(POLISHED_TUFF_BRICKS).breakByTool(FabricToolTags.PICKAXES)));
    public static final Block CALCITE_STAIRS = register("calcite_stairs", new PublicStairsBlock(Blocks.CALCITE.getDefaultState(), FabricBlockSettings.copyOf(Blocks.CALCITE)));
    public static final Block CALCITE_SLAB = register("calcite_slab", new SlabBlock(FabricBlockSettings.copyOf(Blocks.CALCITE)));
    public static final Block CALCITE_WALL = register("calcite_wall", new WallBlock(FabricBlockSettings.copyOf(Blocks.CALCITE)));
    public static final Block POLISHED_CALCITE = register("polished_calcite", new Block(FabricBlockSettings.copyOf(Blocks.CALCITE).breakByTool(FabricToolTags.PICKAXES)));
    public static final Block POLISHED_CALCITE_STAIRS = register("polished_calcite_stairs", new PublicStairsBlock(POLISHED_CALCITE.getDefaultState(), FabricBlockSettings.copyOf(POLISHED_CALCITE)));
    public static final Block POLISHED_CALCITE_SLAB = register("polished_calcite_slab", new SlabBlock(FabricBlockSettings.copyOf(POLISHED_CALCITE)));
    public static final Block POLISHED_CALCITE_BRICKS = register("polished_calcite_bricks", new Block(FabricBlockSettings.copyOf(Blocks.CALCITE).breakByTool(FabricToolTags.PICKAXES)));
    public static final Block POLISHED_CALCITE_BRICK_STAIRS = register("polished_calcite_brick_stairs", new PublicStairsBlock(POLISHED_CALCITE_BRICKS.getDefaultState(), FabricBlockSettings.copyOf(POLISHED_CALCITE_BRICKS)));
    public static final Block POLISHED_CALCITE_BRICK_SLAB = register("polished_calcite_brick_slab", new SlabBlock(FabricBlockSettings.copyOf(POLISHED_CALCITE_BRICKS)));
    public static final Block POLISHED_CALCITE_BRICK_WALL = register("polished_calcite_brick_wall", new WallBlock(FabricBlockSettings.copyOf(POLISHED_CALCITE_BRICKS)));
    public static final Block CRACKED_POLISHED_CALCITE_BRICKS = register("cracked_polished_calcite_bricks", new Block(FabricBlockSettings.copyOf(POLISHED_CALCITE_BRICKS).breakByTool(FabricToolTags.PICKAXES)));
    public static final Block STRIPPED_BAMBOO = register("stripped_bamboo", new ChainBlock(FabricBlockSettings.copyOf(Blocks.BAMBOO).breakByTool(FabricToolTags.AXES)));
    public static final Block STRIPPED_BUNDLED_BAMBOO = register("stripped_bundled_bamboo", new PillarBlock(FabricBlockSettings.copyOf(Blocks.OAK_PLANKS).sounds(BlockSoundGroup.SCAFFOLDING)));
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
    public static final Block BUNDLED_BAMBOO = register("bundled_bamboo", new PillarBlock(FabricBlockSettings.copyOf(Blocks.OAK_PLANKS).sounds(BlockSoundGroup.SCAFFOLDING)));
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