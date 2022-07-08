package net.moddingplayground.twigs.block;

import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

import java.util.function.Supplier;

@SuppressWarnings("deprecation")
public class AmethystStairBlock extends StairBlock {

    public AmethystStairBlock(Supplier<BlockState> p_56862_, Properties p_56863_) {
        super(p_56862_, p_56863_);
    }

    @Override
    public void onProjectileHit(Level world, BlockState state, BlockHitResult hit, Projectile projectile) {
        Blocks.AMETHYST_BLOCK.onProjectileHit(world, state, hit, projectile);
    }
}
