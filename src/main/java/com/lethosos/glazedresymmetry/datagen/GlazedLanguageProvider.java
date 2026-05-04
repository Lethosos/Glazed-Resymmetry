package com.lethosos.glazedresymmetry.datagen;

import com.lethosos.glazedresymmetry.GlazedResymmetry;
import com.lethosos.glazedresymmetry.compat.ClayworksCompat;
import com.lethosos.glazedresymmetry.init.GlazedBlocks;
import com.lethosos.glazedresymmetry.init.util.GlazedGroup;

import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.LanguageProvider;

public class GlazedLanguageProvider extends LanguageProvider {
    public GlazedLanguageProvider(PackOutput output) {
        super(output, GlazedResymmetry.MOD_ID, "en_us");
    }

    @Override
    protected void addTranslations() {
        this.add("itemGroup.glazedresymmetry", "Glazed Resymmetry");
        this.add("itemGroup.glazedresymmetry.compat", "Glazed Compat");
        this.add("sounds.oud.play", "Oud plays");
        
        DataGenerators.dataList.forEach((group) -> {
        	if (group.groupName != "glazed") { pushLang(group);	}
        	//Clayworks compat only
        	else {
        		this.addBlock(ClayworksCompat.GLAZED.CENTERED, "Centered Glazed Terracotta");
        		this.addBlock(ClayworksCompat.GLAZED.PILLAR, "Glazed Terracotta Pillar");
        		this.addBlock(ClayworksCompat.GLAZED.SLAB, "Glazed Terracotta Slab");
        		this.addBlock(ClayworksCompat.GLAZED.CENTERED_SLAB, "Centered Glazed Terracotta Slab");
        		this.addBlock(ClayworksCompat.GLAZED.PILLAR_SLAB, "Glazed Terracotta Pillar Slab");
        		this.addBlock(ClayworksCompat.GLAZED.SIDE_PILLAR_SLAB, "Glazed Terracotta Side Pillar Slab");
        		this.addBlock(ClayworksCompat.GLAZED.FLOWER_POT, "Glazed Flower Pot");
        		this.addItem(ClayworksCompat.GLAZED.SHARD, "Glazed Shard");
    		
        		this.addBlock(ClayworksCompat.GLAZED.GLASS.GLAZED, "Glazed Glass");
        		this.addBlock(ClayworksCompat.GLAZED.GLASS.CENTERED, "Centered Glazed Glass");
        		this.addBlock(ClayworksCompat.GLAZED.GLASS.PILLAR, "Glazed Glass Pillar");
        		this.addBlock(ClayworksCompat.GLAZED.GLASS.GLAZED_PANE, "Glazed Glass Pane");
        		this.addBlock(ClayworksCompat.GLAZED.GLASS.CENTERED_PANE, "Centered Glazed Glass Pane");
        		this.addBlock(ClayworksCompat.GLAZED.GLASS.PILLAR_TOP_PANE, "Glazed Glass Pillar Top Pane");
        		this.addBlock(ClayworksCompat.GLAZED.GLASS.SIDE_PILLAR_PANE, "Glazed Glass Side Pillar Pane");
        	}
        });
        
        this.addBlock(GlazedBlocks.FLOWERING_GLASS, "Flowering Glass Pillar");
        this.addBlock(GlazedBlocks.FLOWERING_GLASS_SIDE_PANE, "Flowering Glass Pillar Side Pane");
        this.addBlock(GlazedBlocks.FLOWERING_GLASS_TOP_PANE, "Flowering Glass Pillar Top Pane");
        
        this.addItem(GlazedBlocks.WAXED_SHARD, "Wax-Covered Glazed Shard");
        this.add("entity.productivebees.glazed_bee", "Glazed Bee");
        
        this.addItem(GlazedBlocks.GLASSCUTTER_TOOL, "Glasscutter");
        this.add("tooltip.glazedresymmetry.glasscutter.shift_down", "Rotates glazed glass blocks/panes on rightclick");
        this.add("tooltip.glazedresymmetry.glasscutter", "Rotates glazed glass blocks/panes on rightclick");
    }
    
	/**
	 * Takes in a GlazedGroup and spits out the lang output for each item.
	 * 
	 * @param group The GlazedGroup to pass.
	 */
    public void pushLang(GlazedGroup group) {
		this.addBlock(group.CENTERED, formatString(group.groupName) + " Centered Glazed Terracotta");
		this.addBlock(group.PILLAR, formatString(group.groupName) + " Glazed Terracotta Pillar");
		this.addBlock(group.SLAB, formatString(group.groupName) + " Glazed Terracotta Slab");
		this.addBlock(group.CENTERED_SLAB, formatString(group.groupName) + " Centered Glazed Terracotta Slab");
		this.addBlock(group.PILLAR_SLAB, formatString(group.groupName) + " Glazed Terracotta Pillar Slab");
		this.addBlock(group.SIDE_PILLAR_SLAB, formatString(group.groupName) + " Glazed Terracotta Side Pillar Slab");
		this.addBlock(group.FLOWER_POT, formatString(group.groupName) + " Glazed Flower Pot");
		this.addItem(group.SHARD, formatString(group.groupName) + " Glazed Shard");
		
    	this.addBlock(group.GLASS.GLAZED, formatString(group.groupName) + " Glazed Glass");
    	this.addBlock(group.GLASS.CENTERED, formatString(group.groupName) + " Centered Glazed Glass");
    	this.addBlock(group.GLASS.PILLAR, formatString(group.groupName) + " Glazed Glass Pillar");
    	this.addBlock(group.GLASS.GLAZED_PANE, formatString(group.groupName) + " Glazed Glass Pane");
    	this.addBlock(group.GLASS.CENTERED_PANE, formatString(group.groupName) + " Centered Glazed Glass Pane");
    	this.addBlock(group.GLASS.PILLAR_TOP_PANE, formatString(group.groupName) + " Glazed Glass Pillar Top Pane");
    	this.addBlock(group.GLASS.SIDE_PILLAR_PANE, formatString(group.groupName) + " Glazed Glass Side Pillar Pane");
    }
    
    private static String formatString(String str) {
        String name = str;
        String[] nameArr = str.split("[_]");
        String returnStr;
        
        if (nameArr.length == 2)
        {
        	String str1 = nameArr[0].substring(0, 1).toUpperCase();
        	String str2 = nameArr[1].substring(0, 1).toUpperCase();
        	returnStr = str1 + nameArr[0].substring(1) + " " + str2 + nameArr[1].substring(1);
        }
        else {
        	String s1 = name.substring(0, 1).toUpperCase();
        	returnStr = s1 + name.substring(1);
        }

        return returnStr;
    }
}
