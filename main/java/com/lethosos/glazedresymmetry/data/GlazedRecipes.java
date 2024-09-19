package com.lethosos.glazedresymmetry.data;



import java.util.function.Consumer;

import com.lethosos.glazedresymmetry.init.GlazedBlocks;

import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraftforge.common.Tags;

public class GlazedRecipes extends RecipeProvider {

    public GlazedRecipes(PackOutput packOutput) {
        super(packOutput);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> consumer) {
        /*
    	ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Registration.SIMPLE_BLOCK.get())
                .requires(ItemTags.DIRT)
                .requires(Tags.Items.GEMS_DIAMOND)
                .unlockedBy("has_diamond", InventoryChangeTrigger.TriggerInstance.hasItems(
                        ItemPredicate.Builder.item().of(Tags.Items.GEMS_DIAMOND).build()))
                .save(consumer);
        */

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, GlazedBlocks.BLACK_CENTERED_GLAZED_TERRACOTTA.get())
                .pattern("ccc")
                .define('c', GlazedBlocks.BLACK_CENTERED_GLAZED_TERRACOTTA.get())
                .group("black_glazed")
                .unlockedBy("has_dye", InventoryChangeTrigger.TriggerInstance.hasItems(
                        ItemPredicate.Builder.item().of(Tags.Items.DYES_BLACK).build()))
                .save(consumer);

    }
}
