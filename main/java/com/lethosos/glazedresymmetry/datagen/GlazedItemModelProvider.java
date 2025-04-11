package com.lethosos.glazedresymmetry.datagen;

import com.lethosos.glazedresymmetry.Registration;
import com.lethosos.glazedresymmetry.init.GlazedBlocks;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.client.model.generators.ItemModelBuilder;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class GlazedItemModelProvider extends ItemModelProvider {
	public GlazedItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, Registration.MOD_ID, existingFileHelper);
    }
	
	protected String str;

	@Override
	protected void registerModels() {
		GlazedBlocks.groupList.forEach((group) -> {
			if ( group.groupName != "glazed" ) {
				simpleBlockItem(group.SLAB.get());
				simpleBlockItem(group.CENTERED.get());
				simpleBlockItem(group.CENTERED_SLAB.get());
				simpleBlockItem(group.PILLAR.get());
				simpleBlockItem(group.PILLAR_SLAB.get());
				simpleBlockItem(group.SIDE_PILLAR_SLAB.get());
				basicItem(group.FLOWER_POT.asItem());
				basicItem(group.SHARD.get());
						
				group.pottedPots.forEach((pot) -> shadowItem(pot.asItem(), resourceItem(group.groupName + "_glazed_flower_pot")));
			}
			/*
			else {
				Clayworks.GLAZED.pottedPots.forEach((pot) -> shadowItem(pot.asItem(), resourceItem("glazed_flower_pot")));
			}
			*/
		});
	}
	
	public ResourceLocation resourceItem(String path) {
		return ResourceLocation.fromNamespaceAndPath(Registration.MOD_ID, "item/" + path);
	}
	public ResourceLocation resourceVanillaItem(String path) {
		return ResourceLocation.fromNamespaceAndPath("minecraft", "item/" + path);
	}
	
    public ItemModelBuilder shadowItem(Item item, ResourceLocation texSource) {
        return getBuilder(item.toString())
                .parent(new ModelFile.UncheckedModelFile("item/generated"))
                .texture("layer0", ResourceLocation.fromNamespaceAndPath(texSource.getNamespace(), texSource.getPath()));
    }
}
