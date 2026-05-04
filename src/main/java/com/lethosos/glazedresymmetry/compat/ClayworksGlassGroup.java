package com.lethosos.glazedresymmetry.compat;

import com.lethosos.glazedresymmetry.init.util.GlazedGlassBlock;
import com.lethosos.glazedresymmetry.init.util.GlazedGlassPane;
import com.lethosos.glazedresymmetry.init.util.GlazedGlassPillar;
import com.lethosos.glazedresymmetry.init.GlazedCreativeTab;
import com.lethosos.glazedresymmetry.init.util.GlassGroup;

import net.minecraft.world.item.DyeColor;

public class ClayworksGlassGroup extends GlassGroup{

	public static String groupName;
	public DyeColor color;
	
	public ClayworksGlassGroup() {
		super("glazed", DyeColor.ORANGE);
		color = DyeColor.ORANGE;
		groupName = "glazed";

		GLAZED = GlassGroup.registerBlock("glazed_glass", ()-> new GlazedGlassBlock(GlazedGlassBlock.GlazedGlassProperties(color), CENTERED, PILLAR));
		CENTERED = GlassGroup.registerBlock("centered_glazed_glass", ()-> new GlazedGlassBlock(GlazedGlassBlock.GlazedGlassProperties(color), GLAZED, PILLAR));
		PILLAR = GlassGroup.registerBlock("glazed_glass_pillar", ()-> new GlazedGlassPillar(GlazedGlassPillar.GlazedPillarProperties(color), GLAZED, CENTERED));
		
		GLAZED_PANE = GlassGroup.registerBlock("glazed_glass_pane", ()-> new GlazedGlassPane(GlazedGlassPane.GlazedPaneProperties(color)));
		CENTERED_PANE = GlassGroup.registerBlock("centered_glazed_glass_pane", ()-> new GlazedGlassPane(GlazedGlassPane.GlazedPaneProperties(color)));
		PILLAR_TOP_PANE = GlassGroup.registerBlock("glazed_glass_pane_pillar_top", ()-> new GlazedGlassPane(GlazedGlassPane.GlazedPaneProperties(color)));
		SIDE_PILLAR_PANE = GlassGroup.registerBlock("glazed_glass_pane_side_pillar", ()-> new GlazedGlassPane(GlazedGlassPane.GlazedPaneProperties(color)));
		
		glazed1 = registerBlock("glazed_glass_pane1", ()-> new GlazedGlassPane(GlazedGlassPane.GlazedPaneProperties(color)));
		glazed2 = registerBlock("glazed_glass_pane2", ()-> new GlazedGlassPane(GlazedGlassPane.GlazedPaneProperties(color)));
		glazed3 = registerBlock("glazed_glass_pane3", ()-> new GlazedGlassPane(GlazedGlassPane.GlazedPaneProperties(color)));
		side1 = registerBlock("glazed_glass_pane_side_pillar1", ()-> new GlazedGlassPane(GlazedGlassPane.GlazedPaneProperties(color)));

	}
	
    public void toTab() {
    	GlazedCreativeTab.TabList.add(GLAZED.asItem());
    	GlazedCreativeTab.TabList.add(CENTERED.asItem());
    	GlazedCreativeTab.TabList.add(PILLAR.asItem());
    	GlazedCreativeTab.TabList.add(GLAZED_PANE.asItem());
    	GlazedCreativeTab.TabList.add(CENTERED_PANE.asItem());
    	GlazedCreativeTab.TabList.add(PILLAR_TOP_PANE.asItem());
    	GlazedCreativeTab.TabList.add(SIDE_PILLAR_PANE.asItem());
    }
}