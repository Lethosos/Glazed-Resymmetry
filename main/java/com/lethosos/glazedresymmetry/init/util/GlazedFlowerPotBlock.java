package com.lethosos.glazedresymmetry.init.util;

import java.util.function.Supplier;

import javax.annotation.Nullable;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.FlowerPotBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.phys.shapes.VoxelShape;

public class GlazedFlowerPotBlock extends FlowerPotBlock {

    protected static final VoxelShape SHAPE = Block.box(5.0D, 0.0D, 5.0D, 11.0D, 6.0D, 11.0D);

    @SuppressWarnings({ "deprecation" })
	public GlazedFlowerPotBlock(@Nullable Supplier<FlowerPotBlock> emptyPot, Block block) {
        super(emptyPot, () -> block, BlockBehaviour.Properties.copy(emptyPot.get()));

        if(emptyPot != null) {
            emptyPot.get().addPlant(ResourceLocation.tryParse(this.builtInRegistryHolder().toString()), () -> this);
        }
    }
}
