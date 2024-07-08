package com.lethosos.glazedresymmetry.init;

import org.apache.logging.log4j.Level;

import com.lethosos.glazedresymmetry.GlazedResymmetry;
import com.lethosos.glazedresymmetry.Registration;
import com.mojang.datafixers.util.Pair;
import com.teamabnormals.blueprint.core.util.DataUtil;

import net.minecraft.core.registries.Registries;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModPotPatterns {
	public static final DeferredRegister<String> PATTERNS = DeferredRegister.create(Registries.DECORATED_POT_PATTERNS, Registration.MOD_ID);
	
	public static final RegistryObject<String> WHITE = register("white_glazed_pattern");
	public static final RegistryObject<String> LIGHT_GRAY = register("light_gray_glazed_pattern");
	public static final RegistryObject<String> RED = register("red_glazed_pattern");
	public static final RegistryObject<String> PURPLE = register("purple_glazed_pattern");
	public static final RegistryObject<String> PINK = register("pink_glazed_pattern");
	public static final RegistryObject<String> ORANGE = register("orange_glazed_pattern");
	public static final RegistryObject<String> MAGENTA = register("magenta_glazed_pattern");
	public static final RegistryObject<String> LIME = register("lime_glazed_pattern");
	public static final RegistryObject<String> LIGHT_BLUE = register("light_blue_glazed_pattern");
	public static final RegistryObject<String> GREEN = register("green_glazed_pattern");
	public static final RegistryObject<String> GRAY = register("gray_glazed_pattern");
	public static final RegistryObject<String> CYAN = register("cyan_glazed_pattern");
	public static final RegistryObject<String> BROWN = register("brown_glazed_pattern");
	public static final RegistryObject<String> BLUE = register("blue_glazed_pattern");
	public static final RegistryObject<String> YELLOW = register("yellow_glazed_pattern");
	public static final RegistryObject<String> BLACK = register("black_glazed_pattern");
	
	//Clayworks
	public static final RegistryObject<String> GLAZED = register("glazed_pattern");
	
	public static void registerPatterns() {
		
		DataUtil.registerDecoratedPotPattern(Pair.of(ModItems.WHITE_GLAZED_SHARD.get(), WHITE));
		DataUtil.registerDecoratedPotPattern(Pair.of(ModItems.LIGHT_GRAY_GLAZED_SHARD.get(), LIGHT_GRAY));
		DataUtil.registerDecoratedPotPattern(Pair.of(ModItems.RED_GLAZED_SHARD.get(), RED));
		DataUtil.registerDecoratedPotPattern(Pair.of(ModItems.PURPLE_GLAZED_SHARD.get(), PURPLE));
		DataUtil.registerDecoratedPotPattern(Pair.of(ModItems.PINK_GLAZED_SHARD.get(), PINK));
		DataUtil.registerDecoratedPotPattern(Pair.of(ModItems.ORANGE_GLAZED_SHARD.get(), ORANGE));
		DataUtil.registerDecoratedPotPattern(Pair.of(ModItems.MAGENTA_GLAZED_SHARD.get(), MAGENTA));
		DataUtil.registerDecoratedPotPattern(Pair.of(ModItems.LIME_GLAZED_SHARD.get(), LIME));
		DataUtil.registerDecoratedPotPattern(Pair.of(ModItems.LIGHT_BLUE_GLAZED_SHARD.get(), LIGHT_BLUE));
		DataUtil.registerDecoratedPotPattern(Pair.of(ModItems.GREEN_GLAZED_SHARD.get(), GREEN));
		DataUtil.registerDecoratedPotPattern(Pair.of(ModItems.GRAY_GLAZED_SHARD.get(), GRAY));
		DataUtil.registerDecoratedPotPattern(Pair.of(ModItems.CYAN_GLAZED_SHARD.get(), CYAN));
		DataUtil.registerDecoratedPotPattern(Pair.of(ModItems.BROWN_GLAZED_SHARD.get(), BROWN));
		DataUtil.registerDecoratedPotPattern(Pair.of(ModItems.BLUE_GLAZED_SHARD.get(), BLUE));
		DataUtil.registerDecoratedPotPattern(Pair.of(ModItems.YELLOW_GLAZED_SHARD.get(), YELLOW));
		DataUtil.registerDecoratedPotPattern(Pair.of(ModItems.BLACK_GLAZED_SHARD.get(), BLACK));
		
        //Clayworks compat
        if (ModList.get().isLoaded("clayworks")) {
        	DataUtil.registerDecoratedPotPattern(Pair.of(ModItems.GLAZED_SHARD.get(), GLAZED));
        	GlazedResymmetry.LOGGER.log(Level.INFO, "ModPotPatterns: Clayworks Compat registered");
        }
	}
	
	public static RegistryObject<String> register(String name) {
		return PATTERNS.register(name, () -> name);
	}
}