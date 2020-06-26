package cosmetics.pets;

import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class BabySheepColourGUI implements Listener {
    public Inventory inv;

    public void ExampleGui() {
        // Create a new inventory, with no owner (as this isn't a real inventory), a size of nine, called example
        inv = Bukkit.createInventory(null, 54, ChatColor.GOLD + ""  
                + ChatColor.BOLD + "Sheep Color");

        // Put the items into the inventory
        initializeItems();
    }

    // You can call this whenever you want to put the items in
    public void initializeItems() {
        inv.setItem(10, createGuiItem(Material.RED_DYE, ChatColor.GOLD + "Red Sheep"));
        inv.setItem(11, createGuiItem(Material.ORANGE_DYE, ChatColor.GOLD + "Orange Sheep"));
        inv.setItem(12, createGuiItem(Material.YELLOW_DYE, ChatColor.GOLD + "Yellow Sheep"));
        inv.setItem(13, createGuiItem(Material.GREEN_DYE, ChatColor.GOLD + "Green Sheep"));
        inv.setItem(14, createGuiItem(Material.LIME_DYE, ChatColor.GOLD + "Lime Sheep"));
        inv.setItem(15, createGuiItem(Material.BLUE_DYE, ChatColor.GOLD + "Blue Sheep"));
        inv.setItem(16, createGuiItem(Material.CYAN_DYE, ChatColor.GOLD + "Cyan Sheep"));
        inv.setItem(19, createGuiItem(Material.LIGHT_BLUE_DYE, ChatColor.GOLD + "Light Blue Sheep"));
        inv.setItem(20, createGuiItem(Material.PURPLE_DYE, ChatColor.GOLD + "Purple Sheep"));
        inv.setItem(21, createGuiItem(Material.MAGENTA_DYE, ChatColor.GOLD + "Magenta Sheep"));
        inv.setItem(22, createGuiItem(Material.PINK_DYE, ChatColor.GOLD + "Pink Sheep"));
        inv.setItem(23, createGuiItem(Material.BROWN_DYE, ChatColor.GOLD + "Brown Sheep"));
        inv.setItem(24, createGuiItem(Material.BLACK_DYE, ChatColor.GOLD + "Black Sheep"));
        inv.setItem(25, createGuiItem(Material.GRAY_DYE, ChatColor.GOLD + "Gray Sheep"));
        inv.setItem(28, createGuiItem(Material.LIGHT_GRAY_DYE, ChatColor.GOLD + "Light Gray Sheep"));
        inv.setItem(29, createGuiItem(Material.WHITE_DYE, ChatColor.GOLD + "White Sheep"));
        
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