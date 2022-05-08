package net.moddingplayground.twigs.init;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.moddingplayground.twigs.Twigs;
import net.moddingplayground.twigs.block.*;
import net.moddingplayground.twigs.block.vanilla.TwigsSignBlock;
import net.moddingplayground.twigs.block.vanilla.TwigsWallSignBlock;

import java.util.function.Supplier;

@SuppressWarnings("unused")
@Mod.EventBusSubscriber(modid = Twigs.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public final class TwigsBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Twigs.MOD_ID);

    //lamps
    public static final RegistryObject<Block> LAMP = registerBlock("lamp", () -> new LampBlock(BlockBehaviour.Properties.of(Material.METAL).requiresCorrectToolForDrops().strength(4.5F).sound(SoundType.LANTERN).lightLevel(state -> state.getValue(BlockStateProperties.LIT) ? 15 : 0)));
    public static final RegistryObject<Block> SOUL_LAMP = registerBlock("soul_lamp", () -> new LampBlock(BlockBehaviour.Properties.copy(TwigsBlocks.LAMP.get())));
    public static final RegistryObject<Block> CRIMSON_SHROOMLAMP = registerBlock("crimson_shroomlamp", () -> new Block(BlockBehaviour.Properties.of(Material.NETHER_WOOD).strength(3.5F).sound(SoundType.SHROOMLIGHT).isViewBlocking(BlockBehaviour.BlockStateBase::emissiveRendering).lightLevel(value -> 15).noOcclusion()));
    public static final RegistryObject<Block> WARPED_SHROOMLAMP = registerBlock("warped_shroomlamp", () -> new Block(BlockBehaviour.Properties.of(Material.NETHER_WOOD).strength(3.5F).sound(SoundType.SHROOMLIGHT).isViewBlocking(BlockBehaviour.BlockStateBase::emissiveRendering).lightLevel(value -> 15).noOcclusion()));

    //azalea blocks
    public static final RegistryObject<Block> AZALEA_FLOWERS = registerBlock("azalea_flowers", () -> new GlowLichenBlock(BlockBehaviour.Properties.of(Material.PLANT).instabreak().sound(SoundType.AZALEA).noCollission()));
    public static final RegistryObject<Block> POTTED_AZALEA_FLOWERS = registerBlockWithNoTab("potted_azalea_flowers", () -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, AZALEA_FLOWERS, BlockBehaviour.Properties.of(Material.DECORATION).instabreak().noOcclusion()));

    //bamboo blocks
    public static final RegistryObject<Block> BAMBOO_LEAVES = registerBlockWithNoTab("bamboo_leaves", () -> new BambooLeavesBlock(BlockBehaviour.Properties.copy(Blocks.ACACIA_LEAVES).sound(SoundType.AZALEA_LEAVES).instabreak().noCollission()));
    public static final RegistryObject<Block> STRIPPED_BAMBOO = registerBlock("stripped_bamboo", () -> new StrippedBambooBlock(BlockBehaviour.Properties.copy(Blocks.BAMBOO)));
    public static final RegistryObject<Block> STRIPPED_BUNDLED_BAMBOO = registerBlock("stripped_bundled_bamboo", () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).sound(SoundType.SCAFFOLDING)));
    public static final RegistryObject<Block> BUNDLED_BAMBOO = registerBlock("bundled_bamboo", () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).sound(SoundType.SCAFFOLDING)));
    public static final RegistryObject<Block> BAMBOO_THATCH = registerBlock("bamboo_thatch", () -> new Block(BlockBehaviour.Properties.copy(Blocks.ACACIA_LEAVES).sound(SoundType.AZALEA_LEAVES)));
    public static final RegistryObject<Block> BAMBOO_THATCH_STAIRS = registerBlock("bamboo_thatch_stairs", () -> new StairBlock(() -> BAMBOO_THATCH.get().defaultBlockState(), BlockBehaviour.Properties.copy(BAMBOO_THATCH.get())));
    public static final RegistryObject<Block> BAMBOO_THATCH_SLAB = registerBlock("bamboo_thatch_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(BAMBOO_THATCH.get())));
    public static final RegistryObject<Block> BAMBOO_THATCH_VERTICAL_SLAB = registerCompatBlock("quark", "bamboo_thatch_vertical_slab", () -> new VerticalSlabBlock(BlockBehaviour.Properties.copy(BAMBOO_THATCH.get())));

    public static final RegistryObject<Block> STRIPPED_BAMBOO_MAT = registerBlock("stripped_bamboo_mat", () -> new BambooMatBlock(BlockBehaviour.Properties.copy(Blocks.WHITE_CARPET).sound(SoundType.SCAFFOLDING)));
    public static final RegistryObject<Block> STRIPPED_BAMBOO_PLANKS = registerBlock("stripped_bamboo_planks", () -> new Block(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).strength(1.0F, 1.5F).sound(SoundType.SCAFFOLDING)));
    public static final RegistryObject<Block> STRIPPED_BAMBOO_STAIRS = registerBlock("stripped_bamboo_stairs", () -> new StairBlock(() -> STRIPPED_BAMBOO_PLANKS.get().defaultBlockState(), BlockBehaviour.Properties.copy(STRIPPED_BAMBOO_PLANKS.get())));
    public static final RegistryObject<Block> STRIPPED_BAMBOO_SLAB = registerBlock("stripped_bamboo_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(STRIPPED_BAMBOO_PLANKS.get())));
    public static final RegistryObject<Block> STRIPPED_BAMBOO_FENCE = registerBlock("stripped_bamboo_fence", () -> new FenceBlock(BlockBehaviour.Properties.copy(STRIPPED_BAMBOO_PLANKS.get())));
    public static final RegistryObject<Block> STRIPPED_BAMBOO_FENCE_GATE = registerBlock("stripped_bamboo_fence_gate", () -> new FenceGateBlock(BlockBehaviour.Properties.copy(STRIPPED_BAMBOO_PLANKS.get())));
    public static final RegistryObject<Block> STRIPPED_BAMBOO_DOOR = registerBlock("stripped_bamboo_door", () -> new DoorBlock(BlockBehaviour.Properties.copy(STRIPPED_BAMBOO_PLANKS.get())));
    public static final RegistryObject<Block> STRIPPED_BAMBOO_TRAPDOOR = registerBlock("stripped_bamboo_trapdoor", () -> new TrapDoorBlock(BlockBehaviour.Properties.copy(STRIPPED_BAMBOO_PLANKS.get())));
    public static final RegistryObject<Block> STRIPPED_BAMBOO_BUTTON = registerBlock("stripped_bamboo_button", () -> new WoodButtonBlock(BlockBehaviour.Properties.copy(STRIPPED_BAMBOO_PLANKS.get())));
    public static final RegistryObject<Block> STRIPPED_BAMBOO_PRESSURE_PLATE = registerBlock("stripped_bamboo_pressure_plate", () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.copy(STRIPPED_BAMBOO_PLANKS.get())));
    public static final RegistryObject<Block> STRIPPED_BAMBOO_PLANKS_VERTICAL_SLAB = registerCompatBlock("quark", "stripped_bamboo_planks_vertical_slab", () -> new VerticalSlabBlock(BlockBehaviour.Properties.copy(STRIPPED_BAMBOO_PLANKS.get())));

    //tables
    public static final RegistryObject<Block> OAK_TABLE = registerBlock("oak_table", () -> new TableBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).instabreak()));
    public static final RegistryObject<Block> SPRUCE_TABLE = registerBlock("spruce_table", () -> new TableBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).instabreak()));
    public static final RegistryObject<Block> BIRCH_TABLE = registerBlock("birch_table", () -> new TableBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).instabreak()));
    public static final RegistryObject<Block> JUNGLE_TABLE = registerBlock("jungle_table", () -> new TableBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).instabreak()));
    public static final RegistryObject<Block> ACACIA_TABLE = registerBlock("acacia_table", () -> new TableBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).instabreak()));
    public static final RegistryObject<Block> DARK_OAK_TABLE = registerBlock("dark_oak_table", () -> new TableBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).instabreak()));
    public static final RegistryObject<Block> CRIMSON_TABLE = registerBlock("crimson_table", () -> new TableBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).instabreak()));
    public static final RegistryObject<Block> WARPED_TABLE = registerBlock("warped_table", () -> new TableBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).instabreak()));
    public static final RegistryObject<Block> STRIPPED_BAMBOO_TABLE = registerBlock("stripped_bamboo_table", () -> new TableBlock(BlockBehaviour.Properties.copy(TwigsBlocks.STRIPPED_BAMBOO_PLANKS.get()).instabreak()));

    //brick blocks
    public static final RegistryObject<Block> CHISELED_BRICKS = registerBlock("chiseled_bricks", () -> new Block(BlockBehaviour.Properties.copy(Blocks.BRICKS)));
    public static final RegistryObject<Block> CRACKED_BRICKS = registerBlock("cracked_bricks", () -> new Block(BlockBehaviour.Properties.copy(Blocks.BRICKS)));
    public static final RegistryObject<Block> MOSSY_BRICKS = registerBlock("mossy_bricks", () -> new Block(BlockBehaviour.Properties.copy(Blocks.BRICKS)));
    public static final RegistryObject<Block> MOSSY_BRICK_STAIRS = registerBlock("mossy_brick_stairs", () -> new StairBlock(() -> MOSSY_BRICKS.get().defaultBlockState(), BlockBehaviour.Properties.copy(MOSSY_BRICKS.get())));
    public static final RegistryObject<Block> MOSSY_BRICK_SLAB = registerBlock("mossy_brick_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(MOSSY_BRICKS.get())));
    public static final RegistryObject<Block> MOSSY_BRICK_WALL = registerBlock("mossy_brick_wall", () -> new WallBlock(BlockBehaviour.Properties.copy(MOSSY_BRICKS.get())));
    public static final RegistryObject<Block> MOSSY_BRICK_VERTICAL_SLAB = registerCompatBlock("quark", "mossy_brick_vertical_slab", () -> new VerticalSlabBlock(BlockBehaviour.Properties.copy(MOSSY_BRICKS.get())));

    //basalt blocks
    public static final RegistryObject<Block> POLISHED_BASALT_BRICKS = registerBlock("polished_basalt_bricks", () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.POLISHED_BASALT)));
    public static final RegistryObject<Block> SMOOTH_BASALT_BRICKS = registerBlock("smooth_basalt_bricks", () -> new Block(BlockBehaviour.Properties.copy(Blocks.SMOOTH_BASALT)));
    public static final RegistryObject<Block> SMOOTH_BASALT_BRICK_STAIRS = registerBlock("smooth_basalt_brick_stairs", () -> new StairBlock(() -> SMOOTH_BASALT_BRICKS.get().defaultBlockState(), BlockBehaviour.Properties.copy(SMOOTH_BASALT_BRICKS.get())));
    public static final RegistryObject<Block> SMOOTH_BASALT_BRICK_SLAB = registerBlock("smooth_basalt_brick_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(SMOOTH_BASALT_BRICKS.get())));
    public static final RegistryObject<Block> SMOOTH_BASALT_BRICK_WALL = registerBlock("smooth_basalt_brick_wall", () -> new WallBlock(BlockBehaviour.Properties.copy(SMOOTH_BASALT_BRICKS.get())));
    public static final RegistryObject<Block> SMOOTH_BASALT_BRICK_VERTICAL_SLAB = registerCompatBlock("quark", "smooth_basalt_brick_vertical_slab", () -> new VerticalSlabBlock(BlockBehaviour.Properties.copy(SMOOTH_BASALT_BRICKS.get())));

    //cobblestone bricks
    public static final RegistryObject<Block> COBBLESTONE_BRICKS = registerBlock("cobblestone_bricks", () -> new Block(BlockBehaviour.Properties.copy(Blocks.COBBLESTONE)));
    public static final RegistryObject<Block> COBBLESTONE_BRICK_STAIRS = registerBlock("cobblestone_brick_stairs", () -> new StairBlock(() -> COBBLESTONE_BRICKS.get().defaultBlockState(), BlockBehaviour.Properties.copy(COBBLESTONE_BRICKS.get())));
    public static final RegistryObject<Block> COBBLESTONE_BRICK_SLAB = registerBlock("cobblestone_brick_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(COBBLESTONE_BRICKS.get())));
    public static final RegistryObject<Block> COBBLESTONE_BRICK_WALL = registerBlock("cobblestone_brick_wall", () -> new WallBlock(BlockBehaviour.Properties.copy(COBBLESTONE_BRICKS.get())));
    public static final RegistryObject<Block> CRACKED_COBBLESTONE_BRICKS = registerBlock("cracked_cobblestone_bricks", () -> new Block(BlockBehaviour.Properties.copy(Blocks.COBBLESTONE)));
    public static final RegistryObject<Block> COBBLESTONE_BRICK_VERTICAL_SLAB = registerCompatBlock("quark", "cobblestone_brick_vertical_slab", () -> new VerticalSlabBlock(BlockBehaviour.Properties.copy(COBBLESTONE_BRICKS.get())));
    public static final RegistryObject<Block> MOSSY_COBBLESTONE_BRICKS = registerBlock("mossy_cobblestone_bricks", () -> new Block(BlockBehaviour.Properties.copy(Blocks.COBBLESTONE)));
    public static final RegistryObject<Block> MOSSY_COBBLESTONE_BRICK_STAIRS = registerBlock("mossy_cobblestone_brick_stairs", () -> new StairBlock(() -> COBBLESTONE_BRICKS.get().defaultBlockState(), BlockBehaviour.Properties.copy(COBBLESTONE_BRICKS.get())));
    public static final RegistryObject<Block> MOSSY_COBBLESTONE_BRICK_SLAB = registerBlock("mossy_cobblestone_brick_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(COBBLESTONE_BRICKS.get())));
    public static final RegistryObject<Block> MOSSY_COBBLESTONE_BRICK_WALL = registerBlock("mossy_cobblestone_brick_wall", () -> new WallBlock(BlockBehaviour.Properties.copy(COBBLESTONE_BRICKS.get())));
    public static final RegistryObject<Block> MOSSY_COBBLESTONE_BRICK_VERTICAL_SLAB = registerCompatBlock("quark", "mossy_cobblestone_brick_vertical_slab", () -> new VerticalSlabBlock(BlockBehaviour.Properties.copy(MOSSY_COBBLESTONE_BRICKS.get())));

    //amethyst blocks
    public static final RegistryObject<Block> POLISHED_AMETHYST_BRICKS = registerBlock("polished_amethyst_bricks", () -> new AmethystBlock(BlockBehaviour.Properties.copy(Blocks.AMETHYST_BLOCK)));
    public static final RegistryObject<Block> POLISHED_AMETHYST_BRICK_STAIRS = registerBlock("polished_amethyst_brick_stairs", () -> new AmethystStairBlock(() -> POLISHED_AMETHYST_BRICKS.get().defaultBlockState(), BlockBehaviour.Properties.copy(POLISHED_AMETHYST_BRICKS.get())));
    public static final RegistryObject<Block> POLISHED_AMETHYST_BRICK_SLAB = registerBlock("polished_amethyst_brick_slab", () -> new AmethystSlabBlock(BlockBehaviour.Properties.copy(POLISHED_AMETHYST_BRICKS.get())));
    public static final RegistryObject<Block> POLISHED_AMETHYST_BRICK_WALL = registerBlock("polished_amethyst_brick_wall", () -> new AmethystWallBlock(BlockBehaviour.Properties.copy(POLISHED_AMETHYST_BRICKS.get())));
    public static final RegistryObject<Block> CRACKED_POLISHED_AMETHYST_BRICKS = registerBlock("cracked_polished_amethyst_bricks", () -> new AmethystBlock(BlockBehaviour.Properties.copy(Blocks.AMETHYST_BLOCK)));
    public static final RegistryObject<Block> POLISHED_AMETHYST_BRICK_VERTICAL_SLAB = registerCompatBlock("quark", "polished_amethyst_brick_vertical_slab", () -> new VerticalSlabBlock(BlockBehaviour.Properties.copy(POLISHED_AMETHYST_BRICKS.get())));
    public static final RegistryObject<Block> POLISHED_AMETHYST = registerBlock("polished_amethyst", () -> new AmethystBlock(BlockBehaviour.Properties.copy(Blocks.AMETHYST_BLOCK)));
    public static final RegistryObject<Block> CHISELED_POLISHED_AMETHYST = registerBlock("chiseled_polished_amethyst", () -> new AmethystBlock(BlockBehaviour.Properties.copy(Blocks.AMETHYST_BLOCK)));
    public static final RegistryObject<Block> POLISHED_AMETHYST_STAIRS = registerBlock("polished_amethyst_stairs", () -> new AmethystStairBlock(() -> POLISHED_AMETHYST.get().defaultBlockState(), BlockBehaviour.Properties.copy(POLISHED_AMETHYST.get())));
    public static final RegistryObject<Block> POLISHED_AMETHYST_SLAB = registerBlock("polished_amethyst_slab", () -> new AmethystSlabBlock(BlockBehaviour.Properties.copy(POLISHED_AMETHYST.get())));
    public static final RegistryObject<Block> POLISHED_AMETHYST_VERTICAL_SLAB = registerCompatBlock("quark", "polished_amethyst_vertical_slab", () -> new VerticalSlabBlock(BlockBehaviour.Properties.copy(POLISHED_AMETHYST.get())));

    //twisting and weeping blackstone blocks
    public static final RegistryObject<Block> TWISTING_POLISHED_BLACKSTONE_BRICKS = registerBlock("twisting_polished_blackstone_bricks", () -> new Block(BlockBehaviour.Properties.copy(Blocks.POLISHED_BLACKSTONE_BRICKS)));
    public static final RegistryObject<Block> TWISTING_POLISHED_BLACKSTONE_BRICK_STAIRS = registerBlock("twisting_polished_blackstone_brick_stairs", () -> new StairBlock(() -> TWISTING_POLISHED_BLACKSTONE_BRICKS.get().defaultBlockState(), BlockBehaviour.Properties.copy(TWISTING_POLISHED_BLACKSTONE_BRICKS.get())));
    public static final RegistryObject<Block> TWISTING_POLISHED_BLACKSTONE_BRICK_SLAB = registerBlock("twisting_polished_blackstone_brick_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(TWISTING_POLISHED_BLACKSTONE_BRICKS.get())));
    public static final RegistryObject<Block> TWISTING_POLISHED_BLACKSTONE_BRICK_WALL = registerBlock("twisting_polished_blackstone_brick_wall", () -> new WallBlock(BlockBehaviour.Properties.copy(TWISTING_POLISHED_BLACKSTONE_BRICKS.get())));
    public static final RegistryObject<Block> TWISTING_POLISHED_BLACKSTONE_BRICK_VERTICAL_SLAB = registerCompatBlock("quark", "twisting_polished_blackstone_brick_vertical_slab", () -> new VerticalSlabBlock(BlockBehaviour.Properties.copy(TWISTING_POLISHED_BLACKSTONE_BRICKS.get())));
    public static final RegistryObject<Block> WEEPING_POLISHED_BLACKSTONE_BRICKS = registerBlock("weeping_polished_blackstone_bricks", () -> new Block(BlockBehaviour.Properties.copy(Blocks.POLISHED_BLACKSTONE_BRICKS)));
    public static final RegistryObject<Block> WEEPING_POLISHED_BLACKSTONE_BRICK_STAIRS = registerBlock("weeping_polished_blackstone_brick_stairs", () -> new StairBlock(() -> WEEPING_POLISHED_BLACKSTONE_BRICKS.get().defaultBlockState(), BlockBehaviour.Properties.copy(WEEPING_POLISHED_BLACKSTONE_BRICKS.get())));
    public static final RegistryObject<Block> WEEPING_POLISHED_BLACKSTONE_BRICK_SLAB = registerBlock("weeping_polished_blackstone_brick_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(WEEPING_POLISHED_BLACKSTONE_BRICKS.get())));
    public static final RegistryObject<Block> WEEPING_POLISHED_BLACKSTONE_BRICK_WALL = registerBlock("weeping_polished_blackstone_brick_wall", () -> new WallBlock(BlockBehaviour.Properties.copy(WEEPING_POLISHED_BLACKSTONE_BRICKS.get())));
    public static final RegistryObject<Block> WEEPING_POLISHED_BLACKSTONE_BRICK_VERTICAL_SLAB = registerCompatBlock("quark", "weeping_polished_blackstone_brick_vertical_slab", () -> new VerticalSlabBlock(BlockBehaviour.Properties.copy(WEEPING_POLISHED_BLACKSTONE_BRICKS.get())));

    //paper lanterns
    public static final RegistryObject<Block> PAPER_LANTERN = registerBlock("paper_lantern", () -> new PaperLanternBlock(Blocks.AIR, BlockBehaviour.Properties.of(Material.WOOL).instabreak().sound(SoundType.BAMBOO).isViewBlocking(BlockBehaviour.BlockStateBase::emissiveRendering).lightLevel(value -> 10).noOcclusion()));
    public static final RegistryObject<Block> ALLIUM_PAPER_LANTERN = registerBlock("allium_paper_lantern", () -> new PaperLanternBlock(Blocks.ALLIUM, BlockBehaviour.Properties.copy(TwigsBlocks.PAPER_LANTERN.get())));
    public static final RegistryObject<Block> BLUE_ORCHID_PAPER_LANTERN = registerBlock("blue_orchid_paper_lantern", () -> new PaperLanternBlock(Blocks.BLUE_ORCHID, BlockBehaviour.Properties.copy(TwigsBlocks.PAPER_LANTERN.get())));
    public static final RegistryObject<Block> CRIMSON_ROOTS_PAPER_LANTERN = registerBlock("crimson_roots_paper_lantern", () -> new PaperLanternBlock(Blocks.CRIMSON_ROOTS, BlockBehaviour.Properties.copy(TwigsBlocks.PAPER_LANTERN.get())));
    public static final RegistryObject<Block> DANDELION_PAPER_LANTERN = registerBlock("dandelion_paper_lantern", () -> new PaperLanternBlock(Blocks.DANDELION, BlockBehaviour.Properties.copy(TwigsBlocks.PAPER_LANTERN.get())));

    //miscellaneous blocks
    public static final RegistryObject<Block> ROCKY_DIRT = registerBlock("rocky_dirt", () -> new Block(BlockBehaviour.Properties.copy(Blocks.DIRT).strength(2.5F).sound(SoundType.TUFF).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> TWIG = registerBlockWithNoTab("twig", () -> new FloorLayerBlock(BlockBehaviour.Properties.of(TwigsMaterial.layerMaterial(MaterialColor.WOOD)).instabreak().sound(SoundType.WOOD).noCollission()));
    public static final RegistryObject<Block> PEBBLE = registerBlock("pebble", () -> new FloorLayerBlock(BlockBehaviour.Properties.of(TwigsMaterial.layerMaterial(MaterialColor.COLOR_GRAY)).instabreak().sound(SoundType.STONE).noCollission()));

    //tuff blocks
    public static final RegistryObject<Block> TUFF_STAIRS = registerBlock("tuff_stairs", () -> new StairBlock(Blocks.TUFF::defaultBlockState, BlockBehaviour.Properties.copy(Blocks.BASALT)));
    public static final RegistryObject<Block> TUFF_SLAB = registerBlock("tuff_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.TUFF)));
    public static final RegistryObject<Block> TUFF_WALL = registerBlock("tuff_wall", () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.TUFF)));
    public static final RegistryObject<Block> TUFF_VERTICAL_SLAB = registerCompatBlock("quark", "tuff_vertical_slab", () -> new VerticalSlabBlock(BlockBehaviour.Properties.copy(Blocks.TUFF)));
    public static final RegistryObject<Block> POLISHED_TUFF = registerBlock("polished_tuff", () -> new Block(BlockBehaviour.Properties.copy(Blocks.TUFF)));
    public static final RegistryObject<Block> POLISHED_TUFF_STAIRS = registerBlock("polished_tuff_stairs", () -> new StairBlock(() -> POLISHED_TUFF.get().defaultBlockState(), BlockBehaviour.Properties.copy(POLISHED_TUFF.get())));
    public static final RegistryObject<Block> POLISHED_TUFF_SLAB = registerBlock("polished_tuff_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(POLISHED_TUFF.get())));
    public static final RegistryObject<Block> POLISHED_TUFF_VERTICAL_SLAB = registerCompatBlock("quark", "polished_tuff_vertical_slab", () -> new VerticalSlabBlock(BlockBehaviour.Properties.copy(POLISHED_TUFF.get())));
    public static final RegistryObject<Block> POLISHED_TUFF_BRICKS = registerBlock("polished_tuff_bricks", () -> new Block(BlockBehaviour.Properties.copy(Blocks.TUFF)));
    public static final RegistryObject<Block> POLISHED_TUFF_BRICK_STAIRS = registerBlock("polished_tuff_brick_stairs", () -> new StairBlock(() -> POLISHED_TUFF_BRICKS.get().defaultBlockState(), BlockBehaviour.Properties.copy(POLISHED_TUFF_BRICKS.get())));
    public static final RegistryObject<Block> POLISHED_TUFF_BRICK_SLAB = registerBlock("polished_tuff_brick_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(POLISHED_TUFF_BRICKS.get())));
    public static final RegistryObject<Block> POLISHED_TUFF_BRICK_WALL = registerBlock("polished_tuff_brick_wall", () -> new WallBlock(BlockBehaviour.Properties.copy(POLISHED_TUFF_BRICKS.get())));
    public static final RegistryObject<Block> CRACKED_POLISHED_TUFF_BRICKS = registerBlock("cracked_polished_tuff_bricks", () -> new Block(BlockBehaviour.Properties.copy(POLISHED_TUFF_BRICKS.get())));
    public static final RegistryObject<Block> POLISHED_TUFF_BRICK_VERTICAL_SLAB = registerCompatBlock("quark", "polished_tuff_brick_vertical_slab", () -> new VerticalSlabBlock(BlockBehaviour.Properties.copy(POLISHED_TUFF_BRICKS.get())));

    //calcite blocks
    public static final RegistryObject<Block> CALCITE_STAIRS = registerBlock("calcite_stairs", () -> new StairBlock(Blocks.CALCITE::defaultBlockState, BlockBehaviour.Properties.copy(Blocks.CALCITE)));
    public static final RegistryObject<Block> CALCITE_SLAB = registerBlock("calcite_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.CALCITE)));
    public static final RegistryObject<Block> CALCITE_WALL = registerBlock("calcite_wall", () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.CALCITE)));
    public static final RegistryObject<Block> CALCITE_VERTICAL_SLAB = registerCompatBlock("quark", "calcite_vertical_slab", () -> new VerticalSlabBlock(BlockBehaviour.Properties.copy(Blocks.CALCITE)));
    public static final RegistryObject<Block> POLISHED_CALCITE = registerBlock("polished_calcite", () -> new Block(BlockBehaviour.Properties.copy(Blocks.CALCITE)));
    public static final RegistryObject<Block> POLISHED_CALCITE_STAIRS = registerBlock("polished_calcite_stairs", () -> new StairBlock(() -> POLISHED_CALCITE.get().defaultBlockState(), BlockBehaviour.Properties.copy(POLISHED_CALCITE.get())));
    public static final RegistryObject<Block> POLISHED_CALCITE_SLAB = registerBlock("polished_calcite_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(POLISHED_CALCITE.get())));
    public static final RegistryObject<Block> POLISHED_CALCITE_VERTICAL_SLAB = registerCompatBlock("quark", "polished_calcite_vertical_slab", () -> new VerticalSlabBlock(BlockBehaviour.Properties.copy(POLISHED_CALCITE.get())));
    public static final RegistryObject<Block> POLISHED_CALCITE_BRICKS = registerBlock("polished_calcite_bricks", () -> new Block(BlockBehaviour.Properties.copy(Blocks.CALCITE)));
    public static final RegistryObject<Block> POLISHED_CALCITE_BRICK_STAIRS = registerBlock("polished_calcite_brick_stairs", () -> new StairBlock(() -> POLISHED_CALCITE_BRICKS.get().defaultBlockState(), BlockBehaviour.Properties.copy(POLISHED_CALCITE_BRICKS.get())));
    public static final RegistryObject<Block> POLISHED_CALCITE_BRICK_SLAB = registerBlock("polished_calcite_brick_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(POLISHED_CALCITE_BRICKS.get())));
    public static final RegistryObject<Block> POLISHED_CALCITE_BRICK_WALL = registerBlock("polished_calcite_brick_wall", () -> new WallBlock(BlockBehaviour.Properties.copy(POLISHED_CALCITE_BRICKS.get())));
    public static final RegistryObject<Block> POLISHED_CALCITE_BRICK_VERTICAL_SLAB = registerCompatBlock("quark", "polished_calcite_brick_vertical_slab", () -> new VerticalSlabBlock(BlockBehaviour.Properties.copy(POLISHED_CALCITE_BRICKS.get())));
    public static final RegistryObject<Block> CRACKED_POLISHED_CALCITE_BRICKS = registerBlock("cracked_polished_calcite_bricks", () -> new Block(BlockBehaviour.Properties.copy(POLISHED_CALCITE_BRICKS.get())));

    //copper blocks
    public static final RegistryObject<Block> COPPER_PILLAR = registerBlock("copper_pillar", () -> new PillarOxidizableBlock(WeatheringCopper.WeatherState.UNAFFECTED, BlockBehaviour.Properties.copy(Blocks.CUT_COPPER)));
    public static final RegistryObject<Block> EXPOSED_COPPER_PILLAR = registerBlock("exposed_copper_pillar", () -> new PillarOxidizableBlock(WeatheringCopper.WeatherState.EXPOSED, BlockBehaviour.Properties.copy(Blocks.EXPOSED_CUT_COPPER)));
    public static final RegistryObject<Block> WEATHERED_COPPER_PILLAR = registerBlock("weathered_copper_pillar", () -> new PillarOxidizableBlock(WeatheringCopper.WeatherState.WEATHERED, BlockBehaviour.Properties.copy(Blocks.WEATHERED_CUT_COPPER)));
    public static final RegistryObject<Block> OXIDIZED_COPPER_PILLAR = registerBlock("oxidized_copper_pillar", () -> new PillarOxidizableBlock(WeatheringCopper.WeatherState.OXIDIZED, BlockBehaviour.Properties.copy(Blocks.OXIDIZED_CUT_COPPER)));
    public static final RegistryObject<Block> WAXED_COPPER_PILLAR = registerBlock("waxed_copper_pillar", () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.WAXED_CUT_COPPER)));
    public static final RegistryObject<Block> WAXED_EXPOSED_COPPER_PILLAR = registerBlock("waxed_exposed_copper_pillar", () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.WAXED_EXPOSED_CUT_COPPER)));
    public static final RegistryObject<Block> WAXED_WEATHERED_COPPER_PILLAR = registerBlock("waxed_weathered_copper_pillar", () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.WAXED_WEATHERED_CUT_COPPER)));
    public static final RegistryObject<Block> WAXED_OXIDIZED_COPPER_PILLAR = registerBlock("waxed_oxidized_copper_pillar", () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.WAXED_OXIDIZED_CUT_COPPER)));

    //rhyolite blocks
    public static final RegistryObject<Block> RHYOLITE = registerBlock("rhyolite", () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE)));
    public static final RegistryObject<Block> RHYOLITE_STAIRS = registerBlock("rhyolite_stairs", () -> new StairBlock(() -> RHYOLITE.get().defaultBlockState(), BlockBehaviour.Properties.copy(RHYOLITE.get())));
    public static final RegistryObject<Block> RHYOLITE_SLAB = registerBlock("rhyolite_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(RHYOLITE.get())));
    public static final RegistryObject<Block> RHYOLITE_WALL = registerBlock("rhyolite_wall", () -> new WallBlock(BlockBehaviour.Properties.copy(RHYOLITE.get())));
    public static final RegistryObject<Block> RHYOLITE_VERTICAL_SLAB = registerCompatBlock("quark", "rhyolite_vertical_slab", () -> new VerticalSlabBlock(BlockBehaviour.Properties.copy(RHYOLITE.get())));
    public static final RegistryObject<Block> POLISHED_RHYOLITE = registerBlock("polished_rhyolite", () -> new Block(BlockBehaviour.Properties.copy(RHYOLITE.get())));
    public static final RegistryObject<Block> POLISHED_RHYOLITE_STAIRS = registerBlock("polished_rhyolite_stairs", () -> new StairBlock(() -> POLISHED_RHYOLITE.get().defaultBlockState(), BlockBehaviour.Properties.copy(POLISHED_RHYOLITE.get())));
    public static final RegistryObject<Block> POLISHED_RHYOLITE_SLAB = registerBlock("polished_rhyolite_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(POLISHED_RHYOLITE.get())));
    public static final RegistryObject<Block> POLISHED_RHYOLITE_VERTICAL_SLAB = registerCompatBlock("quark", "polished_rhyolite_vertical_slab", () -> new VerticalSlabBlock(BlockBehaviour.Properties.copy(POLISHED_RHYOLITE.get())));
    public static final RegistryObject<Block> POLISHED_RHYOLITE_BRICKS = registerBlock("polished_rhyolite_bricks", () -> new Block(BlockBehaviour.Properties.copy(RHYOLITE.get())));
    public static final RegistryObject<Block> POLISHED_RHYOLITE_BRICK_STAIRS = registerBlock("polished_rhyolite_brick_stairs", () -> new StairBlock(() -> POLISHED_RHYOLITE_BRICKS.get().defaultBlockState(), BlockBehaviour.Properties.copy(POLISHED_RHYOLITE_BRICKS.get())));
    public static final RegistryObject<Block> POLISHED_RHYOLITE_BRICK_SLAB = registerBlock("polished_rhyolite_brick_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(POLISHED_RHYOLITE_BRICKS.get())));
    public static final RegistryObject<Block> POLISHED_RHYOLITE_BRICK_WALL = registerBlock("polished_rhyolite_brick_wall", () -> new WallBlock(BlockBehaviour.Properties.copy(POLISHED_RHYOLITE_BRICKS.get())));
    public static final RegistryObject<Block> POLISHED_RHYOLITE_BRICK_VERTICAL_SLAB = registerCompatBlock("quark", "polished_rhyolite_brick_vertical_slab", () -> new VerticalSlabBlock(BlockBehaviour.Properties.copy(POLISHED_RHYOLITE_BRICKS.get())));
    public static final RegistryObject<Block> CRACKED_POLISHED_RHYOLITE_BRICKS = registerBlock("cracked_polished_rhyolite_bricks", () -> new Block(BlockBehaviour.Properties.copy(POLISHED_RHYOLITE_BRICKS.get())));

    //schist blocks
    public static final RegistryObject<Block> SCHIST = registerBlock("schist", () -> new Block(BlockBehaviour.Properties.copy(Blocks.CALCITE)));
    public static final RegistryObject<Block> SCHIST_STAIRS = registerBlock("schist_stairs", () -> new StairBlock(() -> SCHIST.get().defaultBlockState(), BlockBehaviour.Properties.copy(SCHIST.get())));
    public static final RegistryObject<Block> SCHIST_SLAB = registerBlock("schist_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(SCHIST.get())));
    public static final RegistryObject<Block> SCHIST_WALL = registerBlock("schist_wall", () -> new WallBlock(BlockBehaviour.Properties.copy(SCHIST.get())));
    public static final RegistryObject<Block> SCHIST_VERTICAL_SLAB = registerCompatBlock("quark", "schist_vertical_slab", () -> new VerticalSlabBlock(BlockBehaviour.Properties.copy(SCHIST.get())));
    public static final RegistryObject<Block> POLISHED_SCHIST = registerBlock("polished_schist", () -> new Block(BlockBehaviour.Properties.copy(SCHIST.get())));
    public static final RegistryObject<Block> POLISHED_SCHIST_STAIRS = registerBlock("polished_schist_stairs", () -> new StairBlock(() -> POLISHED_SCHIST.get().defaultBlockState(), BlockBehaviour.Properties.copy(POLISHED_SCHIST.get())));
    public static final RegistryObject<Block> POLISHED_SCHIST_SLAB = registerBlock("polished_schist_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(POLISHED_SCHIST.get())));
    public static final RegistryObject<Block> POLISHED_SCHIST_VERTICAL_SLAB = registerCompatBlock("quark", "polished_schist_vertical_slab", () -> new VerticalSlabBlock(BlockBehaviour.Properties.copy(POLISHED_SCHIST.get())));
    public static final RegistryObject<Block> POLISHED_SCHIST_BRICKS = registerBlock("polished_schist_bricks", () -> new Block(BlockBehaviour.Properties.copy(SCHIST.get())));
    public static final RegistryObject<Block> POLISHED_SCHIST_BRICK_STAIRS = registerBlock("polished_schist_brick_stairs", () -> new StairBlock(() -> POLISHED_SCHIST_BRICKS.get().defaultBlockState(), BlockBehaviour.Properties.copy(POLISHED_SCHIST_BRICKS.get())));
    public static final RegistryObject<Block> POLISHED_SCHIST_BRICK_SLAB = registerBlock("polished_schist_brick_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(POLISHED_SCHIST_BRICKS.get())));
    public static final RegistryObject<Block> POLISHED_SCHIST_BRICK_WALL = registerBlock("polished_schist_brick_wall", () -> new WallBlock(BlockBehaviour.Properties.copy(POLISHED_SCHIST_BRICKS.get())));
    public static final RegistryObject<Block> POLISHED_SCHIST_BRICK_VERTICAL_SLAB = registerCompatBlock("quark", "polished_schist_brick_vertical_slab", () -> new VerticalSlabBlock(BlockBehaviour.Properties.copy(POLISHED_SCHIST_BRICKS.get())));
    public static final RegistryObject<Block> CRACKED_POLISHED_SCHIST_BRICKS = registerBlock("cracked_polished_schist_bricks", () -> new Block(BlockBehaviour.Properties.copy(POLISHED_SCHIST_BRICKS.get())));

    //bloodstone blocks
    public static final RegistryObject<Block> BLOODSTONE = registerBlock("bloodstone", () -> new Block(BlockBehaviour.Properties.copy(Blocks.BASALT)));
    public static final RegistryObject<Block> BLOODSTONE_STAIRS = registerBlock("bloodstone_stairs", () -> new StairBlock(() -> BLOODSTONE.get().defaultBlockState(), BlockBehaviour.Properties.copy(BLOODSTONE.get())));
    public static final RegistryObject<Block> BLOODSTONE_SLAB = registerBlock("bloodstone_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(BLOODSTONE.get())));
    public static final RegistryObject<Block> BLOODSTONE_WALL = registerBlock("bloodstone_wall", () -> new WallBlock(BlockBehaviour.Properties.copy(BLOODSTONE.get())));
    public static final RegistryObject<Block> BLOODSTONE_VERTICAL_SLAB = registerCompatBlock("quark", "bloodstone_vertical_slab", () -> new VerticalSlabBlock(BlockBehaviour.Properties.copy(BLOODSTONE.get())));
    public static final RegistryObject<Block> POLISHED_BLOODSTONE = registerBlock("polished_bloodstone", () -> new Block(BlockBehaviour.Properties.copy(BLOODSTONE.get())));
    public static final RegistryObject<Block> POLISHED_BLOODSTONE_STAIRS = registerBlock("polished_bloodstone_stairs", () -> new StairBlock(() -> POLISHED_BLOODSTONE.get().defaultBlockState(), BlockBehaviour.Properties.copy(POLISHED_BLOODSTONE.get())));
    public static final RegistryObject<Block> POLISHED_BLOODSTONE_SLAB = registerBlock("polished_bloodstone_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(POLISHED_BLOODSTONE.get())));
    public static final RegistryObject<Block> POLISHED_BLOODSTONE_VERTICAL_SLAB = registerCompatBlock("quark", "polished_bloodstone_vertical_slab", () -> new VerticalSlabBlock(BlockBehaviour.Properties.copy(POLISHED_BLOODSTONE.get())));
    public static final RegistryObject<Block> POLISHED_BLOODSTONE_BRICKS = registerBlock("polished_bloodstone_bricks", () -> new Block(BlockBehaviour.Properties.copy(BLOODSTONE.get())));
    public static final RegistryObject<Block> POLISHED_BLOODSTONE_BRICK_STAIRS = registerBlock("polished_bloodstone_brick_stairs", () -> new StairBlock(() -> POLISHED_BLOODSTONE_BRICKS.get().defaultBlockState(), BlockBehaviour.Properties.copy(POLISHED_BLOODSTONE_BRICKS.get())));
    public static final RegistryObject<Block> POLISHED_BLOODSTONE_BRICK_SLAB = registerBlock("polished_bloodstone_brick_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(POLISHED_BLOODSTONE_BRICKS.get())));
    public static final RegistryObject<Block> POLISHED_BLOODSTONE_BRICK_WALL = registerBlock("polished_bloodstone_brick_wall", () -> new WallBlock(BlockBehaviour.Properties.copy(POLISHED_BLOODSTONE_BRICKS.get())));
    public static final RegistryObject<Block> POLISHED_BLOODSTONE_BRICK_VERTICAL_SLAB = registerCompatBlock("quark", "polished_bloodstone_brick_vertical_slab", () -> new VerticalSlabBlock(BlockBehaviour.Properties.copy(POLISHED_BLOODSTONE_BRICKS.get())));
    public static final RegistryObject<Block> CRACKED_POLISHED_BLOODSTONE_BRICKS = registerBlock("cracked_polished_bloodstone_bricks", () -> new Block(BlockBehaviour.Properties.copy(POLISHED_BLOODSTONE_BRICKS.get())));

    public static final RegistryObject<Block> STRIPPED_BAMBOO_SIGN = registerBlockWithNoTab("stripped_bamboo_sign", () -> new TwigsSignBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.TERRACOTTA_WHITE).noCollission().strength(1.0F).sound(SoundType.SCAFFOLDING), TwigsWoodType.STRIPPED_BAMBOO));
    public static final RegistryObject<Block> STRIPPED_BAMBOO_WALL_SIGN = registerBlockWithNoTab("stripped_bamboo_wall_sign", () -> new TwigsWallSignBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.TERRACOTTA_WHITE).noCollission().strength(1.0F).sound(SoundType.SCAFFOLDING).lootFrom(STRIPPED_BAMBOO_SIGN), TwigsWoodType.STRIPPED_BAMBOO));

    public static <B extends Block> RegistryObject<B> registerBlock(String name, Supplier<? extends B> block) {
        RegistryObject<B> blocks = BLOCKS.register(name, block);
        TwigsItems.ITEMS.register(name, () -> new BlockItem(blocks.get(), new Item.Properties().tab(Twigs.ITEM_GROUP)));
        return blocks;
    }

    public static <B extends Block> RegistryObject<B> registerBlockWithNoTab(String name, Supplier<? extends B> block) {
        return BLOCKS.register(name, block);
    }

    public static <B extends Block> RegistryObject<B> registerCompatBlock(String modid, String name, Supplier<? extends B> block) {
        RegistryObject<B> blocks = BLOCKS.register(name, block);
        TwigsItems.ITEMS.register(name, () -> new BlockItem(blocks.get(), new Item.Properties().tab(ModList.get().isLoaded(modid) ? Twigs.ITEM_GROUP : null)));
        return blocks;
    }

}
