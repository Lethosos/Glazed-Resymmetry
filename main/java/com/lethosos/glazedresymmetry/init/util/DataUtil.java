package com.lethosos.glazedresymmetry.init.util;

import com.google.common.collect.Maps;
import com.mojang.datafixers.util.Pair;

import net.minecraft.Util;
import net.minecraft.core.RegistryAccess;
import net.minecraft.core.dispenser.BlockSource;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.RegistryOps;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.DecoratedPotPattern;
import net.minecraft.world.level.block.entity.DecoratedPotPatterns;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.util.ObfuscationReflectionHelper;
import net.neoforged.neoforge.common.ModConfigSpec;
import net.neoforged.neoforge.event.server.ServerAboutToStartEvent;
import net.neoforged.neoforge.registries.DeferredHolder;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.*;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.Predicate;

public class DataUtil {

	/**
	 * Adds a Decorated Pot Pattern for Decorated Pots
	 *
	 * @param entries Pairs of an {@link Item} and a {@link net.minecraft.core.Holder} of a String
	 */
	@SafeVarargs
	public static void registerDecoratedPotPattern(Pair<Item, DeferredHolder<String, ?>>... entries) {
		Map<Item, ResourceKey<String>> itemToPotTextureMap = Maps.newHashMap(DecoratedPotPatterns.ITEM_TO_POT_TEXTURE);
		for (Pair<Item, DeferredHolder<String, ?>> entry : entries) {
			itemToPotTextureMap.put(entry.getFirst(), entry.getSecond().getKey());
		}
		DecoratedPotPatterns.ITEM_TO_POT_TEXTURE = itemToPotTextureMap;
	}
	
}
