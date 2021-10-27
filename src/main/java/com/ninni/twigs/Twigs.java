package com.ninni.twigs;

import com.google.common.reflect.Reflection;
import com.ninni.twigs.block.vanilla.PublicStairsBlock;
import com.ninni.twigs.init.TwigsBlocks;
import com.ninni.twigs.init.TwigsItems;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;

public class Twigs implements ModInitializer {
	public static final String MOD_ID = "twigs";
	public static final ItemGroup ITEM_GROUP = FabricItemGroupBuilder.build(new Identifier(Twigs.MOD_ID, "item_group"), () -> new ItemStack(Items.STICK));


	//rhyolite blocks
	public static final Block RHYOLITE = new PillarBlock(FabricBlockSettings.copyOf(Blocks.DEEPSLATE).breakByTool(FabricToolTags.PICKAXES));
	public static final Block RHYOLITE_STAIRS = new PublicStairsBlock(RHYOLITE.getDefaultState(), FabricBlockSettings.copyOf(RHYOLITE));
	public static final Block RHYOLITE_SLAB = new SlabBlock(FabricBlockSettings.copyOf(RHYOLITE));
	public static final Block RHYOLITE_WALL = new WallBlock(FabricBlockSettings.copyOf(RHYOLITE));
	public static final Block POLISHED_RHYOLITE = new Block(FabricBlockSettings.copyOf(RHYOLITE).breakByTool(FabricToolTags.PICKAXES));
	public static final Block POLISHED_RHYOLITE_STAIRS = new PublicStairsBlock(POLISHED_RHYOLITE.getDefaultState(), FabricBlockSettings.copyOf(POLISHED_RHYOLITE));
	public static final Block POLISHED_RHYOLITE_SLAB = new SlabBlock(FabricBlockSettings.copyOf(POLISHED_RHYOLITE));
	public static final Block POLISHED_RHYOLITE_BRICKS = new Block(FabricBlockSettings.copyOf(RHYOLITE).breakByTool(FabricToolTags.PICKAXES));
	public static final Block POLISHED_RHYOLITE_BRICK_STAIRS = new PublicStairsBlock(POLISHED_RHYOLITE_BRICKS.getDefaultState(), FabricBlockSettings.copyOf(POLISHED_RHYOLITE_BRICKS));
	public static final Block POLISHED_RHYOLITE_BRICK_SLAB = new SlabBlock(FabricBlockSettings.copyOf(POLISHED_RHYOLITE_BRICKS));
	public static final Block POLISHED_RHYOLITE_BRICK_WALL = new WallBlock(FabricBlockSettings.copyOf(POLISHED_RHYOLITE_BRICKS));
	public static final Block CRACKED_POLISHED_RHYOLITE_BRICKS = new Block(FabricBlockSettings.copyOf(POLISHED_RHYOLITE_BRICKS).breakByTool(FabricToolTags.PICKAXES));

	//schist blocks
	public static final Block SCHIST = new Block(FabricBlockSettings.copyOf(Blocks.CALCITE).breakByTool(FabricToolTags.PICKAXES));
	public static final Block SCHIST_STAIRS = new PublicStairsBlock(SCHIST.getDefaultState(), FabricBlockSettings.copyOf(SCHIST));
	public static final Block SCHIST_SLAB = new SlabBlock(FabricBlockSettings.copyOf(SCHIST));
	public static final Block SCHIST_WALL = new WallBlock(FabricBlockSettings.copyOf(SCHIST));
	public static final Block POLISHED_SCHIST = new Block(FabricBlockSettings.copyOf(SCHIST).breakByTool(FabricToolTags.PICKAXES));
	public static final Block POLISHED_SCHIST_STAIRS = new PublicStairsBlock(POLISHED_SCHIST.getDefaultState(), FabricBlockSettings.copyOf(POLISHED_SCHIST));
	public static final Block POLISHED_SCHIST_SLAB = new SlabBlock(FabricBlockSettings.copyOf(POLISHED_SCHIST));
	public static final Block POLISHED_SCHIST_BRICKS = new Block(FabricBlockSettings.copyOf(SCHIST).breakByTool(FabricToolTags.PICKAXES));
	public static final Block POLISHED_SCHIST_BRICK_STAIRS = new PublicStairsBlock(POLISHED_SCHIST_BRICKS.getDefaultState(), FabricBlockSettings.copyOf(POLISHED_SCHIST_BRICKS));
	public static final Block POLISHED_SCHIST_BRICK_SLAB = new SlabBlock(FabricBlockSettings.copyOf(POLISHED_SCHIST_BRICKS));
	public static final Block POLISHED_SCHIST_BRICK_WALL = new WallBlock(FabricBlockSettings.copyOf(POLISHED_SCHIST_BRICKS));
	public static final Block CRACKED_POLISHED_SCHIST_BRICKS = new Block(FabricBlockSettings.copyOf(POLISHED_SCHIST_BRICKS).breakByTool(FabricToolTags.PICKAXES));


	//bloodstone blocks
	public static final Block BLOODSTONE = new Block(FabricBlockSettings.copyOf(Blocks.BASALT).breakByTool(FabricToolTags.PICKAXES));
	public static final Block BLOODSTONE_STAIRS = new PublicStairsBlock(BLOODSTONE.getDefaultState(), FabricBlockSettings.copyOf(BLOODSTONE));
	public static final Block BLOODSTONE_SLAB = new SlabBlock(FabricBlockSettings.copyOf(BLOODSTONE));
	public static final Block BLOODSTONE_WALL = new WallBlock(FabricBlockSettings.copyOf(BLOODSTONE));
	public static final Block POLISHED_BLOODSTONE = new Block(FabricBlockSettings.copyOf(BLOODSTONE).breakByTool(FabricToolTags.PICKAXES));
	public static final Block POLISHED_BLOODSTONE_STAIRS = new PublicStairsBlock(POLISHED_BLOODSTONE.getDefaultState(), FabricBlockSettings.copyOf(POLISHED_BLOODSTONE));
	public static final Block POLISHED_BLOODSTONE_SLAB = new SlabBlock(FabricBlockSettings.copyOf(POLISHED_BLOODSTONE));
	public static final Block POLISHED_BLOODSTONE_BRICKS = new Block(FabricBlockSettings.copyOf(BLOODSTONE).breakByTool(FabricToolTags.PICKAXES));
	public static final Block POLISHED_BLOODSTONE_BRICK_STAIRS = new PublicStairsBlock(POLISHED_BLOODSTONE_BRICKS.getDefaultState(), FabricBlockSettings.copyOf(POLISHED_BLOODSTONE_BRICKS));
	public static final Block POLISHED_BLOODSTONE_BRICK_SLAB = new SlabBlock(FabricBlockSettings.copyOf(POLISHED_BLOODSTONE_BRICKS));
	public static final Block POLISHED_BLOODSTONE_BRICK_WALL = new WallBlock(FabricBlockSettings.copyOf(POLISHED_BLOODSTONE_BRICKS));
	public static final Block CRACKED_POLISHED_BLOODSTONE_BRICKS = new Block(FabricBlockSettings.copyOf(POLISHED_BLOODSTONE_BRICKS).breakByTool(FabricToolTags.PICKAXES));



	public static final ConfiguredFeature<?, ?> ORE_RHYOLITE = Feature.ORE.configure(new OreFeatureConfig(OreFeatureConfig.Rules.BASE_STONE_OVERWORLD, RHYOLITE.getDefaultState(), 56)).uniformRange(YOffset.getBottom(), YOffset.fixed(0)).spreadHorizontally().repeat(1);
	public static final ConfiguredFeature<?, ?> ORE_BLOODSTONE = Feature.ORE.configure(new OreFeatureConfig(OreFeatureConfig.Rules.NETHERRACK, BLOODSTONE.getDefaultState(), 33)).uniformRange(YOffset.fixed(5), YOffset.fixed(41)).spreadHorizontally().repeat(25);
	public static final ConfiguredFeature<?, ?> ORE_SCHIST = Feature.ORE.configure(new OreFeatureConfig(OreFeatureConfig.Rules.BASE_STONE_OVERWORLD, SCHIST.getDefaultState(), 44)).uniformRange(YOffset.getBottom(), YOffset.fixed(0)).spreadHorizontally().repeat(10);


	@SuppressWarnings("UnstableApiUsage")
	@Override
	public void onInitialize() {
		Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "rhyolite"), RHYOLITE);
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "rhyolite"), new BlockItem(RHYOLITE, new FabricItemSettings().group(ITEM_GROUP)));
		Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "rhyolite_stairs"), RHYOLITE_STAIRS);
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "rhyolite_stairs"), new BlockItem(RHYOLITE_STAIRS, new FabricItemSettings().group(ITEM_GROUP)));
		Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "rhyolite_slab"), RHYOLITE_SLAB);
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "rhyolite_slab"), new BlockItem(RHYOLITE_SLAB, new FabricItemSettings().group(ITEM_GROUP)));
		Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "rhyolite_wall"), RHYOLITE_WALL);
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "rhyolite_wall"), new BlockItem(RHYOLITE_WALL, new FabricItemSettings().group(ITEM_GROUP)));
		Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "polished_rhyolite"), POLISHED_RHYOLITE);
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "polished_rhyolite"), new BlockItem(POLISHED_RHYOLITE, new FabricItemSettings().group(ITEM_GROUP)));
		Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "polished_rhyolite_stairs"), POLISHED_RHYOLITE_STAIRS);
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "polished_rhyolite_stairs"), new BlockItem(POLISHED_RHYOLITE_STAIRS, new FabricItemSettings().group(ITEM_GROUP)));
		Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "polished_rhyolite_slab"), POLISHED_RHYOLITE_SLAB);
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "polished_rhyolite_slab"), new BlockItem(POLISHED_RHYOLITE_SLAB, new FabricItemSettings().group(ITEM_GROUP)));
		Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "polished_rhyolite_bricks"), POLISHED_RHYOLITE_BRICKS);
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "polished_rhyolite_bricks"), new BlockItem(POLISHED_RHYOLITE_BRICKS, new FabricItemSettings().group(ITEM_GROUP)));
		Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "polished_rhyolite_brick_stairs"), POLISHED_RHYOLITE_BRICK_STAIRS);
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "polished_rhyolite_brick_stairs"), new BlockItem(POLISHED_RHYOLITE_BRICK_STAIRS, new FabricItemSettings().group(ITEM_GROUP)));
		Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "polished_rhyolite_brick_slab"), POLISHED_RHYOLITE_BRICK_SLAB);
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "polished_rhyolite_brick_slab"), new BlockItem(POLISHED_RHYOLITE_BRICK_SLAB, new FabricItemSettings().group(ITEM_GROUP)));
		Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "polished_rhyolite_brick_wall"), POLISHED_RHYOLITE_BRICK_WALL);
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "polished_rhyolite_brick_wall"), new BlockItem(POLISHED_RHYOLITE_BRICK_WALL, new FabricItemSettings().group(ITEM_GROUP)));
		Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "cracked_polished_rhyolite_bricks"), CRACKED_POLISHED_RHYOLITE_BRICKS);
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "cracked_polished_rhyolite_bricks"), new BlockItem(CRACKED_POLISHED_RHYOLITE_BRICKS, new FabricItemSettings().group(ITEM_GROUP)));

		Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "schist"), SCHIST);
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "schist"), new BlockItem(SCHIST, new FabricItemSettings().group(ITEM_GROUP)));
		Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "schist_stairs"), SCHIST_STAIRS);
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "schist_stairs"), new BlockItem(SCHIST_STAIRS, new FabricItemSettings().group(ITEM_GROUP)));
		Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "schist_slab"), SCHIST_SLAB);
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "schist_slab"), new BlockItem(SCHIST_SLAB, new FabricItemSettings().group(ITEM_GROUP)));
		Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "schist_wall"), SCHIST_WALL);
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "schist_wall"), new BlockItem(SCHIST_WALL, new FabricItemSettings().group(ITEM_GROUP)));
		Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "polished_schist"), POLISHED_SCHIST);
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "polished_schist"), new BlockItem(POLISHED_SCHIST, new FabricItemSettings().group(ITEM_GROUP)));
		Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "polished_schist_stairs"), POLISHED_SCHIST_STAIRS);
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "polished_schist_stairs"), new BlockItem(POLISHED_SCHIST_STAIRS, new FabricItemSettings().group(ITEM_GROUP)));
		Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "polished_schist_slab"), POLISHED_SCHIST_SLAB);
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "polished_schist_slab"), new BlockItem(POLISHED_SCHIST_SLAB, new FabricItemSettings().group(ITEM_GROUP)));
		Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "polished_schist_bricks"), POLISHED_SCHIST_BRICKS);
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "polished_schist_bricks"), new BlockItem(POLISHED_SCHIST_BRICKS, new FabricItemSettings().group(ITEM_GROUP)));
		Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "polished_schist_brick_stairs"), POLISHED_SCHIST_BRICK_STAIRS);
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "polished_schist_brick_stairs"), new BlockItem(POLISHED_SCHIST_BRICK_STAIRS, new FabricItemSettings().group(ITEM_GROUP)));
		Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "polished_schist_brick_slab"), POLISHED_SCHIST_BRICK_SLAB);
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "polished_schist_brick_slab"), new BlockItem(POLISHED_SCHIST_BRICK_SLAB, new FabricItemSettings().group(ITEM_GROUP)));
		Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "polished_schist_brick_wall"), POLISHED_SCHIST_BRICK_WALL);
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "polished_schist_brick_wall"), new BlockItem(POLISHED_SCHIST_BRICK_WALL, new FabricItemSettings().group(ITEM_GROUP)));
		Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "cracked_polished_schist_bricks"), CRACKED_POLISHED_SCHIST_BRICKS);
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "cracked_polished_schist_bricks"), new BlockItem(CRACKED_POLISHED_SCHIST_BRICKS, new FabricItemSettings().group(ITEM_GROUP)));

		Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "bloodstone"), BLOODSTONE);
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "bloodstone"), new BlockItem(BLOODSTONE, new FabricItemSettings().group(ITEM_GROUP)));
		Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "bloodstone_stairs"), BLOODSTONE_STAIRS);
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "bloodstone_stairs"), new BlockItem(BLOODSTONE_STAIRS, new FabricItemSettings().group(ITEM_GROUP)));
		Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "bloodstone_slab"), BLOODSTONE_SLAB);
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "bloodstone_slab"), new BlockItem(BLOODSTONE_SLAB, new FabricItemSettings().group(ITEM_GROUP)));
		Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "bloodstone_wall"), BLOODSTONE_WALL);
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "bloodstone_wall"), new BlockItem(BLOODSTONE_WALL, new FabricItemSettings().group(ITEM_GROUP)));
		Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "polished_bloodstone"), POLISHED_BLOODSTONE);
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "polished_bloodstone"), new BlockItem(POLISHED_BLOODSTONE, new FabricItemSettings().group(ITEM_GROUP)));
		Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "polished_bloodstone_stairs"), POLISHED_BLOODSTONE_STAIRS);
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "polished_bloodstone_stairs"), new BlockItem(POLISHED_BLOODSTONE_STAIRS, new FabricItemSettings().group(ITEM_GROUP)));
		Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "polished_bloodstone_slab"), POLISHED_BLOODSTONE_SLAB);
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "polished_bloodstone_slab"), new BlockItem(POLISHED_BLOODSTONE_SLAB, new FabricItemSettings().group(ITEM_GROUP)));
		Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "polished_bloodstone_bricks"), POLISHED_BLOODSTONE_BRICKS);
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "polished_bloodstone_bricks"), new BlockItem(POLISHED_BLOODSTONE_BRICKS, new FabricItemSettings().group(ITEM_GROUP)));
		Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "polished_bloodstone_brick_stairs"), POLISHED_BLOODSTONE_BRICK_STAIRS);
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "polished_bloodstone_brick_stairs"), new BlockItem(POLISHED_BLOODSTONE_BRICK_STAIRS, new FabricItemSettings().group(ITEM_GROUP)));
		Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "polished_bloodstone_brick_slab"), POLISHED_BLOODSTONE_BRICK_SLAB);
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "polished_bloodstone_brick_slab"), new BlockItem(POLISHED_BLOODSTONE_BRICK_SLAB, new FabricItemSettings().group(ITEM_GROUP)));
		Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "polished_bloodstone_brick_wall"), POLISHED_BLOODSTONE_BRICK_WALL);
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "polished_bloodstone_brick_wall"), new BlockItem(POLISHED_BLOODSTONE_BRICK_WALL, new FabricItemSettings().group(ITEM_GROUP)));
		Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "cracked_polished_bloodstone_bricks"), CRACKED_POLISHED_BLOODSTONE_BRICKS);
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "cracked_polished_bloodstone_bricks"), new BlockItem(CRACKED_POLISHED_BLOODSTONE_BRICKS, new FabricItemSettings().group(ITEM_GROUP)));
		//im sorry i know its scuffed ill make the block registry more organized later

		Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new Identifier(MOD_ID, "ore_rhyolite"), ORE_RHYOLITE);

		Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new Identifier(MOD_ID, "ore_schist"), ORE_SCHIST);

		Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new Identifier(MOD_ID, "ore_bloodstone"), ORE_BLOODSTONE);


		Reflection.initialize(
				TwigsBlocks.class,
				TwigsItems.class
		);

		FlammableBlockRegistry fbrInstance = FlammableBlockRegistry.getDefaultInstance();
		fbrInstance.add(TwigsBlocks.AZALEA_FLOWERS,30, 60);
		fbrInstance.add(TwigsBlocks.BAMBOO_LEAVES,30, 60);
		fbrInstance.add(TwigsBlocks.BAMBOO_THATCH,30, 60);
		fbrInstance.add(TwigsBlocks.BAMBOO_THATCH_SLAB, 30, 60);
		fbrInstance.add(TwigsBlocks.BAMBOO_THATCH_STAIRS, 30, 60);
		fbrInstance.add(TwigsBlocks.OAK_TABLE, 5, 20);
		fbrInstance.add(TwigsBlocks.SPRUCE_TABLE, 5, 20);
		fbrInstance.add(TwigsBlocks.BIRCH_TABLE, 5, 20);
		fbrInstance.add(TwigsBlocks.ACACIA_TABLE, 5, 20);
		fbrInstance.add(TwigsBlocks.JUNGLE_TABLE, 5, 20);
		fbrInstance.add(TwigsBlocks.DARK_OAK_TABLE, 5, 20);
		fbrInstance.add(TwigsBlocks.STRIPPED_BAMBOO_TABLE, 5, 20);
		fbrInstance.add(TwigsBlocks.STRIPPED_BAMBOO, 5, 20);
		fbrInstance.add(TwigsBlocks.STRIPPED_BAMBOO_PLANKS, 5, 20);
		fbrInstance.add(TwigsBlocks.STRIPPED_BAMBOO_STAIRS, 5, 20);
		fbrInstance.add(TwigsBlocks.STRIPPED_BAMBOO_SLAB, 5, 20);
		fbrInstance.add(TwigsBlocks.STRIPPED_BAMBOO_FENCE, 5, 20);
		fbrInstance.add(TwigsBlocks.STRIPPED_BAMBOO_FENCE_GATE, 5, 20);
		fbrInstance.add(TwigsBlocks.STRIPPED_BAMBOO_BUTTON, 5, 20);
		fbrInstance.add(TwigsBlocks.STRIPPED_BAMBOO_TRAPDOOR, 5, 20);
		fbrInstance.add(TwigsBlocks.STRIPPED_BAMBOO_DOOR, 5, 20);
		fbrInstance.add(TwigsBlocks.STRIPPED_BAMBOO_PRESSURE_PLATE, 5, 20);
	}
}