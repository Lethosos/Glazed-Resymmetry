package com.lethosos.glazedresymmetry.init;

import java.util.ArrayList;
import java.util.List;

import com.lethosos.glazedresymmetry.Registration;
import com.lethosos.glazedresymmetry.datagen.DataGenerators;
import com.lethosos.glazedresymmetry.init.util.DataUtil;
import com.lethosos.glazedresymmetry.init.util.GlazedGroup;
import com.lethosos.glazedresymmetry.init.util.WaxEncrustedShard;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.DecoratedPotPattern;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredItem;
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
	public static GlazedGroup WHITE = new GlazedGroup("white", DyeColor.WHITE);
	//LIGHT_GRAY
	public static GlazedGroup LIGHT_GRAY = new GlazedGroup("light_gray", DyeColor.LIGHT_GRAY);
	//GRAY
	public static GlazedGroup GRAY = new GlazedGroup("gray", DyeColor.GRAY);
	//BLACK
	public static GlazedGroup BLACK = new GlazedGroup("black", DyeColor.BLACK);
	//BROWN
	public static GlazedGroup BROWN = new GlazedGroup("brown", DyeColor.BROWN);
	//RED
	public static GlazedGroup RED = new GlazedGroup("red", DyeColor.RED);
	//ORANGE
	public static GlazedGroup ORANGE = new GlazedGroup("orange", DyeColor.ORANGE);
	//YELLOW
	public static GlazedGroup YELLOW = new GlazedGroup("yellow", DyeColor.YELLOW);
	//LIME
	public static GlazedGroup LIME = new GlazedGroup("lime", DyeColor.LIME);
	//GREEN
	public static GlazedGroup GREEN = new GlazedGroup("green", DyeColor.GREEN);
	//CYAN
	public static GlazedGroup CYAN = new GlazedGroup("cyan", DyeColor.CYAN);
	//LIGHT_BLUE
	public static GlazedGroup LIGHT_BLUE = new GlazedGroup("light_blue", DyeColor.LIGHT_BLUE);
	//BLUE
	public static GlazedGroup BLUE = new GlazedGroup("blue", DyeColor.BLUE);
	//PURPLE
	public static GlazedGroup PURPLE = new GlazedGroup("purple", DyeColor.PURPLE);
	//MAGENTA
	public static GlazedGroup MAGENTA = new GlazedGroup("magenta", DyeColor.MAGENTA);
	//PINK
	public static GlazedGroup PINK = new GlazedGroup("pink", DyeColor.PINK);
	
	// Base models
	public static DeferredBlock<Block> CACTUS = GlazedGroup.registerBlockOnly("cactus_potmodel", 
			() -> new Block(Blocks.CACTUS.properties()));
	public static DeferredBlock<Block> BAMBOO = GlazedGroup.registerBlockOnly("bamboo_potmodel", 
			() -> new Block(Blocks.BAMBOO.properties()));
	public static DeferredBlock<Block> AZALEA = GlazedGroup.registerBlockOnly("azalea_potmodel", 
			() -> new Block(Blocks.AZALEA.properties()));
	public static DeferredBlock<Block> FLOWERING_AZALEA = GlazedGroup.registerBlockOnly("flowering_azalea_potmodel", 
			() -> new Block(Blocks.AZALEA.properties()));
	
	//Rand-O shard item
	public static DeferredItem<Item> WAXED_SHARD = ITEMS.register("wax_encrusted_shard", () -> new WaxEncrustedShard(new Item.Properties().stacksTo(16)));
	
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
    	
    	//Clayworks.register();
    	
    	BLOCKS.register(eventBus);
    	ITEMS.register(eventBus);
    }
    
    //Register Creative Tab stuff collectively here using GlazedGroup.toTab() for each group object
    //Then add to commonSetup() to properly call without errors; GlazedCreativeTab will handle it fine
    public static void setupTab() {
    	groupList.forEach((group) -> {
    		group.toTab();
    	});
    	GlazedCreativeTab.TabList.add(WAXED_SHARD.get());
    }
    
    public static void registerPatterns() {
    	groupList.forEach((group) -> {
    		DataUtil.registerDecoratedPotPattern(Pair.of(group.SHARD.get(), group.PATTERN));
    	});
    	
    	//Clayworks.registerPattern();
    }
    
    public static void populateList() {
    	groupList.forEach((group) -> {
    		DataGenerators.dataList.add(group);
    	});
    }
    
    public static void registerPots() {
    	groupList.forEach((group) -> {
    		//group.registerPots();
    	});
    	
    	//Clayworks.registerPots();
    }
}
