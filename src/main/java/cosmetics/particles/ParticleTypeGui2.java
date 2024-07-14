package cosmetics.particles;

import java.util.Arrays;

import cosmetics.ParticleType;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import cosmetics.Cosmetics;

public class ParticleTypeGui2 implements InventoryHolder {
    
    private final Cosmetics plugin;
    private final Inventory inventory;
    
    public ParticleTypeGui2(Cosmetics plugin, Player player) {
        this.plugin = plugin;
        
        inventory = Bukkit.createInventory(this, 54, ChatColor.DARK_GRAY + "Particle Type (2/2)");
        
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
        for (int i = 0; i < 21; i++) {
            int particleIndex = i + 21;
            if (particleIndex >= ParticleType.values().length) continue;

            int slot = 10 + (i % 7) + (i / 7) * 9;
            ParticleType particleType = ParticleType.values()[particleIndex];

            GuiConstructor(player, particleType.material(), slot, particleType.price(), particleType.title());
        }

        
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