package com.lethosos.glazedresymmetry.datagen;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.lethosos.glazedresymmetry.GlazedResymmetry;
import com.lethosos.glazedresymmetry.compat.ClayworksCompat;
import com.lethosos.glazedresymmetry.datagen.loot.GlazedLootTableSubProvider;
import com.lethosos.glazedresymmetry.datagen.util.GlazedModelHelper;
import com.lethosos.glazedresymmetry.datagen.loot.GlazedGlobalLootModifierProvider;
import com.lethosos.glazedresymmetry.init.GlazedBlocks;
import com.lethosos.glazedresymmetry.init.util.GlazedGroup;
import com.lethosos.glazedresymmetry.init.util.GlazedTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;

@EventBusSubscriber(modid = GlazedResymmetry.MOD_ID)
public class DataGenerators {

    public static GlazedModelHelper helper;
	public static List<GlazedGroup> dataList = new ArrayList<GlazedGroup>();
	
	//Add tagkeys here to use
	public static void addKeys() {
		GlazedBlocks.WHITE.addTags(GlazedTags.Items.WHITE_SLABS, GlazedTags.Items.WHITE_BLOCKS);
		GlazedBlocks.WHITE.GLASS.addTags(GlazedTags.Items.WHITE_GLASS, GlazedTags.Items.WHITE_PANES);
		GlazedBlocks.LIGHT_GRAY.addTags(GlazedTags.Items.LIGHT_GRAY_SLABS, GlazedTags.Items.LIGHT_GRAY_BLOCKS);
		GlazedBlocks.LIGHT_GRAY.GLASS.addTags(GlazedTags.Items.LIGHT_GRAY_GLASS, GlazedTags.Items.LIGHT_GRAY_PANES);
		GlazedBlocks.GRAY.addTags(GlazedTags.Items.GRAY_SLABS, GlazedTags.Items.GRAY_BLOCKS);
		GlazedBlocks.GRAY.GLASS.addTags(GlazedTags.Items.GRAY_GLASS, GlazedTags.Items.GRAY_PANES);
		GlazedBlocks.BLACK.addTags(GlazedTags.Items.BLACK_SLABS, GlazedTags.Items.BLACK_BLOCKS);
		GlazedBlocks.BLACK.GLASS.addTags(GlazedTags.Items.BLACK_GLASS, GlazedTags.Items.BLACK_PANES);
		GlazedBlocks.BROWN.addTags(GlazedTags.Items.BROWN_SLABS, GlazedTags.Items.BROWN_BLOCKS);
		GlazedBlocks.BROWN.GLASS.addTags(GlazedTags.Items.BROWN_GLASS, GlazedTags.Items.BROWN_PANES);
		GlazedBlocks.RED.addTags(GlazedTags.Items.RED_SLABS, GlazedTags.Items.RED_BLOCKS);
		GlazedBlocks.RED.GLASS.addTags(GlazedTags.Items.RED_GLASS, GlazedTags.Items.RED_PANES);
		GlazedBlocks.ORANGE.addTags(GlazedTags.Items.ORANGE_SLABS, GlazedTags.Items.ORANGE_BLOCKS);
		GlazedBlocks.ORANGE.GLASS.addTags(GlazedTags.Items.ORANGE_GLASS, GlazedTags.Items.ORANGE_PANES);
		GlazedBlocks.YELLOW.addTags(GlazedTags.Items.YELLOW_SLABS, GlazedTags.Items.YELLOW_BLOCKS);
		GlazedBlocks.YELLOW.GLASS.addTags(GlazedTags.Items.YELLOW_GLASS, GlazedTags.Items.YELLOW_PANES);
		GlazedBlocks.LIME.addTags(GlazedTags.Items.LIME_SLABS, GlazedTags.Items.LIME_BLOCKS);
		GlazedBlocks.LIME.GLASS.addTags(GlazedTags.Items.LIME_GLASS, GlazedTags.Items.LIME_PANES);
		GlazedBlocks.GREEN.addTags(GlazedTags.Items.GREEN_SLABS, GlazedTags.Items.GREEN_BLOCKS);
		GlazedBlocks.GREEN.GLASS.addTags(GlazedTags.Items.GREEN_GLASS, GlazedTags.Items.GREEN_PANES);
		GlazedBlocks.CYAN.addTags(GlazedTags.Items.CYAN_SLABS, GlazedTags.Items.CYAN_BLOCKS);
		GlazedBlocks.CYAN.GLASS.addTags(GlazedTags.Items.CYAN_GLASS, GlazedTags.Items.CYAN_PANES);
		GlazedBlocks.LIGHT_BLUE.addTags(GlazedTags.Items.LIGHT_BLUE_SLABS, GlazedTags.Items.LIGHT_BLUE_BLOCKS);
		GlazedBlocks.LIGHT_BLUE.GLASS.addTags(GlazedTags.Items.LIGHT_BLUE_GLASS, GlazedTags.Items.LIGHT_BLUE_PANES);
		GlazedBlocks.BLUE.addTags(GlazedTags.Items.BLUE_SLABS, GlazedTags.Items.BLUE_BLOCKS);
		GlazedBlocks.BLUE.GLASS.addTags(GlazedTags.Items.BLUE_GLASS, GlazedTags.Items.BLUE_PANES);
		GlazedBlocks.MAGENTA.addTags(GlazedTags.Items.MAGENTA_SLABS, GlazedTags.Items.MAGENTA_BLOCKS);
		GlazedBlocks.MAGENTA.GLASS.addTags(GlazedTags.Items.MAGENTA_GLASS, GlazedTags.Items.MAGENTA_PANES);
		GlazedBlocks.PURPLE.addTags(GlazedTags.Items.PURPLE_SLABS, GlazedTags.Items.PURPLE_BLOCKS);
		GlazedBlocks.PURPLE.GLASS.addTags(GlazedTags.Items.PURPLE_GLASS, GlazedTags.Items.PURPLE_PANES);
		GlazedBlocks.PINK.addTags(GlazedTags.Items.PINK_SLABS, GlazedTags.Items.PINK_BLOCKS);
		GlazedBlocks.PINK.GLASS.addTags(GlazedTags.Items.PINK_GLASS, GlazedTags.Items.PINK_PANES);
		
		if (GlazedResymmetry.CLAYWORKS == true) {
			GlazedTags.Items.compat();
			ClayworksCompat.GLAZED.addTags(GlazedTags.Items.GLAZED_SLABS, GlazedTags.Items.GLAZED_BLOCKS);
			ClayworksCompat.GLAZED.GLASS.addTags(GlazedTags.Items.GLAZED_GLASS, GlazedTags.Items.GLAZED_PANES);
		}
	}
	
    @SubscribeEvent
    public static void ongatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();
        
        dataList = GlazedBlocks.groupList;

        // Loot Tables
        generator.addProvider(event.includeServer(), new GlazedGlobalLootModifierProvider(packOutput, lookupProvider));
        generator.addProvider(event.includeServer(),
        	new LootTableProvider(packOutput, Collections.emptySet(),
        		List.of(new LootTableProvider.SubProviderEntry(GlazedBlockLootTableProvider::new, LootContextParamSets.BLOCK),
        			new LootTableProvider.SubProviderEntry(GlazedLootTableSubProvider::new, LootContextParamSets.CHEST)),
        		lookupProvider));
        //Block tags
        BlockTagsProvider blockTagsProvider = new GlazedBlockTagProvider(packOutput, lookupProvider, existingFileHelper);
        generator.addProvider(event.includeServer(), blockTagsProvider);
        //Item tags
        generator.addProvider(event.includeServer(), new GlazedItemTagProvider(packOutput, lookupProvider, blockTagsProvider.contentsGetter(), existingFileHelper));
        //Data maps (we don't need any)
        //generator.addProvider(event.includeServer(), new GlazedDataMapProvider(packOutput, lookupProvider));
        //Block models & block states
        generator.addProvider(event.includeClient(), new GlazedBlockStateProvider(packOutput, existingFileHelper));
        //Item models
        generator.addProvider(event.includeClient(), new GlazedItemModelProvider(packOutput, existingFileHelper));
        //Datapacks (again, we don't need any)
        //generator.addProvider(event.includeServer(), new GlazedDatapackProvider(packOutput, lookupProvider));
        //Recipes
        generator.addProvider(event.includeServer(), new GlazedRecipeProvider(packOutput, lookupProvider));
        //Language
        generator.addProvider(event.includeClient(), new GlazedLanguageProvider(packOutput));
    }
}
