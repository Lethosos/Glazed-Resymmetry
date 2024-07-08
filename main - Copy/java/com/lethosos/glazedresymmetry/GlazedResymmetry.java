package com.lethosos.glazedresymmetry;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.lethosos.glazedresymmetry.init.GlazedFlowerPot;
import com.lethosos.glazedresymmetry.init.ModBlocks;
import com.lethosos.glazedresymmetry.init.ModItems;
import com.lethosos.glazedresymmetry.init.ModPotPatterns;

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
    
    public GlazedResymmetry() {
    	IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
    	
        Registration.register();
        
        ModPotPatterns.PATTERNS.register(modEventBus);

        MinecraftForge.EVENT_BUS.register(this);
        
        modEventBus.addListener(this::commonSetup);
        
        DistExecutor.unsafeRunWhenOn(Dist.CLIENT, () -> () -> {
			ModBlocks.setupTabEditors();
			ModItems.setupTabEditors();
        });
    }
    
	private void commonSetup(FMLCommonSetupEvent event) {
    	event.enqueueWork(() -> {
    		ModPotPatterns.registerPatterns();
    		GlazedFlowerPot.registerFlowerPots();
    	});
    }
}
