package com.lethosos.glazedresymmetry.init.util;

import net.minecraft.core.Holder;

//import com.teamabnormals.clayworks.core.registry.ClayworksBlocks;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

public class VanillaCheck {

	public static Holder<Block> temp;
	
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

		//Clayworks compat
		case "glazed":
			if (temp != null) {	return temp.value(); }
			else { return Blocks.TERRACOTTA; }
		}
		
		//Don't need this, but syntax requires it
		return Blocks.TERRACOTTA;
	}
	
	public static Block returnGlass(String color) {
		switch (color)
		{
		// Vanilla Colors
		case "white":
			return Blocks.WHITE_STAINED_GLASS;
        case "light_gray":
			return Blocks.LIGHT_GRAY_STAINED_GLASS;
		case "gray":
			return Blocks.GRAY_STAINED_GLASS;
		case "black":
			return Blocks.BLACK_STAINED_GLASS;
		case "brown":
			return Blocks.BROWN_STAINED_GLASS;
		case "red":
			return Blocks.RED_STAINED_GLASS;
		case "orange":
			return Blocks.ORANGE_STAINED_GLASS;
		case "yellow":
			return Blocks.YELLOW_STAINED_GLASS;
		case "lime":
			return Blocks.LIME_STAINED_GLASS;
		case "green":
			return Blocks.GREEN_STAINED_GLASS;
		case "cyan":
			return Blocks.CYAN_STAINED_GLASS;
		case "light_blue":
			return Blocks.LIGHT_BLUE_STAINED_GLASS;
		case "blue":
			return Blocks.BLUE_STAINED_GLASS;
		case "purple":
			return Blocks.PURPLE_STAINED_GLASS;
		case "magenta":
			return Blocks.MAGENTA_STAINED_GLASS;
		case "pink":

		//Clayworks compat
		//case "glazed":
			//return ClayworksBlocks.GLAZED_STAINED_GLASS.get();
			//return Blocks.TERRACOTTA;
		}
		
		//Don't need this, but syntax requires it
		return Blocks.TERRACOTTA;
	}
}
