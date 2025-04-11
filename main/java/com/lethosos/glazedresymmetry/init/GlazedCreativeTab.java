package com.lethosos.glazedresymmetry.init;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

import com.lethosos.glazedresymmetry.GlazedResymmetry;
import com.lethosos.glazedresymmetry.Registration;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

public class GlazedCreativeTab {
	public static final DeferredRegister<CreativeModeTab> TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Registration.MOD_ID);
	
	public static List<Item> TabList = new ArrayList<Item>();
	public static List<Item> TabList2 = new ArrayList<Item>();
	
	public static final Supplier<CreativeModeTab> TAB_KEY = TABS.register("glazed_tab",
			() -> CreativeModeTab.builder()
			.title(Component.translatable("itemGroup.glazedresymmetry"))
			.icon(() -> new ItemStack(randomIcon()))
			.displayItems((itemDisplayParameters, output) -> {
				if (!TabList.isEmpty()) {
					TabList.forEach((item) -> output.accept(item));
					GlazedResymmetry.LOGGER.info("Glazed Creative Tab List is loaded!");
				}
			})
			.build());

	public static void register(IEventBus eventBus)
	{
		TABS.register(eventBus);
	}
	
	private static Item randomIcon() {
		int min = 0, max = GlazedBlocks.groupList.size() - 1;
		return GlazedBlocks.groupList.get(min + (int)(Math.random() * ((max - min) + 1))).SHARD.get();
	}
}