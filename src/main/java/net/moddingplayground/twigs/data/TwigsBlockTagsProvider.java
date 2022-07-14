package net.moddingplayground.twigs.data;

import net.minecraft.core.Registry;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.WallBlock;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.registries.ForgeRegistries;
import net.moddingplayground.twigs.Twigs;
import net.moddingplayground.twigs.block.PaperLanternBlock;
import net.moddingplayground.twigs.block.TableBlock;
import net.moddingplayground.twigs.block.VerticalSlabBlock;
import net.moddingplayground.twigs.init.TwigsBlockTags;
import net.moddingplayground.twigs.init.TwigsBlocks;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class TwigsBlockTagsProvider extends BlockTagsProvider {

    public TwigsBlockTagsProvider(DataGenerator dataGenerator, @Nullable ExistingFileHelper existingFileHelper) {
        super(dataGenerator, Twigs.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags() {
        this.tag(BlockTags.MINEABLE_WITH_AXE).add(TwigsBlocks.STRIPPED_BAMBOO.get(), TwigsBlocks.STRIPPED_BUNDLED_BAMBOO.get(), TwigsBlocks.STRIPPED_BAMBOO_MAT.get(), TwigsBlocks.BUNDLED_BAMBOO.get(), TwigsBlocks.CRIMSON_SHROOMLAMP.get(), TwigsBlocks.WARPED_SHROOMLAMP.get(), TwigsBlocks.AZALEA_FLOWERS.get());
        this.tag(BlockTags.MINEABLE_WITH_HOE).add(TwigsBlocks.CRIMSON_SHROOMLAMP.get(), TwigsBlocks.WARPED_SHROOMLAMP.get(), TwigsBlocks.BAMBOO_THATCH.get(), TwigsBlocks.BAMBOO_THATCH_STAIRS.get(), TwigsBlocks.BAMBOO_THATCH_SLAB.get(), TwigsBlocks.BAMBOO_THATCH_VERTICAL_SLAB.get());
        this.tag(BlockTags.MINEABLE_WITH_PICKAXE).add(TwigsBlocks.LAMP.get(), TwigsBlocks.SOUL_LAMP.get(), TwigsBlocks.ROCKY_DIRT.get(), TwigsBlocks.MOSSY_BRICKS.get(), TwigsBlocks.POLISHED_BASALT_BRICKS.get(), TwigsBlocks.CRACKED_BRICKS.get(), TwigsBlocks.CHISELED_BRICKS.get(), TwigsBlocks.MOSSY_BRICK_SLAB.get(), TwigsBlocks.MOSSY_BRICK_STAIRS.get(), TwigsBlocks.MOSSY_BRICK_WALL.get(), TwigsBlocks.SMOOTH_BASALT_BRICKS.get(), TwigsBlocks.SMOOTH_BASALT_BRICK_SLAB.get(), TwigsBlocks.SMOOTH_BASALT_BRICK_STAIRS.get(), TwigsBlocks.SMOOTH_BASALT_BRICK_WALL.get(), TwigsBlocks.MOSSY_COBBLESTONE_BRICKS.get(), TwigsBlocks.MOSSY_COBBLESTONE_BRICK_SLAB.get(), TwigsBlocks.MOSSY_COBBLESTONE_BRICK_STAIRS.get(), TwigsBlocks.MOSSY_COBBLESTONE_BRICK_WALL.get(), TwigsBlocks.COBBLESTONE_BRICKS.get(), TwigsBlocks.COBBLESTONE_BRICK_SLAB.get(), TwigsBlocks.COBBLESTONE_BRICK_STAIRS.get(), TwigsBlocks.COBBLESTONE_BRICK_WALL.get(), TwigsBlocks.CRACKED_COBBLESTONE_BRICKS.get(), TwigsBlocks.POLISHED_AMETHYST.get(), TwigsBlocks.POLISHED_AMETHYST_SLAB.get(), TwigsBlocks.POLISHED_AMETHYST_STAIRS.get(), TwigsBlocks.POLISHED_AMETHYST_BRICKS.get(), TwigsBlocks.POLISHED_AMETHYST_BRICK_SLAB.get(), TwigsBlocks.POLISHED_AMETHYST_BRICK_STAIRS.get(), TwigsBlocks.POLISHED_AMETHYST_BRICK_WALL.get(), TwigsBlocks.CHISELED_POLISHED_AMETHYST.get(), TwigsBlocks.CRACKED_POLISHED_AMETHYST_BRICKS.get(), TwigsBlocks.WEEPING_POLISHED_BLACKSTONE_BRICKS.get(), TwigsBlocks.WEEPING_POLISHED_BLACKSTONE_BRICK_STAIRS.get(), TwigsBlocks.WEEPING_POLISHED_BLACKSTONE_BRICK_SLAB.get(), TwigsBlocks.WEEPING_POLISHED_BLACKSTONE_BRICK_WALL.get(), TwigsBlocks.TWISTING_POLISHED_BLACKSTONE_BRICKS.get(), TwigsBlocks.TWISTING_POLISHED_BLACKSTONE_BRICK_SLAB.get(), TwigsBlocks.TWISTING_POLISHED_BLACKSTONE_BRICK_STAIRS.get(), TwigsBlocks.TWISTING_POLISHED_BLACKSTONE_BRICK_WALL.get(), TwigsBlocks.SCHIST.get(), TwigsBlocks.SCHIST_SLAB.get(), TwigsBlocks.SCHIST_STAIRS.get(), TwigsBlocks.SCHIST_WALL.get(), TwigsBlocks.POLISHED_SCHIST.get(), TwigsBlocks.POLISHED_SCHIST_SLAB.get(), TwigsBlocks.POLISHED_SCHIST_STAIRS.get(), TwigsBlocks.CRACKED_POLISHED_SCHIST_BRICKS.get(), TwigsBlocks.POLISHED_SCHIST_BRICKS.get(), TwigsBlocks.POLISHED_SCHIST_BRICK_SLAB.get(), TwigsBlocks.POLISHED_SCHIST_BRICK_STAIRS.get(), TwigsBlocks.POLISHED_SCHIST_BRICK_WALL.get(), TwigsBlocks.RHYOLITE.get(), TwigsBlocks.RHYOLITE_SLAB.get(), TwigsBlocks.RHYOLITE_STAIRS.get(), TwigsBlocks.RHYOLITE_WALL.get(), TwigsBlocks.POLISHED_RHYOLITE.get(), TwigsBlocks.POLISHED_RHYOLITE_SLAB.get(), TwigsBlocks.POLISHED_RHYOLITE_STAIRS.get(), TwigsBlocks.CRACKED_POLISHED_RHYOLITE_BRICKS.get(), TwigsBlocks.POLISHED_RHYOLITE_BRICKS.get(), TwigsBlocks.POLISHED_RHYOLITE_BRICK_SLAB.get(), TwigsBlocks.POLISHED_RHYOLITE_BRICK_STAIRS.get(), TwigsBlocks.POLISHED_RHYOLITE_BRICK_WALL.get(), TwigsBlocks.BLOODSTONE.get(), TwigsBlocks.BLOODSTONE_SLAB.get(), TwigsBlocks.BLOODSTONE_STAIRS.get(), TwigsBlocks.BLOODSTONE_WALL.get(), TwigsBlocks.POLISHED_BLOODSTONE.get(), TwigsBlocks.POLISHED_BLOODSTONE_SLAB.get(), TwigsBlocks.POLISHED_BLOODSTONE_STAIRS.get(), TwigsBlocks.CRACKED_POLISHED_BLOODSTONE_BRICKS.get(), TwigsBlocks.POLISHED_BLOODSTONE_BRICKS.get(), TwigsBlocks.POLISHED_BLOODSTONE_BRICK_SLAB.get(), TwigsBlocks.POLISHED_BLOODSTONE_BRICK_STAIRS.get(), TwigsBlocks.POLISHED_BLOODSTONE_BRICK_WALL.get(), TwigsBlocks.TUFF_SLAB.get(), TwigsBlocks.TUFF_STAIRS.get(), TwigsBlocks.TUFF_WALL.get(), TwigsBlocks.POLISHED_TUFF.get(), TwigsBlocks.POLISHED_TUFF_SLAB.get(), TwigsBlocks.POLISHED_TUFF_STAIRS.get(), TwigsBlocks.CRACKED_POLISHED_TUFF_BRICKS.get(), TwigsBlocks.POLISHED_TUFF_BRICKS.get(), TwigsBlocks.POLISHED_TUFF_BRICK_SLAB.get(), TwigsBlocks.POLISHED_TUFF_BRICK_STAIRS.get(), TwigsBlocks.POLISHED_TUFF_BRICK_WALL.get(), TwigsBlocks.CALCITE_SLAB.get(), TwigsBlocks.CALCITE_STAIRS.get(), TwigsBlocks.CALCITE_WALL.get(), TwigsBlocks.POLISHED_CALCITE.get(), TwigsBlocks.POLISHED_CALCITE_SLAB.get(), TwigsBlocks.POLISHED_CALCITE_STAIRS.get(), TwigsBlocks.CRACKED_POLISHED_CALCITE_BRICKS.get(), TwigsBlocks.POLISHED_CALCITE_BRICKS.get(), TwigsBlocks.POLISHED_CALCITE_BRICK_SLAB.get(), TwigsBlocks.POLISHED_CALCITE_BRICK_STAIRS.get(), TwigsBlocks.POLISHED_CALCITE_BRICK_WALL.get(), TwigsBlocks.COPPER_PILLAR.get(), TwigsBlocks.WAXED_COPPER_PILLAR.get(), TwigsBlocks.EXPOSED_COPPER_PILLAR.get(), TwigsBlocks.WAXED_EXPOSED_COPPER_PILLAR.get(), TwigsBlocks.WEATHERED_COPPER_PILLAR.get(), TwigsBlocks.WAXED_WEATHERED_COPPER_PILLAR.get(), TwigsBlocks.OXIDIZED_COPPER_PILLAR.get(), TwigsBlocks.WAXED_OXIDIZED_COPPER_PILLAR.get(), TwigsBlocks.ENDER_MESH.get(), TwigsBlocks.PETRIFIED_LICHEN.get());
        this.tag(BlockTags.CRYSTAL_SOUND_BLOCKS).add(TwigsBlocks.POLISHED_AMETHYST.get(), TwigsBlocks.POLISHED_AMETHYST_STAIRS.get(), TwigsBlocks.POLISHED_AMETHYST_SLAB.get(), TwigsBlocks.CHISELED_POLISHED_AMETHYST.get(), TwigsBlocks.POLISHED_AMETHYST_BRICKS.get(), TwigsBlocks.POLISHED_AMETHYST_BRICK_STAIRS.get(), TwigsBlocks.POLISHED_AMETHYST_BRICK_SLAB.get(), TwigsBlocks.POLISHED_AMETHYST_BRICK_WALL.get(), TwigsBlocks.CRACKED_POLISHED_AMETHYST_BRICKS.get());
        this.tag(BlockTags.PLANKS).add(TwigsBlocks.STRIPPED_BAMBOO_PLANKS.get());
        this.tag(BlockTags.STANDING_SIGNS).add(TwigsBlocks.STRIPPED_BAMBOO_SIGN.get());
        this.tag(BlockTags.WALL_SIGNS).add(TwigsBlocks.STRIPPED_BAMBOO_WALL_SIGN.get());
        this.tag(BlockTags.FENCE_GATES).add(TwigsBlocks.STRIPPED_BAMBOO_FENCE_GATE.get());
        this.tag(BlockTags.WOODEN_BUTTONS).add(TwigsBlocks.STRIPPED_BAMBOO_BUTTON.get());
        this.tag(BlockTags.WOODEN_DOORS).add(TwigsBlocks.STRIPPED_BAMBOO_DOOR.get());
        this.tag(BlockTags.WOODEN_FENCES).add(TwigsBlocks.STRIPPED_BAMBOO_FENCE.get());
        this.tag(BlockTags.WOODEN_PRESSURE_PLATES).add(TwigsBlocks.STRIPPED_BAMBOO_PRESSURE_PLATE.get());
        this.tag(BlockTags.WOODEN_SLABS).add(TwigsBlocks.STRIPPED_BAMBOO_SLAB.get());
        this.tag(BlockTags.WOODEN_STAIRS).add(TwigsBlocks.STRIPPED_BAMBOO_STAIRS.get());
        this.tag(BlockTags.WOODEN_TRAPDOORS).add(TwigsBlocks.STRIPPED_BAMBOO_TRAPDOOR.get());
        this.tag(BlockTags.REPLACEABLE_PLANTS).add(TwigsBlocks.AZALEA_FLOWERS.get(), TwigsBlocks.PETRIFIED_LICHEN.get());
        this.tag(BlockTags.FLOWER_POTS).add(TwigsBlocks.POTTED_AZALEA_FLOWERS.get());
        this.tag(BlockTags.BASE_STONE_OVERWORLD).add(TwigsBlocks.SCHIST.get(), TwigsBlocks.RHYOLITE.get());
        this.tag(BlockTags.PIGLIN_REPELLENTS).add(TwigsBlocks.SOUL_LAMP.get());
        this.tag(BlockTags.DIRT).add(TwigsBlocks.ROCKY_DIRT.get());
        this.tag(BlockTags.FOXES_SPAWNABLE_ON).add(TwigsBlocks.ROCKY_DIRT.get());
        this.tag(BlockTags.ENDERMAN_HOLDABLE).add(TwigsBlocks.ROCKY_DIRT.get());
        this.tag(BlockTags.BAMBOO_PLANTABLE_ON).add(TwigsBlocks.ROCKY_DIRT.get());
        for (Block block : ForgeRegistries.BLOCKS) {
            if (ModList.get().isLoaded(Twigs.MOD_ID)) {
                if (block instanceof WallBlock) {
                    this.tag(BlockTags.WALLS).add(block);
                }
                if (block instanceof SlabBlock) {
                    this.tag(BlockTags.SLABS).add(block);
                }
                if (block instanceof StairBlock) {
                    this.tag(BlockTags.STAIRS).add(block);
                }
                if (block instanceof TableBlock) {
                    this.tag(TwigsBlockTags.TABLES).add(block);
                }
                if (block instanceof PaperLanternBlock) {
                    this.tag(TwigsBlockTags.PAPER_LANTERN).add(block);
                }
            }
        }
        for (Block block : ForgeRegistries.BLOCKS) {
            if (block instanceof VerticalSlabBlock) {
                this.tag(quarkTag("vertical_slabs")).add(block);
            }
        }
        this.tag(quarkTag("wooden_vertical_slabs")).add(TwigsBlocks.STRIPPED_BAMBOO_PLANKS_VERTICAL_SLAB.get());
        this.tag(quarkTag("planks_vertical_slab")).add(TwigsBlocks.STRIPPED_BAMBOO_PLANKS_VERTICAL_SLAB.get());
    }

    @NotNull
    private TagKey<Block> quarkTag(String id) {
        return TagKey.create(Registry.BLOCK_REGISTRY, new ResourceLocation("quark", id));
    }
}
