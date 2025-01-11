package com.lethosos.glazedresymmetry.init.util;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.SlabType;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.material.PushReaction;

public class GlazedSlabBlock extends SlabBlock {

	public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;
	
	public GlazedSlabBlock(Properties slab) {
		super(slab);
	}

	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> blockState) {
		blockState.add(FACING, TYPE, WATERLOGGED);
	}

	public BlockState getStateForPlacement(BlockPlaceContext state) {
	      BlockPos blockpos = state.getClickedPos();
	      BlockState blockstate = state.getLevel().getBlockState(blockpos);
	      if (blockstate.is(this)) {
	         return blockstate.setValue(TYPE, SlabType.DOUBLE).setValue(WATERLOGGED, Boolean.valueOf(false));
	      } else {
	         FluidState fluidstate = state.getLevel().getFluidState(blockpos);
	         BlockState blockstate1 = this.defaultBlockState().setValue(TYPE, SlabType.BOTTOM).setValue(WATERLOGGED, Boolean.valueOf(fluidstate.getType() == Fluids.WATER));
	         Direction direction = state.getClickedFace();
	         blockstate1 = this.defaultBlockState().setValue(FACING, state.getHorizontalDirection().getOpposite());
	         return direction != Direction.DOWN && (direction == Direction.UP || !(state.getClickLocation().y - (double)blockpos.getY() > 0.5D)) ? blockstate1 : blockstate1.setValue(TYPE, SlabType.TOP);
	      }
	}

	public PushReaction getPistonPushReaction(BlockState blockState) {
		return PushReaction.PUSH_ONLY;
	}
	
}
