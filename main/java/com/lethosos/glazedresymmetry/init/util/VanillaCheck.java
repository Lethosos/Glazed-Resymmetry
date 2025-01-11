package com.lethosos.glazedresymmetry.init.util;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

public class VanillaCheck {

	public static Block returnGlazed(String color) {
		switch (color)
		{
		// Vanilla Colors
		case "white":
			return Blocks.WHITE_GLAZED_TERRACOTTA;
        case "light_gray":
			return Blocks.LIGHT_GRAY_GLAZED_TERRACOTTA;
		case "gray":
			return Blocks.GRAY_GLAZED_TERRACOTTA;
		case "black":
			return Blocks.BLACK_GLAZED_TERRACOTTA;
		case "brown":
			return Blocks.BROWN_GLAZED_TERRACOTTA;
		case "red":
			return Blocks.RED_GLAZED_TERRACOTTA;
		case "orange":
			return Blocks.ORANGE_GLAZED_TERRACOTTA;
		case "yellow":
			return Blocks.YELLOW_GLAZED_TERRACOTTA;
		case "lime":
			return Blocks.LIME_GLAZED_TERRACOTTA;
		case "green":
			return Blocks.GREEN_GLAZED_TERRACOTTA;
		case "cyan":
			return Blocks.CYAN_GLAZED_TERRACOTTA;
		case "light_blue":
			return Blocks.LIGHT_BLUE_GLAZED_TERRACOTTA;
		case "blue":
			return Blocks.BLUE_GLAZED_TERRACOTTA;
		case "purple":
			return Blocks.PURPLE_GLAZED_TERRACOTTA;
		case "magenta":
			return Blocks.MAGENTA_GLAZED_TERRACOTTA;
		case "pink":
			return Blocks.PINK_GLAZED_TERRACOTTA;

		// Might add more colors here for compat? Will think on this.
		//case "glazed":
		//	return Clayworks.GLAZED_TERRACOTTA;

		}
		
		//Don't need this, but syntax requires it
		return Blocks.TERRACOTTA;
	}
}
