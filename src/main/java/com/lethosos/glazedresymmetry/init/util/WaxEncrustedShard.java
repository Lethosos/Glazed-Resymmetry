package com.lethosos.glazedresymmetry.init.util;

import java.util.ArrayList;
import java.util.List;

import com.lethosos.glazedresymmetry.config.GlazedConfig;

import net.minecraft.core.particles.ItemParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

public class WaxEncrustedShard extends Item {
	private static final float DEFAULT_USE_SECONDS = 4.0F;
	protected final RandomSource random = RandomSource.create();

	public WaxEncrustedShard(Properties properties) {
		super(properties);
	}
	
	@Override
    public void onUseTick(Level level, LivingEntity livingEntity, ItemStack itemstack, int remainingUseDuration) {
        if (remainingUseDuration >= 0 && livingEntity instanceof Player player) {
            float i = this.getUseDuration(itemstack, livingEntity) - remainingUseDuration + 1;
            
            if (check(i)) {
            	spawnItemParticles(itemstack, 2, player);
            	level.playSound(null, player.getX(), player.getY(), player.getZ(),
            		SoundEvents.AXE_SCRAPE, SoundSource.PLAYERS,
                	//1.0F, 1.0F / (level.getRandom().nextFloat() * 0.4F + 1.2F) + i * 0.5F
            		1.0F, 1.0F / (0.4F + 1.2F) + i * 0.5F
            	);
            }
            else {
            	getShard(itemstack, livingEntity);
            }
        }
	}
	
    @Override
    public void releaseUsing(ItemStack stack, Level level, LivingEntity entityLiving, int timeLeft) {
        if (entityLiving instanceof Player player) {
    		ItemStack itemstack = player.getItemInHand(player.getUsedItemHand());
            if (!itemstack.isEmpty()) {
               	getShard(itemstack, entityLiving);
                return;
            }
        }
    }
    
    private boolean check(float i) {
    	if (i < 40.0) { return true; }
    	return false;
    }
    
    private void getShard(ItemStack itemstack, LivingEntity entityLiving) {
    	if (entityLiving instanceof Player player) {
    		List<Item> temp2 = new ArrayList<Item>();
    		GlazedTags.GlazedTagsShardCache.getItemTagContents().forEach((item) -> { temp2.add(item.value().asItem()); });
    		int min = 0, max = temp2.size() - 1;
    		ItemStack newShard = temp2.get(min + (int)(Math.random() * ((max - min) + 1))).getDefaultInstance();
		
    		// I might change dropAround to true for the lulz
    		boolean spread = GlazedConfig.SPRAY_AND_PRAY.get();
    		if (spread) { player.drop(newShard, true, true); }
    		else { player.drop(newShard, false, true); }
    		itemstack.shrink(1);
		
    		player.resetCurrentImpulseContext();
    		player.stopUsingItem();
    		player.getCooldowns().addCooldown(this, 20);
    	}
    }
    
    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        ItemStack itemstack = player.getItemInHand(hand);
        player.startUsingItem(hand);
        return InteractionResultHolder.consume(itemstack);
    }
    
    private void spawnItemParticles(ItemStack stack, int amount, Player player) {
        for (int i = 0; i < amount; i++) {
            Vec3 vec3 = new Vec3(((double)this.random.nextFloat() - 0.5) * 0.1, Math.random() * 0.1 + 0.1, 0.0);
            vec3 = vec3.xRot(-player.getXRot() * (float) (Math.PI / 180.0));
            vec3 = vec3.yRot(-player.getYRot() * (float) (Math.PI / 180.0));
            double d0 = (double)(-this.random.nextFloat()) * 0.6 - 0.3;
            Vec3 vec31 = new Vec3(((double)this.random.nextFloat() - 0.5) * 0.3, d0, 0.6);
            vec31 = vec31.xRot(-player.getXRot() * (float) (Math.PI / 180.0));
            vec31 = vec31.yRot(-player.getYRot() * (float) (Math.PI / 180.0));
            vec31 = vec31.add(player.getX(), player.getEyeY(), player.getZ());
            player.level().addParticle(new ItemParticleOption(ParticleTypes.ITEM, stack), vec31.x, vec31.y, vec31.z, vec3.x, vec3.y + 0.05, vec3.z);
        }
    }
    
	@Override
    public UseAnim getUseAnimation(ItemStack stack) {
        return UseAnim.BRUSH;
    }
	
	@Override
    public int getUseDuration(ItemStack stack, LivingEntity entity) {
        return (int)(WaxEncrustedShard.DEFAULT_USE_SECONDS * 20.0F);
	}
}
