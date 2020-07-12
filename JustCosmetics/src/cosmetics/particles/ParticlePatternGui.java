package cosmetics.particles;

import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ParticlePatternGui implements Listener {
    public Inventory inv;

    public void ExampleGui() {
        // Create a new inventory, with no owner (as this isn't a real inventory), a size of nine, called example
        inv = Bukkit.createInventory(null, 54, ChatColor.GOLD + ""  
                + ChatColor.BOLD + "Particle Pattern");

        // Put the items into the inventory
        initializeItems();
    }

    // You can call this whenever you want to put the items in
    public void initializeItems() {
        inv.setItem(10, createGuiItem(Material.WARPED_BUTTON, ChatColor.GOLD + "Dot", "Equip Dot Pattern!"));
        inv.setItem(11, createGuiItem(Material.SUNFLOWER, ChatColor.GOLD + "Halo", "Equip Halo Pattern!"));
        inv.setItem(12, createGuiItem(Material.MUSIC_DISC_STAL, ChatColor.GOLD + "Rings", "Equip Rings Pattern!"));
        inv.setItem(13, createGuiItem(Material.HEART_OF_THE_SEA, ChatColor.GOLD + "Sphere", "Equip Sphere Pattern!"));
        inv.setItem(14, createGuiItem(Material.PRISMARINE_SHARD, ChatColor.GOLD + "Prism", "Equip Prism Pattern!"));
        inv.setItem(15, createGuiItem(Material.NETHER_GOLD_ORE, ChatColor.GOLD + "Burst", "Equip Burst Pattern!"));
        inv.setItem(16, createGuiItem(Material.PLAYER_HEAD, ChatColor.GOLD + "Smiley", "Equip Smiley Pattern!"));
        inv.setItem(19, createGuiItem(Material.CAKE, ChatColor.GOLD + "Heart", "Equip Heart Pattern!"));
        inv.setItem(20, createGuiItem(Material.NAUTILUS_SHELL, ChatColor.GOLD + "Swirl Helix", "Equip Swirl Helix Pattern!"));
        inv.setItem(21, createGuiItem(Material.BEACON, ChatColor.GOLD + "Cube", "Equip Cube Pattern!"));
        inv.setItem(22, createGuiItem(Material.CHAIN, ChatColor.GOLD + "Chains", "Equip Chain Pattern!"));
        inv.setItem(23, createGuiItem(Material.NETHER_STAR, ChatColor.GOLD + "Stars", "Equip Stars Pattern!"));
        inv.setItem(24, createGuiItem(Material.WEEPING_VINES, ChatColor.GOLD + "Double Helix", "Equip Double Helix Pattern!"));
        inv.setItem(25, createGuiItem(Material.HOPPER, ChatColor.GOLD + "QuadraHelix", "Equip QuadraHelix Pattern!"));
        inv.setItem(28, createGuiItem(Material.TURTLE_EGG, ChatColor.GOLD + "Egg", "Equip Egg Pattern!"));
        inv.setItem(29, createGuiItem(Material.LEAD, ChatColor.GOLD + "Big Ring", "Equip Big Ring Pattern!"));
        inv.setItem(30, createGuiItem(Material.WHITE_WOOL, ChatColor.GOLD + "Normal", "Equip Normal Pattern!"));
        inv.setItem(31, createGuiItem(Material.BLAZE_ROD, ChatColor.GOLD + "Beams", "Equip Beam Pattern!"));
        inv.setItem(32, createGuiItem(Material.IRON_BARS, ChatColor.GOLD + "Cage", "Equip Cage Pattern!"));
        inv.setItem(33, createGuiItem(Material.CARROT, ChatColor.GOLD + "Test", "Equip Test Pattern!"));
        
        
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