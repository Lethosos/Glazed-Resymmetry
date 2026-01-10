package com.lethosos.glazedresymmetry.init.util;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class WaxEncrustedShard extends Item{

	public WaxEncrustedShard(Properties properties) {
		super(properties);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand usedHand)
	{
		ItemStack itemstack = player.getItemInHand(usedHand);
		List<Item> temp2 = new ArrayList<Item>();
		GlazedTags.GlazedTagsShardCache.getItemTagContents().forEach((item) -> {
			temp2.add(item.value().asItem());
		});
		int min = 0, max = temp2.size() - 1;
		ItemStack newShard = temp2.get(min + (int)(Math.random() * ((max - min) + 1))).getDefaultInstance();
		player.spawnAtLocation(newShard, 0);
		itemstack.shrink(1);
		return InteractionResultHolder.consume(itemstack);
	}

}
