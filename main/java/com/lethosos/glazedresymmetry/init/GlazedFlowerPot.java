package com.lethosos.glazedresymmetry.init;

import java.util.HashMap;
import java.util.Map;

import com.lethosos.glazedresymmetry.Registration;
import com.lethosos.glazedresymmetry.init.util.GlazedFlowerPotBlock;
import com.lethosos.glazedresymmetry.init.util.PotablePlants;
import com.teamabnormals.blueprint.core.util.PropertyUtil;
import com.teamabnormals.blueprint.core.util.registry.BlockSubRegistryHelper;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FlowerPotBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegisterEvent;
import net.minecraftforge.registries.RegistryObject;

@SuppressWarnings("deprecation")
@EventBusSubscriber(modid = Registration.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
public class GlazedFlowerPot {
	public static final BlockSubRegistryHelper HELPER = Registration.REGISTRY_HELPER.getBlockSubHelper();
	
	// empty glazed flower pots by color
    public static final Map<String, FlowerPotBlock> EMPTY_FLOWER_POT_BY_COLOR = new HashMap<>(16);
    // color -> registryName(potableBlock) -> potableBlock
    public static final Map<String, Map<String, RegistryObject<Block>>> POTTED_POTS_BY_COLOR_AND_NAME = new HashMap<>();
    
    // color -> registryName(potableBlock) -> RegistryObject(potableBlock)
    //public static final Map<String, Map<String, RegistryObject<Block>>> REGISTERED_POTTED_POTS_BY_COLOR_AND_NAME = new HashMap<>();
    // registered potted glazed pots by registry name
    //public static final Map<ResourceLocation, RegistryObject<Block>> REGISTERED_POTTED_POTS_BY_NAME = new HashMap<>();
	
    //FLOWER POTS
  	public static RegistryObject<Block> BLACK_GLAZED_FP = HELPER.createBlock("black_glazed_flower_pot", () -> newEmptyFlowerPot());
  	public static RegistryObject<Block> BLUE_GLAZED_FP = HELPER.createBlock("blue_glazed_flower_pot", () -> newEmptyFlowerPot());
  	public static RegistryObject<Block> BROWN_GLAZED_FP = HELPER.createBlock("brown_glazed_flower_pot", () -> newEmptyFlowerPot());
  	public static RegistryObject<Block> CYAN_GLAZED_FP = HELPER.createBlock("cyan_glazed_flower_pot", () -> newEmptyFlowerPot());
  	public static RegistryObject<Block> GRAY_GLAZED_FP = HELPER.createBlock("gray_glazed_flower_pot", () -> newEmptyFlowerPot());
  	public static RegistryObject<Block> GREEN_GLAZED_FP = HELPER.createBlock("green_glazed_flower_pot", () -> newEmptyFlowerPot());
  	public static RegistryObject<Block> LIGHT_BLUE_GLAZED_FP = HELPER.createBlock("light_blue_glazed_flower_pot", () -> newEmptyFlowerPot());
  	public static RegistryObject<Block> LIGHT_GRAY_GLAZED_FP = HELPER.createBlock("light_gray_glazed_flower_pot", () -> newEmptyFlowerPot());
  	public static RegistryObject<Block> LIME_GLAZED_FP = HELPER.createBlock("lime_glazed_flower_pot", () -> newEmptyFlowerPot());
  	public static RegistryObject<Block> MAGENTA_GLAZED_FP = HELPER.createBlock("magenta_glazed_flower_pot", () -> newEmptyFlowerPot());
  	public static RegistryObject<Block> ORANGE_GLAZED_FP = HELPER.createBlock("orange_glazed_flower_pot", () -> newEmptyFlowerPot());
  	public static RegistryObject<Block> PINK_GLAZED_FP = HELPER.createBlock("pink_glazed_flower_pot", () -> newEmptyFlowerPot());
  	public static RegistryObject<Block> PURPLE_GLAZED_FP = HELPER.createBlock("purple_glazed_flower_pot", () -> newEmptyFlowerPot());
  	public static RegistryObject<Block> RED_GLAZED_FP = HELPER.createBlock("red_glazed_flower_pot", () -> newEmptyFlowerPot());
  	public static RegistryObject<Block> WHITE_GLAZED_FP = HELPER.createBlock("white_glazed_flower_pot", () -> newEmptyFlowerPot());
  	public static RegistryObject<Block> YELLOW_GLAZED_FP = HELPER.createBlock("yellow_glazed_flower_pot", () -> newEmptyFlowerPot());
  	
    private static Block.Properties GlazedFlowerPotProperties(String color) {
        return BlockBehaviour.Properties.copy(Blocks.FLOWER_POT).mapColor(GlazedColor.getColor(color)).requiresCorrectToolForDrops().instabreak();
    }
    
    public static FlowerPotBlock newEmptyFlowerPot() {
        return new FlowerPotBlock(null, () -> Blocks.AIR, PropertyUtil.flowerPot());
    }
  
   	static int x = 0;
	static String flowerName;
	static String pottedPotName;
	static RegistryObject<Block> tempPot;
	static Map<String, RegistryObject<Block>> pottedFlowerPot = new HashMap<>();
	
	@SubscribeEvent
    public void registerPottedPlants(RegisterEvent event) {
    	for (String color : GlazedColor.COLORS )
    	{
    		while (x != PotablePlants.POTABLE_BLOCKS.size()) {
    			flowerName = PotablePlants.getName(PotablePlants.POTABLE_BLOCKS.get(x));
    			pottedPotName = color + "_glazed_potted_" + flowerName;
    			event.register(ForgeRegistries.Keys.BLOCKS, helper -> tempPot = HELPER.createBlock(pottedPotName, () -> new FlowerPotBlock(PotablePlants.POTABLE_BLOCKS.get(x), PropertyUtil.flowerPot())));
    			pottedFlowerPot.put(flowerName, tempPot);    					
    			POTTED_POTS_BY_COLOR_AND_NAME.put(color, pottedFlowerPot);
    		}
    	}
    }
	
	@SubscribeEvent
	@SuppressWarnings("unlikely-arg-type")
	public static void registerFlowerPots(RegisterEvent event) {
        //add empty glazed pots
    	EMPTY_FLOWER_POT_BY_COLOR.put("black", (FlowerPotBlock) BLACK_GLAZED_FP.get());
    	
    	//pottedFlowerPot.clear();

    	EMPTY_FLOWER_POT_BY_COLOR.forEach((color, emptyPot) -> {
    		POTTED_POTS_BY_COLOR_AND_NAME.forEach((color2, flowerPot) -> {
    			if (color2 == color) {pottedFlowerPot.putAll(flowerPot);}
    		});
    		while (x != PotablePlants.POTABLE_BLOCKS.size())
    		{
    			flowerName = PotablePlants.getName(PotablePlants.POTABLE_BLOCKS.get(x));
    			GlazedFlowerPotBlock pot = new GlazedFlowerPotBlock(() -> EMPTY_FLOWER_POT_BY_COLOR.get(color), PotablePlants.POTABLE_BLOCKS.get(x));
    			event.register(ForgeRegistries.Keys.BLOCKS, helper -> Registration.BLOCKS.register(flowerName, () -> pot));
    			//emptyPot.addPlant(new ResourceLocation(flowerName), pottedFlowerPot.get(flowerName));
    			x++;
    		};
    		x = 0;
    	});
    }
}
