package net.moddingplayground.twigs.data;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.moddingplayground.twigs.Twigs;
import net.moddingplayground.twigs.init.TwigsBlockTags;
import net.moddingplayground.twigs.init.TwigsBlocks;
import org.jetbrains.annotations.Nullable;

public class TwigsBlockTagsProvider extends BlockTagsProvider {

    public TwigsBlockTagsProvider(DataGenerator dataGenerator, @Nullable ExistingFileHelper existingFileHelper) {
        super(dataGenerator, Twigs.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags() {
        this.tag(TwigsBlockTags.PAPER_LANTERN).add(TwigsBlocks.PAPER_LANTERN.get(), TwigsBlocks.ALLIUM_PAPER_LANTERN.get(), TwigsBlocks.BLUE_ORCHID_PAPER_LANTERN.get(), TwigsBlocks.CRIMSON_ROOTS_PAPER_LANTERN.get(), TwigsBlocks.DANDELION_PAPER_LANTERN.get());
        this.tag(TwigsBlockTags.TABLES).add(TwigsBlocks.STRIPPED_BAMBOO_TABLE.get(), TwigsBlocks.OAK_TABLE.get(), TwigsBlocks.SPRUCE_TABLE.get(), TwigsBlocks.BIRCH_TABLE.get(), TwigsBlocks.JUNGLE_TABLE.get(), TwigsBlocks.ACACIA_TABLE.get(), TwigsBlocks.DARK_OAK_TABLE.get(), TwigsBlocks.CRIMSON_TABLE.get(), TwigsBlocks.WARPED_TABLE.get());
    }
}
