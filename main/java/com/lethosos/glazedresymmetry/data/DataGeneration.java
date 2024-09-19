package com.lethosos.glazedresymmetry.data;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.data.tags.TagsProvider.TagLookup;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraftforge.data.event.GatherDataEvent;

public class DataGeneration {

    public static void generate(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();

        //generator.addProvider(event.includeClient(), new GlazedBlockStates(packOutput, event.getExistingFileHelper()));
        generator.addProvider(event.includeClient(), new GlazedItemModels(packOutput, event.getExistingFileHelper()));
        generator.addProvider(event.includeClient(), new GlazedLanguageProvider(packOutput, "en_us"));

        /*
        GlazedBlockTags blockTags = new GlazedBlockTags(packOutput, lookupProvider, event.getExistingFileHelper());
        generator.addProvider(event.includeServer(), blockTags);
        //generator.addProvider(event.includeServer(), new GlazedItemTags(packOutput, lookupProvider, blockTags, event.getExistingFileHelper()));
        generator.addProvider(event.includeServer(), new GlazedRecipes(packOutput));
        generator.addProvider(event.includeServer(), new LootTableProvider(packOutput, Collections.emptySet(),
                List.of(new LootTableProvider.SubProviderEntry(GlazedLootTables::new, LootContextParamSets.BLOCK))));
        */
    }
}
