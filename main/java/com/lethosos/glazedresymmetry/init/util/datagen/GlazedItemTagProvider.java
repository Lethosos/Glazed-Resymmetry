package com.lethosos.glazedresymmetry.init.util.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import com.lethosos.glazedresymmetry.Registration;
import com.lethosos.glazedresymmetry.init.GlazedBlocks;
import com.lethosos.glazedresymmetry.init.util.GlazedTags;

import java.util.concurrent.CompletableFuture;

public class GlazedItemTagProvider extends ItemTagsProvider {
    public GlazedItemTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider,
            CompletableFuture<TagLookup<Block>> blockTags, @Nullable ExistingFileHelper existingFileHelper) {
    	super(output, lookupProvider, blockTags, Registration.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
   		tag(GlazedTags.Items.WHITE_SLABS)
   			.add(GlazedBlocks.WHITE.SLAB.asItem())
            .add(GlazedBlocks.WHITE.CENTERED_SLAB.asItem())
            .add(GlazedBlocks.WHITE.PILLAR_SLAB.asItem())
            .add(GlazedBlocks.WHITE.SIDE_PILLAR_SLAB.asItem());
   		tag(GlazedTags.Items.WHITE_BLOCKS)
   			.add(GlazedBlocks.WHITE.CENTERED.asItem())
            .add(GlazedBlocks.WHITE.PILLAR.asItem());
   		
   		tag(GlazedTags.Items.LIGHT_GRAY_SLABS)
			.add(GlazedBlocks.LIGHT_GRAY.SLAB.asItem())
			.add(GlazedBlocks.LIGHT_GRAY.CENTERED_SLAB.asItem())
        	.add(GlazedBlocks.LIGHT_GRAY.PILLAR_SLAB.asItem())
        	.add(GlazedBlocks.LIGHT_GRAY.SIDE_PILLAR_SLAB.asItem());
		tag(GlazedTags.Items.LIGHT_GRAY_BLOCKS)
			.add(GlazedBlocks.LIGHT_GRAY.CENTERED.asItem())
			.add(GlazedBlocks.LIGHT_GRAY.PILLAR.asItem());
		
   		tag(GlazedTags.Items.GRAY_SLABS)
			.add(GlazedBlocks.GRAY.SLAB.asItem())
			.add(GlazedBlocks.GRAY.CENTERED_SLAB.asItem())
			.add(GlazedBlocks.GRAY.PILLAR_SLAB.asItem())
			.add(GlazedBlocks.GRAY.SIDE_PILLAR_SLAB.asItem());
		tag(GlazedTags.Items.GRAY_BLOCKS)
			.add(GlazedBlocks.GRAY.CENTERED.asItem())
			.add(GlazedBlocks.GRAY.PILLAR.asItem());
		
   		tag(GlazedTags.Items.BLACK_SLABS)
			.add(GlazedBlocks.BLACK.SLAB.asItem())
			.add(GlazedBlocks.BLACK.CENTERED_SLAB.asItem())
			.add(GlazedBlocks.BLACK.PILLAR_SLAB.asItem())
			.add(GlazedBlocks.BLACK.SIDE_PILLAR_SLAB.asItem());
		tag(GlazedTags.Items.BLACK_BLOCKS)
			.add(GlazedBlocks.BLACK.CENTERED.asItem())
			.add(GlazedBlocks.BLACK.PILLAR.asItem());
		
   		tag(GlazedTags.Items.BROWN_SLABS)
			.add(GlazedBlocks.BROWN.SLAB.asItem())
			.add(GlazedBlocks.BROWN.CENTERED_SLAB.asItem())
        	.add(GlazedBlocks.BROWN.PILLAR_SLAB.asItem())
        	.add(GlazedBlocks.BROWN.SIDE_PILLAR_SLAB.asItem());
		tag(GlazedTags.Items.BROWN_BLOCKS)
			.add(GlazedBlocks.BROWN.CENTERED.asItem())
			.add(GlazedBlocks.BROWN.PILLAR.asItem());

   		tag(GlazedTags.Items.RED_SLABS)
			.add(GlazedBlocks.RED.SLAB.asItem())
			.add(GlazedBlocks.RED.CENTERED_SLAB.asItem())
			.add(GlazedBlocks.RED.PILLAR_SLAB.asItem())
			.add(GlazedBlocks.RED.SIDE_PILLAR_SLAB.asItem());
		tag(GlazedTags.Items.RED_BLOCKS)
			.add(GlazedBlocks.RED.CENTERED.asItem())
			.add(GlazedBlocks.RED.PILLAR.asItem());
		
   		tag(GlazedTags.Items.ORANGE_SLABS)
			.add(GlazedBlocks.ORANGE.SLAB.asItem())
			.add(GlazedBlocks.ORANGE.CENTERED_SLAB.asItem())
        	.add(GlazedBlocks.ORANGE.PILLAR_SLAB.asItem())
        	.add(GlazedBlocks.ORANGE.SIDE_PILLAR_SLAB.asItem());
		tag(GlazedTags.Items.ORANGE_BLOCKS)
			.add(GlazedBlocks.ORANGE.CENTERED.asItem())
			.add(GlazedBlocks.ORANGE.PILLAR.asItem());
		
   		tag(GlazedTags.Items.YELLOW_SLABS)
			.add(GlazedBlocks.YELLOW.SLAB.asItem())
			.add(GlazedBlocks.YELLOW.CENTERED_SLAB.asItem())
        	.add(GlazedBlocks.YELLOW.PILLAR_SLAB.asItem())
        	.add(GlazedBlocks.YELLOW.SIDE_PILLAR_SLAB.asItem());
		tag(GlazedTags.Items.YELLOW_BLOCKS)
			.add(GlazedBlocks.YELLOW.CENTERED.asItem())
			.add(GlazedBlocks.YELLOW.PILLAR.asItem());
		
   		tag(GlazedTags.Items.LIME_SLABS)
			.add(GlazedBlocks.LIME.SLAB.asItem())
			.add(GlazedBlocks.LIME.CENTERED_SLAB.asItem())
        	.add(GlazedBlocks.LIME.PILLAR_SLAB.asItem())
        	.add(GlazedBlocks.LIME.SIDE_PILLAR_SLAB.asItem());
		tag(GlazedTags.Items.LIME_BLOCKS)
			.add(GlazedBlocks.LIME.CENTERED.asItem())
			.add(GlazedBlocks.LIME.PILLAR.asItem());
		
   		tag(GlazedTags.Items.GREEN_SLABS)
			.add(GlazedBlocks.GREEN.SLAB.asItem())
			.add(GlazedBlocks.GREEN.CENTERED_SLAB.asItem())
        	.add(GlazedBlocks.GREEN.PILLAR_SLAB.asItem())
        	.add(GlazedBlocks.GREEN.SIDE_PILLAR_SLAB.asItem());
		tag(GlazedTags.Items.GREEN_BLOCKS)
			.add(GlazedBlocks.GREEN.CENTERED.asItem())
			.add(GlazedBlocks.GREEN.PILLAR.asItem());
		
   		tag(GlazedTags.Items.CYAN_SLABS)
			.add(GlazedBlocks.CYAN.SLAB.asItem())
			.add(GlazedBlocks.CYAN.CENTERED_SLAB.asItem())
        	.add(GlazedBlocks.CYAN.PILLAR_SLAB.asItem())
        	.add(GlazedBlocks.CYAN.SIDE_PILLAR_SLAB.asItem());
		tag(GlazedTags.Items.CYAN_BLOCKS)
			.add(GlazedBlocks.CYAN.CENTERED.asItem())
			.add(GlazedBlocks.CYAN.PILLAR.asItem());
		
   		tag(GlazedTags.Items.LIGHT_BLUE_SLABS)
			.add(GlazedBlocks.LIGHT_BLUE.SLAB.asItem())
			.add(GlazedBlocks.LIGHT_BLUE.CENTERED_SLAB.asItem())
        	.add(GlazedBlocks.LIGHT_BLUE.PILLAR_SLAB.asItem())
        	.add(GlazedBlocks.LIGHT_BLUE.SIDE_PILLAR_SLAB.asItem());
		tag(GlazedTags.Items.LIGHT_BLUE_BLOCKS)
			.add(GlazedBlocks.LIGHT_BLUE.CENTERED.asItem())
			.add(GlazedBlocks.LIGHT_BLUE.PILLAR.asItem());
		
   		tag(GlazedTags.Items.BLUE_SLABS)
			.add(GlazedBlocks.BLUE.SLAB.asItem())
			.add(GlazedBlocks.BLUE.CENTERED_SLAB.asItem())
        	.add(GlazedBlocks.BLUE.PILLAR_SLAB.asItem())
        	.add(GlazedBlocks.BLUE.SIDE_PILLAR_SLAB.asItem());
		tag(GlazedTags.Items.BLUE_BLOCKS)
			.add(GlazedBlocks.BLUE.CENTERED.asItem())
			.add(GlazedBlocks.BLUE.PILLAR.asItem());
		
   		tag(GlazedTags.Items.MAGENTA_SLABS)
			.add(GlazedBlocks.MAGENTA.SLAB.asItem())
			.add(GlazedBlocks.MAGENTA.CENTERED_SLAB.asItem())
        	.add(GlazedBlocks.MAGENTA.PILLAR_SLAB.asItem())
        	.add(GlazedBlocks.MAGENTA.SIDE_PILLAR_SLAB.asItem());
		tag(GlazedTags.Items.MAGENTA_BLOCKS)
			.add(GlazedBlocks.MAGENTA.CENTERED.asItem())
			.add(GlazedBlocks.MAGENTA.PILLAR.asItem());
		
   		tag(GlazedTags.Items.PURPLE_SLABS)
			.add(GlazedBlocks.PURPLE.SLAB.asItem())
			.add(GlazedBlocks.PURPLE.CENTERED_SLAB.asItem())
        	.add(GlazedBlocks.PURPLE.PILLAR_SLAB.asItem())
        	.add(GlazedBlocks.PURPLE.SIDE_PILLAR_SLAB.asItem());
		tag(GlazedTags.Items.PURPLE_BLOCKS)
			.add(GlazedBlocks.PURPLE.CENTERED.asItem())
			.add(GlazedBlocks.PURPLE.PILLAR.asItem());
		
   		tag(GlazedTags.Items.PINK_SLABS)
			.add(GlazedBlocks.PINK.SLAB.asItem())
			.add(GlazedBlocks.PINK.CENTERED_SLAB.asItem())
        	.add(GlazedBlocks.PINK.PILLAR_SLAB.asItem())
        	.add(GlazedBlocks.PINK.SIDE_PILLAR_SLAB.asItem());
		tag(GlazedTags.Items.PINK_BLOCKS)
			.add(GlazedBlocks.PINK.CENTERED.asItem())
			.add(GlazedBlocks.PINK.PILLAR.asItem());
    }
}
