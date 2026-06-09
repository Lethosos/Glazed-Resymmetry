package com.lethosos.glazedresymmetry.init.util;

import java.util.Collections;
import java.util.Set;
import java.util.stream.Collectors;

import com.lethosos.glazedresymmetry.GlazedResymmetry;
import com.lethosos.glazedresymmetry.init.GlazedBlocks;

import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class GlazedTags {
	
    public static final TagKey<Item> POTTABLE_PLANTS = createItemTag("pottable_plants");
	
    public static class Items {
        public static final TagKey<Item> WHITE_SLABS = createItemTag("white_glazed_slabs");
        public static final TagKey<Item> WHITE_BLOCKS = createItemTag("white_glazed_blocks");
        public static final TagKey<Item> WHITE_GLASS = createItemTag("white_glazed_glass");
        public static final TagKey<Item> WHITE_PANES = createItemTag("white_glazed_panes");
        
        public static final TagKey<Item> LIGHT_GRAY_SLABS = createItemTag("light_gray_glazed_slabs");
        public static final TagKey<Item> LIGHT_GRAY_BLOCKS = createItemTag("light_gray_glazed_blocks");
        public static final TagKey<Item> LIGHT_GRAY_GLASS = createItemTag("light_gray_glazed_glass");
        public static final TagKey<Item> LIGHT_GRAY_PANES = createItemTag("light_gray_glazed_panes");

        public static final TagKey<Item> GRAY_SLABS = createItemTag("gray_glazed_slabs");
        public static final TagKey<Item> GRAY_BLOCKS = createItemTag("gray_glazed_blocks");
        public static final TagKey<Item> GRAY_GLASS = createItemTag("gray_glazed_glass");
        public static final TagKey<Item> GRAY_PANES = createItemTag("gray_glazed_panes");
        
        public static final TagKey<Item> BLACK_SLABS = createItemTag("black_glazed_slabs");
        public static final TagKey<Item> BLACK_BLOCKS = createItemTag("black_glazed_blocks");
        public static final TagKey<Item> BLACK_GLASS = createItemTag("black_glazed_glass");
        public static final TagKey<Item> BLACK_PANES = createItemTag("black_glazed_panes");
        
        public static final TagKey<Item> BROWN_SLABS = createItemTag("brown_glazed_slabs");
        public static final TagKey<Item> BROWN_BLOCKS = createItemTag("brown_glazed_blocks");
        public static final TagKey<Item> BROWN_GLASS = createItemTag("brown_glazed_glass");
        public static final TagKey<Item> BROWN_PANES = createItemTag("brown_glazed_panes");
        
        public static final TagKey<Item> RED_SLABS = createItemTag("red_glazed_slabs");
        public static final TagKey<Item> RED_BLOCKS = createItemTag("red_glazed_blocks");
        public static final TagKey<Item> RED_GLASS = createItemTag("red_glazed_glass");
        public static final TagKey<Item> RED_PANES = createItemTag("red_glazed_panes");
        
        public static final TagKey<Item> ORANGE_SLABS = createItemTag("orange_glazed_slabs");
        public static final TagKey<Item> ORANGE_BLOCKS = createItemTag("orange_glazed_blocks");
        public static final TagKey<Item> ORANGE_GLASS = createItemTag("orange_glazed_glass");
        public static final TagKey<Item> ORANGE_PANES = createItemTag("orange_glazed_panes");
        
        public static final TagKey<Item> YELLOW_SLABS = createItemTag("yellow_glazed_slabs");
        public static final TagKey<Item> YELLOW_BLOCKS = createItemTag("yellow_glazed_blocks");
        public static final TagKey<Item> YELLOW_GLASS = createItemTag("yellow_glazed_glass");
        public static final TagKey<Item> YELLOW_PANES = createItemTag("yellow_glazed_panes");
        
        public static final TagKey<Item> LIME_SLABS = createItemTag("lime_glazed_slabs");
        public static final TagKey<Item> LIME_BLOCKS = createItemTag("lime_glazed_blocks");
        public static final TagKey<Item> LIME_GLASS = createItemTag("lime_glazed_glass");
        public static final TagKey<Item> LIME_PANES = createItemTag("lime_glazed_panes");
        
        public static final TagKey<Item> GREEN_SLABS = createItemTag("green_glazed_slabs");
        public static final TagKey<Item> GREEN_BLOCKS = createItemTag("green_glazed_blocks");
        public static final TagKey<Item> GREEN_GLASS = createItemTag("green_glazed_glass");
        public static final TagKey<Item> GREEN_PANES = createItemTag("green_glazed_panes");
        
        public static final TagKey<Item> CYAN_SLABS = createItemTag("cyan_glazed_slabs");
        public static final TagKey<Item> CYAN_BLOCKS = createItemTag("cyan_glazed_blocks");
        public static final TagKey<Item> CYAN_GLASS = createItemTag("cyan_glazed_glass");
        public static final TagKey<Item> CYAN_PANES = createItemTag("cyan_glazed_panes");
        
        public static final TagKey<Item> LIGHT_BLUE_SLABS = createItemTag("light_blue_glazed_slabs");
        public static final TagKey<Item> LIGHT_BLUE_BLOCKS = createItemTag("light_blue_glazed_blocks");
        public static final TagKey<Item> LIGHT_BLUE_GLASS = createItemTag("light_blue_glazed_glass");
        public static final TagKey<Item> LIGHT_BLUE_PANES = createItemTag("light_blue_glazed_panes");
        
        public static final TagKey<Item> BLUE_SLABS = createItemTag("blue_glazed_slabs");
        public static final TagKey<Item> BLUE_BLOCKS = createItemTag("blue_glazed_blocks");
        public static final TagKey<Item> BLUE_GLASS = createItemTag("blue_glazed_glass");
        public static final TagKey<Item> BLUE_PANES = createItemTag("blue_glazed_panes");
        
        public static final TagKey<Item> MAGENTA_SLABS = createItemTag("magenta_glazed_slabs");
        public static final TagKey<Item> MAGENTA_BLOCKS = createItemTag("magenta_glazed_blocks");
        public static final TagKey<Item> MAGENTA_GLASS = createItemTag("magenta_glazed_glass");
        public static final TagKey<Item> MAGENTA_PANES = createItemTag("magenta_glazed_panes");
        
        public static final TagKey<Item> PURPLE_SLABS = createItemTag("purple_glazed_slabs");
        public static final TagKey<Item> PURPLE_BLOCKS = createItemTag("purple_glazed_blocks");
        public static final TagKey<Item> PURPLE_GLASS = createItemTag("purple_glazed_glass");
        public static final TagKey<Item> PURPLE_PANES = createItemTag("purple_glazed_panes");
        
        public static final TagKey<Item> PINK_SLABS = createItemTag("pink_glazed_slabs");
        public static final TagKey<Item> PINK_BLOCKS = createItemTag("pink_glazed_blocks");
        public static final TagKey<Item> PINK_GLASS = createItemTag("pink_glazed_glass");
        public static final TagKey<Item> PINK_PANES = createItemTag("pink_glazed_panes");
        
        public static final TagKey<Item> ALL_SHARDS = createItemTag("glazed_shards");
        
		//Clayworks Compat
		public static TagKey<Item> GLAZED_SLABS;
		public static TagKey<Item> GLAZED_BLOCKS;
		public static TagKey<Item> GLAZED_GLASS;
		public static TagKey<Item> GLAZED_PANES;
		public static TagKey<Block> GLAZED_GLASS_BLOCKS;
	    public static void compat() {
	    	if (GlazedResymmetry.CLAYWORKS == true) {
	    		GLAZED_SLABS = createItemTag("glazed_slabs");
	    		GLAZED_BLOCKS = createItemTag("glazed_blocks");
	    		GLAZED_GLASS = createItemTag("glazed_glass");
	    		GLAZED_PANES = createItemTag("glazed_panes");
	    	}
	    }
    }
    
    public static TagKey<Item> createItemTag(String name) {
        return GlazedBlocks.ITEMS.createTagKey(ResourceLocation.fromNamespaceAndPath(GlazedResymmetry.MOD_ID, name));
    }

    public class GlazedTagsShardCache {
        private static Set<Holder<Item>> itemsInTag = null;

        public static Set<Holder<Item>> getItemTagContents() {
            if (itemsInTag == null) {
                // Wrap as an unmodifiable set, as we're not supposed to modify this anyway
                 itemsInTag = Collections.unmodifiableSet(BuiltInRegistries.ITEM.getOrCreateTag(GlazedTags.Items.ALL_SHARDS).stream().collect(Collectors.toSet()));
            }
            return itemsInTag;
        }
        
        public static void invalidateCache() {
            itemsInTag = null;
        }
    }
}
