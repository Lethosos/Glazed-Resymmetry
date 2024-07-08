package com.lethosos.glazedresymmetry.init.util;

import com.teamabnormals.blueprint.core.util.registry.ItemSubRegistryHelper;
import com.teamabnormals.blueprint.core.util.registry.RegistryHelper;

public class ModItemSubRegistryHelper extends ItemSubRegistryHelper {

	public ModItemSubRegistryHelper(RegistryHelper parent) {
		super(parent, parent.getItemSubHelper().getDeferredRegister());
	}
}