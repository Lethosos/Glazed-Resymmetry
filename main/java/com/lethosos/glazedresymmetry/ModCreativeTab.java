package com.lethosos.glazedresymmetry;

import java.util.function.Supplier;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeTab extends CreativeModeTab {
    protected ModCreativeTab(Builder builder) {
		super(builder);
		// TODO Auto-generated constructor stub
	}

	@SuppressWarnings("unchecked")
	public static Supplier<ItemStack> makeIcon() {
        //return (Supplier<ItemStack>) ModItems.LIGHT_BLUE_GLAZED_SHARD.get();
		return (Supplier<ItemStack>) Items.LIGHT_BLUE_DYE.asItem();
    }
	
    //public static final ModCreativeTab instance = new ModCreativeTab(CreativeModeTab.builder().icon(null).title(Component.translatable("glazedresymmetry")));
	public static RegistryObject<CreativeModeTab> instance = Registration.TABS.register("base",
			() -> CreativeModeTab.builder()
				.title(Component.translatable("itemGroup.glazedresymmetry"))
				.withTabsBefore(CreativeModeTabs.SPAWN_EGGS)
				.icon(makeIcon())
				.build()
			);
}
