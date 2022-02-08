package com.ninni.twigs.item;

import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.block.Block;

public class FlintAndSteelBlockItem extends BlockItem {

    public FlintAndSteelBlockItem(Block block, Item.Properties properties) {
        super(block, properties);
    }

    @Override
    public InteractionResult useOn(UseOnContext ctx) {
        Player player = ctx.getPlayer();
        BlockPlaceContext blockPlaceContext = new BlockPlaceContext(ctx);
        if (player != null && blockPlaceContext.canPlace()) {
            ItemStack sm = player.getMainHandItem();
            ItemStack so = player.getOffhandItem();
            if (so.sameItem(sm)) {
                InteractionResult action = Items.FLINT_AND_STEEL.useOn(ctx);
                if (!player.getAbilities().instabuild) {
                    sm.shrink(1);
                    so.shrink(1);
                }
                return action;
            }
        }
        return super.useOn(ctx);
    }
}
