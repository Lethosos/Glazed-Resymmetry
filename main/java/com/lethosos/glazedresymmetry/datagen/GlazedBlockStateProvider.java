package com.lethosos.glazedresymmetry.datagen;

import com.lethosos.glazedresymmetry.Registration;
import com.lethosos.glazedresymmetry.init.util.GlazedSlabBlock;
import com.lethosos.glazedresymmetry.init.util.PottablePlants;
import com.lethosos.glazedresymmetry.init.util.VanillaCheck;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.SlabType;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ConfiguredModel;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;

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
			
				blockWithItem(group.CENTERED);
				pillarBlock(group.PILLAR);
			
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
				group.pottedPots.forEach((pot) -> {
					if (pot.get().getPotted() == Blocks.AZALEA) {
						pottedPot = models()
							.withExistingParent(group.groupName + "_glazed_potted_" + PottablePlants.getName(pot.get().getPotted()),
									resourceVanillaBlock("template_potted_azalea_bush"))
							.renderType("cutout")
							.texture("flowerpot", resourceBlock(group.groupName + "_glazed_flower_pot"))
							.texture("particle", resourceBlock(group.groupName + "_glazed_flower_pot"))
							.texture("plant", "minecraft:block/potted_azalea_bush_plant")
							.texture("side", "minecraft:block/potted_azalea_bush_side")
							.texture("top", "minecraft:block/potted_azalea_bush_top");
						simpleBlock(pot.get(), pottedPot);
					}
					else if (pot.get().getPotted() == Blocks.FLOWERING_AZALEA) {
						pottedPot = models()
							.withExistingParent(group.groupName + "_glazed_potted_" + PottablePlants.getName(pot.get().getPotted()),
									resourceVanillaBlock("template_potted_azalea_bush"))
							.renderType("cutout")
							.texture("flowerpot", resourceBlock(group.groupName + "_glazed_flower_pot"))
							.texture("particle", resourceBlock(group.groupName + "_glazed_flower_pot"))
							.texture("plant", "minecraft:block/potted_flowering_azalea_bush_plant")
							.texture("side", "minecraft:block/potted_flowering_azalea_bush_side")
							.texture("top", "minecraft:block/potted_flowering_azalea_bush_top");
						simpleBlock(pot.get(), pottedPot);
					}
					else if (pot.get().getPotted() == Blocks.BAMBOO) {
						pottedPot = models()
							.withExistingParent(group.groupName + "_glazed_potted_" + PottablePlants.getName(pot.get().getPotted()),
									resourceVanillaBlock("potted_bamboo"))
							.renderType("cutout")
							.texture("flowerpot", resourceBlock(group.groupName + "_glazed_flower_pot"))
							.texture("particle", resourceBlock(group.groupName + "_glazed_flower_pot"))
							.texture("bamboo", "minecraft:block/bamboo_stalk")
							.texture("leaf", "minecraft:block/bamboo_singleleaf");
						simpleBlock(pot.get(), pottedPot);
					}
					else if (pot.get().getPotted() == Blocks.CACTUS) {
						pottedPot = models()
							.withExistingParent(group.groupName + "_glazed_potted_" + PottablePlants.getName(pot.get().getPotted()),
									resourceVanillaBlock("potted_cactus"))
							.texture("flowerpot", resourceBlock(group.groupName + "_glazed_flower_pot"))
							.texture("particle", resourceBlock(group.groupName + "_glazed_flower_pot"))
							.texture("cactus_top", "minecraft:block/cactus_top")
							.texture("cactus", "minecraft:block/cactus_side");
						simpleBlock(pot.get(), pottedPot);
					}
					else {
						pottedPot = models()
							.withExistingParent(group.groupName + "_glazed_potted_" + PottablePlants.getName(pot.get().getPotted()),
								resourceVanillaBlock("flower_pot_cross"))
							.renderType("cutout")
							.texture("flowerpot", resourceBlock(group.groupName + "_glazed_flower_pot"))
							.texture("particle", resourceBlock(group.groupName + "_glazed_flower_pot"))
							.texture("plant", blockTexture(pot.get().getPotted()));
						simpleBlock(pot.get(), pottedPot);
					}
				});
			}
			/*
			else {
				vanilla = blockTexture(VanillaCheck.returnGlazed(group.groupName));
				centered = resourceBlock("centered_glazed_terracotta");
				pillar_side = resourceBlock("glazed_terracotta_pillar");
				pillar_top = resourceBlock("glazed_terracotta_pillar_top");
				
				blockWithItem(group.CENTERED);
				pillarBlock(group.PILLAR);
				
				slabBlock(group.CENTERED_SLAB.get(), blockTexture(group.CENTERED.get()), centered);
				slabBlock(group.PILLAR_SLAB.get(), blockTexture(group.PILLAR.get()), pillar_side, pillar_top, pillar_top);
				
				slab = models().slab("glazed_terracotta_slab", vanilla, vanilla, vanilla);
				slab_top = models().slabTop("glazed_terracotta_slab_top", vanilla, vanilla, vanilla);
				slab_double = models().cubeAll("glazed_terracotta_slab_double", vanilla);
				axisSlabBlock(group.SLAB.get(), slab, slab_top, slab_double);
				
				rotated_slab = models()
						.withExistingParent("glazed_terracotta_side_pillar_slab", resourceBlock("rotated_slab"))
						.texture("side", pillar_side)
						.texture("top", pillar_top);
				rotated_slab_top = models()
						.withExistingParent("glazed_terracotta_side_pillar_slab_top", resourceBlock("rotated_slab_top"))
						.texture("side", pillar_side)
						.texture("top", pillar_top);
				rotated_slab_double = models()
						.withExistingParent("glazed_terracotta_side_pillar_slab_double", resourceBlock("rotated_slab_double"))
						.texture("side", pillar_side)
						.texture("top", pillar_top);
				axisSlabBlock(group.SIDE_PILLAR_SLAB.get(),	rotated_slab, rotated_slab_top, rotated_slab_double);
				
				//Flower Pots
				emptyFlowerPot = models()
						.withExistingParent("glazed_flower_pot", resourceVanillaBlock("flower_pot"))
						.texture("flowerpot", resourceBlock("glazed_flower_pot"))
						.texture("particle", resourceBlock("glazed_flower_pot"));
				simpleBlock(group.FLOWER_POT.get(), emptyFlowerPot);
				group.pottedPots.forEach((pot) -> {
					if (pot.get().getPotted() == Blocks.AZALEA) {
						pottedPot = models()
								.withExistingParent("glazed_potted_" + PottablePlants.getName(pot.get().getPotted()),
										resourceVanillaBlock("template_potted_azalea_bush"))
								.renderType("cutout")
								.texture("flowerpot", resourceBlock("glazed_flower_pot"))
								.texture("particle", resourceBlock("glazed_flower_pot"))
								.texture("plant", "minecraft:block/potted_azalea_bush_plant")
								.texture("side", "minecraft:block/potted_azalea_bush_side")
								.texture("top", "minecraft:block/potted_azalea_bush_top");
							simpleBlock(pot.get(), pottedPot);
					}
					else if (pot.get().getPotted() == Blocks.FLOWERING_AZALEA) {
						pottedPot = models()
								.withExistingParent("glazed_potted_" + PottablePlants.getName(pot.get().getPotted()),
										resourceVanillaBlock("template_potted_azalea_bush"))
								.renderType("cutout")
								.texture("flowerpot", resourceBlock("glazed_flower_pot"))
								.texture("particle", resourceBlock("glazed_flower_pot"))
								.texture("plant", "minecraft:block/potted_flowering_azalea_bush_plant")
								.texture("side", "minecraft:block/potted_flowering_azalea_bush_side")
								.texture("top", "minecraft:block/potted_flowering_azalea_bush_top");
							simpleBlock(pot.get(), pottedPot);
					}
					else if (pot.get().getPotted() == Blocks.BAMBOO) {
						pottedPot = models()
								.withExistingParent("glazed_potted_" + PottablePlants.getName(pot.get().getPotted()),
										resourceVanillaBlock("potted_bamboo"))
								.renderType("cutout")
								.texture("flowerpot", resourceBlock("glazed_flower_pot"))
								.texture("particle", resourceBlock("glazed_flower_pot"))
								.texture("bamboo", "minecraft:block/bamboo_stalk")
								.texture("leaf", "minecraft:block/bamboo_singleleaf");
							simpleBlock(pot.get(), pottedPot);
					}
					else if (pot.get().getPotted() == Blocks.CACTUS) {
						pottedPot = models()
								.withExistingParent("glazed_potted_" + PottablePlants.getName(pot.get().getPotted()),
										resourceVanillaBlock("potted_cactus"))
								.texture("flowerpot", resourceBlock("glazed_flower_pot"))
								.texture("particle", resourceBlock("glazed_flower_pot"))
								.texture("cactus_top", "minecraft:block/cactus_top")
								.texture("cactus", "minecraft:block/cactus_side");
							simpleBlock(pot.get(), pottedPot);
					}
					else {
						pottedPot = models()
							.withExistingParent("glazed_potted_" + PottablePlants.getName(pot.get().getPotted()),
									resourceVanillaBlock("flower_pot_cross"))
							.renderType("cutout")
							.texture("flowerpot", resourceBlock("glazed_flower_pot"))
							.texture("particle", resourceBlock("glazed_flower_pot"))
							.texture("plant", blockTexture(pot.get().getPotted()));
						simpleBlock(pot.get(), pottedPot);
					}
				});
			}
			*/
		});
	}
	
    private void blockWithItem(DeferredBlock<?> deferredBlock) {
    	simpleBlock(deferredBlock.get(), cubeAll(deferredBlock.get()));
    }
    
    private void pillarBlock(DeferredBlock<?> deferredBlock) {
        logBlock((RotatedPillarBlock) deferredBlock.get());
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
}