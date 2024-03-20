package com.lethosos.glazedresymmetry.init;

import com.lethosos.glazedresymmetry.Registration;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeTab {
    public static final RegistryObject<CreativeModeTab> TAB_KEY = Registration.TABS.register("glazed_tab",
			() -> CreativeModeTab.builder()
			.title(Component.translatable("itemGroup.glazedresymmetry"))
			.displayItems((pParemeters, pOutput) -> {
				for (RegistryObject<Item> item: Registration.ITEMS.getEntries()) {
					pOutput.accept(item.get());
				}
			})
			.icon(() -> new ItemStack(ModItems.LIGHT_BLUE_GLAZED_SHARD.get()))
			.build());

	public static void register(IEventBus eventBus)
	{
		Registration.TABS.register(eventBus);
	}
}