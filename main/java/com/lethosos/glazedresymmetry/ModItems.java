package com.lethosos.glazedresymmetry;

import java.util.ArrayList;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static RegistryObject<Item> LIGHT_BLUE_GLAZED_SHARD;
    public static RegistryObject<Item> THIS_ITEM;
    
    public static ArrayList<Item> regItems;
    
    //public int getListSize() { return regItems.size(); }
    //public int getIterator() { return regItems.forEach(regItems.get(getIterator())); }
    
    static void register() {
    	//int x = 0;
        for (String color: GlazedColor.COLORS) {
         	if (color == "light_blue")
        	{
        		LIGHT_BLUE_GLAZED_SHARD = Registration.ITEMS.register("light_blue_glazed_shard", () -> new Item(new Item.Properties().stacksTo(64))); //.tab(ModCreativeTab.instance)));
        		//regItems.add(x, LIGHT_BLUE_GLAZED_SHARD.get());
        	}
        	else
        	{
        		THIS_ITEM = Registration.ITEMS.register(color + "_glazed_shard", () -> new Item(new Item.Properties().stacksTo(64))); //.tab(ModCreativeTab.instance)));
        		//regItems.add(x, THIS_ITEM.get());
        	}
         //	x++;
        }
    }

    /*
	private static <T extends Item> RegistryObject<T> register(String name, Supplier<T> item) {
        RegistryObject<T> reg_item = Registration.ITEMS.register(name, item);

        
        return reg_item;
    }
    */
}
