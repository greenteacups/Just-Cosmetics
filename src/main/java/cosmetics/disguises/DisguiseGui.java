package cosmetics.disguises;

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

public class DisguiseGui implements InventoryHolder {
    
    private Cosmetics plugin;
    private final Inventory inventory;
    
    public DisguiseGui(Cosmetics plugin, Player player) {
        this.plugin = plugin;
        
        inventory = Bukkit.createInventory(this, 54, ChatColor.DARK_GRAY + "Disguise Selector (1/2)");
        
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
        
        GuiConstructor(player, Material.BEE_SPAWN_EGG, 10, 200, "Bee Disguise");
        GuiConstructor(player, Material.BLAZE_SPAWN_EGG, 11, 200, "Blaze Disguise");
        GuiConstructor(player, Material.CAT_SPAWN_EGG, 12, 200, "Cat Disguise");
        GuiConstructor(player, Material.CHICKEN_SPAWN_EGG, 13, 200, "Chicken Disguise");
        GuiConstructor(player, Material.COW_SPAWN_EGG, 14, 200, "Cow Disguise");
        GuiConstructor(player, Material.CREEPER_SPAWN_EGG, 15, 200, "Creeper Disguise");
        GuiConstructor(player, Material.DOLPHIN_SPAWN_EGG, 16, 200, "Dolphin Disguise");
        GuiConstructor(player, Material.DONKEY_SPAWN_EGG, 19, 200, "Donkey Disguise");
        GuiConstructor(player, Material.DROWNED_SPAWN_EGG, 20, 200, "Drowned Disguise");
        GuiConstructor(player, Material.ENDERMAN_SPAWN_EGG, 21, 200, "Enderman Disguise");
        GuiConstructor(player, Material.ENDERMITE_SPAWN_EGG, 22, 200, "Endermite Disguise");
        GuiConstructor(player, Material.EVOKER_SPAWN_EGG, 23, 200, "Evoker Disguise");
        GuiConstructor(player, Material.FOX_SPAWN_EGG, 24, 200, "Fox Disguise");
        GuiConstructor(player, Material.GUARDIAN_SPAWN_EGG, 25, 200, "Guardian Disguise");
        GuiConstructor(player, Material.HOGLIN_SPAWN_EGG, 28, 200, "Hoglin Disguise");
        GuiConstructor(player, Material.HORSE_SPAWN_EGG, 29, 200, "Horse Disguise");
        GuiConstructor(player, Material.HUSK_SPAWN_EGG, 30, 200, "Husk Disguise");
        GuiConstructor(player, Material.LLAMA_SPAWN_EGG, 31, 200, "Llama Disguise");
        GuiConstructor(player, Material.MAGMA_CUBE_SPAWN_EGG, 32, 200, "Magma Cube Disguise");
        GuiConstructor(player, Material.OCELOT_SPAWN_EGG, 33, 200, "Ocelot Disguise");
        GuiConstructor(player, Material.PANDA_SPAWN_EGG, 34, 200, "Panda Disguise");
        
        
//        System.out.println("plugin = " + plugin);
//        System.out.println("dataCosmetics = " + plugin.dataCosmetics);
//        System.out.println("player = " + player);
        
        inventory.setItem(39, createGuiItem(Material.ARROW, "Back"));
        inventory.setItem(40, createGuiItem(Material.BARRIER, "Remove Disguise"));
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