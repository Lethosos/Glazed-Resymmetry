package com.lethosos.glazedresymmetry.init.util;

import com.lethosos.glazedresymmetry.Registration;
import com.lethosos.glazedresymmetry.init.GlazedBlocks;

import net.minecraft.world.entity.player.Player;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.level.block.Block;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.level.NoteBlockEvent;

@EventBusSubscriber(modid = Registration.MOD_ID, bus = EventBusSubscriber.Bus.GAME)
public class GlazedEvents {
	@SubscribeEvent
	public static void onNoteBlockPlay(NoteBlockEvent.Play event) {
		BlockPos eventPos = event.getPos().below();
		Block testBlock = event.getLevel().getBlockState(eventPos).getBlock();
		Player playerHere = event.getLevel().players().getFirst();
		
		GlazedBlocks.groupList.forEach((group) -> {
			if (testBlock.equals(VanillaCheck.returnGlazed(group.groupName)) 
					||testBlock.equals(group.SLAB.get())
					|| testBlock.equals(group.CENTERED.get())
					|| testBlock.equals(group.CENTERED_SLAB.get())
					|| testBlock.equals(group.PILLAR.get())
					|| testBlock.equals(group.PILLAR_SLAB.get())
					|| testBlock.equals(group.SIDE_PILLAR_SLAB.get())) {
				event.getLevel().playSound(playerHere, eventPos, GlazedSounds.NOTE_BLOCK_OUD.get(), SoundSource.RECORDS);
			}
		});
	}
}
