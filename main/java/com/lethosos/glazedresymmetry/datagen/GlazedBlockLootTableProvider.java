package com.lethosos.glazedresymmetry.datagen;

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
		DataGenerators.dataList.forEach((group) -> {
			if (group.groupName != "glazed")
			{
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
			
				dropSelf(group.FLOWER_POT.get());
				//dropPottedContents(group.FLOWER_POT.get());
				//group.pottedPots.forEach((pot) -> {
				//	dropPottedContents(pot.get());
				//});
				
				dropWhenSilkTouch(group.GLASS.GLAZED.get());
				dropWhenSilkTouch(group.GLASS.CENTERED.get());
				dropWhenSilkTouch(group.GLASS.PILLAR.get());
				
				dropWhenSilkTouch(group.GLASS.GLAZED_PANE.get());
				dropWhenSilkTouch(group.GLASS.CENTERED_PANE.get());
				dropWhenSilkTouch(group.GLASS.PILLAR_TOP_PANE.get());
				dropWhenSilkTouch(group.GLASS.SIDE_PILLAR_PANE.get());
			}
		});
		
		add(GlazedBlocks.AZALEA.get(), block -> noDrop());
		add(GlazedBlocks.BAMBOO.get(), block -> noDrop());
		add(GlazedBlocks.CACTUS.get(), block -> noDrop());
		add(GlazedBlocks.FLOWERING_AZALEA.get(), block -> noDrop());
	}
	
    @Override
    protected Iterable<Block> getKnownBlocks() {
        return GlazedBlocks.BLOCKS.getEntries().stream().map(Holder::value)::iterator;
    }
}
