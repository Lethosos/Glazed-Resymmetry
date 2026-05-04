package com.lethosos.glazedresymmetry.init.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

import com.lethosos.glazedresymmetry.GlazedResymmetry;
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
public class GlassGroup {
	public static String groupName;
	public DyeColor color;
	
	public DeferredBlock<StainedGlassBlock> GLAZED;
	public DeferredBlock<StainedGlassBlock> CENTERED;
	public DeferredBlock<GlazedGlassPillar> PILLAR;
	
	public DeferredBlock<GlazedGlassPane> GLAZED_PANE;
	public DeferredBlock<GlazedGlassPane> CENTERED_PANE;
	public DeferredBlock<GlazedGlassPane> PILLAR_TOP_PANE;
	public DeferredBlock<GlazedGlassPane> SIDE_PILLAR_PANE;

	public DeferredBlock<GlazedGlassPane> glazed1;
	public DeferredBlock<GlazedGlassPane> glazed2;
	public DeferredBlock<GlazedGlassPane> glazed3;
	public DeferredBlock<GlazedGlassPane> side1;
	
	protected static String GMOD_ID;
	protected static DeferredRegister.Blocks GBLOCK;
	protected static DeferredRegister.Items GITEM;
	
	public TagKey<Item> GLASS_KEY;
	public TagKey<Item> PANES_KEY;
	
	protected static List<Block> OCCL_LIST = new ArrayList<Block>();
	
	public Map<Block, Block> PANES_MAP;
	public List<Block> ROTATE_LIST;
	
	/*
	 * Internal build only. Use the long form for compat use.
	 */
	public GlassGroup(String name, DyeColor c) {
		color = c;
		groupName = name;
		
		GBLOCK = GlazedBlocks.BLOCKS;
		GITEM = GlazedBlocks.ITEMS;
		
		GMOD_ID = GlazedResymmetry.MOD_ID;
	
		//Compat check
		if (groupName != "glazed") { build2(); }
	}
	
	public GlassGroup(String name, DyeColor c, DeferredRegister.Blocks regBlock, DeferredRegister.Items regItem, String modid) {
		color = c;
		groupName = name;
		
		GBLOCK = regBlock;
		GITEM = regItem;
		
		GMOD_ID = modid;

		build2();
	}
	
	private void build2() {
		GLAZED = registerBlock(groupName + "_glazed_glass", ()-> new GlazedGlassBlock(GlazedGlassBlock.GlazedGlassProperties(color), CENTERED, PILLAR));
		CENTERED = registerBlock(groupName + "_centered_glazed_glass", ()-> new GlazedGlassBlock(GlazedGlassBlock.GlazedGlassProperties(color), GLAZED, PILLAR));
		PILLAR = registerBlock(groupName + "_glazed_glass_pillar", ()-> new GlazedGlassPillar(GlazedGlassPillar.GlazedPillarProperties(color), GLAZED, CENTERED));
		
		GLAZED_PANE = registerBlock(groupName + "_glazed_glass_pane", ()-> new GlazedGlassPane(GlazedGlassPane.GlazedPaneProperties(color)));
		CENTERED_PANE = registerBlock(groupName + "_centered_glazed_glass_pane", ()-> new GlazedGlassPane(GlazedGlassPane.GlazedPaneProperties(color)));
		PILLAR_TOP_PANE = registerBlock(groupName + "_glazed_glass_pane_pillar_top", ()-> new GlazedGlassPane(GlazedGlassPane.GlazedPaneProperties(color)));
		SIDE_PILLAR_PANE = registerBlock(groupName + "_glazed_glass_pane_side_pillar", ()-> new GlazedGlassPane(GlazedGlassPane.GlazedPaneProperties(color)));
		
		glazed1 = registerBlock(groupName + "_glazed_glass_pane1", ()-> new GlazedGlassPane(GlazedGlassPane.GlazedPaneProperties(color)));
		glazed2 = registerBlock(groupName + "_glazed_glass_pane2", ()-> new GlazedGlassPane(GlazedGlassPane.GlazedPaneProperties(color)));
		glazed3 = registerBlock(groupName + "_glazed_glass_pane3", ()-> new GlazedGlassPane(GlazedGlassPane.GlazedPaneProperties(color)));
		side1 = registerBlock(groupName + "_glazed_glass_pane_side_pillar1", ()-> new GlazedGlassPane(GlazedGlassPane.GlazedPaneProperties(color)));
	}
	
	public void addTags(TagKey<Item> glassKey, TagKey<Item> paneKey) {
		GLASS_KEY = glassKey;
		PANES_KEY = paneKey;
	}
	
	public void setPanes() {
		PANES_MAP = Map.of(
				GLAZED_PANE.get(), glazed1.get(),
				glazed1.get(), glazed2.get(),
				glazed2.get(), glazed3.get(),
				glazed3.get(), GLAZED_PANE.get(),
				SIDE_PILLAR_PANE.get(), side1.get(),
				side1.get(), SIDE_PILLAR_PANE.get());
	}
	
	public void setRotationList() {
		ROTATE_LIST = List.of(GLAZED.get(), PILLAR.get());
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
