package com.lethosos.glazedresymmetry;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.lethosos.glazedresymmetry.compat.Clayworks;
import com.lethosos.glazedresymmetry.compat.PatternedClayworks;
import com.lethosos.glazedresymmetry.compat.PatternedGlass;
import com.lethosos.glazedresymmetry.init.GlazedBlocks;
import com.lethosos.glazedresymmetry.init.GlazedPotPatterns;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;


@Mod(Registration.MOD_ID)
public class GlazedResymmetry {
	
    // Directly reference a log4j logger.
    public static final Logger LOGGER = LogManager.getLogger();
    
    public static final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
    
    public GlazedResymmetry() {
    	Registration.register();
        
        GlazedPotPatterns.PATTERNS.register(modEventBus);

        MinecraftForge.EVENT_BUS.register(this);
        
        modEventBus.addListener(this::commonSetup);
        
        DistExecutor.unsafeRunWhenOn(Dist.CLIENT, () -> () -> {
			GlazedBlocks.setupTabEditors();
			Clayworks.setupTabEditors();
			PatternedGlass.setupTabEditors();
			PatternedClayworks.setupTabEditors();
        });
    }
    
	private void commonSetup(FMLCommonSetupEvent event) {
    	event.enqueueWork(() -> {
    		GlazedPotPatterns.registerPatterns();
    	});
    }
}
