package com.ninni.twigs;

import com.google.common.reflect.Reflection;
import com.ninni.twigs.init.TwigsBiomes;
import com.ninni.twigs.init.TwigsBlocks;
import com.ninni.twigs.init.TwigsConfiguredFeatures;
import com.ninni.twigs.init.TwigsItems;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
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
				TwigsBlocks.class,
				TwigsBiomes.class,
				TwigsItems.class,
				TwigsConfiguredFeatures.class
		);

		FlammableBlockRegistry fbrInstance = FlammableBlockRegistry.getDefaultInstance();
		fbrInstance.add(TwigsBlocks.AZALEA_FLOWERS,30, 60);
		fbrInstance.add(TwigsBlocks.BAMBOO_LEAVES,30, 60);
		fbrInstance.add(TwigsBlocks.BAMBOO_THATCH,30, 60);
		fbrInstance.add(TwigsBlocks.BAMBOO_THATCH_SLAB, 30, 60);
		fbrInstance.add(TwigsBlocks.BAMBOO_THATCH_STAIRS, 30, 60);
		fbrInstance.add(TwigsBlocks.OAK_TABLE, 5, 20);
		fbrInstance.add(TwigsBlocks.SPRUCE_TABLE, 5, 20);
		fbrInstance.add(TwigsBlocks.BIRCH_TABLE, 5, 20);
		fbrInstance.add(TwigsBlocks.ACACIA_TABLE, 5, 20);
		fbrInstance.add(TwigsBlocks.JUNGLE_TABLE, 5, 20);
		fbrInstance.add(TwigsBlocks.DARK_OAK_TABLE, 5, 20);
		fbrInstance.add(TwigsBlocks.STRIPPED_BAMBOO_TABLE, 5, 20);
		fbrInstance.add(TwigsBlocks.STRIPPED_BAMBOO, 5, 20);
		fbrInstance.add(TwigsBlocks.STRIPPED_BAMBOO_PLANKS, 5, 20);
		fbrInstance.add(TwigsBlocks.STRIPPED_BAMBOO_STAIRS, 5, 20);
		fbrInstance.add(TwigsBlocks.STRIPPED_BAMBOO_SLAB, 5, 20);
		fbrInstance.add(TwigsBlocks.STRIPPED_BAMBOO_FENCE, 5, 20);
		fbrInstance.add(TwigsBlocks.STRIPPED_BAMBOO_FENCE_GATE, 5, 20);
		fbrInstance.add(TwigsBlocks.STRIPPED_BAMBOO_BUTTON, 5, 20);
		fbrInstance.add(TwigsBlocks.STRIPPED_BAMBOO_TRAPDOOR, 5, 20);
		fbrInstance.add(TwigsBlocks.STRIPPED_BAMBOO_DOOR, 5, 20);
		fbrInstance.add(TwigsBlocks.STRIPPED_BAMBOO_PRESSURE_PLATE, 5, 20);
	}
}