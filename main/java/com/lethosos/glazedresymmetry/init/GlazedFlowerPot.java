package com.lethosos.glazedresymmetry.init;

import java.util.HashMap;
import java.util.Map;

import com.lethosos.glazedresymmetry.Registration;
import com.lethosos.glazedresymmetry.init.util.PotablePlants;
import com.teamabnormals.blueprint.core.util.PropertyUtil;
import com.teamabnormals.blueprint.core.util.registry.BlockSubRegistryHelper;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FlowerPotBlock;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.registries.RegistryObject;

@EventBusSubscriber(modid = Registration.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
public class GlazedFlowerPot {
	public static final BlockSubRegistryHelper HELPER = Registration.REGISTRY_HELPER.getBlockSubHelper();
	
	// empty glazed flower pots by color
    public static final Map<String, FlowerPotBlock> EMPTY_FLOWER_POT_BY_COLOR = new HashMap<>(16);
    public static final Map<String, Map<String, RegistryObject<Block>>> POTTED_POTS_BY_COLOR_AND_NAME = new HashMap<>();
	
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
  	
  	// Clayworks compat
  	public static RegistryObject<Block> GLAZED_FP = HELPER.createBlock("glazed_flower_pot", () -> newEmptyFlowerPot());
  	
  	/**
  	 * A helper to create an empty FlowerPotBlock object.
  	 * @return a fresh empty flower pot with no plant blocks attached.
  	 */
    public static FlowerPotBlock newEmptyFlowerPot() {
        return new FlowerPotBlock(null, () -> Blocks.AIR, PropertyUtil.flowerPot());
    }
    
    /**
     * A wrapper for registering a flower pot through the Blueprint helper registry.
     * @param name The registry name of the pot.
     * @return Returns an empty flower pot.
     */
    public static RegistryObject<Block> newGlazedFlowerPot(String name) {
    	return HELPER.createBlock(name, () -> newEmptyFlowerPot());
    }
    
    /**
     * Pass empty pots here to add to GR pot builder.
     * @param color The color name for the pot.
     * @param emptyPot The empty flower pot.
     */
    public static void addEmptyPot(String color, FlowerPotBlock emptyPot) {
   		EMPTY_FLOWER_POT_BY_COLOR.put(color, emptyPot);
    }
    
    private static int x = 0;
    private static int size;
    private static String flowerName;
    private static String pottedPotName;
    private static RegistryObject<Block> tempPot;
    private static Map<String, RegistryObject<Block>> pottedFlowerPot = new HashMap<>();
    
    //add empty glazed pots
    private static void emptyPots() {
    	addEmptyPot("black", (FlowerPotBlock) BLACK_GLAZED_FP.get());
    	addEmptyPot("blue", (FlowerPotBlock) BLUE_GLAZED_FP.get());
    	addEmptyPot("brown", (FlowerPotBlock) BROWN_GLAZED_FP.get());
    	addEmptyPot("cyan", (FlowerPotBlock) CYAN_GLAZED_FP.get());
    	addEmptyPot("gray", (FlowerPotBlock) GRAY_GLAZED_FP.get());
    	addEmptyPot("green", (FlowerPotBlock) GREEN_GLAZED_FP.get());
    	addEmptyPot("light_blue", (FlowerPotBlock) LIGHT_BLUE_GLAZED_FP.get());
    	addEmptyPot("light_gray", (FlowerPotBlock) LIGHT_GRAY_GLAZED_FP.get());
    	addEmptyPot("lime", (FlowerPotBlock) LIME_GLAZED_FP.get());
    	addEmptyPot("magenta", (FlowerPotBlock) MAGENTA_GLAZED_FP.get());
    	addEmptyPot("orange", (FlowerPotBlock) ORANGE_GLAZED_FP.get());
    	addEmptyPot("pink", (FlowerPotBlock) PINK_GLAZED_FP.get());
    	addEmptyPot("purple", (FlowerPotBlock) PURPLE_GLAZED_FP.get());
    	addEmptyPot("red", (FlowerPotBlock) RED_GLAZED_FP.get());
    	addEmptyPot("white", (FlowerPotBlock) WHITE_GLAZED_FP.get());
    	addEmptyPot("yellow", (FlowerPotBlock) YELLOW_GLAZED_FP.get());
    	
    	if (ModList.get().isLoaded("clayworks")) {
    		addEmptyPot("glazed", (FlowerPotBlock) GLAZED_FP.get());
    	}
    }
    
    @SuppressWarnings("deprecation")
	public static void registerPottedPlants(IEventBus event) {
    	size = PotablePlants.POTABLE_BLOCKS.size();
    	for (String color : GlazedColor.COLORS )
    	{
    		while (x != size ) {
    			flowerName = PotablePlants.getName(PotablePlants.POTABLE_BLOCKS.get(x));
    			pottedPotName = color + "_glazed_potted_" + flowerName;
    			event.register(tempPot = HELPER.createBlockNoItem(pottedPotName, () -> new FlowerPotBlock(PotablePlants.POTABLE_BLOCKS.get(x), PropertyUtil.flowerPot())));
    			pottedFlowerPot.put(flowerName, tempPot);    					
    			POTTED_POTS_BY_COLOR_AND_NAME.put(color, pottedFlowerPot);
    			x++;
    		}
    		x = 0;
    	}
    	if (ModList.get().isLoaded("clayworks")) {
    		while (x != size ) {
    			flowerName = PotablePlants.getName(PotablePlants.POTABLE_BLOCKS.get(x));
    			pottedPotName = "glazed_potted_" + flowerName;
    			event.register(tempPot = HELPER.createBlockNoItem(pottedPotName, () -> new FlowerPotBlock(PotablePlants.POTABLE_BLOCKS.get(x), PropertyUtil.flowerPot())));
    			pottedFlowerPot.put(flowerName, tempPot);    					
    			POTTED_POTS_BY_COLOR_AND_NAME.put("glazed", pottedFlowerPot);
    			x++;
    		}
    		x = 0;
    	}
    }
    
    /**
     * Use this to add custom flower pots.
     * @param event The bus pass on.
     * @param colorList[] A list of the names of the colors to register each iteration of potted plant with each color. 
     */
    @SuppressWarnings("deprecation")
	public static void registerCustomPottedPlants(IEventBus event, String[] colorList) {
    	for (String color : colorList )
    	{
    		while (x != size ) {
    			flowerName = PotablePlants.getName(PotablePlants.POTABLE_BLOCKS.get(x));
    			pottedPotName = color + "_glazed_potted_" + flowerName;
    			event.register(tempPot = HELPER.createBlockNoItem(pottedPotName, () -> new FlowerPotBlock(PotablePlants.POTABLE_BLOCKS.get(x), PropertyUtil.flowerPot())));
    			pottedFlowerPot.put(flowerName, tempPot);    					
    			POTTED_POTS_BY_COLOR_AND_NAME.put(color, pottedFlowerPot);
    			x++;
    		}
    		x = 0;
    	}
    }
	
	public static void registerFlowerPots(IEventBus event) {
    	emptyPots();
		
    	EMPTY_FLOWER_POT_BY_COLOR.forEach((color, emptyPot) -> {
    		POTTED_POTS_BY_COLOR_AND_NAME.forEach((color2, flowerPot) -> {
    			if (color2 == color) {pottedFlowerPot.putAll(flowerPot);}
    		});
    		while (x != PotablePlants.POTABLE_BLOCKS.size())
    		{
    			flowerName = PotablePlants.getName(PotablePlants.POTABLE_BLOCKS.get(x));
    			emptyPot.addPlant(new ResourceLocation(flowerName), pottedFlowerPot.get(flowerName));
    			x++;
    		};
    		x = 0;
    	});
    }
}
