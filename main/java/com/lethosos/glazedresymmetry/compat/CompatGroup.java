package com.lethosos.glazedresymmetry.compat;

import com.lethosos.glazedresymmetry.Registration;
import com.lethosos.glazedresymmetry.init.GlazedBlocks;
import com.lethosos.glazedresymmetry.init.GlazedGroup;
import com.lethosos.glazedresymmetry.init.util.GlazedSlabBlock;
import com.lethosos.glazedresymmetry.init.util.PottablePlants;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FlowerPotBlock;
import net.minecraft.world.level.block.GlazedTerracottaBlock;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.entity.DecoratedPotPattern;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.neoforge.registries.DeferredBlock;

public class CompatGroup extends GlazedGroup {

	public CompatGroup(String name, MapColor c) {
		super(name, c);
		GBLOCK = GlazedBlocks.BLOCKS;
		GITEM = GlazedBlocks.ITEMS;
		GPATTERN = GlazedBlocks.PATTERNS;
		
		CENTERED = registerBlock("centered_glazed_terracotta", () -> new GlazedTerracottaBlock(GlazedTerracottaProperties(color)));
		PILLAR = registerBlock("glazed_terracotta_pillar", () -> new RotatedPillarBlock(GlazedTerracottaProperties(color)));
		
		SLAB = registerBlock("glazed_terracotta_slab", () -> new GlazedSlabBlock(GlazedTerracottaProperties(color)));
		CENTERED_SLAB = registerBlock("centered_glazed_terracotta_slab", () -> new SlabBlock(GlazedTerracottaProperties(color)));
		PILLAR_SLAB = registerBlock("glazed_terracotta_pillar_slab", () -> new SlabBlock(GlazedTerracottaProperties(color)));
		SIDE_PILLAR_SLAB = registerBlock("glazed_terracotta_side_pillar_slab", () -> new GlazedSlabBlock(GlazedTerracottaProperties(color)));
		
		FLOWER_POT = registerBlock("glazed_flower_pot", () -> new FlowerPotBlock(null, () -> (Blocks.AIR), FlowerPotProperties(color)));
		PottablePlants.POTTABLE_BLOCKS.forEach((flower) -> {
			DeferredBlock<FlowerPotBlock> temp = registerBlock("glazed_potted_" + PottablePlants.getName(flower), 
					() -> new FlowerPotBlock(FLOWER_POT, () -> (flower), FlowerPotProperties(color)));
			pottedPots.add(temp);
		});

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
