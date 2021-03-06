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

public class ParticleTypeGui implements InventoryHolder {
    
    private final Cosmetics plugin;
    private final Inventory inventory;
    
    public ParticleTypeGui(Cosmetics plugin, Player player) {
        this.plugin = plugin;
        
        inventory = Bukkit.createInventory(this, 54, ChatColor.DARK_GRAY + "Particle Type (1/2)");
        
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
        GuiConstructor(player, Material.VINE, 10, 30, "Composter Particle");
        GuiConstructor(player, Material.FIREWORK_STAR, 11, 30, "Angry Villager Particle");
        GuiConstructor(player, Material.BASALT, 12, 30, "Ash Particle");
        GuiConstructor(player, Material.TUBE_CORAL_FAN, 13, 30, "Water Bubble Particle");
        GuiConstructor(player, Material.TUBE_CORAL, 14, 30, "Bubble Pop Particle");
        GuiConstructor(player, Material.FIRE_CHARGE, 15, 30, "Smoulder Particle");
        GuiConstructor(player, Material.MAGMA_CREAM, 16, 30, "Smoke Particle");
        GuiConstructor(player, Material.CAMPFIRE, 19, 30, "Campfire Smoke Particle");
        GuiConstructor(player, Material.COBWEB, 20, 30, "Cloud Particle");
        GuiConstructor(player, Material.CRIMSON_FUNGUS, 21, 30, "Crimson Spore Particle");
        GuiConstructor(player, Material.WARPED_FUNGUS, 22, 30, "Warped Spore Particle");
        GuiConstructor(player, Material.TIPPED_ARROW, 23, 30, "Critical Hit Particle");
        GuiConstructor(player, Material.POPPY, 24, 30, "Damage Particle");
        GuiConstructor(player, Material.DRAGON_HEAD, 25, 30, "Dragon Breath Particle");
        GuiConstructor(player, Material.BEE_NEST, 28, 30, "Honey Drops Particle");
        GuiConstructor(player, Material.WATER_BUCKET, 29, 30, "Water Drops Particle");
        GuiConstructor(player, Material.LAVA_BUCKET, 30, 30, "Lava Drops Particle");
        GuiConstructor(player, Material.CRYING_OBSIDIAN, 31, 30, "Obsidian Tears Particle");
        GuiConstructor(player, Material.WHITE_DYE, 32, 30, "White Spell Particle");
        GuiConstructor(player, Material.BLACK_DYE, 33, 30, "Black Spell Particle");
        GuiConstructor(player, Material.PURPLE_DYE, 34, 30, "Purple Spell Particle");

        
        
        inventory.setItem(39, createGuiItem(Material.ARROW, "Back"));
        inventory.setItem(40, createGuiItem(Material.BARRIER, "Remove Particle"));
        inventory.setItem(41, createGuiItem(Material.ARROW, "Next"));
        
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