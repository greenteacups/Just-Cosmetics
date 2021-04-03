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

public class PetGui implements InventoryHolder {
    
    private final Cosmetics plugin;
    private final Inventory inventory;
    
    public PetGui(Cosmetics plugin, Player player) {
        this.plugin = plugin;
        
        inventory = Bukkit.createInventory(this, 54, ChatColor.DARK_GRAY + "Pet Selector (1/2)");
        
        initializeItems(player);
    }
    
    @Override
    public Inventory getInventory() {
        return inventory;
    }
    
    // GuiConstructor
    public void GuiConstructor(Player player, Material item, int pos, int price, String name, String desc) {
        if (plugin.dataCosmetics.exists(player.getUniqueId(), name)) {
            inventory.setItem(pos, createGuiItem(item, ChatColor.GOLD + name, ChatColor.GREEN + desc));
        }
        else {
            inventory.setItem(pos, createGuiItem(item, ChatColor.GOLD + name, 
                    "" + ChatColor.AQUA + "Click to buy for " + ChatColor.GREEN + price + ChatColor.AQUA + " Slime!"));
        }
    }

    // You can call this whenever you want to put the items in
    public void initializeItems(Player player) {
        GuiConstructor(player, Material.LEATHER, 10, 200, "Llama Pet", "Llamaaaaa");
        GuiConstructor(player, Material.SUNFLOWER, 11, 200, "Baby Llama Pet", "Tiny Llamama");
        GuiConstructor(player, Material.COOKED_PORKCHOP, 12, 200, "Pig Pet", "Oink");
        GuiConstructor(player, Material.CARROT, 13, 200, "Baby Pig Pet", "Oinklet");
        GuiConstructor(player, Material.FEATHER, 14, 200, "Chicken Pet", "Bad flyer");
        GuiConstructor(player, Material.WHEAT_SEEDS, 15, 200, "Baby Chicken Pet", "Baby Bad flyer");

        inventory.setItem(16, createGuiItem(Material.WHITE_WOOL, ChatColor.GOLD + "Sheep", "Sheep Color Selector!"));
        inventory.setItem(19, createGuiItem(Material.WHITE_CARPET, ChatColor.GOLD + "Baby Sheep", "Baby Sheep Color Selector!"));
        
        GuiConstructor(player, Material.BEEF, 20, 200, "Cow Pet", "Big Moo");
        GuiConstructor(player, Material.WHEAT, 21, 200, "Baby Cow Pet", "Lil Moo");
        GuiConstructor(player, Material.RED_MUSHROOM, 22, 200, "Mooshroom Pet", "Red Moo");
        GuiConstructor(player, Material.REDSTONE, 23, 200, "Fox Pet", "Fox Pet");
        GuiConstructor(player, Material.GLOWSTONE_DUST, 24, 200, "Baby Fox Pet", "Baby Fox Pet");
        GuiConstructor(player, Material.CAKE, 25, 200, "Panda Pet", "Bamboo Eater");
        GuiConstructor(player, Material.BAMBOO, 28, 200, "Baby Panda Pet", "Small Bamboo Eater");
        GuiConstructor(player, Material.LEAD, 29, 200, "Wolf Pet", "Wolf Pet");
        GuiConstructor(player, Material.BONE, 30, 200, "Baby Wolf Pet", "Baby Wolf Pet");
        GuiConstructor(player, Material.SALMON, 31, 200, "Polar Bear Pet", "Super Forbidden Teddy");
        GuiConstructor(player, Material.MILK_BUCKET, 32, 200, "Baby Polar Bear Pet", "Forbidden Teddy");
        GuiConstructor(player, Material.COD, 33, 200, "Ocelot Pet", "Wild Meow");
        
        inventory.setItem(34, createGuiItem(Material.COOKED_COD, ChatColor.GOLD + "Cat Type Selector", "Meow"));
        
        
        inventory.setItem(39, createGuiItem(Material.ARROW, "Back"));
        inventory.setItem(40, createGuiItem(Material.BARRIER, "Remove Pet"));
        inventory.setItem(41, createGuiItem(Material.ARROW, "Next"));
        
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