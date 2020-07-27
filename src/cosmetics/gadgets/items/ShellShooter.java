package cosmetics.gadgets.items;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ShellShooter {
    
    public ItemStack getItem() {
        
        ItemStack jumpStick = new ItemStack(Material.SCUTE);
        ItemMeta meta = jumpStick.getItemMeta();
        
        meta.setDisplayName(ChatColor.GREEN + "" + ChatColor.BOLD + "Green Shell Gun");
        List<String> lore = new ArrayList<String>();
        lore.add("");
        lore.add(ChatColor.GOLD + "" + ChatColor.ITALIC + "Click to shoot Green Shells");
        meta.setLore(lore);
        
        meta.addEnchant(Enchantment.PROTECTION_FALL, 1, true);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        meta.setUnbreakable(true);
        
        jumpStick.setItemMeta(meta);
        
        return jumpStick;
        
    }
}