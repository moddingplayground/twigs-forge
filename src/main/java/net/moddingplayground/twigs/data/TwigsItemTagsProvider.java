package net.moddingplayground.twigs.data;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.moddingplayground.twigs.Twigs;
import net.moddingplayground.twigs.init.TwigsBlockTags;
import net.moddingplayground.twigs.init.TwigsBlocks;
import net.moddingplayground.twigs.init.TwigsItemTags;
import org.jetbrains.annotations.Nullable;

public class TwigsItemTagsProvider extends ItemTagsProvider {

    public TwigsItemTagsProvider(DataGenerator dataGenerator, @Nullable ExistingFileHelper existingFileHelper) {
        super(dataGenerator, new TwigsBlockTagsProvider(dataGenerator, existingFileHelper), Twigs.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags() {
        this.tag(TwigsItemTags.PAPER_LANTERNS).add(TwigsBlocks.PAPER_LANTERN.get().asItem(), TwigsBlocks.ALLIUM_PAPER_LANTERN.get().asItem(), TwigsBlocks.BLUE_ORCHID_PAPER_LANTERN.get().asItem(), TwigsBlocks.CRIMSON_ROOTS_PAPER_LANTERN.get().asItem(), TwigsBlocks.DANDELION_PAPER_LANTERN.get().asItem());
        this.tag(TwigsItemTags.TABLES).add(TwigsBlocks.STRIPPED_BAMBOO_TABLE.get().asItem(), TwigsBlocks.OAK_TABLE.get().asItem(), TwigsBlocks.SPRUCE_TABLE.get().asItem(), TwigsBlocks.BIRCH_TABLE.get().asItem(), TwigsBlocks.JUNGLE_TABLE.get().asItem(), TwigsBlocks.ACACIA_TABLE.get().asItem(), TwigsBlocks.DARK_OAK_TABLE.get().asItem(), TwigsBlocks.CRIMSON_TABLE.get().asItem(), TwigsBlocks.WARPED_TABLE.get().asItem());
    }
}
