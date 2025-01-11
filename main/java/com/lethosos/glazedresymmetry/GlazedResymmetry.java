package com.lethosos.glazedresymmetry;

import org.slf4j.Logger;
//import com.lethosos.glazedresymmetry.compat.Clayworks;
//import com.lethosos.glazedresymmetry.compat.PatternedClayworks;
//import com.lethosos.glazedresymmetry.compat.PatternedGlass;
import com.lethosos.glazedresymmetry.init.GlazedBlocks;
import com.lethosos.glazedresymmetry.init.GlazedCreativeTab;
import com.mojang.logging.LogUtils;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
//import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.event.server.ServerStartingEvent;

@Mod(Registration.MOD_ID)
public class GlazedResymmetry {
	
    // Directly reference a log4j logger.
    public static final Logger LOGGER = LogUtils.getLogger();
    
    //@EventBusSubscriber(modid = Registration.MOD_ID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    
    //ModContainer needed for config; we don't use one right now
    //public GlazedResymmetry(IEventBus modEventBus, ModContainer modContainer) {
    public GlazedResymmetry(IEventBus modEventBus) {
        modEventBus.addListener(this::commonSetup);

    	//Do we have a @SubscribeEvent somewhere?
        NeoForge.EVENT_BUS.register(this);

        GlazedBlocks.register(modEventBus);
        //GlazedItems.register(modEventBus);
    	GlazedCreativeTab.register(modEventBus);
    	
        modEventBus.addListener(this::addCreative);

        //For config setup
        //modContainer.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }
    
    private void addCreative(BuildCreativeModeTabContentsEvent event)
    {
		//GlazedBlocks.setupTab();
		//GlazedBlocks.setupTabEditors(event);
		//GlazedItems.setupTabEditors();//(event);
		//Clayworks.setupTabEditors(event);
		//PatternedGlass.setupTabEditors(event);
		//PatternedClayworks.setupTabEditors(event);
    }
    
	private void commonSetup(final FMLCommonSetupEvent event) {
    	event.enqueueWork(() -> {
    		//LOGGER.info("HELLO FROM SETUP");
    		GlazedBlocks.setupTab();
    		//GlazedPotPatterns.registerPatterns();
    	});
    }
	
	@SubscribeEvent
	public void onServerStarting(ServerStartingEvent event) {
		
	}
	
	@EventBusSubscriber(modid = Registration.MOD_ID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
	public static class ClientModEvents {
		@SubscribeEvent
		public static void onClientStartup(FMLClientSetupEvent event) {
			
		}
	}
}
