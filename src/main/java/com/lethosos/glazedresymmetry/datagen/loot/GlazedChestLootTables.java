package com.lethosos.glazedresymmetry.datagen.loot;

import com.lethosos.glazedresymmetry.GlazedResymmetry;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.LootTable;

public class GlazedChestLootTables {
    public static final ResourceKey<LootTable> SHIPWRECK_SUPPLY = register("chests/shipwreck_supply");
	public static final ResourceKey<LootTable> UNDERWATER_RUIN_BIG = register("chests/underwater_ruin_big");
    public static final ResourceKey<LootTable> UNDERWATER_RUIN_SMALL = register("chests/underwater_ruin_small");
    public static final ResourceKey<LootTable> DESERT_PYRAMID = register("chests/desert_pyramid");
    public static final ResourceKey<LootTable> ANCIENT_CITY = register("chests/ancient_city");

    private static ResourceKey<LootTable> register(String id) {
        return ResourceKey.create(Registries.LOOT_TABLE, ResourceLocation.fromNamespaceAndPath(GlazedResymmetry.MOD_ID, id));
    }
}
