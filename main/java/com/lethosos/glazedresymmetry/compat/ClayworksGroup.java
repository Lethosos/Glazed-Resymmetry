package com.lethosos.glazedresymmetry.compat;

import com.lethosos.glazedresymmetry.Registration;
import com.lethosos.glazedresymmetry.init.GlazedBlocks;
import com.lethosos.glazedresymmetry.init.util.GlazedFlowerPot;
import com.lethosos.glazedresymmetry.init.util.GlazedGroup;
import com.lethosos.glazedresymmetry.init.util.GlazedSlabBlock;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.GlazedTerracottaBlock;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.entity.DecoratedPotPattern;

public class ClayworksGroup extends GlazedGroup {

	public ClayworksGroup(String name) {
		super(name, DyeColor.ORANGE);
		GBLOCK = GlazedBlocks.BLOCKS;
		GITEM = GlazedBlocks.ITEMS;
		GPATTERN = GlazedBlocks.PATTERNS;
		
		CENTERED = registerBlock("centered_glazed_terracotta", () -> new GlazedTerracottaBlock(GlazedTerracottaProperties(color)));
		PILLAR = registerBlock("glazed_terracotta_pillar", () -> new RotatedPillarBlock(GlazedTerracottaProperties(color)));
		
		SLAB = registerBlock("glazed_terracotta_slab", () -> new GlazedSlabBlock(GlazedTerracottaProperties(color)));
		CENTERED_SLAB = registerBlock("centered_glazed_terracotta_slab", () -> new SlabBlock(GlazedTerracottaProperties(color)));
		PILLAR_SLAB = registerBlock("glazed_terracotta_pillar_slab", () -> new SlabBlock(GlazedTerracottaProperties(color)));
		SIDE_PILLAR_SLAB = registerBlock("glazed_terracotta_side_pillar_slab", () -> new GlazedSlabBlock(GlazedTerracottaProperties(color)));
		
		FLOWER_POT = registerBlock("glazed_flower_pot", () -> new GlazedFlowerPot(GlazedGroup.FlowerPotProperties(color)));

		SHARD = registerItem("glazed_shard", () -> new Item(new Item.Properties().stacksTo(64)));
		PATTERN = GPATTERN.register("glazed_pattern", () -> new DecoratedPotPattern(pointToPattern()));
	}
	
	public String getPatternName() {
		return "glazed_pattern";
	}
	
    protected static ResourceLocation pointToPattern() {
    	return ResourceLocation.fromNamespaceAndPath(Registration.MOD_ID, "glazed_pattern");
    }
}
