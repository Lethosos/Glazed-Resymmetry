package com.lethosos.glazedresymmetry.data;

import java.util.Map;
import java.util.stream.Collectors;

import com.lethosos.glazedresymmetry.Registration;
import com.lethosos.glazedresymmetry.init.GlazedBlocks;

import net.minecraft.data.loot.packs.VanillaBlockLoot;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.ForgeRegistries;

public class GlazedLootTables extends VanillaBlockLoot {

    @Override
    protected void generate() {
        dropSelf(GlazedBlocks.BLACK_CENTERED_GLAZED_TERRACOTTA.get());
        //dropPottedContents(GlazedFlowerPot.BLACK_GLAZED_FP.get());
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ForgeRegistries.BLOCKS.getEntries().stream()
                .filter(e -> e.getKey().location().getNamespace().equals(Registration.MOD_ID))
                .map(Map.Entry::getValue)
                .collect(Collectors.toList());
    }
}
