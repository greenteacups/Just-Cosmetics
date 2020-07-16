package cosmetics.pets;

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

public class BabySheepColourGUI implements Listener {
    public Inventory inv;
    
    private Cosmetics plugin;
    public BabySheepColourGUI(Cosmetics b) {
        plugin = b;
    }

    public void ExampleGui(Player player) {
        // Create a new inventory, with no owner (as this isn't a real inventory), a size of nine, called example
        inv = Bukkit.createInventory(null, 54, ChatColor.GOLD + ""  
                + ChatColor.BOLD + "Sheep Color");

        // Put the items into the inventory
        initializeItems(player);
    }

    // You can call this whenever you want to put the items in
    public void initializeItems(Player player) {
        if (plugin.dataCosmetics.exists(player.getUniqueId(), "Red Baby Sheep Pet")) {
            inv.setItem(10, createGuiItem(Material.RED_DYE, ChatColor.GOLD + "Red Baby Sheep Pet"));
        }
        else {
            inv.setItem(10, createGuiItem(Material.RED_DYE, ChatColor.GOLD + "Unlock Red Baby Sheep Pet", "100 Slime"));
        }
        
        if (plugin.dataCosmetics.exists(player.getUniqueId(), "Orange Baby Sheep Pet")) {
            inv.setItem(11, createGuiItem(Material.ORANGE_DYE, ChatColor.GOLD + "Orange Baby Sheep Pet"));
        }
        else {
            inv.setItem(11, createGuiItem(Material.ORANGE_DYE, ChatColor.GOLD + "Unlock Orange Baby Sheep Pet", "100 Slime"));
        }
        
        if (plugin.dataCosmetics.exists(player.getUniqueId(), "Yellow Baby Sheep Pet")) {
            inv.setItem(12, createGuiItem(Material.YELLOW_DYE, ChatColor.GOLD + "Yellow Baby Sheep Pet"));
        }
        else {
            inv.setItem(12, createGuiItem(Material.YELLOW_DYE, ChatColor.GOLD + "Unlock Yellow Baby Sheep Pet", "100 Slime"));
        }
        
        if (plugin.dataCosmetics.exists(player.getUniqueId(), "Green Baby Sheep Pet")) {
            inv.setItem(13, createGuiItem(Material.GREEN_DYE, ChatColor.GOLD + "Green Baby Sheep Pet"));
        }
        else {
            inv.setItem(13, createGuiItem(Material.GREEN_DYE, ChatColor.GOLD + "Unlock Green Baby Sheep Pet", "100 Slime"));
        }
        
        if (plugin.dataCosmetics.exists(player.getUniqueId(), "Lime Baby Sheep Pet")) {
            inv.setItem(14, createGuiItem(Material.LIME_DYE, ChatColor.GOLD + "Lime Baby Sheep Pet"));
        }
        else {
            inv.setItem(14, createGuiItem(Material.LIME_DYE, ChatColor.GOLD + "Unlock Lime Baby Sheep Pet", "100 Slime"));
        }
        
        if (plugin.dataCosmetics.exists(player.getUniqueId(), "Blue Baby Sheep Pet")) {
            inv.setItem(15, createGuiItem(Material.BLUE_DYE, ChatColor.GOLD + "Blue Baby Sheep Pet"));
        }
        else {
            inv.setItem(15, createGuiItem(Material.BLUE_DYE, ChatColor.GOLD + "Unlock Blue Baby Sheep Pet", "100 Slime"));
        }
        
        if (plugin.dataCosmetics.exists(player.getUniqueId(), "Cyan Baby Sheep Pet")) {
            inv.setItem(16, createGuiItem(Material.CYAN_DYE, ChatColor.GOLD + "Cyan Baby Sheep Pet"));
        }
        else {
            inv.setItem(16, createGuiItem(Material.CYAN_DYE, ChatColor.GOLD + "Unlock Cyan Baby Sheep Pet", "100 Slime"));
        }
        
        if (plugin.dataCosmetics.exists(player.getUniqueId(), "Light Blue Baby Sheep Pet")) {
            inv.setItem(19, createGuiItem(Material.LIGHT_BLUE_DYE, ChatColor.GOLD + "Light Blue Baby Sheep Pet"));
        }
        else {
            inv.setItem(19, createGuiItem(Material.LIGHT_BLUE_DYE, ChatColor.GOLD + "Unlock Light Blue Baby Sheep Pet", "100 Slime"));
        }
        
        if (plugin.dataCosmetics.exists(player.getUniqueId(), "Purple Baby Sheep Pet")) {
            inv.setItem(20, createGuiItem(Material.PURPLE_DYE, ChatColor.GOLD + "Purple Baby Sheep Pet"));
        }
        else {
            inv.setItem(20, createGuiItem(Material.PURPLE_DYE, ChatColor.GOLD + "Unlock Purple Baby Sheep Pet", "100 Slime"));
        }
        
        if (plugin.dataCosmetics.exists(player.getUniqueId(), "Magenta Baby Sheep Pet")) {
            inv.setItem(21, createGuiItem(Material.MAGENTA_DYE, ChatColor.GOLD + "Magenta Baby Sheep Pet"));
        }
        else {
            inv.setItem(21, createGuiItem(Material.MAGENTA_DYE, ChatColor.GOLD + "Unlock Magenta Baby Sheep Pet", "100 Slime"));
        }
        
        if (plugin.dataCosmetics.exists(player.getUniqueId(), "Pink Baby Sheep Pet")) {
            inv.setItem(22, createGuiItem(Material.PINK_DYE, ChatColor.GOLD + "Pink Baby Sheep Pet"));
        }
        else {
            inv.setItem(22, createGuiItem(Material.PINK_DYE, ChatColor.GOLD + "Unlock Pink Baby Sheep Pet", "100 Slime"));
        }
        
        if (plugin.dataCosmetics.exists(player.getUniqueId(), "Brown Baby Sheep Pet")) {
            inv.setItem(23, createGuiItem(Material.BROWN_DYE, ChatColor.GOLD + "Brown Baby Sheep Pet"));
        }
        else {
            inv.setItem(23, createGuiItem(Material.BROWN_DYE, ChatColor.GOLD + "Unlock Brown Baby Sheep Pet", "100 Slime"));
        }
        
        if (plugin.dataCosmetics.exists(player.getUniqueId(), "Black Baby Sheep Pet")) {
            inv.setItem(24, createGuiItem(Material.BLACK_DYE, ChatColor.GOLD + "Black Baby Sheep Pet"));
        }
        else {
            inv.setItem(24, createGuiItem(Material.BLACK_DYE, ChatColor.GOLD + "Unlock Black Baby Sheep Pet", "100 Slime"));
        }
        
        if (plugin.dataCosmetics.exists(player.getUniqueId(), "Gray Baby Sheep Pet")) {
            inv.setItem(25, createGuiItem(Material.GRAY_DYE, ChatColor.GOLD + "Gray Baby Sheep Pet"));
        }
        else {
            inv.setItem(25, createGuiItem(Material.GRAY_DYE, ChatColor.GOLD + "Unlock Gray Baby Sheep Pet", "100 Slime"));
        }
        
        if (plugin.dataCosmetics.exists(player.getUniqueId(), "Light Gray Baby Sheep Pet")) {
            inv.setItem(28, createGuiItem(Material.LIGHT_GRAY_DYE, ChatColor.GOLD + "Light Gray Baby Sheep Pet"));
        }
        else {
            inv.setItem(28, createGuiItem(Material.LIGHT_GRAY_DYE, ChatColor.GOLD + "Unlock Light Gray Baby Sheep Pet", "100 Slime"));
        }
        
        if (plugin.dataCosmetics.exists(player.getUniqueId(), "White Sheep Pet")) {
            inv.setItem(29, createGuiItem(Material.WHITE_DYE, ChatColor.GOLD + "White Baby Sheep Pet"));
        }
        else {
            inv.setItem(29, createGuiItem(Material.WHITE_DYE, ChatColor.GOLD + "Unlock White Baby Sheep Pet", "100 Slime"));
        }
        
        inv.setItem(39, createGuiItem(Material.ARROW, "Back"));
        inv.setItem(40, createGuiItem(Material.BARRIER, "Remove Pet"));
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