package com.ninni.twigs.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class QuadPoleBlock extends RotatedPillarBlock implements SimpleWaterloggedBlock {
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;

    public static final float MIN_BOUND = 5.0f;
    public static final float MAX_BOUND = 11.0f;
    public static final VoxelShape Y_SHAPE = Block.box(MIN_BOUND, 0.0, MIN_BOUND, MAX_BOUND, 16.0, MAX_BOUND);
    public static final VoxelShape Z_SHAPE = Block.box(MIN_BOUND, MIN_BOUND, 0.0, MAX_BOUND, MAX_BOUND, 16.0);
    public static final VoxelShape X_SHAPE = Block.box(0.0, MIN_BOUND, MIN_BOUND, 16.0, MAX_BOUND, MAX_BOUND);

    public static final float MIN_BOUND_COLL = 6.5f;
    public static final float MAX_BOUND_COLL = 9.5f;
    public static final VoxelShape Y_SHAPE_COLL = Block.box(MIN_BOUND_COLL, 0.0, MIN_BOUND_COLL, MAX_BOUND_COLL, 16.0, MAX_BOUND_COLL);
    public static final VoxelShape Z_SHAPE_COLL = Block.box(MIN_BOUND_COLL, MIN_BOUND_COLL, 0.0, MAX_BOUND_COLL, MAX_BOUND_COLL, 16.0);
    public static final VoxelShape X_SHAPE_COLL = Block.box(0.0, MIN_BOUND_COLL, MIN_BOUND_COLL, 16.0, MAX_BOUND_COLL, MAX_BOUND_COLL);

    public QuadPoleBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.defaultBlockState().setValue(WATERLOGGED, false).setValue(AXIS, Direction.Axis.Y));
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
        return switch (state.getValue(AXIS)) {
            case X -> X_SHAPE;
            case Y -> Y_SHAPE;
            case Z -> Z_SHAPE;
        };
    }

    @Override
    public VoxelShape getCollisionShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
        return switch (state.getValue(AXIS)) {
            case X -> X_SHAPE_COLL;
            case Y -> Y_SHAPE_COLL;
            case Z -> Z_SHAPE_COLL;
        };
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext ctx) {
        FluidState fluidState = ctx.getLevel().getFluidState(ctx.getClickedPos());
        BlockState state = super.getStateForPlacement(ctx);
        return (state == null ? this.defaultBlockState() : state).setValue(WATERLOGGED, fluidState.getType() == Fluids.WATER);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder);
        builder.add(WATERLOGGED);
    }

    @Override
    public FluidState getFluidState(BlockState state) {
        return state.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(state);
    }

    @Override
    public boolean isPathfindable(BlockState state, BlockGetter world, BlockPos pos, PathComputationType type) {
        return false;
    }

    @Override
    public boolean isCollisionShapeFullBlock(BlockState state, BlockGetter world, BlockPos pos) {
        return false;
    }
}
