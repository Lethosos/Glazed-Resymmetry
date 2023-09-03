package com.lethosos.glazedresymmetry;

import net.minecraft.world.item.DyeColor;

public class GlazedColor {
    final public static String[] COLORS = {
            "white", "light_gray", "red", "purple",
            "pink", "orange", "magenta", "lime",
            "light_blue", "green", "gray", "cyan",
            "brown", "blue", "yellow", "black"
    };

    public static DyeColor getColor(String color) {
        switch (color) {
            case "white":
                return DyeColor.WHITE;
            case "light_gray":
                return DyeColor.LIGHT_GRAY;
            case "red":
                return DyeColor.RED;
            case "purple":
                return DyeColor.PURPLE;
            case "pink":
                return DyeColor.PINK;
            case "orange":
                return DyeColor.ORANGE;
            case "magenta":
                return DyeColor.MAGENTA;
            case "lime":
                return DyeColor.LIME;
            case "light_blue":
                return DyeColor.LIGHT_BLUE;
            case "green":
                return DyeColor.GREEN;
            case "gray":
                return DyeColor.GRAY;
            case "cyan":
                return DyeColor.CYAN;
            case "brown":
                return DyeColor.BROWN;
            case "blue":
                return DyeColor.BLUE;
            case "yellow":
                return DyeColor.YELLOW;
            case "black":
                return DyeColor.BLACK;
        }
        return DyeColor.WHITE;
    }
}
