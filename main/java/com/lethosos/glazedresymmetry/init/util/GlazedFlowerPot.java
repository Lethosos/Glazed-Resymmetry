package com.lethosos.glazedresymmetry.init.util;

import org.jetbrains.annotations.Nullable;

import com.lethosos.glazedresymmetry.init.util.renderer.GlazedFlowerPotEntity;
import com.mojang.serialization.MapCodec;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class GlazedFlowerPot extends BaseEntityBlock{
    public static final float AABB_SIZE = 3.0F;
    protected static final VoxelShape SHAPE = Block.box(5.0, 0.0, 5.0, 11.0, 6.0, 11.0);
    public static final MapCodec<GlazedFlowerPot> CODEC = simpleCodec(GlazedFlowerPot::new);

	public GlazedFlowerPot(Properties properties) {
		super(properties);
	}
	
    @Override
    protected VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return SHAPE;
    }

    @Override
    protected MapCodec<? extends BaseEntityBlock> codec() {
        return CODEC;
    }

    /* BLOCK ENTITY */

    @Override
    protected RenderShape getRenderShape(BlockState state) {
        return RenderShape.MODEL;
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState) {
        return new GlazedFlowerPotEntity(blockPos, blockState);
    }

    @Override
    protected void onRemove(BlockState state, Level level, BlockPos pos, BlockState newState, boolean movedByPiston) {
        if(state.getBlock() != newState.getBlock()) {
            if(level.getBlockEntity(pos) instanceof GlazedFlowerPotEntity flowerpotBlockEntity) {
                flowerpotBlockEntity.drops();
                level.updateNeighbourForOutputSignal(pos, this);
            }
        }
        super.onRemove(state, level, pos, newState, movedByPiston);
    }

    @Override
    protected ItemInteractionResult useItemOn(ItemStack stack, BlockState state, Level level, BlockPos pos,
                                              Player player, InteractionHand hand, BlockHitResult hitResult) {
        if(level.getBlockEntity(pos) instanceof GlazedFlowerPotEntity flowerpotBlockEntity) {
            if(flowerpotBlockEntity.inventory.getStackInSlot(0).isEmpty() && !stack.isEmpty()) {
            	if (stack.is(GlazedTags.POTTABLE_PLANTS)) {
            		flowerpotBlockEntity.inventory.insertItem(0, stack.copy(), false);
            		level.gameEvent(player, GameEvent.BLOCK_CHANGE, pos);
                    player.awardStat(Stats.POT_FLOWER);
                	stack.shrink(1);
                	level.playSound(player, pos, SoundEvents.ITEM_PICKUP, SoundSource.BLOCKS, 1f, 1f);
                	return ItemInteractionResult.SUCCESS;
            	}
            	else { return ItemInteractionResult.CONSUME; }
            } else if(stack.isEmpty()) {
                ItemStack stackOnPedestal = flowerpotBlockEntity.inventory.extractItem(0, 1, false);
                player.setItemInHand(InteractionHand.MAIN_HAND, stackOnPedestal);
                flowerpotBlockEntity.clearContents();
                level.playSound(player, pos, SoundEvents.ITEM_BREAK, SoundSource.BLOCKS, 1f, 1f);
            }
        }

        return ItemInteractionResult.SUCCESS;
    }
    
    @Override
    public ItemStack getCloneItemStack(LevelReader level, BlockPos pos, BlockState state) {
    	if(level.getBlockEntity(pos) instanceof GlazedFlowerPotEntity flowerpotBlockEntity) {
    		if (!flowerpotBlockEntity.inventory.getStackInSlot(0).isEmpty()) {
    			return flowerpotBlockEntity.inventory.getStackInSlot(0);
    		}
    	}
		return null;    	
    }
}
