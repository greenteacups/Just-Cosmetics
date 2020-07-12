package cosmetics.particles;

import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ParticleTypeGui implements Listener {
    public Inventory inv;

    public void ExampleGui() {
        // Create a new inventory, with no owner (as this isn't a real inventory), a size of nine, called example
        inv = Bukkit.createInventory(null, 54, ChatColor.GOLD + ""  
                + ChatColor.BOLD + "Particle Type");

        // Put the items into the inventory
        initializeItems();
    }

    // You can call this whenever you want to put the items in
    public void initializeItems() {
        inv.setItem(10, createGuiItem(Material.VINE, ChatColor.GOLD + "Composter", "Equip Composter Style!"));
        inv.setItem(11, createGuiItem(Material.FIREWORK_STAR, ChatColor.GOLD + "Angry Villager", "Equip Angry Villager Style!"));
        inv.setItem(12, createGuiItem(Material.BASALT, ChatColor.GOLD + "Ash", "Equip Ash Style!"));
        inv.setItem(13, createGuiItem(Material.TUBE_CORAL_FAN, ChatColor.GOLD + "Water Bubble", "Equip Water Bubble Style!"));
        inv.setItem(14, createGuiItem(Material.TUBE_CORAL, ChatColor.GOLD + "Big Water Bubble", "Equip Big Water Bubble Style!"));
        inv.setItem(15, createGuiItem(Material.FIRE_CHARGE, ChatColor.GOLD + "Smoulder", "Equip Smoulder Style!"));
        inv.setItem(16, createGuiItem(Material.TORCH, ChatColor.GOLD + "Smoke", "Equip Smoke Style!"));
        inv.setItem(19, createGuiItem(Material.CAMPFIRE, ChatColor.GOLD + "Campfire Smoke", "Equip Campfire Smoke Style!"));
        inv.setItem(20, createGuiItem(Material.COBWEB, ChatColor.GOLD + "Cloud", "Equip Cloud Style!"));
        inv.setItem(21, createGuiItem(Material.CRIMSON_FUNGUS, ChatColor.GOLD + "Crimson Spore", "Equip Crimson Spore Style!"));
        inv.setItem(22, createGuiItem(Material.WARPED_FUNGUS, ChatColor.GOLD + "Warped Spore", "Equip Warped Spore Style!"));
        inv.setItem(23, createGuiItem(Material.TIPPED_ARROW, ChatColor.GOLD + "Critical Hit", "Equip Critical Style!"));
        inv.setItem(24, createGuiItem(Material.POPPY, ChatColor.GOLD + "Damage", "Equip Damage Style!"));
        inv.setItem(25, createGuiItem(Material.DRAGON_HEAD, ChatColor.GOLD + "Dragon Breath", "Equip Dragon Breath Style!"));
        inv.setItem(28, createGuiItem(Material.BEE_NEST, ChatColor.GOLD + "Honey Drops", "Equip Honey Drops Style!"));
        inv.setItem(29, createGuiItem(Material.WATER_BUCKET, ChatColor.GOLD + "Water Drops", "Equip Water Drops Style!"));
        inv.setItem(30, createGuiItem(Material.LAVA_BUCKET, ChatColor.GOLD + "Lava Drops", "Equip Lava Drops Style!"));
        inv.setItem(31, createGuiItem(Material.CRYING_OBSIDIAN, ChatColor.GOLD + "Obsidian Tears", "Equip Obsidian Tears Style!"));
        inv.setItem(32, createGuiItem(Material.WHITE_DYE, ChatColor.GOLD + "White Spell", "Equip White Spell Style!"));
        inv.setItem(33, createGuiItem(Material.BLACK_DYE, ChatColor.GOLD + "Black Spell", "Equip Black Spell Style!"));
        inv.setItem(34, createGuiItem(Material.PURPLE_DYE, ChatColor.GOLD + "Purple Spell", "Equip Purple Spell Style!"));
        
        inv.setItem(39, createGuiItem(Material.ARROW, "Back"));
        inv.setItem(40, createGuiItem(Material.BARRIER, "Remove Particle"));
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