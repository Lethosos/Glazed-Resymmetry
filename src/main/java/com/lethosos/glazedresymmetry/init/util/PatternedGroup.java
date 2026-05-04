package com.lethosos.glazedresymmetry.init.util;

import java.util.function.Supplier;

//import com.lethosos.glazedresymmetry.GlazedResymmetry;
import com.lethosos.glazedresymmetry.Registration;
import com.lethosos.glazedresymmetry.init.GlazedBlocks;
import com.lethosos.glazedresymmetry.init.GlazedCreativeTab;

import net.minecraft.tags.TagKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.StainedGlassBlock;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.PushReaction;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

//The orignal mod was Patterned Glass (by tnoctua), but since then it's discontinued, it got folded into GR
public class PatternedGroup {
	public static String groupName;
	public DyeColor color;
	
	public DeferredBlock<StainedGlassBlock> GLAZED;
	public DeferredBlock<StainedGlassBlock> CENTERED;
	public DeferredBlock<GlazedGlassPillar> PILLAR;
	
	public DeferredBlock<GlazedGlassPane> GLAZED_PANE;
	public DeferredBlock<GlazedGlassPane> CENTERED_PANE;
	public DeferredBlock<GlazedGlassPane> PILLAR_TOP_PANE;
	public DeferredBlock<GlazedGlassPane> SIDE_PILLAR_PANE;
	
	public TagKey<Item> GLASS_KEY;
	public TagKey<Item> PANES_KEY;
	
	protected static String GMOD_ID;
	protected static DeferredRegister.Blocks GBLOCK;
	protected static DeferredRegister.Items GITEM;
	
	/*
	 * Internal build only. Use the long form for compat use.
	 */
	public PatternedGroup(String name, DyeColor c) {
		color = c;
		groupName = name;
		
		GBLOCK = GlazedBlocks.BLOCKS;
		GITEM = GlazedBlocks.ITEMS;
		
		GMOD_ID = Registration.MOD_ID;
	
		build2();
	}
	
	public PatternedGroup(String name, DyeColor c, DeferredRegister.Blocks regBlock, DeferredRegister.Items regItem, String modid) {
		color = c;
		groupName = name;
		
		GBLOCK = regBlock;
		GITEM = regItem;
		
		GMOD_ID = modid;
		
		build2();
	}
	
	private void build2() {
		GLAZED = registerBlock(groupName + "_glazed_glass", ()-> new GlazedGlassBlock(GlazedGlassBlock.GlazedGlassProperties(color)));
		CENTERED = registerBlock(groupName + "_centered_glazed_glass", ()-> new StainedGlassBlock(color, GlassProperties()));
		PILLAR = registerBlock(groupName + "_glazed_glass_pillar", ()-> new GlazedGlassPillar(GlazedGlassPillar.GlazedPillarProperties(color)));
		
		GLAZED_PANE = registerBlock(groupName + "_glazed_glass_pane", ()-> new GlazedGlassPane(GlazedGlassPane.GlazedPaneProperties(color)));
		CENTERED_PANE = registerBlock(groupName + "_centered_glazed_glass_pane", ()-> new GlazedGlassPane(GlazedGlassPane.GlazedPaneProperties(color)));
		PILLAR_TOP_PANE = registerBlock(groupName + "_glazed_glass_pane_pillar_top", ()-> new GlazedGlassPane(GlazedGlassPane.GlazedPaneProperties(color)));
		SIDE_PILLAR_PANE = registerBlock(groupName + "_glazed_glass_pane_side_pillar", ()-> new GlazedGlassPane(GlazedGlassPane.GlazedPaneProperties(color)));
        //GlazedResymmetry.LOGGER.info(groupName + " Glass registered");
	}
	
	public static Properties GlassProperties() {
		return Block.Properties.of()
                .strength(0.3F)
                .instrument(NoteBlockInstrument.HAT)
                .sound(SoundType.GLASS)
                .noOcclusion()
                .isValidSpawn(Blocks::never)
                .isRedstoneConductor((state, getter, pos) -> false)
                .isSuffocating((state, getter, pos) -> false)
                .isViewBlocking((state, getter, pos) -> false)
                .pushReaction(PushReaction.PUSH_ONLY);
	}
	
    public static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block) {
        DeferredBlock<T> toReturn = GBLOCK.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> toReturn) {
    	GITEM.register(name, () -> new BlockItem(toReturn.get(), new Item.Properties()));
    }
    
    //external
    public static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block, DeferredRegister.Blocks regBlock, DeferredRegister.Items regItem) {
        DeferredBlock<T> toReturn = regBlock.register(name, block);
        registerBlockItem(name, toReturn, regItem);
        return toReturn;
    }

    //internal
    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> toReturn, DeferredRegister.Items regItem) {
    	regItem.register(name, () -> new BlockItem(toReturn.get(), new Item.Properties()));
    }
    
    protected static <T extends Item> DeferredItem<T> registerItem (String name, Supplier<T> item) {
        DeferredItem<T> toReturn = GITEM.register(name, item);
        return toReturn;
    }
    
	public void addTags(TagKey<Item> glassKey, TagKey<Item> paneKey) {
		GLASS_KEY = glassKey;
		PANES_KEY = paneKey;
	}
    
    public void toTab() {
    	GlazedCreativeTab.TabList.add(GLAZED.asItem());
    	GlazedCreativeTab.TabList.add(CENTERED.asItem());
    	GlazedCreativeTab.TabList.add(PILLAR.asItem());
    	GlazedCreativeTab.TabList.add(GLAZED_PANE.asItem());
    	GlazedCreativeTab.TabList.add(CENTERED_PANE.asItem());
    	GlazedCreativeTab.TabList.add(PILLAR_TOP_PANE.asItem());
    	GlazedCreativeTab.TabList.add(SIDE_PILLAR_PANE.asItem());
    }
}
