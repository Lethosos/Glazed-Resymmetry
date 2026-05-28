package com.lethosos.glazedresymmetry.config;

import java.util.function.Supplier;

import net.neoforged.neoforge.common.ModConfigSpec;

public class GlazedConfig {
	public static final ModConfigSpec COMMON_CONFIG;
	//public static final ModConfigSpec CLIENT_CONFIG;
	
	//COMMON
	public static final String CATEGORY_SETTINGS = "settings";
	public static Supplier<Boolean> SPRAY_AND_PRAY;
	
	static {
		ModConfigSpec.Builder COMMON_BUILDER = new ModConfigSpec.Builder();
		
		COMMON_BUILDER.push(CATEGORY_SETTINGS);
		SPRAY_AND_PRAY = COMMON_BUILDER.comment("Want more bang for your buck with those annoying Wax Covered Shards? Set this to true!")
				.define("spray_n_pray", false);
		COMMON_BUILDER.pop();
		
		COMMON_CONFIG = COMMON_BUILDER.build();
	}
}
