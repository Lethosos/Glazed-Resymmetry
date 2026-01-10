package com.lethosos.glazedresymmetry.init.util;

import java.util.Collections;
import java.util.Set;
import java.util.stream.Collectors;

import com.lethosos.glazedresymmetry.Registration;
import com.lethosos.glazedresymmetry.init.GlazedBlocks;

import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public class GlazedTags {
	
    public static final TagKey<Item> POTTABLE_PLANTS = createTag("pottable_plants");
	
    public static class Items {
        public static final TagKey<Item> WHITE_SLABS = createTag("white_glazed_slabs");
        public static final TagKey<Item> WHITE_BLOCKS = createTag("white_glazed_blocks");
        //public static final TagKey<Item> WHITE_GLASS = createTag("white_glazed_glass");
        //public static final TagKey<Item> WHITE_PANES = createTag("white_glazed_panes");
        
        public static final TagKey<Item> LIGHT_GRAY_SLABS = createTag("light_gray_glazed_slabs");
        public static final TagKey<Item> LIGHT_GRAY_BLOCKS = createTag("light_gray_glazed_blocks");
        public static final TagKey<Item> LIGHT_GRAY_GLASS = createTag("light_gray_glazed_glass");
        public static final TagKey<Item> LIGHT_GRAY_PANES = createTag("light_gray_glazed_panes");

        public static final TagKey<Item> GRAY_SLABS = createTag("gray_glazed_slabs");
        public static final TagKey<Item> GRAY_BLOCKS = createTag("gray_glazed_blocks");
        public static final TagKey<Item> GRAY_GLASS = createTag("gray_glazed_glass");
        public static final TagKey<Item> GRAY_PANES = createTag("gray_glazed_panes");
        
        public static final TagKey<Item> BLACK_SLABS = createTag("black_glazed_slabs");
        public static final TagKey<Item> BLACK_BLOCKS = createTag("black_glazed_blocks");
        public static final TagKey<Item> BLACK_GLASS = createTag("black_glazed_glass");
        public static final TagKey<Item> BLACK_PANES = createTag("black_glazed_panes");
        
        public static final TagKey<Item> BROWN_SLABS = createTag("brown_glazed_slabs");
        public static final TagKey<Item> BROWN_BLOCKS = createTag("brown_glazed_blocks");
        public static final TagKey<Item> BROWN_GLASS = createTag("brown_glazed_glass");
        public static final TagKey<Item> BROWN_PANES = createTag("brown_glazed_panes");
        
        public static final TagKey<Item> RED_SLABS = createTag("red_glazed_slabs");
        public static final TagKey<Item> RED_BLOCKS = createTag("red_glazed_blocks");
        public static final TagKey<Item> RED_GLASS = createTag("red_glazed_glass");
        public static final TagKey<Item> RED_PANES = createTag("red_glazed_panes");
        
        public static final TagKey<Item> ORANGE_SLABS = createTag("orange_glazed_slabs");
        public static final TagKey<Item> ORANGE_BLOCKS = createTag("orange_glazed_blocks");
        public static final TagKey<Item> ORANGE_GLASS = createTag("orange_glazed_glass");
        public static final TagKey<Item> ORANGE_PANES = createTag("orange_glazed_panes");
        
        public static final TagKey<Item> YELLOW_SLABS = createTag("yellow_glazed_slabs");
        public static final TagKey<Item> YELLOW_BLOCKS = createTag("yellow_glazed_blocks");
        public static final TagKey<Item> YELLOW_GLASS = createTag("yellow_glazed_glass");
        public static final TagKey<Item> YELLOW_PANES = createTag("yellow_glazed_panes");
        
        public static final TagKey<Item> LIME_SLABS = createTag("lime_glazed_slabs");
        public static final TagKey<Item> LIME_BLOCKS = createTag("lime_glazed_blocks");
        public static final TagKey<Item> LIME_GLASS = createTag("lime_glazed_glass");
        public static final TagKey<Item> LIME_PANES = createTag("lime_glazed_panes");
        
        public static final TagKey<Item> GREEN_SLABS = createTag("green_glazed_slabs");
        public static final TagKey<Item> GREEN_BLOCKS = createTag("green_glazed_blocks");
        public static final TagKey<Item> GREEN_GLASS = createTag("green_glazed_glass");
        public static final TagKey<Item> GREEN_PANES = createTag("green_glazed_panes");
        
        public static final TagKey<Item> CYAN_SLABS = createTag("cyan_glazed_slabs");
        public static final TagKey<Item> CYAN_BLOCKS = createTag("cyan_glazed_blocks");
        public static final TagKey<Item> CYAN_GLASS = createTag("cyan_glazed_glass");
        public static final TagKey<Item> CYAN_PANES = createTag("cyan_glazed_panes");
        
        public static final TagKey<Item> LIGHT_BLUE_SLABS = createTag("light_blue_glazed_slabs");
        public static final TagKey<Item> LIGHT_BLUE_BLOCKS = createTag("light_blue_glazed_blocks");
        public static final TagKey<Item> LIGHT_BLUE_GLASS = createTag("light_blue_glazed_glass");
        public static final TagKey<Item> LIGHT_BLUE_PANES = createTag("light_blue_glazed_panes");
        
        public static final TagKey<Item> BLUE_SLABS = createTag("blue_glazed_slabs");
        public static final TagKey<Item> BLUE_BLOCKS = createTag("blue_glazed_blocks");
        public static final TagKey<Item> BLUE_GLASS = createTag("blue_glazed_glass");
        public static final TagKey<Item> BLUE_PANES = createTag("blue_glazed_panes");
        
        public static final TagKey<Item> MAGENTA_SLABS = createTag("magenta_glazed_slabs");
        public static final TagKey<Item> MAGENTA_BLOCKS = createTag("magenta_glazed_blocks");
        public static final TagKey<Item> MAGENTA_GLASS = createTag("magenta_glazed_glass");
        public static final TagKey<Item> MAGENTA_PANES = createTag("magenta_glazed_panes");
        
        public static final TagKey<Item> PURPLE_SLABS = createTag("purple_glazed_slabs");
        public static final TagKey<Item> PURPLE_BLOCKS = createTag("purple_glazed_blocks");
        public static final TagKey<Item> PURPLE_GLASS = createTag("purple_glazed_glass");
        public static final TagKey<Item> PURPLE_PANES = createTag("purple_glazed_panes");
        
        public static final TagKey<Item> PINK_SLABS = createTag("pink_glazed_slabs");
        public static final TagKey<Item> PINK_BLOCKS = createTag("pink_glazed_blocks");
        public static final TagKey<Item> PINK_GLASS = createTag("pink_glazed_glass");
        public static final TagKey<Item> PINK_PANES = createTag("pink_glazed_panes");
        
        //Clayworks
        public static final TagKey<Item> GLAZED_SLABS = createTag("glazed_slabs");
        public static final TagKey<Item> GLAZED_BLOCKS = createTag("glazed_blocks");
        public static final TagKey<Item> GLAZED_GLASS = createTag("glazed_glass");
        public static final TagKey<Item> GLAZED_PANES = createTag("glazed_panes");
        
        public static final TagKey<Item> ALL_SHARDS = createTag("glazed_shards");
        }

    private static TagKey<Item> createTag(String name) {
        return GlazedBlocks.ITEMS.createTagKey(ResourceLocation.fromNamespaceAndPath(Registration.MOD_ID, name));
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
