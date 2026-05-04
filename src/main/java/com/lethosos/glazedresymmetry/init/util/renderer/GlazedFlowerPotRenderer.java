package com.lethosos.glazedresymmetry.init.util.renderer;

import com.lethosos.glazedresymmetry.init.GlazedBlocks;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.block.BlockRenderDispatcher;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

public class GlazedFlowerPotRenderer implements BlockEntityRenderer<GlazedFlowerPotEntity> {
	private BlockRenderDispatcher blockRenderer;
	
    public GlazedFlowerPotRenderer(BlockEntityRendererProvider.Context context) {
    	this.blockRenderer = context.getBlockRenderDispatcher();
    }

    @Override
    public void render(GlazedFlowerPotEntity pBlockEntity, float pPartialTick, PoseStack pPoseStack,
                       MultiBufferSource pBufferSource, int pPackedLight, int pPackedOverlay) {
        //ItemRenderer itemRenderer = Minecraft.getInstance().getItemRenderer();
        //ItemStack stack = pBlockEntity.inventory.getStackInSlot(0);
        
        Item item = pBlockEntity.getItemFromSlot();
        if (item != Items.AIR) {
        	Block block = ((BlockItem) item).getBlock();
        	
        	pPoseStack.pushPose();
        	
       		if (item == Blocks.CACTUS.asItem()) {
       		blockRenderer.renderSingleBlock(GlazedBlocks.CACTUS.get().defaultBlockState(), pPoseStack, pBufferSource, pPackedLight, OverlayTexture.NO_OVERLAY,
       				net.neoforged.neoforge.client.model.data.ModelData.EMPTY, null);
       		}
       		else if (item == Blocks.BAMBOO.asItem()) {
       		blockRenderer.renderSingleBlock(GlazedBlocks.BAMBOO.get().defaultBlockState(), pPoseStack, pBufferSource, pPackedLight, OverlayTexture.NO_OVERLAY,
       				net.neoforged.neoforge.client.model.data.ModelData.EMPTY, null);
       		}
       		else if (item == Blocks.AZALEA.asItem()) {
       		blockRenderer.renderSingleBlock(GlazedBlocks.AZALEA.get().defaultBlockState(), pPoseStack, pBufferSource, pPackedLight, OverlayTexture.NO_OVERLAY,
       				net.neoforged.neoforge.client.model.data.ModelData.EMPTY, null);
       		}
       		else if (item == Blocks.FLOWERING_AZALEA.asItem()) {
       			blockRenderer.renderSingleBlock(GlazedBlocks.FLOWERING_AZALEA.get().defaultBlockState(), pPoseStack, pBufferSource, pPackedLight, OverlayTexture.NO_OVERLAY,
           				net.neoforged.neoforge.client.model.data.ModelData.EMPTY, null);
           	}
         	else {
        		pPoseStack.translate(0.125f, 0.25f, 0.125f);
        		pPoseStack.scale(0.75f, 0.75f, 0.75f);
        		blockRenderer.renderSingleBlock(block.defaultBlockState(), pPoseStack, pBufferSource, pPackedLight, OverlayTexture.NO_OVERLAY,
        				net.neoforged.neoforge.client.model.data.ModelData.EMPTY, null);
        	}
        	
        	//pPoseStack.scale(0.5f, 0.5f, 0.5f);
        	//pPoseStack.mulPose(Axis.YP.rotationDegrees(pBlockEntity.getRenderingRotation()));
        	//itemRenderer.renderStatic(stack, ItemDisplayContext.FIXED, getLightLevel(pBlockEntity.getLevel(),
        	//	pBlockEntity.getBlockPos()), OverlayTexture.NO_OVERLAY, pPoseStack, pBufferSource, pBlockEntity.getLevel(), 1);
        	
        	pPoseStack.popPose();
        }
    }
}
