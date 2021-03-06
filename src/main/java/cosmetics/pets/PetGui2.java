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

public class PetGui2 implements InventoryHolder {
    
    private final Cosmetics plugin;
    private final Inventory inventory;
    
    public PetGui2(Cosmetics plugin, Player player) {
        this.plugin = plugin;
        
        inventory = Bukkit.createInventory(this, 54, ChatColor.DARK_GRAY + "Pet Selector (2/2)");
        
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
        GuiConstructor(player, Material.SCUTE, 10, 200, "Turtle Pet", "Shelly");
        GuiConstructor(player, Material.GUNPOWDER, 11, 200, "Creeper Pet", "Psssssss");
        GuiConstructor(player, Material.HAY_BLOCK, 12, 200, "Horse Pet", "Kinda like a Donkey");
        GuiConstructor(player, Material.BLAZE_ROD, 13, 200, "Blaze Pet", "Fire Monster");
        GuiConstructor(player, Material.EXPERIENCE_BOTTLE, 14, 200, "Witch Pet", "Potionless");
        GuiConstructor(player, Material.SAND, 15, 200, "Husk Pet", "Needs Hydration");
        GuiConstructor(player, Material.SANDSTONE_WALL, 16, 200, "Baby Husk Pet", "Not to be confused with Husky");
        GuiConstructor(player, Material.ROTTEN_FLESH, 19, 200, "Zombie Pet", "Nice guy. Avoids sunlight");
        GuiConstructor(player, Material.CRACKED_STONE_BRICKS, 20, 200, "Baby Zombie Pet", "Brains?");
        GuiConstructor(player, Material.SNOW_BLOCK, 21, 200, "Snowman Pet", "Enjoys long walks on the beach");
        GuiConstructor(player, Material.POPPY, 22, 200, "Golem Pet", "Iron Golem");
        GuiConstructor(player, Material.RABBIT_HIDE, 23, 200, "Rabbit Pet", "Do a trick!");
        
        
        inventory.setItem(40, createGuiItem(Material.BARRIER, "Remove Pet"));
        inventory.setItem(39, createGuiItem(Material.ARROW, "Back"));
        
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