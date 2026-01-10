package com.lethosos.glazedresymmetry.init.util;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

import com.lethosos.glazedresymmetry.Registration;
//import com.lethosos.glazedresymmetry.compat.Clayworks;
import com.lethosos.glazedresymmetry.init.GlazedBlocks;
import com.lethosos.glazedresymmetry.init.util.renderer.GlazedFlowerPotEntity;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(BuiltInRegistries.BLOCK_ENTITY_TYPE, Registration.MOD_ID);

    public static final Supplier<BlockEntityType<GlazedFlowerPotEntity>> FLOWERPOT_BE =
            BLOCK_ENTITIES.register("flowerpot_be",
            		() -> BlockEntityType.Builder.of(GlazedFlowerPotEntity::new,
            				GlazedBlocks.WHITE.FLOWER_POT.get(),
            				GlazedBlocks.LIGHT_GRAY.FLOWER_POT.get(),
            				GlazedBlocks.GRAY.FLOWER_POT.get(),
            				GlazedBlocks.BLACK.FLOWER_POT.get(),
            				GlazedBlocks.BROWN.FLOWER_POT.get(),
            				GlazedBlocks.RED.FLOWER_POT.get(),
            				GlazedBlocks.ORANGE.FLOWER_POT.get(),
            				GlazedBlocks.YELLOW.FLOWER_POT.get(),
            				GlazedBlocks.LIME.FLOWER_POT.get(),
            				GlazedBlocks.GREEN.FLOWER_POT.get(),
            				GlazedBlocks.CYAN.FLOWER_POT.get(),
            				GlazedBlocks.LIGHT_BLUE.FLOWER_POT.get(),
            				GlazedBlocks.BLUE.FLOWER_POT.get(),
            				GlazedBlocks.PURPLE.FLOWER_POT.get(),
            				GlazedBlocks.MAGENTA.FLOWER_POT.get(),
            				GlazedBlocks.PINK.FLOWER_POT.get()//,
            				//Clayworks.GLAZED.FLOWER_POT.get()
            				).build(null));

    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}
