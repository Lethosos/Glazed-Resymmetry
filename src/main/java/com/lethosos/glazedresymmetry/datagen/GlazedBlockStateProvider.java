package com.lethosos.glazedresymmetry.datagen;

import com.lethosos.glazedresymmetry.GlazedResymmetry;
import com.lethosos.glazedresymmetry.init.GlazedBlocks;
import com.lethosos.glazedresymmetry.init.util.GlazedGroup;
import com.lethosos.glazedresymmetry.init.util.GlazedSlabBlock;
import com.lethosos.glazedresymmetry.init.util.VanillaCheck;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.IronBarsBlock;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.SlabType;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ConfiguredModel;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class GlazedBlockStateProvider extends BlockStateProvider {
	private static final int DEFAULT_ANGLE_OFFSET = 180;

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
    }

	@Override
	protected void registerStatesAndModels() {
		DataGenerators.dataList.forEach((group) -> {
			pushBStates(group);
		});
		
		glassPillarBlock(GlazedBlocks.FLOWERING_GLASS.get(),
				resourceBlock("flower_patterned_glass_side"),
				resourceBlock("flower_patterned_glass_top"));
		
		glassPaneBlock((IronBarsBlock)GlazedBlocks.FLOWERING_GLASS_SIDE_PANE.get(),
				resourceBlock("flower_patterned_glass_side"),
				resourceVanillaBlock("red_stained_glass_pane_top"));
		glassPaneBlock((IronBarsBlock)GlazedBlocks.FLOWERING_GLASS_TOP_PANE.get(),
				resourceBlock("flower_patterned_glass_top"),
				resourceVanillaBlock("red_stained_glass_pane_top"));
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
    	centered = resourceBlock(name + "centered_glazed_terracotta");
    	pillar_side = resourceBlock(name + "glazed_terracotta_pillar");
    	pillar_top = resourceBlock(name + "glazed_terracotta_pillar_top");

    	blockWithItem(group.CENTERED.get());
    	pillarBlock(group.PILLAR.get());

    	slabBlock(group.CENTERED_SLAB.get(), blockTexture(group.CENTERED.get()), centered);
    	slabBlock(group.PILLAR_SLAB.get(), blockTexture(group.PILLAR.get()), pillar_side, pillar_top, pillar_top);

    	slab = models().slab(name + "glazed_terracotta_slab", vanilla, vanilla, vanilla);
    	slab_top = models().slabTop(name + "glazed_terracotta_slab_top", vanilla, vanilla, vanilla);
    	slab_double = models().cubeAll(name + "glazed_terracotta_slab_double", vanilla);
    	axisSlabBlock(group.SLAB.get(), slab, slab_top, slab_double);

    	rotated_slab = models()
    		.withExistingParent(name + "glazed_terracotta_side_pillar_slab", resourceBlock("rotated_slab"))
    		.texture("side", pillar_side)
    		.texture("top", pillar_top);
    	rotated_slab_top = models()
    		.withExistingParent(name + "glazed_terracotta_side_pillar_slab_top", resourceBlock("rotated_slab_top"))
    		.texture("side", pillar_side)
    		.texture("top", pillar_top);
    	rotated_slab_double = models()
    		.withExistingParent(name + "glazed_terracotta_side_pillar_slab_double", resourceBlock("rotated_slab_double"))
    		.texture("side", pillar_side)
    		.texture("top", pillar_top);
    	axisSlabBlock(group.SIDE_PILLAR_SLAB.get(),	rotated_slab, rotated_slab_top, rotated_slab_double);

    	//Flower Pots
    	emptyFlowerPot = models()
    		.withExistingParent(name + "glazed_flower_pot", resourceVanillaBlock("flower_pot"))
    		.texture("flowerpot", resourceBlock(name + "glazed_flower_pot"))
    		.texture("particle", resourceBlock(name + "glazed_flower_pot"));
    	simpleBlock(group.FLOWER_POT.get(), emptyFlowerPot);
	
    	//Glass
    	glassAxisBlock(group.GLASS.GLAZED.get());
    	glassBlock(group.GLASS.CENTERED.get());
    	glassPillarBlock(group.GLASS.PILLAR.get(),
			resourceBlock(name + "glazed_glass_pillar"),
			resourceBlock(name + "glazed_glass_pillar_top"));
	
    	//Glass Panes
    	String paneEdge;
    	// Again, Clayworks compat to just use white edges for glazed glass panes.
    	if ( group.groupName != "glazed" ) { paneEdge = name + "stained_glass_pane_top"; }
    		else { paneEdge = new String("white_stained_glass_pane_top"); }
    	
    	glassPaneBlock((IronBarsBlock)group.GLASS.GLAZED_PANE.get(),
			resourceBlock(name + "glazed_glass"),
			resourceVanillaBlock(paneEdge));
    	glassPaneBlock((IronBarsBlock)group.GLASS.glazed1.get(),
			resourceBlock(name + "glazed_glass1"),
			resourceVanillaBlock(paneEdge));
    	glassPaneBlock((IronBarsBlock)group.GLASS.glazed2.get(),
			resourceBlock(name + "glazed_glass2"),
			resourceVanillaBlock(paneEdge));
    	glassPaneBlock((IronBarsBlock)group.GLASS.glazed3.get(),
			resourceBlock(name + "glazed_glass3"),
			resourceVanillaBlock(paneEdge));
	
    	glassPaneBlock((IronBarsBlock)group.GLASS.CENTERED_PANE.get(),
			resourceBlock(name + "centered_glazed_glass"),
			resourceVanillaBlock(paneEdge));
    	glassPaneBlock((IronBarsBlock)group.GLASS.PILLAR_TOP_PANE.get(),
			resourceBlock(name + "glazed_glass_pillar_top"),
			resourceVanillaBlock(paneEdge));
	
    	glassPaneBlock((IronBarsBlock)group.GLASS.SIDE_PILLAR_PANE.get(),
			resourceBlock(name + "glazed_glass_pillar"),
			resourceVanillaBlock(paneEdge));
    	glassPaneBlock((IronBarsBlock)group.GLASS.side1.get(),
			resourceBlock(name + "glazed_glass_pillar1"),
			resourceVanillaBlock(paneEdge));
    }
	
    private void blockWithItem(Block block) {
    	simpleBlock(block, cubeAll(block));
    }
    private void pillarBlock(Block block) {
        logBlock((RotatedPillarBlock) block);
    }
    
    private void glassBlock(Block block) {
    	simpleBlock(block, glassCubeAll(block));
    }
    private void glassAxisBlock(Block block) {
    	horizontalBlock(block, glasscubeAxis(block), 0);
    }
    private ModelFile glassCubeAll(Block block) {
    	String name = BuiltInRegistries.BLOCK.getKey(block).getPath();
    	return models()
    		.cubeAll(name, resourceBlock(name))
    		.renderType("translucent");
    }
    private ModelFile glasscubeAxis(Block block) {
    	String name = BuiltInRegistries.BLOCK.getKey(block).getPath();
    	return models()
    		.withExistingParent(name, "template_glazed_terracotta")
    		.renderType("translucent")
    		.texture("pattern", resourceBlock(name));
    }
    private void glassPillarBlock(RotatedPillarBlock block, ResourceLocation side, ResourceLocation end) {
        axisBlock(block,
            models().cubeColumn(BuiltInRegistries.BLOCK.getKey(block).getPath(), side, end).renderType("translucent"),
            models().cubeColumnHorizontal(BuiltInRegistries.BLOCK.getKey(block).getPath() + "_horizontal", side, end)
            	.renderType("translucent"));
    }
	private void glassPaneBlock(IronBarsBlock ironBarsBlock, ResourceLocation pane, ResourceLocation top) {
    	paneBlockWithRenderType((IronBarsBlock) ironBarsBlock, pane, top, "translucent");
    }

	public static ResourceLocation resourceBlock(String path) {
		return ResourceLocation.fromNamespaceAndPath(GlazedResymmetry.MOD_ID, "block/" + path);
	}
	public ResourceLocation resourceVanillaBlock(String path) {
		return ResourceLocation.fromNamespaceAndPath("minecraft", "block/" + path);
	}

	public ModelFile existingModel(String path) {
		return new ModelFile.ExistingModelFile(resourceBlock(path), models().existingFileHelper);
	}
	public ModelFile existingVanillaModel(String path) {
		return new ModelFile.ExistingModelFile(resourceVanillaBlock(path), models().existingFileHelper);
	}

    public void axisSlabBlock(SlabBlock block, ModelFile bottom, ModelFile top, ModelFile doubleslab) {
        getVariantBuilder(block)
        	.forAllStatesExcept(state -> {
                SlabType type = state.getValue(BlockStateProperties.SLAB_TYPE);
                ModelFile model = switch (type) {
                	default -> bottom;
                    case TOP -> top;
                    case DOUBLE -> doubleslab;
                };
                return ConfiguredModel.builder().modelFile(model)
                	.rotationY(((int) state.getValue(GlazedSlabBlock.FACING).toYRot() + DEFAULT_ANGLE_OFFSET) % 360)
                	.build();
            },
        	BlockStateProperties.WATERLOGGED);
    }
}