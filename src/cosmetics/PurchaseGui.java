package cosmetics;

import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class PurchaseGui implements InventoryHolder {
    
    private final Inventory inventory;
    
    public PurchaseGui(String item) {
        
        inventory = Bukkit.createInventory(this, 54, ChatColor.RED + "Purchase: " + item + "?");
        
        initializeItems();
    }
    
    @Override
    public Inventory getInventory() {
        return inventory;
    }

    // You can call this whenever you want to put the items in
    public void initializeItems() {
        inventory.setItem(20, createGuiItem(Material.LIME_WOOL, ChatColor.GREEN + "YES"));
        inventory.setItem(24, createGuiItem(Material.RED_WOOL, ChatColor.RED + "NO"));

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