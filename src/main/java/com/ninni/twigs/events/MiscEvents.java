package com.ninni.twigs.events;

import com.google.common.base.Suppliers;
import com.google.common.collect.BiMap;
import com.google.common.collect.ImmutableBiMap;
import com.ninni.twigs.Twigs;
import com.ninni.twigs.block.PillarOxidizableBlock;
import com.ninni.twigs.block.StrippedBambooBlock;
import com.ninni.twigs.init.TwigsBlocks;
import com.ninni.twigs.init.TwigsItems;
import it.unimi.dsi.fastutil.objects.Object2IntArrayMap;
import it.unimi.dsi.fastutil.objects.Object2IntMap;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.core.BlockPos;
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
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.Tags;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.furnace.FurnaceFuelBurnTimeEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.Optional;
import java.util.function.Supplier;

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
        if (state.is(Blocks.FLOWERING_AZALEA) && stack.m_204117_(Tags.Items.SHEARS)) {
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
                world.levelEvent(player, 3003, blockPos, 0);
                player.swing(hand);
            }
        }
        if (stack.getItem() instanceof AxeItem) {
            Optional<BlockState> finalState = Optional.empty();
            if (state.getBlock() instanceof PillarOxidizableBlock) {
                Optional<BlockState> previous = PillarOxidizableBlock.getPreviousState(state);
                if (previous.isPresent()) {
                    world.playSound(player, blockPos, SoundEvents.AXE_SCRAPE, SoundSource.BLOCKS, 1.0F, 1.0F);
                    world.levelEvent(player, 3005, blockPos, 0);
                    finalState = previous;
                }
            }
            Optional<BlockState> previousWaxed = Optional.ofNullable(WAX_OFF_BY_BLOCK.get().get(state.getBlock())).map((blockState) -> blockState.withPropertiesOf(state));
            if (previousWaxed.isPresent()) {
                world.playSound(player, blockPos, SoundEvents.AXE_SCRAPE, SoundSource.BLOCKS, 1.0F, 1.0F);
                world.levelEvent(player, 3004, blockPos, 0);
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
        Object2IntMap<ItemLike> TWIGS_FUELS = new Object2IntArrayMap<>();
        TWIGS_FUELS.put(TwigsBlocks.STRIPPED_BAMBOO.get(), 50);
        TWIGS_FUELS.put(TwigsItems.STRIPPED_BAMBOO_BOAT.get(), 1200);
        TWIGS_FUELS.put(TwigsItems.STRIPPED_BAMBOO_SIGN.get(), 200);
        TWIGS_FUELS.put(TwigsBlocks.BUNDLED_BAMBOO.get(), 450);
        TWIGS_FUELS.put(TwigsBlocks.STRIPPED_BUNDLED_BAMBOO.get(), 450);
        TWIGS_FUELS.put(TwigsBlocks.STRIPPED_BAMBOO_PLANKS.get(), 200);
        TWIGS_FUELS.put(TwigsBlocks.STRIPPED_BAMBOO.get(), 50);
        for (ItemLike itemLike : TWIGS_FUELS.keySet()) {
            if (event.getItemStack().is(itemLike.asItem())) {
                event.setBurnTime(TWIGS_FUELS.get(itemLike));
            }
        }
    }

}
