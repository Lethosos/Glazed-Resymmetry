package com.lethosos.glazedresymmetry.compat;

import com.lethosos.glazedresymmetry.GlazedResymmetry;
import com.lethosos.glazedresymmetry.init.GlazedBlocks;
import com.lethosos.glazedresymmetry.init.GlazedGroup;
import com.lethosos.glazedresymmetry.init.util.DataUtil;
import com.mojang.datafixers.util.Pair;

import net.minecraft.world.level.block.Blocks;

public class Clayworks {
	public static GlazedGroup GLAZED;

	public static void register() {
		if ( GlazedResymmetry.CLAYWORKS ) {
			GLAZED = new CompatGroup("glazed", Blocks.TERRACOTTA.defaultMapColor());
			GlazedBlocks.groupList.add(GLAZED);
		}
	}
	
	public static void registerPattern() {
    	if ( GlazedResymmetry.CLAYWORKS )
    	{
    		DataUtil.registerDecoratedPotPattern(Pair.of(GLAZED.SHARD.get(), GLAZED.PATTERN));
    	}
	}
	
	public static void registerPots() {
    	if ( GlazedResymmetry.CLAYWORKS )
    	{
    		GLAZED.registerPots();
    	}
	}
}
