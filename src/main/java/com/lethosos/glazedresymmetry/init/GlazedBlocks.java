package com.lethosos.glazedresymmetry.init;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.lethosos.glazedresymmetry.GlazedResymmetry;
import com.lethosos.glazedresymmetry.compat.ClayworksCompat;
import com.lethosos.glazedresymmetry.datagen.DataGenerators;
import com.lethosos.glazedresymmetry.init.util.DataUtil;
import com.lethosos.glazedresymmetry.init.util.GlasscutterTool;
import com.lethosos.glazedresymmetry.init.util.GlazedEvents;
import com.lethosos.glazedresymmetry.init.util.GlazedGlassBlock;
import com.lethosos.glazedresymmetry.init.util.GlazedGlassPane;
import com.lethosos.glazedresymmetry.init.util.GlazedGlassPillar;
import com.lethosos.glazedresymmetry.init.util.GlazedGroup;
import com.lethosos.glazedresymmetry.init.util.GlazedTags;
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
	public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(GlazedResymmetry.MOD_ID);
	public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(GlazedResymmetry.MOD_ID);
	public static final DeferredRegister<DecoratedPotPattern> PATTERNS = 
			DeferredRegister.create(Registries.DECORATED_POT_PATTERN, GlazedResymmetry.MOD_ID);
	public static final DeferredRegister<SoundEvent> SOUNDS = 
			DeferredRegister.create(BuiltInRegistries.SOUND_EVENT, GlazedResymmetry.MOD_ID);

	public static List<GlazedGroup> groupList = new ArrayList<GlazedGroup>();
	public static List<Pair<Item, DeferredHolder<DecoratedPotPattern, ?>>> patternList = 
			new ArrayList<Pair<Item, DeferredHolder<DecoratedPotPattern, ?>>>();
	public static Map<Block, Block> CUTTER_MAP = new HashMap<Block, Block>();
	public static List<Block> CUTTER_ROTATABLES = new ArrayList<Block>();
	public static List<Block> GLAZED_NOTEBLOCK_LIST = new ArrayList<Block>();
	
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
	
	//Special flower glass
	public static DeferredBlock<GlazedGlassBlock> FLOWERING_GLASS = GlazedGroup.registerBlock("flowering_glass", 
			() -> new GlazedGlassBlock(GlazedGlassBlock.GlazedGlassProperties(DyeColor.RED)));
	public static DeferredBlock<GlazedGlassPillar> FLOWERING_GLASS_PILLAR = GlazedGroup.registerBlock("flowering_glass_pillar", 
			() -> new GlazedGlassPillar(GlazedGlassPillar.GlazedPillarProperties(DyeColor.RED)));
	public static DeferredBlock<GlazedGlassPane> FLOWERING_GLASS_TOP_PANE = GlazedGroup.registerBlock("flowering_glass_top_pane", 
			() -> new GlazedGlassPane(GlazedGlassPane.GlazedPaneProperties(DyeColor.RED)));
	public static DeferredBlock<GlazedGlassPane> FLOWERING_GLASS_SIDE_PANE = GlazedGroup.registerBlock("flowering_glass_side_pane", 
			() -> new GlazedGlassPane(GlazedGlassPane.GlazedPaneProperties(DyeColor.RED)));
	
	//Rand-O shard item
	public static DeferredItem<WaxEncrustedShard> WAXED_SHARD = ITEMS.register("wax_encrusted_shard", () -> new WaxEncrustedShard(new Item.Properties().stacksTo(16)));
	
	//Glasscutter item
	public static DeferredItem<GlasscutterTool> GLASSCUTTER_TOOL = ITEMS.register("glasscutter", 
			() -> new GlasscutterTool(new Item.Properties().stacksTo(1).durability(256)));
	
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
    	
    	if ( GlazedResymmetry.CLAYWORKS ) {
    		ClayworksCompat.register();
    		groupList.add(ClayworksCompat.GLAZED);
    	}
    	
    	BLOCKS.register(eventBus);
    	ITEMS.register(eventBus);
    	DataGenerators.addKeys();
    	//GlazedTags.GlazedNoteblockCache.getBlockTagContents().forEach((block) -> { GLAZED_NOTEBLOCK_LIST.add(block.value()); });
    }

    //Sets up anything needed during the Enqueue setup.
    public static void setEnqueueExtras() {
    	groupList.forEach((group) -> {
    		if (group.GLASS.GLAZED.isBound()) {
    			//For panes
    			group.GLASS.setPanes();
				CUTTER_MAP.putAll(group.GLASS.PANES_MAP);
				//For glass itself
    			group.GLASS.setRotationList();
				CUTTER_ROTATABLES.addAll(group.GLASS.ROTATE_LIST);
				//For patterns
				DataUtil.registerDecoratedPotPattern(Pair.of(group.SHARD.get(), group.PATTERN));
				group.GLASS.addKeys();
    		}
    	});
    	CUTTER_ROTATABLES.add(FLOWERING_GLASS.get());
    	CUTTER_ROTATABLES.add(FLOWERING_GLASS_PILLAR.get());
    	FLOWERING_GLASS.get().setGlassHolders(FLOWERING_GLASS, FLOWERING_GLASS_PILLAR);
    	FLOWERING_GLASS_PILLAR.get().setGlassHolders(FLOWERING_GLASS, FLOWERING_GLASS_PILLAR);
    }
    
    //Register Creative Tab stuff collectively here using GlazedGroup.toTab() for each group object
    //Then add to commonSetup() to properly call without errors; GlazedCreativeTab will handle it fine
    public static void setupTab() {
    	groupList.forEach((group) -> {
    		group.toTab();
    	});
    	
    	if ( GlazedResymmetry.CLAYWORKS == true ) { ClayworksCompat.GLAZED.toTab();	}
    	
    	GlazedCreativeTab.TabList.add(FLOWERING_GLASS.asItem());
    	GlazedCreativeTab.TabList.add(FLOWERING_GLASS_PILLAR.asItem());
    	GlazedCreativeTab.TabList.add(FLOWERING_GLASS_TOP_PANE.asItem());
    	GlazedCreativeTab.TabList.add(FLOWERING_GLASS_SIDE_PANE.asItem());
    	GlazedCreativeTab.TabList.add(WAXED_SHARD.get());
    	GlazedCreativeTab.TabList.add(GLASSCUTTER_TOOL.get());
    }
    
    public static void populateList() {
    	groupList.forEach((group) -> {
    		DataGenerators.dataList.add(group);
    	});
    }
}
