package com.lethosos.glazedresymmetry.datagen.loot;

import java.util.function.BiConsumer;

import com.lethosos.glazedresymmetry.init.GlazedBlocks;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.loot.LootTableSubProvider;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;

public class GlazedLootTableSubProvider implements LootTableSubProvider{
	public static HolderLookup.Provider provider;
    public GlazedLootTableSubProvider(HolderLookup.Provider lookupProvider) {
        provider = lookupProvider;
    }
	
	@Override
	public void generate(BiConsumer<ResourceKey<LootTable>, LootTable.Builder> output) {
		output.accept(GlazedChestLootTables.SHIPWRECK_SUPPLY,  
			LootTable.lootTable()
				.withPool(LootPool.lootPool()
					.setRolls(ConstantValue.exactly(3.0f))
					.setBonusRolls(UniformGenerator.between(0, 3))
					.add(LootItem.lootTableItem(GlazedBlocks.WAXED_SHARD))
				)
		);
		output.accept(GlazedChestLootTables.UNDERWATER_RUIN_BIG, 
				LootTable.lootTable()
					.withPool(LootPool.lootPool()
						.setRolls(ConstantValue.exactly(3.0f))
						.setBonusRolls(UniformGenerator.between(0, 5))
						.add(LootItem.lootTableItem(GlazedBlocks.WAXED_SHARD))
					)
		);
		output.accept(GlazedChestLootTables.UNDERWATER_RUIN_SMALL, 
				LootTable.lootTable()
					.withPool(LootPool.lootPool()
						.setRolls(ConstantValue.exactly(2.0f))
						.setBonusRolls(UniformGenerator.between(0, 2))
						.add(LootItem.lootTableItem(GlazedBlocks.WAXED_SHARD))
					)
		);
		output.accept(GlazedChestLootTables.DESERT_PYRAMID, 
				LootTable.lootTable()
					.withPool(LootPool.lootPool()
						.setRolls(ConstantValue.exactly(5.0f))
						.setBonusRolls(UniformGenerator.between(0, 2))
						.add(LootItem.lootTableItem(GlazedBlocks.WAXED_SHARD))
					)
		);
		output.accept(GlazedChestLootTables.ANCIENT_CITY, 
				LootTable.lootTable()
					.withPool(LootPool.lootPool()
						.setRolls(ConstantValue.exactly(2.0f))
						.setBonusRolls(UniformGenerator.between(0, 4))
						.add(LootItem.lootTableItem(GlazedBlocks.WAXED_SHARD))
					)
		);
	}
}
