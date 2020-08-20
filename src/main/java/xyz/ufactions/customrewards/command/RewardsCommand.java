package xyz.ufactions.customrewards.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import xyz.ufactions.customrewards.CustomRewards;
import xyz.ufactions.customrewards.data.Reward;
import xyz.ufactions.customrewards.gui.RewardsGUI;
import xyz.ufactions.customrewards.libs.F;

import java.util.Collections;
import java.util.List;

public class RewardsCommand implements TabCompleter, CommandExecutor {

    private final CustomRewards plugin;

    public RewardsCommand(CustomRewards plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(F.error("You must be an in-game player to execute this command."));
            return true;
        }
        Player player = (Player) sender;
        List<Reward> rewards = plugin.getRewardsFile().getRewards();
        if (rewards.isEmpty()) {
            player.sendMessage(F.error("There are no loaded rewards."));
            return true;
        }
        new RewardsGUI(plugin).openInventory(player);
        return true;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String label, String[] args) {
        return Collections.emptyList();
    }
}