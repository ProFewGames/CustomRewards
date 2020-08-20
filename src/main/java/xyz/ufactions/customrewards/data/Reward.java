package xyz.ufactions.customrewards.data;

import org.bukkit.inventory.ItemStack;

import java.util.List;

public class Reward {

    private final int slot;
    private final String permission;
    private final ItemStack display;
    private final List<String> commands;

    public Reward(int slot, String permission, ItemStack display, List<String> commands) {
        this.slot = slot;
        this.permission = permission;
        this.display = display;
        this.commands = commands;
    }

    public int getSlot() {
        return slot;
    }

    public String getPermission() {
        return permission;
    }

    public ItemStack getDisplay() {
        return display;
    }

    public List<String> getCommands() {
        return commands;
    }
}