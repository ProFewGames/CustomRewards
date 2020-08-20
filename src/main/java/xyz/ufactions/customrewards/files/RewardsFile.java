package xyz.ufactions.customrewards.files;

import org.bukkit.Material;
import xyz.ufactions.customrewards.CustomRewards;
import xyz.ufactions.customrewards.data.Reward;
import xyz.ufactions.customrewards.libs.FileHandler;
import xyz.ufactions.customrewards.libs.ItemBuilder;

import java.util.ArrayList;
import java.util.List;

public class RewardsFile extends FileHandler<CustomRewards> {

    public RewardsFile(CustomRewards plugin) {
        super(plugin, "rewards.yml", plugin.getDataFolder(), "rewards.yml");
    }

    public List<Reward> getRewards() {
        List<Reward> rewards = new ArrayList<>();
        for (String key : getConfigurationSection("rewards").getKeys(false)) {
            String path = "rewards." + key;

            try {
                int slot = getInt(path + ".slot");
                String permission = getString(path + ".permission");

                ItemBuilder builder;
                try {
                    Material material = Material.getMaterial(getString(path + ".display.material"));
                    boolean glow = getBoolean(path + ".display.glow", false);
                    int amount = getInt(path + ".display.amount", 1);
                    String name = getString(path + ".display.name");
                    List<String> lore = getStringList(path + ".display.lore");

                    builder = new ItemBuilder(material).amount(amount).name(name).lore(lore);
                } catch (Exception e) {
                    builder = new ItemBuilder(Material.BEDROCK);
                    builder.name("&4&lFailed to load display.");
                    builder.lore("This is because the configuration file", "for this item is malformed",
                            "Please review your settings");

                    plugin.getLogger().warning("Failed to load reward display. Please provide the following stacktrace with a ticket.");
                    e.printStackTrace(); // TODO CHECK IF DEBUGGING
                }

                List<String> commands = getStringList(path + ".commands");

                rewards.add(new Reward(slot, permission, builder.build(), commands));
            } catch (Exception e) {
                plugin.getLogger().warning("Failed to load reward. Please provide the following stacktrace with a ticket.");
                e.printStackTrace(); // TODO CHECK IF DEBUGGING
            }
        }
        return rewards;
    }
}