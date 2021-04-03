package cosmetics;

import java.util.Arrays;
import java.util.stream.Collectors;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

public class CosmeticGui implements InventoryHolder {
    
    private final Cosmetics plugin;
    private final Inventory inventory;
    
    public CosmeticGui(Cosmetics plugin, Player player) {
        this.plugin = plugin;
        
        inventory = Bukkit.createInventory(this, 54, ChatColor.DARK_GRAY + "Costmetics");
        
        inventory.setItem(31, getPlayerHead(player));
        
        initializeItems();
    }
    
    @Override
    public Inventory getInventory() {
        return inventory;
    }
    
    
    // Get player skull
    @SuppressWarnings("deprecation")
    public ItemStack getPlayerHead(Player player) {
    
        boolean isNewVersion = Arrays.stream(Material.values())
                .map(Material::name).collect(Collectors.toList()).contains("PLAYER_HEAD");
    
        Material type = Material.matchMaterial(isNewVersion ? "PLAYER_HEAD" : "SKULL_ITEM");
        ItemStack playerskull = new ItemStack(type, 1);
        
        if (!isNewVersion)
            playerskull.setDurability((short) 3);
        
        SkullMeta meta = (SkullMeta) playerskull.getItemMeta();
        meta.setOwner(player.getName());
        
        meta.setDisplayName(ChatColor.GOLD + "" + player.getName());
        
        meta.setLore(Arrays.asList(ChatColor.GREEN + "Slime: " + 
                ChatColor.WHITE + plugin.dataSlime.getSlime(player.getUniqueId())));
        
        playerskull.setItemMeta(meta);
        
        return playerskull;
    }
    
    // You can call this whenever you want to put the items in
    public void initializeItems() {
        inventory.setItem(10, createGuiItem(Material.PARROT_SPAWN_EGG, ChatColor.GOLD + "Pets"));
        inventory.setItem(12, createGuiItem(Material.CARVED_PUMPKIN, ChatColor.GOLD + "Disguises"));
        inventory.setItem(14, createGuiItem(Material.STICKY_PISTON, ChatColor.GOLD + "Gadgets"));
        inventory.setItem(16, createGuiItem(Material.FIREWORK_ROCKET, ChatColor.GOLD + "Particles"));
        
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
