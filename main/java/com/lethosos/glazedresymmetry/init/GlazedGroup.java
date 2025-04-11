package com.lethosos.glazedresymmetry.init;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

import com.lethosos.glazedresymmetry.Registration;
import com.lethosos.glazedresymmetry.init.util.GlazedSlabBlock;
import com.lethosos.glazedresymmetry.init.util.PottablePlants;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FlowerPotBlock;
import net.minecraft.world.level.block.GlazedTerracottaBlock;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.entity.DecoratedPotPattern;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class GlazedGroup {
	
	public String groupName;
	public MapColor color;
	
	public DeferredBlock<Block> CENTERED;
	public DeferredBlock<RotatedPillarBlock> PILLAR;
	
	public DeferredBlock<GlazedSlabBlock> SLAB;
	public DeferredBlock<SlabBlock> CENTERED_SLAB;
	public DeferredBlock<SlabBlock> PILLAR_SLAB;
	public DeferredBlock<GlazedSlabBlock> SIDE_PILLAR_SLAB;
	
	public DeferredBlock<FlowerPotBlock> FLOWER_POT;
	public List<DeferredBlock<FlowerPotBlock>> pottedPots = new ArrayList<DeferredBlock<FlowerPotBlock>>();
	
	public DeferredItem<Item> SHARD;
	public DeferredHolder<DecoratedPotPattern, DecoratedPotPattern> PATTERN;
	
	public TagKey<Item> SLAB_KEY;
	public TagKey<Item> BLOCK_KEY;
	
	protected static String GMOD_ID;
	
	protected static DeferredRegister.Blocks GBLOCK;
	protected static DeferredRegister.Items GITEM;
	protected static DeferredRegister<DecoratedPotPattern> GPATTERN;
	
	/*
	 * Internal build only. Use the long form for compat use.
	 */
	public GlazedGroup(String name, MapColor c) {
		color = c;
		groupName = name;
		
		GBLOCK = GlazedBlocks.BLOCKS;
		GITEM = GlazedBlocks.ITEMS;
		GPATTERN = GlazedBlocks.PATTERNS;
		
		GMOD_ID = Registration.MOD_ID;
		
		build();
	}
	
	public GlazedGroup(String name, MapColor c, DeferredRegister.Blocks regBlock, DeferredRegister.Items regItem, DeferredRegister<DecoratedPotPattern> regPattern, String modid) {
		color = c;
		groupName = name;
		
		GBLOCK = regBlock;
		GITEM = regItem;
		GPATTERN = regPattern;
		
		GMOD_ID = modid;
		
		build();
	}
	
	private void build()
	{
		if ( groupName != "glazed") {
			CENTERED = registerBlock(groupName + "_centered_glazed_terracotta", () -> new GlazedTerracottaBlock(GlazedTerracottaProperties(color)));
			PILLAR = registerBlock(groupName + "_glazed_terracotta_pillar", () -> new RotatedPillarBlock(GlazedTerracottaProperties(color)));
		
			SLAB = registerBlock(groupName + "_glazed_terracotta_slab", () -> new GlazedSlabBlock(GlazedTerracottaProperties(color)));
			CENTERED_SLAB = registerBlock(groupName + "_centered_glazed_terracotta_slab", () -> new SlabBlock(GlazedTerracottaProperties(color)));
			PILLAR_SLAB = registerBlock(groupName + "_glazed_terracotta_pillar_slab", () -> new SlabBlock(GlazedTerracottaProperties(color)));
			SIDE_PILLAR_SLAB = registerBlock(groupName + "_glazed_terracotta_side_pillar_slab", () -> new GlazedSlabBlock(GlazedTerracottaProperties(color)));
		
			FLOWER_POT = registerBlock(groupName + "_glazed_flower_pot", () -> new FlowerPotBlock(null, () -> (Blocks.AIR), FlowerPotProperties(color)));
			PottablePlants.POTTABLE_BLOCKS.forEach((flower) -> {
				DeferredBlock<FlowerPotBlock> temp = registerBlock(groupName + "_glazed_potted_" + PottablePlants.getName(flower), 
					() -> new FlowerPotBlock(FLOWER_POT, () -> (flower), FlowerPotProperties(color)));
				pottedPots.add(temp);
			});

			SHARD = registerItem(groupName + "_glazed_shard", () -> new Item(new Item.Properties().stacksTo(64)));
			PATTERN = GPATTERN.register(groupName + "_glazed_pattern", () -> new DecoratedPotPattern(pointToPattern(groupName)));
		}
	}
	
	public void registerPots() {
        FlowerPotBlock block = FLOWER_POT.get();
        pottedPots.forEach((pot) -> {
        	block.addPlant(BuiltInRegistries.BLOCK.getKey(pot.get().getPotted()), pot);
        });
	}
	
	public void addTags(TagKey<Item> slabKey, TagKey<Item> blockKey) {
		SLAB_KEY = slabKey;
		BLOCK_KEY = blockKey;
	}
	
	public static Block.Properties GlazedTerracottaProperties(MapColor c) {
        return BlockBehaviour.Properties.of()
        		.mapColor(c)
        		.requiresCorrectToolForDrops()
        		.strength(1.4F)
        		.pushReaction(PushReaction.PUSH_ONLY);
    }
	
	public static Block.Properties FlowerPotProperties(MapColor c){
		return Blocks.FLOWER_POT.properties()
				.mapColor(c);
	}
	
    public static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block) {
        DeferredBlock<T> toReturn = GBLOCK.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> toReturn) {
    	GITEM.register(name, () -> new BlockItem(toReturn.get(), new Item.Properties()));
    }
    
    //external
    public static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block, DeferredRegister.Blocks regBlock, DeferredRegister.Items regItem) {
        DeferredBlock<T> toReturn = regBlock.register(name, block);
        registerBlockItem(name, toReturn, regItem);
        return toReturn;
    }

    //internal
    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> toReturn, DeferredRegister.Items regItem) {
    	regItem.register(name, () -> new BlockItem(toReturn.get(), new Item.Properties()));
    }
    
    protected static <T extends Item> DeferredItem<T> registerItem (String name, Supplier<T> item) {
        DeferredItem<T> toReturn = GITEM.register(name, item);
        return toReturn;
    }
    
	public String getPatternName(String str) {
		return str + "_glazed_pattern";
	}
    
    protected static ResourceLocation pointToPattern(String name) {
    	return ResourceLocation.fromNamespaceAndPath(GMOD_ID, name + "_glazed_pattern");
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
    }
}
