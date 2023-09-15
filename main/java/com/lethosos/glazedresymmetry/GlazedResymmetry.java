package com.lethosos.glazedresymmetry;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;


@Mod(Registration.MOD_ID)
public class GlazedResymmetry {
    
    public GlazedResymmetry() {
        Registration.register();

        MinecraftForge.EVENT_BUS.register(this);
    }
}
