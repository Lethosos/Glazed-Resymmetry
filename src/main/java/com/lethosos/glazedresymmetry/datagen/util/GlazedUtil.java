package com.lethosos.glazedresymmetry.datagen.util;

import com.lethosos.glazedresymmetry.GlazedResymmetry;

import net.minecraft.resources.ResourceLocation;

public class GlazedUtil {
	/**
	 * Created for Lang files to assist in name part capitalization. This is how "light_blue" becomes "Light Blue", for example.
	 */
    public static String formatString(String str) {
        String name = str;
        String[] nameArr = str.split("[_]");
        String returnStr;
        
        if (nameArr.length == 2)
        {
        	String str1 = nameArr[0].substring(0, 1).toUpperCase();
        	String str2 = nameArr[1].substring(0, 1).toUpperCase();
        	returnStr = str1 + nameArr[0].substring(1) + " " + str2 + nameArr[1].substring(1);
        }
        else {
        	String s1 = name.substring(0, 1).toUpperCase();
        	returnStr = s1 + name.substring(1);
        }

        return returnStr;
    }
    /**
     * Very generic method to call from a specific path within the mod; use {@link GlazedModelHelper} for block and item paths.
     */
	public static ResourceLocation resourceLoc(String path) {
		return ResourceLocation.fromNamespaceAndPath(GlazedResymmetry.MOD_ID, path);
	}
}
