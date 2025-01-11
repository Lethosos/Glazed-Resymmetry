package com.lethosos.glazedresymmetry.init.util.datagen;

import com.lethosos.glazedresymmetry.Registration;
import com.lethosos.glazedresymmetry.init.util.GlazedSlabBlock;
import com.lethosos.glazedresymmetry.init.util.VanillaCheck;

import net.minecraft.core.Direction;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.SlabBlock;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;

public class GlazedBlockStateProvider extends BlockStateProvider {
    public GlazedBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, Registration.MOD_ID, exFileHelper);
    }

	@Override
	protected void registerStatesAndModels() {
		DataGenerators.groupList.forEach((group) -> {
			blockWithItem(group.CENTERED);
			pillarWithItem(group.PILLAR);
			
			//slabBlock(group.SLAB.get(), blockTexture(VanillaCheck.returnGlazed(group.groupName)), blockTexture(VanillaCheck.returnGlazed(group.groupName));
			slabBlock(group.CENTERED_SLAB.get(), blockTexture(group.CENTERED.get()), blockTexture(group.CENTERED.get()));
			slabBlock(group.PILLAR_SLAB.get(), blockTexture(group.PILLAR.get()), blockTexture(group.PILLAR.get()));
			//slabBlock(group.SIDE_PILLAR_SLAB.get(), something, something);
		});
	}
	
    private void blockWithItem(DeferredBlock<?> deferredBlock) {
        simpleBlockWithItem(deferredBlock.get(), cubeAll(deferredBlock.get()));
    }
    
    private void pillarWithItem(DeferredBlock<?> deferredBlock) {
        axisBlock((RotatedPillarBlock) deferredBlock.get());
    }
    
    /*
    private void slabWithRotation(SlabBlock block, ModelFile bottom, ModelFile top, ModelFile doubleslab) {
    	getVariantBuilder(block)
    		.forAllStatesExcept(state -> {
    			 Direction facing = state.getValue(GlazedSlabBlock.FACING);
    		});
    }
    */
    
    /*
    public void stairsBlock(StairBlock block, ModelFile stairs, ModelFile stairsInner, ModelFile stairsOuter) {
        getVariantBuilder(block)
                .forAllStatesExcept(state -> {
                    Direction facing = state.getValue(StairBlock.FACING);
                    Half half = state.getValue(StairBlock.HALF);
                    StairsShape shape = state.getValue(StairBlock.SHAPE);
                    int yRot = (int) facing.getClockWise().toYRot(); // Stairs model is rotated 90 degrees clockwise for some reason
                    if (shape == StairsShape.INNER_LEFT || shape == StairsShape.OUTER_LEFT) {
                        yRot += 270; // Left facing stairs are rotated 90 degrees clockwise
                    }
                    if (shape != StairsShape.STRAIGHT && half == Half.TOP) {
                        yRot += 90; // Top stairs are rotated 90 degrees clockwise
                    }
                    yRot %= 360;
                    boolean uvlock = yRot != 0 || half == Half.TOP; // Don't set uvlock for states that have no rotation
                    return ConfiguredModel.builder()
                            .modelFile(shape == StairsShape.STRAIGHT ? stairs : shape == StairsShape.INNER_LEFT || shape == StairsShape.INNER_RIGHT ? stairsInner : stairsOuter)
                            .rotationX(half == Half.BOTTOM ? 0 : 180)
                            .rotationY(yRot)
                            .uvLock(uvlock)
                            .build();
                }, StairBlock.WATERLOGGED);
    }

    public void slabBlock(SlabBlock block, ModelFile bottom, ModelFile top, ModelFile doubleslab) {
        getVariantBuilder(block)
                .partialState().with(SlabBlock.TYPE, SlabType.BOTTOM).addModels(new ConfiguredModel(bottom))
                .partialState().with(SlabBlock.TYPE, SlabType.TOP).addModels(new ConfiguredModel(top))
                .partialState().with(SlabBlock.TYPE, SlabType.DOUBLE).addModels(new ConfiguredModel(doubleslab));
    }
     */
}
