package com.lethosos.glazedresymmetry;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;


@Mod(GlazedResymmetry.MOD_ID)
public class GlazedResymmetry {
    public static final String MOD_ID = "glazedresymmetry";
    public GlazedResymmetry() {
        Registration.register();

        MinecraftForge.EVENT_BUS.register(this);
    }
}
