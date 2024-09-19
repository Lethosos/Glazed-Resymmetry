package com.lethosos.glazedresymmetry.data;

import java.util.concurrent.CompletableFuture;
import javax.annotation.Nullable;

import com.lethosos.glazedresymmetry.Registration;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class GlazedBlockTags extends BlockTagsProvider {

    public GlazedBlockTags(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, Registration.MOD_ID, existingFileHelper);
    }

    /*
	protected void addTags() {
        this.tag(GlazedTags.Blocks.POTABLE_PLANTS)
        // small flowers
        .add(Blocks.DANDELION, Blocks.POPPY, Blocks.BLUE_ORCHID, Blocks.ALLIUM, Blocks.AZURE_BLUET,
                Blocks.RED_TULIP, Blocks.ORANGE_TULIP, Blocks.WHITE_TULIP, Blocks.PINK_TULIP, Blocks.OXEYE_DAISY, Blocks.CORNFLOWER,
                Blocks.LILY_OF_THE_VALLEY, Blocks.WITHER_ROSE, Blocks.TORCHFLOWER)
        // saplings
        .add(Blocks.OAK_SAPLING, Blocks.SPRUCE_SAPLING, Blocks.BIRCH_SAPLING,
                Blocks.JUNGLE_SAPLING, Blocks.ACACIA_SAPLING, Blocks.DARK_OAK_SAPLING, Blocks.AZALEA, Blocks.FLOWERING_AZALEA,
                Blocks.MANGROVE_PROPAGULE, Blocks.CHERRY_SAPLING)
        .add(Blocks.FERN)
        .add(Blocks.BAMBOO)
        .add(Blocks.CACTUS)
        .add(Blocks.RED_MUSHROOM)
        .add(Blocks.BROWN_MUSHROOM)
        .add(Blocks.DEAD_BUSH)
        .add(Blocks.CRIMSON_FUNGUS)
        .add(Blocks.WARPED_FUNGUS)
        .add(Blocks.WARPED_ROOTS)
        .add(Blocks.CRIMSON_ROOTS);

        IntrinsicTagAppender<Block> flowerPotTagBuilder = tag(GlazedTags.Blocks.FLOWER_POT);
        //GlazedFlowerPot.POTTED_POTS_BY_COLOR_AND_NAME.forEach( (color, block) -> flowerPotTagBuilder.add(block.get(color).get()) );

        IntrinsicTagAppender<Block> glazedPotTagBuilder = tag(GlazedTags.Blocks.GLAZED_POT);
        //GlazedFlowerPot.EMPTY_FLOWER_POT_BY_COLOR.forEach( (color, block) -> glazedPotTagBuilder.add(block.getEmptyPot()) );
    }
    */
    

	@Override
	protected void addTags(Provider p_256380_) {
		// TODO Auto-generated method stub
		
	}
}
