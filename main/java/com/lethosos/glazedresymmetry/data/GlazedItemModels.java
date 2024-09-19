package com.lethosos.glazedresymmetry.data;

import com.lethosos.glazedresymmetry.Registration;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.DyeColor;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.client.model.generators.ModelFile.ExistingModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;

public class GlazedItemModels extends ItemModelProvider {

    public GlazedItemModels(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, Registration.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        ExistingModelFile itemGenerated = getExistingFile(mcLoc("item/generated"));

        for (final DyeColor dyeColor : DyeColor.values()) {
            builderFor(itemGenerated, dyeColor.getName() + "_glazed_flower_pot");
        }
    }

    private ItemModelBuilder builderFor(ModelFile itemGenerated, String name){
        return getBuilder(name)
                .parent(itemGenerated)
                .texture("layer0", "item/" + name);
    }
}