package cosmetics.gadgets.items;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class FireworkSpawn {

    public ItemStack getItem() {
        
        ItemStack fireworkSpawn = new ItemStack(Material.BLAZE_ROD);
        ItemMeta meta = fireworkSpawn.getItemMeta();
        
        meta.setDisplayName(ChatColor.GREEN + "" + ChatColor.BOLD + "Firework Gadget");
        List<String> lore = new ArrayList<String>();
        lore.add("");
        lore.add(ChatColor.GOLD + "" + ChatColor.ITALIC + "Fire that works!");
        meta.setLore(lore);
        
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        meta.setUnbreakable(true);
        
        fireworkSpawn.setItemMeta(meta);
        
        return fireworkSpawn;
        
    }
}