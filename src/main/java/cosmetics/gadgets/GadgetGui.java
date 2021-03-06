package cosmetics.gadgets;

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

public class GadgetGui implements InventoryHolder {
    
    public static final String JUMP_STICK = "Jump Stick";
    public static final String GREEN_SHELLS = "Green Shells";
    public static final String DAZED = "Dazed";
    public static final String AIR_STRIKE = "Air Strike";
    public static final String FIREWORK_GADGET = "Firework Gadget";
    
    private final Cosmetics plugin;
    private final Inventory inventory;
    
    public GadgetGui(Cosmetics plugin, Player player) {
        this.plugin = plugin;
        
        inventory = Bukkit.createInventory(this, 54, ChatColor.DARK_GRAY + "Gadgets");
        
        initializeItems(player);
    }
    
    @Override
    public Inventory getInventory() {
        return inventory;
    }
    
    // GuiConstructor
    public void GuiConstructor(Player player, Material item, int pos, int price, String name, String desc) {
        if (plugin.dataCosmetics.exists(player.getUniqueId(), name)) {
            inventory.setItem(pos, createGuiItem(item, ChatColor.GOLD + name, ChatColor.GREEN + desc));
        }
        else {
            inventory.setItem(pos, createGuiItem(item, ChatColor.GOLD + name, 
                    "" + ChatColor.AQUA + "Click to buy for " + ChatColor.GREEN + price + ChatColor.AQUA + " Slime!"));
        }
    }

    // You can call this whenever you want to put the items in
    public void initializeItems(Player player) {
        GuiConstructor(player, Material.STICK, 10, 200, JUMP_STICK, "Equip to Jump!");
        GuiConstructor(player, Material.TURTLE_HELMET, 11, 400, GREEN_SHELLS, "Destroy your Enemies!");
        GuiConstructor(player, Material.NETHER_STAR, 12, 300, DAZED, "I think you've been hit on the head?");
        GuiConstructor(player, Material.REDSTONE_TORCH, 13, 300, AIR_STRIKE, "Strike from above!");
        GuiConstructor(player, Material.BLAZE_ROD, 14, 200, FIREWORK_GADGET, "Fire that works!");
        
        inventory.setItem(15, createGuiItem(Material.GRASS_PATH, ChatColor.GOLD + "Trails", "Trails Selector"));
        
        
        
        inventory.setItem(39, createGuiItem(Material.ARROW, "Back"));
        inventory.setItem(40, createGuiItem(Material.BARRIER, "Remove Gadget"));
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