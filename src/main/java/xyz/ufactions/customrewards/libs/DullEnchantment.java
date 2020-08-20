package xyz.ufactions.customrewards.libs;

import org.bukkit.enchantments.Enchantment;
import org.bukkit.enchantments.EnchantmentTarget;
import org.bukkit.enchantments.EnchantmentWrapper;
import org.bukkit.inventory.ItemStack;

public class DullEnchantment
  extends EnchantmentWrapper
{
  public DullEnchantment() { super(120); }
  
  public boolean canEnchantItem(ItemStack item) { return true; }
  
  public boolean conflictsWith(Enchantment other) { return false; }
  
  public EnchantmentTarget getItemTarget() { return null; }

  public int getMaxLevel() { return 1; }
  
  public String getName() { return "Glow"; }

  public int getStartLevel() { return 1; }
}
