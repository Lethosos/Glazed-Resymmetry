package com.lethosos.glazedresymmetry.compat;

import org.apache.logging.log4j.Level;

import com.lethosos.glazedresymmetry.GlazedResymmetry;
import com.lethosos.glazedresymmetry.Registration;
import com.lethosos.glazedresymmetry.init.GlazedBlocks;
import com.lethosos.glazedresymmetry.init.GlazedSlabBlock;
import com.lethosos.glazedresymmetry.init.util.ModItemSubRegistryHelper;
import com.teamabnormals.blueprint.core.util.item.CreativeModeTabContentsPopulator;
import com.teamabnormals.blueprint.core.util.registry.BlockSubRegistryHelper;

import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.GlazedTerracottaBlock;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.registries.RegistryObject;

public class Clayworks {
	public static final BlockSubRegistryHelper HELPER = Registration.REGISTRY_HELPER.getBlockSubHelper();
	public static final ModItemSubRegistryHelper IHELPER = Registration.REGISTRY_HELPER.getItemSubHelper();

	//GLAZED
	public static RegistryObject<Block> CENTERED_GLAZED_TERRACOTTA;
	public static RegistryObject<Block> GLAZED_TERRACOTTA_PILLAR;
	public static RegistryObject<Block> GLAZED_TERRACOTTA_SLAB;
	public static RegistryObject<Block> GLAZED_TERRACOTTA_PILLAR_SLAB;
	public static RegistryObject<Block> GLAZED_TERRACOTTA_SIDE_PILLAR_SLAB;
	public static RegistryObject<Block> CENTERED_GLAZED_TERRACOTTA_SLAB;
	
	public static RegistryObject<Item> GLAZED_SHARD;

	//Clayworks compat
	public static void register() {
       	CENTERED_GLAZED_TERRACOTTA = HELPER.createBlock("centered_glazed_terracotta", () -> new GlazedTerracottaBlock(GlazedBlocks.GlazedTerracottaProperties(Blocks.TERRACOTTA.defaultMapColor().toString())));
      	GLAZED_TERRACOTTA_PILLAR = HELPER.createBlock("glazed_terracotta_pillar", () -> new RotatedPillarBlock(GlazedBlocks.GlazedTerracottaProperties(Blocks.TERRACOTTA.defaultMapColor().toString())));
       	GLAZED_TERRACOTTA_SLAB = HELPER.createBlock("glazed_terracotta_slab", () -> new GlazedSlabBlock(GlazedBlocks.GlazedTerracottaProperties(Blocks.TERRACOTTA.defaultMapColor().toString())));
       	GLAZED_TERRACOTTA_PILLAR_SLAB = HELPER.createBlock("glazed_terracotta_pillar_slab", () -> new SlabBlock(GlazedBlocks.GlazedTerracottaProperties(Blocks.TERRACOTTA.defaultMapColor().toString())));
       	GLAZED_TERRACOTTA_SIDE_PILLAR_SLAB = HELPER.createBlock("glazed_terracotta_side_pillar_slab", () -> new GlazedSlabBlock(GlazedBlocks.GlazedTerracottaProperties(Blocks.TERRACOTTA.defaultMapColor().toString())));
       	CENTERED_GLAZED_TERRACOTTA_SLAB = HELPER.createBlock("centered_glazed_terracotta_slab", () -> new SlabBlock(GlazedBlocks.GlazedTerracottaProperties(Blocks.TERRACOTTA.defaultMapColor().toString())));
        
       	GLAZED_SHARD = IHELPER.createItem("glazed_shard", () -> new Item(new Item.Properties().stacksTo(64)));
       	
       	GlazedResymmetry.LOGGER.log(Level.INFO, "Compat: Clayworks glazed blocks/item registered");
	}

	public static void setupTabEditors() {
		if (ModList.get().isLoaded("clayworks")) {
			CreativeModeTabContentsPopulator.mod(Registration.MOD_ID)
				.tab(CompatCreativeTab.TAB_KEY2.getKey())
				.addItems(CENTERED_GLAZED_TERRACOTTA,
					GLAZED_TERRACOTTA_PILLAR,
					GLAZED_TERRACOTTA_SLAB,
					GLAZED_TERRACOTTA_PILLAR_SLAB,
					GLAZED_TERRACOTTA_SIDE_PILLAR_SLAB,
					CENTERED_GLAZED_TERRACOTTA_SLAB,
					GLAZED_SHARD);
		}
	}
}
