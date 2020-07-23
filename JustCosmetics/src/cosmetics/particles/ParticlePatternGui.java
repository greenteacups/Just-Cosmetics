package cosmetics.particles;

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

public class ParticlePatternGui implements Listener {
    public Inventory inv;
    
    private Cosmetics plugin;
    public ParticlePatternGui(Cosmetics b) {
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
        inv = Bukkit.createInventory(null, 54, ChatColor.DARK_GRAY + "Particle Pattern");

        // Put the items into the inventory
        initializeItems(player);
    }

    // You can call this whenever you want to put the items in
    public void initializeItems(Player player) {
        GuiConstructor(player, Material.WARPED_BUTTON, 10, 20, "Dot Pattern");
        GuiConstructor(player, Material.SUNFLOWER, 11, 20, "Halo Pattern");
        GuiConstructor(player, Material.MUSIC_DISC_STAL, 12, 20, "Rings Pattern");
        GuiConstructor(player, Material.HEART_OF_THE_SEA, 13, 20, "Sphere Pattern");
        GuiConstructor(player, Material.PRISMARINE_SHARD, 14, 20, "Prism Pattern");
        GuiConstructor(player, Material.NETHER_GOLD_ORE, 15, 20, "Burst Pattern");
        GuiConstructor(player, Material.PLAYER_HEAD, 16, 20, "Smiley Pattern");
        GuiConstructor(player, Material.CAKE, 19, 20, "Heart Pattern");
        GuiConstructor(player, Material.NAUTILUS_SHELL, 20, 20, "Swirl Helix Pattern");
        GuiConstructor(player, Material.BEACON, 21, 20, "Cube Pattern");
        GuiConstructor(player, Material.CHAIN, 22, 20, "Chains Pattern");
        GuiConstructor(player, Material.NETHER_STAR, 23, 20, "Stars Pattern");
        GuiConstructor(player, Material.WEEPING_VINES, 24, 20, "Double Helix Pattern");
        GuiConstructor(player, Material.HOPPER, 25, 20, "QuadraHelix Pattern");
        GuiConstructor(player, Material.TURTLE_EGG, 28, 20, "Egg Pattern");
        GuiConstructor(player, Material.LEAD, 29, 20, "Big Ring Pattern");
        GuiConstructor(player, Material.WHITE_WOOL, 30, 20, "Normal Pattern");
        GuiConstructor(player, Material.BLAZE_ROD, 31, 20, "Beams Pattern");
        GuiConstructor(player, Material.IRON_BARS, 32, 20, "Cage Pattern");



        //inv.setItem(33, createGuiItem(Material.CARROT, ChatColor.GOLD + "Test", "Equip Test Pattern!"));
        
        
        inv.setItem(39, createGuiItem(Material.ARROW, "Back"));
        inv.setItem(40, createGuiItem(Material.BARRIER, "Remove Particle"));
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