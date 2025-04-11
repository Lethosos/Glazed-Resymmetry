package com.lethosos.glazedresymmetry.compat.util;

import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.StainedGlassPaneBlock;

//Currently this is off because Patterned Glass is not updated yet 
@SuppressWarnings("unused")
public class GlazedGlassPane extends StainedGlassPaneBlock {

	public GlazedGlassPane(DyeColor color, Properties properties) {
		super(color, properties);
		// TODO Auto-generated constructor stub
	}
	/*
	private final DyeColor color;
	
	public GlazedGlassPane(Properties properties, DyeColor color) {
        super(color, Properties.of()
                .strength(0.3F)
                .sound(SoundType.GLASS)
                .noOcclusion()
                .isValidSpawn((state, getter, pos, entity) -> false)
                .isRedstoneConductor((state, getter, pos) -> false)
                .isSuffocating((state, getter, pos) -> false)
                .isViewBlocking((state, getter, pos) -> false));
        this.color = color;
        this.registerDefaultState(this.stateDefinition.any()
                .setValue(NORTH, Boolean.valueOf(false))
                .setValue(EAST, Boolean.valueOf(false))
                .setValue(SOUTH, Boolean.valueOf(false))
                .setValue(WEST, Boolean.valueOf(false))
                .setValue(WATERLOGGED, Boolean.valueOf(false)));

    }

    public DyeColor getColor() {
        return this.color;
    }
    */
}
