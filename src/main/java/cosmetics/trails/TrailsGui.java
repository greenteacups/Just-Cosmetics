package cosmetics.trails;

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

public class TrailsGui implements InventoryHolder {
    
    private final Cosmetics plugin;
    private final Inventory inventory;
    
    public TrailsGui(Cosmetics plugin, Player player) {
        this.plugin = plugin;
        
        inventory = Bukkit.createInventory(this, 54, ChatColor.DARK_GRAY + "Trail Type");
        
        initializeItems(player);
    }
    
    @Override
    public Inventory getInventory() {
        return inventory;
    }

    // GuiConstructor
    public void GuiConstructor(Player player, Material item, int pos, int price, String name) {
        if (plugin.dataCosmetics.exists(player.getUniqueId(), name)) {
            inventory.setItem(pos, createGuiItem(item, ChatColor.GOLD + name, ChatColor.GREEN + "Click to equip!"));
        }
        else {
            inventory.setItem(pos, createGuiItem(item, ChatColor.GOLD + name, 
                    "" + ChatColor.AQUA + "Click to buy for " + ChatColor.GREEN + price + ChatColor.AQUA + " Slime!"));
        }
    }

    // You can call this whenever you want to put the items in
    public void initializeItems(Player player) {
        GuiConstructor(player, Material.MAGENTA_CONCRETE, 10, 60, "Disco Trail");
        GuiConstructor(player, Material.COARSE_DIRT, 11, 60, "Path Trail");
        GuiConstructor(player, Material.CRAFTING_TABLE, 12, 60, "Utility Trail");
        GuiConstructor(player, Material.GOLD_INGOT, 13, 60, "Wealthy Trail");
        GuiConstructor(player, Material.SPRUCE_PLANKS, 14, 60, "Wood Trail");
        GuiConstructor(player, Material.COAL_ORE, 15, 60, "Ore Trail");
        GuiConstructor(player, Material.CRIMSON_HYPHAE, 16, 60, "Nether Trail");
        GuiConstructor(player, Material.END_STONE, 19, 60, "End Trail");
        GuiConstructor(player, Material.MELON, 20, 60, "Melon Trail");
        GuiConstructor(player, Material.FIRE_CORAL_BLOCK, 21, 60, "Coral Trail");
        
        
        inventory.setItem(39, createGuiItem(Material.ARROW, "Back"));
        inventory.setItem(40, createGuiItem(Material.BARRIER, "Remove Trail"));
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
