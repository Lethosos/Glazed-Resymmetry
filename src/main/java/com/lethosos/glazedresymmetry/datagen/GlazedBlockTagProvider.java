package com.lethosos.glazedresymmetry.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import com.lethosos.glazedresymmetry.GlazedResymmetry;
import com.lethosos.glazedresymmetry.init.GlazedBlocks;
import com.lethosos.glazedresymmetry.init.util.GlazedGroup;

import java.util.concurrent.CompletableFuture;

public class GlazedBlockTagProvider extends BlockTagsProvider {
    public GlazedBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, GlazedResymmetry.MOD_ID, existingFileHelper);
    }

    @Override
	protected void addTags(HolderLookup.Provider provider) {
    	DataGenerators.dataList.forEach((group) -> {
    		if (group.groupName != "glazed") { pushBlockTags(group); }
    		//Clayworks compat only
    		else {
    			tag(BlockTags.MINEABLE_WITH_PICKAXE)
					.addOptional(ResourceLocation.fromNamespaceAndPath(GlazedResymmetry.MOD_ID, "glazed_terracotta_slab"))
					.addOptional(ResourceLocation.fromNamespaceAndPath(GlazedResymmetry.MOD_ID, "centered_glazed_terracotta"))
					.addOptional(ResourceLocation.fromNamespaceAndPath(GlazedResymmetry.MOD_ID, "centered_glazed_terracotta_slab"))
					.addOptional(ResourceLocation.fromNamespaceAndPath(GlazedResymmetry.MOD_ID, "glazed_terracotta_pillar"))
					.addOptional(ResourceLocation.fromNamespaceAndPath(GlazedResymmetry.MOD_ID, "glazed_terracotta_pillar_slab"))
					.addOptional(ResourceLocation.fromNamespaceAndPath(GlazedResymmetry.MOD_ID, "glazed_terracotta_side_pillar_slab"))

					.addOptional(ResourceLocation.fromNamespaceAndPath(GlazedResymmetry.MOD_ID, "glazed_glass"))
					.addOptional(ResourceLocation.fromNamespaceAndPath(GlazedResymmetry.MOD_ID, "centered_glazed_glass"))
					.addOptional(ResourceLocation.fromNamespaceAndPath(GlazedResymmetry.MOD_ID, "glazed_glass_pillar"))
					.addOptional(ResourceLocation.fromNamespaceAndPath(GlazedResymmetry.MOD_ID, "glazed_glass_pane"))
					.addOptional(ResourceLocation.fromNamespaceAndPath(GlazedResymmetry.MOD_ID, "centered_glazed_glass_pane"))
					.addOptional(ResourceLocation.fromNamespaceAndPath(GlazedResymmetry.MOD_ID, "glazed_glass_pane_pillar_top"))
					.addOptional(ResourceLocation.fromNamespaceAndPath(GlazedResymmetry.MOD_ID, "glazed_glass_pane_side_pillar"));
    			
    			tag(BlockTags.FLOWER_POTS).addOptional(ResourceLocation.fromNamespaceAndPath(GlazedResymmetry.MOD_ID, "glazed_flower_pot"));
    		}
    	});
    	
    	tag(BlockTags.MINEABLE_WITH_PICKAXE)
    		.add(GlazedBlocks.FLOWERING_GLASS.get())
    		.add(GlazedBlocks.FLOWERING_GLASS_SIDE_PANE.get())
    		.add(GlazedBlocks.FLOWERING_GLASS_TOP_PANE.get());
    }
    
	/**
	 * Takes in a GlazedGroup and spits out block tag listings that include them.
	 * MINEABLE_WITH_PICKAXE and FLOWER_POTS are used.
	 * 
	 * @param group The GlazedGroup to pass.
	 */
    public void pushBlockTags(GlazedGroup group) {
 		tag(BlockTags.MINEABLE_WITH_PICKAXE)
			.add(group.SLAB.get())
			.add(group.CENTERED.get())
			.add(group.CENTERED_SLAB.get())
			.add(group.PILLAR.get())
			.add(group.PILLAR_SLAB.get())
			.add(group.SIDE_PILLAR_SLAB.get())

			.add(group.GLASS.GLAZED.get())
			.add(group.GLASS.CENTERED.get())
			.add(group.GLASS.PILLAR.get())
			.add(group.GLASS.GLAZED_PANE.get())
			.add(group.GLASS.CENTERED_PANE.get())
			.add(group.GLASS.PILLAR_TOP_PANE.get())
			.add(group.GLASS.SIDE_PILLAR_PANE.get());
			
		tag(BlockTags.FLOWER_POTS).add(group.FLOWER_POT.get());
	}
}
