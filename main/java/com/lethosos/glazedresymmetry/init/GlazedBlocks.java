package com.lethosos.glazedresymmetry.init;

import java.util.ArrayList;
import java.util.List;

import com.lethosos.glazedresymmetry.Registration;
import com.lethosos.glazedresymmetry.compat.Clayworks;
import com.lethosos.glazedresymmetry.datagen.DataGenerators;
import com.lethosos.glazedresymmetry.init.util.DataUtil;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.entity.DecoratedPotPattern;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import com.mojang.datafixers.util.Pair;

public class GlazedBlocks {
	public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(Registration.MOD_ID);
	public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(Registration.MOD_ID);
	public static final DeferredRegister<DecoratedPotPattern> PATTERNS = DeferredRegister.create(Registries.DECORATED_POT_PATTERN, Registration.MOD_ID);
	public static final DeferredRegister<SoundEvent> SOUNDS = DeferredRegister.create(BuiltInRegistries.SOUND_EVENT, Registration.MOD_ID);

	public static List<GlazedGroup> groupList = new ArrayList<GlazedGroup>();
	public static List<Pair<Item, DeferredHolder<DecoratedPotPattern, ?>>> patternList = new ArrayList<Pair<Item, DeferredHolder<DecoratedPotPattern, ?>>>();
	
	//WHITE
	public static GlazedGroup WHITE = new GlazedGroup("white", DyeColor.WHITE.getMapColor());
	//LIGHT_GRAY
	public static GlazedGroup LIGHT_GRAY = new GlazedGroup("light_gray", DyeColor.LIGHT_GRAY.getMapColor());
	//GRAY
	public static GlazedGroup GRAY = new GlazedGroup("gray", DyeColor.GRAY.getMapColor());
	//BLACK
	public static GlazedGroup BLACK = new GlazedGroup("black", DyeColor.BLACK.getMapColor());
	//BROWN
	public static GlazedGroup BROWN = new GlazedGroup("brown", DyeColor.BROWN.getMapColor());
	//RED
	public static GlazedGroup RED = new GlazedGroup("red", DyeColor.RED.getMapColor());
	//ORANGE
	public static GlazedGroup ORANGE = new GlazedGroup("orange", DyeColor.ORANGE.getMapColor());
	//YELLOW
	public static GlazedGroup YELLOW = new GlazedGroup("yellow", DyeColor.YELLOW.getMapColor());
	//LIME
	public static GlazedGroup LIME = new GlazedGroup("lime", DyeColor.LIME.getMapColor());
	//GREEN
	public static GlazedGroup GREEN = new GlazedGroup("green", DyeColor.GREEN.getMapColor());
	//CYAN
	public static GlazedGroup CYAN = new GlazedGroup("cyan", DyeColor.CYAN.getMapColor());
	//LIGHT_BLUE
	public static GlazedGroup LIGHT_BLUE = new GlazedGroup("light_blue", DyeColor.LIGHT_BLUE.getMapColor());
	//BLUE
	public static GlazedGroup BLUE = new GlazedGroup("blue", DyeColor.BLUE.getMapColor());
	//PURPLE
	public static GlazedGroup PURPLE = new GlazedGroup("purple", DyeColor.PURPLE.getMapColor());
	//MAGENTA
	public static GlazedGroup MAGENTA = new GlazedGroup("magenta", DyeColor.MAGENTA.getMapColor());
	//PINK
	public static GlazedGroup PINK = new GlazedGroup("pink", DyeColor.PINK.getMapColor());
	
	//Gotta register this!
    public static void register(IEventBus eventBus) {
    	groupList.add(WHITE);
    	groupList.add(LIGHT_GRAY);
    	groupList.add(GRAY);
    	groupList.add(BLACK);
    	groupList.add(BROWN);
    	groupList.add(RED);
    	groupList.add(ORANGE);
    	groupList.add(YELLOW);
    	groupList.add(LIME);
    	groupList.add(GREEN);
    	groupList.add(CYAN);
    	groupList.add(LIGHT_BLUE);
    	groupList.add(BLUE);
    	groupList.add(PURPLE);
    	groupList.add(MAGENTA);
    	groupList.add(PINK);
    	
    	Clayworks.register();
    	
    	BLOCKS.register(eventBus);
    	ITEMS.register(eventBus);
    }
    
    //Register Creative Tab stuff collectively here using GlazedGroup.toTab() for each group object
    //Then add to commonSetup() to properly call without errors; GlazedCreativeTab will handle it fine
    public static void setupTab() {
    	groupList.forEach((group) -> {
    		group.toTab();
    	});
    }
    
    public static void registerPatterns() {
    	groupList.forEach((group) -> {
    		DataUtil.registerDecoratedPotPattern(Pair.of(group.SHARD.get(), group.PATTERN));
    	});
    	
    	Clayworks.registerPattern();
    }
    
    public static void populateList() {
    	groupList.forEach((group) -> {
    		DataGenerators.dataList.add(group);
    	});
    }
    
    public static void registerPots() {
    	groupList.forEach((group) -> {
    		group.registerPots();
    	});
    	
    	Clayworks.registerPots();
    }
}
