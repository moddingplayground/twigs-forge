package net.moddingplayground.twigs.block;

import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LanternBlock;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class PaperLanternBlock extends Block implements SimpleWaterloggedBlock {
    public static final BooleanProperty HANGING = BlockStateProperties.HANGING;
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
    protected static final VoxelShape STANDING_SHAPE = Shapes.or(
            Block.box(5, 9, 5, 11, 11, 11),
            Block.box(3, 0, 3, 13, 9, 13));
    protected static final VoxelShape HANGING_SHAPE = Shapes.or(
            Block.box(5, 9, 5, 11, 11, 11),
            Block.box(7, 11, 7, 9, 16, 9),
            Block.box(3, 0, 3, 13, 9, 13));
    private final Block block;
    private final Component component;

    public PaperLanternBlock(Block block, Properties properties) {
        super(properties);
        this.block = block;
        this.component = this.block.getName().copy().withStyle(ChatFormatting.GRAY);
        this.registerDefaultState(((this.stateDefinition.any()).setValue(HANGING, false)).setValue(WATERLOGGED, false));
    }

    @Override
    @Nullable
    public BlockState getStateForPlacement(BlockPlaceContext ctx) {
        FluidState fluidstate = ctx.getLevel().getFluidState(ctx.getClickedPos());

        for(Direction direction : ctx.getNearestLookingDirections()) {
            if (direction.getAxis() == Direction.Axis.Y) {
                BlockState blockstate = this.defaultBlockState().setValue(HANGING, direction == Direction.UP);
                if (blockstate.canSurvive(ctx.getLevel(), ctx.getClickedPos())) {
                    return blockstate.setValue(WATERLOGGED, fluidstate.getType() == Fluids.WATER);
                }
            }
        }

        return null;
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
        return state.getValue(HANGING) ? HANGING_SHAPE : STANDING_SHAPE;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(HANGING, WATERLOGGED);
    }

    @Override
    public boolean canSurvive(BlockState state, LevelReader world, BlockPos pos) {
        Direction direction = attachedDirection(state).getOpposite();
        return Block.canSupportCenter(world, pos.relative(direction), direction.getOpposite());
    }

    protected static Direction attachedDirection(BlockState state) {
        return state.getValue(HANGING) ? Direction.DOWN : Direction.UP;
    }

    @Override
    public PushReaction getPistonPushReaction(BlockState state) {
        return PushReaction.DESTROY;
    }

    @Override
    public BlockState updateShape(BlockState state, Direction direction, BlockState neighborState, LevelAccessor world, BlockPos pos, BlockPos neighborPos) {
        if (state.getValue(WATERLOGGED)) {
            world.scheduleTick(pos, Fluids.WATER, Fluids.WATER.getTickDelay(world));
        }

        return attachedDirection(state).getOpposite() == direction && !state.canSurvive(world, pos) ? Blocks.AIR.defaultBlockState() : super.updateShape(state, direction, neighborState, world, pos, neighborPos);
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
    public void appendHoverText(ItemStack p_49816_, @Nullable BlockGetter p_49817_, List<Component> toolTip, TooltipFlag p_49819_) {
        if (this.block != Blocks.AIR) toolTip.add(this.component);
    }
}
