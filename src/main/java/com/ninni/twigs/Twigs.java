package com.ninni.twigs;

import com.google.common.reflect.Reflection;
import com.ninni.twigs.init.TwigsBlocks;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;

public class Twigs implements ModInitializer {
	public static final String MOD_ID = "twigs";
	public static final ItemGroup ITEM_GROUP = FabricItemGroupBuilder.build(new Identifier(Twigs.MOD_ID, "item_group"), () -> new ItemStack(Items.STICK));

	@SuppressWarnings("UnstableApiUsage")
	@Override
	public void onInitialize() {
		Reflection.initialize(
				TwigsBlocks.class
		);

	}
}