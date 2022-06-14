package net.moddingplayground.twigs.data;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.data.tags.EntityTypeTagsProvider;
import net.minecraft.world.entity.EntityType;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.moddingplayground.twigs.Twigs;
import net.moddingplayground.twigs.init.TwigsBlockTags;
import net.moddingplayground.twigs.init.TwigsBlocks;
import net.moddingplayground.twigs.init.TwigsEntityTypeTags;
import org.jetbrains.annotations.Nullable;

public class TwigsEntityTypeTagsProvider extends EntityTypeTagsProvider {

    public TwigsEntityTypeTagsProvider(DataGenerator dataGenerator, @Nullable ExistingFileHelper existingFileHelper) {
        super(dataGenerator, Twigs.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags() {
        this.tag(TwigsEntityTypeTags.BAMBOO_LEAVES_SLOW_IMMUNE).add(EntityType.PANDA, EntityType.BEE, EntityType.PARROT, EntityType.OCELOT);
    }
}
