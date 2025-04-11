package com.lethosos.glazedresymmetry.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import com.lethosos.glazedresymmetry.Registration;

import java.util.concurrent.CompletableFuture;

public class GlazedBlockTagProvider extends BlockTagsProvider {
    public GlazedBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, Registration.MOD_ID, existingFileHelper);
    }

    @Override
	protected void addTags(HolderLookup.Provider provider) {
    	DataGenerators.dataList.forEach((group) -> {
    		if (group.groupName == "glazed") {
    			tag(BlockTags.MINEABLE_WITH_PICKAXE)
					.addOptional(ResourceLocation.fromNamespaceAndPath(Registration.MOD_ID, "glazed_terracotta_slab"))
					.addOptional(ResourceLocation.fromNamespaceAndPath(Registration.MOD_ID, "centered_glazed_terracotta"))
					.addOptional(ResourceLocation.fromNamespaceAndPath(Registration.MOD_ID, "centered_glazed_terracotta_slab"))
					.addOptional(ResourceLocation.fromNamespaceAndPath(Registration.MOD_ID, "glazed_terracotta_pillar"))
					.addOptional(ResourceLocation.fromNamespaceAndPath(Registration.MOD_ID, "glazed_terracotta_pillar_slab"))
					.addOptional(ResourceLocation.fromNamespaceAndPath(Registration.MOD_ID, "glazed_terracotta_side_pillar_slab"));    			
    		}
    		else {
    			tag(BlockTags.MINEABLE_WITH_PICKAXE)
    				.add(group.SLAB.get())
    				.add(group.CENTERED.get())
    				.add(group.CENTERED_SLAB.get())
    				.add(group.PILLAR.get())
    				.add(group.PILLAR_SLAB.get())
    				.add(group.SIDE_PILLAR_SLAB.get());
    		}
    	});
    }
}
