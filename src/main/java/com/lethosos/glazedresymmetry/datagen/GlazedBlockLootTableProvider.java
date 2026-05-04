package com.lethosos.glazedresymmetry.datagen;

import java.util.Set;

import com.lethosos.glazedresymmetry.compat.ClayworksCompat;
import com.lethosos.glazedresymmetry.init.GlazedBlocks;
import com.lethosos.glazedresymmetry.init.util.GlazedGroup;

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
			if (group.groupName != "glazed") { pushLootTable(group); }
			//Clayworks compat only
			else
			{
				dropSelf(ClayworksCompat.GLAZED.CENTERED.get());
				dropSelf(ClayworksCompat.GLAZED.PILLAR.get());
			
				add(ClayworksCompat.GLAZED.SLAB.get(),
	                block -> createSlabItemTable(ClayworksCompat.GLAZED.SLAB.get()));
				add(ClayworksCompat.GLAZED.CENTERED_SLAB.get(),
	                block -> createSlabItemTable(ClayworksCompat.GLAZED.CENTERED_SLAB.get()));
				add(ClayworksCompat.GLAZED.PILLAR_SLAB.get(),
	                block -> createSlabItemTable(ClayworksCompat.GLAZED.PILLAR_SLAB.get()));
				add(ClayworksCompat.GLAZED.SIDE_PILLAR_SLAB.get(),
	                block -> createSlabItemTable(ClayworksCompat.GLAZED.SIDE_PILLAR_SLAB.get()));
			
				dropSelf(ClayworksCompat.GLAZED.FLOWER_POT.get());
				
				dropWhenSilkTouch(ClayworksCompat.GLAZED.GLASS.GLAZED.get());
				dropWhenSilkTouch(ClayworksCompat.GLAZED.GLASS.CENTERED.get());
				dropWhenSilkTouch(ClayworksCompat.GLAZED.GLASS.PILLAR.get());
				
				dropWhenSilkTouch(ClayworksCompat.GLAZED.GLASS.GLAZED_PANE.get());
				dropWhenSilkTouch(ClayworksCompat.GLAZED.GLASS.CENTERED_PANE.get());
				dropWhenSilkTouch(ClayworksCompat.GLAZED.GLASS.PILLAR_TOP_PANE.get());
				dropWhenSilkTouch(ClayworksCompat.GLAZED.GLASS.SIDE_PILLAR_PANE.get());
				
				add(ClayworksCompat.GLAZED.GLASS.glazed1.get(), 
					this.createSilkTouchOnlyTable(ClayworksCompat.GLAZED.GLASS.GLAZED_PANE.get()));
				add(ClayworksCompat.GLAZED.GLASS.glazed2.get(), 
					this.createSilkTouchOnlyTable(ClayworksCompat.GLAZED.GLASS.GLAZED_PANE.get()));
				add(ClayworksCompat.GLAZED.GLASS.glazed3.get(), 
					this.createSilkTouchOnlyTable(ClayworksCompat.GLAZED.GLASS.GLAZED_PANE.get()));
				add(ClayworksCompat.GLAZED.GLASS.side1.get(), 
					this.createSilkTouchOnlyTable(ClayworksCompat.GLAZED.GLASS.SIDE_PILLAR_PANE.get()));
			}
		});
		
		dropWhenSilkTouch(GlazedBlocks.FLOWERING_GLASS.get());
		dropWhenSilkTouch(GlazedBlocks.FLOWERING_GLASS_SIDE_PANE.get());
		dropWhenSilkTouch(GlazedBlocks.FLOWERING_GLASS_TOP_PANE.get());
		
		add(GlazedBlocks.AZALEA.get(), block -> noDrop());
		add(GlazedBlocks.BAMBOO.get(), block -> noDrop());
		add(GlazedBlocks.CACTUS.get(), block -> noDrop());
		add(GlazedBlocks.FLOWERING_AZALEA.get(), block -> noDrop());
	}
	
	/**
	 * Takes in a GlazedGroup and spits out the drop tables for each item.
	 * 
	 * @param group The GlazedGroup to pass.
	 */
	public void pushLootTable(GlazedGroup group) {
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
		
		dropWhenSilkTouch(group.GLASS.GLAZED.get());
		dropWhenSilkTouch(group.GLASS.CENTERED.get());
		dropWhenSilkTouch(group.GLASS.PILLAR.get());
		
		dropWhenSilkTouch(group.GLASS.GLAZED_PANE.get());
		dropWhenSilkTouch(group.GLASS.CENTERED_PANE.get());
		dropWhenSilkTouch(group.GLASS.PILLAR_TOP_PANE.get());
		dropWhenSilkTouch(group.GLASS.SIDE_PILLAR_PANE.get());
		
		add(group.GLASS.glazed1.get(), this.createSilkTouchOnlyTable(group.GLASS.GLAZED_PANE.get()));
		add(group.GLASS.glazed2.get(), this.createSilkTouchOnlyTable(group.GLASS.GLAZED_PANE.get()));
		add(group.GLASS.glazed3.get(), this.createSilkTouchOnlyTable(group.GLASS.GLAZED_PANE.get()));
		add(group.GLASS.side1.get(), this.createSilkTouchOnlyTable(group.GLASS.SIDE_PILLAR_PANE.get()));
	}
	
    @Override
    protected Iterable<Block> getKnownBlocks() {
        return GlazedBlocks.BLOCKS.getEntries().stream().map(Holder::value)::iterator;
    }
}
