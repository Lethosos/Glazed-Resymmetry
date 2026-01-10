package com.lethosos.glazedresymmetry.datagen;

import com.lethosos.glazedresymmetry.Registration;
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
        super(output, Registration.MOD_ID, exFileHelper);
    }

	@Override
	protected void registerStatesAndModels() {
		DataGenerators.dataList.forEach((group) -> {
			if ( group.groupName != "glazed" ) {
				vanilla = blockTexture(VanillaCheck.returnGlazed(group.groupName));
				centered = resourceBlock(group.groupName + "_centered_glazed_terracotta");
				pillar_side = resourceBlock(group.groupName + "_glazed_terracotta_pillar");
				pillar_top = resourceBlock(group.groupName + "_glazed_terracotta_pillar_top");
			
				blockWithItem(group.CENTERED.get());
				pillarBlock(group.PILLAR.get());
			
				slabBlock(group.CENTERED_SLAB.get(), blockTexture(group.CENTERED.get()), centered);
				slabBlock(group.PILLAR_SLAB.get(), blockTexture(group.PILLAR.get()), pillar_side, pillar_top, pillar_top);
			
				slab = models().slab(group.groupName + "_glazed_terracotta_slab", vanilla, vanilla, vanilla);
				slab_top = models().slabTop(group.groupName + "_glazed_terracotta_slab_top", vanilla, vanilla, vanilla);
				slab_double = models().cubeAll(group.groupName + "_glazed_terracotta_slab_double", vanilla);
				axisSlabBlock(group.SLAB.get(), slab, slab_top, slab_double);
			
				rotated_slab = models()
					.withExistingParent(group.groupName + "_glazed_terracotta_side_pillar_slab", resourceBlock("rotated_slab"))
					.texture("side", pillar_side)
					.texture("top", pillar_top);
				rotated_slab_top = models()
					.withExistingParent(group.groupName + "_glazed_terracotta_side_pillar_slab_top", resourceBlock("rotated_slab_top"))
					.texture("side", pillar_side)
					.texture("top", pillar_top);
				rotated_slab_double = models()
					.withExistingParent(group.groupName + "_glazed_terracotta_side_pillar_slab_double", resourceBlock("rotated_slab_double"))
					.texture("side", pillar_side)
					.texture("top", pillar_top);
				axisSlabBlock(group.SIDE_PILLAR_SLAB.get(),	rotated_slab, rotated_slab_top, rotated_slab_double);
			
				//Flower Pots
				emptyFlowerPot = models()
					.withExistingParent(group.groupName + "_glazed_flower_pot", resourceVanillaBlock("flower_pot"))
					.texture("flowerpot", resourceBlock(group.groupName + "_glazed_flower_pot"))
					.texture("particle", resourceBlock(group.groupName + "_glazed_flower_pot"));
				simpleBlock(group.FLOWER_POT.get(), emptyFlowerPot);
				
				//Glass
				glassAxisBlock(group.GLASS.GLAZED.get());
				glassBlock(group.GLASS.CENTERED.get());
				glassPillarBlock(group.GLASS.PILLAR.get());
				
				//Glass Panes
				//glass_pane = models()
				//	.withExistingParent(group.groupName + "_glazed_glass", resourceVanillaBlock("template_stained_glass_pane"))
				//	.texture("pane", group.groupName + "_glazed_glass");
				//paneBlock
				
				glassPaneBlock((IronBarsBlock)group.GLASS.GLAZED_PANE.get(),
						resourceBlock(group.groupName + "_glazed_glass"),
						resourceVanillaBlock(group.groupName + "_stained_glass_pane_top"));
				glassPaneBlock((IronBarsBlock)group.GLASS.CENTERED_PANE.get(),
						resourceBlock(group.groupName + "_centered_glazed_glass"),
						resourceVanillaBlock(group.groupName + "_stained_glass_pane_top"));
				glassPaneBlock((IronBarsBlock)group.GLASS.PILLAR_TOP_PANE.get(),
						resourceBlock(group.groupName + "_glazed_glass_pillar_top"),
						resourceVanillaBlock(group.groupName + "_stained_glass_pane_top"));
				glassPaneBlock((IronBarsBlock)group.GLASS.SIDE_PILLAR_PANE.get(),
						resourceBlock(group.groupName + "_glazed_glass_pillar"),
						resourceVanillaBlock(group.groupName + "_stained_glass_pane_top"));
			}
		});
	}
	
    private void blockWithItem(Block block) {
    	simpleBlock(block, cubeAll(block));
    }
    private void pillarBlock(Block block) {
        logBlock((RotatedPillarBlock) block);
    }
    
    private void glassBlock(Block block) {
    	simpleBlock(block, glasscubeAll(block));
    }
    private void glassAxisBlock(Block block) {
    	horizontalBlock(block, glasscubeAll(block));
    }
    private ModelFile glasscubeAll(Block block) {
        return models().cubeAll(BuiltInRegistries.BLOCK.getKey(block).getPath(), blockTexture(block)).renderType("translucent");
    }
    private void glassPillarBlock(Block block) {
    	logBlockWithRenderType((RotatedPillarBlock) block, "translucent");
    }
	private void glassPaneBlock(IronBarsBlock ironBarsBlock, ResourceLocation pane, ResourceLocation top) {
    	paneBlockWithRenderType((IronBarsBlock) ironBarsBlock, pane, top, "translucent");
    }

	public ResourceLocation resourceBlock(String path) {
		return ResourceLocation.fromNamespaceAndPath(Registration.MOD_ID, "block/" + path);
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
    /*
    public void axisGlassPaneBlock(IronBarsBlock block) {
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
                	.renderType("translucent")
                	.build();
            },
        	BlockStateProperties.WATERLOGGED);
    }
    */
}