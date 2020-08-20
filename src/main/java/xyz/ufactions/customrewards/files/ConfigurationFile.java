package xyz.ufactions.customrewards.files;

import org.bukkit.ChatColor;
import xyz.ufactions.customrewards.CustomRewards;
import xyz.ufactions.customrewards.gui.internal.GUI;
import xyz.ufactions.customrewards.libs.FileHandler;

public class ConfigurationFile extends FileHandler<CustomRewards> {

    public ConfigurationFile(CustomRewards plugin) {
        super(plugin, "config.yml", plugin.getDataFolder(), "config.yml");
    }

    public String getInventoryName() {
        return getString("inventory-name");
    }

    public GUI.GUIFiller getInventoryFiller() {
        try {
            return GUI.GUIFiller.valueOf(getString("inventory-filler"));
        } catch (EnumConstantNotPresentException e) {
            return GUI.GUIFiller.PANE;
        }
    }

    public ChatColor getInventoryColor() {
        try {
            return ChatColor.valueOf(getString("inventory-color"));
        } catch (EnumConstantNotPresentException e) {
            return ChatColor.RED;
        }
    }

    public int getInventorySize() {
        return getInt("inventory-size");
    }
}