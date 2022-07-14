package net.moddingplayground.twigs.data;

import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.core.Direction;
import net.minecraft.data.loot.BlockLoot;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.MultifaceBlock;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.AlternativesEntry;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyExplosionDecay;
import net.minecraft.world.level.storage.loot.functions.LootItemFunction;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.MatchTool;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraftforge.registries.RegistryObject;
import net.moddingplayground.twigs.block.BambooLeavesBlock;
import net.moddingplayground.twigs.block.VerticalSlabBlock;
import net.moddingplayground.twigs.init.TwigsBlocks;
import org.jetbrains.annotations.NotNull;

import java.util.stream.Collectors;

public class TwigsBlockLootTables extends BlockLoot {
    private static final LootItemCondition.Builder HAS_SHEARS = MatchTool.toolMatches(ItemPredicate.Builder.item().of(Items.SHEARS));

    @Override
    protected void addTables() {
        this.dropSelf(TwigsBlocks.STRIPPED_BAMBOO_SIGN.get());
        this.dropSelf(TwigsBlocks.LAMP.get());
        this.dropSelf(TwigsBlocks.SOUL_LAMP.get());
        this.dropSelf(TwigsBlocks.CRIMSON_SHROOMLAMP.get());
        this.dropSelf(TwigsBlocks.WARPED_SHROOMLAMP.get());
        this.add(TwigsBlocks.AZALEA_FLOWERS.get(), block -> createMultifaceBlockDrops(block, HAS_SHEARS));
        this.dropPottedContents(TwigsBlocks.POTTED_AZALEA_FLOWERS.get());
        this.add(TwigsBlocks.BAMBOO_LEAVES.get(), this::dropsLayer1_4);
        this.dropSelf(TwigsBlocks.STRIPPED_BAMBOO.get());
        this.dropSelf(TwigsBlocks.STRIPPED_BUNDLED_BAMBOO.get());
        this.dropSelf(TwigsBlocks.BUNDLED_BAMBOO.get());
        this.dropSelf(TwigsBlocks.BAMBOO_THATCH.get());
        this.dropSelf(TwigsBlocks.BAMBOO_THATCH_STAIRS.get());
        this.dropSlab(TwigsBlocks.BAMBOO_THATCH_SLAB.get());
        this.add(TwigsBlocks.BAMBOO_THATCH_VERTICAL_SLAB.get(), this::verticalSlab);
        this.add(TwigsBlocks.BAMBOO_THATCH_VERTICAL_SLAB.get(), this::verticalSlab);
        this.dropSelf(TwigsBlocks.STRIPPED_BAMBOO_MAT.get());
        this.dropSelf(TwigsBlocks.STRIPPED_BAMBOO_PLANKS.get());
        this.dropSelf(TwigsBlocks.STRIPPED_BAMBOO_STAIRS.get());
        this.dropSlab(TwigsBlocks.STRIPPED_BAMBOO_SLAB.get());
        this.dropSelf(TwigsBlocks.STRIPPED_BAMBOO_FENCE.get());
        this.dropSelf(TwigsBlocks.STRIPPED_BAMBOO_FENCE_GATE.get());
        this.add(TwigsBlocks.STRIPPED_BAMBOO_DOOR.get(), BlockLoot::createDoorTable);
        this.dropSelf(TwigsBlocks.STRIPPED_BAMBOO_TRAPDOOR.get());
        this.dropSelf(TwigsBlocks.STRIPPED_BAMBOO_BUTTON.get());
        this.dropSelf(TwigsBlocks.STRIPPED_BAMBOO_PRESSURE_PLATE.get());
        this.add(TwigsBlocks.STRIPPED_BAMBOO_PLANKS_VERTICAL_SLAB.get(), this::verticalSlab);
        this.dropSelf(TwigsBlocks.OAK_TABLE.get());
        this.dropSelf(TwigsBlocks.SPRUCE_TABLE.get());
        this.dropSelf(TwigsBlocks.BIRCH_TABLE.get());
        this.dropSelf(TwigsBlocks.JUNGLE_TABLE.get());
        this.dropSelf(TwigsBlocks.ACACIA_TABLE.get());
        this.dropSelf(TwigsBlocks.DARK_OAK_TABLE.get());
        this.dropSelf(TwigsBlocks.CRIMSON_TABLE.get());
        this.dropSelf(TwigsBlocks.WARPED_TABLE.get());
        this.dropSelf(TwigsBlocks.STRIPPED_BAMBOO_TABLE.get());
        this.dropSelf(TwigsBlocks.MANGROVE_TABLE.get());
        this.dropSelf(TwigsBlocks.CHISELED_BRICKS.get());
        this.dropSelf(TwigsBlocks.CRACKED_BRICKS.get());
        this.dropSelf(TwigsBlocks.MOSSY_BRICKS.get());
        this.dropSelf(TwigsBlocks.MOSSY_BRICK_STAIRS.get());
        this.dropSlab(TwigsBlocks.MOSSY_BRICK_SLAB.get());
        this.dropSelf(TwigsBlocks.MOSSY_BRICK_WALL.get());
        this.add(TwigsBlocks.MOSSY_BRICK_VERTICAL_SLAB.get(), this::verticalSlab);
        this.dropSelf(TwigsBlocks.POLISHED_BASALT_BRICKS.get());
        this.dropSelf(TwigsBlocks.SMOOTH_BASALT_BRICKS.get());
        this.dropSelf(TwigsBlocks.SMOOTH_BASALT_BRICK_STAIRS.get());
        this.dropSlab(TwigsBlocks.SMOOTH_BASALT_BRICK_SLAB.get());
        this.dropSelf(TwigsBlocks.SMOOTH_BASALT_BRICK_WALL.get());
        this.add(TwigsBlocks.SMOOTH_BASALT_BRICK_VERTICAL_SLAB.get(), this::verticalSlab);
        this.dropSelf(TwigsBlocks.COBBLESTONE_BRICKS.get());
        this.dropSelf(TwigsBlocks.COBBLESTONE_BRICK_STAIRS.get());
        this.dropSlab(TwigsBlocks.COBBLESTONE_BRICK_SLAB.get());
        this.dropSelf(TwigsBlocks.COBBLESTONE_BRICK_WALL.get());
        this.dropSelf(TwigsBlocks.CRACKED_COBBLESTONE_BRICKS.get());
        this.add(TwigsBlocks.COBBLESTONE_BRICK_VERTICAL_SLAB.get(), this::verticalSlab);
        this.dropSelf(TwigsBlocks.MOSSY_COBBLESTONE_BRICKS.get());
        this.dropSelf(TwigsBlocks.MOSSY_COBBLESTONE_BRICK_STAIRS.get());
        this.dropSlab(TwigsBlocks.MOSSY_COBBLESTONE_BRICK_SLAB.get());
        this.dropSelf(TwigsBlocks.MOSSY_COBBLESTONE_BRICK_WALL.get());
        this.add(TwigsBlocks.MOSSY_COBBLESTONE_BRICK_VERTICAL_SLAB.get(), this::verticalSlab);
        this.dropSelf(TwigsBlocks.POLISHED_AMETHYST_BRICKS.get());
        this.dropSelf(TwigsBlocks.POLISHED_AMETHYST_BRICK_STAIRS.get());
        this.dropSlab(TwigsBlocks.POLISHED_AMETHYST_BRICK_SLAB.get());
        this.dropSelf(TwigsBlocks.POLISHED_AMETHYST_BRICK_WALL.get());
        this.dropSelf(TwigsBlocks.CRACKED_POLISHED_AMETHYST_BRICKS.get());
        this.add(TwigsBlocks.POLISHED_AMETHYST_BRICK_VERTICAL_SLAB.get(), this::verticalSlab);
        this.dropSelf(TwigsBlocks.POLISHED_AMETHYST.get());
        this.dropSelf(TwigsBlocks.CHISELED_POLISHED_AMETHYST.get());
        this.dropSelf(TwigsBlocks.POLISHED_AMETHYST_STAIRS.get());
        this.dropSlab(TwigsBlocks.POLISHED_AMETHYST_SLAB.get());
        this.add(TwigsBlocks.POLISHED_AMETHYST_VERTICAL_SLAB.get(), this::verticalSlab);
        this.dropSelf(TwigsBlocks.TWISTING_POLISHED_BLACKSTONE_BRICKS.get());
        this.dropSelf(TwigsBlocks.TWISTING_POLISHED_BLACKSTONE_BRICK_STAIRS.get());
        this.dropSlab(TwigsBlocks.TWISTING_POLISHED_BLACKSTONE_BRICK_SLAB.get());
        this.dropSelf(TwigsBlocks.TWISTING_POLISHED_BLACKSTONE_BRICK_WALL.get());
        this.add(TwigsBlocks.TWISTING_POLISHED_BLACKSTONE_BRICK_VERTICAL_SLAB.get(), this::verticalSlab);
        this.dropSelf(TwigsBlocks.WEEPING_POLISHED_BLACKSTONE_BRICKS.get());
        this.dropSelf(TwigsBlocks.WEEPING_POLISHED_BLACKSTONE_BRICK_STAIRS.get());
        this.dropSlab(TwigsBlocks.WEEPING_POLISHED_BLACKSTONE_BRICK_SLAB.get());
        this.dropSelf(TwigsBlocks.WEEPING_POLISHED_BLACKSTONE_BRICK_WALL.get());
        this.add(TwigsBlocks.WEEPING_POLISHED_BLACKSTONE_BRICK_VERTICAL_SLAB.get(), this::verticalSlab);
        this.dropSelf(TwigsBlocks.PAPER_LANTERN.get());
        this.dropSelf(TwigsBlocks.ALLIUM_PAPER_LANTERN.get());
        this.dropSelf(TwigsBlocks.BLUE_ORCHID_PAPER_LANTERN.get());
        this.dropSelf(TwigsBlocks.CRIMSON_ROOTS_PAPER_LANTERN.get());
        this.dropSelf(TwigsBlocks.DANDELION_PAPER_LANTERN.get());
        this.dropSelf(TwigsBlocks.ROCKY_DIRT.get());
        this.dropSelf(TwigsBlocks.TWIG.get());
        this.dropSelf(TwigsBlocks.PEBBLE.get());
        this.dropSelf(TwigsBlocks.SEA_SHELL.get());
        this.dropSelf(TwigsBlocks.TUFF_STAIRS.get());
        this.dropSlab(TwigsBlocks.TUFF_SLAB.get());
        this.dropSelf(TwigsBlocks.TUFF_WALL.get());
        this.add(TwigsBlocks.TUFF_VERTICAL_SLAB.get(), this::verticalSlab);
        this.dropSelf(TwigsBlocks.POLISHED_TUFF.get());
        this.dropSelf(TwigsBlocks.POLISHED_TUFF_STAIRS.get());
        this.dropSlab(TwigsBlocks.POLISHED_TUFF_SLAB.get());
        this.add(TwigsBlocks.POLISHED_TUFF_VERTICAL_SLAB.get(), this::verticalSlab);
        this.dropSelf(TwigsBlocks.POLISHED_TUFF_BRICKS.get());
        this.dropSelf(TwigsBlocks.POLISHED_TUFF_BRICK_STAIRS.get());
        this.dropSlab(TwigsBlocks.POLISHED_TUFF_BRICK_SLAB.get());
        this.dropSelf(TwigsBlocks.POLISHED_TUFF_BRICK_WALL.get());
        this.dropSelf(TwigsBlocks.CRACKED_POLISHED_TUFF_BRICKS.get());
        this.add(TwigsBlocks.POLISHED_TUFF_BRICK_VERTICAL_SLAB.get(), this::verticalSlab);
        this.dropSelf(TwigsBlocks.CALCITE_STAIRS.get());
        this.dropSlab(TwigsBlocks.CALCITE_SLAB.get());
        this.dropSelf(TwigsBlocks.CALCITE_WALL.get());
        this.add(TwigsBlocks.CALCITE_VERTICAL_SLAB.get(), this::verticalSlab);
        this.dropSelf(TwigsBlocks.POLISHED_CALCITE.get());
        this.dropSelf(TwigsBlocks.POLISHED_CALCITE_STAIRS.get());
        this.dropSlab(TwigsBlocks.POLISHED_CALCITE_SLAB.get());
        this.add(TwigsBlocks.POLISHED_CALCITE_VERTICAL_SLAB.get(), this::verticalSlab);
        this.dropSelf(TwigsBlocks.POLISHED_CALCITE_BRICKS.get());
        this.dropSelf(TwigsBlocks.POLISHED_CALCITE_BRICK_STAIRS.get());
        this.dropSlab(TwigsBlocks.POLISHED_CALCITE_BRICK_SLAB.get());
        this.dropSelf(TwigsBlocks.POLISHED_CALCITE_BRICK_WALL.get());
        this.add(TwigsBlocks.POLISHED_CALCITE_BRICK_VERTICAL_SLAB.get(), this::verticalSlab);
        this.dropSelf(TwigsBlocks.CRACKED_POLISHED_CALCITE_BRICKS.get());
        this.dropSelf(TwigsBlocks.COPPER_PILLAR.get());
        this.dropSelf(TwigsBlocks.EXPOSED_COPPER_PILLAR.get());
        this.dropSelf(TwigsBlocks.WEATHERED_COPPER_PILLAR.get());
        this.dropSelf(TwigsBlocks.OXIDIZED_COPPER_PILLAR.get());
        this.dropSelf(TwigsBlocks.WAXED_COPPER_PILLAR.get());
        this.dropSelf(TwigsBlocks.WAXED_EXPOSED_COPPER_PILLAR.get());
        this.dropSelf(TwigsBlocks.WAXED_WEATHERED_COPPER_PILLAR.get());
        this.dropSelf(TwigsBlocks.WAXED_OXIDIZED_COPPER_PILLAR.get());
        this.dropSelf(TwigsBlocks.RHYOLITE.get());
        this.dropSelf(TwigsBlocks.RHYOLITE_STAIRS.get());
        this.dropSlab(TwigsBlocks.RHYOLITE_SLAB.get());
        this.dropSelf(TwigsBlocks.RHYOLITE_WALL.get());
        this.add(TwigsBlocks.RHYOLITE_VERTICAL_SLAB.get(), this::verticalSlab);
        this.dropSelf(TwigsBlocks.POLISHED_RHYOLITE.get());
        this.dropSelf(TwigsBlocks.POLISHED_RHYOLITE_STAIRS.get());
        this.dropSlab(TwigsBlocks.POLISHED_RHYOLITE_SLAB.get());
        this.add(TwigsBlocks.POLISHED_RHYOLITE_VERTICAL_SLAB.get(), this::verticalSlab);
        this.dropSelf(TwigsBlocks.POLISHED_RHYOLITE_BRICKS.get());
        this.dropSelf(TwigsBlocks.POLISHED_RHYOLITE_BRICK_STAIRS.get());
        this.dropSlab(TwigsBlocks.POLISHED_RHYOLITE_BRICK_SLAB.get());
        this.dropSelf(TwigsBlocks.POLISHED_RHYOLITE_BRICK_WALL.get());
        this.add(TwigsBlocks.POLISHED_RHYOLITE_BRICK_VERTICAL_SLAB.get(), this::verticalSlab);
        this.dropSelf(TwigsBlocks.CRACKED_POLISHED_RHYOLITE_BRICKS.get());
        this.dropSelf(TwigsBlocks.SCHIST.get());
        this.dropSelf(TwigsBlocks.SCHIST_STAIRS.get());
        this.dropSlab(TwigsBlocks.SCHIST_SLAB.get());
        this.dropSelf(TwigsBlocks.SCHIST_WALL.get());
        this.add(TwigsBlocks.SCHIST_VERTICAL_SLAB.get(), this::verticalSlab);
        this.dropSelf(TwigsBlocks.POLISHED_SCHIST.get());
        this.dropSelf(TwigsBlocks.POLISHED_SCHIST_STAIRS.get());
        this.dropSlab(TwigsBlocks.POLISHED_SCHIST_SLAB.get());
        this.add(TwigsBlocks.POLISHED_SCHIST_VERTICAL_SLAB.get(), this::verticalSlab);
        this.dropSelf(TwigsBlocks.POLISHED_SCHIST_BRICKS.get());
        this.dropSelf(TwigsBlocks.POLISHED_SCHIST_BRICK_STAIRS.get());
        this.dropSlab(TwigsBlocks.POLISHED_SCHIST_BRICK_SLAB.get());
        this.dropSelf(TwigsBlocks.POLISHED_SCHIST_BRICK_WALL.get());
        this.add(TwigsBlocks.POLISHED_SCHIST_BRICK_VERTICAL_SLAB.get(), this::verticalSlab);
        this.dropSelf(TwigsBlocks.CRACKED_POLISHED_SCHIST_BRICKS.get());
        this.dropSelf(TwigsBlocks.BLOODSTONE.get());
        this.dropSelf(TwigsBlocks.BLOODSTONE_STAIRS.get());
        this.dropSlab(TwigsBlocks.BLOODSTONE_SLAB.get());
        this.dropSelf(TwigsBlocks.BLOODSTONE_WALL.get());
        this.add(TwigsBlocks.BLOODSTONE_VERTICAL_SLAB.get(), this::verticalSlab);
        this.dropSelf(TwigsBlocks.POLISHED_BLOODSTONE.get());
        this.dropSelf(TwigsBlocks.POLISHED_BLOODSTONE_STAIRS.get());
        this.dropSlab(TwigsBlocks.POLISHED_BLOODSTONE_SLAB.get());
        this.add(TwigsBlocks.POLISHED_BLOODSTONE_VERTICAL_SLAB.get(), this::verticalSlab);
        this.dropSelf(TwigsBlocks.POLISHED_BLOODSTONE_BRICKS.get());
        this.dropSelf(TwigsBlocks.POLISHED_BLOODSTONE_BRICK_STAIRS.get());
        this.dropSlab(TwigsBlocks.POLISHED_BLOODSTONE_BRICK_SLAB.get());
        this.dropSelf(TwigsBlocks.POLISHED_BLOODSTONE_BRICK_WALL.get());
        this.add(TwigsBlocks.POLISHED_BLOODSTONE_BRICK_VERTICAL_SLAB.get(), this::verticalSlab);
        this.dropSelf(TwigsBlocks.CRACKED_POLISHED_BLOODSTONE_BRICKS.get());
        this.dropSelf(TwigsBlocks.ENDER_MESH.get());
        this.add(TwigsBlocks.PETRIFIED_LICHEN.get(), TwigsBlockLootTables::createMultifaceBlockDrops);
    }

    public static LootTable.Builder createMultifaceBlockDrops(Block block) {
        return LootTable.lootTable()
                .withPool(
                        LootPool.lootPool()
                                .add(
                                        applyExplosionDecay(block,
                                                LootItem.lootTableItem(block)
                                                        .apply(Direction.values(), direction ->
                                                                SetItemCountFunction.setCount(ConstantValue.exactly(1.0f), true)
                                                                        .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block).setProperties(
                                                                                StatePropertiesPredicate.Builder.properties()
                                                                                        .hasProperty(MultifaceBlock.getFaceProperty(direction), true)
                                                                        ))
                                                        )
                                                        .apply(SetItemCountFunction.setCount(ConstantValue.exactly(-1.0f), true)))
                                )
                );
    }

    @NotNull
    private LootTable.Builder verticalSlab(Block block) {
        return LootTable.lootTable().withPool(LootPool.lootPool()
                        .add(LootItem.lootTableItem(block)
                                .apply(SetItemCountFunction.setCount(ConstantValue.exactly(2))
                                        .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(VerticalSlabBlock.TYPE, VerticalSlabBlock.VerticalSlabType.DOUBLE)))
                                )
                                .apply(ApplyExplosionDecay.explosionDecay())
                        ));
    }

    private LootTable.Builder dropsLayer1_4(Block block) {
        return LootTable.lootTable().withPool(LootPool.lootPool().add(
                AlternativesEntry.alternatives(
                        LootItem.lootTableItem(block)
                                .apply(addPerLayer1_4(block, 1.0F, 2))
                                .apply(addPerLayer1_4(block, 2.0F, 3))
                                .apply(addPerLayer1_4(block, 3.0F, 4)))));
    }

    public LootItemFunction.Builder addPerLayer1_4(Block block, float count, int layer) {
        return SetItemCountFunction.setCount(ConstantValue.exactly(count), true).when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(BambooLeavesBlock.LAYERS, layer)));
    }

    private void dropSlab(Block slab) {
        this.add(slab, BlockLoot::createSlabItemTable);
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return TwigsBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get).collect(Collectors.toList());
    }
}
