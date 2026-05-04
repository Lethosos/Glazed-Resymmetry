package com.lethosos.glazedresymmetry;

import net.neoforged.bus.api.IEventBus;

public class Registration {
	public static final String MOD_ID = "glazedresymmetry";
	
	/*
	public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(MOD_ID);
	public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(MOD_ID);
	public static final DeferredRegister<CreativeModeTab> TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MOD_ID);

    public static final DeferredRegister<LootPoolEntryType> LOOT_POOL_ENTRIES = DeferredRegister.create(NeoForgeRegistries.LOOT_POOL_ENTRY_TYPE, MOD_ID);
    public static final DeferredRegister<LootItemConditionType> LOOT_POOL_CONDITIONS = DeferredRegister.create(NeoForgeRegistries.LOOT_CONDITION_TYPE, MOD_ID);

    public static final RegistryObject<LootPoolEntryType> OPTIONAL_LOOT_ITEM = LOOT_POOL_ENTRIES.register("optional_loot_item", () -> new LootPoolEntryType(new OptionalLootItem.Serializer()));
    public static final RegistryObject<LootItemConditionType> OPTIONAL_BLOCK_STATE_PROPERTY = LOOT_POOL_CONDITIONS.register("optional_block_state_property", () -> new LootItemConditionType(new OptionalLootItemBlockStatePropertyCondition.Serializer()));
    */
	
	public static void register(IEventBus modEventBus) {
        //BLOCKS.register(modEventBus);
        //ITEMS.register(modEventBus);
        
        //GlazedCreativeTab.register(modEventBus);
        
        /*
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        
        REGISTRY_HELPER.register(modEventBus);
                
        if (ModList.get().isLoaded("clayworks")) {
        	Clayworks.register();
        }
        if (ModList.get().isLoaded("patternedglass")) {
        	PatternedGlass.register();
        }
        if (ModList.get().isLoaded("clayworks") && ModList.get().isLoaded("patternedglass")) {
        	PatternedClayworks.register();
        }
        if (ModList.get().isLoaded("clayworks") || ModList.get().isLoaded("patternedglass"))
        {
        	CompatCreativeTab.register(modEventBus);
        }
        */
        

        
        //LOOT_POOL_ENTRIES.register(modEventBus);
        //LOOT_POOL_CONDITIONS.register(modEventBus);
    }
}
