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

public class SheepColourGUI implements Listener {
    public Inventory inv;

    private Cosmetics plugin;
    public SheepColourGUI(Cosmetics b) {
        plugin = b;
    }
    
    // GuiConstructor
    public void GuiConstructor(Player player, Material item, int pos, int price, String name, String desc) {
        if (plugin.dataCosmetics.exists(player.getUniqueId(), name)) {
            inv.setItem(pos, createGuiItem(item, ChatColor.GOLD + name, desc));
        }
        else {
            inv.setItem(pos, createGuiItem(item, ChatColor.GOLD + name, price + " Slime"));
        }
    }
    
    public void ExampleGui(Player player) {
        // Create a new inventory, with no owner (as this isn't a real inventory), a size of nine, called example
        inv = Bukkit.createInventory(null, 54, ChatColor.DARK_GRAY + "Sheep Color Selector");

        // Put the items into the inventory
        initializeItems(player);
    }

    // You can call this whenever you want to put the items in
    public void initializeItems(Player player) {
        GuiConstructor(player, Material.RED_DYE, 10, 100, "Red Sheep Pet", "");
        GuiConstructor(player, Material.ORANGE_DYE, 11, 100, "Orange Sheep Pet", "");
        GuiConstructor(player, Material.YELLOW_DYE, 12, 100, "Yellow Sheep Pet", "");
        GuiConstructor(player, Material.GREEN_DYE, 13, 100, "Green Sheep Pet", "");
        GuiConstructor(player, Material.LIME_DYE, 14, 100, "Lime Sheep Pet", "");
        GuiConstructor(player, Material.BLUE_DYE, 15, 100, "Blue Sheep Pet", "");
        GuiConstructor(player, Material.CYAN_DYE, 16, 100, "Cyan Sheep Pet", "");
        GuiConstructor(player, Material.LIGHT_BLUE_DYE, 19, 100, "Light Blue Sheep Pet", "");
        GuiConstructor(player, Material.PURPLE_DYE, 20, 100, "Purple Sheep Pet", "");
        GuiConstructor(player, Material.MAGENTA_DYE, 21, 100, "Magenta Sheep Pet", "");
        GuiConstructor(player, Material.PINK_DYE, 22, 100, "Pink Sheep Pet", "");
        GuiConstructor(player, Material.BROWN_DYE, 23, 100, "Brown Sheep Pet", "");
        GuiConstructor(player, Material.BLACK_DYE, 24, 100, "Black Sheep Pet", "");
        GuiConstructor(player, Material.GRAY_DYE, 25, 100, "Gray Sheep Pet", "");
        GuiConstructor(player, Material.LIGHT_GRAY_DYE, 28, 100, "Light Gray Sheep Pet", "");
        GuiConstructor(player, Material.WHITE_DYE, 29, 100, "White Sheep Pet", "");

        
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