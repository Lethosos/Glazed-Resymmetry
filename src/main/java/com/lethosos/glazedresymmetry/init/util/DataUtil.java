package com.lethosos.glazedresymmetry.init.util;

import com.google.common.collect.Maps;
import com.lethosos.glazedresymmetry.GlazedResymmetry;
import com.mojang.datafixers.util.Pair;

import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.entity.DecoratedPotPattern;
import net.minecraft.world.level.block.entity.DecoratedPotPatterns;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.*;

public final class DataUtil {
	public static final DeferredRegister<DataComponentType<?>> DATA_COMPONENT_TYPES =
            DeferredRegister.createDataComponents(Registries.DATA_COMPONENT_TYPE, GlazedResymmetry.MOD_ID);

    public static void register(IEventBus eventBus) {
        DATA_COMPONENT_TYPES.register(eventBus);
    }
    
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
