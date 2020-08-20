package xyz.ufactions.customrewards.libs;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * Notice as of 1.13.2 MegaBukkit support for
 * Material ID's has been stopped please use Material
 * Names.
 */
public class ItemBuilder {

    private static DullEnchantment ENCHANTMENT;

    static {
        try {
            Field field = Enchantment.class.getDeclaredField("acceptingNew");
            field.setAccessible(true);
            field.set(null, true);

            ENCHANTMENT = new DullEnchantment();

            Enchantment.registerEnchantment(ENCHANTMENT);
        } catch (Exception ignored) {
        }
    }

    private final ItemStack item;

    public ItemBuilder(ItemStack item) {
        this.item = item;
    }

    public ItemBuilder(Material material) {
        this(material, 0);
    }

    public ItemBuilder(Material material, int data) {
        this(material, 1, data);
    }

    /**
     * Regular Item Creator
     *
     * @param material The material of the item
     * @param amount   How much of the material do you want the item
     * @param data     The item's data
     */
    public ItemBuilder(Material material, int amount, int data) {
        this.item = new ItemStack(material, amount, (short) data);
    }

    public ItemBuilder glow(boolean glow) {
        if (glow) this.item.addEnchantment(ENCHANTMENT, 1);
        return this;
    }

    public ItemBuilder amount(int amount) {
        this.item.setAmount(amount);
        return this;
    }

    public ItemBuilder name(String name) {
        ItemMeta meta = this.item.getItemMeta();
        meta.setDisplayName(cc((name.startsWith("&") ? "&f" : "") + name));
        this.item.setItemMeta(meta);
        return this;
    }

    public ItemBuilder lore(List<String> lore) {
        ItemMeta meta = this.item.getItemMeta();
        List<String> finLore = new ArrayList<String>();
        for (String line : lore) {
            finLore.add(cc("&7" + line));
        }
        meta.setLore(finLore);
        this.item.setItemMeta(meta);
        return this;
    }

    public ItemBuilder lore(String... strings) {
        ItemMeta meta = this.item.getItemMeta();
        List<String> lore = new ArrayList<String>();
        for (String string : strings) {
            lore.add(cc("&7" + string));
        }
        meta.setLore(lore);
        this.item.setItemMeta(meta);
        return this;
    }

    public Material getMaterial() {
        return item.getType();
    }

    public ItemStack build() {
        return this.item;
    }

    private String cc(String string) {
        return ChatColor.translateAlternateColorCodes('&', string);
    }
}