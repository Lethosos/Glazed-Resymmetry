package com.lethosos.glazedresymmetry.compat;

import com.lethosos.glazedresymmetry.GlazedResymmetry;
import com.lethosos.glazedresymmetry.init.GlazedBlocks;
import com.lethosos.glazedresymmetry.init.GlazedCreativeTab;
import com.lethosos.glazedresymmetry.init.util.GlazedFlowerPot;
import com.lethosos.glazedresymmetry.init.util.GlazedGroup;
import com.lethosos.glazedresymmetry.init.util.GlazedSlabBlock;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.GlazedTerracottaBlock;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.entity.DecoratedPotPattern;

public class ClayworksGroup extends GlazedGroup {

	public String groupName;
	public DyeColor color;
	
	public ClayworksGroup() {
		super("glazed", DyeColor.ORANGE);
		color = DyeColor.ORANGE;
		groupName = "glazed";
		
		GBLOCK = GlazedBlocks.BLOCKS;
		GITEM = GlazedBlocks.ITEMS;
		GPATTERN = GlazedBlocks.PATTERNS;
		
		CENTERED = GlazedGroup.registerBlock("centered_glazed_terracotta", () -> new GlazedTerracottaBlock(GlazedGroup.GlazedTerracottaProperties(color)));
		PILLAR = GlazedGroup.registerBlock("glazed_terracotta_pillar", () -> new RotatedPillarBlock(GlazedGroup.GlazedTerracottaProperties(color)));
		
		SLAB = GlazedGroup.registerBlock("glazed_terracotta_slab", () -> new GlazedSlabBlock(GlazedGroup.GlazedTerracottaProperties(color)));
		CENTERED_SLAB = GlazedGroup.registerBlock("centered_glazed_terracotta_slab", () -> new SlabBlock(GlazedGroup.GlazedTerracottaProperties(color)));
		PILLAR_SLAB = GlazedGroup.registerBlock("glazed_terracotta_pillar_slab", () -> new SlabBlock(GlazedGroup.GlazedTerracottaProperties(color)));
		SIDE_PILLAR_SLAB = GlazedGroup.registerBlock("glazed_terracotta_side_pillar_slab", () -> new GlazedSlabBlock(GlazedGroup.GlazedTerracottaProperties(color)));
		
		FLOWER_POT = GlazedGroup.registerBlock("glazed_flower_pot", () -> new GlazedFlowerPot(GlazedGroup.FlowerPotProperties(color)));

		SHARD = GlazedGroup.registerItem("glazed_shard", () -> new Item(new Item.Properties().stacksTo(64)));
		PATTERN = GPATTERN.register("glazed_pattern", () -> new DecoratedPotPattern(pointToPattern()));
		
		GLASS = new ClayworksGlassGroup();
	}
	
	public String getPatternName() {
		return "glazed_pattern";
	}
	
	public void addTags(TagKey<Item> slabKey, TagKey<Item> blockKey) {
		SLAB_KEY = slabKey;
		BLOCK_KEY = blockKey;
	}
	
    protected static ResourceLocation pointToPattern() {
    	return ResourceLocation.fromNamespaceAndPath(GlazedResymmetry.MOD_ID, "glazed_pattern");
    }
    
    public void toTab() {
    	GlazedCreativeTab.TabList.add(CENTERED.asItem());
		GlazedCreativeTab.TabList.add(PILLAR.asItem());
		GlazedCreativeTab.TabList.add(SLAB.asItem());
		GlazedCreativeTab.TabList.add(CENTERED_SLAB.asItem());
		GlazedCreativeTab.TabList.add(PILLAR_SLAB.asItem());
		GlazedCreativeTab.TabList.add(SIDE_PILLAR_SLAB.asItem());
		GlazedCreativeTab.TabList.add(FLOWER_POT.asItem());
		GlazedCreativeTab.TabList.add(SHARD.asItem());
		
		GLASS.toTab();
    }
}
