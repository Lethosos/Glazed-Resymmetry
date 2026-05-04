package com.lethosos.glazedresymmetry.compat;

import com.lethosos.glazedresymmetry.GlazedResymmetry;
import com.lethosos.glazedresymmetry.init.util.DataUtil;
//import com.lethosos.glazedresymmetry.init.util.VanillaCheck;
import com.mojang.datafixers.util.Pair;
//import com.teamabnormals.clayworks.core.registry.ClayworksBlocks;

public class ClayworksCompat {
	public static ClayworksGroup GLAZED;

	public static void register() {
		if ( GlazedResymmetry.CLAYWORKS == true ) {
			GLAZED = new ClayworksGroup();
		}
	}
	
	public static void registerPattern() {
    	if ( GlazedResymmetry.CLAYWORKS == true )
    	{
    		DataUtil.registerDecoratedPotPattern(Pair.of(GLAZED.SHARD.get(), GLAZED.PATTERN));
    	}
	}
}
