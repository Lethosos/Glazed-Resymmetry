package com.lethosos.glazedresymmetry.datagen.loot;

import java.util.concurrent.CompletableFuture;

import com.lethosos.glazedresymmetry.GlazedResymmetry;
import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.storage.loot.BuiltInLootTables;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.neoforged.neoforge.common.data.GlobalLootModifierProvider;
import net.neoforged.neoforge.common.loot.AddTableLootModifier;
import net.neoforged.neoforge.common.loot.LootTableIdCondition;

public class GlazedGlobalLootModifierProvider extends GlobalLootModifierProvider {

	public GlazedGlobalLootModifierProvider(PackOutput output, CompletableFuture<Provider> registries) {
		super(output, registries, GlazedResymmetry.MOD_ID);
	}

	@Override
	protected void start() {
		this.add("add_loot_shipwreck", this.addNewLootPool(BuiltInLootTables.SHIPWRECK_SUPPLY, GlazedChestLootTables.SHIPWRECK_SUPPLY));
		this.add("add_loot_underwater_big", this.addNewLootPool(BuiltInLootTables.UNDERWATER_RUIN_BIG, GlazedChestLootTables.UNDERWATER_RUIN_BIG));
		this.add("add_loot_underwater_small", this.addNewLootPool(BuiltInLootTables.UNDERWATER_RUIN_SMALL, GlazedChestLootTables.UNDERWATER_RUIN_SMALL));
		this.add("add_loot_pyramid", this.addNewLootPool(BuiltInLootTables.DESERT_PYRAMID, GlazedChestLootTables.DESERT_PYRAMID));
		this.add("add_loot_ancient_city", this.addNewLootPool(BuiltInLootTables.ANCIENT_CITY, GlazedChestLootTables.ANCIENT_CITY));
	}

	private AddTableLootModifier addNewLootPool(ResourceKey<LootTable> lootToAddTo, ResourceKey<LootTable> newPool) {
		return new AddTableLootModifier(new LootItemCondition[]{LootTableIdCondition.builder(lootToAddTo.location()).build()}, newPool);
	}
}
