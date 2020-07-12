package cosmetics.particles;

import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ParticleTypeGui2 implements Listener {
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
        inv.setItem(10, createGuiItem(Material.ENCHANTING_TABLE, ChatColor.GOLD + "Enchant Glyph", "Equip Enchant Glyph Style!"));
        inv.setItem(11, createGuiItem(Material.END_ROD, ChatColor.GOLD + "End Rod", "Equip End Rod Style!"));
        inv.setItem(12, createGuiItem(Material.TNT, ChatColor.GOLD + "Explosion", "Equip Explosion Style!"));
        inv.setItem(13, createGuiItem(Material.SOUL_TORCH, ChatColor.GOLD + "Soul Fire", "Equip Soul Fire Style!"));
        inv.setItem(14, createGuiItem(Material.DANDELION, ChatColor.GOLD + "Nectar", "Equip Nectar Style!"));
        inv.setItem(15, createGuiItem(Material.FISHING_ROD, ChatColor.GOLD + "Water Wake", "Equip Water Wake Style!"));
        inv.setItem(16, createGuiItem(Material.CAKE, ChatColor.GOLD + "Heart", "Equip Heart Style!"));
        inv.setItem(19, createGuiItem(Material.SLIME_BALL, ChatColor.GOLD + "Slime", "Equip Slime Style!"));
        inv.setItem(20, createGuiItem(Material.SNOWBALL, ChatColor.GOLD + "Snowball", "Equip Snowball Style!"));
        inv.setItem(21, createGuiItem(Material.NAUTILUS_SHELL, ChatColor.GOLD + "Nautilus", "Equip Nautilus Style!"));
        inv.setItem(22, createGuiItem(Material.NOTE_BLOCK, ChatColor.GOLD + "Music Note", "Equip Music Note Style!"));
        inv.setItem(23, createGuiItem(Material.BAMBOO, ChatColor.GOLD + "Contagious", "Equip Contagious Style!"));
        inv.setItem(24, createGuiItem(Material.INK_SAC, ChatColor.GOLD + "Ink", "Equip Ink Style!"));
        inv.setItem(25, createGuiItem(Material.TOTEM_OF_UNDYING, ChatColor.GOLD + "Totem", "Equip Totem Style!"));
        inv.setItem(28, createGuiItem(Material.MAGMA_CREAM, ChatColor.GOLD + "Lava Burst", "Lava Burst!"));

        
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