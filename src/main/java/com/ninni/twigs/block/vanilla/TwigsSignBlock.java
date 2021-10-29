package com.ninni.twigs.block.vanilla;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.SignBlock;
import net.minecraft.util.Identifier;
import net.minecraft.util.SignType;

import java.util.Objects;

import static com.ninni.twigs.Twigs.MOD_ID;

public class TwigsSignBlock extends SignBlock {

    public TwigsSignBlock(AbstractBlock.Settings settings, SignType type) {
        super(settings, type);
    }

    @Override
    public final Identifier getLootTableId() {
        Identifier correctedLootTableId = new Identifier(MOD_ID, "blocks/" + this.getSignType().getName() + "_sign");
        if (!Objects.equals(this.lootTableId, correctedLootTableId)) {
            this.lootTableId = correctedLootTableId;
        }

        return this.lootTableId;
    }
}
