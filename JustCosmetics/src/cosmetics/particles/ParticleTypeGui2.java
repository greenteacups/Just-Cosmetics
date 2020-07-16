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

public class ParticleTypeGui2 implements Listener {
    public Inventory inv;
    
    private Cosmetics plugin;
    public ParticleTypeGui2(Cosmetics b) {
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
        if (plugin.dataCosmetics.exists(player.getUniqueId(), "Enchant Glyph Particle")) {
            inv.setItem(10, createGuiItem(Material.ENCHANTING_TABLE, ChatColor.GOLD + "Enchant Glyph", "Equip Enchant Glyph Style!"));
        }
        else {
            inv.setItem(10, createGuiItem(Material.ENCHANTING_TABLE, ChatColor.GOLD + "Unlock Enchant Glyph Particle", "20 Slime"));
        }
        
        if (plugin.dataCosmetics.exists(player.getUniqueId(), "End Rod Particle")) {
            inv.setItem(11, createGuiItem(Material.END_ROD, ChatColor.GOLD + "End Rod", "Equip End Rod Style!"));
        }
        else {
            inv.setItem(11, createGuiItem(Material.END_ROD, ChatColor.GOLD + "Unlock End Rod Particle", "20 Slime"));
        }
        
        if (plugin.dataCosmetics.exists(player.getUniqueId(), "Explosion Particle")) {
            inv.setItem(12, createGuiItem(Material.TNT, ChatColor.GOLD + "Explosion", "Equip Explosion Style!"));
        }
        else {
            inv.setItem(12, createGuiItem(Material.TNT, ChatColor.GOLD + "Unlock Explosion Particle", "20 Slime"));
        }
        
        if (plugin.dataCosmetics.exists(player.getUniqueId(), "Soul Fire Particle")) {
            inv.setItem(13, createGuiItem(Material.SOUL_TORCH, ChatColor.GOLD + "Soul Fire", "Equip Soul Fire Style!"));
        }
        else {
            inv.setItem(13, createGuiItem(Material.SOUL_TORCH, ChatColor.GOLD + "Unlock Soul Fire Particle", "20 Slime"));
        }

        if (plugin.dataCosmetics.exists(player.getUniqueId(), "Nectar Particle")) {
            inv.setItem(14, createGuiItem(Material.DANDELION, ChatColor.GOLD + "Nectar", "Equip Nectar Style!"));
        }
        else {
            inv.setItem(14, createGuiItem(Material.DANDELION, ChatColor.GOLD + "Unlock Nectar Particle", "20 Slime"));
        }

        if (plugin.dataCosmetics.exists(player.getUniqueId(), "Water Wake Particle")) {
            inv.setItem(15, createGuiItem(Material.FISHING_ROD, ChatColor.GOLD + "Water Wake", "Equip Water Wake Style!"));
        }
        else {
            inv.setItem(15, createGuiItem(Material.FISHING_ROD, ChatColor.GOLD + "Unlock Water Wake Particle", "20 Slime"));
        }

        if (plugin.dataCosmetics.exists(player.getUniqueId(), "Heart Particle")) {
            inv.setItem(16, createGuiItem(Material.CAKE, ChatColor.GOLD + "Heart", "Equip Heart Style!"));
        }
        else {
            inv.setItem(16, createGuiItem(Material.CAKE, ChatColor.GOLD + "Unlock Heart Particle", "20 Slime"));
        }

        if (plugin.dataCosmetics.exists(player.getUniqueId(), "Slime Particle")) {
            inv.setItem(19, createGuiItem(Material.SLIME_BALL, ChatColor.GOLD + "Slime", "Equip Slime Style!"));
        }
        else {
            inv.setItem(19, createGuiItem(Material.SLIME_BALL, ChatColor.GOLD + "Unlock Slime Particle", "20 Slime"));
        }

        if (plugin.dataCosmetics.exists(player.getUniqueId(), "Snowball Particle")) {
            inv.setItem(20, createGuiItem(Material.SNOWBALL, ChatColor.GOLD + "Snowball", "Equip Snowball Style!"));
        }
        else {
            inv.setItem(20, createGuiItem(Material.SNOWBALL, ChatColor.GOLD + "Unlock Snowball Particle", "20 Slime"));
        }
        
        if (plugin.dataCosmetics.exists(player.getUniqueId(), "Nautilus Particle")) {
            inv.setItem(21, createGuiItem(Material.NAUTILUS_SHELL, ChatColor.GOLD + "Nautilus", "Equip Nautilus Style!"));
        }
        else {
            inv.setItem(21, createGuiItem(Material.NAUTILUS_SHELL, ChatColor.GOLD + "Unlock Nautilus Particle", "20 Slime"));
        }

        if (plugin.dataCosmetics.exists(player.getUniqueId(), "Music Note Particle")) {
            inv.setItem(22, createGuiItem(Material.NOTE_BLOCK, ChatColor.GOLD + "Music Note", "Equip Music Note Style!"));
        }
        else {
            inv.setItem(22, createGuiItem(Material.NOTE_BLOCK, ChatColor.GOLD + "Unlock Music Note Particle", "20 Slime"));
        }
        
        if (plugin.dataCosmetics.exists(player.getUniqueId(), "Contagious Particle")) {
            inv.setItem(23, createGuiItem(Material.BAMBOO, ChatColor.GOLD + "Contagious", "Equip Contagious Style!"));
        }
        else {
            inv.setItem(23, createGuiItem(Material.BAMBOO, ChatColor.GOLD + "Unlock Contagious Particle", "20 Slime"));
        }

        if (plugin.dataCosmetics.exists(player.getUniqueId(), "Ink Particle")) {
            inv.setItem(24, createGuiItem(Material.INK_SAC, ChatColor.GOLD + "Ink", "Equip Ink Style!"));
        }
        else {
            inv.setItem(24, createGuiItem(Material.INK_SAC, ChatColor.GOLD + "Unlock Ink Particle", "20 Slime"));
        }
        
        if (plugin.dataCosmetics.exists(player.getUniqueId(), "Totem Particle")) {
            inv.setItem(25, createGuiItem(Material.TOTEM_OF_UNDYING, ChatColor.GOLD + "Totem", "Equip Totem Style!"));
        }
        else {
            inv.setItem(25, createGuiItem(Material.TOTEM_OF_UNDYING, ChatColor.GOLD + "Unlock Totem Particle", "20 Slime"));
        }
        
        if (plugin.dataCosmetics.exists(player.getUniqueId(), "Lava Burst Particle")) {
            inv.setItem(28, createGuiItem(Material.MAGMA_CREAM, ChatColor.GOLD + "Lava Burst", "Lava Burst!"));
        }
        else {
            inv.setItem(28, createGuiItem(Material.MAGMA_CREAM, ChatColor.GOLD + "Unlock Lava Burst Particle", "20 Slime"));
        }

        
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