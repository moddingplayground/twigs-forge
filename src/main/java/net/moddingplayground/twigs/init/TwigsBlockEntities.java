package net.moddingplayground.twigs.init;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.moddingplayground.twigs.Twigs;
import net.moddingplayground.twigs.block.blockentities.TwigsSignBlockEntity;

@Mod.EventBusSubscriber(modid = Twigs.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class TwigsBlockEntities {

    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, Twigs.MOD_ID);

    public static final RegistryObject<BlockEntityType<TwigsSignBlockEntity>> TWIGS_SIGN = BLOCK_ENTITIES.register("twigs_sign", () -> BlockEntityType.Builder.of(TwigsSignBlockEntity::new, TwigsBlocks.STRIPPED_BAMBOO_SIGN.get(), TwigsBlocks.STRIPPED_BAMBOO_WALL_SIGN.get()).build(null));

}
