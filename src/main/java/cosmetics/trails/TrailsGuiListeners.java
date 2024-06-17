package cosmetics.trails;

import java.util.HashMap;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import cosmetics.Cosmetics;
import cosmetics.PurchaseConstructor;
import cosmetics.RemoveEffectsOnQuit;
import cosmetics.gadgets.GadgetGui;

public class TrailsGuiListeners implements Listener {
    
    public PurchaseConstructor PurchaseConstructor = Cosmetics.PurchaseConstructor;
    public HashMap<Player, String> purchaseItem = Cosmetics.purchaseItem;
    public HashMap<Player, Integer> purchasePrice = Cosmetics.purchasePrice;
    
    private final Cosmetics plugin;
    public TrailsGuiListeners(Cosmetics b) {
        plugin = b;
    }
    
    public static RemoveEffectsOnQuit RemoveEffectsOnQuit = new RemoveEffectsOnQuit();
    
    public static HashMap<Player, Location> trailsMap = new HashMap<>();
    public static HashMap<Player, String> trailTypeMap = new HashMap<>();
    
    public void TrailEquip(Player player, String trail, int price, String name) {
        if (plugin.dataCosmetics.exists(player.getUniqueId(), name)) {
            if (!trailsMap.containsKey(player)) {
                trailsMap.put(player, player.getLocation());
                trailTypeMap.put(player, trail);
            }
        }
        else {
            purchaseItem.put(player, name); //Input Name
            purchasePrice.put(player, price); //Input Price
            PurchaseConstructor.purchaseGui(player, purchaseItem.get(player), purchasePrice.get(player));
        }
    }
    
    
    //////
    //Clicking Inside the Trails Gui
    @EventHandler()
    public void onTypeGuiClick(InventoryClickEvent event) {
        if (!(event.getInventory().getHolder() instanceof TrailsGui))
            return;
        if (event.getCurrentItem() == null) return;
        if (event.getCurrentItem().getItemMeta() == null) return;
        if (event.getRawSlot() > 53) return;
        
        event.setCancelled(true);
        
        Player player = (Player) event.getWhoClicked();
        
        // Remove Active Cosmetics when selecting new Gadget
        if (event.getSlot() < 35) {
            RemoveEffectsOnQuit.ClearEffects(player);
        }
        
        if (event.getSlot() == 10) {
            TrailEquip(player, "Disco", 60, "Disco Trail");
        }
        
        if (event.getSlot() == 11) {
            TrailEquip(player, "Path", 60, "Path Trail");
        }
        
        if (event.getSlot() == 12) {
            TrailEquip(player, "Utility", 60, "Utility Trail");
        }
        
        if (event.getSlot() == 13) {
            TrailEquip(player, "Wealthy", 60, "Wealthy Trail");
        }
        
        if (event.getSlot() == 14) {
            TrailEquip(player, "Wood", 60, "Wood Trail");
        }
        
        if (event.getSlot() == 15) {
            TrailEquip(player, "Ore", 60, "Ore Trail");
        }
        
        if (event.getSlot() == 16) {
            TrailEquip(player, "Nether", 60, "Nether Trail");
        }
        
        if (event.getSlot() == 19) {
            TrailEquip(player, "End", 60, "End Trail");
        }
        
        if (event.getSlot() == 20) {
            TrailEquip(player, "Melon", 60, "Melon Trail");
        }
        
        if (event.getSlot() == 21) {
            TrailEquip(player, "Coral", 60, "Coral Trail");
        }
    
        
        
        
        // Return to Gadget window
        if (event.getSlot() == 39) {
            plugin.runTask(player, () -> player.openInventory(new GadgetGui(plugin, player).getInventory()));
        }
        
        // Remove Effects Option
        if (event.getSlot() == 40) {
            RemoveEffectsOnQuit.ClearEffects(player);
        }
        
        //Close Menu
        player.closeInventory();
    }
    
    
}
