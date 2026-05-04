package com.lethosos.glazedresymmetry.init.util;

import java.util.List;

import com.lethosos.glazedresymmetry.GlazedResymmetry;
import com.lethosos.glazedresymmetry.init.GlazedBlocks;

import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;

public class GlasscutterTool extends Item {
	public GlasscutterTool(Properties properties) {
		super(properties);
	}

	@Override
	public InteractionResult useOn(UseOnContext context) {
		Level level = context.getLevel();
		Block clickedBlock = level.getBlockState(context.getClickedPos()).getBlock();
		BlockState oldState = level.getBlockState(context.getClickedPos());
		if (oldState == null) { oldState = clickedBlock.defaultBlockState().setValue(BlockStateProperties.FACING, Direction.NORTH); }

		if (GlazedBlocks.CUTTER_MAP.containsKey(clickedBlock)) {
			if (!level.isClientSide()) {
				GlazedBlocks.CUTTER_MAP.get(clickedBlock);
				level.setBlockAndUpdate(context.getClickedPos(), 
						Block.updateFromNeighbourShapes(GlazedBlocks.CUTTER_MAP.get(clickedBlock).defaultBlockState(), level, context.getClickedPos()));

				context.getItemInHand().hurtAndBreak(1, ((ServerLevel) level), context.getPlayer(),
						item -> context.getPlayer().onEquippedItemBroken(item, EquipmentSlot.MAINHAND));

			}
		}
		if (GlazedBlocks.CUTTER_ROTATABLES.contains(clickedBlock)) {
			if (!level.isClientSide()) {
				GlazedResymmetry.LOGGER.info("oldState onRightClick: " + oldState.toString());
				level.setBlockAndUpdate(context.getClickedPos(), getRotated(oldState));
			}
		}
		
		level.playSound(null, context.getClickedPos(), SoundEvents.GLASS_BREAK, SoundSource.BLOCKS);
		return InteractionResult.SUCCESS;
	}
	
	private BlockState getRotated(BlockState state) {
		BlockState newState = null;
		
		if (state.hasProperty(BlockStateProperties.AXIS))
		{
			Direction.Axis axis = switch(state.getValue(BlockStateProperties.AXIS))
			{
				case X -> Direction.Axis.Y;
				case Y -> Direction.Axis.Z;
				case Z -> Direction.Axis.X;
			};
			newState = state.setValue(BlockStateProperties.AXIS, axis);
		}
		else if (state.hasProperty(BlockStateProperties.HORIZONTAL_FACING))
		{
			Direction direction = switch (state.getValue(BlockStateProperties.HORIZONTAL_FACING)) {
				case UP -> Direction.NORTH;
				case NORTH -> Direction.EAST;
				case EAST -> Direction.SOUTH;
				case SOUTH -> Direction.WEST;
				case WEST -> Direction.NORTH;
				case DOWN -> Direction.SOUTH;
			};
			newState = state.setValue(BlockStateProperties.HORIZONTAL_FACING, direction);
		}
		
		return newState;
	}

	@Override
	public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents,	TooltipFlag tooltipFlag) {
		if (Screen.hasShiftDown()) {
			tooltipComponents.add(Component.translatable("tooltip.glazedresymmetry.glasscutter.shift_down"));
		} else {
			tooltipComponents.add(Component.translatable("tooltip.glazedresymmetry.glasscutter"));
		}
		super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
	}
}