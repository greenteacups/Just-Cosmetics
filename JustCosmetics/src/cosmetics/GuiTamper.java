package cosmetics;

import java.util.HashMap;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;

import cosmetics.commands.CosmeticCommand;
import cosmetics.disguises.DisguiseGui;
import cosmetics.disguises.DisguiseGui2;
import cosmetics.gadgets.GadgetGui;
import cosmetics.particles.ParticlePatternGui;
import cosmetics.particles.ParticleTypeGui;
import cosmetics.particles.ParticleTypeGui2;
import cosmetics.pets.BabySheepColourGUI;
import cosmetics.pets.CatTypeGui;
import cosmetics.pets.PetGui;
import cosmetics.pets.PetGui2;
import cosmetics.pets.SheepColourGUI;
import cosmetics.trails.TrailsGui;

public class GuiTamper implements Listener {
    
//    private Cosmetics plugin;
//    public GuiTamper(Cosmetics b) {
//        plugin = b;
//    }

    public static HashMap<Player, Inventory> inventorySave = CosmeticCommand.inventorySave;
    
    // Stop dragging of items out of gadget gui, trail gui and main gui
    @EventHandler
    public void InvClick(InventoryClickEvent event) {    
        
        //Player player = (Player) event.getWhoClicked();
        
        if(event.getInventory().getHolder() instanceof CosmeticGui) {
            if(event.getClick().equals(ClickType.NUMBER_KEY)) {
                event.setCancelled(true);
            }
            if(event.getClick().equals(ClickType.UNKNOWN)) {
                event.setCancelled(true);
            }
            if (event.getRawSlot() > 53) {
                event.setCancelled(true);
            }
        }
        
        if(event.getInventory().getHolder() instanceof PurchaseGui) {
            if(event.getClick().equals(ClickType.NUMBER_KEY)) {
                event.setCancelled(true);
            }
            if(event.getClick().equals(ClickType.UNKNOWN)) {
                event.setCancelled(true);
            }
            if (event.getRawSlot() > 53) {
                event.setCancelled(true);
            }
        }
        
        if(event.getInventory().getHolder() instanceof DisguiseGui) {
            if(event.getClick().equals(ClickType.NUMBER_KEY)) {
                event.setCancelled(true);
            }
            if(event.getClick().equals(ClickType.UNKNOWN)) {
                event.setCancelled(true);
            }
            if (event.getRawSlot() > 53) {
                event.setCancelled(true);
            }
        }
        
        if(event.getInventory().getHolder() instanceof DisguiseGui2) {
            if(event.getClick().equals(ClickType.NUMBER_KEY)) {
                event.setCancelled(true);
            }
            if(event.getClick().equals(ClickType.UNKNOWN)) {
                event.setCancelled(true);
            }
            if (event.getRawSlot() > 53) {
                event.setCancelled(true);
            }
        }
        
        if(event.getInventory().getHolder() instanceof GadgetGui) {
            if(event.getClick().equals(ClickType.NUMBER_KEY)) {
                event.setCancelled(true);
            }
            if(event.getClick().equals(ClickType.UNKNOWN)) {
                event.setCancelled(true);
            }
            if (event.getRawSlot() > 53) {
                event.setCancelled(true);
            }
        }
        
        if(event.getInventory().getHolder() instanceof TrailsGui) {
            if(event.getClick().equals(ClickType.NUMBER_KEY)) {
                event.setCancelled(true);
            }
            if(event.getClick().equals(ClickType.UNKNOWN)) {
                event.setCancelled(true);
            }
            if (event.getRawSlot() > 53) {
                event.setCancelled(true);
            }
        }
        
        if(event.getInventory().getHolder() instanceof ParticleTypeGui) {
            if(event.getClick().equals(ClickType.NUMBER_KEY)) {
                event.setCancelled(true);
            }
            if(event.getClick().equals(ClickType.UNKNOWN)) {
                event.setCancelled(true);
            }
            if (event.getRawSlot() > 53) {
                event.setCancelled(true);
            }
        }
        
        if(event.getInventory().getHolder() instanceof ParticleTypeGui2) {
            if(event.getClick().equals(ClickType.NUMBER_KEY)) {
                event.setCancelled(true);
            }
            if(event.getClick().equals(ClickType.UNKNOWN)) {
                event.setCancelled(true);
            }
            if (event.getRawSlot() > 53) {
                event.setCancelled(true);
            }
        }
        
        if(event.getInventory().getHolder() instanceof ParticlePatternGui) {
            if(event.getClick().equals(ClickType.NUMBER_KEY)) {
                event.setCancelled(true);
            }
            if(event.getClick().equals(ClickType.UNKNOWN)) {
                event.setCancelled(true);
            }
            if (event.getRawSlot() > 53) {
                event.setCancelled(true);
            }
        }
        
        if(event.getInventory().getHolder() instanceof PetGui) {
            if(event.getClick().equals(ClickType.NUMBER_KEY)) {
                event.setCancelled(true);
            }
            if(event.getClick().equals(ClickType.UNKNOWN)) {
                event.setCancelled(true);
            }
            if (event.getRawSlot() > 53) {
                event.setCancelled(true);
            }
        }
        
        if(event.getInventory().getHolder() instanceof PetGui2) {
            if(event.getClick().equals(ClickType.NUMBER_KEY)) {
                event.setCancelled(true);
            }
            if(event.getClick().equals(ClickType.UNKNOWN)) {
                event.setCancelled(true);
            }
            if (event.getRawSlot() > 53) {
                event.setCancelled(true);
            }
        }
        
        if(event.getInventory().getHolder() instanceof SheepColourGUI) {
            if(event.getClick().equals(ClickType.NUMBER_KEY)) {
                event.setCancelled(true);
            }
            if(event.getClick().equals(ClickType.UNKNOWN)) {
                event.setCancelled(true);
            }
            if (event.getRawSlot() > 53) {
                event.setCancelled(true);
            }
        }
        
        if(event.getInventory().getHolder() instanceof BabySheepColourGUI) {
            if(event.getClick().equals(ClickType.NUMBER_KEY)) {
                event.setCancelled(true);
            }
            if(event.getClick().equals(ClickType.UNKNOWN)) {
                event.setCancelled(true);
            }
            if (event.getRawSlot() > 53) {
                event.setCancelled(true);
            }
        }
        
        if(event.getInventory().getHolder() instanceof CatTypeGui) {
            if(event.getClick().equals(ClickType.NUMBER_KEY)) {
                event.setCancelled(true);
            }
            if(event.getClick().equals(ClickType.UNKNOWN)) {
                event.setCancelled(true);
            }
            if (event.getRawSlot() > 53) {
                event.setCancelled(true);
            }
        }
    }
    
    
}
