package cosmetics.disguises;

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

public class DisguiseGui2 implements InventoryHolder {
    
    private final Cosmetics plugin;
    private final Inventory inventory;
    
    public DisguiseGui2(Cosmetics plugin, Player player) {
        this.plugin = plugin;
        
        inventory = Bukkit.createInventory(this, 54, ChatColor.DARK_GRAY + "Disguise Selector (2/2)");
        
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
        
        GuiConstructor(player, Material.PARROT_SPAWN_EGG, 10, 200, "Parrot Disguise");
        GuiConstructor(player, Material.PIG_SPAWN_EGG, 11, 200, "Pig Disguise");
        GuiConstructor(player, Material.PIGLIN_SPAWN_EGG, 12, 200, "Piglin Disguise");
        GuiConstructor(player, Material.PILLAGER_SPAWN_EGG, 13, 200, "Pillager Disguise");
        GuiConstructor(player, Material.POLAR_BEAR_SPAWN_EGG, 14, 200, "Polar Bear Disguise");
        GuiConstructor(player, Material.RABBIT_SPAWN_EGG, 15, 200, "Rabbit Disguise");
        GuiConstructor(player, Material.SHEEP_SPAWN_EGG, 16, 200, "Sheep Disguise");
        GuiConstructor(player, Material.SILVERFISH_SPAWN_EGG, 19, 200, "Silverfish Disguise");
        GuiConstructor(player, Material.SKELETON_SPAWN_EGG, 20, 200, "Skeleton Disguise");
        GuiConstructor(player, Material.SLIME_SPAWN_EGG, 21, 200, "Slime Disguise");
        GuiConstructor(player, Material.SPIDER_SPAWN_EGG, 22, 200, "Spider Disguise");
        GuiConstructor(player, Material.STRAY_SPAWN_EGG, 23, 200, "Stray Disguise");
        GuiConstructor(player, Material.STRIDER_SPAWN_EGG, 24, 200, "Strider Disguise");
        GuiConstructor(player, Material.TURTLE_SPAWN_EGG, 25, 200, "Turtle Disguise");
        GuiConstructor(player, Material.VEX_SPAWN_EGG, 28, 200, "Vex Disguise");
        GuiConstructor(player, Material.VINDICATOR_SPAWN_EGG, 29, 200, "Vindicator Disguise");
        GuiConstructor(player, Material.WITCH_SPAWN_EGG, 30, 200, "Witch Disguise");
        GuiConstructor(player, Material.WITHER_SKELETON_SPAWN_EGG, 31, 200, "Wither Skeleton Disguise");
        GuiConstructor(player, Material.WOLF_SPAWN_EGG, 32, 200, "Wolf Disguise");
        GuiConstructor(player, Material.ZOGLIN_SPAWN_EGG, 33, 200, "Zoglin Disguise");
        GuiConstructor(player, Material.ZOMBIE_SPAWN_EGG, 34, 200, "Zombie Disguise");

        
        inventory.setItem(39, createGuiItem(Material.ARROW, "Back"));
        inventory.setItem(40, createGuiItem(Material.BARRIER, "Remove Disguise"));
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
