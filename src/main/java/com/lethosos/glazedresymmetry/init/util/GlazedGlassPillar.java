package com.lethosos.glazedresymmetry.init.util;

import java.util.Set;

import javax.annotation.Nullable;

import net.minecraft.core.Direction;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.block.BeaconBeamBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.PushReaction;

public class GlazedGlassPillar extends RotatedPillarBlock implements BeaconBeamBlock{
	private Set<Holder<Block>> key;
	
	public GlazedGlassPillar(Properties properties, @Nullable Holder<Block> g, @Nullable Holder<Block> c) {
		super(properties);
		key = Set.of(g, c);
	}
	public GlazedGlassPillar(Properties properties) { super(properties); }
	
	public void setKey(Set<Holder<Block>> k) { key = k;	}
	
	public void setGlassHolders(@Nullable Holder<Block> g, @Nullable Holder<Block> c) { key = Set.of(g, c);	}

	public static final StreamCodec<RegistryFriendlyByteBuf, HolderSet<Block>> HOLDER_SET_STREAM_CODEC =
		    ByteBufCodecs.holderSet(Registries.BLOCK);
	
	private static DyeColor color;
	public static final EnumProperty<Direction.Axis> AXIS = BlockStateProperties.AXIS;
	
	public static Block.Properties GlazedPillarProperties(DyeColor color2) {
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

    /**
     * Returns the blockstate with the given rotation from the passed blockstate. If inapplicable, returns the passed blockstate.
     */
    @Override
    protected BlockState rotate(BlockState state, Rotation rot) {
        return rotatePillar(state, rot);
    }
    
    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(AXIS);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return this.defaultBlockState().setValue(AXIS, context.getClickedFace().getAxis());
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
