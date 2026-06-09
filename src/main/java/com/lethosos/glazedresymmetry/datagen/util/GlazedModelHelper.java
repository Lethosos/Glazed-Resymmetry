package com.lethosos.glazedresymmetry.datagen.util;

import com.lethosos.glazedresymmetry.GlazedResymmetry;
import com.lethosos.glazedresymmetry.init.util.GlazedSlabBlock;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.IronBarsBlock;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.SlabType;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ConfiguredModel;
import net.neoforged.neoforge.client.model.generators.ItemModelBuilder;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.client.model.generators.ModelFile;

public class GlazedModelHelper {

	public static ResourceLocation resourceItem(String path) {
		return ResourceLocation.fromNamespaceAndPath(GlazedResymmetry.MOD_ID, "item/" + path);
	}
	public static ResourceLocation resourceVanillaItem(String path) {
		return ResourceLocation.fromNamespaceAndPath("minecraft", "item/" + path);
	}
	public static ResourceLocation resourceBlock(String path) {
		return ResourceLocation.fromNamespaceAndPath(GlazedResymmetry.MOD_ID, "block/" + path);
	}
	public static ResourceLocation resourceVanillaBlock(String path) {
		return ResourceLocation.fromNamespaceAndPath("minecraft", "block/" + path);
	}
	public static ModelFile existingModel(String path) {
		return Blocks.existingModel(path);
	}
	public static ModelFile existingVanillaModel(String path) {
		return Blocks.existingVanillaModel(path);
	}
	
	public class Blocks {
		public static BlockStateProvider bsProvider;
		
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

		public static ModelFile existingModel(String path) {
			return new ModelFile.ExistingModelFile(resourceBlock(path), bsProvider.models().existingFileHelper);
		}
		public static ModelFile existingVanillaModel(String path) {
			return new ModelFile.ExistingModelFile(resourceVanillaBlock(path), bsProvider.models().existingFileHelper);
		}
		
	    public static void blockWithItem(Block block) {
	    	bsProvider.simpleBlock(block, bsProvider.cubeAll(block));
	    }
	    public static void pillarBlock(Block block) {
	    	bsProvider.logBlock((RotatedPillarBlock) block);
	    }
	    
	    public static void glassBlock(Block block) {
	    	bsProvider.simpleBlock(block, glassCubeAll(block));
	    }
	    public static void glassAxisBlock(Block block) {
	    	bsProvider.horizontalBlock(block, glasscubeAxis(block), 0);
	    }
	    public static void glassAxisBlock(Block block, String texture) {
	    	bsProvider.horizontalBlock(block, bsProvider.models()
	    		.withExistingParent(BuiltInRegistries.BLOCK.getKey(block).getPath(), "template_glazed_terracotta")
	        	.renderType("translucent")
	        	.texture("pattern", resourceBlock(texture)), 0);
	    }
	    public static ModelFile glassCubeAll(Block block) {
	    	String name = BuiltInRegistries.BLOCK.getKey(block).getPath();
	    	return bsProvider.models()
	    		.cubeAll(name, resourceBlock(name))
	    		.renderType("translucent");
	    }
	    public static ModelFile glasscubeAxis(Block block) {
	    	String name = BuiltInRegistries.BLOCK.getKey(block).getPath();
	    	return bsProvider.models()
	    		.withExistingParent(name, "template_glazed_terracotta")
	    		.renderType("translucent")
	    		.texture("pattern", resourceBlock(name));
	    }
	    public static void glassPillarBlock(RotatedPillarBlock block, ResourceLocation side, ResourceLocation end) {
	    	bsProvider.axisBlock(block,
	        	bsProvider.models().cubeColumn(BuiltInRegistries.BLOCK.getKey(block).getPath(), side, end).renderType("translucent"),
	        	bsProvider.models().cubeColumnHorizontal(BuiltInRegistries.BLOCK.getKey(block).getPath() + "_horizontal", side, end)
	            	.renderType("translucent"));
	    }
		public static void glassPaneBlock(IronBarsBlock ironBarsBlock, ResourceLocation pane, ResourceLocation top) {
			bsProvider.paneBlockWithRenderType((IronBarsBlock) ironBarsBlock, pane, top, "translucent");
	    }
	    public static void axisSlabBlock(SlabBlock block, ModelFile bottom, ModelFile top, ModelFile doubleslab) {
	    	bsProvider.getVariantBuilder(block)
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
	
	public class Items {
		public static ItemModelProvider iProvider;
		
		public static ItemModelBuilder shadowItem(Item item, ResourceLocation texSource) {
    		return iProvider.getBuilder(item.toString())
                .parent(new ModelFile.UncheckedModelFile("item/generated"))
                .ao(false)
                .texture("layer0", ResourceLocation.fromNamespaceAndPath(texSource.getNamespace(), texSource.getPath()))
                .renderType("translucent");
    	}
    	public ItemModelBuilder shadowModelItem(ResourceLocation item, String model, String texName, ResourceLocation texSource) {
    		return iProvider.getBuilder(item.toString())
                .parent(new ModelFile.UncheckedModelFile(model))
                .texture(texName, ResourceLocation.fromNamespaceAndPath(texSource.getNamespace(), texSource.getPath()));
    	}
	}
}
