package com.lethosos.glazedresymmetry.init.util.datagen;

import com.lethosos.glazedresymmetry.Registration;

import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class GlazedItemModelProvider extends ItemModelProvider {
	    public GlazedItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
	        super(output, Registration.MOD_ID, existingFileHelper);
	    }

	    @Override
	    protected void registerModels() {
	    	DataGenerators.groupList.forEach((group) -> {
	    		basicItem(group.SHARD.get());
	    	});
	    }
}
