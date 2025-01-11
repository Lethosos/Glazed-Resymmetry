package com.lethosos.glazedresymmetry.init.util.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
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
    	DataGenerators.groupList.forEach((group) -> {
    		tag(BlockTags.MINEABLE_WITH_PICKAXE)
    			.add(group.SLAB.get())
                .add(group.CENTERED.get())
                .add(group.CENTERED_SLAB.get())
                .add(group.PILLAR.get())
                .add(group.PILLAR_SLAB.get())
                .add(group.SIDE_PILLAR_SLAB.get());
    	});
    }
}
