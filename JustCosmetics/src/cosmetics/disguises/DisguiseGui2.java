package cosmetics.disguises;

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

public class DisguiseGui2 implements Listener {
    public Inventory inv;
    
    private Cosmetics plugin;
    public DisguiseGui2(Cosmetics b) {
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
        inv = Bukkit.createInventory(null, 54, ChatColor.DARK_GRAY + "Disguise Selector (2/2)");

        // Put the items into the inventory
        initializeItems(player);
    }

    // You can call this whenever you want to put the items in
    public void initializeItems(Player player) {
        
        GuiConstructor(player, Material.PARROT_SPAWN_EGG, 10, 100, "Parrot Disguise");
        GuiConstructor(player, Material.PIG_SPAWN_EGG, 11, 100, "Pig Disguise");
        GuiConstructor(player, Material.PIGLIN_SPAWN_EGG, 12, 100, "Piglin Disguise");
        GuiConstructor(player, Material.PILLAGER_SPAWN_EGG, 13, 100, "Pillager Disguise");
        GuiConstructor(player, Material.POLAR_BEAR_SPAWN_EGG, 14, 100, "Polar Bear Disguise");
        GuiConstructor(player, Material.RABBIT_SPAWN_EGG, 15, 100, "Rabbit Disguise");
        GuiConstructor(player, Material.SHEEP_SPAWN_EGG, 16, 100, "Sheep Disguise");
        GuiConstructor(player, Material.SILVERFISH_SPAWN_EGG, 19, 100, "Silverfish Disguise");
        GuiConstructor(player, Material.SKELETON_SPAWN_EGG, 20, 100, "Skeleton Disguise");
        GuiConstructor(player, Material.SLIME_SPAWN_EGG, 21, 100, "Slime Disguise");
        GuiConstructor(player, Material.SPIDER_SPAWN_EGG, 22, 100, "Spider Disguise");
        GuiConstructor(player, Material.STRAY_SPAWN_EGG, 23, 100, "Stray Disguise");
        GuiConstructor(player, Material.STRIDER_SPAWN_EGG, 24, 100, "Strider Disguise");
        GuiConstructor(player, Material.TURTLE_SPAWN_EGG, 25, 100, "Turtle Disguise");
        GuiConstructor(player, Material.VINDICATOR_SPAWN_EGG, 28, 100, "Vindicator Disguise");
        GuiConstructor(player, Material.WITCH_SPAWN_EGG, 29, 100, "Witch Disguise");
        GuiConstructor(player, Material.WITHER_SKELETON_SPAWN_EGG, 30, 100, "Wither Skeleton Disguise");
        GuiConstructor(player, Material.WOLF_SPAWN_EGG, 31, 100, "Wolf Disguise");
        GuiConstructor(player, Material.ZOGLIN_SPAWN_EGG, 32, 100, "Zoglin Disguise");
        GuiConstructor(player, Material.ZOMBIE_SPAWN_EGG, 33, 100, "Zombie Disguise");

        
        inv.setItem(39, createGuiItem(Material.ARROW, "Back"));
        inv.setItem(40, createGuiItem(Material.BARRIER, "Remove Disguise"));
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
