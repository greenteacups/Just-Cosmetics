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
        inv = Bukkit.createInventory(null, 54, ChatColor.DARK_GRAY +"Particle Type (1/2)");

        // Put the items into the inventory
        initializeItems(player);
    }

    // You can call this whenever you want to put the items in
    public void initializeItems(Player player) {
        GuiConstructor(player, Material.VINE, 10, 20, "Composter Particle");
        GuiConstructor(player, Material.FIREWORK_STAR, 11, 20, "Angry Villager Particle");
        GuiConstructor(player, Material.BASALT, 12, 20, "Ash Particle");
        GuiConstructor(player, Material.TUBE_CORAL_FAN, 13, 20, "Water Bubble Particle");
        GuiConstructor(player, Material.TUBE_CORAL, 14, 20, "Big Water Bubble Particle");
        GuiConstructor(player, Material.FIRE_CHARGE, 15, 20, "Smoulder Particle");
        GuiConstructor(player, Material.TORCH, 16, 20, "Smoke Particle");
        GuiConstructor(player, Material.CAMPFIRE, 19, 20, "Campfire Smoke Particle");
        GuiConstructor(player, Material.COBWEB, 20, 20, "Cloud Particle");
        GuiConstructor(player, Material.CRIMSON_FUNGUS, 21, 20, "Crimson Spore Particle");
        GuiConstructor(player, Material.WARPED_FUNGUS, 22, 20, "Warped Spore Particle");
        GuiConstructor(player, Material.TIPPED_ARROW, 23, 20, "Critical Hit Particle");
        GuiConstructor(player, Material.POPPY, 24, 20, "Damage Particle");
        GuiConstructor(player, Material.DRAGON_HEAD, 25, 20, "Dragon Breath Particle");
        GuiConstructor(player, Material.BEE_NEST, 28, 20, "Honey Drops Particle");
        GuiConstructor(player, Material.WATER_BUCKET, 29, 20, "Water Drops Particle");
        GuiConstructor(player, Material.LAVA_BUCKET, 30, 20, "Lava Drops Particle");
        GuiConstructor(player, Material.CRYING_OBSIDIAN, 31, 20, "Obsidian Tears Particle");
        GuiConstructor(player, Material.WHITE_DYE, 32, 20, "White Spell Particle");
        GuiConstructor(player, Material.BLACK_DYE, 33, 20, "Black Spell Particle");
        GuiConstructor(player, Material.PURPLE_DYE, 34, 20, "Purple Spell Particle");

        
        
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