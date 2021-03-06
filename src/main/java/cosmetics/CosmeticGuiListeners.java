package cosmetics;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import cosmetics.disguises.DisguiseGui;
import cosmetics.gadgets.GadgetGui;
import cosmetics.particles.ParticleTypeGui;
import cosmetics.pets.PetGui;

public class CosmeticGuiListeners implements Listener {
    
    private Cosmetics plugin;
    public CosmeticGuiListeners(Cosmetics b) {
        plugin = b;
    }
    
    
    //////
    //Clicking Inside the main Main Gui
    @EventHandler()
    public void onMainGuiClick(InventoryClickEvent event) {
        if (!(event.getInventory().getHolder() instanceof CosmeticGui))
            return;
        if (event.getCurrentItem() == null) return;
        if (event.getCurrentItem().getItemMeta() == null) return;
        if (event.getRawSlot() > 53) return;
        
        event.setCancelled(true);
        
        Player player = (Player) event.getWhoClicked();
        
        if (event.getSlot() == 10) {
            plugin.getServer().getScheduler().runTask(plugin, () -> {
                player.openInventory(new PetGui(plugin, player).getInventory());
            });
        }
        
        if (event.getSlot() == 12) {
            plugin.getServer().getScheduler().runTask(plugin, () -> {
                player.openInventory(new DisguiseGui(plugin, player).getInventory());
            });
        }
        
        if (event.getSlot() == 14) {
            plugin.getServer().getScheduler().runTask(plugin, () -> {
                player.openInventory(new GadgetGui(plugin, player).getInventory());
            });
        }
        
        if (event.getSlot() == 16) {
            plugin.getServer().getScheduler().runTask(plugin, () -> {
                player.openInventory(new ParticleTypeGui(plugin, player).getInventory());
            });
        }
        
        if (event.getSlot() == 31) {
            player.sendMessage(ChatColor.AQUA + "Buy more Slime at: " + ChatColor.GOLD + ChatColor.BOLD + "https://justminecraft.buycraft.net/");
        }
        
        player.closeInventory();
    }
    
    
}