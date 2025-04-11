package com.lethosos.glazedresymmetry.init.util;

import com.lethosos.glazedresymmetry.Registration;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public class GlazedTags {
	
    public static class Items {
        public static final TagKey<Item> WHITE_SLABS = createTag("white_glazed_slabs");
        public static final TagKey<Item> WHITE_BLOCKS = createTag("white_glazed_blocks");
        public static final TagKey<Item> LIGHT_GRAY_SLABS = createTag("light_gray_glazed_slabs");
        public static final TagKey<Item> LIGHT_GRAY_BLOCKS = createTag("light_gray_glazed_blocks");
        public static final TagKey<Item> GRAY_SLABS = createTag("gray_glazed_slabs");
        public static final TagKey<Item> GRAY_BLOCKS = createTag("gray_glazed_blocks");
        public static final TagKey<Item> BLACK_SLABS = createTag("black_glazed_slabs");
        public static final TagKey<Item> BLACK_BLOCKS = createTag("black_glazed_blocks");
        public static final TagKey<Item> BROWN_SLABS = createTag("brown_glazed_slabs");
        public static final TagKey<Item> BROWN_BLOCKS = createTag("brown_glazed_blocks");
        public static final TagKey<Item> RED_SLABS = createTag("red_glazed_slabs");
        public static final TagKey<Item> RED_BLOCKS = createTag("red_glazed_blocks");
        public static final TagKey<Item> ORANGE_SLABS = createTag("orange_glazed_slabs");
        public static final TagKey<Item> ORANGE_BLOCKS = createTag("orange_glazed_blocks");
        public static final TagKey<Item> YELLOW_SLABS = createTag("yellow_glazed_slabs");
        public static final TagKey<Item> YELLOW_BLOCKS = createTag("yellow_glazed_blocks");
        public static final TagKey<Item> LIME_SLABS = createTag("lime_glazed_slabs");
        public static final TagKey<Item> LIME_BLOCKS = createTag("lime_glazed_blocks");
        public static final TagKey<Item> GREEN_SLABS = createTag("green_glazed_slabs");
        public static final TagKey<Item> GREEN_BLOCKS = createTag("green_glazed_blocks");
        public static final TagKey<Item> CYAN_SLABS = createTag("cyan_glazed_slabs");
        public static final TagKey<Item> CYAN_BLOCKS = createTag("cyan_glazed_blocks");
        public static final TagKey<Item> LIGHT_BLUE_SLABS = createTag("light_blue_glazed_slabs");
        public static final TagKey<Item> LIGHT_BLUE_BLOCKS = createTag("light_blue_glazed_blocks");
        public static final TagKey<Item> BLUE_SLABS = createTag("blue_glazed_slabs");
        public static final TagKey<Item> BLUE_BLOCKS = createTag("blue_glazed_blocks");
        public static final TagKey<Item> MAGENTA_SLABS = createTag("magenta_glazed_slabs");
        public static final TagKey<Item> MAGENTA_BLOCKS = createTag("magenta_glazed_blocks");
        public static final TagKey<Item> PURPLE_SLABS = createTag("purple_glazed_slabs");
        public static final TagKey<Item> PURPLE_BLOCKS = createTag("purple_glazed_blocks");
        public static final TagKey<Item> PINK_SLABS = createTag("pink_glazed_slabs");
        public static final TagKey<Item> PINK_BLOCKS = createTag("pink_glazed_blocks");
        
        //Clayworks
        public static final TagKey<Item> GLAZED_SLABS = createTag("glazed_slabs");
        public static final TagKey<Item> GLAZED_BLOCKS = createTag("glazed_blocks");
        
        public static final TagKey<Item> ALL_SHARDS = createTag("glazed_shards");

        private static TagKey<Item> createTag(String name) {
            return ItemTags.create(ResourceLocation.fromNamespaceAndPath(Registration.MOD_ID, name));
        }
    }
}
