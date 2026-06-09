package com.lethosos.glazedresymmetry.datagen;

import com.lethosos.glazedresymmetry.GlazedResymmetry;
import com.lethosos.glazedresymmetry.compat.ClayworksCompat;
import com.lethosos.glazedresymmetry.datagen.util.GlazedModelHelper;
import com.lethosos.glazedresymmetry.init.GlazedBlocks;
import com.lethosos.glazedresymmetry.init.util.GlazedGroup;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class GlazedItemModelProvider extends ItemModelProvider {
	public GlazedItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, GlazedResymmetry.MOD_ID, existingFileHelper);
        GlazedModelHelper.Items.iProvider = this;
    }
	
	protected String str;

	@Override
	protected void registerModels() {
		GlazedBlocks.groupList.forEach((group) -> {
			if ( group.groupName != "glazed" ) { pushItemModels(group); }
			//Clayworks compat only
			else {
				simpleBlockItem(ClayworksCompat.GLAZED.SLAB.get());
				simpleBlockItem(ClayworksCompat.GLAZED.CENTERED.get());
				simpleBlockItem(ClayworksCompat.GLAZED.CENTERED_SLAB.get());
				simpleBlockItem(ClayworksCompat.GLAZED.PILLAR.get());
				simpleBlockItem(ClayworksCompat.GLAZED.PILLAR_SLAB.get());
				simpleBlockItem(ClayworksCompat.GLAZED.SIDE_PILLAR_SLAB.get());
				basicItem(ClayworksCompat.GLAZED.FLOWER_POT.asItem());
				basicItem(ClayworksCompat.GLAZED.SHARD.get());
					
				simpleBlockItem(ClayworksCompat.GLAZED.GLASS.GLAZED.get());
				simpleBlockItem(ClayworksCompat.GLAZED.GLASS.CENTERED.get());
				simpleBlockItem(ClayworksCompat.GLAZED.GLASS.PILLAR.get());
			
				GlazedModelHelper.Items.shadowItem(ClayworksCompat.GLAZED.GLASS.GLAZED_PANE.get().asItem(), 
					resourceBlock("glazed_glass"));
				GlazedModelHelper.Items.shadowItem(ClayworksCompat.GLAZED.GLASS.glazed1.get().asItem(), 
						resourceBlock("glazed_glass"));
				GlazedModelHelper.Items.shadowItem(ClayworksCompat.GLAZED.GLASS.glazed2.get().asItem(), 
						resourceBlock("glazed_glass"));
				GlazedModelHelper.Items.shadowItem(ClayworksCompat.GLAZED.GLASS.glazed3.get().asItem(), 
						resourceBlock("glazed_glass"));
			
				GlazedModelHelper.Items.shadowItem(ClayworksCompat.GLAZED.GLASS.CENTERED_PANE.get().asItem(), 
					resourceBlock("centered_glazed_glass"));
				GlazedModelHelper.Items.shadowItem(ClayworksCompat.GLAZED.GLASS.PILLAR_TOP_PANE.get().asItem(), 
					resourceBlock("glazed_glass_pillar_top"));

				GlazedModelHelper.Items.shadowItem(ClayworksCompat.GLAZED.GLASS.SIDE_PILLAR_PANE.get().asItem(), 
					resourceBlock("glazed_glass_pillar"));
				GlazedModelHelper.Items.shadowItem(ClayworksCompat.GLAZED.GLASS.side1.get().asItem(), 
						resourceBlock("glazed_glass_pillar"));
			}
		});
		
		simpleBlockItem(GlazedBlocks.FLOWERING_GLASS.get());
		simpleBlockItem(GlazedBlocks.FLOWERING_GLASS_PILLAR.get());
		GlazedModelHelper.Items.shadowItem(GlazedBlocks.FLOWERING_GLASS_TOP_PANE.get().asItem(),
				resourceBlock("flower_patterned_glass_top"));
		GlazedModelHelper.Items.shadowItem(GlazedBlocks.FLOWERING_GLASS_SIDE_PANE.get().asItem(),
				resourceBlock("flower_patterned_glass_side"));
		basicItem(GlazedBlocks.WAXED_SHARD.get());
		GlazedModelHelper.Items.shadowItem(GlazedBlocks.GLASSCUTTER_TOOL.get(),
				resourceItem("glasscutter"));
	}
	
	/**
	 * Takes in a GlazedGroup and spits out the item models for each item.
	 * 
	 * @param group The GlazedGroup to pass.
	 */
	public void pushItemModels(GlazedGroup group) {
		simpleBlockItem(group.SLAB.get());
		simpleBlockItem(group.CENTERED.get());
		simpleBlockItem(group.CENTERED_SLAB.get());
		simpleBlockItem(group.PILLAR.get());
		simpleBlockItem(group.PILLAR_SLAB.get());
		simpleBlockItem(group.SIDE_PILLAR_SLAB.get());
		basicItem(group.FLOWER_POT.asItem());
		basicItem(group.SHARD.get());
				
		simpleBlockItem(group.GLASS.GLAZED.get());
		simpleBlockItem(group.GLASS.CENTERED.get());
		simpleBlockItem(group.GLASS.PILLAR.get());
		
		GlazedModelHelper.Items.shadowItem(group.GLASS.GLAZED_PANE.get().asItem(), 
				resourceBlock(group.groupName + "_glazed_glass"));
		GlazedModelHelper.Items.shadowItem(group.GLASS.glazed1.get().asItem(), 
				resourceBlock(group.groupName + "_glazed_glass"));
		GlazedModelHelper.Items.shadowItem(group.GLASS.glazed2.get().asItem(), 
				resourceBlock(group.groupName + "_glazed_glass"));
		GlazedModelHelper.Items.shadowItem(group.GLASS.glazed3.get().asItem(), 
				resourceBlock(group.groupName + "_glazed_glass"));
		
		GlazedModelHelper.Items.shadowItem(group.GLASS.CENTERED_PANE.get().asItem(), 
				resourceBlock(group.groupName + "_centered_glazed_glass"));
		GlazedModelHelper.Items.shadowItem(group.GLASS.PILLAR_TOP_PANE.get().asItem(), 
				resourceBlock(group.groupName + "_glazed_glass_pillar_top"));
		
		GlazedModelHelper.Items.shadowItem(group.GLASS.SIDE_PILLAR_PANE.get().asItem(), 
				resourceBlock(group.groupName + "_glazed_glass_pillar"));
		GlazedModelHelper.Items.shadowItem(group.GLASS.side1.get().asItem(), 
				resourceBlock(group.groupName + "_glazed_glass_pillar"));
	}
	
	public ResourceLocation resourceItem(String path) {
		return ResourceLocation.fromNamespaceAndPath(GlazedResymmetry.MOD_ID, "item/" + path);
	}
	public ResourceLocation resourceVanillaItem(String path) {
		return ResourceLocation.fromNamespaceAndPath("minecraft", "item/" + path);
	}
	public ResourceLocation resourceBlock(String path) {
		return ResourceLocation.fromNamespaceAndPath(GlazedResymmetry.MOD_ID, "block/" + path);
	}
}
