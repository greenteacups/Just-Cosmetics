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

public class ParticleTypeGui implements Listener {
    public Inventory inv;
    
    private Cosmetics plugin;
    public ParticleTypeGui(Cosmetics b) {
        plugin = b;
    }


    public void ExampleGui(Player player) {
        // Create a new inventory, with no owner (as this isn't a real inventory), a size of nine, called example
        inv = Bukkit.createInventory(null, 54, ChatColor.GOLD + ""  
                + ChatColor.BOLD + "Particle Type");

        // Put the items into the inventory
        initializeItems(player);
    }

    // You can call this whenever you want to put the items in
    public void initializeItems(Player player) {
        if (plugin.dataCosmetics.exists(player.getUniqueId(), "Composter Particle")) {
            inv.setItem(10, createGuiItem(Material.VINE, ChatColor.GOLD + "Composter", "Equip Composter Style!"));
        }
        else {
            inv.setItem(10, createGuiItem(Material.VINE, ChatColor.GOLD + "Unlock Composter Particle", "20 Slime"));
        }
        
        if (plugin.dataCosmetics.exists(player.getUniqueId(), "Angry Villager Particle")) {
            inv.setItem(11, createGuiItem(Material.FIREWORK_STAR, ChatColor.GOLD + "Angry Villager", "Equip Angry Villager Style!"));
        }
        else {
            inv.setItem(11, createGuiItem(Material.FIREWORK_STAR, ChatColor.GOLD + "Unlock Angry Villager Particle", "20 Slime"));
        }
        
        if (plugin.dataCosmetics.exists(player.getUniqueId(), "Ash Particle")) {
            inv.setItem(12, createGuiItem(Material.BASALT, ChatColor.GOLD + "Ash", "Equip Ash Style!"));
        }
        else {
            inv.setItem(12, createGuiItem(Material.VINE, ChatColor.GOLD + "Unlock Ash Particle", "20 Slime"));
        }

        if (plugin.dataCosmetics.exists(player.getUniqueId(), "Water Bubble Particle")) {
            inv.setItem(13, createGuiItem(Material.TUBE_CORAL_FAN, ChatColor.GOLD + "Water Bubble", "Equip Water Bubble Style!"));
        }
        else {
            inv.setItem(13, createGuiItem(Material.TUBE_CORAL_FAN, ChatColor.GOLD + "Unlock Water Bubble Particle", "20 Slime"));
        }
        
        if (plugin.dataCosmetics.exists(player.getUniqueId(), "Big Water Bubble Particle")) {
            inv.setItem(14, createGuiItem(Material.TUBE_CORAL, ChatColor.GOLD + "Big Water Bubble", "Equip Big Water Bubble Style!"));
        }
        else {
            inv.setItem(14, createGuiItem(Material.TUBE_CORAL, ChatColor.GOLD + "Unlock Big Water Bubble Particle", "20 Slime"));
        }

        if (plugin.dataCosmetics.exists(player.getUniqueId(), "Smoulder Particle")) {
            inv.setItem(15, createGuiItem(Material.FIRE_CHARGE, ChatColor.GOLD + "Smoulder", "Equip Smoulder Style!"));
        }
        else {
            inv.setItem(15, createGuiItem(Material.FIRE_CHARGE, ChatColor.GOLD + "Unlock Smoulder Particle", "20 Slime"));
        }

        if (plugin.dataCosmetics.exists(player.getUniqueId(), "Smoke Particle")) {
            inv.setItem(16, createGuiItem(Material.TORCH, ChatColor.GOLD + "Smoke", "Equip Smoke Style!"));
        }
        else {
            inv.setItem(16, createGuiItem(Material.TORCH, ChatColor.GOLD + "Unlock Smoke Particle", "20 Slime"));
        }
        
        if (plugin.dataCosmetics.exists(player.getUniqueId(), "Campfire Smoke Particle")) {
            inv.setItem(19, createGuiItem(Material.CAMPFIRE, ChatColor.GOLD + "Campfire Smoke", "Equip Campfire Smoke Style!"));
        }
        else {
            inv.setItem(19, createGuiItem(Material.CAMPFIRE, ChatColor.GOLD + "Unlock Campfire Smoke Particle", "20 Slime"));
        }

        if (plugin.dataCosmetics.exists(player.getUniqueId(), "Cloud Particle")) {
            inv.setItem(20, createGuiItem(Material.COBWEB, ChatColor.GOLD + "Cloud", "Equip Cloud Style!"));
        }
        else {
            inv.setItem(20, createGuiItem(Material.COBWEB, ChatColor.GOLD + "Unlock Cloud Particle", "20 Slime"));
        }

        if (plugin.dataCosmetics.exists(player.getUniqueId(), "Crimson Spore Particle")) {
            inv.setItem(21, createGuiItem(Material.CRIMSON_FUNGUS, ChatColor.GOLD + "Crimson Spore", "Equip Crimson Spore Style!"));
        }
        else {
            inv.setItem(21, createGuiItem(Material.CRIMSON_FUNGUS, ChatColor.GOLD + "Unlock Crimson Spore Particle", "20 Slime"));
        }
        
        if (plugin.dataCosmetics.exists(player.getUniqueId(), "Warped Spore Particle")) {
            inv.setItem(22, createGuiItem(Material.WARPED_FUNGUS, ChatColor.GOLD + "Warped Spore", "Equip Warped Spore Style!"));
        }
        else {
            inv.setItem(22, createGuiItem(Material.WARPED_FUNGUS, ChatColor.GOLD + "Unlock Warped Spore Particle", "20 Slime"));
        }

        if (plugin.dataCosmetics.exists(player.getUniqueId(), "Critical Hit Particle")) {
            inv.setItem(23, createGuiItem(Material.TIPPED_ARROW, ChatColor.GOLD + "Critical Hit", "Equip Critical Style!"));
        }
        else {
            inv.setItem(23, createGuiItem(Material.TIPPED_ARROW, ChatColor.GOLD + "Unlock Critical Hit Particle", "20 Slime"));
        }
        
        if (plugin.dataCosmetics.exists(player.getUniqueId(), "Damage Particle")) {
            inv.setItem(24, createGuiItem(Material.POPPY, ChatColor.GOLD + "Damage", "Equip Damage Style!"));
        }
        else {
            inv.setItem(24, createGuiItem(Material.POPPY, ChatColor.GOLD + "Unlock Damage Particle", "20 Slime"));
        }

        if (plugin.dataCosmetics.exists(player.getUniqueId(), "Dragon Breath Particle")) {
            inv.setItem(25, createGuiItem(Material.DRAGON_HEAD, ChatColor.GOLD + "Dragon Breath", "Equip Dragon Breath Style!"));
        }
        else {
            inv.setItem(25, createGuiItem(Material.DRAGON_HEAD, ChatColor.GOLD + "Unlock Dragon Breath Particle", "20 Slime"));
        }
        
        if (plugin.dataCosmetics.exists(player.getUniqueId(), "Honey Drops Particle")) {
            inv.setItem(28, createGuiItem(Material.BEE_NEST, ChatColor.GOLD + "Honey Drops", "Equip Honey Drops Style!"));
        }
        else {
            inv.setItem(28, createGuiItem(Material.BEE_NEST, ChatColor.GOLD + "Unlock Honey Drops Particle", "20 Slime"));
        }

        if (plugin.dataCosmetics.exists(player.getUniqueId(), "Water Drops Particle")) {
            inv.setItem(29, createGuiItem(Material.WATER_BUCKET, ChatColor.GOLD + "Water Drops", "Equip Water Drops Style!"));
        }
        else {
            inv.setItem(29, createGuiItem(Material.WATER_BUCKET, ChatColor.GOLD + "Unlock Water Drops Particle", "20 Slime"));
        }
        
        if (plugin.dataCosmetics.exists(player.getUniqueId(), "Lava Drops Particle")) {
            inv.setItem(30, createGuiItem(Material.LAVA_BUCKET, ChatColor.GOLD + "Lava Drops", "Equip Lava Drops Style!"));
        }
        else {
            inv.setItem(30, createGuiItem(Material.LAVA_BUCKET, ChatColor.GOLD + "Unlock Lava Drops Particle", "20 Slime"));
        }

        if (plugin.dataCosmetics.exists(player.getUniqueId(), "Obsidian Tears Particle")) {
            inv.setItem(31, createGuiItem(Material.CRYING_OBSIDIAN, ChatColor.GOLD + "Obsidian Tears", "Equip Obsidian Tears Style!"));
        }
        else {
            inv.setItem(31, createGuiItem(Material.CRYING_OBSIDIAN, ChatColor.GOLD + "Unlock Obsidian Tears Particle", "20 Slime"));
        }
        
        if (plugin.dataCosmetics.exists(player.getUniqueId(), "White Spell Particle")) {
            inv.setItem(32, createGuiItem(Material.WHITE_DYE, ChatColor.GOLD + "White Spell", "Equip White Spell Style!"));
        }
        else {
            inv.setItem(32, createGuiItem(Material.WHITE_DYE, ChatColor.GOLD + "Unlock White Spell Particle", "20 Slime"));
        }

        if (plugin.dataCosmetics.exists(player.getUniqueId(), "Black Spell Particle")) {
            inv.setItem(33, createGuiItem(Material.BLACK_DYE, ChatColor.GOLD + "Black Spell", "Equip Black Spell Style!"));
        }
        else {
            inv.setItem(33, createGuiItem(Material.BLACK_DYE, ChatColor.GOLD + "Unlock Black Spell Particle", "20 Slime"));
        }
        
        if (plugin.dataCosmetics.exists(player.getUniqueId(), "Purple Spell Particle")) {
            inv.setItem(34, createGuiItem(Material.PURPLE_DYE, ChatColor.GOLD + "Purple Spell", "Equip Purple Spell Style!"));
        }
        else {
            inv.setItem(34, createGuiItem(Material.PURPLE_DYE, ChatColor.GOLD + "Unlock Purple Spell Particle", "20 Slime"));
        }
        
        
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