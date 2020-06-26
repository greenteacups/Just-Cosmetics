package cosmetics.pets;

import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class PetGui2 implements Listener {
    public Inventory inv;

    public void ExampleGui() {
        // Create a new inventory, with no owner (as this isn't a real inventory), a size of nine, called example
        inv = Bukkit.createInventory(null, 54, ChatColor.GOLD + ""  
                + ChatColor.BOLD + "Pet Selector");

        // Put the items into the inventory
        initializeItems();
    }

    // You can call this whenever you want to put the items in
    public void initializeItems() {
        inv.setItem(10, createGuiItem(Material.SCUTE, ChatColor.GOLD + "Turtle", "Spawn Turtle!"));
        inv.setItem(11, createGuiItem(Material.HONEYCOMB, ChatColor.GOLD + "Bee", "Spawn Bee!"));
        inv.setItem(12, createGuiItem(Material.HAY_BLOCK, ChatColor.GOLD + "Horse", "Spawn Horse!"));
        inv.setItem(13, createGuiItem(Material.BLAZE_ROD, ChatColor.GOLD + "Blaze", "Spawn Blaze!"));
        inv.setItem(14, createGuiItem(Material.EXPERIENCE_BOTTLE, ChatColor.GOLD + "Witch", "Spawn Witch!"));
        inv.setItem(15, createGuiItem(Material.SAND, ChatColor.GOLD + "Husk", "Spawn Husk!"));
        inv.setItem(16, createGuiItem(Material.SANDSTONE_WALL, ChatColor.GOLD + "Baby Husk", "Spawn Baby Husk!"));
        inv.setItem(19, createGuiItem(Material.ROTTEN_FLESH, ChatColor.GOLD + "Zombie", "Spawn Zombie!"));
        inv.setItem(20, createGuiItem(Material.CRACKED_STONE_BRICKS, ChatColor.GOLD + "Baby Zombie", "Spawn Baby Zombie!"));
        inv.setItem(21, createGuiItem(Material.SNOW_BLOCK, ChatColor.GOLD + "Snowman", "Spawn Snowman!"));
        inv.setItem(22, createGuiItem(Material.POPPY, ChatColor.GOLD + "Golem", "Spawn Golem!"));
        
        inv.setItem(40, createGuiItem(Material.BARRIER, "Remove Pet"));
        inv.setItem(39, createGuiItem(Material.ARROW, "Back"));
        
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