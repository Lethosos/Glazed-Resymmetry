package com.lethosos.glazedresymmetry;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


@Mod(Registration.MOD_ID)
public class GlazedResymmetry {
	
    public static boolean clayworks = false;
    
    // Directly reference a log4j logger.
    public static final Logger LOGGER = LogManager.getLogger();
    
    public GlazedResymmetry() {
    	
    	if (ModList.get().isLoaded("clayworks")) { clayworks = true; }
    	
        Registration.register();

        MinecraftForge.EVENT_BUS.register(this);
    }
}
