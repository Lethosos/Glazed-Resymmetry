package com.lethosos.glazedresymmetry.init.util;

import javax.annotation.Nullable;

import net.minecraft.core.Direction;
import net.minecraft.core.Holder;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.block.BeaconBeamBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.StainedGlassBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.PushReaction;

public class GlazedGlassBlock extends StainedGlassBlock implements BeaconBeamBlock {
	private Holder<Block> glass1;
	private Holder<Block> glass2;
	
	public GlazedGlassBlock(Properties properties, @Nullable Holder<Block> g1, @Nullable Holder<Block> g2) {
		super(color, properties);
		glass1 = g1;
		glass2 = g2;
	}
	
	private static DyeColor color;
	public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;
	
	public static Properties GlazedGlassProperties(DyeColor color2) {
		color = color2;
		return Block.Properties.of()
                .strength(0.3F)
                .instrument(NoteBlockInstrument.HAT)
                .sound(SoundType.GLASS)
                .noOcclusion()
                .mapColor(color.getMapColor())
                .isValidSpawn(Blocks::never)
                .isRedstoneConductor((state, getter, pos) -> false)
                .isSuffocating((state, getter, pos) -> false)
                .isViewBlocking((state, getter, pos) -> false)
                .pushReaction(PushReaction.PUSH_ONLY);
	}
	
	@Override
	public BlockState rotate(BlockState state, Rotation rotation) {
        return state.setValue(FACING, rotation.rotate(state.getValue(FACING)));
    }

	@Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> stateBuilder) {
        stateBuilder.add(FACING);
    }

	@Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
    	return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite());
    }
    
    @Override
    public DyeColor getColor() {
 	   return color;
    }
    
    @Override
    protected boolean skipRendering(BlockState state, BlockState adjacentBlockState, Direction side) {
 	   if (glass1 != null) {
 		   if (adjacentBlockState.is(glass1)) { return adjacentBlockState.is(glass1) ? true : super.skipRendering(state, adjacentBlockState, side); }
 		   else if (adjacentBlockState.is(glass2)) { return adjacentBlockState.is(glass2) ? true : super.skipRendering(state, adjacentBlockState, side); }
 		   else { return adjacentBlockState.is(this) ? true : super.skipRendering(state, adjacentBlockState, side); }
 	   }
 		else {
 		   return adjacentBlockState.is(this) ? true : super.skipRendering(state, adjacentBlockState, side);
 	   }
    }
}
