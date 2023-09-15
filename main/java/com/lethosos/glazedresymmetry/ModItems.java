package com.lethosos.glazedresymmetry;

import net.minecraft.world.item.Item;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static RegistryObject<Item> LIGHT_BLUE_GLAZED_SHARD;
  
    static void register() {
        for (String color: GlazedColor.COLORS) {
         	if (color == "light_blue")
        	{
        		LIGHT_BLUE_GLAZED_SHARD = Registration.ITEMS.register("light_blue_glazed_shard", () -> new Item(new Item.Properties()));
        	}
        	else
        	{
        		Registration.ITEMS.register(color + "_glazed_shard", () -> new Item(new Item.Properties()));
        	}
        }
    }
}
