package com.lethosos.glazedresymmetry;

import com.lethosos.glazedresymmetry.compat.Clayworks;
import com.lethosos.glazedresymmetry.compat.CompatCreativeTab;
import com.lethosos.glazedresymmetry.compat.PatternedClayworks;
import com.lethosos.glazedresymmetry.compat.PatternedGlass;
import com.lethosos.glazedresymmetry.init.GlazedCreativeTab;
import com.lethosos.glazedresymmetry.init.util.ModItemSubRegistryHelper;
import com.lethosos.glazedresymmetry.init.util.OptionalLootItem;
import com.lethosos.glazedresymmetry.init.util.OptionalLootItemBlockStatePropertyCondition;
import com.teamabnormals.blueprint.core.util.registry.RegistryHelper;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.entries.LootPoolEntryType;
import net.minecraft.world.level.storage.loot.predicates.LootItemConditionType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class Registration {
	public static final String MOD_ID = "glazedresymmetry";
	
	public static final RegistryHelper REGISTRY_HELPER = RegistryHelper.create(MOD_ID, helper -> helper.putSubHelper(ForgeRegistries.ITEMS, new ModItemSubRegistryHelper(helper)));
	
	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MOD_ID);
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MOD_ID);
    public static final DeferredRegister<CreativeModeTab> TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MOD_ID);
    public static final DeferredRegister<LootPoolEntryType> LOOT_POOL_ENTRIES = DeferredRegister.create(Registries.LOOT_POOL_ENTRY_TYPE, MOD_ID);
    public static final DeferredRegister<LootItemConditionType> LOOT_POOL_CONDITIONS = DeferredRegister.create(Registries.LOOT_CONDITION_TYPE, MOD_ID);

    public static final RegistryObject<LootPoolEntryType> OPTIONAL_LOOT_ITEM = LOOT_POOL_ENTRIES.register("optional_loot_item", () -> new LootPoolEntryType(new OptionalLootItem.Serializer()));
    public static final RegistryObject<LootItemConditionType> OPTIONAL_BLOCK_STATE_PROPERTY = LOOT_POOL_CONDITIONS.register("optional_block_state_property", () -> new LootItemConditionType(new OptionalLootItemBlockStatePropertyCondition.Serializer()));
    
	public static void register() {
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

        GlazedCreativeTab.register(modEventBus);
        if (ModList.get().isLoaded("clayworks") || ModList.get().isLoaded("patternedglass"))
        {
        	CompatCreativeTab.register(modEventBus);
        }
        
        BLOCKS.register(modEventBus);
        ITEMS.register(modEventBus);
        
        LOOT_POOL_ENTRIES.register(modEventBus);
        LOOT_POOL_CONDITIONS.register(modEventBus);
    }
}
