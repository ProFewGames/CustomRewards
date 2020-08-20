package xyz.ufactions.customrewards.libs;

import org.bukkit.ChatColor;
import org.bukkit.Material;

public class ColorLib {

    public static ItemBuilder cp(ChatColor color) {
        return new ItemBuilder(Material.STAINED_GLASS_PANE, cbyte(color));
    }

    public static ItemBuilder cw(ChatColor color) {
        return new ItemBuilder(Material.WOOL, cbyte(color));
    }

    public static ItemBuilder cb(ChatColor color) {
        return new ItemBuilder(Material.BANNER, cbyte(color));
    }

    private static byte cbyte(ChatColor color) {
        if (color == ChatColor.WHITE) return 0;
        else if (color == ChatColor.GOLD) return 1;
            // MAGENTA
        else if (color == ChatColor.BLUE) return 3;
        else if (color == ChatColor.YELLOW) return 4;
        else if (color == ChatColor.GREEN) return 5;
        else if (color == ChatColor.LIGHT_PURPLE) return 6;
        else if (color == ChatColor.DARK_GRAY) return 7;
        else if (color == ChatColor.GRAY) return 8;
        else if (color == ChatColor.AQUA) return 9;
        else if (color == ChatColor.DARK_PURPLE) return 10;
        else if (color == ChatColor.DARK_BLUE) return 11;
            // BROWN
        else if (color == ChatColor.DARK_GREEN) return 13;
        else if (color == ChatColor.RED) return 14;
        else if (color == ChatColor.BLACK) return 15;
        return 2;
    }

    public static ChatColor randomColor() {
        ChatColor color = ChatColor.values()[UtilMath.r(ChatColor.values().length)];
        while (!color.isColor()) {
            color = ChatColor.values()[UtilMath.r(ChatColor.values().length)];
        }
        return color;
    }
}