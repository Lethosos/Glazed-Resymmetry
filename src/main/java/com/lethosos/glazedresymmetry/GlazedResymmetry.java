package com.lethosos.glazedresymmetry;

import org.slf4j.Logger;

import com.lethosos.glazedresymmetry.config.GlazedConfig;
import com.lethosos.glazedresymmetry.init.GlazedBlocks;
import com.lethosos.glazedresymmetry.init.GlazedCreativeTab;
import com.lethosos.glazedresymmetry.init.util.GlazedSounds;
import com.lethosos.glazedresymmetry.init.util.ModBlockEntities;
import com.lethosos.glazedresymmetry.init.util.renderer.GlazedFlowerPotRenderer;
import com.mojang.logging.LogUtils;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.ModList;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.event.server.ServerStartingEvent;

@Mod(GlazedResymmetry.MOD_ID)
public class GlazedResymmetry {
	
    // Directly reference a log4j logger.
    public static final Logger LOGGER = LogUtils.getLogger();
    
    public static final String MOD_ID = "glazedresymmetry";
    public static Boolean CLAYWORKS = false;
    
    //ModContainer needed for config; we don't use one right now
    //public GlazedResymmetry(IEventBus modEventBus, ModContainer modContainer) {
    public GlazedResymmetry(IEventBus modEventBus, ModContainer modContainer) {
        if (ModList.get().isLoaded("clayworks")) { CLAYWORKS = true; }
        
    	modEventBus.addListener(this::commonSetup);
    	
    	modContainer.registerConfig(ModConfig.Type.COMMON, GlazedConfig.COMMON_CONFIG);

    	//Do we have a @SubscribeEvent somewhere?
        NeoForge.EVENT_BUS.register(this);
        
        GlazedBlocks.register(modEventBus);
        ModBlockEntities.register(modEventBus);
        GlazedBlocks.PATTERNS.register(modEventBus);
        GlazedSounds.SOUND_EVENTS.register(modEventBus);
        GlazedCreativeTab.register(modEventBus);
		
        modEventBus.addListener(this::addCreative);

        //For config setup
        //modContainer.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }
    
    private void addCreative(BuildCreativeModeTabContentsEvent event) {}
    
	private void commonSetup(final FMLCommonSetupEvent event) {
    	event.enqueueWork(() -> {
    		GlazedBlocks.setupTab();
    		GlazedBlocks.registerPatterns();
    		GlazedBlocks.setPanes();
    		GlazedBlocks.setRotatables();
    		});
    }
	
	@SubscribeEvent
	public void onServerStarting(ServerStartingEvent event) {
		//GlazedBlocks.setPanes();
	}
	
	@EventBusSubscriber(modid = MOD_ID, value = Dist.CLIENT)
	public static class ClientModEvents {
		@SubscribeEvent
		public static void onClientStartup(FMLClientSetupEvent event) {
		}
		
        @SubscribeEvent
        public static void registerBER(EntityRenderersEvent.RegisterRenderers event) {
        	event.registerBlockEntityRenderer(ModBlockEntities.FLOWERPOT_BE.get(), GlazedFlowerPotRenderer::new);
        }
	}
}
