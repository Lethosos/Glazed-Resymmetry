package com.lethosos.glazedresymmetry.init.util;

import com.lethosos.glazedresymmetry.Registration;
import com.lethosos.glazedresymmetry.init.GlazedBlocks;

import cy.jdkdigital.productivebees.common.entity.bee.ConfigurableBee;
import cy.jdkdigital.productivebees.init.ModEntities;
import cy.jdkdigital.productivebees.util.GeneAttribute;
import net.minecraft.world.entity.Entity.RemovalReason;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Items;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModList;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.level.NoteBlockEvent;
import net.neoforged.neoforge.event.TagsUpdatedEvent;
import net.neoforged.neoforge.event.entity.living.LivingDamageEvent;

@EventBusSubscriber(modid = Registration.MOD_ID)
public class GlazedEvents {
	@SubscribeEvent
	public static void onNoteBlockPlay(NoteBlockEvent.Play event) {
		BlockPos eventPos = event.getPos().below();
		Block testBlock = event.getLevel().getBlockState(eventPos).getBlock();
		Player playerHere = event.getLevel().players().getFirst();
		
		GlazedBlocks.groupList.forEach((group) -> {
			if (testBlock.equals(VanillaCheck.returnGlazed(group.groupName)) 
					|| testBlock.equals(group.SLAB.get())
					|| testBlock.equals(group.CENTERED.get())
					|| testBlock.equals(group.CENTERED_SLAB.get())
					|| testBlock.equals(group.PILLAR.get())
					|| testBlock.equals(group.PILLAR_SLAB.get())
					|| testBlock.equals(group.SIDE_PILLAR_SLAB.get())) {
				event.getLevel().playSound(playerHere, eventPos, GlazedSounds.NOTE_BLOCK_OUD.get(), SoundSource.RECORDS);
			}
		});
	}
	
	//GlazedResymmetry.LOGGER.info("Glazed Bee: This is not a pinata!");
	
	@SubscribeEvent
	public static void onEntityAttacked(LivingDamageEvent.Post event) {
		if (ModList.get().isLoaded("productivebees")) {
			if (event.getSource().getEntity() instanceof LivingEntity attacker && 
					event.getEntity() instanceof ConfigurableBee bee) {
				if (attacker.getWeaponItem().getItem().equals(Items.STICK) && 
						bee.getBeeType().toString().equals("productivebees:glazed")) {
					Level level = event.getEntity().level();
					
					//bee.convertTo(ModEntities.QUARRY_BEE.get(), true);
					//bee.playSound(SoundEvents.DECORATED_POT_SHATTER);
					//GlazedResymmetry.LOGGER.info(attacker.toString());
					
					//bee.attackTarget(attacker);
					//bee.setTarget(attacker);
					//bee.getTarget();
					//bee.updatePersistentAnger((ServerLevel) level, true);
					
					ConfigurableBee newBee = new ConfigurableBee(ModEntities.QUARRY_BEE.get(), event.getEntity().level());
					newBee.setAttributeValue(GeneAttribute.ENDURANCE, bee.getAttributeValue(GeneAttribute.ENDURANCE));
					newBee.setAttributeValue(GeneAttribute.PRODUCTIVITY, bee.getAttributeValue(GeneAttribute.PRODUCTIVITY));
					newBee.setAttributeValue(GeneAttribute.BEHAVIOR, bee.getAttributeValue(GeneAttribute.BEHAVIOR));
					newBee.setTarget(attacker);
					newBee.playSound(SoundEvents.DECORATED_POT_SHATTER);
					newBee.setPos(bee.getBlockX(), bee.getBlockY(), bee.getBlockZ());
					newBee.setDeltaMovement(bee.getDeltaMovement());
					//newBee.setPersistenceRequired();
					bee.remove(RemovalReason.UNLOADED_TO_CHUNK);
					level.addFreshEntity(newBee);
					
					//newBee.finalizeSpawn(level.getServer().getLevel(Level.OVERWORLD), level.getCurrentDifficultyAt(newBee.getOnPos()), MobSpawnType.SPAWN_EGG, null);
					//newBee.setHasStung(false);
					//newBee.setInvulnerable(true);
				}
			}
		}
	}
	
	@SubscribeEvent // on the game event bus
	public static void onTagsUpdated(TagsUpdatedEvent event) {
	    GlazedTags.GlazedTagsShardCache.invalidateCache();
	}
}
