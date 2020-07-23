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

public class PetGui2 implements Listener {
    public Inventory inv;
    
    private Cosmetics plugin;
    public PetGui2(Cosmetics b) {
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
        inv = Bukkit.createInventory(null, 54, ChatColor.DARK_GRAY + "Pet Selector (2/2)");

        // Put the items into the inventory
        initializeItems(player);
    }

    // You can call this whenever you want to put the items in
    public void initializeItems(Player player) {
        GuiConstructor(player, Material.SCUTE, 10, 100, "Turtle Pet", "Shelly");
        GuiConstructor(player, Material.GUNPOWDER, 11, 100, "Creeper Pet", "Psssssss");
        GuiConstructor(player, Material.HAY_BLOCK, 12, 100, "Horse Pet", "Kinda like a Donkey");
        GuiConstructor(player, Material.BLAZE_ROD, 13, 100, "Blaze Pet", "Fire Monster");
        GuiConstructor(player, Material.EXPERIENCE_BOTTLE, 14, 100, "Witch Pet", "Potionless");
        GuiConstructor(player, Material.SAND, 15, 100, "Husk Pet", "Needs Hydration");
        GuiConstructor(player, Material.SANDSTONE_WALL, 16, 100, "Baby Husk Pet", "Not to be confused with Husky");
        GuiConstructor(player, Material.ROTTEN_FLESH, 19, 100, "Zombie Pet", "Nice guy. Avoids sunlight");
        GuiConstructor(player, Material.CRACKED_STONE_BRICKS, 20, 100, "Baby Zombie Pet", "Brains?");
        GuiConstructor(player, Material.SNOW_BLOCK, 21, 100, "Snowman Pet", "Enjoys long walks on the beach");
        GuiConstructor(player, Material.POPPY, 22, 100, "Golem Pet", "Iron Golem");
        
        
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