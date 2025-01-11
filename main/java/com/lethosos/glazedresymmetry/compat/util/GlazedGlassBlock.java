package com.lethosos.glazedresymmetry.compat.util;

import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.block.BeaconBeamBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.StainedGlassBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.DirectionProperty;

public class GlazedGlassBlock extends StainedGlassBlock implements BeaconBeamBlock {

	public GlazedGlassBlock(DyeColor dyeColor, Properties properties) {
		super(dyeColor, properties);
		// TODO Auto-generated constructor stub
	}
	/*
	private final DyeColor color;
	public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;
	
	protected GlazedGlassBlock(DyeColor c) {
		super(Block.Properties.of()
                .strength(0.3F)
                .sound(SoundType.GLASS)
                .noOcclusion()
                .isValidSpawn((state, getter, pos, entity) -> false)
                .isRedstoneConductor((state, getter, pos) -> false)
                .isSuffocating((state, getter, pos) -> false)
                .isViewBlocking((state, getter, pos) -> false));
		this.color = c;
	}
	
	public BlockState rotate(BlockState state, Rotation rotation) {
        return state.setValue(FACING, rotation.rotate(state.getValue(FACING)));
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> stateBuilder) {
        stateBuilder.add(FACING);
    }

    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite());
    }

	@Override
	public DyeColor getColor() {
		return color;
	}
	*/
}
