package com.lethosos.glazedresymmetry.compat;

import java.util.HashMap;
import java.util.List;
import java.util.function.Supplier;

import com.lethosos.glazedresymmetry.Registration;
import com.lethosos.glazedresymmetry.init.GlazedCreativeTab;
import com.lethosos.glazedresymmetry.init.GlazedBlocks;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.neoforged.bus.api.IEventBus;

public class CompatCreativeTab {
	public static HashMap<String, List<ItemLike>> tabContents = new HashMap<String, List<ItemLike>>();
	
    public static final Supplier<CreativeModeTab> TAB_KEY2 = GlazedCreativeTab.TABS.register("compat_tab",
			() -> CreativeModeTab.builder()
			.withTabsBefore(ResourceLocation.fromNamespaceAndPath(Registration.MOD_ID, "glazed_tab"))
			.title(Component.translatable("itemGroup.glazedresymmetry.compat"))
			.icon(() -> new ItemStack(GlazedBlocks.BLACK.SHARD.get()))
			.build());

	public static void register(IEventBus eventBus)
	{
		GlazedCreativeTab.TABS.register(eventBus);
	}
}
