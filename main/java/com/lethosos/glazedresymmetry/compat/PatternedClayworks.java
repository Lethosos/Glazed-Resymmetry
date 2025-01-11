package com.lethosos.glazedresymmetry.compat;

import com.lethosos.glazedresymmetry.Registration;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.StainedGlassPaneBlock;

public class PatternedClayworks {
	/*
	public static final BlockSubRegistryHelper HELPER = Registration.REGISTRY_HELPER.getBlockSubHelper();
	
	public static RegistryObject<Block> GLAZED_GLASS;
	public static RegistryObject<Block> CENTERED_GLAZED_GLASS;
	public static RegistryObject<Block> GLAZED_GLASS_PILLAR;
	public static RegistryObject<Block> GLAZED_GLASS_PANE;
	public static RegistryObject<Block> CENTERED_GLAZED_GLASS_PANE;
	public static RegistryObject<Block> GLAZED_GLASS_PANE_PILLAR;
	public static RegistryObject<Block> GLAZED_GLASS_PANE_PILLAR_TOP;
	public static RegistryObject<Block> GLAZED_GLASS_PANE_SIDE_PILLAR;
	
	private static String temp = Blocks.TERRACOTTA.defaultMapColor().toString();
	//Patterned Glass and Clayworks compat (since I can do this!)
	public static void register() {
		GLAZED_GLASS = HELPER.createBlock("glazed_glass", () -> new GlazedGlassBlock(GlazedColor.getColor(temp)));
		CENTERED_GLAZED_GLASS = HELPER.createBlock("centered_glazed_glass", () -> new GlazedGlassBlock(GlazedColor.getColor(temp)));
		GLAZED_GLASS_PILLAR = HELPER.createBlock("glazed_glass_pillar", () -> new GlazedGlassPillar(GlazedColor.getColor(temp)));
		GLAZED_GLASS_PANE = HELPER.createBlock("glazed_glass_pane", () -> new StainedGlassPaneBlock(GlazedColor.getColor(temp), PatternedGlass.GlazedGlassProperties(temp)));
       	CENTERED_GLAZED_GLASS_PANE = HELPER.createBlock("centered_glazed_glass_pane", () -> new StainedGlassPaneBlock(GlazedColor.getColor(temp), PatternedGlass.GlazedGlassProperties(temp)));
       	GLAZED_GLASS_PANE_PILLAR = HELPER.createBlock("glazed_glass_pane_pillar", () -> new StainedGlassPaneBlock(GlazedColor.getColor(temp), PatternedGlass.GlazedGlassProperties(temp)));
       	GLAZED_GLASS_PANE_PILLAR_TOP = HELPER.createBlock("glazed_glass_pane_pillar_top", () -> new StainedGlassPaneBlock(GlazedColor.getColor(temp), PatternedGlass.GlazedGlassProperties(temp)));
       	GLAZED_GLASS_PANE_SIDE_PILLAR = HELPER.createBlock("glazed_glass_pane_side_pillar", () -> new StainedGlassPaneBlock(GlazedColor.getColor(temp), PatternedGlass.GlazedGlassProperties(temp)));
	}
	
	public static void setupTabEditors() {
		if (ModList.get().isLoaded("patternedglass") && ModList.get().isLoaded("clayworks")) {
			CreativeModeTabContentsPopulator.mod(Registration.MOD_ID)
				.tab(CompatCreativeTab.TAB_KEY2.getKey())
				.addItems(GLAZED_GLASS,
						CENTERED_GLAZED_GLASS,
						GLAZED_GLASS_PILLAR,
						GLAZED_GLASS_PANE,
						CENTERED_GLAZED_GLASS_PANE,
						GLAZED_GLASS_PANE_PILLAR,
						GLAZED_GLASS_PANE_PILLAR_TOP,
						GLAZED_GLASS_PANE_SIDE_PILLAR);
		}
	}
	*/
}