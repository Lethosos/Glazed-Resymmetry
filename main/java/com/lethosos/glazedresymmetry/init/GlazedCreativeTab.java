package com.lethosos.glazedresymmetry.init;

import java.util.HashMap;
import java.util.List;

import com.lethosos.glazedresymmetry.Registration;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.RegistryObject;

public class GlazedCreativeTab {
	public static HashMap<String, List<ItemLike>> tabContents = new HashMap<String, List<ItemLike>>();
	
    public static final RegistryObject<CreativeModeTab> TAB_KEY = Registration.TABS.register("glazed_tab",
			() -> CreativeModeTab.builder()
			.title(Component.translatable("itemGroup.glazedresymmetry"))
			.icon(() -> new ItemStack(GlazedItems.LIGHT_BLUE_GLAZED_SHARD.get()))
			.build());

	public static void register(IEventBus eventBus)
	{
		Registration.TABS.register(eventBus);
	}
}