package cosmetics.gadgets.items;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class AirStrike {
    
    public ItemStack getItem() {
        
        ItemStack jumpStick = new ItemStack(Material.REDSTONE_TORCH);
        ItemMeta meta = jumpStick.getItemMeta();
        
        meta.setDisplayName(ChatColor.GREEN + "" + ChatColor.BOLD + "Air Strike");
        List<String> lore = new ArrayList<>();
        lore.add("");
        lore.add(ChatColor.GOLD + "" + ChatColor.ITALIC + "Click to call Air Strike");
        meta.setLore(lore);
        
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        meta.setUnbreakable(true);
        
        jumpStick.setItemMeta(meta);
        
        return jumpStick;
        
    }
}