package com.lethosos.glazedresymmetry;

import java.util.function.Supplier;

import net.minecraft.world.item.Item;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static RegistryObject<Item> LIGHT_BLUE_GLAZED_SHARD;
    
    static void register() {
        for (String color: GlazedColor.COLORS) {
        	if (color == "light_blue")
        	{
        		LIGHT_BLUE_GLAZED_SHARD = Registration.ITEMS.register("light_blue_glazed_shard", () -> new Item(new Item.Properties().stacksTo(64).tab(ModCreativeTab.instance)));
        	}
        	else
        	{
        		register(color + "_glazed_shard", () -> new Item(new Item.Properties().stacksTo(64).tab(ModCreativeTab.instance)));
        	}
        }
    }
    
    private static <T extends Item> RegistryObject<T> register(String name, Supplier<T> item) {
        RegistryObject<T> reg_item = Registration.ITEMS.register(name, item);
        
        return reg_item;
    }
}
