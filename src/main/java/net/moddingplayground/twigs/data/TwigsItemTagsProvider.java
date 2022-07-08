package net.moddingplayground.twigs.data;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.WallBlock;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.registries.ForgeRegistries;
import net.moddingplayground.twigs.Twigs;
import net.moddingplayground.twigs.init.TwigsBlockTags;
import net.moddingplayground.twigs.init.TwigsBlocks;
import net.moddingplayground.twigs.init.TwigsItemTags;
import net.moddingplayground.twigs.init.TwigsItems;
import org.jetbrains.annotations.Nullable;

public class TwigsItemTagsProvider extends ItemTagsProvider {

    public TwigsItemTagsProvider(DataGenerator dataGenerator, @Nullable ExistingFileHelper existingFileHelper) {
        super(dataGenerator, new TwigsBlockTagsProvider(dataGenerator, existingFileHelper), Twigs.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags() {
        this.tag(TwigsItemTags.TABLES).add(TwigsBlocks.STRIPPED_BAMBOO_TABLE.get().asItem(), TwigsBlocks.OAK_TABLE.get().asItem(), TwigsBlocks.SPRUCE_TABLE.get().asItem(), TwigsBlocks.BIRCH_TABLE.get().asItem(), TwigsBlocks.JUNGLE_TABLE.get().asItem(), TwigsBlocks.ACACIA_TABLE.get().asItem(), TwigsBlocks.DARK_OAK_TABLE.get().asItem(), TwigsBlocks.CRIMSON_TABLE.get().asItem(), TwigsBlocks.WARPED_TABLE.get().asItem());
        this.tag(TwigsItemTags.PAPER_LANTERNS).add(TwigsBlocks.PAPER_LANTERN.get().asItem(), TwigsBlocks.ALLIUM_PAPER_LANTERN.get().asItem(), TwigsBlocks.BLUE_ORCHID_PAPER_LANTERN.get().asItem(), TwigsBlocks.CRIMSON_ROOTS_PAPER_LANTERN.get().asItem(), TwigsBlocks.DANDELION_PAPER_LANTERN.get().asItem());
        this.tag(ItemTags.PIGLIN_REPELLENTS).add(TwigsBlocks.SOUL_LAMP.get().asItem());
        this.tag(ItemTags.STONE_CRAFTING_MATERIALS).add(TwigsBlocks.SCHIST.get().asItem(), TwigsBlocks.RHYOLITE.get().asItem());
        this.tag(ItemTags.STONE_TOOL_MATERIALS).add(TwigsBlocks.SCHIST.get().asItem(), TwigsBlocks.RHYOLITE.get().asItem());
        this.tag(ItemTags.BOATS).add(TwigsItems.STRIPPED_BAMBOO_BOAT.get());
        this.tag(ItemTags.CHEST_BOATS).add(TwigsItems.STRIPPED_BAMBOO_CHEST_BOAT.get());
        this.tag(ItemTags.DIRT).add(TwigsBlocks.ROCKY_DIRT.get().asItem());
        this.tag(ItemTags.PIGLIN_REPELLENTS).add(TwigsBlocks.SOUL_LAMP.get().asItem());
        this.tag(ItemTags.PLANKS).add(TwigsBlocks.STRIPPED_BAMBOO_PLANKS.get().asItem());
        this.tag(ItemTags.SIGNS).add(TwigsBlocks.STRIPPED_BAMBOO_SIGN.get().asItem());
        for (Block block : ForgeRegistries.BLOCKS) {
            if (ModList.get().isLoaded(Twigs.MOD_ID)) {
                if (block instanceof SlabBlock) {
                    this.tag(ItemTags.SLABS).add(block.asItem());
                }
                if (block instanceof StairBlock) {
                    this.tag(ItemTags.STAIRS).add(block.asItem());
                }
                if (block instanceof WallBlock) {
                    this.tag(ItemTags.WALLS).add(block.asItem());
                }
            }
        }
        this.tag(ItemTags.WOODEN_BUTTONS).add(TwigsBlocks.STRIPPED_BAMBOO_BUTTON.get().asItem());
        this.tag(ItemTags.WOODEN_DOORS).add(TwigsBlocks.STRIPPED_BAMBOO_DOOR.get().asItem());
        this.tag(ItemTags.WOODEN_FENCES).add(TwigsBlocks.STRIPPED_BAMBOO_FENCE.get().asItem());
        this.tag(ItemTags.WOODEN_PRESSURE_PLATES).add(TwigsBlocks.STRIPPED_BAMBOO_PRESSURE_PLATE.get().asItem());
        this.tag(ItemTags.WOODEN_SLABS).add(TwigsBlocks.STRIPPED_BAMBOO_SLAB.get().asItem());
        this.tag(ItemTags.WOODEN_STAIRS).add(TwigsBlocks.STRIPPED_BAMBOO_STAIRS.get().asItem());
        this.tag(ItemTags.WOODEN_TRAPDOORS).add(TwigsBlocks.STRIPPED_BAMBOO_TRAPDOOR.get().asItem());
    }
}
