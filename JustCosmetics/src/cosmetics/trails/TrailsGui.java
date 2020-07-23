package cosmetics.trails;

import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import cosmetics.Cosmetics;

public class TrailsGui {
    public Inventory inv;
    
    private Cosmetics plugin;
    public TrailsGui(Cosmetics b) {
        plugin = b;
    }

    // GuiConstructor
    public void GuiConstructor(Player player, Material item, int pos, int price, String name) {
        if (plugin.dataCosmetics.exists(player.getUniqueId(), name)) {
            inv.setItem(pos, createGuiItem(item, ChatColor.GOLD + name, "Equip " + name + "!"));
        }
        else {
            inv.setItem(pos, createGuiItem(item, ChatColor.GOLD + name, price + " Slime"));
        }
    }
    
    public void ExampleGui(Player player) {
        // Create a new inventory, with no owner (as this isn't a real inventory), a size of nine, called example
        inv = Bukkit.createInventory(null, 54, ChatColor.DARK_GRAY + "Trail Type");

        // Put the items into the inventory
        initializeItems(player);
    }

    // You can call this whenever you want to put the items in
    public void initializeItems(Player player) {
        GuiConstructor(player, Material.MAGENTA_CONCRETE, 10, 50, "Disco Trail");
        GuiConstructor(player, Material.GRASS_PATH, 11, 50, "Path Trail");
        GuiConstructor(player, Material.CRAFTING_TABLE, 12, 50, "Utility Trail");
        GuiConstructor(player, Material.GOLD_INGOT, 13, 50, "Wealthy Trail");
        GuiConstructor(player, Material.SPRUCE_PLANKS, 14, 50, "Wood Trail");
        GuiConstructor(player, Material.COAL_ORE, 15, 50, "Ore Trail");
        GuiConstructor(player, Material.CRIMSON_HYPHAE, 16, 50, "Nether Trail");
        GuiConstructor(player, Material.END_STONE, 19, 50, "End Trail");
        GuiConstructor(player, Material.MELON, 20, 50, "Melon Trail");
        GuiConstructor(player, Material.FIRE_CORAL_BLOCK, 21, 50, "Coral Trail");
        
        
        inv.setItem(39, createGuiItem(Material.ARROW, "Back"));
        inv.setItem(40, createGuiItem(Material.BARRIER, "Remove Trail"));
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
