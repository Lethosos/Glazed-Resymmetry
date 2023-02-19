package com.lethosos.glazedresymmetry;

import java.util.function.Supplier;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
//import net.minecraft.world.level.block.Blocks;
//import net.minecraft.world.level.block.FlowerPotBlock;
import net.minecraft.world.level.block.GlazedTerracottaBlock;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.SlabBlock;
//import net.minecraft.world.level.block.StairBlock;
//import net.minecraft.world.level.block.WallBlock;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.registries.RegistryObject;

public class ModBlocks {
    final private static String[] COLORS = {
            "white", "light_gray", "red", "purple",
            "pink", "orange", "magenta", "lime",
            "light_blue", "green", "gray", "cyan",
            "brown", "blue", "yellow", "black"
    };

    private static DyeColor getColor(String color) {
        switch (color) {
            case "white":
                return DyeColor.WHITE;
            case "light_gray":
                return DyeColor.LIGHT_GRAY;
            case "red":
                return DyeColor.RED;
            case "purple":
                return DyeColor.PURPLE;
            case "pink":
                return DyeColor.PINK;
            case "orange":
                return DyeColor.ORANGE;
            case "magenta":
                return DyeColor.MAGENTA;
            case "lime":
                return DyeColor.LIME;
            case "light_blue":
                return DyeColor.LIGHT_BLUE;
            case "green":
                return DyeColor.GREEN;
            case "gray":
                return DyeColor.GRAY;
            case "cyan":
                return DyeColor.CYAN;
            case "brown":
                return DyeColor.BROWN;
            case "blue":
                return DyeColor.BLUE;
            case "yellow":
                return DyeColor.YELLOW;
            case "black":
                return DyeColor.BLACK;
        }
        return DyeColor.WHITE;
    }
    private static Block.Properties GlazedTerracottaProperties(String color) {
        return Block.Properties.of(Material.STONE, getColor(color)).requiresCorrectToolForDrops().strength(1.4F);
    }
    
    static void register() {
        for (String color: COLORS) {
            register(color + "_centered_glazed_terracotta", () -> new GlazedTerracottaBlock(GlazedTerracottaProperties(color)));
            register(color + "_glazed_terracotta_pillar", () -> new RotatedPillarBlock(GlazedTerracottaProperties(color)));
            register(color + "_glazed_terracotta_slab", () -> new GlazedSlabBlock(GlazedTerracottaProperties(color)));
            register(color + "_glazed_terracotta_pillar_slab", () -> new SlabBlock(GlazedTerracottaProperties(color)));
            register(color + "_glazed_terracotta_pillar_side_slab", () -> new GlazedSlabBlock(GlazedTerracottaProperties(color)));
            register(color + "_centered_glazed_terracotta_slab", () -> new SlabBlock(GlazedTerracottaProperties(color)));
            //Future stuff
            //register(color + "_glazed_terracotta_stair", () -> new StairBlock(Blocks.BLACK_GLAZED_TERRACOTTA.defaultBlockState(), GlazedTerracottaProperties(color)));
            //register(color + "_glazed_terracotta_wall", () -> new WallBlock(GlazedTerracottaProperties(color)));
        }
        //Testing run
        //register("black_terracotta_pot", () -> new FlowerPotBlock(null, Blocks.AIR.delegate, GlazedTerracottaProperties(color)));
    }

    private static <T extends Block> RegistryObject<T> register(String name, Supplier<T> block) {
        RegistryObject<T> reg_block = Registration.BLOCKS.register(name, block);
        Registration.ITEMS.register(name, () -> new BlockItem(reg_block.get(), new Item.Properties().tab(ModCreativeTab.instance)));
        
        return reg_block;
    }
}
