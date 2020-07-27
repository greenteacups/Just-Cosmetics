package cosmetics.pets;

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

public class CatTypeGui implements InventoryHolder {
    
    private Cosmetics plugin;
    private final Inventory inventory;
    
    public CatTypeGui(Cosmetics plugin, Player player) {
        this.plugin = plugin;
        
        inventory = Bukkit.createInventory(this, 54, ChatColor.DARK_GRAY + "Cat Type Selector");
        
        initializeItems(player);
    }
    
    @Override
    public Inventory getInventory() {
        return inventory;
    }
    
    // GuiConstructor
    public void GuiConstructor(Player player, Material item, int pos, int price, String name, String desc) {
        if (plugin.dataCosmetics.exists(player.getUniqueId(), name)) {
            inventory.setItem(pos, createGuiItem(item, ChatColor.GOLD + name, desc));
        }
        else {
            inventory.setItem(pos, createGuiItem(item, ChatColor.GOLD + name, 
                    "" + ChatColor.AQUA + "Click to buy for " + ChatColor.GREEN + price + ChatColor.AQUA + " Slime!"));
        }
    }

    // You can call this whenever you want to put the items in
    public void initializeItems(Player player) {
        GuiConstructor(player, Material.BLACK_DYE, 10, 200, "Black Cat Pet", "(black with orange eyes)");
        GuiConstructor(player, Material.COOKED_COD, 11, 200, "British Shorthair Cat Pet", "(silver with yellow eyes)");
        GuiConstructor(player, Material.COOKED_SALMON, 12, 200, "Calico Cat Pet", "(orange, white and dark brown with yellow and blue eyes)");
        GuiConstructor(player, Material.SEA_PICKLE, 13, 200, "Jellie Cat Pet", "(gray and white with gray-green eyes)");
        GuiConstructor(player, Material.COD, 14, 200, "Persian Cat Pet", "(creamy with blue eyes)");
        GuiConstructor(player, Material.SEAGRASS, 15, 200, "Ragdoll Cat Pet", "(white and soft amber with blue eyes)");
        GuiConstructor(player, Material.TROPICAL_FISH, 16, 200, "Red Cat Pet", "(orange and white with green eyes)");
        GuiConstructor(player, Material.FERN, 19, 200, "Siamese Cat Pet", "(white and pale brown with blue eyes)");
        GuiConstructor(player, Material.SALMON, 20, 200, "Tabby Cat Pet", "(brown and white with yellow eyes)");
        GuiConstructor(player, Material.DRIED_KELP, 21, 200, "Tuxedo Cat Pet", "(black and white with green eyes)");
        GuiConstructor(player, Material.PUFFERFISH, 22, 200, "White Cat Pet", "(white with light blue and yellow eyes)");

        
        inventory.setItem(39, createGuiItem(Material.ARROW, "Back"));
        inventory.setItem(40, createGuiItem(Material.BARRIER, "Remove Pet"));
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
