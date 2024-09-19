package com.lethosos.glazedresymmetry.data;

import com.lethosos.glazedresymmetry.Registration;
import com.lethosos.glazedresymmetry.init.GlazedBlocks;

import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.LanguageProvider;

public class GlazedLanguageProvider extends LanguageProvider {

    public GlazedLanguageProvider(PackOutput output, String locale) {
        super(output, Registration.MOD_ID, locale);
    }

    @Override
    protected void addTranslations() {
        add(GlazedBlocks.BLACK_CENTERED_GLAZED_TERRACOTTA.get(), "Black Glazed Centered Terracotta");
    }
}
