package com.lethosos.glazedresymmetry.datagen;

import com.lethosos.glazedresymmetry.GlazedResymmetry;
import com.lethosos.glazedresymmetry.datagen.util.GlazedModelHelper;
import com.lethosos.glazedresymmetry.init.GlazedBlocks;
import com.lethosos.glazedresymmetry.init.util.GlazedGroup;
import com.lethosos.glazedresymmetry.init.util.VanillaCheck;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.IronBarsBlock;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class GlazedBlockStateProvider extends BlockStateProvider {
	protected ResourceLocation vanilla;
	protected ResourceLocation centered;
	protected ResourceLocation pillar_side;
	protected ResourceLocation pillar_top;
	
	protected ModelFile slab;
	protected ModelFile slab_top;
	protected ModelFile slab_double;
	protected ModelFile rotated_slab;
	protected ModelFile rotated_slab_top;
	protected ModelFile rotated_slab_double;
	protected ModelFile emptyFlowerPot;
	protected ModelFile pottedPot;
	protected ModelFile glass_pane;

	protected ModelFile glass;
	protected ModelFile pane;
	
    public GlazedBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, GlazedResymmetry.MOD_ID, exFileHelper);
        GlazedModelHelper.Blocks.bsProvider = this;
    }

	@Override
	protected void registerStatesAndModels() {
		DataGenerators.dataList.forEach((group) -> {
			pushBStates(group);
		});
		
		GlazedModelHelper.Blocks.glassAxisBlock(GlazedBlocks.FLOWERING_GLASS.get(), "flower_patterned_glass_top");
		GlazedModelHelper.Blocks.glassPillarBlock(GlazedBlocks.FLOWERING_GLASS_PILLAR.get(),
				GlazedModelHelper.resourceBlock("flower_patterned_glass_side"),
				GlazedModelHelper.resourceBlock("flower_patterned_glass_top"));
		GlazedModelHelper.Blocks.glassPaneBlock((IronBarsBlock)GlazedBlocks.FLOWERING_GLASS_SIDE_PANE.get(),
				GlazedModelHelper.resourceBlock("flower_patterned_glass_side"),
				GlazedModelHelper.resourceVanillaBlock("red_stained_glass_pane_top"));
		GlazedModelHelper.Blocks.glassPaneBlock((IronBarsBlock)GlazedBlocks.FLOWERING_GLASS_TOP_PANE.get(),
				GlazedModelHelper.resourceBlock("flower_patterned_glass_top"),
				GlazedModelHelper.resourceVanillaBlock("red_stained_glass_pane_top"));
	}
	
	/**
	 * Takes in the GlazedGroup and spits out models and blockstates. Use in your BlockStateProvider.
	 * Remember that group.groupName gets copied and a _ added to fill out the names;
	 * this is for Clayworks compat where the naming convention is just "glazed_whatever".
	 * 
	 * @param group The GlazedGroup to pass.
	 */	
	public void pushBStates(GlazedGroup group){
    	String name = group.groupName;
    	vanilla = blockTexture(VanillaCheck.returnGlazed(name));
    	//Check for Clayworks compat; otherwise don't worry about it.
    	if ( name != "glazed" ) { name = name + "_"; } else { name = new String(); }
    	centered = GlazedModelHelper.resourceBlock(name + "centered_glazed_terracotta");
    	pillar_side = GlazedModelHelper.resourceBlock(name + "glazed_terracotta_pillar");
    	pillar_top = GlazedModelHelper.resourceBlock(name + "glazed_terracotta_pillar_top");

    	GlazedModelHelper.Blocks.blockWithItem(group.CENTERED.get());
    	GlazedModelHelper.Blocks.pillarBlock(group.PILLAR.get());

    	slabBlock(group.CENTERED_SLAB.get(), blockTexture(group.CENTERED.get()), centered);
    	slabBlock(group.PILLAR_SLAB.get(), blockTexture(group.PILLAR.get()), pillar_side, pillar_top, pillar_top);

    	slab = models().slab(name + "glazed_terracotta_slab", vanilla, vanilla, vanilla);
    	slab_top = models().slabTop(name + "glazed_terracotta_slab_top", vanilla, vanilla, vanilla);
    	slab_double = models().cubeAll(name + "glazed_terracotta_slab_double", vanilla);
    	GlazedModelHelper.Blocks.axisSlabBlock(group.SLAB.get(), slab, slab_top, slab_double);

    	rotated_slab = models()
    		.withExistingParent(name + "glazed_terracotta_side_pillar_slab", GlazedModelHelper.resourceBlock("rotated_slab"))
    		.texture("side", pillar_side)
    		.texture("top", pillar_top);
    	rotated_slab_top = models()
    		.withExistingParent(name + "glazed_terracotta_side_pillar_slab_top", GlazedModelHelper.resourceBlock("rotated_slab_top"))
    		.texture("side", pillar_side)
    		.texture("top", pillar_top);
    	rotated_slab_double = models()
    		.withExistingParent(name + "glazed_terracotta_side_pillar_slab_double", GlazedModelHelper.resourceBlock("rotated_slab_double"))
    		.texture("side", pillar_side)
    		.texture("top", pillar_top);
    	GlazedModelHelper.Blocks.axisSlabBlock(group.SIDE_PILLAR_SLAB.get(),
    		rotated_slab, rotated_slab_top, rotated_slab_double);

    	//Flower Pots
    	emptyFlowerPot = models()
    		.withExistingParent(name + "glazed_flower_pot", GlazedModelHelper.resourceVanillaBlock("flower_pot"))
    		.texture("flowerpot", GlazedModelHelper.resourceBlock(name + "glazed_flower_pot"))
    		.texture("particle", GlazedModelHelper.resourceBlock(name + "glazed_flower_pot"));
    	simpleBlock(group.FLOWER_POT.get(), emptyFlowerPot);
	
    	//Glass
    	GlazedModelHelper.Blocks.glassAxisBlock(group.GLASS.GLAZED.get());
    	GlazedModelHelper.Blocks.glassBlock(group.GLASS.CENTERED.get());
    	GlazedModelHelper.Blocks.glassPillarBlock(group.GLASS.PILLAR.get(),
    		GlazedModelHelper.resourceBlock(name + "glazed_glass_pillar"),
			GlazedModelHelper.resourceBlock(name + "glazed_glass_pillar_top"));
	
    	//Glass Panes
    	String paneEdge;
    	// Again, Clayworks compat to just use white edges for glazed glass panes.
    	if ( group.groupName != "glazed" ) { paneEdge = name + "stained_glass_pane_top"; }
    		else { paneEdge = new String("white_stained_glass_pane_top"); }
    	
    	GlazedModelHelper.Blocks.glassPaneBlock((IronBarsBlock)group.GLASS.GLAZED_PANE.get(),
    		GlazedModelHelper.resourceBlock(name + "glazed_glass"),
			GlazedModelHelper.resourceVanillaBlock(paneEdge));
    	GlazedModelHelper.Blocks.glassPaneBlock((IronBarsBlock)group.GLASS.glazed1.get(),
    		GlazedModelHelper.resourceBlock(name + "glazed_glass1"),
			GlazedModelHelper.resourceVanillaBlock(paneEdge));
    	GlazedModelHelper.Blocks.glassPaneBlock((IronBarsBlock)group.GLASS.glazed2.get(),
    		GlazedModelHelper.resourceBlock(name + "glazed_glass2"),
			GlazedModelHelper.resourceVanillaBlock(paneEdge));
    	GlazedModelHelper.Blocks.glassPaneBlock((IronBarsBlock)group.GLASS.glazed3.get(),
    		GlazedModelHelper.resourceBlock(name + "glazed_glass3"),
			GlazedModelHelper.resourceVanillaBlock(paneEdge));
	
    	GlazedModelHelper.Blocks.glassPaneBlock((IronBarsBlock)group.GLASS.CENTERED_PANE.get(),
    		GlazedModelHelper.resourceBlock(name + "centered_glazed_glass"),
			GlazedModelHelper.resourceVanillaBlock(paneEdge));
    	GlazedModelHelper.Blocks.glassPaneBlock((IronBarsBlock)group.GLASS.PILLAR_TOP_PANE.get(),
    		GlazedModelHelper.resourceBlock(name + "glazed_glass_pillar_top"),
			GlazedModelHelper.resourceVanillaBlock(paneEdge));
	
    	GlazedModelHelper.Blocks.glassPaneBlock((IronBarsBlock)group.GLASS.SIDE_PILLAR_PANE.get(),
    		GlazedModelHelper.resourceBlock(name + "glazed_glass_pillar"),
			GlazedModelHelper.resourceVanillaBlock(paneEdge));
    	GlazedModelHelper.Blocks.glassPaneBlock((IronBarsBlock)group.GLASS.side1.get(),
    		GlazedModelHelper.resourceBlock(name + "glazed_glass_pillar1"),
    		GlazedModelHelper.resourceVanillaBlock(paneEdge));
    }
}