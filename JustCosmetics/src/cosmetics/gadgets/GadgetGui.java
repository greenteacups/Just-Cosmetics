package cosmetics.gadgets;

import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import cosmetics.Cosmetics;

public class GadgetGui implements Listener {
    public Inventory inv;
    
    private Cosmetics plugin;
    public GadgetGui(Cosmetics b) {
        plugin = b;
    }

    public void ExampleGui(Player player) {
        // Create a new inventory, with no owner (as this isn't a real inventory), a size of nine, called example
        inv = Bukkit.createInventory(null, 54, ChatColor.GOLD + ""  
                + ChatColor.BOLD + "Disguise Selector");

        // Put the items into the inventory
        initializeItems(player);
    }

    // You can call this whenever you want to put the items in
    public void initializeItems(Player player) {
        if (plugin.dataCosmetics.exists(player.getUniqueId(), "Jump Stick")) {
            inv.setItem(10, createGuiItem(Material.STICK, ChatColor.GOLD + "Jump Stick", "Equip to Jump!"));
        }
        else {
            inv.setItem(10, createGuiItem(Material.STICK, ChatColor.GOLD + "Unlock Jump Stick", "100 Slime"));
        }
        
        if (plugin.dataCosmetics.exists(player.getUniqueId(), "Green Shells")) {
            inv.setItem(11, createGuiItem(Material.TURTLE_HELMET, ChatColor.GOLD + "Green Shells", "Destroy your Enemies!"));
        }
        else {
            inv.setItem(11, createGuiItem(Material.TURTLE_HELMET, ChatColor.GOLD + "Unlock Jump Green Shells", "500 Slime"));
        }
        
        if (plugin.dataCosmetics.exists(player.getUniqueId(), "Dazed")) {
            inv.setItem(12, createGuiItem(Material.NETHER_STAR, ChatColor.GOLD + "Dazed", "I think you've been hit on the head?"));
        }
        else {
            inv.setItem(12, createGuiItem(Material.NETHER_STAR, ChatColor.GOLD + "Unlock Dazed", "200 Slime"));
        }
        
        if (plugin.dataCosmetics.exists(player.getUniqueId(), "Air Strike")) {
            inv.setItem(13, createGuiItem(Material.REDSTONE_TORCH, ChatColor.GOLD + "Air Strike", "Strike from above!"));
        }
        else {
            inv.setItem(13, createGuiItem(Material.REDSTONE_TORCH, ChatColor.GOLD + "Unlock Air Strike", "500 Slime"));
        }
        
        if (plugin.dataCosmetics.exists(player.getUniqueId(), "Firework Gadget")) {
            inv.setItem(14, createGuiItem(Material.BLAZE_ROD, ChatColor.GOLD + "Firework Gadget", "Fire that works!"));
        }
        else {
            inv.setItem(14, createGuiItem(Material.BLAZE_ROD, ChatColor.GOLD + "Unlock Firework Gadget", "200 Slime"));
        }
        

        
        
        
        inv.setItem(39, createGuiItem(Material.ARROW, "Back"));
        inv.setItem(40, createGuiItem(Material.BARRIER, "Remove Disguise"));
        //inv.setItem(41, createGuiItem(Material.ARROW, "Next"));
        
        //inv.setItem(53, createGuiItem(Material.CARROT, "Test Slot"));
    }

    // Nice little method to create a gui item with a custom name, and description
    protected ItemStack createGuiItem(final Material material, final String name, final String... lore) {
        final ItemStack item = new ItemStack(material, 1);
        final ItemMeta meta = item.getItemMeta();

        // Set the name of the item
        meta.setDisplayName(name);

        // Set the lore of the item
        meta.setLore(Arrays.asList(lore));

        item.setItemMeta(meta);

        return item;
    }

}