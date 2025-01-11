package com.lethosos.glazedresymmetry.compat;

import java.util.HashMap;
import java.util.List;
import com.lethosos.glazedresymmetry.Registration;
import com.lethosos.glazedresymmetry.init.GlazedItems;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.RegistryObject;

public class CompatCreativeTab {
	public static HashMap<String, List<ItemLike>> tabContents = new HashMap<String, List<ItemLike>>();
	
    public static final RegistryObject<CreativeModeTab> TAB_KEY2 = Registration.TABS.register("compat_tab",
			() -> CreativeModeTab.builder()
			.title(Component.translatable("itemGroup.glazedresymmetry.compat"))
			.icon(() -> new ItemStack(GlazedItems.BLACK_GLAZED_SHARD.get()))
			.build());

	public static void register(IEventBus eventBus)
	{
		Registration.TABS.register(eventBus);
	}
}
