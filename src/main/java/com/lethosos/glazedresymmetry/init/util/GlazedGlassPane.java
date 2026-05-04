package com.lethosos.glazedresymmetry.init.util;

import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.BeaconBeamBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.StainedGlassPaneBlock;
import net.minecraft.world.level.material.PushReaction;

public class GlazedGlassPane extends StainedGlassPaneBlock implements BeaconBeamBlock {
	public GlazedGlassPane(Properties properties) {
		super(color, properties);
		
        this.registerDefaultState(this.stateDefinition.any()
                .setValue(NORTH, Boolean.valueOf(false))
                .setValue(EAST, Boolean.valueOf(false))
                .setValue(SOUTH, Boolean.valueOf(false))
                .setValue(WEST, Boolean.valueOf(false))
                .setValue(WATERLOGGED, Boolean.valueOf(false)));
	}

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
