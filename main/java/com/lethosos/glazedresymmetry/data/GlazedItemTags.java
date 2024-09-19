package com.lethosos.glazedresymmetry.data;

import java.util.concurrent.CompletableFuture;

import javax.annotation.Nullable;

import com.lethosos.glazedresymmetry.Registration;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.data.tags.TagsProvider;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;

public class GlazedItemTags extends ItemTagsProvider {

	public GlazedItemTags(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, CompletableFuture<TagsProvider.TagLookup<Item>> itemTagProvider, CompletableFuture<TagsProvider.TagLookup<Block>> blockTagProvider, @Nullable ExistingFileHelper existingFileHelper) {
		super(output, lookupProvider, itemTagProvider, blockTagProvider, Registration.MOD_ID, existingFileHelper);
	}

	public GlazedItemTags(PackOutput packOutput, CompletableFuture<Provider> lookupProvider, CompletableFuture<TagLookup<Block>> blockTags,	ExistingFileHelper existingFileHelper) {
		super(packOutput, lookupProvider, blockTags, Registration.MOD_ID, existingFileHelper);
	}

	/*
	protected void addTags() {
        copy(GlazedTags.Blocks.POTABLE_PLANTS, GlazedTags.Items.POTABLE_PLANTS);
        copy(GlazedTags.Blocks.FLOWER_POT, GlazedTags.Items.FLOWER_POT);
        copy(GlazedTags.Blocks.GLAZED_POT, GlazedTags.Items.GLAZED_POT);
    }
    */

	@Override
	protected void addTags(Provider p_256380_) {
		// TODO Auto-generated method stub
		
	}
}
