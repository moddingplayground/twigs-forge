package com.ninni.twigs.init;

import com.google.common.base.Suppliers;
import com.google.common.collect.Maps;
import com.mojang.datafixers.util.Pair;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.HoneycombItem;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.ComposterBlock;
import net.minecraft.world.level.block.FireBlock;
import net.minecraft.world.level.block.WeatheringCopper;

import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class TwigsVanillaIntegration {

    public static void init() {
        registerCompostable(0.5F, TwigsBlocks.BAMBOO_LEAVES.get());
        registerFlammables(TwigsBlocks.AZALEA_FLOWERS.get(),30, 60);
        registerFlammables(TwigsBlocks.TWIG.get(),30, 60);
        registerFlammables(TwigsBlocks.BAMBOO_LEAVES.get(),30, 60);
        registerFlammables(TwigsBlocks.BAMBOO_THATCH.get(),30, 60);
        registerFlammables(TwigsBlocks.BAMBOO_THATCH_SLAB.get(), 30, 60);
        registerFlammables(TwigsBlocks.BAMBOO_THATCH_STAIRS.get(), 30, 60);
        registerFlammables(TwigsBlocks.STRIPPED_BAMBOO.get(), 5, 20);
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
        registerStrippable(TwigsBlocks.BUNDLED_BAMBOO.get(), TwigsBlocks.STRIPPED_BUNDLED_BAMBOO.get());
        registerTillables(TwigsBlocks.ROCKY_DIRT.get(), Pair.of(useOnContext -> true, HoeItem.changeIntoStateAndDropItem(Blocks.COARSE_DIRT.defaultBlockState(), TwigsBlocks.PEBBLE.get().asItem())));
    }

    public static void registerTillables(Block block, Pair<Predicate<UseOnContext>, Consumer<UseOnContext>> pair) {
        HoeItem.TILLABLES = Maps.newHashMap(HoeItem.TILLABLES);
        HoeItem.TILLABLES.put(block, pair);
    }

    public static void registerFlammables(Block block, int burn, int spread) {
        FireBlock fireBlock = (FireBlock) Blocks.FIRE;
        fireBlock.setFlammable(block, burn, spread);
    }

    public static void registerCompostable(float chance, ItemLike item) {
        ComposterBlock.COMPOSTABLES.put(item, chance);
    }

    public static void registerStrippable(Block unStripped, Block stripped) {
        AxeItem.STRIPPABLES = Maps.newHashMap(AxeItem.STRIPPABLES);
        AxeItem.STRIPPABLES.put(unStripped, stripped);
    }

}
