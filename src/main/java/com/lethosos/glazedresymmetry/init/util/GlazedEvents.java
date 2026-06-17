package com.lethosos.glazedresymmetry.init.util;

import java.util.ArrayList;
import java.util.List;

import com.lethosos.glazedresymmetry.GlazedResymmetry;
import cy.jdkdigital.productivebees.common.entity.bee.ConfigurableBee;
import cy.jdkdigital.productivebees.init.ModEntities;
import cy.jdkdigital.productivebees.util.GeneAttribute;
import net.minecraft.world.entity.Entity.RemovalReason;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Items;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.NoteBlock;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModList;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.level.NoteBlockEvent;
import net.neoforged.neoforge.event.TagsUpdatedEvent;
import net.neoforged.neoforge.event.entity.living.LivingDamageEvent;

@EventBusSubscriber(modid = GlazedResymmetry.MOD_ID)
public class GlazedEvents {
	@SubscribeEvent
	public static void onNoteBlockPlay(NoteBlockEvent.Play event) {
		BlockPos eventPos = event.getPos().below();
		Block testBlock = event.getLevel().getBlockState(eventPos).getBlock();
		List<Block> notelist = new ArrayList<Block>();
		GlazedTags.GlazedNoteblockCache.getBlockTagContents().forEach((block) -> { notelist.add(block.value()); });
		if (notelist.isEmpty()) { GlazedResymmetry.LOGGER.info("Is Empty!"); }

		notelist.forEach((block) -> {
			if (testBlock.equals(block)) {
				event.getLevel().playSound(event.getLevel().getNearestPlayer(event.getPos().getX(), event.getPos().getY(), event.getPos().getZ(), 16, true), 
						eventPos, GlazedSounds.NOTE_BLOCK_OUD.get(), SoundSource.BLOCKS, 
						3.0f, NoteBlock.getPitchFromNote(event.getVanillaNoteId()));
				//Note: May need to change getVanillaNoteId() for later versions, even if it just *works*.
			}
		});
	}
	
	@SubscribeEvent
	public static void onEntityAttacked(LivingDamageEvent.Post event) {
		if (ModList.get().isLoaded("productivebees")) {
			if (event.getSource().getEntity() instanceof LivingEntity attacker && 
					event.getEntity() instanceof ConfigurableBee bee) {
				if (attacker.getWeaponItem().getItem().equals(Items.STICK) && 
						bee.getBeeType().toString().equals("productivebees:glazed")) {
					Level level = event.getEntity().level();
					
					ConfigurableBee newBee = new ConfigurableBee(ModEntities.QUARRY_BEE.get(), event.getEntity().level());
					newBee.setAttributeValue(GeneAttribute.ENDURANCE, bee.getAttributeValue(GeneAttribute.ENDURANCE));
					newBee.setAttributeValue(GeneAttribute.PRODUCTIVITY, bee.getAttributeValue(GeneAttribute.PRODUCTIVITY));
					newBee.setAttributeValue(GeneAttribute.BEHAVIOR, bee.getAttributeValue(GeneAttribute.BEHAVIOR));
					newBee.setTarget(attacker);
					newBee.playSound(SoundEvents.DECORATED_POT_SHATTER);
					newBee.setPos(bee.getBlockX(), bee.getBlockY(), bee.getBlockZ());
					newBee.setDeltaMovement(bee.getDeltaMovement());
					bee.remove(RemovalReason.UNLOADED_TO_CHUNK);
					level.addFreshEntity(newBee);
				}
			}
		}
	}
	
	@SubscribeEvent // on the game event bus
	public static void onTagsUpdated(TagsUpdatedEvent event) {
	    GlazedTags.GlazedTagsShardCache.invalidateCache();
	}
}
