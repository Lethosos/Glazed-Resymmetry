package com.lethosos.glazedresymmetry.init.util;

import java.util.function.Supplier;

import com.lethosos.glazedresymmetry.GlazedResymmetry;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.neoforged.neoforge.registries.DeferredRegister;

public class GlazedSounds {
	public static final DeferredRegister<SoundEvent> SOUND_EVENTS =
            DeferredRegister.create(BuiltInRegistries.SOUND_EVENT, GlazedResymmetry.MOD_ID);
	
	public static final Supplier<SoundEvent> NOTE_BLOCK_OUD = registerSoundEvent("oud_play");
    
	private static Supplier<SoundEvent> registerSoundEvent(String name) {
		ResourceLocation id = ResourceLocation.fromNamespaceAndPath(GlazedResymmetry.MOD_ID, name);
		return SOUND_EVENTS.register(name, () -> SoundEvent.createVariableRangeEvent(id));
	}
}
