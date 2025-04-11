package com.lethosos.glazedresymmetry.datagen;

import java.util.ArrayList;
import java.util.Collections;
//import java.util.Collections;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.lethosos.glazedresymmetry.GlazedResymmetry;
import com.lethosos.glazedresymmetry.Registration;
import com.lethosos.glazedresymmetry.compat.Clayworks;
import com.lethosos.glazedresymmetry.init.GlazedBlocks;
import com.lethosos.glazedresymmetry.init.GlazedGroup;
import com.lethosos.glazedresymmetry.init.util.GlazedTags;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
//import net.minecraft.data.loot.LootTableProvider;
//import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;

@EventBusSubscriber(modid = Registration.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
public class DataGenerators {

	public static List<GlazedGroup> dataList = new ArrayList<GlazedGroup>();
	
	//Add tagkeys here to use
	private static void addKeys() {
		GlazedBlocks.WHITE.addTags(GlazedTags.Items.WHITE_SLABS, GlazedTags.Items.WHITE_BLOCKS);
		GlazedBlocks.LIGHT_GRAY.addTags(GlazedTags.Items.LIGHT_GRAY_SLABS, GlazedTags.Items.LIGHT_GRAY_BLOCKS);
		GlazedBlocks.GRAY.addTags(GlazedTags.Items.GRAY_SLABS, GlazedTags.Items.GRAY_BLOCKS);
		GlazedBlocks.BLACK.addTags(GlazedTags.Items.BLACK_SLABS, GlazedTags.Items.BLACK_BLOCKS);
		GlazedBlocks.BROWN.addTags(GlazedTags.Items.BROWN_SLABS, GlazedTags.Items.BROWN_BLOCKS);
		GlazedBlocks.RED.addTags(GlazedTags.Items.RED_SLABS, GlazedTags.Items.RED_BLOCKS);
		GlazedBlocks.ORANGE.addTags(GlazedTags.Items.ORANGE_SLABS, GlazedTags.Items.ORANGE_BLOCKS);
		GlazedBlocks.YELLOW.addTags(GlazedTags.Items.YELLOW_SLABS, GlazedTags.Items.YELLOW_BLOCKS);
		GlazedBlocks.LIME.addTags(GlazedTags.Items.LIME_SLABS, GlazedTags.Items.LIME_BLOCKS);
		GlazedBlocks.GREEN.addTags(GlazedTags.Items.GREEN_SLABS, GlazedTags.Items.GREEN_BLOCKS);
		GlazedBlocks.CYAN.addTags(GlazedTags.Items.CYAN_SLABS, GlazedTags.Items.CYAN_BLOCKS);
		GlazedBlocks.LIGHT_BLUE.addTags(GlazedTags.Items.LIGHT_BLUE_SLABS, GlazedTags.Items.LIGHT_BLUE_BLOCKS);
		GlazedBlocks.BLUE.addTags(GlazedTags.Items.BLUE_SLABS, GlazedTags.Items.BLUE_BLOCKS);
		GlazedBlocks.MAGENTA.addTags(GlazedTags.Items.MAGENTA_SLABS, GlazedTags.Items.MAGENTA_BLOCKS);
		GlazedBlocks.PURPLE.addTags(GlazedTags.Items.PURPLE_SLABS, GlazedTags.Items.PURPLE_BLOCKS);
		GlazedBlocks.PINK.addTags(GlazedTags.Items.PINK_SLABS, GlazedTags.Items.PINK_BLOCKS);
		
		if ( GlazedResymmetry.CLAYWORKS )
		{
			Clayworks.GLAZED.addTags(GlazedTags.Items.GLAZED_SLABS, GlazedTags.Items.GLAZED_BLOCKS);
		}
	}
	
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();
        
        dataList = GlazedBlocks.groupList;
        addKeys();

        // I ought to add a seperate data generator class just for compat at some point
        // Might lower this down to root just because
        
        // Loot Tables
        generator.addProvider(event.includeServer(), new LootTableProvider(packOutput, Collections.emptySet(),
                List.of(new LootTableProvider.SubProviderEntry(GlazedBlockLootTableProvider::new, LootContextParamSets.BLOCK)), lookupProvider));
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
        //Datapacks (again we don't need any right now)
        //generator.addProvider(event.includeServer(), new GlazedDatapackProvider(packOutput, lookupProvider));
        //Global loot modifier (we have to call after Datapacks)
        //generator.addProvider(event.includeServer(), new GlazedGlobalLootModifierProvider(packOutput, lookupProvider));
        //Recipes
        generator.addProvider(event.includeServer(), new GlazedRecipeProvider(packOutput, lookupProvider));
        //Language
        generator.addProvider(event.includeClient(), new GlazedLanguageProvider(packOutput));
    }
}
