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
                Blocks.RED_TULIP, Blocks.ORANGE_TULIP, Blocks.WHITE_TULIP, Blocks.PINK_TULIP, Blocks.OXEYE_DAISY, Blocks.CORNFLOWER, Blocks.LILY_OF_THE_VALLEY, Blocks.WITHER_ROSE));
        // ModBlocks.POTABLE_BLOCKS.addAll(Arrays.asList(Blocks.SUNFLOWER, Blocks.LILAC, Blocks.PEONY, Blocks.ROSE_BUSH));
        POTABLE_BLOCKS.addAll(Arrays.asList(Blocks.OAK_SAPLING, Blocks.SPRUCE_SAPLING, Blocks.BIRCH_SAPLING,
                Blocks.JUNGLE_SAPLING, Blocks.ACACIA_SAPLING, Blocks.DARK_OAK_SAPLING, Blocks.MANGROVE_PROPAGULE, Blocks.CHERRY_SAPLING));
        POTABLE_BLOCKS.addAll(Arrays.asList(Blocks.FERN, Blocks.BAMBOO, Blocks.CACTUS, Blocks.RED_MUSHROOM, Blocks.BROWN_MUSHROOM,
                Blocks.DEAD_BUSH, Blocks.CRIMSON_FUNGUS, Blocks.WARPED_FUNGUS, Blocks.WARPED_ROOTS,Blocks.CRIMSON_ROOTS));
        
		//POTABLE_BLOCKS.addAll(Arrays.asList(ModTags.Blocks.ALL_POTABLE_PLANTS));
	}
	
	public static void addFlower(Block flower) {
		POTABLE_BLOCKS.add(flower);
	}
	
	public static Block addPotable(Block flower) {
		POTABLE_BLOCKS.add(flower);
		return flower;
	}
	
	public static String getName(Block flower) {
		//Block{minecraft:dandelion}
		String x = flower.toString();
		x = x.replace("Block{minecraft:", "");
		x = x.replace("}", "");
		return x;
	}
}
