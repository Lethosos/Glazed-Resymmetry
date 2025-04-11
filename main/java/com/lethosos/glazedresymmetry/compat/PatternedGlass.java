package com.lethosos.glazedresymmetry.compat;

import org.apache.logging.log4j.Level;

import com.lethosos.glazedresymmetry.GlazedResymmetry;
import com.lethosos.glazedresymmetry.Registration;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.StainedGlassPaneBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;

//Currently this is off because Patterned Glass is not updated yet 
@SuppressWarnings("unused")
public class PatternedGlass {
	/*
	public static final BlockSubRegistryHelper HELPER = Registration.REGISTRY_HELPER.getBlockSubHelper();
	
	public static RegistryObject<Block> WHITE_CENTERED_GLAZED_GLASS;
	public static RegistryObject<Block> WHITE_GLAZED_GLASS_PILLAR;
	public static RegistryObject<Block> WHITE_CENTERED_GLAZED_GLASS_PANE;
	public static RegistryObject<Block> WHITE_GLAZED_GLASS_PANE_PILLAR;
	public static RegistryObject<Block> WHITE_GLAZED_GLASS_PANE_PILLAR_TOP;
	public static RegistryObject<Block> WHITE_GLAZED_GLASS_PANE_SIDE_PILLAR;
	
	public static RegistryObject<Block> LIGHT_GRAY_CENTERED_GLAZED_GLASS;
	public static RegistryObject<Block> LIGHT_GRAY_GLAZED_GLASS_PILLAR;
	public static RegistryObject<Block> LIGHT_GRAY_CENTERED_GLAZED_GLASS_PANE;
	public static RegistryObject<Block> LIGHT_GRAY_GLAZED_GLASS_PANE_PILLAR;
	public static RegistryObject<Block> LIGHT_GRAY_GLAZED_GLASS_PANE_PILLAR_TOP;
	public static RegistryObject<Block> LIGHT_GRAY_GLAZED_GLASS_PANE_SIDE_PILLAR;

	public static RegistryObject<Block> GRAY_CENTERED_GLAZED_GLASS;
	public static RegistryObject<Block> GRAY_GLAZED_GLASS_PILLAR;
	public static RegistryObject<Block> GRAY_CENTERED_GLAZED_GLASS_PANE;
	public static RegistryObject<Block> GRAY_GLAZED_GLASS_PANE_PILLAR;
	public static RegistryObject<Block> GRAY_GLAZED_GLASS_PANE_PILLAR_TOP;
	public static RegistryObject<Block> GRAY_GLAZED_GLASS_PANE_SIDE_PILLAR;

	public static RegistryObject<Block> BLACK_CENTERED_GLAZED_GLASS;
	public static RegistryObject<Block> BLACK_GLAZED_GLASS_PILLAR;
	public static RegistryObject<Block> BLACK_CENTERED_GLAZED_GLASS_PANE;
	public static RegistryObject<Block> BLACK_GLAZED_GLASS_PANE_PILLAR;
	public static RegistryObject<Block> BLACK_GLAZED_GLASS_PANE_PILLAR_TOP;
	public static RegistryObject<Block> BLACK_GLAZED_GLASS_PANE_SIDE_PILLAR;

	public static RegistryObject<Block> BROWN_CENTERED_GLAZED_GLASS;
	public static RegistryObject<Block> BROWN_GLAZED_GLASS_PILLAR;
	public static RegistryObject<Block> BROWN_CENTERED_GLAZED_GLASS_PANE;
	public static RegistryObject<Block> BROWN_GLAZED_GLASS_PANE_PILLAR;
	public static RegistryObject<Block> BROWN_GLAZED_GLASS_PANE_PILLAR_TOP;
	public static RegistryObject<Block> BROWN_GLAZED_GLASS_PANE_SIDE_PILLAR;

	public static RegistryObject<Block> RED_CENTERED_GLAZED_GLASS;
	public static RegistryObject<Block> RED_GLAZED_GLASS_PILLAR;
	public static RegistryObject<Block> RED_CENTERED_GLAZED_GLASS_PANE;
	public static RegistryObject<Block> RED_GLAZED_GLASS_PANE_PILLAR;
	public static RegistryObject<Block> RED_GLAZED_GLASS_PANE_PILLAR_TOP;
	public static RegistryObject<Block> RED_GLAZED_GLASS_PANE_SIDE_PILLAR;

	public static RegistryObject<Block> ORANGE_CENTERED_GLAZED_GLASS;
	public static RegistryObject<Block> ORANGE_GLAZED_GLASS_PILLAR;
	public static RegistryObject<Block> ORANGE_CENTERED_GLAZED_GLASS_PANE;
	public static RegistryObject<Block> ORANGE_GLAZED_GLASS_PANE_PILLAR;
	public static RegistryObject<Block> ORANGE_GLAZED_GLASS_PANE_PILLAR_TOP;
	public static RegistryObject<Block> ORANGE_GLAZED_GLASS_PANE_SIDE_PILLAR;

	public static RegistryObject<Block> YELLOW_CENTERED_GLAZED_GLASS;
	public static RegistryObject<Block> YELLOW_GLAZED_GLASS_PILLAR;
	public static RegistryObject<Block> YELLOW_CENTERED_GLAZED_GLASS_PANE;
	public static RegistryObject<Block> YELLOW_GLAZED_GLASS_PANE_PILLAR;
	public static RegistryObject<Block> YELLOW_GLAZED_GLASS_PANE_PILLAR_TOP;
	public static RegistryObject<Block> YELLOW_GLAZED_GLASS_PANE_SIDE_PILLAR;

	public static RegistryObject<Block> LIME_CENTERED_GLAZED_GLASS;
	public static RegistryObject<Block> LIME_GLAZED_GLASS_PILLAR;
	public static RegistryObject<Block> LIME_CENTERED_GLAZED_GLASS_PANE;
	public static RegistryObject<Block> LIME_GLAZED_GLASS_PANE_PILLAR;
	public static RegistryObject<Block> LIME_GLAZED_GLASS_PANE_PILLAR_TOP;
	public static RegistryObject<Block> LIME_GLAZED_GLASS_PANE_SIDE_PILLAR;

	public static RegistryObject<Block> GREEN_CENTERED_GLAZED_GLASS;
	public static RegistryObject<Block> GREEN_GLAZED_GLASS_PILLAR;
	public static RegistryObject<Block> GREEN_CENTERED_GLAZED_GLASS_PANE;
	public static RegistryObject<Block> GREEN_GLAZED_GLASS_PANE_PILLAR;
	public static RegistryObject<Block> GREEN_GLAZED_GLASS_PANE_PILLAR_TOP;
	public static RegistryObject<Block> GREEN_GLAZED_GLASS_PANE_SIDE_PILLAR;

	public static RegistryObject<Block> CYAN_CENTERED_GLAZED_GLASS;
	public static RegistryObject<Block> CYAN_GLAZED_GLASS_PILLAR;
	public static RegistryObject<Block> CYAN_CENTERED_GLAZED_GLASS_PANE;
	public static RegistryObject<Block> CYAN_GLAZED_GLASS_PANE_PILLAR;
	public static RegistryObject<Block> CYAN_GLAZED_GLASS_PANE_PILLAR_TOP;
	public static RegistryObject<Block> CYAN_GLAZED_GLASS_PANE_SIDE_PILLAR;

	public static RegistryObject<Block> LIGHT_BLUE_CENTERED_GLAZED_GLASS;
	public static RegistryObject<Block> LIGHT_BLUE_GLAZED_GLASS_PILLAR;
	public static RegistryObject<Block> LIGHT_BLUE_CENTERED_GLAZED_GLASS_PANE;
	public static RegistryObject<Block> LIGHT_BLUE_GLAZED_GLASS_PANE_PILLAR;
	public static RegistryObject<Block> LIGHT_BLUE_GLAZED_GLASS_PANE_PILLAR_TOP;
	public static RegistryObject<Block> LIGHT_BLUE_GLAZED_GLASS_PANE_SIDE_PILLAR;

	public static RegistryObject<Block> BLUE_CENTERED_GLAZED_GLASS;
	public static RegistryObject<Block> BLUE_GLAZED_GLASS_PILLAR;
	public static RegistryObject<Block> BLUE_CENTERED_GLAZED_GLASS_PANE;
	public static RegistryObject<Block> BLUE_GLAZED_GLASS_PANE_PILLAR;
	public static RegistryObject<Block> BLUE_GLAZED_GLASS_PANE_PILLAR_TOP;
	public static RegistryObject<Block> BLUE_GLAZED_GLASS_PANE_SIDE_PILLAR;

	public static RegistryObject<Block> PURPLE_CENTERED_GLAZED_GLASS;
	public static RegistryObject<Block> PURPLE_GLAZED_GLASS_PILLAR;
	public static RegistryObject<Block> PURPLE_CENTERED_GLAZED_GLASS_PANE;
	public static RegistryObject<Block> PURPLE_GLAZED_GLASS_PANE_PILLAR;
	public static RegistryObject<Block> PURPLE_GLAZED_GLASS_PANE_PILLAR_TOP;
	public static RegistryObject<Block> PURPLE_GLAZED_GLASS_PANE_SIDE_PILLAR;

	public static RegistryObject<Block> MAGENTA_CENTERED_GLAZED_GLASS;
	public static RegistryObject<Block> MAGENTA_GLAZED_GLASS_PILLAR;
	public static RegistryObject<Block> MAGENTA_CENTERED_GLAZED_GLASS_PANE;
	public static RegistryObject<Block> MAGENTA_GLAZED_GLASS_PANE_PILLAR;
	public static RegistryObject<Block> MAGENTA_GLAZED_GLASS_PANE_PILLAR_TOP;
	public static RegistryObject<Block> MAGENTA_GLAZED_GLASS_PANE_SIDE_PILLAR;

	public static RegistryObject<Block> PINK_CENTERED_GLAZED_GLASS;
	public static RegistryObject<Block> PINK_GLAZED_GLASS_PILLAR;
	public static RegistryObject<Block> PINK_CENTERED_GLAZED_GLASS_PANE;
	public static RegistryObject<Block> PINK_GLAZED_GLASS_PANE_PILLAR;
	public static RegistryObject<Block> PINK_GLAZED_GLASS_PANE_PILLAR_TOP;
	public static RegistryObject<Block> PINK_GLAZED_GLASS_PANE_SIDE_PILLAR;
	
	public static Block.Properties GlazedGlassProperties(String color) {
        return BlockBehaviour.Properties.copy(Blocks.GLASS).mapColor(GlazedColor.getColor(color)).strength(0.3F).noOcclusion().sound(SoundType.GLASS)
        		.isValidSpawn((state, getter, pos, entity) -> false).isRedstoneConductor((state, getter, pos) -> false)
        		.isSuffocating((state, getter, pos) -> false).isViewBlocking((state, getter, pos) -> false);
    }
	/**
	 * Sets up the properties and mapColor of the glazed glass block for you. Requires just the color code you use for maps from your dye code.
	 * Use only if you're also adding compat for Patterned Glass mod as well.
	 * 
	 * @param DyeColor color
	 * @return BlockBehavior.Properties for glazed glass in general.
	 */
	/*
	public static Block.Properties GlazedGlassProperties(DyeColor dye) {
        return BlockBehaviour.Properties.copy(Blocks.GLASS).mapColor(dye).strength(0.3F).noOcclusion().sound(SoundType.GLASS)
        		.isValidSpawn((state, getter, pos, entity) -> false).isRedstoneConductor((state, getter, pos) -> false)
        		.isSuffocating((state, getter, pos) -> false).isViewBlocking((state, getter, pos) -> false);
    }
	
	private static String temp = "white";
	//Patterned Glass compat
	public static void register() {
		//WHITE
		temp = "white";
		WHITE_CENTERED_GLAZED_GLASS = HELPER.createBlock(temp + "_centered_glazed_glass", () -> new GlazedGlassBlock(GlazedColor.getColor(temp)));
		WHITE_GLAZED_GLASS_PILLAR = HELPER.createBlock(temp + "_glazed_glass_pillar", () -> new GlazedGlassPillar(GlazedColor.getColor(temp)));
       	WHITE_CENTERED_GLAZED_GLASS_PANE = HELPER.createBlock(temp + "_centered_glazed_glass_pane", () -> new StainedGlassPaneBlock(GlazedColor.getColor(temp), GlazedGlassProperties(temp)));
       	WHITE_GLAZED_GLASS_PANE_PILLAR = HELPER.createBlock(temp + "_glazed_glass_pane_pillar", () -> new StainedGlassPaneBlock(GlazedColor.getColor(temp), GlazedGlassProperties(temp)));
       	WHITE_GLAZED_GLASS_PANE_PILLAR_TOP = HELPER.createBlock(temp + "_glazed_glass_pane_pillar_top", () -> new StainedGlassPaneBlock(GlazedColor.getColor(temp), GlazedGlassProperties(temp)));
       	WHITE_GLAZED_GLASS_PANE_SIDE_PILLAR = HELPER.createBlock(temp + "_glazed_glass_pane_side_pillar", () -> new StainedGlassPaneBlock(GlazedColor.getColor(temp), GlazedGlassProperties(temp)));
       	//LIGHT GRAY
       	temp = "light_gray";
       	LIGHT_GRAY_CENTERED_GLAZED_GLASS = HELPER.createBlock(temp + "_centered_glazed_glass", () -> new GlazedGlassBlock(GlazedColor.getColor(temp)));
       	LIGHT_GRAY_GLAZED_GLASS_PILLAR = HELPER.createBlock(temp + "_glazed_glass_pillar", () -> new GlazedGlassPillar(GlazedColor.getColor(temp)));
       	LIGHT_GRAY_CENTERED_GLAZED_GLASS_PANE = HELPER.createBlock(temp + "_centered_glazed_glass_pane", () -> new StainedGlassPaneBlock(GlazedColor.getColor(temp), GlazedGlassProperties(temp)));
       	LIGHT_GRAY_GLAZED_GLASS_PANE_PILLAR = HELPER.createBlock(temp + "_glazed_glass_pane_pillar", () -> new StainedGlassPaneBlock(GlazedColor.getColor(temp), GlazedGlassProperties(temp)));
       	LIGHT_GRAY_GLAZED_GLASS_PANE_PILLAR_TOP = HELPER.createBlock(temp + "_glazed_glass_pane_pillar_top", () -> new StainedGlassPaneBlock(GlazedColor.getColor(temp), GlazedGlassProperties(temp)));
       	LIGHT_GRAY_GLAZED_GLASS_PANE_SIDE_PILLAR = HELPER.createBlock(temp + "_glazed_glass_pane_side_pillar", () -> new StainedGlassPaneBlock(GlazedColor.getColor(temp), GlazedGlassProperties(temp)));
       	//GRAY
       	temp = "gray";
       	GRAY_CENTERED_GLAZED_GLASS = HELPER.createBlock(temp + "_centered_glazed_glass", () -> new GlazedGlassBlock(GlazedColor.getColor(temp)));
       	GRAY_GLAZED_GLASS_PILLAR = HELPER.createBlock(temp + "_glazed_glass_pillar", () -> new GlazedGlassPillar(GlazedColor.getColor(temp)));
       	GRAY_CENTERED_GLAZED_GLASS_PANE = HELPER.createBlock(temp + "_centered_glazed_glass_pane", () -> new StainedGlassPaneBlock(GlazedColor.getColor(temp), GlazedGlassProperties(temp)));
       	GRAY_GLAZED_GLASS_PANE_PILLAR = HELPER.createBlock(temp + "_glazed_glass_pane_pillar", () -> new StainedGlassPaneBlock(GlazedColor.getColor(temp), GlazedGlassProperties(temp)));
       	GRAY_GLAZED_GLASS_PANE_PILLAR_TOP = HELPER.createBlock(temp + "_glazed_glass_pane_pillar_top", () -> new StainedGlassPaneBlock(GlazedColor.getColor(temp), GlazedGlassProperties(temp)));
       	GRAY_GLAZED_GLASS_PANE_SIDE_PILLAR = HELPER.createBlock(temp + "_glazed_glass_pane_side_pillar", () -> new StainedGlassPaneBlock(GlazedColor.getColor(temp), GlazedGlassProperties(temp)));
       	//BLACK
       	temp = "black";
       	BLACK_CENTERED_GLAZED_GLASS = HELPER.createBlock(temp + "_centered_glazed_glass", () -> new GlazedGlassBlock(GlazedColor.getColor(temp)));
       	BLACK_GLAZED_GLASS_PILLAR = HELPER.createBlock(temp + "_glazed_glass_pillar", () -> new GlazedGlassPillar(GlazedColor.getColor(temp)));
       	BLACK_CENTERED_GLAZED_GLASS_PANE = HELPER.createBlock(temp + "_centered_glazed_glass_pane", () -> new StainedGlassPaneBlock(GlazedColor.getColor(temp), GlazedGlassProperties(temp)));
       	BLACK_GLAZED_GLASS_PANE_PILLAR = HELPER.createBlock(temp + "_glazed_glass_pane_pillar", () -> new StainedGlassPaneBlock(GlazedColor.getColor(temp), GlazedGlassProperties(temp)));
       	BLACK_GLAZED_GLASS_PANE_PILLAR_TOP = HELPER.createBlock(temp + "_glazed_glass_pane_pillar_top", () -> new StainedGlassPaneBlock(GlazedColor.getColor(temp), GlazedGlassProperties(temp)));
       	BLACK_GLAZED_GLASS_PANE_SIDE_PILLAR = HELPER.createBlock(temp + "_glazed_glass_pane_side_pillar", () -> new StainedGlassPaneBlock(GlazedColor.getColor(temp), GlazedGlassProperties(temp)));
       	//BROWN
       	temp = "brown";
       	BROWN_CENTERED_GLAZED_GLASS = HELPER.createBlock(temp + "_centered_glazed_glass", () -> new GlazedGlassBlock(GlazedColor.getColor(temp)));
       	BROWN_GLAZED_GLASS_PILLAR = HELPER.createBlock(temp + "_glazed_glass_pillar", () -> new GlazedGlassPillar(GlazedColor.getColor(temp)));
       	BROWN_CENTERED_GLAZED_GLASS_PANE = HELPER.createBlock(temp + "_centered_glazed_glass_pane", () -> new StainedGlassPaneBlock(GlazedColor.getColor(temp), GlazedGlassProperties(temp)));
       	BROWN_GLAZED_GLASS_PANE_PILLAR = HELPER.createBlock(temp + "_glazed_glass_pane_pillar", () -> new StainedGlassPaneBlock(GlazedColor.getColor(temp), GlazedGlassProperties(temp)));
       	BROWN_GLAZED_GLASS_PANE_PILLAR_TOP = HELPER.createBlock(temp + "_glazed_glass_pane_pillar_top", () -> new StainedGlassPaneBlock(GlazedColor.getColor(temp), GlazedGlassProperties(temp)));
       	BROWN_GLAZED_GLASS_PANE_SIDE_PILLAR = HELPER.createBlock(temp + "_glazed_glass_pane_side_pillar", () -> new StainedGlassPaneBlock(GlazedColor.getColor(temp), GlazedGlassProperties(temp)));
       	//RED
       	temp = "red";
       	RED_CENTERED_GLAZED_GLASS = HELPER.createBlock(temp + "_centered_glazed_glass", () -> new GlazedGlassBlock(GlazedColor.getColor(temp)));
       	RED_GLAZED_GLASS_PILLAR = HELPER.createBlock(temp + "_glazed_glass_pillar", () -> new GlazedGlassPillar(GlazedColor.getColor(temp)));
       	RED_CENTERED_GLAZED_GLASS_PANE = HELPER.createBlock(temp + "_centered_glazed_glass_pane", () -> new StainedGlassPaneBlock(GlazedColor.getColor(temp), GlazedGlassProperties(temp)));
       	RED_GLAZED_GLASS_PANE_PILLAR = HELPER.createBlock(temp + "_glazed_glass_pane_pillar", () -> new StainedGlassPaneBlock(GlazedColor.getColor(temp), GlazedGlassProperties(temp)));
       	RED_GLAZED_GLASS_PANE_PILLAR_TOP = HELPER.createBlock(temp + "_glazed_glass_pane_pillar_top", () -> new StainedGlassPaneBlock(GlazedColor.getColor(temp), GlazedGlassProperties(temp)));
       	RED_GLAZED_GLASS_PANE_SIDE_PILLAR = HELPER.createBlock(temp + "_glazed_glass_pane_side_pillar", () -> new StainedGlassPaneBlock(GlazedColor.getColor(temp), GlazedGlassProperties(temp)));
       	//ORANGE
       	temp = "orange";
       	ORANGE_CENTERED_GLAZED_GLASS = HELPER.createBlock(temp + "_centered_glazed_glass", () -> new GlazedGlassBlock(GlazedColor.getColor(temp)));
       	ORANGE_GLAZED_GLASS_PILLAR = HELPER.createBlock(temp + "_glazed_glass_pillar", () -> new GlazedGlassPillar(GlazedColor.getColor(temp)));
       	ORANGE_CENTERED_GLAZED_GLASS_PANE = HELPER.createBlock(temp + "_centered_glazed_glass_pane", () -> new StainedGlassPaneBlock(GlazedColor.getColor(temp), GlazedGlassProperties(temp)));
       	ORANGE_GLAZED_GLASS_PANE_PILLAR = HELPER.createBlock(temp + "_glazed_glass_pane_pillar", () -> new StainedGlassPaneBlock(GlazedColor.getColor(temp), GlazedGlassProperties(temp)));
       	ORANGE_GLAZED_GLASS_PANE_PILLAR_TOP = HELPER.createBlock(temp + "_glazed_glass_pane_pillar_top", () -> new StainedGlassPaneBlock(GlazedColor.getColor(temp), GlazedGlassProperties(temp)));
       	ORANGE_GLAZED_GLASS_PANE_SIDE_PILLAR = HELPER.createBlock(temp + "_glazed_glass_pane_side_pillar", () -> new StainedGlassPaneBlock(GlazedColor.getColor(temp), GlazedGlassProperties(temp)));
       	//YELLOW
       	temp = "yellow";
       	YELLOW_CENTERED_GLAZED_GLASS = HELPER.createBlock(temp + "_centered_glazed_glass", () -> new GlazedGlassBlock(GlazedColor.getColor(temp)));
       	YELLOW_GLAZED_GLASS_PILLAR = HELPER.createBlock(temp + "_glazed_glass_pillar", () -> new GlazedGlassPillar(GlazedColor.getColor(temp)));
       	YELLOW_CENTERED_GLAZED_GLASS_PANE = HELPER.createBlock(temp + "_centered_glazed_glass_pane", () -> new StainedGlassPaneBlock(GlazedColor.getColor(temp), GlazedGlassProperties(temp)));
       	YELLOW_GLAZED_GLASS_PANE_PILLAR = HELPER.createBlock(temp + "_glazed_glass_pane_pillar", () -> new StainedGlassPaneBlock(GlazedColor.getColor(temp), GlazedGlassProperties(temp)));
       	YELLOW_GLAZED_GLASS_PANE_PILLAR_TOP = HELPER.createBlock(temp + "_glazed_glass_pane_pillar_top", () -> new StainedGlassPaneBlock(GlazedColor.getColor(temp), GlazedGlassProperties(temp)));
       	YELLOW_GLAZED_GLASS_PANE_SIDE_PILLAR = HELPER.createBlock(temp + "_glazed_glass_pane_side_pillar", () -> new StainedGlassPaneBlock(GlazedColor.getColor(temp), GlazedGlassProperties(temp)));
       	//LIME
       	temp = "lime";
       	LIME_CENTERED_GLAZED_GLASS = HELPER.createBlock(temp + "_centered_glazed_glass", () -> new GlazedGlassBlock(GlazedColor.getColor(temp)));
       	LIME_GLAZED_GLASS_PILLAR = HELPER.createBlock(temp + "_glazed_glass_pillar", () -> new GlazedGlassPillar(GlazedColor.getColor(temp)));
       	LIME_CENTERED_GLAZED_GLASS_PANE = HELPER.createBlock(temp + "_centered_glazed_glass_pane", () -> new StainedGlassPaneBlock(GlazedColor.getColor(temp), GlazedGlassProperties(temp)));
       	LIME_GLAZED_GLASS_PANE_PILLAR = HELPER.createBlock(temp + "_glazed_glass_pane_pillar", () -> new StainedGlassPaneBlock(GlazedColor.getColor(temp), GlazedGlassProperties(temp)));
       	LIME_GLAZED_GLASS_PANE_PILLAR_TOP = HELPER.createBlock(temp + "_glazed_glass_pane_pillar_top", () -> new StainedGlassPaneBlock(GlazedColor.getColor(temp), GlazedGlassProperties(temp)));
       	LIME_GLAZED_GLASS_PANE_SIDE_PILLAR = HELPER.createBlock(temp + "_glazed_glass_pane_side_pillar", () -> new StainedGlassPaneBlock(GlazedColor.getColor(temp), GlazedGlassProperties(temp)));
       	//GREEN
       	temp = "green";
       	GREEN_CENTERED_GLAZED_GLASS = HELPER.createBlock(temp + "_centered_glazed_glass", () -> new GlazedGlassBlock(GlazedColor.getColor(temp)));
       	GREEN_GLAZED_GLASS_PILLAR = HELPER.createBlock(temp + "_glazed_glass_pillar", () -> new GlazedGlassPillar(GlazedColor.getColor(temp)));
       	GREEN_CENTERED_GLAZED_GLASS_PANE = HELPER.createBlock(temp + "_centered_glazed_glass_pane", () -> new StainedGlassPaneBlock(GlazedColor.getColor(temp), GlazedGlassProperties(temp)));
       	GREEN_GLAZED_GLASS_PANE_PILLAR = HELPER.createBlock(temp + "_glazed_glass_pane_pillar", () -> new StainedGlassPaneBlock(GlazedColor.getColor(temp), GlazedGlassProperties(temp)));
       	GREEN_GLAZED_GLASS_PANE_PILLAR_TOP = HELPER.createBlock(temp + "_glazed_glass_pane_pillar_top", () -> new StainedGlassPaneBlock(GlazedColor.getColor(temp), GlazedGlassProperties(temp)));
       	GREEN_GLAZED_GLASS_PANE_SIDE_PILLAR = HELPER.createBlock(temp + "_glazed_glass_pane_side_pillar", () -> new StainedGlassPaneBlock(GlazedColor.getColor(temp), GlazedGlassProperties(temp)));
       	//CYAN
       	temp = "cyan";
       	CYAN_CENTERED_GLAZED_GLASS = HELPER.createBlock(temp + "_centered_glazed_glass", () -> new GlazedGlassBlock(GlazedColor.getColor(temp)));
       	CYAN_GLAZED_GLASS_PILLAR = HELPER.createBlock(temp + "_glazed_glass_pillar", () -> new GlazedGlassPillar(GlazedColor.getColor(temp)));
       	CYAN_CENTERED_GLAZED_GLASS_PANE = HELPER.createBlock(temp + "_centered_glazed_glass_pane", () -> new StainedGlassPaneBlock(GlazedColor.getColor(temp), GlazedGlassProperties(temp)));
       	CYAN_GLAZED_GLASS_PANE_PILLAR = HELPER.createBlock(temp + "_glazed_glass_pane_pillar", () -> new StainedGlassPaneBlock(GlazedColor.getColor(temp), GlazedGlassProperties(temp)));
       	CYAN_GLAZED_GLASS_PANE_PILLAR_TOP = HELPER.createBlock(temp + "_glazed_glass_pane_pillar_top", () -> new StainedGlassPaneBlock(GlazedColor.getColor(temp), GlazedGlassProperties(temp)));
       	CYAN_GLAZED_GLASS_PANE_SIDE_PILLAR = HELPER.createBlock(temp + "_glazed_glass_pane_side_pillar", () -> new StainedGlassPaneBlock(GlazedColor.getColor(temp), GlazedGlassProperties(temp)));
       	//LIGHT BLUE
       	temp = "light_blue";
       	LIGHT_BLUE_CENTERED_GLAZED_GLASS = HELPER.createBlock(temp + "_centered_glazed_glass", () -> new GlazedGlassBlock(GlazedColor.getColor(temp)));
       	LIGHT_BLUE_GLAZED_GLASS_PILLAR = HELPER.createBlock(temp + "_glazed_glass_pillar", () -> new GlazedGlassPillar(GlazedColor.getColor(temp)));
       	LIGHT_BLUE_CENTERED_GLAZED_GLASS_PANE = HELPER.createBlock(temp + "_centered_glazed_glass_pane", () -> new StainedGlassPaneBlock(GlazedColor.getColor(temp), GlazedGlassProperties(temp)));
       	LIGHT_BLUE_GLAZED_GLASS_PANE_PILLAR = HELPER.createBlock(temp + "_glazed_glass_pane_pillar", () -> new StainedGlassPaneBlock(GlazedColor.getColor(temp), GlazedGlassProperties(temp)));
       	LIGHT_BLUE_GLAZED_GLASS_PANE_PILLAR_TOP = HELPER.createBlock(temp + "_glazed_glass_pane_pillar_top", () -> new StainedGlassPaneBlock(GlazedColor.getColor(temp), GlazedGlassProperties(temp)));
       	LIGHT_BLUE_GLAZED_GLASS_PANE_SIDE_PILLAR = HELPER.createBlock(temp + "_glazed_glass_pane_side_pillar", () -> new StainedGlassPaneBlock(GlazedColor.getColor(temp), GlazedGlassProperties(temp)));
       	//BLUE
       	temp = "blue";
       	BLUE_CENTERED_GLAZED_GLASS = HELPER.createBlock(temp + "_centered_glazed_glass", () -> new GlazedGlassBlock(GlazedColor.getColor(temp)));
       	BLUE_GLAZED_GLASS_PILLAR = HELPER.createBlock(temp + "_glazed_glass_pillar", () -> new GlazedGlassPillar(GlazedColor.getColor(temp)));
       	BLUE_CENTERED_GLAZED_GLASS_PANE = HELPER.createBlock(temp + "_centered_glazed_glass_pane", () -> new StainedGlassPaneBlock(GlazedColor.getColor(temp), GlazedGlassProperties(temp)));
       	BLUE_GLAZED_GLASS_PANE_PILLAR = HELPER.createBlock(temp + "_glazed_glass_pane_pillar", () -> new StainedGlassPaneBlock(GlazedColor.getColor(temp), GlazedGlassProperties(temp)));
       	BLUE_GLAZED_GLASS_PANE_PILLAR_TOP = HELPER.createBlock(temp + "_glazed_glass_pane_pillar_top", () -> new StainedGlassPaneBlock(GlazedColor.getColor(temp), GlazedGlassProperties(temp)));
       	BLUE_GLAZED_GLASS_PANE_SIDE_PILLAR = HELPER.createBlock(temp + "_glazed_glass_pane_side_pillar", () -> new StainedGlassPaneBlock(GlazedColor.getColor(temp), GlazedGlassProperties(temp)));
       	//PURPLE
       	temp = "purple";
       	PURPLE_CENTERED_GLAZED_GLASS = HELPER.createBlock(temp + "_centered_glazed_glass", () -> new GlazedGlassBlock(GlazedColor.getColor(temp)));
       	PURPLE_GLAZED_GLASS_PILLAR = HELPER.createBlock(temp + "_glazed_glass_pillar", () -> new GlazedGlassPillar(GlazedColor.getColor(temp)));
       	PURPLE_CENTERED_GLAZED_GLASS_PANE = HELPER.createBlock(temp + "_centered_glazed_glass_pane", () -> new StainedGlassPaneBlock(GlazedColor.getColor(temp), GlazedGlassProperties(temp)));
       	PURPLE_GLAZED_GLASS_PANE_PILLAR = HELPER.createBlock(temp + "_glazed_glass_pane_pillar", () -> new StainedGlassPaneBlock(GlazedColor.getColor(temp), GlazedGlassProperties(temp)));
       	PURPLE_GLAZED_GLASS_PANE_PILLAR_TOP = HELPER.createBlock(temp + "_glazed_glass_pane_pillar_top", () -> new StainedGlassPaneBlock(GlazedColor.getColor(temp), GlazedGlassProperties(temp)));
       	PURPLE_GLAZED_GLASS_PANE_SIDE_PILLAR = HELPER.createBlock(temp + "_glazed_glass_pane_side_pillar", () -> new StainedGlassPaneBlock(GlazedColor.getColor(temp), GlazedGlassProperties(temp)));
       	//MAGENTA
       	temp = "magenta";
       	MAGENTA_CENTERED_GLAZED_GLASS = HELPER.createBlock(temp + "_centered_glazed_glass", () -> new GlazedGlassBlock(GlazedColor.getColor(temp)));
       	MAGENTA_GLAZED_GLASS_PILLAR = HELPER.createBlock(temp + "_glazed_glass_pillar", () -> new GlazedGlassPillar(GlazedColor.getColor(temp)));
       	MAGENTA_CENTERED_GLAZED_GLASS_PANE = HELPER.createBlock(temp + "_centered_glazed_glass_pane", () -> new StainedGlassPaneBlock(GlazedColor.getColor(temp), GlazedGlassProperties(temp)));
       	MAGENTA_GLAZED_GLASS_PANE_PILLAR = HELPER.createBlock(temp + "_glazed_glass_pane_pillar", () -> new StainedGlassPaneBlock(GlazedColor.getColor(temp), GlazedGlassProperties(temp)));
       	MAGENTA_GLAZED_GLASS_PANE_PILLAR_TOP = HELPER.createBlock(temp + "_glazed_glass_pane_pillar_top", () -> new StainedGlassPaneBlock(GlazedColor.getColor(temp), GlazedGlassProperties(temp)));
       	MAGENTA_GLAZED_GLASS_PANE_SIDE_PILLAR = HELPER.createBlock(temp + "_glazed_glass_pane_side_pillar", () -> new StainedGlassPaneBlock(GlazedColor.getColor(temp), GlazedGlassProperties(temp)));
       	//PINK
       	temp = "pink";
       	PINK_CENTERED_GLAZED_GLASS = HELPER.createBlock(temp + "_centered_glazed_glass", () -> new GlazedGlassBlock(GlazedColor.getColor(temp)));
       	PINK_GLAZED_GLASS_PILLAR = HELPER.createBlock(temp + "_glazed_glass_pillar", () -> new GlazedGlassPillar(GlazedColor.getColor(temp)));
       	PINK_CENTERED_GLAZED_GLASS_PANE = HELPER.createBlock(temp + "_centered_glazed_glass_pane", () -> new StainedGlassPaneBlock(GlazedColor.getColor(temp), GlazedGlassProperties(temp)));
       	PINK_GLAZED_GLASS_PANE_PILLAR = HELPER.createBlock(temp + "_glazed_glass_pane_pillar", () -> new StainedGlassPaneBlock(GlazedColor.getColor(temp), GlazedGlassProperties(temp)));
       	PINK_GLAZED_GLASS_PANE_PILLAR_TOP = HELPER.createBlock(temp + "_glazed_glass_pane_pillar_top", () -> new StainedGlassPaneBlock(GlazedColor.getColor(temp), GlazedGlassProperties(temp)));
       	PINK_GLAZED_GLASS_PANE_SIDE_PILLAR = HELPER.createBlock(temp + "_glazed_glass_pane_side_pillar", () -> new StainedGlassPaneBlock(GlazedColor.getColor(temp), GlazedGlassProperties(temp)));
       	
       	GlazedResymmetry.LOGGER.log(Level.INFO, "Compat: Patterned Glass glazed block/panes registered");
    }
	
	//@SuppressWarnings("unchecked")
	public static void setupTabEditors() {
		if (ModList.get().isLoaded("patternedglass")) {
			CreativeModeTabContentsPopulator.mod(Registration.MOD_ID)
				.tab(CompatCreativeTab.TAB_KEY2.getKey())
				//WHITE
				.addItems(WHITE_CENTERED_GLAZED_GLASS,
						WHITE_GLAZED_GLASS_PILLAR,
						WHITE_CENTERED_GLAZED_GLASS_PANE,
						WHITE_GLAZED_GLASS_PANE_PILLAR,
						WHITE_GLAZED_GLASS_PANE_PILLAR_TOP,
						WHITE_GLAZED_GLASS_PANE_SIDE_PILLAR)
				//LIGHT GRAY
				.addItems(LIGHT_GRAY_CENTERED_GLAZED_GLASS,
						LIGHT_GRAY_GLAZED_GLASS_PILLAR,
						LIGHT_GRAY_CENTERED_GLAZED_GLASS_PANE,
						LIGHT_GRAY_GLAZED_GLASS_PANE_PILLAR,
						LIGHT_GRAY_GLAZED_GLASS_PANE_PILLAR_TOP,
						LIGHT_GRAY_GLAZED_GLASS_PANE_SIDE_PILLAR)
				//GRAY
				.addItems(GRAY_CENTERED_GLAZED_GLASS,
						GRAY_GLAZED_GLASS_PILLAR,
						GRAY_CENTERED_GLAZED_GLASS_PANE,
						GRAY_GLAZED_GLASS_PANE_PILLAR,
						GRAY_GLAZED_GLASS_PANE_PILLAR_TOP,
						GRAY_GLAZED_GLASS_PANE_SIDE_PILLAR)
				//BLACK
				.addItems(BLACK_CENTERED_GLAZED_GLASS,
						BLACK_GLAZED_GLASS_PILLAR,
						BLACK_CENTERED_GLAZED_GLASS_PANE,
						BLACK_GLAZED_GLASS_PANE_PILLAR,
						BLACK_GLAZED_GLASS_PANE_PILLAR_TOP,
						BLACK_GLAZED_GLASS_PANE_SIDE_PILLAR)
				//BROWN
				.addItems(BROWN_CENTERED_GLAZED_GLASS,
						BROWN_GLAZED_GLASS_PILLAR,
						BROWN_CENTERED_GLAZED_GLASS_PANE,
						BROWN_GLAZED_GLASS_PANE_PILLAR,
						BROWN_GLAZED_GLASS_PANE_PILLAR_TOP,
						BROWN_GLAZED_GLASS_PANE_SIDE_PILLAR)
				//RED
				.addItems(RED_CENTERED_GLAZED_GLASS,
						RED_GLAZED_GLASS_PILLAR,
						RED_CENTERED_GLAZED_GLASS_PANE,
						RED_GLAZED_GLASS_PANE_PILLAR,
						RED_GLAZED_GLASS_PANE_PILLAR_TOP,
						RED_GLAZED_GLASS_PANE_SIDE_PILLAR)
				//ORANGE
				.addItems(ORANGE_CENTERED_GLAZED_GLASS,
						ORANGE_GLAZED_GLASS_PILLAR,
						ORANGE_CENTERED_GLAZED_GLASS_PANE,
						ORANGE_GLAZED_GLASS_PANE_PILLAR,
						ORANGE_GLAZED_GLASS_PANE_PILLAR_TOP,
						ORANGE_GLAZED_GLASS_PANE_SIDE_PILLAR)
				//YELLOW
				.addItems(YELLOW_CENTERED_GLAZED_GLASS,
						YELLOW_GLAZED_GLASS_PILLAR,
						YELLOW_CENTERED_GLAZED_GLASS_PANE,
						YELLOW_GLAZED_GLASS_PANE_PILLAR,
						YELLOW_GLAZED_GLASS_PANE_PILLAR_TOP,
						YELLOW_GLAZED_GLASS_PANE_SIDE_PILLAR)
				//LIME
				.addItems(LIME_CENTERED_GLAZED_GLASS,
						LIME_GLAZED_GLASS_PILLAR,
						LIME_CENTERED_GLAZED_GLASS_PANE,
						LIME_GLAZED_GLASS_PANE_PILLAR,
						LIME_GLAZED_GLASS_PANE_PILLAR_TOP,
						LIME_GLAZED_GLASS_PANE_SIDE_PILLAR)
				//GREEN
				.addItems(GREEN_CENTERED_GLAZED_GLASS,
						GREEN_GLAZED_GLASS_PILLAR,
						GREEN_CENTERED_GLAZED_GLASS_PANE,
						GREEN_GLAZED_GLASS_PANE_PILLAR,
						GREEN_GLAZED_GLASS_PANE_PILLAR_TOP,
						GREEN_GLAZED_GLASS_PANE_SIDE_PILLAR)
				//CYAN
				.addItems(CYAN_CENTERED_GLAZED_GLASS,
						CYAN_GLAZED_GLASS_PILLAR,
						CYAN_CENTERED_GLAZED_GLASS_PANE,
						CYAN_GLAZED_GLASS_PANE_PILLAR,
						CYAN_GLAZED_GLASS_PANE_PILLAR_TOP,
						CYAN_GLAZED_GLASS_PANE_SIDE_PILLAR)
				//LIGHT BLUE
				.addItems(LIGHT_BLUE_CENTERED_GLAZED_GLASS,
						LIGHT_BLUE_GLAZED_GLASS_PILLAR,
						LIGHT_BLUE_CENTERED_GLAZED_GLASS_PANE,
						LIGHT_BLUE_GLAZED_GLASS_PANE_PILLAR,
						LIGHT_BLUE_GLAZED_GLASS_PANE_PILLAR_TOP,
						LIGHT_BLUE_GLAZED_GLASS_PANE_SIDE_PILLAR)
				//BLUE
				.addItems(BLUE_CENTERED_GLAZED_GLASS,
						BLUE_GLAZED_GLASS_PILLAR,
						BLUE_CENTERED_GLAZED_GLASS_PANE,
						BLUE_GLAZED_GLASS_PANE_PILLAR,
						BLUE_GLAZED_GLASS_PANE_PILLAR_TOP,
						BLUE_GLAZED_GLASS_PANE_SIDE_PILLAR)
				//PURPLE
				.addItems(PURPLE_CENTERED_GLAZED_GLASS,
						PURPLE_GLAZED_GLASS_PILLAR,
						PURPLE_CENTERED_GLAZED_GLASS_PANE,
						PURPLE_GLAZED_GLASS_PANE_PILLAR,
						PURPLE_GLAZED_GLASS_PANE_PILLAR_TOP,
						PURPLE_GLAZED_GLASS_PANE_SIDE_PILLAR)
				//MAGENTA
				.addItems(MAGENTA_CENTERED_GLAZED_GLASS,
						MAGENTA_GLAZED_GLASS_PILLAR,
						MAGENTA_CENTERED_GLAZED_GLASS_PANE,
						MAGENTA_GLAZED_GLASS_PANE_PILLAR,
						MAGENTA_GLAZED_GLASS_PANE_PILLAR_TOP,
						MAGENTA_GLAZED_GLASS_PANE_SIDE_PILLAR)
				//PINK
				.addItems(PINK_CENTERED_GLAZED_GLASS,
						PINK_GLAZED_GLASS_PILLAR,
						PINK_CENTERED_GLAZED_GLASS_PANE,
						PINK_GLAZED_GLASS_PANE_PILLAR,
						PINK_GLAZED_GLASS_PANE_PILLAR_TOP,
						PINK_GLAZED_GLASS_PANE_SIDE_PILLAR);
		}
	}
	*/
}
