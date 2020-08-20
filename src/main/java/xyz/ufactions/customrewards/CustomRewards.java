package xyz.ufactions.customrewards;

import org.bukkit.plugin.java.JavaPlugin;
import xyz.ufactions.customrewards.command.RewardsCommand;
import xyz.ufactions.customrewards.files.ConfigurationFile;
import xyz.ufactions.customrewards.files.RewardsFile;
import xyz.ufactions.customrewards.updater.Updater;

public class CustomRewards extends JavaPlugin {

    private RewardsFile rewardsFile;
    private ConfigurationFile configurationFile;

    @Override
    public void onEnable() {
        new Updater(this); // UPDATER
        this.rewardsFile = new RewardsFile(this);
        this.configurationFile = new ConfigurationFile(this);

        getCommand("customrewards").setExecutor(new RewardsCommand(this));
    }

    public RewardsFile getRewardsFile() {
        return rewardsFile;
    }

    public ConfigurationFile getConfigurationFile() {
        return configurationFile;
    }
}