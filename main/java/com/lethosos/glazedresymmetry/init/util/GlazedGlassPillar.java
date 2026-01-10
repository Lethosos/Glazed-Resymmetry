package com.lethosos.glazedresymmetry.init.util;

import net.minecraft.core.Direction;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.block.BeaconBeamBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.material.PushReaction;

public class GlazedGlassPillar extends GlazedGlassBlock implements BeaconBeamBlock{

	public GlazedGlassPillar(Properties properties) {
		super(properties);
	}

	private static DyeColor color;
	public static final EnumProperty<Direction.Axis> AXIS = BlockStateProperties.AXIS;
	
	public static Block.Properties GlazedPillarProperties(DyeColor color2) {
		color = color2;
		return Block.Properties.of()
                .strength(0.3F)
                .sound(SoundType.GLASS)
                .mapColor(color.getMapColor())
                .noOcclusion()
                .isValidSpawn((state, getter, pos, entity) -> false)
                .isRedstoneConductor((state, getter, pos) -> false)
                .isSuffocating((state, getter, pos) -> false)
                .isViewBlocking((state, getter, pos) -> false)
                .pushReaction(PushReaction.PUSH_ONLY);
	}

   public BlockState rotate(BlockState p_55930_, Rotation p_55931_) {
      return rotatePillar(p_55930_, p_55931_);
   }

   public static BlockState rotatePillar(BlockState p_154377_, Rotation p_154378_) {
      switch (p_154378_) {
         case COUNTERCLOCKWISE_90:
         case CLOCKWISE_90:
            switch ((Direction.Axis)p_154377_.getValue(AXIS)) {
               case X:
                  return p_154377_.setValue(AXIS, Direction.Axis.Z);
               case Z:
                  return p_154377_.setValue(AXIS, Direction.Axis.X);
               default:
                  return p_154377_;
            }
         default:
            return p_154377_;
      }
   }

   protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> p_55933_) {
      p_55933_.add(AXIS);
   }

   public BlockState getStateForPlacement(BlockPlaceContext p_55928_) {
      return this.defaultBlockState().setValue(AXIS, p_55928_.getClickedFace().getAxis());
   }
}
