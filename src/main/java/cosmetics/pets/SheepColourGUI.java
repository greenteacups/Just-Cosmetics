package cosmetics.pets;

import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import cosmetics.Cosmetics;

public class SheepColourGUI implements InventoryHolder {
    
    private final Cosmetics plugin;
    private final Inventory inventory;
    
    public SheepColourGUI(Cosmetics plugin, Player player) {
        this.plugin = plugin;
        
        inventory = Bukkit.createInventory(this, 54, ChatColor.DARK_GRAY + "Sheep Color Selector");
        
        initializeItems(player);
    }
    
    @Override
    public Inventory getInventory() {
        return inventory;
    }
    
    // GuiConstructor
    public void GuiConstructor(Player player, Material item, int pos, int price, String name, String desc) {
        if (plugin.dataCosmetics.exists(player.getUniqueId(), name)) {
            inventory.setItem(pos, createGuiItem(item, ChatColor.GOLD + name, desc));
        }
        else {
            inventory.setItem(pos, createGuiItem(item, ChatColor.GOLD + name, 
                    "" + ChatColor.AQUA + "Click to buy for " + ChatColor.GREEN + price + ChatColor.AQUA + " Slime!"));
        }
    }

    // You can call this whenever you want to put the items in
    public void initializeItems(Player player) {
        GuiConstructor(player, Material.RED_DYE, 10, 200, "Red Sheep Pet", "");
        GuiConstructor(player, Material.ORANGE_DYE, 11, 200, "Orange Sheep Pet", "");
        GuiConstructor(player, Material.YELLOW_DYE, 12, 200, "Yellow Sheep Pet", "");
        GuiConstructor(player, Material.GREEN_DYE, 13, 200, "Green Sheep Pet", "");
        GuiConstructor(player, Material.LIME_DYE, 14, 200, "Lime Sheep Pet", "");
        GuiConstructor(player, Material.BLUE_DYE, 15, 200, "Blue Sheep Pet", "");
        GuiConstructor(player, Material.CYAN_DYE, 16, 200, "Cyan Sheep Pet", "");
        GuiConstructor(player, Material.LIGHT_BLUE_DYE, 19, 200, "Light Blue Sheep Pet", "");
        GuiConstructor(player, Material.PURPLE_DYE, 20, 200, "Purple Sheep Pet", "");
        GuiConstructor(player, Material.MAGENTA_DYE, 21, 200, "Magenta Sheep Pet", "");
        GuiConstructor(player, Material.PINK_DYE, 22, 200, "Pink Sheep Pet", "");
        GuiConstructor(player, Material.BROWN_DYE, 23, 200, "Brown Sheep Pet", "");
        GuiConstructor(player, Material.BLACK_DYE, 24, 200, "Black Sheep Pet", "");
        GuiConstructor(player, Material.GRAY_DYE, 25, 200, "Gray Sheep Pet", "");
        GuiConstructor(player, Material.LIGHT_GRAY_DYE, 28, 200, "Light Gray Sheep Pet", "");
        GuiConstructor(player, Material.WHITE_DYE, 29, 200, "White Sheep Pet", "");

        
        inventory.setItem(39, createGuiItem(Material.ARROW, "Back"));
        inventory.setItem(40, createGuiItem(Material.BARRIER, "Remove Pet"));
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