package com.lethosos.glazedresymmetry.init;

import java.util.Map;
import java.util.function.Supplier;

import org.apache.logging.log4j.Level;

import com.lethosos.glazedresymmetry.GlazedResymmetry;
import com.lethosos.glazedresymmetry.Registration;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.entity.DecoratedPotPatterns;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.RegistryObject;

@SuppressWarnings("unused")
public class ModItems {
	
	// Just in case
	/*
    public static RegistryObject<Item> WHITE_GLAZED_SHARD;
    public static RegistryObject<Item> LIGHT_GRAY_GLAZED_SHARD;
    public static RegistryObject<Item> RED_GLAZED_SHARD;
    public static RegistryObject<Item> PURPLE_GLAZED_SHARD;
    public static RegistryObject<Item> PINK_GLAZED_SHARD;
    public static RegistryObject<Item> ORANGE_GLAZED_SHARD;
    public static RegistryObject<Item> MAGENTA_GLAZED_SHARD;
    public static RegistryObject<Item> LIME_GLAZED_SHARD;
    public static RegistryObject<Item> LIGHT_BLUE_GLAZED_SHARD;
    public static RegistryObject<Item> GREEN_GLAZED_SHARD;
    public static RegistryObject<Item> GRAY_GLAZED_SHARD;
    public static RegistryObject<Item> CYAN_GLAZED_SHARD;
    public static RegistryObject<Item> BROWN_GLAZED_SHARD;
    public static RegistryObject<Item> BLUE_GLAZED_SHARD;
    public static RegistryObject<Item> YELLOW_GLAZED_SHARD;
    public static RegistryObject<Item> BLACK_GLAZED_SHARD;
    */
	public static RegistryObject<Item> LIGHT_BLUE_GLAZED_SHARD;
    
    // For later Clayworks compat
    //public static RegistryObject<Item> GLAZED_SHARD;
    
    public static void register() {
        for (String color: GlazedColor.COLORS) {
         	if (color == "light_blue")
        	{
         		LIGHT_BLUE_GLAZED_SHARD = Registration.ITEMS.register(color + "_glazed_shard", () -> new Item(new Item.Properties()));
        	}
        	else
        	{
        		Registration.ITEMS.register(color + "_glazed_shard", () -> new Item(new Item.Properties()));
        	}
        }
        GlazedResymmetry.LOGGER.log(Level.INFO, "Items loaded");
    }
}