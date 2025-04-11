package com.lethosos.glazedresymmetry.init.util;

import com.google.common.collect.Maps;
import com.mojang.datafixers.util.Pair;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.entity.DecoratedPotPattern;
import net.minecraft.world.level.block.entity.DecoratedPotPatterns;
import net.neoforged.neoforge.registries.DeferredHolder;

import java.util.*;

public final class DataUtil {

	/**
	 * Adds a Decorated Pot Pattern for Decorated Pots
	 *
	 * @param entries Pairs of an {@link Item} and a {@link net.neoforged.neoforge.registries.DeferredHolder} of
	 *  a DecoratedPotPattern (which in itself is a record for a ResourceLocation)
	 */
	@SafeVarargs
	public static void registerDecoratedPotPattern(Pair<Item, DeferredHolder<DecoratedPotPattern, ?>>... entries) {
		Map<Item, ResourceKey<DecoratedPotPattern>> itemToPotTextureMap = Maps.newHashMap(DecoratedPotPatterns.ITEM_TO_POT_TEXTURE);
		for (Pair<Item, DeferredHolder<DecoratedPotPattern, ?>> entry : entries) {
			itemToPotTextureMap.put(entry.getFirst(), entry.getSecond().getKey());
		}
		DecoratedPotPatterns.ITEM_TO_POT_TEXTURE = itemToPotTextureMap;
	}
}
