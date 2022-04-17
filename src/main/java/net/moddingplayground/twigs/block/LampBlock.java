package net.moddingplayground.twigs.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RedstoneTorchBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.moddingplayground.twigs.init.TwigsBlocks;

import java.util.Random;


@SuppressWarnings("deprecation")
public class LampBlock extends Block {
    public static final BooleanProperty LIT = RedstoneTorchBlock.LIT;

    public LampBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(LIT, true));
    }

    @Override
    public InteractionResult use(BlockState state, Level world, BlockPos pos, Player player, InteractionHand hand, BlockHitResult result) {
        Random random = world.getRandom();
        if (!world.isClientSide()) {
            boolean wasLit = !state.getValue(LIT);
            world.setBlockAndUpdate(pos, state.setValue(LIT, wasLit));
            world.playSound(null, pos, wasLit ? SoundEvents.FIRECHARGE_USE : SoundEvents.FIRE_EXTINGUISH, SoundSource.PLAYERS, 0.3F, 2.0F);
        } else {
            double d0 = pos.getX() + 0.5D;
            double d1 = pos.getY();
            double d2 = pos.getZ() + 0.5D;
            for (Direction direction : Direction.values()) {
                for (int i = 0; i < Math.max(3, random.nextInt(12)); i++) {
                    Direction.Axis direction$axis = direction.getAxis();
                    double d4 = random.nextDouble() * 0.8D - 0.3D;
                    double d5 = direction$axis == Direction.Axis.X ? (double) direction.getStepX() * 0.52D : d4;
                    double d6 = random.nextDouble() * 6.0D / 16.0D;
                    double d7 = direction$axis == Direction.Axis.Z ? (double) direction.getStepZ() * 0.52D : d4;
                    double particleX = d0 + d5;
                    double particleY = d1 + d6;
                    double particleZ = d2 + d7;
                    if (!world.getBlockState(new BlockPos(particleX, particleY, particleZ)).isCollisionShapeFullBlock(world, new BlockPos(particleX, particleY, particleZ))){
                        world.addParticle(ParticleTypes.SMOKE, particleX, particleY, particleZ, 0.0D, 0.0D, 0.0D);
                        SimpleParticleType flameType = this == TwigsBlocks.SOUL_LAMP.get() ? ParticleTypes.SOUL_FIRE_FLAME : ParticleTypes.FLAME;
                        world.addParticle(flameType, particleX, particleY, particleZ, 0.0D, 0.0D, 0.0D);
                    }
                }
            }
        }
        return InteractionResult.SUCCESS;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder);
        builder.add(LIT);
    }
}
