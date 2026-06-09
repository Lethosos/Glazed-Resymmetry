package com.lethosos.glazedresymmetry.init.util;

import java.util.Set;

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
	private Set<Holder<Block>> key;
	
	public GlazedGlassBlock(Properties properties, @Nullable Holder<Block> cg, @Nullable Holder<Block> p) {
		super(color, properties);
		key = Set.of(cg, p);
	}
	public GlazedGlassBlock(Properties properties) { super(color, properties); }
	
	public void setKey(Set<Holder<Block>> k) { key = k; }
	
	public void setGlassHolders(@Nullable Holder<Block> cg, @Nullable Holder<Block> p) { key = Set.of(cg, p); }
	
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
     	return key.contains(adjacentBlockState.getBlockHolder()) ? true : super.skipRendering(state, adjacentBlockState, side);
    }
}
