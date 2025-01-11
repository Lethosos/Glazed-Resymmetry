package com.lethosos.glazedresymmetry.init;

import java.util.function.Supplier;

import com.lethosos.glazedresymmetry.GlazedResymmetry;
import com.lethosos.glazedresymmetry.init.util.GlazedSlabBlock;

import net.minecraft.tags.TagKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.GlazedTerracottaBlock;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;

public class GlazedGroup {
	
	public static String groupName;
	public static MapColor color;
	
	public DeferredBlock<GlazedTerracottaBlock> CENTERED;
	public DeferredBlock<RotatedPillarBlock> PILLAR;
	
	public DeferredBlock<GlazedSlabBlock> SLAB;
	public DeferredBlock<SlabBlock> CENTERED_SLAB;
	public DeferredBlock<SlabBlock> PILLAR_SLAB;
	public DeferredBlock<GlazedSlabBlock> SIDE_PILLAR_SLAB;
	
	public DeferredItem<Item> SHARD;
	
	public TagKey<Item> SLAB_KEY;
	public TagKey<Item> BLOCK_KEY;

	public GlazedGroup(String name, MapColor c) {
		color = c;
		groupName = name;
		
		CENTERED = registerBlock(name + "_centered_glazed_terracotta", () -> new GlazedTerracottaBlock(GlazedTerracottaProperties(color)));
		PILLAR = registerBlock(name + "_glazed_terracotta_pillar", () -> new RotatedPillarBlock(GlazedTerracottaProperties(color)));
		
		SLAB = registerBlock(name + "_glazed_terracotta_slab", () -> new GlazedSlabBlock(GlazedTerracottaProperties(color)));
		CENTERED_SLAB = registerBlock(name + "_centered_glazed_terracotta_slab", () -> new SlabBlock(GlazedTerracottaProperties(color)));
		PILLAR_SLAB = registerBlock(name + "_glazed_terracotta_pillar_slab", () -> new SlabBlock(GlazedTerracottaProperties(color)));
		SIDE_PILLAR_SLAB = registerBlock(name + "_glazed_terracotta_side_pillar_slab", () -> new GlazedSlabBlock(GlazedTerracottaProperties(color)));
		
		SHARD = registerItem(name + "_glazed_shard", () -> new Item(new Item.Properties().stacksTo(64)));
		// /give Dev glazedresymmetry:blue_glazed_shard[sherdsapi:sherd_pattern="blue_glazed_pattern"] 4
	}
	
	public void addTags(TagKey<Item> slabKey, TagKey<Item> blockKey) {
		SLAB_KEY = slabKey;
		BLOCK_KEY = blockKey;
	}
	
	public String getPatternName() {
		return groupName + "_glazed_pattern";
	}
	
	private static Block.Properties GlazedTerracottaProperties(MapColor c) {
        return BlockBehaviour.Properties.ofFullCopy(Blocks.STONE).mapColor(c).requiresCorrectToolForDrops().strength(1.4F).pushReaction(PushReaction.PUSH_ONLY);
    }
	
    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block) {
        DeferredBlock<T> toReturn = GlazedBlocks.BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> toReturn) {
    	GlazedBlocks.ITEMS.register(name, () -> new BlockItem(toReturn.get(), new Item.Properties()));
    }
    
    private static <T extends Item> DeferredItem<T> registerItem (String name, Supplier<T> item) {
        DeferredItem<T> toReturn = GlazedBlocks.ITEMS.register(name, item);
        return toReturn;
    }
    
	public void toTab() {
    	GlazedCreativeTab.TabList.add(CENTERED.asItem());
		GlazedCreativeTab.TabList.add(PILLAR.asItem());
		GlazedCreativeTab.TabList.add(SLAB.asItem());
		GlazedCreativeTab.TabList.add(CENTERED_SLAB.asItem());
		GlazedCreativeTab.TabList.add(PILLAR_SLAB.asItem());
		GlazedCreativeTab.TabList.add(SIDE_PILLAR_SLAB.asItem());
		GlazedCreativeTab.TabList.add(SHARD.asItem());
		GlazedResymmetry.LOGGER.info(groupName + " glazed items is loaded into Creative Tab!");
    }
}
