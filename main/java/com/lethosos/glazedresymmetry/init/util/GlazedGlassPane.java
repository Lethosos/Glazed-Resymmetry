package com.lethosos.glazedresymmetry.init.util;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.block.BeaconBeamBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.StainedGlassPaneBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.material.PushReaction;

public class GlazedGlassPane extends StainedGlassPaneBlock implements BeaconBeamBlock {

	public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;
	
	public GlazedGlassPane(Properties properties) {
		super(color, properties);
		
        this.registerDefaultState(this.stateDefinition.any()
                .setValue(NORTH, Boolean.valueOf(false))
                .setValue(EAST, Boolean.valueOf(false))
                .setValue(SOUTH, Boolean.valueOf(false))
                .setValue(WEST, Boolean.valueOf(false))
                .setValue(WATERLOGGED, Boolean.valueOf(false)));
	}
	/*
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> blockState) {
		blockState.add(FACING);
	}
	
	public BlockState rotate(BlockState state, Rotation rotation) {
        return state.setValue(FACING, rotation.rotate(state.getValue(FACING)));
	}
	
	public BlockState getStateForPlacement(BlockPlaceContext state) {
		BlockPos blockpos = state.getClickedPos();
   		FluidState fluidstate = state.getLevel().getFluidState(blockpos);
   		return this.defaultBlockState().setValue(FACING, state.getHorizontalDirection().getOpposite())
   				.setValue(WATERLOGGED, Boolean.valueOf(fluidstate.getType() == Fluids.WATER));
	}
	/*
	//Copied from Slab code
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
	*/

	private static DyeColor color;
	
	public static Block.Properties GlazedPaneProperties(DyeColor color2) {
		color = color2;
		return Block.Properties.of()
                .strength(0.3F)
                .sound(SoundType.GLASS)
                .noOcclusion()
                .isValidSpawn((state, getter, pos, entity) -> false)
                .isRedstoneConductor((state, getter, pos) -> false)
                .isSuffocating((state, getter, pos) -> false)
                .isViewBlocking((state, getter, pos) -> false)
                .pushReaction(PushReaction.PUSH_ONLY);
    }
}
