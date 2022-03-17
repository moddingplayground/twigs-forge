package net.moddingplayground.twigs.init;

import net.moddingplayground.twigs.Twigs;
import net.moddingplayground.twigs.entity.StrippedBambooBoatEntity;
import net.moddingplayground.twigs.item.FlintAndSteelBlockItem;
import net.moddingplayground.twigs.item.StrippedBambooBoatItem;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SignItem;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

@Mod.EventBusSubscriber(modid = Twigs.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class TwigsItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Twigs.MOD_ID);

    public static final RegistryObject<Item> TWIGS = ITEMS.register("twig", () -> new FlintAndSteelBlockItem(TwigsBlocks.TWIG.get(), new Item.Properties().tab(Twigs.ITEM_GROUP)));
    public static final RegistryObject<Item> BAMBOO_LEAVES = ITEMS.register("bamboo_leaves", () -> new BlockItem(TwigsBlocks.BAMBOO_LEAVES.get(), new Item.Properties().tab(Twigs.ITEM_GROUP)));
    public static final RegistryObject<Item> STRIPPED_BAMBOO_SIGN = ITEMS.register("stripped_bamboo_sign", () -> new SignItem(new Item.Properties().stacksTo(16).tab(CreativeModeTab.TAB_DECORATIONS), TwigsBlocks.STRIPPED_BAMBOO_SIGN.get(), TwigsBlocks.STRIPPED_BAMBOO_WALL_SIGN.get()));
    public static final RegistryObject<Item> STRIPPED_BAMBOO_BOAT = ITEMS.register("stripped_bamboo_boat", () -> new StrippedBambooBoatItem(StrippedBambooBoatEntity.BoatType.STRIPPED_BAMBOO, new Item.Properties().stacksTo(1).tab(CreativeModeTab.TAB_TRANSPORTATION)));

}
