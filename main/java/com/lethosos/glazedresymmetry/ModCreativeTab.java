package com.lethosos.glazedresymmetry;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModCreativeTab extends CreativeModeTab {
    private ModCreativeTab(int index, String label) {
        super(index, label);
    }

    @Override
    public ItemStack makeIcon() {
        return new ItemStack(ModItems.LIGHT_BLUE_GLAZED_SHARD.get());
    }
    
    public static final ModCreativeTab instance = new ModCreativeTab(CreativeModeTab.TABS.length, "glazedresymmetry");
}
