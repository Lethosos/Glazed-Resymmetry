package com.lethosos.glazedresymmetry;

import com.lethosos.glazedresymmetry.init.GlazedBlocks;
import com.lethosos.glazedresymmetry.init.GlazedCreativeTab;
import com.lethosos.glazedresymmetry.init.GlazedItems;
import com.lethosos.glazedresymmetry.init.util.ModItemSubRegistryHelper;
import com.teamabnormals.blueprint.core.util.registry.RegistryHelper;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class Registration {
	public static final String MOD_ID = "glazedresymmetry";
	
	public static final RegistryHelper REGISTRY_HELPER = RegistryHelper.create(MOD_ID, helper -> helper.putSubHelper(ForgeRegistries.ITEMS, new ModItemSubRegistryHelper(helper)));
	
	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MOD_ID);
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MOD_ID);
    public static final DeferredRegister<CreativeModeTab> TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MOD_ID);
     
	public static void register() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        
        REGISTRY_HELPER.register(modEventBus);
                
        GlazedBlocks.register();
        GlazedItems.register();
        GlazedCreativeTab.register(modEventBus);
        
        BLOCKS.register(modEventBus);
        ITEMS.register(modEventBus);
    }
}
