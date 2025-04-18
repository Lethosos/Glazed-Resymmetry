package com.lethosos.glazedresymmetry.datagen;

import java.util.concurrent.CompletableFuture;

import com.lethosos.glazedresymmetry.init.util.VanillaCheck;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.data.recipes.SingleItemRecipeBuilder;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;

public class GlazedRecipeProvider extends RecipeProvider implements IConditionBuilder{

	public GlazedRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
		super(output, lookupProvider);
	}

	private static RecipeCategory DECOR = RecipeCategory.DECORATIONS;

	@Override
	protected void buildRecipes(RecipeOutput recipeOutput) {
		DataGenerators.dataList.forEach((group) -> {
			if (group.groupName != "glazed")
			{
				//Shard To Vanilla block
				ShapedRecipeBuilder.shaped(DECOR, VanillaCheck.returnGlazed(group.groupName))
				.pattern("ss")
				.pattern("ss")
				.define('s', group.SHARD.get())
				.unlockedBy("has_" + group.groupName, has(VanillaCheck.returnGlazed(group.groupName)))
				.save(recipeOutput, "cb/" + group.groupName + "_shard_to_block");

				//Shard to Centered block
				ShapedRecipeBuilder.shaped(DECOR, group.CENTERED)
				.pattern("s s")
				.pattern("   ")
				.pattern("s s")
				.define('s', group.SHARD.get())
				.unlockedBy("has_" + group.groupName, has(VanillaCheck.returnGlazed(group.groupName)))
				.save(recipeOutput, "cb/" + group.groupName + "_shard_to_centered");

				//Shard to Pillar block
				ShapedRecipeBuilder.shaped(DECOR, group.PILLAR)
				.pattern("s s")
				.pattern("s s")
				.define('s', group.SHARD.get())
				.unlockedBy("has_" + group.groupName, has(VanillaCheck.returnGlazed(group.groupName)))
				.save(recipeOutput, "cb/" + group.groupName + "_shard_to_pillar");

				//Vanilla block to Centered block
				ShapedRecipeBuilder.shaped(DECOR, group.CENTERED, 4)
				.pattern(" B ")
				.pattern("B B")
				.pattern(" B ")
				.define('B', VanillaCheck.returnGlazed(group.groupName))
				.unlockedBy("has_" + group.groupName, has(VanillaCheck.returnGlazed(group.groupName)))
				.save(recipeOutput, "cb/" + group.groupName + "_block_to_centered");

				//Vanilla block to Pillar block
				ShapedRecipeBuilder.shaped(DECOR, group.PILLAR, 4)
				.pattern("B B")
				.pattern("B B")
				.define('B', VanillaCheck.returnGlazed(group.groupName))
				.unlockedBy("has_" + group.groupName, has(VanillaCheck.returnGlazed(group.groupName)))
				.save(recipeOutput, "cb/" + group.groupName + "_block_to_pillar");

				//Vanilla block to Slab version
				ShapedRecipeBuilder.shaped(DECOR, group.SLAB.get(), 6)
				.pattern("BBB")
				.define('B', VanillaCheck.returnGlazed(group.groupName))
				.unlockedBy("has_" + group.groupName, has(VanillaCheck.returnGlazed(group.groupName)))
				.save(recipeOutput, "cb/" + group.groupName + "_block_to_slab");

				//All slabs back into Vanilla block
				ShapedRecipeBuilder.shaped(DECOR, VanillaCheck.returnGlazed(group.groupName))
				.pattern("S")
				.pattern("S")
				.define('S', group.SLAB_KEY)
				.unlockedBy("has_" + group.groupName, has(VanillaCheck.returnGlazed(group.groupName)))
				.save(recipeOutput, "cb/" + group.groupName + "_slab_to_block");

				//Centered block to Slab version
				ShapedRecipeBuilder.shaped(DECOR, group.CENTERED_SLAB.get(), 6)
				.pattern("BBB")
				.define('B', group.CENTERED.get())
				.unlockedBy("has_" + group.groupName, has(VanillaCheck.returnGlazed(group.groupName)))
				.save(recipeOutput, "cb/" + group.groupName + "_centered_to_slab");

				//Pillar block to Slab version
				ShapedRecipeBuilder.shaped(DECOR, group.PILLAR_SLAB.get(), 6)
				.pattern("BBB")
				.define('B', group.PILLAR.get())
				.unlockedBy("has_" + group.groupName, has(VanillaCheck.returnGlazed(group.groupName)))
				.save(recipeOutput, "cb/" + group.groupName + "_pillar_to_slab");

				//Pillar slab to Side Pillar slab
				ShapelessRecipeBuilder.shapeless(DECOR, group.SIDE_PILLAR_SLAB)
				.requires(group.PILLAR_SLAB)
				.unlockedBy("has_" + group.groupName, has(VanillaCheck.returnGlazed(group.groupName)))
				.save(recipeOutput, "cb/" + group.groupName + "_pillar_slab_to_side_slab");
				//And back
				ShapelessRecipeBuilder.shapeless(DECOR, group.PILLAR_SLAB)
				.requires(group.SIDE_PILLAR_SLAB)
				.unlockedBy("has_" + group.groupName, has(VanillaCheck.returnGlazed(group.groupName)))
				.save(recipeOutput, "cb/" + group.groupName + "_side_slab_to_pillar_slab");

				//Flower Pot recipe
				ShapelessRecipeBuilder.shapeless(DECOR, group.FLOWER_POT)
				.requires(Blocks.FLOWER_POT)
				.requires(group.SHARD)
				.unlockedBy("has_" + group.groupName, has(VanillaCheck.returnGlazed(group.groupName)))
				.save(recipeOutput, "cb/" + group.groupName + "_glazed_flower_pot");

				//Stonecutter Recipes
				//Shard from blocks
				SingleItemRecipeBuilder.stonecutting(Ingredient.of(VanillaCheck.returnGlazed(group.groupName)), DECOR, group.SHARD, 4)
				.unlockedBy("has_" + group.groupName, has(VanillaCheck.returnGlazed(group.groupName)))
				.save(recipeOutput, "sc/" + group.groupName + "_block_to_shard_sc1");
				SingleItemRecipeBuilder.stonecutting(Ingredient.of(group.BLOCK_KEY), DECOR, group.SHARD, 4)
				.unlockedBy("has_" + group.groupName, has(VanillaCheck.returnGlazed(group.groupName)))
				.save(recipeOutput, "sc/" + group.groupName + "_block_to_shard_sc2");

				//Vanilla block to Centered block
				SingleItemRecipeBuilder.stonecutting(Ingredient.of(VanillaCheck.returnGlazed(group.groupName)), DECOR, group.CENTERED)
				.unlockedBy("has_" + group.groupName, has(VanillaCheck.returnGlazed(group.groupName)))
				.save(recipeOutput, "sc/" + group.groupName + "_block_to_centered_sc");

				//Vanilla block to Pillar block
				SingleItemRecipeBuilder.stonecutting(Ingredient.of(VanillaCheck.returnGlazed(group.groupName)), DECOR, group.PILLAR)
				.unlockedBy("has_" + group.groupName, has(VanillaCheck.returnGlazed(group.groupName)))
				.save(recipeOutput, "sc/" + group.groupName + "_block_to_pillar_sc");

				// Centered/Pillar block to Vanilla block
				SingleItemRecipeBuilder.stonecutting(Ingredient.of(group.CENTERED, group.PILLAR), DECOR, VanillaCheck.returnGlazed(group.groupName))
				.unlockedBy("has_" + group.groupName, has(VanillaCheck.returnGlazed(group.groupName)))
				.save(recipeOutput, "sc/" + group.groupName + "_back_to_block_sc");

				//All slab to vanilla slab
				SingleItemRecipeBuilder.stonecutting(Ingredient.of(group.CENTERED_SLAB, group.PILLAR_SLAB, group.SIDE_PILLAR_SLAB), DECOR, group.SLAB)
				.unlockedBy("has_" + group.groupName, has(VanillaCheck.returnGlazed(group.groupName)))
				.save(recipeOutput, "sc/" + group.groupName + "_other_slab_back_to_slab_sc");

				//Vanilla block to slab
				SingleItemRecipeBuilder.stonecutting(Ingredient.of(VanillaCheck.returnGlazed(group.groupName)), DECOR, group.SLAB, 2)
				.unlockedBy("has_" + group.groupName, has(VanillaCheck.returnGlazed(group.groupName)))
				.save(recipeOutput, "sc/" + group.groupName + "_block_to_slab_sc");

				//Centered block to slab
				SingleItemRecipeBuilder.stonecutting(Ingredient.of(group.CENTERED), DECOR, group.CENTERED_SLAB, 2)
				.unlockedBy("has_" + group.groupName, has(VanillaCheck.returnGlazed(group.groupName)))
				.save(recipeOutput, "sc/" + group.groupName + "_centered_to_slab_sc");

				//Pillar block to slab
				SingleItemRecipeBuilder.stonecutting(Ingredient.of(group.PILLAR), DECOR, group.PILLAR_SLAB, 2)
				.unlockedBy("has_" + group.groupName, has(VanillaCheck.returnGlazed(group.groupName)))
				.save(recipeOutput, "sc/" + group.groupName + "_pillar_to_slab_sc");

				//Pillar block to side slab
				SingleItemRecipeBuilder.stonecutting(Ingredient.of(group.PILLAR), DECOR, group.SIDE_PILLAR_SLAB, 2)
				.unlockedBy("has_" + group.groupName, has(VanillaCheck.returnGlazed(group.groupName)))
				.save(recipeOutput, "sc/" + group.groupName + "_pillar_to_side_slab_sc");
			}
		});
	}
}
