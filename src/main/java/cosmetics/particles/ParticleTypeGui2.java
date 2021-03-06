package cosmetics.particles;

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

public class ParticleTypeGui2 implements InventoryHolder {
    
    private final Cosmetics plugin;
    private final Inventory inventory;
    
    public ParticleTypeGui2(Cosmetics plugin, Player player) {
        this.plugin = plugin;
        
        inventory = Bukkit.createInventory(this, 54, ChatColor.DARK_GRAY + "Particle Type (2/2)");
        
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
        GuiConstructor(player, Material.ENCHANTING_TABLE, 10, 30, "Enchant Glyph Particle");
        GuiConstructor(player, Material.END_ROD, 11, 30, "End Rod Particle");
        GuiConstructor(player, Material.TOTEM_OF_UNDYING, 12, 30, "Totem Particle");
        //GuiConstructor(player, Material.TNT, 12, 20, "Explosion Particle");///
        GuiConstructor(player, Material.SOUL_TORCH, 13, 30, "Soul Fire Particle");
        GuiConstructor(player, Material.DANDELION, 14, 30, "Nectar Particle");
        GuiConstructor(player, Material.FISHING_ROD, 15, 30, "Water Wake Particle");
        GuiConstructor(player, Material.CAKE, 16, 30, "Heart Particle");
        GuiConstructor(player, Material.SLIME_BALL, 19, 30, "Slime Particle");
        GuiConstructor(player, Material.SNOWBALL, 20, 30, "Snowball Particle");
        GuiConstructor(player, Material.NAUTILUS_SHELL, 21, 30, "Nautilus Particle");
        GuiConstructor(player, Material.NOTE_BLOCK, 22, 30, "Music Note Particle");
        GuiConstructor(player, Material.BAMBOO, 23, 30, "Contagious Particle");
        GuiConstructor(player, Material.INK_SAC, 24, 30, "Ink Particle");
        GuiConstructor(player, Material.TORCH, 25, 30, "Flame Particle");
        //GuiConstructor(player, Material.MAGMA_CREAM, 28, 20, "Lava Burst Particle");

        
        inventory.setItem(39, createGuiItem(Material.ARROW, "Back"));
        inventory.setItem(40, createGuiItem(Material.BARRIER, "Remove Particle"));
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