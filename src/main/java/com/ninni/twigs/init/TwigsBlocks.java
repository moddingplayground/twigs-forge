package com.ninni.twigs.init;


import com.ninni.twigs.Twigs;
import com.ninni.twigs.block.vanilla.PublicStairsBlock;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

@SuppressWarnings("unused")
public class TwigsBlocks {
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