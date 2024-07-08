package com.lethosos.glazedresymmetry.init.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

public class PotablePlants {
	public static final List<Block> POTABLE_BLOCKS = new ArrayList<>();
	
	static {
        POTABLE_BLOCKS.addAll(Arrays.asList(Blocks.DANDELION, Blocks.POPPY, Blocks.BLUE_ORCHID, Blocks.ALLIUM, Blocks.AZURE_BLUET,
                Blocks.RED_TULIP, Blocks.ORANGE_TULIP, Blocks.WHITE_TULIP, Blocks.PINK_TULIP, Blocks.OXEYE_DAISY, Blocks.CORNFLOWER,
                Blocks.LILY_OF_THE_VALLEY, Blocks.WITHER_ROSE, Blocks.TORCHFLOWER));
        POTABLE_BLOCKS.addAll(Arrays.asList(Blocks.OAK_SAPLING, Blocks.SPRUCE_SAPLING, Blocks.BIRCH_SAPLING,
                Blocks.JUNGLE_SAPLING, Blocks.ACACIA_SAPLING, Blocks.DARK_OAK_SAPLING, Blocks.AZALEA, Blocks.FLOWERING_AZALEA,
                Blocks.MANGROVE_PROPAGULE, Blocks.CHERRY_SAPLING));
        POTABLE_BLOCKS.addAll(Arrays.asList(Blocks.FERN, Blocks.BAMBOO, Blocks.CACTUS, Blocks.RED_MUSHROOM, Blocks.BROWN_MUSHROOM,
                Blocks.DEAD_BUSH, Blocks.CRIMSON_FUNGUS, Blocks.WARPED_FUNGUS, Blocks.WARPED_ROOTS, Blocks.CRIMSON_ROOTS));
        
        //Tags?
		//POTABLE_BLOCKS.addAll(Arrays.asList(ModTags.Blocks.ALL_POTABLE_PLANTS));
	}
	
	/**
	 * Add flower/sapling block to the list for GR registry. Will add a means to use tags to auto-add flowers.
	 * @param flower
	 */
	public static void addFlower(Block flower) {
		POTABLE_BLOCKS.add(flower);
	}
	
	/**
	 * Add flower/sapling block to the list for GR registry, returns flower/sapling block if you need it back.
	 * @param flower
	 * @return itself
	 */
	public static Block addPotable(Block flower) {
		POTABLE_BLOCKS.add(flower);
		return flower;
	}
	
	/**
	 * Parses a Block from .toString() into a useable String object. Only works on Minecraft namespace entries.
	 * @param flower
	 * @return a String name of the flower block itself
	 */
	public static String getName(Block flower) {
		String x = flower.toString();
		x = x.replace("Block{minecraft:", "");
		x = x.replace("}", "");
		return x;
	}
}
