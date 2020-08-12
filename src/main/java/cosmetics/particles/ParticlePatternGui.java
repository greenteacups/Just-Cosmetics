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

public class ParticlePatternGui implements InventoryHolder {
    
    private Cosmetics plugin;
    private final Inventory inventory;
    
    public ParticlePatternGui(Cosmetics plugin, Player player) {
        this.plugin = plugin;
        
        inventory = Bukkit.createInventory(this, 54, ChatColor.DARK_GRAY + "Particle Pattern");
        
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
        inventory.setItem(10, createGuiItem(Material.WHITE_WOOL, ChatColor.GOLD + "Normal Pattern", ChatColor.ITALIC
                + "Equip Normal Pattern!"));
        GuiConstructor(player, Material.WARPED_BUTTON, 11, 30, "Dot Pattern");
        GuiConstructor(player, Material.SUNFLOWER, 12, 30, "Halo Pattern");
        GuiConstructor(player, Material.MUSIC_DISC_STAL, 13, 30, "Rings Pattern");
        GuiConstructor(player, Material.HEART_OF_THE_SEA, 14, 30, "Sphere Pattern");
        GuiConstructor(player, Material.PRISMARINE_SHARD, 15, 30, "Prism Pattern");
        GuiConstructor(player, Material.PLAYER_HEAD, 16, 30, "Smiley Pattern");
        GuiConstructor(player, Material.CAKE, 19, 30, "Heart Pattern");
        GuiConstructor(player, Material.NAUTILUS_SHELL, 20, 30, "Swirl Helix Pattern");
        GuiConstructor(player, Material.BEACON, 21, 30, "Cube Pattern");
        GuiConstructor(player, Material.CHAIN, 22, 30, "Chains Pattern");
        GuiConstructor(player, Material.NETHER_STAR, 23, 30, "Stars Pattern");
        GuiConstructor(player, Material.WEEPING_VINES, 24, 30, "Double Helix Pattern");
        GuiConstructor(player, Material.HOPPER, 25, 30, "QuadraHelix Pattern");
        GuiConstructor(player, Material.ELYTRA, 28, 30, "Wings Pattern");
        GuiConstructor(player, Material.ALLIUM, 29, 30, "Lotus Pattern");
        GuiConstructor(player, Material.NETHER_GOLD_ORE, 30, 30, "Burst Pattern");
        GuiConstructor(player, Material.BLAZE_ROD, 31, 30, "Beams Pattern");
        GuiConstructor(player, Material.IRON_BARS, 32, 30, "Cage Pattern");
        GuiConstructor(player, Material.STRING, 33, 30, "Vortex Pattern");


        //inv.setItem(33, createGuiItem(Material.CARROT, ChatColor.GOLD + "Test", "Equip Test Pattern!"));
        
        
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