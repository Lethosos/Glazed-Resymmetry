package com.lethosos.glazedresymmetry.compat;

import com.lethosos.glazedresymmetry.GlazedResymmetry;
import com.lethosos.glazedresymmetry.init.GlazedBlocks;
import com.lethosos.glazedresymmetry.init.util.DataUtil;
import com.lethosos.glazedresymmetry.init.util.GlazedGroup;
import com.mojang.datafixers.util.Pair;

public class Clayworks {
	public static GlazedGroup GLAZED;

	public static void register() {
		if ( GlazedResymmetry.CLAYWORKS ) {
			GLAZED = new ClayworksGroup("glazed");
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
    		//GLAZED.registerPots();
    	}
	}
}
