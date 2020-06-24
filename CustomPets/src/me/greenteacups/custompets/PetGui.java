package me.greenteacups.custompets;

import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class PetGui implements Listener {
    public Inventory inv;

    public void ExampleGui() {
        // Create a new inventory, with no owner (as this isn't a real inventory), a size of nine, called example
        inv = Bukkit.createInventory(null, 54, ChatColor.GOLD + ""  
                + ChatColor.BOLD + "Pet Selector");

        // Put the items into the inventory
        initializeItems();
    }

    // You can call this whenever you want to put the items in
    public void initializeItems() {
        inv.setItem(10, createGuiItem(Material.LLAMA_SPAWN_EGG, ChatColor.GOLD + "Llama", "Spawn Llama!"));
        inv.setItem(11, createGuiItem(Material.PIG_SPAWN_EGG, ChatColor.GOLD + "Pig", "Spawn Pig!"));
        inv.setItem(12, createGuiItem(Material.CHICKEN_SPAWN_EGG, ChatColor.GOLD + "Chicken", "Spawn Chicken!"));
        inv.setItem(13, createGuiItem(Material.SHEEP_SPAWN_EGG, ChatColor.GOLD + "Sheep", "Spawn Sheep!"));
        inv.setItem(14, createGuiItem(Material.COW_SPAWN_EGG, ChatColor.GOLD + "Cow", "Spawn Cow!"));
        inv.setItem(15, createGuiItem(Material.MOOSHROOM_SPAWN_EGG, ChatColor.GOLD + "Mooshroom", "Spawn Mooshroom!"));
        inv.setItem(16, createGuiItem(Material.FOX_SPAWN_EGG, ChatColor.GOLD + "Fox", "Spawn Fox!"));
        inv.setItem(19, createGuiItem(Material.PANDA_SPAWN_EGG, ChatColor.GOLD + "Panda", "Spawn Panda!"));
        inv.setItem(20, createGuiItem(Material.WOLF_SPAWN_EGG, ChatColor.GOLD + "Wolf", "Spawn Wolf!"));
        inv.setItem(21, createGuiItem(Material.POLAR_BEAR_SPAWN_EGG, ChatColor.GOLD + "Polar Bear", "Spawn Polar Bear!"));
        inv.setItem(22, createGuiItem(Material.RABBIT_SPAWN_EGG, ChatColor.GOLD + "Rabbit", "Spawn Rabbit!"));
        inv.setItem(23, createGuiItem(Material.OCELOT_SPAWN_EGG, ChatColor.GOLD + "Ocelot", "Spawn Ocelot!"));
        inv.setItem(24, createGuiItem(Material.TURTLE_SPAWN_EGG, ChatColor.GOLD + "Turtle", "Spawn Turtle!"));
        inv.setItem(25, createGuiItem(Material.BEE_SPAWN_EGG, ChatColor.GOLD + "Bee", "Spawn Bee!"));
        inv.setItem(28, createGuiItem(Material.HORSE_SPAWN_EGG, ChatColor.GOLD + "Horse", "Spawn Horse!"));
        inv.setItem(29, createGuiItem(Material.BLAZE_SPAWN_EGG, ChatColor.GOLD + "Blaze", "Spawn Blaze!"));
        inv.setItem(30, createGuiItem(Material.WITCH_SPAWN_EGG, ChatColor.GOLD + "Witch", "Spawn Witch!"));
        inv.setItem(31, createGuiItem(Material.ENDERMAN_SPAWN_EGG, ChatColor.GOLD + "Enderman", "Spawn Enderman!"));
        inv.setItem(32, createGuiItem(Material.SKELETON_SPAWN_EGG, ChatColor.GOLD + "Skeleton", "Spawn Skeleton!"));
        inv.setItem(33, createGuiItem(Material.ZOMBIE_SPAWN_EGG, ChatColor.GOLD + "Zombie", "Spawn Zombie!"));
        inv.setItem(34, createGuiItem(Material.WITHER_SKELETON_SPAWN_EGG, ChatColor.GOLD + "Wither Skeleton", "Spawn Wither Skeleton!"));
        
        inv.setItem(40, createGuiItem(Material.BARRIER, "Remove Pet"));
        
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