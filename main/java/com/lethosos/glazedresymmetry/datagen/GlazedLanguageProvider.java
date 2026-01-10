package com.lethosos.glazedresymmetry.datagen;

import com.lethosos.glazedresymmetry.Registration;
import com.lethosos.glazedresymmetry.init.GlazedBlocks;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.LanguageProvider;

public class GlazedLanguageProvider extends LanguageProvider {
    public GlazedLanguageProvider(PackOutput output) {
        super(output, Registration.MOD_ID, "en_us");
    }

    @Override
    protected void addTranslations() {
        this.add("itemGroup.glazedresymmetry", "Glazed Resymmetry");
        this.add("itemGroup.glazedresymmetry.compat", "Glazed Compat");
        this.add("sounds.oud.play", "Oud plays");
        
        DataGenerators.dataList.forEach((group) -> {
        	if (group.groupName != "glazed")
        	{
        		this.addBlock(group.CENTERED, formatString(group.groupName) + " Centered Glazed Terracotta");
        		this.addBlock(group.PILLAR, formatString(group.groupName) + " Glazed Terracotta Pillar");
        		this.addBlock(group.SLAB, formatString(group.groupName) + " Glazed Terracotta Slab");
        		this.addBlock(group.CENTERED_SLAB, formatString(group.groupName) + " Centered Glazed Terracotta Slab");
        		this.addBlock(group.PILLAR_SLAB, formatString(group.groupName) + " Glazed Terracotta Pillar Slab");
        		this.addBlock(group.SIDE_PILLAR_SLAB, formatString(group.groupName) + " Glazed Terracotta Slade Pillar Slab");
        		this.addBlock(group.FLOWER_POT, formatString(group.groupName) + " Glazed Flower Pot");
        		this.addItem(group.SHARD, formatString(group.groupName) + " Glazed Shard");
        		
            	this.addBlock(group.GLASS.GLAZED, formatString(group.groupName) + " Glazed Glass");
            	this.addBlock(group.GLASS.CENTERED, formatString(group.groupName) + " Centered Glazed Glass");
            	this.addBlock(group.GLASS.PILLAR, formatString(group.groupName) + " Glazed Pillar Glass");
            	this.addBlock(group.GLASS.GLAZED_PANE, formatString(group.groupName) + " Glazed Glass Pane");
            	this.addBlock(group.GLASS.CENTERED_PANE, formatString(group.groupName) + " Centered Glazed Glass Pane");
            	this.addBlock(group.GLASS.PILLAR_TOP_PANE, formatString(group.groupName) + " Glazed Glass Pillar Top Pane");
            	this.addBlock(group.GLASS.SIDE_PILLAR_PANE, formatString(group.groupName) + " Glazed Glass Side Pillar Pane");
        	}
        	else
        	{
        		this.addBlock(group.CENTERED, "Centered Glazed Terracotta");
        		this.addBlock(group.PILLAR, "Glazed Terracotta Pillar");
        		this.addBlock(group.SLAB, "Glazed Terracotta Slab");
        		this.addBlock(group.CENTERED_SLAB, "Centered Glazed Terracotta Slab");
        		this.addBlock(group.PILLAR_SLAB, "Glazed Terracotta Pillar Slab");
        		this.addBlock(group.SIDE_PILLAR_SLAB, "Glazed Terracotta Side Pillar Slab");
        		this.addBlock(group.FLOWER_POT, "Glazed Flower Pot");
        		this.addItem(group.SHARD, "Glazed Shard");
        	}
        });
        
        this.addItem(GlazedBlocks.WAXED_SHARD, "Wax-Covered Glazed Shard");
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
