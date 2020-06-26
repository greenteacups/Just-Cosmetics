package cosmetics.pets;

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
        inv.setItem(10, createGuiItem(Material.LEATHER, ChatColor.GOLD + "Llama", "Spawn Llama!"));
        inv.setItem(11, createGuiItem(Material.SUNFLOWER, ChatColor.GOLD + "Baby Llama", "Spawn Baby Llama!"));
        inv.setItem(12, createGuiItem(Material.COOKED_PORKCHOP, ChatColor.GOLD + "Pig", "Spawn Pig!"));
        inv.setItem(13, createGuiItem(Material.CARROT, ChatColor.GOLD + "Baby Pig", "Spawn Baby Pig!"));
        inv.setItem(14, createGuiItem(Material.FEATHER, ChatColor.GOLD + "Chicken", "Spawn Chicken!"));
        inv.setItem(15, createGuiItem(Material.WHEAT_SEEDS, ChatColor.GOLD + "Baby Chicken", "Spawn Baby Chicken!"));
        inv.setItem(16, createGuiItem(Material.WHITE_WOOL, ChatColor.GOLD + "Sheep", "Spawn Sheep!"));
        inv.setItem(19, createGuiItem(Material.WHITE_CARPET, ChatColor.GOLD + "Baby Sheep", "Spawn Baby Sheep!"));
        inv.setItem(20, createGuiItem(Material.BEEF, ChatColor.GOLD + "Cow", "Spawn Cow!"));
        inv.setItem(21, createGuiItem(Material.WHEAT, ChatColor.GOLD + "Baby Cow", "Spawn Baby Cow!"));
        inv.setItem(22, createGuiItem(Material.RED_MUSHROOM, ChatColor.GOLD + "Mooshroom", "Spawn Mooshroom!"));
        inv.setItem(23, createGuiItem(Material.REDSTONE, ChatColor.GOLD + "Fox", "Spawn Fox!"));
        inv.setItem(24, createGuiItem(Material.GLOWSTONE_DUST, ChatColor.GOLD + "Baby Fox", "Spawn Baby Fox!"));        
        inv.setItem(25, createGuiItem(Material.CAKE, ChatColor.GOLD + "Panda", "Spawn Panda!"));
        inv.setItem(28, createGuiItem(Material.BAMBOO, ChatColor.GOLD + "Baby Panda", "Spawn Baby Panda!"));
        inv.setItem(29, createGuiItem(Material.LEAD, ChatColor.GOLD + "Wolf", "Spawn Wolf!"));
        inv.setItem(30, createGuiItem(Material.BONE, ChatColor.GOLD + "Baby Wolf", "Spawn Baby Wolf!"));
        inv.setItem(31, createGuiItem(Material.SALMON, ChatColor.GOLD + "Polar Bear", "Spawn Polar Bear!"));
        inv.setItem(32, createGuiItem(Material.MILK_BUCKET, ChatColor.GOLD + "Baby Polar Bear", "Spawn Baby Polar Bear!"));
        inv.setItem(33, createGuiItem(Material.RABBIT_HIDE, ChatColor.GOLD + "Rabbit", "Spawn Rabbit!"));
        inv.setItem(34, createGuiItem(Material.COOKED_COD, ChatColor.GOLD + "Ocelot", "Spawn Ocelot!"));
        
//        inv.setItem(35, createGuiItem(Material.SCUTE, ChatColor.GOLD + "Turtle", "Spawn Turtle!"));
//        inv.setItem(25, createGuiItem(Material.BEE_SPAWN_EGG, ChatColor.GOLD + "Bee", "Spawn Bee!"));
//        inv.setItem(28, createGuiItem(Material.HORSE_SPAWN_EGG, ChatColor.GOLD + "Horse", "Spawn Horse!"));
//        inv.setItem(29, createGuiItem(Material.BLAZE_SPAWN_EGG, ChatColor.GOLD + "Blaze", "Spawn Blaze!"));
//        inv.setItem(30, createGuiItem(Material.WITCH_SPAWN_EGG, ChatColor.GOLD + "Witch", "Spawn Witch!"));
//        inv.setItem(31, createGuiItem(Material.ENDERMAN_SPAWN_EGG, ChatColor.GOLD + "Enderman", "Spawn Enderman!"));
//        inv.setItem(32, createGuiItem(Material.SKELETON_SPAWN_EGG, ChatColor.GOLD + "Skeleton", "Spawn Skeleton!"));
//        inv.setItem(33, createGuiItem(Material.ZOMBIE_SPAWN_EGG, ChatColor.GOLD + "Zombie", "Spawn Zombie!"));
//        inv.setItem(34, createGuiItem(Material.WITHER_SKELETON_SPAWN_EGG, ChatColor.GOLD + "Wither Skeleton", "Spawn Wither Skeleton!"));
        
        inv.setItem(39, createGuiItem(Material.ARROW, "Back"));
        inv.setItem(40, createGuiItem(Material.BARRIER, "Remove Pet"));
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