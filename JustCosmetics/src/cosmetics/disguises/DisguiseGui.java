package cosmetics.disguises;

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

public class DisguiseGui implements Listener {
    public Inventory inv;
    
    private Cosmetics plugin;
    public DisguiseGui(Cosmetics b) {
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
        inv = Bukkit.createInventory(null, 54, ChatColor.DARK_GRAY + "Disguise Selector (1/2)");

        // Put the items into the inventory
        initializeItems(player);
    }

    // You can call this whenever you want to put the items in
    public void initializeItems(Player player) {
        
        GuiConstructor(player, Material.BEE_SPAWN_EGG, 10, 100, "Bee Disguise");
        GuiConstructor(player, Material.BLAZE_SPAWN_EGG, 11, 100, "Blaze Disguise");
        GuiConstructor(player, Material.CAT_SPAWN_EGG, 12, 100, "Cat Disguise");
        GuiConstructor(player, Material.CHICKEN_SPAWN_EGG, 13, 100, "Chicken Disguise");
        GuiConstructor(player, Material.COW_SPAWN_EGG, 14, 100, "Cow Disguise");
        GuiConstructor(player, Material.CREEPER_SPAWN_EGG, 15, 100, "Creeper Disguise");
        GuiConstructor(player, Material.DOLPHIN_SPAWN_EGG, 16, 100, "Dolphin Disguise");
        GuiConstructor(player, Material.DONKEY_SPAWN_EGG, 19, 100, "Donkey Disguise");
        GuiConstructor(player, Material.DROWNED_SPAWN_EGG, 20, 100, "Drowned Disguise");
        GuiConstructor(player, Material.ENDERMAN_SPAWN_EGG, 21, 100, "Enderman Disguise");
        GuiConstructor(player, Material.ENDERMITE_SPAWN_EGG, 22, 100, "Endermite Disguise");
        GuiConstructor(player, Material.EVOKER_SPAWN_EGG, 23, 100, "Evoker Disguise");
        GuiConstructor(player, Material.FOX_SPAWN_EGG, 24, 100, "Fox Disguise");
        GuiConstructor(player, Material.GUARDIAN_SPAWN_EGG, 25, 100, "Guardian Disguise");
        GuiConstructor(player, Material.HOGLIN_SPAWN_EGG, 28, 100, "Hoglin Disguise");
        GuiConstructor(player, Material.HORSE_SPAWN_EGG, 29, 100, "Horse Disguise");
        GuiConstructor(player, Material.HUSK_SPAWN_EGG, 30, 100, "Husk Disguise");
        GuiConstructor(player, Material.LLAMA_SPAWN_EGG, 31, 100, "Llama Disguise");
        GuiConstructor(player, Material.MAGMA_CUBE_SPAWN_EGG, 32, 100, "Magma Cube Disguise");
        GuiConstructor(player, Material.OCELOT_SPAWN_EGG, 33, 100, "Ocelot Disguise");
        GuiConstructor(player, Material.PANDA_SPAWN_EGG, 34, 100, "Panda Disguise");
        
        
//        System.out.println("plugin = " + plugin);
//        System.out.println("dataCosmetics = " + plugin.dataCosmetics);
//        System.out.println("player = " + player);
        
        inv.setItem(39, createGuiItem(Material.ARROW, "Back"));
        inv.setItem(40, createGuiItem(Material.BARRIER, "Remove Disguise"));
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