package net.moddingplayground.twigs.events;

import com.google.common.base.Suppliers;
import com.google.common.collect.BiMap;
import com.google.common.collect.ImmutableBiMap;
import com.google.common.collect.ImmutableMap;
import net.minecraft.Util;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BambooBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LevelEvent;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BambooLeaves;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraftforge.common.Tags;
import net.minecraftforge.event.LootTableLoadEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.furnace.FurnaceFuelBurnTimeEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.moddingplayground.twigs.Twigs;
import net.moddingplayground.twigs.block.PillarOxidizableBlock;
import net.moddingplayground.twigs.block.StrippedBambooBlock;
import net.moddingplayground.twigs.init.TwigsBlocks;
import net.moddingplayground.twigs.init.TwigsItems;

import java.util.Optional;
import java.util.function.Supplier;

import static net.minecraft.advancements.critereon.StatePropertiesPredicate.Builder.*;
import static net.minecraft.world.level.storage.loot.LootPool.*;
import static net.minecraft.world.level.storage.loot.entries.LootItem.*;
import static net.minecraft.world.level.storage.loot.predicates.InvertedLootItemCondition.*;
import static net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition.*;

@Mod.EventBusSubscriber(modid = Twigs.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class MiscEvents {
    public static final Supplier<BiMap<Block, Block>> WAXABLES = Suppliers.memoize(() -> ImmutableBiMap.<Block, Block>builder().put(TwigsBlocks.COPPER_PILLAR.get(), TwigsBlocks.WAXED_COPPER_PILLAR.get()).put(TwigsBlocks.EXPOSED_COPPER_PILLAR.get(), TwigsBlocks.WAXED_EXPOSED_COPPER_PILLAR.get()).put(TwigsBlocks.WEATHERED_COPPER_PILLAR.get(), TwigsBlocks.WAXED_WEATHERED_COPPER_PILLAR.get()).put(TwigsBlocks.OXIDIZED_COPPER_PILLAR.get(), TwigsBlocks.WAXED_OXIDIZED_COPPER_PILLAR.get()).build());
    public static final Supplier<BiMap<Block, Block>> WAX_OFF_BY_BLOCK = Suppliers.memoize(() -> WAXABLES.get().inverse());

    @SubscribeEvent
    public void onRightClick(PlayerInteractEvent.RightClickBlock event) {
        BlockPos blockPos = event.getPos();
        Level world = event.getWorld();
        BlockState state = world.getBlockState(blockPos);
        Player player = event.getPlayer();
        ItemStack stack = event.getItemStack();
        InteractionHand hand = event.getHand();
        if (state.is(Blocks.FLOWERING_AZALEA) && stack.is(Tags.Items.SHEARS)) {
            world.setBlockAndUpdate(blockPos, Blocks.AZALEA.defaultBlockState());
            world.playSound(null, player, SoundEvents.SHEEP_SHEAR, SoundSource.PLAYERS, 1.0F, 1.0F);
            Block.popResource(world, blockPos.above(), new ItemStack(TwigsBlocks.AZALEA_FLOWERS.get(), world.random.nextInt(2) + 1));
            stack.hurtAndBreak(1, player, p -> p.broadcastBreakEvent(hand));
            player.swing(hand);
        }
        if (stack.getItem() == Items.HONEYCOMB) {
            Optional<BlockState> waxables = Optional.ofNullable(WAXABLES.get().get(state.getBlock())).map((blockState) -> blockState.withPropertiesOf(state));
            if (waxables.isPresent()) {
                if (player instanceof ServerPlayer) {
                    CriteriaTriggers.ITEM_USED_ON_BLOCK.trigger((ServerPlayer) player, blockPos, stack);
                }
                if (!player.getAbilities().instabuild) {
                    stack.shrink(1);
                }
                world.setBlock(blockPos, waxables.get(), 1);
                world.levelEvent(player, LevelEvent.PARTICLES_AND_SOUND_WAX_ON, blockPos, 0);
                player.swing(hand);
            }
        }
        if (stack.getItem() instanceof AxeItem) {
            Optional<BlockState> finalState = Optional.empty();
            if (state.getBlock() instanceof PillarOxidizableBlock) {
                Optional<BlockState> previous = PillarOxidizableBlock.getPreviousState(state);
                if (previous.isPresent()) {
                    world.playSound(player, blockPos, SoundEvents.AXE_SCRAPE, SoundSource.BLOCKS, 1.0F, 1.0F);
                    world.levelEvent(player, LevelEvent.PARTICLES_SCRAPE, blockPos, 0);
                    finalState = previous;
                }
            }
            Optional<BlockState> previousWaxed = Optional.ofNullable(WAX_OFF_BY_BLOCK.get().get(state.getBlock())).map((blockState) -> blockState.withPropertiesOf(state));
            if (previousWaxed.isPresent()) {
                world.playSound(player, blockPos, SoundEvents.AXE_SCRAPE, SoundSource.BLOCKS, 1.0F, 1.0F);
                world.levelEvent(player, LevelEvent.PARTICLES_WAX_OFF, blockPos, 0);
                finalState = previousWaxed;
            }
            if (state.is(Blocks.BAMBOO)) {
                if (!world.getBlockState(blockPos.above()).is(Blocks.BAMBOO)) {
                    world.playSound(player, blockPos, SoundEvents.AXE_STRIP, SoundSource.BLOCKS, 1.0F, 1.0F);
                    finalState = Optional.of(TwigsBlocks.STRIPPED_BAMBOO.get().defaultBlockState().setValue(StrippedBambooBlock.FROM_BAMBOO, true));
                }
            }
            if (finalState.isPresent()) {
                world.setBlock(blockPos, finalState.get(), 11);
                stack.hurtAndBreak(1, player, p -> p.broadcastBreakEvent(hand));
                player.swing(hand);
            }
        }
    }

    @SubscribeEvent
    public void onFuelBurn(FurnaceFuelBurnTimeEvent event) {
        Util.make(ImmutableMap.<ItemLike, Integer>builder(), map -> {
            map.put(TwigsBlocks.STRIPPED_BAMBOO.get(), 50)
               .put(TwigsItems.STRIPPED_BAMBOO_BOAT.get(), 1200)
               .put(TwigsItems.STRIPPED_BAMBOO_SIGN.get(), 200)
               .put(TwigsBlocks.BUNDLED_BAMBOO.get(), 450)
               .put(TwigsBlocks.STRIPPED_BUNDLED_BAMBOO.get(), 450)
               .put(TwigsBlocks.STRIPPED_BAMBOO_PLANKS.get(), 200);
        }).build().forEach((item, burnTime) -> { if (event.getItemStack().is(item.asItem())) event.setBurnTime(burnTime); });
    }

    @SubscribeEvent
    public void onLootTableLoad(LootTableLoadEvent event) {
        ResourceLocation id = event.getName();
        LootTable table = event.getTable();
        if (id.equals(Blocks.BAMBOO.getLootTable())) {
            table.addPool(
                lootPool().when(invert(hasBlockStateProperties(Blocks.BAMBOO).setProperties(properties().hasProperty(BambooBlock.LEAVES, BambooLeaves.NONE))))
                          .add(lootTableItem(TwigsBlocks.BAMBOO_LEAVES.get()))
                          .build()
            );
        }
    }
}
