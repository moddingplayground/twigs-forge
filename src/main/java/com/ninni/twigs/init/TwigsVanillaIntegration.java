package com.ninni.twigs.init;

import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.ComposterBlock;
import net.minecraft.world.level.block.FireBlock;

public class TwigsVanillaIntegration {

    public static void init() {
        registerCompostable(0.5F, TwigsBlocks.BAMBOO_LEAVES.get());
        registerFlammables(TwigsBlocks.AZALEA_FLOWERS.get(),30, 60);
        registerFlammables(TwigsBlocks.TWIG.get(),30, 60);
        registerFlammables(TwigsBlocks.BAMBOO_LEAVES.get(),30, 60);
        registerFlammables(TwigsBlocks.BAMBOO_THATCH.get(),30, 60);
        registerFlammables(TwigsBlocks.BAMBOO_THATCH_SLAB.get(), 30, 60);
        registerFlammables(TwigsBlocks.BAMBOO_THATCH_STAIRS.get(), 30, 60);
        registerFlammables(TwigsBlocks.OAK_TABLE.get(), 5, 20);
        registerFlammables(TwigsBlocks.SPRUCE_TABLE.get(), 5, 20);
        registerFlammables(TwigsBlocks.BIRCH_TABLE.get(), 5, 20);
        registerFlammables(TwigsBlocks.ACACIA_TABLE.get(), 5, 20);
        registerFlammables(TwigsBlocks.JUNGLE_TABLE.get(), 5, 20);
        registerFlammables(TwigsBlocks.DARK_OAK_TABLE.get(), 5, 20);
        registerFlammables(TwigsBlocks.STRIPPED_BAMBOO_TABLE.get(), 5, 20);
        registerFlammables(TwigsBlocks.STRIPPED_BAMBOO.get(), 5, 20);
        registerFlammables(TwigsBlocks.STRIPPED_BAMBOO_PLANKS.get(), 5, 20);
        registerFlammables(TwigsBlocks.STRIPPED_BAMBOO_STAIRS.get(), 5, 20);
        registerFlammables(TwigsBlocks.STRIPPED_BAMBOO_SLAB.get(), 5, 20);
        registerFlammables(TwigsBlocks.STRIPPED_BAMBOO_FENCE.get(), 5, 20);
        registerFlammables(TwigsBlocks.STRIPPED_BAMBOO_FENCE_GATE.get(), 5, 20);
        registerFlammables(TwigsBlocks.STRIPPED_BAMBOO_BUTTON.get(), 5, 20);
        registerFlammables(TwigsBlocks.STRIPPED_BAMBOO_TRAPDOOR.get(), 5, 20);
        registerFlammables(TwigsBlocks.STRIPPED_BAMBOO_DOOR.get(), 5, 20);
        registerFlammables(TwigsBlocks.STRIPPED_BAMBOO_PRESSURE_PLATE.get(), 5, 20);
    }

    public static void registerFlammables(Block block, int burn, int spread) {
        FireBlock fireBlock = (FireBlock) Blocks.FIRE;
        fireBlock.setFlammable(block, burn, spread);
    }

    public static void registerCompostable(float chance, ItemLike item) {
        ComposterBlock.COMPOSTABLES.put(item, chance);
    }

}
