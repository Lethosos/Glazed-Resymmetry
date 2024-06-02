package com.lethosos.glazedresymmetry.init;

import org.apache.logging.log4j.Level;

import com.lethosos.glazedresymmetry.GlazedResymmetry;
import com.lethosos.glazedresymmetry.Registration;
import com.teamabnormals.blueprint.core.util.item.CreativeModeTabContentsPopulator;
import com.teamabnormals.blueprint.core.util.registry.BlockSubRegistryHelper;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
//import net.minecraft.world.level.block.DecoratedPotBlock;
//import net.minecraft.world.level.block.FlowerPotBlock;
import net.minecraft.world.level.block.GlazedTerracottaBlock;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
//import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.registries.RegistryObject;

@EventBusSubscriber(modid = Registration.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
public class ModBlocks {
	public static final BlockSubRegistryHelper HELPER = Registration.REGISTRY_HELPER.getBlockSubHelper();
	
	//WHITE
	public static RegistryObject<Block> WHITE_CENTERED_GLAZED_TERRACOTTA = HELPER.createBlock("white_centered_glazed_terracotta", () -> new GlazedTerracottaBlock(GlazedTerracottaProperties("white")));
	public static RegistryObject<Block> WHITE_GLAZED_TERRACOTTA_PILLAR = HELPER.createBlock("white_glazed_terracotta_pillar", () -> new RotatedPillarBlock(GlazedTerracottaProperties("white")));
	public static RegistryObject<Block> WHITE_GLAZED_TERRACOTTA_SLAB = HELPER.createBlock("white_glazed_terracotta_slab", () -> new GlazedSlabBlock(GlazedTerracottaProperties("white")));
	public static RegistryObject<Block> WHITE_GLAZED_TERRACOTTA_PILLAR_SLAB = HELPER.createBlock("white_glazed_terracotta_pillar_slab", () -> new SlabBlock(GlazedTerracottaProperties("white")));
	public static RegistryObject<Block> WHITE_GLAZED_TERRACOTTA_PILLAR_SIDE_SLAB = HELPER.createBlock("white_glazed_terracotta_pillar_side_slab", () -> new GlazedSlabBlock(GlazedTerracottaProperties("white")));
	public static RegistryObject<Block> WHITE_CENTERED_GLAZED_TERRACOTTA_SLAB = HELPER.createBlock("white_centered_glazed_terracotta_slab", () -> new SlabBlock(GlazedTerracottaProperties("white")));
	//LIGHT_GRAY
	public static RegistryObject<Block> LIGHT_GRAY_CENTERED_GLAZED_TERRACOTTA = HELPER.createBlock("light_gray_centered_glazed_terracotta", () -> new GlazedTerracottaBlock(GlazedTerracottaProperties("light_gray")));
	public static RegistryObject<Block> LIGHT_GRAY_GLAZED_TERRACOTTA_PILLAR = HELPER.createBlock("light_gray_glazed_terracotta_pillar", () -> new RotatedPillarBlock(GlazedTerracottaProperties("light_gray")));
	public static RegistryObject<Block> LIGHT_GRAY_GLAZED_TERRACOTTA_SLAB = HELPER.createBlock("light_gray_glazed_terracotta_slab", () -> new GlazedSlabBlock(GlazedTerracottaProperties("light_gray")));
	public static RegistryObject<Block> LIGHT_GRAY_GLAZED_TERRACOTTA_PILLAR_SLAB = HELPER.createBlock("light_gray_glazed_terracotta_pillar_slab", () -> new SlabBlock(GlazedTerracottaProperties("light_gray")));
	public static RegistryObject<Block> LIGHT_GRAY_GLAZED_TERRACOTTA_PILLAR_SIDE_SLAB = HELPER.createBlock("light_gray_glazed_terracotta_pillar_side_slab", () -> new GlazedSlabBlock(GlazedTerracottaProperties("light_gray")));
	public static RegistryObject<Block> LIGHT_GRAY_CENTERED_GLAZED_TERRACOTTA_SLAB = HELPER.createBlock("light_gray_centered_glazed_terracotta_slab", () -> new SlabBlock(GlazedTerracottaProperties("light_gray")));
	//RED
	public static RegistryObject<Block> RED_CENTERED_GLAZED_TERRACOTTA = HELPER.createBlock("red_centered_glazed_terracotta", () -> new GlazedTerracottaBlock(GlazedTerracottaProperties("red")));
	public static RegistryObject<Block> RED_GLAZED_TERRACOTTA_PILLAR = HELPER.createBlock("red_glazed_terracotta_pillar", () -> new RotatedPillarBlock(GlazedTerracottaProperties("red")));
	public static RegistryObject<Block> RED_GLAZED_TERRACOTTA_SLAB = HELPER.createBlock("red_glazed_terracotta_slab", () -> new GlazedSlabBlock(GlazedTerracottaProperties("red")));
	public static RegistryObject<Block> RED_GLAZED_TERRACOTTA_PILLAR_SLAB = HELPER.createBlock("red_glazed_terracotta_pillar_slab", () -> new SlabBlock(GlazedTerracottaProperties("red")));
	public static RegistryObject<Block> RED_GLAZED_TERRACOTTA_PILLAR_SIDE_SLAB = HELPER.createBlock("red_glazed_terracotta_pillar_side_slab", () -> new GlazedSlabBlock(GlazedTerracottaProperties("red")));
	public static RegistryObject<Block> RED_CENTERED_GLAZED_TERRACOTTA_SLAB = HELPER.createBlock("red_centered_glazed_terracotta_slab", () -> new SlabBlock(GlazedTerracottaProperties("red")));
	//PURPLE
	public static RegistryObject<Block> PURPLE_CENTERED_GLAZED_TERRACOTTA = HELPER.createBlock("purple_centered_glazed_terracotta", () -> new GlazedTerracottaBlock(GlazedTerracottaProperties("purple")));
	public static RegistryObject<Block> PURPLE_GLAZED_TERRACOTTA_PILLAR = HELPER.createBlock("purple_glazed_terracotta_pillar", () -> new RotatedPillarBlock(GlazedTerracottaProperties("purple")));
	public static RegistryObject<Block> PURPLE_GLAZED_TERRACOTTA_SLAB = HELPER.createBlock("purple_glazed_terracotta_slab", () -> new GlazedSlabBlock(GlazedTerracottaProperties("purple")));
	public static RegistryObject<Block> PURPLE_GLAZED_TERRACOTTA_PILLAR_SLAB = HELPER.createBlock("purple_glazed_terracotta_pillar_slab", () -> new SlabBlock(GlazedTerracottaProperties("purple")));
	public static RegistryObject<Block> PURPLE_GLAZED_TERRACOTTA_PILLAR_SIDE_SLAB = HELPER.createBlock("purple_glazed_terracotta_pillar_side_slab", () -> new GlazedSlabBlock(GlazedTerracottaProperties("purple")));
	public static RegistryObject<Block> PURPLE_CENTERED_GLAZED_TERRACOTTA_SLAB = HELPER.createBlock("purple_centered_glazed_terracotta_slab", () -> new SlabBlock(GlazedTerracottaProperties("purple")));
	//PINK
	public static RegistryObject<Block> PINK_CENTERED_GLAZED_TERRACOTTA = HELPER.createBlock("pink_centered_glazed_terracotta", () -> new GlazedTerracottaBlock(GlazedTerracottaProperties("pink")));
	public static RegistryObject<Block> PINK_GLAZED_TERRACOTTA_PILLAR = HELPER.createBlock("pink_glazed_terracotta_pillar", () -> new RotatedPillarBlock(GlazedTerracottaProperties("pink")));
	public static RegistryObject<Block> PINK_GLAZED_TERRACOTTA_SLAB = HELPER.createBlock("pink_glazed_terracotta_slab", () -> new GlazedSlabBlock(GlazedTerracottaProperties("pink")));
	public static RegistryObject<Block> PINK_GLAZED_TERRACOTTA_PILLAR_SLAB = HELPER.createBlock("pink_glazed_terracotta_pillar_slab", () -> new SlabBlock(GlazedTerracottaProperties("pink")));
	public static RegistryObject<Block> PINK_GLAZED_TERRACOTTA_PILLAR_SIDE_SLAB = HELPER.createBlock("pink_glazed_terracotta_pillar_side_slab", () -> new GlazedSlabBlock(GlazedTerracottaProperties("pink")));
	public static RegistryObject<Block> PINK_CENTERED_GLAZED_TERRACOTTA_SLAB = HELPER.createBlock("pink_centered_glazed_terracotta_slab", () -> new SlabBlock(GlazedTerracottaProperties("pink")));
	//ORANGE
	public static RegistryObject<Block> ORANGE_CENTERED_GLAZED_TERRACOTTA = HELPER.createBlock("orange_centered_glazed_terracotta", () -> new GlazedTerracottaBlock(GlazedTerracottaProperties("orange")));
	public static RegistryObject<Block> ORANGE_GLAZED_TERRACOTTA_PILLAR = HELPER.createBlock("orange_glazed_terracotta_pillar", () -> new RotatedPillarBlock(GlazedTerracottaProperties("orange")));
	public static RegistryObject<Block> ORANGE_GLAZED_TERRACOTTA_SLAB = HELPER.createBlock("orange_glazed_terracotta_slab", () -> new GlazedSlabBlock(GlazedTerracottaProperties("orange")));
	public static RegistryObject<Block> ORANGE_GLAZED_TERRACOTTA_PILLAR_SLAB = HELPER.createBlock("orange_glazed_terracotta_pillar_slab", () -> new SlabBlock(GlazedTerracottaProperties("orange")));
	public static RegistryObject<Block> ORANGE_GLAZED_TERRACOTTA_PILLAR_SIDE_SLAB = HELPER.createBlock("orange_glazed_terracotta_pillar_side_slab", () -> new GlazedSlabBlock(GlazedTerracottaProperties("orange")));
	public static RegistryObject<Block> ORANGE_CENTERED_GLAZED_TERRACOTTA_SLAB = HELPER.createBlock("orange_centered_glazed_terracotta_slab", () -> new SlabBlock(GlazedTerracottaProperties("orange")));
	//MAGENTA
	public static RegistryObject<Block> MAGENTA_CENTERED_GLAZED_TERRACOTTA = HELPER.createBlock("magenta_centered_glazed_terracotta", () -> new GlazedTerracottaBlock(GlazedTerracottaProperties("magenta")));
	public static RegistryObject<Block> MAGENTA_GLAZED_TERRACOTTA_PILLAR = HELPER.createBlock("magenta_glazed_terracotta_pillar", () -> new RotatedPillarBlock(GlazedTerracottaProperties("magenta")));
	public static RegistryObject<Block> MAGENTA_GLAZED_TERRACOTTA_SLAB = HELPER.createBlock("magenta_glazed_terracotta_slab", () -> new GlazedSlabBlock(GlazedTerracottaProperties("magenta")));
	public static RegistryObject<Block> MAGENTA_GLAZED_TERRACOTTA_PILLAR_SLAB = HELPER.createBlock("magenta_glazed_terracotta_pillar_slab", () -> new SlabBlock(GlazedTerracottaProperties("magenta")));
	public static RegistryObject<Block> MAGENTA_GLAZED_TERRACOTTA_PILLAR_SIDE_SLAB = HELPER.createBlock("magenta_glazed_terracotta_pillar_side_slab", () -> new GlazedSlabBlock(GlazedTerracottaProperties("magenta")));
	public static RegistryObject<Block> MAGENTA_CENTERED_GLAZED_TERRACOTTA_SLAB = HELPER.createBlock("magenta_centered_glazed_terracotta_slab", () -> new SlabBlock(GlazedTerracottaProperties("magenta")));
	//LIME
	public static RegistryObject<Block> LIME_CENTERED_GLAZED_TERRACOTTA = HELPER.createBlock("lime_centered_glazed_terracotta", () -> new GlazedTerracottaBlock(GlazedTerracottaProperties("lime")));
	public static RegistryObject<Block> LIME_GLAZED_TERRACOTTA_PILLAR = HELPER.createBlock("lime_glazed_terracotta_pillar", () -> new RotatedPillarBlock(GlazedTerracottaProperties("lime")));
	public static RegistryObject<Block> LIME_GLAZED_TERRACOTTA_SLAB = HELPER.createBlock("lime_glazed_terracotta_slab", () -> new GlazedSlabBlock(GlazedTerracottaProperties("lime")));
	public static RegistryObject<Block> LIME_GLAZED_TERRACOTTA_PILLAR_SLAB = HELPER.createBlock("lime_glazed_terracotta_pillar_slab", () -> new SlabBlock(GlazedTerracottaProperties("lime")));
	public static RegistryObject<Block> LIME_GLAZED_TERRACOTTA_PILLAR_SIDE_SLAB = HELPER.createBlock("lime_glazed_terracotta_pillar_side_slab", () -> new GlazedSlabBlock(GlazedTerracottaProperties("lime")));
	public static RegistryObject<Block> LIME_CENTERED_GLAZED_TERRACOTTA_SLAB = HELPER.createBlock("lime_centered_glazed_terracotta_slab", () -> new SlabBlock(GlazedTerracottaProperties("lime")));
	//LIGHT_BLUE
	public static RegistryObject<Block> LIGHT_BLUE_CENTERED_GLAZED_TERRACOTTA = HELPER.createBlock("light_blue_centered_glazed_terracotta", () -> new GlazedTerracottaBlock(GlazedTerracottaProperties("light_blue")));
	public static RegistryObject<Block> LIGHT_BLUE_GLAZED_TERRACOTTA_PILLAR = HELPER.createBlock("light_blue_glazed_terracotta_pillar", () -> new RotatedPillarBlock(GlazedTerracottaProperties("light_blue")));
	public static RegistryObject<Block> LIGHT_BLUE_GLAZED_TERRACOTTA_SLAB = HELPER.createBlock("light_blue_glazed_terracotta_slab", () -> new GlazedSlabBlock(GlazedTerracottaProperties("light_blue")));
	public static RegistryObject<Block> LIGHT_BLUE_GLAZED_TERRACOTTA_PILLAR_SLAB = HELPER.createBlock("light_blue_glazed_terracotta_pillar_slab", () -> new SlabBlock(GlazedTerracottaProperties("light_blue")));
	public static RegistryObject<Block> LIGHT_BLUE_GLAZED_TERRACOTTA_PILLAR_SIDE_SLAB = HELPER.createBlock("light_blue_glazed_terracotta_pillar_side_slab", () -> new GlazedSlabBlock(GlazedTerracottaProperties("light_blue")));
	public static RegistryObject<Block> LIGHT_BLUE_CENTERED_GLAZED_TERRACOTTA_SLAB = HELPER.createBlock("light_blue_centered_glazed_terracotta_slab", () -> new SlabBlock(GlazedTerracottaProperties("light_blue")));
	//GREEN
	public static RegistryObject<Block> GREEN_CENTERED_GLAZED_TERRACOTTA = HELPER.createBlock("green_centered_glazed_terracotta", () -> new GlazedTerracottaBlock(GlazedTerracottaProperties("green")));
	public static RegistryObject<Block> GREEN_GLAZED_TERRACOTTA_PILLAR = HELPER.createBlock("green_glazed_terracotta_pillar", () -> new RotatedPillarBlock(GlazedTerracottaProperties("green")));
	public static RegistryObject<Block> GREEN_GLAZED_TERRACOTTA_SLAB = HELPER.createBlock("green_glazed_terracotta_slab", () -> new GlazedSlabBlock(GlazedTerracottaProperties("green")));
	public static RegistryObject<Block> GREEN_GLAZED_TERRACOTTA_PILLAR_SLAB = HELPER.createBlock("green_glazed_terracotta_pillar_slab", () -> new SlabBlock(GlazedTerracottaProperties("green")));
	public static RegistryObject<Block> GREEN_GLAZED_TERRACOTTA_PILLAR_SIDE_SLAB = HELPER.createBlock("green_glazed_terracotta_pillar_side_slab", () -> new GlazedSlabBlock(GlazedTerracottaProperties("green")));
	public static RegistryObject<Block> GREEN_CENTERED_GLAZED_TERRACOTTA_SLAB = HELPER.createBlock("green_centered_glazed_terracotta_slab", () -> new SlabBlock(GlazedTerracottaProperties("green")));
	//GRAY
	public static RegistryObject<Block> GRAY_CENTERED_GLAZED_TERRACOTTA = HELPER.createBlock("gray_centered_glazed_terracotta", () -> new GlazedTerracottaBlock(GlazedTerracottaProperties("gray")));
	public static RegistryObject<Block> GRAY_GLAZED_TERRACOTTA_PILLAR = HELPER.createBlock("gray_glazed_terracotta_pillar", () -> new RotatedPillarBlock(GlazedTerracottaProperties("gray")));
	public static RegistryObject<Block> GRAY_GLAZED_TERRACOTTA_SLAB = HELPER.createBlock("gray_glazed_terracotta_slab", () -> new GlazedSlabBlock(GlazedTerracottaProperties("gray")));
	public static RegistryObject<Block> GRAY_GLAZED_TERRACOTTA_PILLAR_SLAB = HELPER.createBlock("gray_glazed_terracotta_pillar_slab", () -> new SlabBlock(GlazedTerracottaProperties("gray")));
	public static RegistryObject<Block> GRAY_GLAZED_TERRACOTTA_PILLAR_SIDE_SLAB = HELPER.createBlock("gray_glazed_terracotta_pillar_side_slab", () -> new GlazedSlabBlock(GlazedTerracottaProperties("gray")));
	public static RegistryObject<Block> GRAY_CENTERED_GLAZED_TERRACOTTA_SLAB = HELPER.createBlock("gray_centered_glazed_terracotta_slab", () -> new SlabBlock(GlazedTerracottaProperties("gray")));
	//CYAN
	public static RegistryObject<Block> CYAN_CENTERED_GLAZED_TERRACOTTA = HELPER.createBlock("cyan_centered_glazed_terracotta", () -> new GlazedTerracottaBlock(GlazedTerracottaProperties("cyan")));
	public static RegistryObject<Block> CYAN_GLAZED_TERRACOTTA_PILLAR = HELPER.createBlock("cyan_glazed_terracotta_pillar", () -> new RotatedPillarBlock(GlazedTerracottaProperties("cyan")));
	public static RegistryObject<Block> CYAN_GLAZED_TERRACOTTA_SLAB = HELPER.createBlock("cyan_glazed_terracotta_slab", () -> new GlazedSlabBlock(GlazedTerracottaProperties("cyan")));
	public static RegistryObject<Block> CYAN_GLAZED_TERRACOTTA_PILLAR_SLAB = HELPER.createBlock("cyan_glazed_terracotta_pillar_slab", () -> new SlabBlock(GlazedTerracottaProperties("cyan")));
	public static RegistryObject<Block> CYAN_GLAZED_TERRACOTTA_PILLAR_SIDE_SLAB = HELPER.createBlock("cyan_glazed_terracotta_pillar_side_slab", () -> new GlazedSlabBlock(GlazedTerracottaProperties("cyan")));
	public static RegistryObject<Block> CYAN_CENTERED_GLAZED_TERRACOTTA_SLAB = HELPER.createBlock("cyan_centered_glazed_terracotta_slab", () -> new SlabBlock(GlazedTerracottaProperties("cyan")));
	//BROWN
	public static RegistryObject<Block> BROWN_CENTERED_GLAZED_TERRACOTTA = HELPER.createBlock("brown_centered_glazed_terracotta", () -> new GlazedTerracottaBlock(GlazedTerracottaProperties("brown")));
	public static RegistryObject<Block> BROWN_GLAZED_TERRACOTTA_PILLAR = HELPER.createBlock("brown_glazed_terracotta_pillar", () -> new RotatedPillarBlock(GlazedTerracottaProperties("brown")));
	public static RegistryObject<Block> BROWN_GLAZED_TERRACOTTA_SLAB = HELPER.createBlock("brown_glazed_terracotta_slab", () -> new GlazedSlabBlock(GlazedTerracottaProperties("brown")));
	public static RegistryObject<Block> BROWN_GLAZED_TERRACOTTA_PILLAR_SLAB = HELPER.createBlock("brown_glazed_terracotta_pillar_slab", () -> new SlabBlock(GlazedTerracottaProperties("brown")));
	public static RegistryObject<Block> BROWN_GLAZED_TERRACOTTA_PILLAR_SIDE_SLAB = HELPER.createBlock("brown_glazed_terracotta_pillar_side_slab", () -> new GlazedSlabBlock(GlazedTerracottaProperties("brown")));
	public static RegistryObject<Block> BROWN_CENTERED_GLAZED_TERRACOTTA_SLAB = HELPER.createBlock("brown_centered_glazed_terracotta_slab", () -> new SlabBlock(GlazedTerracottaProperties("brown")));
	//BLUE
	public static RegistryObject<Block> BLUE_CENTERED_GLAZED_TERRACOTTA = HELPER.createBlock("blue_centered_glazed_terracotta", () -> new GlazedTerracottaBlock(GlazedTerracottaProperties("blue")));
	public static RegistryObject<Block> BLUE_GLAZED_TERRACOTTA_PILLAR = HELPER.createBlock("blue_glazed_terracotta_pillar", () -> new RotatedPillarBlock(GlazedTerracottaProperties("blue")));
	public static RegistryObject<Block> BLUE_GLAZED_TERRACOTTA_SLAB = HELPER.createBlock("blue_glazed_terracotta_slab", () -> new GlazedSlabBlock(GlazedTerracottaProperties("blue")));
	public static RegistryObject<Block> BLUE_GLAZED_TERRACOTTA_PILLAR_SLAB = HELPER.createBlock("blue_glazed_terracotta_pillar_slab", () -> new SlabBlock(GlazedTerracottaProperties("blue")));
	public static RegistryObject<Block> BLUE_GLAZED_TERRACOTTA_PILLAR_SIDE_SLAB = HELPER.createBlock("blue_glazed_terracotta_pillar_side_slab", () -> new GlazedSlabBlock(GlazedTerracottaProperties("blue")));
	public static RegistryObject<Block> BLUE_CENTERED_GLAZED_TERRACOTTA_SLAB = HELPER.createBlock("blue_centered_glazed_terracotta_slab", () -> new SlabBlock(GlazedTerracottaProperties("blue")));
	//YELLOW
	public static RegistryObject<Block> YELLOW_CENTERED_GLAZED_TERRACOTTA = HELPER.createBlock("yellow_centered_glazed_terracotta", () -> new GlazedTerracottaBlock(GlazedTerracottaProperties("yellow")));
	public static RegistryObject<Block> YELLOW_GLAZED_TERRACOTTA_PILLAR = HELPER.createBlock("yellow_glazed_terracotta_pillar", () -> new RotatedPillarBlock(GlazedTerracottaProperties("yellow")));
	public static RegistryObject<Block> YELLOW_GLAZED_TERRACOTTA_SLAB = HELPER.createBlock("yellow_glazed_terracotta_slab", () -> new GlazedSlabBlock(GlazedTerracottaProperties("yellow")));
	public static RegistryObject<Block> YELLOW_GLAZED_TERRACOTTA_PILLAR_SLAB = HELPER.createBlock("yellow_glazed_terracotta_pillar_slab", () -> new SlabBlock(GlazedTerracottaProperties("yellow")));
	public static RegistryObject<Block> YELLOW_GLAZED_TERRACOTTA_PILLAR_SIDE_SLAB = HELPER.createBlock("yellow_glazed_terracotta_pillar_side_slab", () -> new GlazedSlabBlock(GlazedTerracottaProperties("yellow")));
	public static RegistryObject<Block> YELLOW_CENTERED_GLAZED_TERRACOTTA_SLAB = HELPER.createBlock("yellow_centered_glazed_terracotta_slab", () -> new SlabBlock(GlazedTerracottaProperties("yellow")));
	//BLACK
	public static RegistryObject<Block> BLACK_CENTERED_GLAZED_TERRACOTTA = HELPER.createBlock("black_centered_glazed_terracotta", () -> new GlazedTerracottaBlock(GlazedTerracottaProperties("black")));
	public static RegistryObject<Block> BLACK_GLAZED_TERRACOTTA_PILLAR = HELPER.createBlock("black_glazed_terracotta_pillar", () -> new RotatedPillarBlock(GlazedTerracottaProperties("black")));
	public static RegistryObject<Block> BLACK_GLAZED_TERRACOTTA_SLAB = HELPER.createBlock("black_glazed_terracotta_slab", () -> new GlazedSlabBlock(GlazedTerracottaProperties("black")));
	public static RegistryObject<Block> BLACK_GLAZED_TERRACOTTA_PILLAR_SLAB = HELPER.createBlock("black_glazed_terracotta_pillar_slab", () -> new SlabBlock(GlazedTerracottaProperties("black")));
	public static RegistryObject<Block> BLACK_GLAZED_TERRACOTTA_PILLAR_SIDE_SLAB = HELPER.createBlock("black_glazed_terracotta_pillar_side_slab", () -> new GlazedSlabBlock(GlazedTerracottaProperties("black")));
	public static RegistryObject<Block> BLACK_CENTERED_GLAZED_TERRACOTTA_SLAB = HELPER.createBlock("black_centered_glazed_terracotta_slab", () -> new SlabBlock(GlazedTerracottaProperties("black")));
	//GLAZED
	public static RegistryObject<Block> CENTERED_GLAZED_TERRACOTTA = HELPER.createBlock("centered_glazed_terracotta", () -> new GlazedTerracottaBlock(GlazedTerracottaProperties(Blocks.TERRACOTTA.defaultMapColor().toString())));
	public static RegistryObject<Block> GLAZED_TERRACOTTA_PILLAR = HELPER.createBlock("glazed_terracotta_pillar", () -> new RotatedPillarBlock(GlazedTerracottaProperties(Blocks.TERRACOTTA.defaultMapColor().toString())));
	public static RegistryObject<Block> GLAZED_TERRACOTTA_SLAB = HELPER.createBlock("glazed_terracotta_slab", () -> new GlazedSlabBlock(GlazedTerracottaProperties(Blocks.TERRACOTTA.defaultMapColor().toString())));
	public static RegistryObject<Block> GLAZED_TERRACOTTA_PILLAR_SLAB = HELPER.createBlock("glazed_terracotta_pillar_slab", () -> new SlabBlock(GlazedTerracottaProperties(Blocks.TERRACOTTA.defaultMapColor().toString())));
	public static RegistryObject<Block> GLAZED_TERRACOTTA_PILLAR_SIDE_SLAB = HELPER.createBlock("glazed_terracotta_pillar_side_slab", () -> new GlazedSlabBlock(GlazedTerracottaProperties(Blocks.TERRACOTTA.defaultMapColor().toString())));
	public static RegistryObject<Block> CENTERED_GLAZED_TERRACOTTA_SLAB = HELPER.createBlock("centered_glazed_terracotta_slab", () -> new SlabBlock(GlazedTerracottaProperties(Blocks.TERRACOTTA.defaultMapColor().toString())));
	
    private static Block.Properties GlazedTerracottaProperties(String color) {
        return BlockBehaviour.Properties.copy(Blocks.STONE).mapColor(GlazedColor.getColor(color)).requiresCorrectToolForDrops().strength(1.4F).pushReaction(PushReaction.PUSH_ONLY);
    }
    
	public static void register(IEventBus modEventBus) {
		
		//Yes, I'm aware there's hardly anything in here.
		
        GlazedResymmetry.LOGGER.log(Level.INFO, "ModBlocks: Blocks registered");
        //Clayworks compat
        if (ModList.get().isLoaded("clayworks")) {
        	GlazedResymmetry.LOGGER.log(Level.INFO, "ModBlocks: Clayworks Compat registered");
        }
        
        Registration.BLOCKS.register(modEventBus);
    }
	
	public static void setupTabEditors() {
		CreativeModeTabContentsPopulator.mod(Registration.MOD_ID)
			.tab(ModCreativeTab.TAB_KEY.getKey())
			//WHITE
			.addItems(WHITE_CENTERED_GLAZED_TERRACOTTA,
					WHITE_GLAZED_TERRACOTTA_PILLAR,
					WHITE_GLAZED_TERRACOTTA_SLAB,
					WHITE_GLAZED_TERRACOTTA_PILLAR_SLAB,
					WHITE_GLAZED_TERRACOTTA_PILLAR_SIDE_SLAB,
					WHITE_CENTERED_GLAZED_TERRACOTTA_SLAB)
			//LIGHT_GRAY
			.addItems(LIGHT_GRAY_CENTERED_GLAZED_TERRACOTTA,
					LIGHT_GRAY_GLAZED_TERRACOTTA_PILLAR,
					LIGHT_GRAY_GLAZED_TERRACOTTA_SLAB,
					LIGHT_GRAY_GLAZED_TERRACOTTA_PILLAR_SLAB,
					LIGHT_GRAY_GLAZED_TERRACOTTA_PILLAR_SIDE_SLAB,
					LIGHT_GRAY_CENTERED_GLAZED_TERRACOTTA_SLAB)
			//RED
			.addItems(RED_CENTERED_GLAZED_TERRACOTTA,
					RED_GLAZED_TERRACOTTA_PILLAR,
					RED_GLAZED_TERRACOTTA_SLAB,
					RED_GLAZED_TERRACOTTA_PILLAR_SLAB,
					RED_GLAZED_TERRACOTTA_PILLAR_SIDE_SLAB,
					RED_CENTERED_GLAZED_TERRACOTTA_SLAB)
			//PURPLE
			.addItems(PURPLE_CENTERED_GLAZED_TERRACOTTA,
					PURPLE_GLAZED_TERRACOTTA_PILLAR,
					PURPLE_GLAZED_TERRACOTTA_SLAB,
					PURPLE_GLAZED_TERRACOTTA_PILLAR_SLAB,
					PURPLE_GLAZED_TERRACOTTA_PILLAR_SIDE_SLAB,
					PURPLE_CENTERED_GLAZED_TERRACOTTA_SLAB)
			//PINK
			.addItems(PINK_CENTERED_GLAZED_TERRACOTTA,
					PINK_GLAZED_TERRACOTTA_PILLAR,
					PINK_GLAZED_TERRACOTTA_SLAB,
					PINK_GLAZED_TERRACOTTA_PILLAR_SLAB,
					PINK_GLAZED_TERRACOTTA_PILLAR_SIDE_SLAB,
					PINK_CENTERED_GLAZED_TERRACOTTA_SLAB)
			//ORANGE
			.addItems(ORANGE_CENTERED_GLAZED_TERRACOTTA,
					ORANGE_GLAZED_TERRACOTTA_PILLAR,
					ORANGE_GLAZED_TERRACOTTA_SLAB,
					ORANGE_GLAZED_TERRACOTTA_PILLAR_SLAB,
					ORANGE_GLAZED_TERRACOTTA_PILLAR_SIDE_SLAB,
					ORANGE_CENTERED_GLAZED_TERRACOTTA_SLAB)
			//MAGENTA
			.addItems(MAGENTA_CENTERED_GLAZED_TERRACOTTA,
					MAGENTA_GLAZED_TERRACOTTA_PILLAR,
					MAGENTA_GLAZED_TERRACOTTA_SLAB,
					MAGENTA_GLAZED_TERRACOTTA_PILLAR_SLAB,
					MAGENTA_GLAZED_TERRACOTTA_PILLAR_SIDE_SLAB,
					MAGENTA_CENTERED_GLAZED_TERRACOTTA_SLAB)
			//LIME
			.addItems(LIME_CENTERED_GLAZED_TERRACOTTA,
					LIME_GLAZED_TERRACOTTA_PILLAR,
					LIME_GLAZED_TERRACOTTA_SLAB,
					LIME_GLAZED_TERRACOTTA_PILLAR_SLAB,
					LIME_GLAZED_TERRACOTTA_PILLAR_SIDE_SLAB,
					LIME_CENTERED_GLAZED_TERRACOTTA_SLAB)
			//LIGHT_BLUE
			.addItems(LIGHT_BLUE_CENTERED_GLAZED_TERRACOTTA,
					LIGHT_BLUE_GLAZED_TERRACOTTA_PILLAR,
					LIGHT_BLUE_GLAZED_TERRACOTTA_SLAB,
					LIGHT_BLUE_GLAZED_TERRACOTTA_PILLAR_SLAB,
					LIGHT_BLUE_GLAZED_TERRACOTTA_PILLAR_SIDE_SLAB,
					LIGHT_BLUE_CENTERED_GLAZED_TERRACOTTA_SLAB)
			//GREEN
			.addItems(GREEN_CENTERED_GLAZED_TERRACOTTA,
					GREEN_GLAZED_TERRACOTTA_PILLAR,
					GREEN_GLAZED_TERRACOTTA_SLAB,
					GREEN_GLAZED_TERRACOTTA_PILLAR_SLAB,
					GREEN_GLAZED_TERRACOTTA_PILLAR_SIDE_SLAB,
					GREEN_CENTERED_GLAZED_TERRACOTTA_SLAB)
			//GRAY
			.addItems(GRAY_CENTERED_GLAZED_TERRACOTTA,
					GRAY_GLAZED_TERRACOTTA_PILLAR,
					GRAY_GLAZED_TERRACOTTA_SLAB,
					GRAY_GLAZED_TERRACOTTA_PILLAR_SLAB,
					GRAY_GLAZED_TERRACOTTA_PILLAR_SIDE_SLAB,
					GRAY_CENTERED_GLAZED_TERRACOTTA_SLAB)
			//CYAN
			.addItems(CYAN_CENTERED_GLAZED_TERRACOTTA,
					CYAN_GLAZED_TERRACOTTA_PILLAR,
					CYAN_GLAZED_TERRACOTTA_SLAB,
					CYAN_GLAZED_TERRACOTTA_PILLAR_SLAB,
					CYAN_GLAZED_TERRACOTTA_PILLAR_SIDE_SLAB,
					CYAN_CENTERED_GLAZED_TERRACOTTA_SLAB)
			//BROWN
			.addItems(BROWN_CENTERED_GLAZED_TERRACOTTA,
					BROWN_GLAZED_TERRACOTTA_PILLAR,
					BROWN_GLAZED_TERRACOTTA_SLAB,
					BROWN_GLAZED_TERRACOTTA_PILLAR_SLAB,
					BROWN_GLAZED_TERRACOTTA_PILLAR_SIDE_SLAB,
					BROWN_CENTERED_GLAZED_TERRACOTTA_SLAB)
			//BLUE
			.addItems(BLUE_CENTERED_GLAZED_TERRACOTTA,
					BLUE_GLAZED_TERRACOTTA_PILLAR,
					BLUE_GLAZED_TERRACOTTA_SLAB,
					BLUE_GLAZED_TERRACOTTA_PILLAR_SLAB,
					BLUE_GLAZED_TERRACOTTA_PILLAR_SIDE_SLAB,
					BLUE_CENTERED_GLAZED_TERRACOTTA_SLAB)
			//YELLOW
			.addItems(YELLOW_CENTERED_GLAZED_TERRACOTTA,
					YELLOW_GLAZED_TERRACOTTA_PILLAR,
					YELLOW_GLAZED_TERRACOTTA_SLAB,
					YELLOW_GLAZED_TERRACOTTA_PILLAR_SLAB,
					YELLOW_GLAZED_TERRACOTTA_PILLAR_SIDE_SLAB,
					YELLOW_CENTERED_GLAZED_TERRACOTTA_SLAB)
			//BLACK
			.addItems(BLACK_CENTERED_GLAZED_TERRACOTTA,
					BLACK_GLAZED_TERRACOTTA_PILLAR,
					BLACK_GLAZED_TERRACOTTA_SLAB,
					BLACK_GLAZED_TERRACOTTA_PILLAR_SLAB,
					BLACK_GLAZED_TERRACOTTA_PILLAR_SIDE_SLAB,
					BLACK_CENTERED_GLAZED_TERRACOTTA_SLAB)
			//GLAZED
			.predicate(event -> event.getTabKey() == ModCreativeTab.TAB_KEY.getKey() && ModList.get().isLoaded("clayworks"))
			.addItems(CENTERED_GLAZED_TERRACOTTA,
					GLAZED_TERRACOTTA_PILLAR,
					GLAZED_TERRACOTTA_SLAB,
					GLAZED_TERRACOTTA_PILLAR_SLAB,
					GLAZED_TERRACOTTA_PILLAR_SIDE_SLAB,
					CENTERED_GLAZED_TERRACOTTA_SLAB);
	}
}
