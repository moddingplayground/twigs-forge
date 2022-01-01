package com.ninni.twigs.events;

import com.ninni.twigs.Twigs;
import com.ninni.twigs.init.TwigsBlocks;
import com.ninni.twigs.init.TwigsItems;
import it.unimi.dsi.fastutil.objects.Object2IntArrayMap;
import it.unimi.dsi.fastutil.objects.Object2IntMap;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
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

@Mod.EventBusSubscriber(modid = Twigs.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class MiscEvents {

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
        for (ItemLike itemLike : TWIGS_FUELS.keySet()) {
            if (event.getItemStack().is(itemLike.asItem())) {
                event.setBurnTime(TWIGS_FUELS.get(itemLike));
            }
        }
    }

}
