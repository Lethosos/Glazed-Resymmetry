package com.lethosos.glazedresymmetry.data;

import java.util.function.BiConsumer;

import com.lethosos.glazedresymmetry.Registration;
import com.lethosos.glazedresymmetry.init.GlazedBlocks;
import net.minecraft.core.Direction;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraftforge.client.model.generators.BlockModelBuilder;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.client.model.generators.VariantBlockStateBuilder;
import net.minecraftforge.common.data.ExistingFileHelper;

//remove abstract
public abstract class GlazedBlockStates extends BlockStateProvider {

	public static final ResourceLocation BOTTOM = new ResourceLocation("minecraft", "block/black_glazed_terracotta");
    public static final ResourceLocation TOP = new ResourceLocation(Registration.MOD_ID, "block/black_centered_glazed_terracotta");
    public static final ResourceLocation SIDE = new ResourceLocation("minecraft", "block/black_glazed_terracotta");
	
	
	public GlazedBlockStates(PackOutput output, ExistingFileHelper exFileHelper) {
		super(output, Registration.MOD_ID, exFileHelper);
	}
	
	/*
    @Override
    protected void registerStatesAndModels() {
        // generate blockstates
        GlazedFlowerPot.EMPTY_FLOWER_POT_BY_COLOR.forEach((color,block) -> simpleBlock(block.getEmptyPot()));
        GlazedFlowerPot.POTTED_POTS_BY_COLOR_AND_NAME.forEach((color,block) -> simpleBlock(block.get(color).get()));

        // generate models
        // models for glazed pots
        GlazedFlowerPot.POTTED_POTS_BY_COLOR_AND_NAME.forEach((color, block) -> {
            this.models().generatedModels.put(
                    block.get(color).getId(),
                    new GlazedFlowerPotBlockModelProvider(block.get(color).getId(), this.models().existingFileHelper));
        });

        // models for glazed pots cross
        GlazedFlowerPot.POTTED_POTS_BY_COLOR_AND_NAME.forEach((color, block) -> {
            this.models().generatedModels.put(
                    block.get(color).getId(),
                    new GlazedFlowerPotCrossBlockModelProvider(block.get(color).getId(), this.models().existingFileHelper));
        });
    }
    */
    
    private void registerGlazedSlab() {
    	BlockModelBuilder glazedSlab = models().slab(GlazedBlocks.BLACK_GLAZED_TERRACOTTA_SLAB.getId().getPath(), SIDE, BOTTOM, TOP);
        directionBlock(GlazedBlocks.BLACK_GLAZED_TERRACOTTA_SLAB.get(), (state, builder) -> {
            //builder.modelFile(state.BlockStateProperties.FACING ? modelOn : modelOff);
        });
    }

    private VariantBlockStateBuilder directionBlock(Block block, BiConsumer<BlockState, ConfiguredModel.Builder<?>> model) {
        VariantBlockStateBuilder builder = getVariantBuilder(block);
        builder.forAllStates(facing -> {
            ConfiguredModel.Builder<?> bld = ConfiguredModel.builder();
            model.accept(facing, bld);
            applyRotationBld(bld, facing.getValue(BlockStateProperties.FACING));
            return bld.build();
        });
        return builder;
    }

    @SuppressWarnings("incomplete-switch")
	private void applyRotationBld(ConfiguredModel.Builder<?> builder, Direction direction) {
        switch (direction) {
            case NORTH -> { }
            case SOUTH -> builder.rotationY(180);
            case WEST -> builder.rotationY(270);
            case EAST -> builder.rotationY(90);
        }
    }
}

