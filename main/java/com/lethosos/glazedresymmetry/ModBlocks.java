package com.lethosos.glazedresymmetry;

import java.util.function.Supplier;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
//import net.minecraft.world.level.block.FlowerPotBlock;
import net.minecraft.world.level.block.GlazedTerracottaBlock;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.PushReaction;
import net.minecraftforge.registries.RegistryObject;

public class ModBlocks {

    private static Block.Properties GlazedTerracottaProperties(String color) {
        return BlockBehaviour.Properties.copy(Blocks.STONE).mapColor(GlazedColor.getColor(color)).requiresCorrectToolForDrops().strength(1.4F).pushReaction(PushReaction.PUSH_ONLY);
    }
    
    static void register() {
        for (String color: GlazedColor.COLORS) {
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
        Registration.ITEMS.register(name, () -> new BlockItem(reg_block.get(), new Item.Properties())); //.tab(ModCreativeTab.instance)));
        ModCreativeTab.builder().displayItems((pParemeters, pOutput) -> {
        	pOutput.accept(block.get());
        });
        
        return reg_block;
    }
}
