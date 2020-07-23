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

    public CosmeticGui maingui = Cosmetics.maingui;
    
    public PetGui petgui = Cosmetics.petgui;
    
    public DisguiseGui disguisegui = Cosmetics.disguisegui;
    
    public GadgetGui gadgetgui = Cosmetics.gadgetgui;
    
    public ParticleTypeGui particletypegui = Cosmetics.particletypegui;
    
    private Cosmetics plugin;
    public CosmeticGuiListeners(Cosmetics b) {
        plugin = b;
    }
    
    
    //////
    //Clicking Inside the main Main Gui
    @EventHandler()
    public void onPetGuiClick(InventoryClickEvent event) {
        if (!event.getInventory().equals(maingui.inv))
            return;
        if (event.getCurrentItem() == null) return;
        if (event.getCurrentItem().getItemMeta() == null) return;
        if (event.getCurrentItem().getItemMeta().getDisplayName() == null) return;
        
        event.setCancelled(true);
        
        Player player = (Player) event.getWhoClicked();
        
        if (event.getSlot() == 10) {
            petgui.ExampleGui(player);
            plugin.getServer().getScheduler().runTask(plugin, () -> {
                player.openInventory(petgui.inv);
            });
        }
        
        if (event.getSlot() == 12) {
            disguisegui.ExampleGui(player);
            plugin.getServer().getScheduler().runTask(plugin, () -> {
                player.openInventory(disguisegui.inv);
            });
        }
        
        if (event.getSlot() == 14) {
            gadgetgui.ExampleGui(player);
            plugin.getServer().getScheduler().runTask(plugin, () -> {
                player.openInventory(gadgetgui.inv);
            });
        }
        
        if (event.getSlot() == 16) {
            particletypegui.ExampleGui(player);
            plugin.getServer().getScheduler().runTask(plugin, () -> {
                player.openInventory(particletypegui.inv);
            });
        }
        
        if (event.getSlot() == 31) {
            player.sendMessage(ChatColor.AQUA + "Buy more Slime at: " + ChatColor.GOLD + ChatColor.BOLD + "http://justminecraft.buycraft.net/");
        }
        
        player.closeInventory();
    }
    
    
}