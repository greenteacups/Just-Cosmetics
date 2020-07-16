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

public class PetGui implements Listener {
    public Inventory inv;
    
    private Cosmetics plugin;
    public PetGui(Cosmetics b) {
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
        inv = Bukkit.createInventory(null, 54, ChatColor.GOLD + ""  
                + ChatColor.BOLD + "Pet Selector");

        // Put the items into the inventory
        initializeItems(player);
    }

    // You can call this whenever you want to put the items in
    public void initializeItems(Player player) {
        GuiConstructor(player, Material.LEATHER, 10, 100, "Llama Pet", "Llamaaaaa");
        GuiConstructor(player, Material.SUNFLOWER, 11, 100, "Baby Llama Pet", "Tiny Llamama");
        GuiConstructor(player, Material.COOKED_PORKCHOP, 12, 100, "Pig Pet", "Oink");
        GuiConstructor(player, Material.CARROT, 13, 100, "Baby Pig Pet", "Oinklet");
        GuiConstructor(player, Material.FEATHER, 14, 100, "Chicken Pet", "Bad flyer");
        GuiConstructor(player, Material.WHEAT_SEEDS, 15, 100, "Baby Chicken Pet", "Baby Bad flyer");

        inv.setItem(16, createGuiItem(Material.WHITE_WOOL, ChatColor.GOLD + "Sheep", "Sheep Color Selector!"));
        inv.setItem(19, createGuiItem(Material.WHITE_CARPET, ChatColor.GOLD + "Baby Sheep", "Baby Sheep Color Selector!"));
        
        GuiConstructor(player, Material.BEEF, 20, 100, "Cow Pet", "Big Moo");
        GuiConstructor(player, Material.WHEAT, 21, 100, "Baby Cow Pet", "Lil Moo");
        GuiConstructor(player, Material.RED_MUSHROOM, 22, 100, "Mooshroom Pet", "Red Moo");
        GuiConstructor(player, Material.REDSTONE, 23, 100, "Fox Pet", "Fox Pet");
        GuiConstructor(player, Material.GLOWSTONE_DUST, 24, 100, "Baby Fox Pet", "Baby Fox Pet");
        GuiConstructor(player, Material.CAKE, 25, 100, "Panda Pet", "Bamboo Eater");
        GuiConstructor(player, Material.BAMBOO, 28, 100, "Baby Panda Pet", "Small Bamboo Eater");
        GuiConstructor(player, Material.LEAD, 29, 100, "Wolf Pet", "Wolf Pet");
        GuiConstructor(player, Material.BONE, 30, 100, "Baby Wolf Pet", "Baby Wolf Pet");
        GuiConstructor(player, Material.SALMON, 31, 100, "Polar Bear Pet", "Super Forbidden Teddy");
        GuiConstructor(player, Material.MILK_BUCKET, 32, 100, "Baby Polar Bear Pet", "Forbidden Teddy");
        GuiConstructor(player, Material.RABBIT_HIDE, 33, 100, "Rabbit Pet", "Do a trick!");
        GuiConstructor(player, Material.COOKED_COD, 34, 100, "Ocelot Pet", "Meow");
        
        
        inv.setItem(39, createGuiItem(Material.ARROW, "Back"));
        inv.setItem(40, createGuiItem(Material.BARRIER, "Remove Pet"));
        inv.setItem(41, createGuiItem(Material.ARROW, "Next"));
        
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