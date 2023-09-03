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

    public static final ResourceKey<CreativeModeTab> TAB_KEY = ResourceKey.create(Registries.CREATIVE_MODE_TAB, new ResourceLocation(MOD_ID, "base"));
    @Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, modid = MOD_ID)
    public class EventHandler
    {
        @SubscribeEvent
        public static void buildContents(BuildCreativeModeTabContentsEvent event) {
            if (event.getTabKey().equals(TAB_KEY)) {
                for (RegistryObject<Item> item: Registration.ITEMS.getEntries()) {
                    event.accept(item);
                }
            }
        }
    }
}
