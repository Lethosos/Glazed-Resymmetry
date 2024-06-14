package com.lethosos.glazedresymmetry.init.util;

import com.lethosos.glazedresymmetry.Registration;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;

public class ModTags {
	public static class Blocks{
		public static final TagKey<Block> ALL_POTABLE_PLANTS = tag("potable_plants");
		
		private static TagKey<Block> tag(String name){
			return BlockTags.create(new ResourceLocation(Registration.MOD_ID, name));
		}
		
	}

}
