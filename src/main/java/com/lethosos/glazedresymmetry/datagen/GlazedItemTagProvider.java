package com.lethosos.glazedresymmetry.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import com.lethosos.glazedresymmetry.GlazedResymmetry;
import com.lethosos.glazedresymmetry.init.GlazedBlocks;
import com.lethosos.glazedresymmetry.init.util.GlazedTags;

import java.util.concurrent.CompletableFuture;

public class GlazedItemTagProvider extends ItemTagsProvider {
    public GlazedItemTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider,
            CompletableFuture<TagLookup<Block>> blockTags, @Nullable ExistingFileHelper existingFileHelper) {
    	super(output, lookupProvider, blockTags, GlazedResymmetry.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
    	tag(ItemTags.DURABILITY_ENCHANTABLE).add(GlazedBlocks.GLASSCUTTER_TOOL.get());
    	
   		tag(GlazedTags.Items.WHITE_SLABS)
   			.add(GlazedBlocks.WHITE.SLAB.asItem())
            .add(GlazedBlocks.WHITE.CENTERED_SLAB.asItem())
            .add(GlazedBlocks.WHITE.PILLAR_SLAB.asItem())
            .add(GlazedBlocks.WHITE.SIDE_PILLAR_SLAB.asItem());
   		tag(GlazedTags.Items.WHITE_BLOCKS)
   			.add(GlazedBlocks.WHITE.CENTERED.asItem())
            .add(GlazedBlocks.WHITE.PILLAR.asItem());
   		tag(GlazedTags.Items.WHITE_GLASS)
			.add(GlazedBlocks.WHITE.GLASS.GLAZED.asItem())
			.add(GlazedBlocks.WHITE.GLASS.CENTERED.asItem())
			.add(GlazedBlocks.WHITE.GLASS.PILLAR.asItem());
		tag(GlazedTags.Items.WHITE_PANES)
			.add(GlazedBlocks.WHITE.GLASS.CENTERED_PANE.asItem())
			.add(GlazedBlocks.WHITE.GLASS.PILLAR_TOP_PANE.asItem())
   			.add(GlazedBlocks.WHITE.GLASS.SIDE_PILLAR_PANE.asItem());
   		
   		tag(GlazedTags.Items.LIGHT_GRAY_SLABS)
			.add(GlazedBlocks.LIGHT_GRAY.SLAB.asItem())
			.add(GlazedBlocks.LIGHT_GRAY.CENTERED_SLAB.asItem())
        	.add(GlazedBlocks.LIGHT_GRAY.PILLAR_SLAB.asItem())
        	.add(GlazedBlocks.LIGHT_GRAY.SIDE_PILLAR_SLAB.asItem());
		tag(GlazedTags.Items.LIGHT_GRAY_BLOCKS)
			.add(GlazedBlocks.LIGHT_GRAY.CENTERED.asItem())
			.add(GlazedBlocks.LIGHT_GRAY.PILLAR.asItem());
   		tag(GlazedTags.Items.LIGHT_GRAY_GLASS)
			.add(GlazedBlocks.LIGHT_GRAY.GLASS.GLAZED.asItem())
			.add(GlazedBlocks.LIGHT_GRAY.GLASS.CENTERED.asItem())
			.add(GlazedBlocks.LIGHT_GRAY.GLASS.PILLAR.asItem());
		tag(GlazedTags.Items.LIGHT_GRAY_PANES)
			.add(GlazedBlocks.LIGHT_GRAY.GLASS.CENTERED_PANE.asItem())
			.add(GlazedBlocks.LIGHT_GRAY.GLASS.PILLAR_TOP_PANE.asItem())
   			.add(GlazedBlocks.LIGHT_GRAY.GLASS.SIDE_PILLAR_PANE.asItem());
		
   		tag(GlazedTags.Items.GRAY_SLABS)
			.add(GlazedBlocks.GRAY.SLAB.asItem())
			.add(GlazedBlocks.GRAY.CENTERED_SLAB.asItem())
			.add(GlazedBlocks.GRAY.PILLAR_SLAB.asItem())
			.add(GlazedBlocks.GRAY.SIDE_PILLAR_SLAB.asItem());
		tag(GlazedTags.Items.GRAY_BLOCKS)
			.add(GlazedBlocks.GRAY.CENTERED.asItem())
			.add(GlazedBlocks.GRAY.PILLAR.asItem());
   		tag(GlazedTags.Items.GRAY_GLASS)
			.add(GlazedBlocks.GRAY.GLASS.GLAZED.asItem())
			.add(GlazedBlocks.GRAY.GLASS.CENTERED.asItem())
			.add(GlazedBlocks.GRAY.GLASS.PILLAR.asItem());
		tag(GlazedTags.Items.GRAY_PANES)
			.add(GlazedBlocks.GRAY.GLASS.CENTERED_PANE.asItem())
			.add(GlazedBlocks.GRAY.GLASS.PILLAR_TOP_PANE.asItem())
   			.add(GlazedBlocks.GRAY.GLASS.SIDE_PILLAR_PANE.asItem());
		
   		tag(GlazedTags.Items.BLACK_SLABS)
			.add(GlazedBlocks.BLACK.SLAB.asItem())
			.add(GlazedBlocks.BLACK.CENTERED_SLAB.asItem())
			.add(GlazedBlocks.BLACK.PILLAR_SLAB.asItem())
			.add(GlazedBlocks.BLACK.SIDE_PILLAR_SLAB.asItem());
		tag(GlazedTags.Items.BLACK_BLOCKS)
			.add(GlazedBlocks.BLACK.CENTERED.asItem())
			.add(GlazedBlocks.BLACK.PILLAR.asItem());
   		tag(GlazedTags.Items.BLACK_GLASS)
			.add(GlazedBlocks.BLACK.GLASS.GLAZED.asItem())
			.add(GlazedBlocks.BLACK.GLASS.CENTERED.asItem())
			.add(GlazedBlocks.BLACK.GLASS.PILLAR.asItem());
		tag(GlazedTags.Items.BLACK_PANES)
			.add(GlazedBlocks.BLACK.GLASS.CENTERED_PANE.asItem())
			.add(GlazedBlocks.BLACK.GLASS.PILLAR_TOP_PANE.asItem())
   			.add(GlazedBlocks.BLACK.GLASS.SIDE_PILLAR_PANE.asItem());
		
   		tag(GlazedTags.Items.BROWN_SLABS)
			.add(GlazedBlocks.BROWN.SLAB.asItem())
			.add(GlazedBlocks.BROWN.CENTERED_SLAB.asItem())
        	.add(GlazedBlocks.BROWN.PILLAR_SLAB.asItem())
        	.add(GlazedBlocks.BROWN.SIDE_PILLAR_SLAB.asItem());
		tag(GlazedTags.Items.BROWN_BLOCKS)
			.add(GlazedBlocks.BROWN.CENTERED.asItem())
			.add(GlazedBlocks.BROWN.PILLAR.asItem());
   		tag(GlazedTags.Items.BROWN_GLASS)
			.add(GlazedBlocks.BROWN.GLASS.GLAZED.asItem())
			.add(GlazedBlocks.BROWN.GLASS.CENTERED.asItem())
			.add(GlazedBlocks.BROWN.GLASS.PILLAR.asItem());
		tag(GlazedTags.Items.BROWN_PANES)
			.add(GlazedBlocks.BROWN.GLASS.CENTERED_PANE.asItem())
			.add(GlazedBlocks.BROWN.GLASS.PILLAR_TOP_PANE.asItem())
   			.add(GlazedBlocks.BROWN.GLASS.SIDE_PILLAR_PANE.asItem());

   		tag(GlazedTags.Items.RED_SLABS)
			.add(GlazedBlocks.RED.SLAB.asItem())
			.add(GlazedBlocks.RED.CENTERED_SLAB.asItem())
			.add(GlazedBlocks.RED.PILLAR_SLAB.asItem())
			.add(GlazedBlocks.RED.SIDE_PILLAR_SLAB.asItem());
		tag(GlazedTags.Items.RED_BLOCKS)
			.add(GlazedBlocks.RED.CENTERED.asItem())
			.add(GlazedBlocks.RED.PILLAR.asItem());
   		tag(GlazedTags.Items.RED_GLASS)
			.add(GlazedBlocks.RED.GLASS.GLAZED.asItem())
			.add(GlazedBlocks.RED.GLASS.CENTERED.asItem())
			.add(GlazedBlocks.RED.GLASS.PILLAR.asItem());
		tag(GlazedTags.Items.RED_PANES)
			.add(GlazedBlocks.RED.GLASS.CENTERED_PANE.asItem())
			.add(GlazedBlocks.RED.GLASS.PILLAR_TOP_PANE.asItem())
   			.add(GlazedBlocks.RED.GLASS.SIDE_PILLAR_PANE.asItem());
		
   		tag(GlazedTags.Items.ORANGE_SLABS)
			.add(GlazedBlocks.ORANGE.SLAB.asItem())
			.add(GlazedBlocks.ORANGE.CENTERED_SLAB.asItem())
        	.add(GlazedBlocks.ORANGE.PILLAR_SLAB.asItem())
        	.add(GlazedBlocks.ORANGE.SIDE_PILLAR_SLAB.asItem());
		tag(GlazedTags.Items.ORANGE_BLOCKS)
			.add(GlazedBlocks.ORANGE.CENTERED.asItem())
			.add(GlazedBlocks.ORANGE.PILLAR.asItem());
   		tag(GlazedTags.Items.ORANGE_GLASS)
			.add(GlazedBlocks.ORANGE.GLASS.GLAZED.asItem())
			.add(GlazedBlocks.ORANGE.GLASS.CENTERED.asItem())
			.add(GlazedBlocks.ORANGE.GLASS.PILLAR.asItem());
		tag(GlazedTags.Items.ORANGE_PANES)
			.add(GlazedBlocks.ORANGE.GLASS.CENTERED_PANE.asItem())
			.add(GlazedBlocks.ORANGE.GLASS.PILLAR_TOP_PANE.asItem())
   			.add(GlazedBlocks.ORANGE.GLASS.SIDE_PILLAR_PANE.asItem());
		
   		tag(GlazedTags.Items.YELLOW_SLABS)
			.add(GlazedBlocks.YELLOW.SLAB.asItem())
			.add(GlazedBlocks.YELLOW.CENTERED_SLAB.asItem())
        	.add(GlazedBlocks.YELLOW.PILLAR_SLAB.asItem())
        	.add(GlazedBlocks.YELLOW.SIDE_PILLAR_SLAB.asItem());
		tag(GlazedTags.Items.YELLOW_BLOCKS)
			.add(GlazedBlocks.YELLOW.CENTERED.asItem())
			.add(GlazedBlocks.YELLOW.PILLAR.asItem());
   		tag(GlazedTags.Items.YELLOW_GLASS)
			.add(GlazedBlocks.YELLOW.GLASS.GLAZED.asItem())
			.add(GlazedBlocks.YELLOW.GLASS.CENTERED.asItem())
			.add(GlazedBlocks.YELLOW.GLASS.PILLAR.asItem());
		tag(GlazedTags.Items.YELLOW_PANES)
			.add(GlazedBlocks.YELLOW.GLASS.CENTERED_PANE.asItem())
			.add(GlazedBlocks.YELLOW.GLASS.PILLAR_TOP_PANE.asItem())
   			.add(GlazedBlocks.YELLOW.GLASS.SIDE_PILLAR_PANE.asItem());
		
   		tag(GlazedTags.Items.LIME_SLABS)
			.add(GlazedBlocks.LIME.SLAB.asItem())
			.add(GlazedBlocks.LIME.CENTERED_SLAB.asItem())
        	.add(GlazedBlocks.LIME.PILLAR_SLAB.asItem())
        	.add(GlazedBlocks.LIME.SIDE_PILLAR_SLAB.asItem());
		tag(GlazedTags.Items.LIME_BLOCKS)
			.add(GlazedBlocks.LIME.CENTERED.asItem())
			.add(GlazedBlocks.LIME.PILLAR.asItem());
   		tag(GlazedTags.Items.LIME_GLASS)
			.add(GlazedBlocks.LIME.GLASS.GLAZED.asItem())
			.add(GlazedBlocks.LIME.GLASS.CENTERED.asItem())
			.add(GlazedBlocks.LIME.GLASS.PILLAR.asItem());
		tag(GlazedTags.Items.LIME_PANES)
			.add(GlazedBlocks.LIME.GLASS.CENTERED_PANE.asItem())
			.add(GlazedBlocks.LIME.GLASS.PILLAR_TOP_PANE.asItem())
   			.add(GlazedBlocks.LIME.GLASS.SIDE_PILLAR_PANE.asItem());
		
   		tag(GlazedTags.Items.GREEN_SLABS)
			.add(GlazedBlocks.GREEN.SLAB.asItem())
			.add(GlazedBlocks.GREEN.CENTERED_SLAB.asItem())
        	.add(GlazedBlocks.GREEN.PILLAR_SLAB.asItem())
        	.add(GlazedBlocks.GREEN.SIDE_PILLAR_SLAB.asItem());
		tag(GlazedTags.Items.GREEN_BLOCKS)
			.add(GlazedBlocks.GREEN.CENTERED.asItem())
			.add(GlazedBlocks.GREEN.PILLAR.asItem());
   		tag(GlazedTags.Items.GREEN_GLASS)
			.add(GlazedBlocks.GREEN.GLASS.GLAZED.asItem())
			.add(GlazedBlocks.GREEN.GLASS.CENTERED.asItem())
			.add(GlazedBlocks.GREEN.GLASS.PILLAR.asItem());
		tag(GlazedTags.Items.GREEN_PANES)
			.add(GlazedBlocks.GREEN.GLASS.CENTERED_PANE.asItem())
			.add(GlazedBlocks.GREEN.GLASS.PILLAR_TOP_PANE.asItem())
   			.add(GlazedBlocks.GREEN.GLASS.SIDE_PILLAR_PANE.asItem());
		
   		tag(GlazedTags.Items.CYAN_SLABS)
			.add(GlazedBlocks.CYAN.SLAB.asItem())
			.add(GlazedBlocks.CYAN.CENTERED_SLAB.asItem())
        	.add(GlazedBlocks.CYAN.PILLAR_SLAB.asItem())
        	.add(GlazedBlocks.CYAN.SIDE_PILLAR_SLAB.asItem());
		tag(GlazedTags.Items.CYAN_BLOCKS)
			.add(GlazedBlocks.CYAN.CENTERED.asItem())
			.add(GlazedBlocks.CYAN.PILLAR.asItem());
   		tag(GlazedTags.Items.CYAN_GLASS)
			.add(GlazedBlocks.CYAN.GLASS.GLAZED.asItem())
			.add(GlazedBlocks.CYAN.GLASS.CENTERED.asItem())
			.add(GlazedBlocks.CYAN.GLASS.PILLAR.asItem());
		tag(GlazedTags.Items.CYAN_PANES)
			.add(GlazedBlocks.CYAN.GLASS.CENTERED_PANE.asItem())
			.add(GlazedBlocks.CYAN.GLASS.PILLAR_TOP_PANE.asItem())
   			.add(GlazedBlocks.CYAN.GLASS.SIDE_PILLAR_PANE.asItem());
		
   		tag(GlazedTags.Items.LIGHT_BLUE_SLABS)
			.add(GlazedBlocks.LIGHT_BLUE.SLAB.asItem())
			.add(GlazedBlocks.LIGHT_BLUE.CENTERED_SLAB.asItem())
        	.add(GlazedBlocks.LIGHT_BLUE.PILLAR_SLAB.asItem())
        	.add(GlazedBlocks.LIGHT_BLUE.SIDE_PILLAR_SLAB.asItem());
		tag(GlazedTags.Items.LIGHT_BLUE_BLOCKS)
			.add(GlazedBlocks.LIGHT_BLUE.CENTERED.asItem())
			.add(GlazedBlocks.LIGHT_BLUE.PILLAR.asItem());
   		tag(GlazedTags.Items.LIGHT_BLUE_GLASS)
			.add(GlazedBlocks.LIGHT_BLUE.GLASS.GLAZED.asItem())
			.add(GlazedBlocks.LIGHT_BLUE.GLASS.CENTERED.asItem())
			.add(GlazedBlocks.LIGHT_BLUE.GLASS.PILLAR.asItem());
		tag(GlazedTags.Items.LIGHT_BLUE_PANES)
			.add(GlazedBlocks.LIGHT_BLUE.GLASS.CENTERED_PANE.asItem())
			.add(GlazedBlocks.LIGHT_BLUE.GLASS.PILLAR_TOP_PANE.asItem())
   			.add(GlazedBlocks.LIGHT_BLUE.GLASS.SIDE_PILLAR_PANE.asItem());
		
   		tag(GlazedTags.Items.BLUE_SLABS)
			.add(GlazedBlocks.BLUE.SLAB.asItem())
			.add(GlazedBlocks.BLUE.CENTERED_SLAB.asItem())
        	.add(GlazedBlocks.BLUE.PILLAR_SLAB.asItem())
        	.add(GlazedBlocks.BLUE.SIDE_PILLAR_SLAB.asItem());
		tag(GlazedTags.Items.BLUE_BLOCKS)
			.add(GlazedBlocks.BLUE.CENTERED.asItem())
			.add(GlazedBlocks.BLUE.PILLAR.asItem());
   		tag(GlazedTags.Items.BLUE_GLASS)
			.add(GlazedBlocks.BLUE.GLASS.GLAZED.asItem())
			.add(GlazedBlocks.BLUE.GLASS.CENTERED.asItem())
			.add(GlazedBlocks.BLUE.GLASS.PILLAR.asItem());
		tag(GlazedTags.Items.BLUE_PANES)
			.add(GlazedBlocks.BLUE.GLASS.CENTERED_PANE.asItem())
			.add(GlazedBlocks.BLUE.GLASS.PILLAR_TOP_PANE.asItem())
   			.add(GlazedBlocks.BLUE.GLASS.SIDE_PILLAR_PANE.asItem());
		
   		tag(GlazedTags.Items.MAGENTA_SLABS)
			.add(GlazedBlocks.MAGENTA.SLAB.asItem())
			.add(GlazedBlocks.MAGENTA.CENTERED_SLAB.asItem())
        	.add(GlazedBlocks.MAGENTA.PILLAR_SLAB.asItem())
        	.add(GlazedBlocks.MAGENTA.SIDE_PILLAR_SLAB.asItem());
		tag(GlazedTags.Items.MAGENTA_BLOCKS)
			.add(GlazedBlocks.MAGENTA.CENTERED.asItem())
			.add(GlazedBlocks.MAGENTA.PILLAR.asItem());
   		tag(GlazedTags.Items.MAGENTA_GLASS)
			.add(GlazedBlocks.MAGENTA.GLASS.GLAZED.asItem())
			.add(GlazedBlocks.MAGENTA.GLASS.CENTERED.asItem())
			.add(GlazedBlocks.MAGENTA.GLASS.PILLAR.asItem());
		tag(GlazedTags.Items.MAGENTA_PANES)
			.add(GlazedBlocks.MAGENTA.GLASS.CENTERED_PANE.asItem())
			.add(GlazedBlocks.MAGENTA.GLASS.PILLAR_TOP_PANE.asItem())
   			.add(GlazedBlocks.MAGENTA.GLASS.SIDE_PILLAR_PANE.asItem());
		
   		tag(GlazedTags.Items.PURPLE_SLABS)
			.add(GlazedBlocks.PURPLE.SLAB.asItem())
			.add(GlazedBlocks.PURPLE.CENTERED_SLAB.asItem())
        	.add(GlazedBlocks.PURPLE.PILLAR_SLAB.asItem())
        	.add(GlazedBlocks.PURPLE.SIDE_PILLAR_SLAB.asItem());
		tag(GlazedTags.Items.PURPLE_BLOCKS)
			.add(GlazedBlocks.PURPLE.CENTERED.asItem())
			.add(GlazedBlocks.PURPLE.PILLAR.asItem());
   		tag(GlazedTags.Items.PURPLE_GLASS)
			.add(GlazedBlocks.PURPLE.GLASS.GLAZED.asItem())
			.add(GlazedBlocks.PURPLE.GLASS.CENTERED.asItem())
			.add(GlazedBlocks.PURPLE.GLASS.PILLAR.asItem());
		tag(GlazedTags.Items.PURPLE_PANES)
			.add(GlazedBlocks.PURPLE.GLASS.CENTERED_PANE.asItem())
			.add(GlazedBlocks.PURPLE.GLASS.PILLAR_TOP_PANE.asItem())
   			.add(GlazedBlocks.PURPLE.GLASS.SIDE_PILLAR_PANE.asItem());
		
   		tag(GlazedTags.Items.PINK_SLABS)
			.add(GlazedBlocks.PINK.SLAB.asItem())
			.add(GlazedBlocks.PINK.CENTERED_SLAB.asItem())
        	.add(GlazedBlocks.PINK.PILLAR_SLAB.asItem())
        	.add(GlazedBlocks.PINK.SIDE_PILLAR_SLAB.asItem());
		tag(GlazedTags.Items.PINK_BLOCKS)
			.add(GlazedBlocks.PINK.CENTERED.asItem())
			.add(GlazedBlocks.PINK.PILLAR.asItem());
   		tag(GlazedTags.Items.PINK_GLASS)
			.add(GlazedBlocks.PINK.GLASS.GLAZED.asItem())
			.add(GlazedBlocks.PINK.GLASS.CENTERED.asItem())
			.add(GlazedBlocks.PINK.GLASS.PILLAR.asItem());
		tag(GlazedTags.Items.PINK_PANES)
			.add(GlazedBlocks.PINK.GLASS.CENTERED_PANE.asItem())
			.add(GlazedBlocks.PINK.GLASS.PILLAR_TOP_PANE.asItem())
   			.add(GlazedBlocks.PINK.GLASS.SIDE_PILLAR_PANE.asItem());
		
		if ( GlazedResymmetry.CLAYWORKS == true )
		{
	   		tag(GlazedTags.Items.GLAZED_SLABS)
	   			.addOptional(ResourceLocation.fromNamespaceAndPath(GlazedResymmetry.MOD_ID, "glazed_terracotta_slab"))
	   			.addOptional(ResourceLocation.fromNamespaceAndPath(GlazedResymmetry.MOD_ID, "centered_glazed_terracotta_slab"))
	   			.addOptional(ResourceLocation.fromNamespaceAndPath(GlazedResymmetry.MOD_ID, "glazed_terracotta_pillar_slab"))
	   			.addOptional(ResourceLocation.fromNamespaceAndPath(GlazedResymmetry.MOD_ID, "glazed_terracotta_side_pillar_slab"));
			tag(GlazedTags.Items.GLAZED_BLOCKS)
				.addOptional(ResourceLocation.fromNamespaceAndPath(GlazedResymmetry.MOD_ID, "centered_glazed_terracotta"))
				.addOptional(ResourceLocation.fromNamespaceAndPath(GlazedResymmetry.MOD_ID, "glazed_terracotta_pillar"));
		}
		
		DataGenerators.dataList.forEach((group) -> {
			if (group.groupName == "glazed") {
				tag(GlazedTags.Items.ALL_SHARDS).addOptional(ResourceLocation.fromNamespaceAndPath(GlazedResymmetry.MOD_ID, "glazed_shard"));
			}
			else {
				tag(GlazedTags.Items.ALL_SHARDS).add(group.SHARD.asItem());
			}
    	});
    }
}
