package com.lethosos.glazedresymmetry.init.util.datagen;

import java.util.Set;

import com.lethosos.glazedresymmetry.init.GlazedBlocks;

import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;

public class GlazedBlockLootTableProvider extends BlockLootSubProvider{

	protected GlazedBlockLootTableProvider(HolderLookup.Provider registries) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), registries);
    }

	@Override
	protected void generate() {
		DataGenerators.groupList.forEach((group) -> {
			dropSelf(group.CENTERED.get());
			dropSelf(group.PILLAR.get());
			
			add(group.SLAB.get(),
	                block -> createSlabItemTable(group.SLAB.get()));
			add(group.CENTERED_SLAB.get(),
	                block -> createSlabItemTable(group.CENTERED_SLAB.get()));
			add(group.PILLAR_SLAB.get(),
	                block -> createSlabItemTable(group.PILLAR_SLAB.get()));
			add(group.SIDE_PILLAR_SLAB.get(),
	                block -> createSlabItemTable(group.SIDE_PILLAR_SLAB.get()));
		});
	}
	
    @Override
    protected Iterable<Block> getKnownBlocks() {
        return GlazedBlocks.BLOCKS.getEntries().stream().map(Holder::value)::iterator;
    }
}
