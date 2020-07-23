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
        inv = Bukkit.createInventory(null, 54, ChatColor.DARK_GRAY + "Particle Type (2/2)");

        // Put the items into the inventory
        initializeItems(player);
    }

    // You can call this whenever you want to put the items in
    public void initializeItems(Player player) {
        GuiConstructor(player, Material.ENCHANTING_TABLE, 10, 20, "Enchant Glyph Particle");
        GuiConstructor(player, Material.END_ROD, 11, 20, "End Rod Particle");
        GuiConstructor(player, Material.TNT, 12, 20, "Explosion Particle");
        GuiConstructor(player, Material.SOUL_TORCH, 13, 20, "Soul Fire Particle");
        GuiConstructor(player, Material.DANDELION, 14, 20, "Nectar Particle");
        GuiConstructor(player, Material.FISHING_ROD, 15, 20, "Water Wake Particle");
        GuiConstructor(player, Material.CAKE, 16, 20, "Heart Particle");
        GuiConstructor(player, Material.SLIME_BALL, 19, 20, "Slime Particle");
        GuiConstructor(player, Material.SNOWBALL, 20, 20, "Snowball Particle");
        GuiConstructor(player, Material.NAUTILUS_SHELL, 21, 20, "Nautilus Particle");
        GuiConstructor(player, Material.NOTE_BLOCK, 22, 20, "Music Note Particle");
        GuiConstructor(player, Material.BAMBOO, 23, 20, "Contagious Particle");
        GuiConstructor(player, Material.INK_SAC, 24, 20, "Ink Particle");
        GuiConstructor(player, Material.TOTEM_OF_UNDYING, 25, 20, "Totem Particle");
        GuiConstructor(player, Material.MAGMA_CREAM, 28, 20, "Lava Burst Particle");

        
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