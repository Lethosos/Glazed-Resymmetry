package com.lethosos.glazedresymmetry.init;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.lethosos.glazedresymmetry.Registration;
import com.lethosos.glazedresymmetry.init.util.ModItemSubRegistryHelper;
import com.teamabnormals.blueprint.core.util.item.CreativeModeTabContentsPopulator;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.registries.RegistryObject;

@EventBusSubscriber(modid = Registration.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
public class ModItems{
	public static final ModItemSubRegistryHelper HELPER = Registration.REGISTRY_HELPER.getItemSubHelper();
    public static final List<RegistryObject<Item>> REGISTERED_ITEMS = new ArrayList<>(16);
    public static final Map<String, BlockItem> GLAZED_FLOWER_POT_ITEMS_BY_COLOR = new HashMap<>(16);
	
    public static RegistryObject<Item> WHITE_GLAZED_SHARD = HELPER.createItem("white_glazed_shard", () -> new Item(new Item.Properties().stacksTo(64)));
    public static RegistryObject<Item> LIGHT_GRAY_GLAZED_SHARD = HELPER.createItem("light_gray_glazed_shard", () -> new Item(new Item.Properties().stacksTo(64)));
    public static RegistryObject<Item> RED_GLAZED_SHARD = HELPER.createItem("red_glazed_shard", () -> new Item(new Item.Properties().stacksTo(64)));
    public static RegistryObject<Item> PURPLE_GLAZED_SHARD = HELPER.createItem("purple_glazed_shard", () -> new Item(new Item.Properties().stacksTo(64)));
    public static RegistryObject<Item> PINK_GLAZED_SHARD = HELPER.createItem("pink_glazed_shard", () -> new Item(new Item.Properties().stacksTo(64)));
    public static RegistryObject<Item> ORANGE_GLAZED_SHARD = HELPER.createItem("orange_glazed_shard", () -> new Item(new Item.Properties().stacksTo(64)));
    public static RegistryObject<Item> MAGENTA_GLAZED_SHARD = HELPER.createItem("magenta_glazed_shard", () -> new Item(new Item.Properties().stacksTo(64)));
    public static RegistryObject<Item> LIME_GLAZED_SHARD = HELPER.createItem("lime_glazed_shard", () -> new Item(new Item.Properties().stacksTo(64)));
    public static RegistryObject<Item> LIGHT_BLUE_GLAZED_SHARD = HELPER.createItem("light_blue_glazed_shard", () -> new Item(new Item.Properties().stacksTo(64)));
    public static RegistryObject<Item> GREEN_GLAZED_SHARD = HELPER.createItem("green_glazed_shard", () -> new Item(new Item.Properties().stacksTo(64)));
    public static RegistryObject<Item> GRAY_GLAZED_SHARD = HELPER.createItem("gray_glazed_shard", () -> new Item(new Item.Properties().stacksTo(64)));
    public static RegistryObject<Item> CYAN_GLAZED_SHARD = HELPER.createItem("cyan_glazed_shard", () -> new Item(new Item.Properties().stacksTo(64)));
    public static RegistryObject<Item> BROWN_GLAZED_SHARD = HELPER.createItem("brown_glazed_shard", () -> new Item(new Item.Properties().stacksTo(64)));
    public static RegistryObject<Item> BLUE_GLAZED_SHARD = HELPER.createItem("blue_glazed_shard", () -> new Item(new Item.Properties().stacksTo(64)));
    public static RegistryObject<Item> YELLOW_GLAZED_SHARD = HELPER.createItem("yellow_glazed_shard", () -> new Item(new Item.Properties().stacksTo(64)));
    public static RegistryObject<Item> BLACK_GLAZED_SHARD = HELPER.createItem("black_glazed_shard", () -> new Item(new Item.Properties().stacksTo(64)));
    
      // For Clayworks compat
    public static RegistryObject<Item> GLAZED_SHARD = HELPER.createItem("glazed_shard", () -> new Item(new Item.Properties().stacksTo(64)));
    
     public static void registerBlockItems(){
        GLAZED_FLOWER_POT_ITEMS_BY_COLOR.forEach((color, blockItem) -> {
            RegistryObject<Item> flowerPotItem = Registration.ITEMS.register(color + "_glazed_flower_pot", blockItem::asItem);
            REGISTERED_ITEMS.add(flowerPotItem);
        });
    }
    
	public static void setupTabEditors() {
		CreativeModeTabContentsPopulator.mod(Registration.MOD_ID)
		.tab(ModCreativeTab.TAB_KEY.getKey())
		.addItems(WHITE_GLAZED_SHARD,
				LIGHT_GRAY_GLAZED_SHARD,
				RED_GLAZED_SHARD,
				PURPLE_GLAZED_SHARD,
				PINK_GLAZED_SHARD,
				ORANGE_GLAZED_SHARD,
				MAGENTA_GLAZED_SHARD,
				LIME_GLAZED_SHARD,
				LIGHT_BLUE_GLAZED_SHARD,
				GREEN_GLAZED_SHARD,
				GRAY_GLAZED_SHARD,
				CYAN_GLAZED_SHARD,
				BROWN_GLAZED_SHARD,
				BLUE_GLAZED_SHARD,
				YELLOW_GLAZED_SHARD,
				BLACK_GLAZED_SHARD)
		.predicate(event -> event.getTabKey() == ModCreativeTab.TAB_KEY.getKey() && ModList.get().isLoaded("clayworks"))
		.addItems(GLAZED_SHARD);
	}
}