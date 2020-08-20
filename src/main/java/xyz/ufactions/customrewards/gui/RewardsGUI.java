package xyz.ufactions.customrewards.gui;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;
import xyz.ufactions.customrewards.CustomRewards;
import xyz.ufactions.customrewards.data.Reward;
import xyz.ufactions.customrewards.gui.internal.GUI;
import xyz.ufactions.customrewards.gui.internal.button.BasicButton;
import xyz.ufactions.customrewards.libs.F;
import xyz.ufactions.customrewards.libs.ItemBuilder;

public class RewardsGUI extends GUI<CustomRewards> {

    public RewardsGUI(CustomRewards plugin) {
        super(plugin, F.color(plugin.getConfigurationFile().getInventoryName()), plugin.getConfigurationFile().getInventoryFiller());

        setPaneColor(plugin.getConfigurationFile().getInventoryColor());

        for (Reward reward : plugin.getRewardsFile().getRewards()) {
            addButton(new BasicButton<CustomRewards>(plugin, new ItemBuilder(reward.getDisplay()), reward.getSlot()) {

                @Override
                public void onClick(Player player, ClickType type) {
                    if (!player.hasPermission(reward.getPermission())) {
                        player.sendMessage(F.error("No Permission."));
                        return;
                    }
                    for (String command : reward.getCommands()) {
                        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), command.replaceAll("%player%", player.getName()));
                    }
                }
            });
        }
        setSize(plugin.getConfigurationFile().getInventorySize());
    }
}