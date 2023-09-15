package com.lethosos.glazedresymmetry;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeTab {
    public static final RegistryObject<CreativeModeTab> TAB_KEY = Registration.TABS.register("glazed_tab",
			() -> CreativeModeTab.builder()
			.icon(() -> new ItemStack (Items.LIGHT_BLUE_GLAZED_TERRACOTTA))
			//.icon(() -> new ItemStack (ModItems.LIGHT_BLUE_GLAZED_SHARD.get())
			.title(Component.translatable("itemGroup.glazedresymmetry"))
			.displayItems((pParemeters, pOutput) -> {
				for (RegistryObject<Item> item: Registration.ITEMS.getEntries()) {
					pOutput.accept(item.get());
				}
			})
			.build());

	public static ItemLike makeIcon() {
		return (ItemLike) ModItems.LIGHT_BLUE_GLAZED_SHARD.get();
    }

	public static void register(IEventBus eventBus)
	{
		Registration.TABS.register(eventBus);
	}
}