package com.lethosos.glazedresymmetry.init;

import java.util.function.Supplier;

import org.apache.logging.log4j.Level;

import com.lethosos.glazedresymmetry.GlazedResymmetry;
import com.lethosos.glazedresymmetry.Registration;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
//import net.minecraft.world.level.block.DecoratedPotBlock;
//import net.minecraft.world.level.block.FlowerPotBlock;
import net.minecraft.world.level.block.GlazedTerracottaBlock;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
//import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.minecraftforge.registries.RegistryObject;

public class ModBlocks {

    private static Block.Properties GlazedTerracottaProperties(String color) {
        return BlockBehaviour.Properties.copy(Blocks.STONE).mapColor(GlazedColor.getColor(color)).requiresCorrectToolForDrops().strength(1.4F).pushReaction(PushReaction.PUSH_ONLY);
    }
    
    public static void register() {
        for (String color: GlazedColor.COLORS) {
            register(color + "_centered_glazed_terracotta", () -> new GlazedTerracottaBlock(GlazedTerracottaProperties(color)));
            register(color + "_glazed_terracotta_pillar", () -> new RotatedPillarBlock(GlazedTerracottaProperties(color)));
            register(color + "_glazed_terracotta_slab", () -> new GlazedSlabBlock(GlazedTerracottaProperties(color)));
            register(color + "_glazed_terracotta_pillar_slab", () -> new SlabBlock(GlazedTerracottaProperties(color)));
            register(color + "_glazed_terracotta_pillar_side_slab", () -> new GlazedSlabBlock(GlazedTerracottaProperties(color)));
            register(color + "_centered_glazed_terracotta_slab", () -> new SlabBlock(GlazedTerracottaProperties(color)));
            //Future stuff?
            //register(color + "_glazed_terracotta_stair", () -> new StairBlock(Blocks.BLACK_GLAZED_TERRACOTTA.defaultBlockState(), GlazedTerracottaProperties(color)));
            //register(color + "_glazed_terracotta_wall", () -> new WallBlock(GlazedTerracottaProperties(color)));
            GlazedResymmetry.LOGGER.log(Level.INFO, color + " blocks loaded");
        }
        //Testing run
        //public static final Block FLOWER_POT = register("flower_pot", flowerPot(AIR));
        //public static final Block DECORATED_POT = register("decorated_pot", new DecoratedPotBlock(BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_RED).strength(0.0F, 0.0F).pushReaction(PushReaction.DESTROY).noOcclusion()));
        
        //register("black_terracotta_pot", () -> new FlowerPotBlock(null, Blocks.AIR.delegate, GlazedTerracottaProperties(color)));
        //Clayworks compat
        /*
        if (GlazedResymmetry.clayworks == true) {
        	register("centered_glazed_terracotta", () -> new GlazedTerracottaBlock(GlazedTerracottaProperties("orange")));
        	register("glazed_terracotta_pillar", () -> new RotatedPillarBlock(GlazedTerracottaProperties("orange")));
        	register("glazed_terracotta_slab", () -> new GlazedSlabBlock(GlazedTerracottaProperties("orange")));
        	register("glazed_terracotta_pillar_slab", () -> new SlabBlock(GlazedTerracottaProperties("orange")));
        	register("glazed_terracotta_pillar_side_slab", () -> new GlazedSlabBlock(GlazedTerracottaProperties("orange")));
        	register("centered_glazed_terracotta_slab", () -> new SlabBlock(GlazedTerracottaProperties("orange")));
        }
        */
    }

	private static <T extends Block> RegistryObject<T> register(String name, Supplier<T> block) {
        RegistryObject<T> reg_block = Registration.BLOCKS.register(name, block);
        Registration.ITEMS.register(name, () -> new BlockItem(reg_block.get(), new Item.Properties()));
        
        return reg_block;
    }
}
