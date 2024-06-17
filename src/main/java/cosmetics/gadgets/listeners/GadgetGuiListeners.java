package cosmetics.gadgets.listeners;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.github.puregero.multilib.MultiLib;
import org.bukkit.ChatColor;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import cosmetics.CosmeticGui;
import cosmetics.Cosmetics;
import cosmetics.PurchaseConstructor;
import cosmetics.RemoveEffectsOnQuit;
import cosmetics.gadgets.GadgetGui;
import cosmetics.gadgets.GadgetRunnables;
import cosmetics.gadgets.items.AirStrike;
import cosmetics.gadgets.items.FireworkSpawn;
import cosmetics.gadgets.items.JumpStick;
import cosmetics.gadgets.items.ShellShooter;
import cosmetics.trails.TrailsGui;

public class GadgetGuiListeners implements Listener {
    
    public PurchaseConstructor PurchaseConstructor = Cosmetics.PurchaseConstructor;
    public HashMap<Player, String> purchaseItem = Cosmetics.purchaseItem;
    public HashMap<Player, Integer> purchasePrice = Cosmetics.purchasePrice;
    
    private final Cosmetics plugin;
    public GadgetGuiListeners(Cosmetics b) {
        this.plugin = b;
    }
    
    public static RemoveEffectsOnQuit RemoveEffectsOnQuit = new RemoveEffectsOnQuit();
    
    public static HashMap<Player, List<Entity>> shellMap = new HashMap<>();
    public static HashMap<Player, List<Entity>> parrotMap = new HashMap<>();
    public static HashMap<Player, Long> airstrike = GadgetRunnables.airstrike;
    public static HashMap<Player, Entity> airturtlelist = GadgetRunnables.airturtlelist;
    
    //////
    //Clicking Inside the main Main Gui
    @EventHandler()
    public void onGadgetGuiClick(InventoryClickEvent event) {
        if (!(event.getInventory().getHolder() instanceof GadgetGui))
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
        
        //Add Jump Stick Gadget
        if (event.getSlot() == 10) {
            if (plugin.dataCosmetics.exists(player.getUniqueId(), "Jump Stick")) {
                if (player.getInventory().getItem(8) == null) {
                    JumpStick jumpstick = new JumpStick();
                    player.getInventory().setItem(8, jumpstick.getItem());
                }
                else {
                    player.sendMessage(ChatColor.RED + "Clear the 9th slot of your hotbar to equip the Jump Stick!");
                }
            }
            else {
                purchaseItem.put(player, "Jump Stick"); //Input Name
                purchasePrice.put(player, 200); //Input Price
                PurchaseConstructor.purchaseGui(player, purchaseItem.get(player), purchasePrice.get(player));
            }
        }
        
        //Add Shell Gadget
        if (event.getSlot() == 11) {
            if (plugin.dataCosmetics.exists(player.getUniqueId(), "Green Shells")) {
                List<Entity> shellList = new ArrayList<>();
                
                LivingEntity shell1 = (LivingEntity) player.getWorld().spawnEntity(player.getLocation().add(0, 0, -2), EntityType.TURTLE);
                LivingEntity shell2 = (LivingEntity) player.getWorld().spawnEntity(player.getLocation().add(2/Math.sqrt(2), 0, 2/Math.sqrt(2)), EntityType.TURTLE);
                LivingEntity shell3 = (LivingEntity) player.getWorld().spawnEntity(player.getLocation().add(-2/Math.sqrt(2), 0, 2/Math.sqrt(2)), EntityType.TURTLE);
                
                shell1.setInvulnerable(true);
                shell2.setInvulnerable(true);
                shell3.setInvulnerable(true);
                shell1.setAI(false);
                shell2.setAI(false);
                shell3.setAI(false);
                
                shellList.add(shell1);
                shellList.add(shell2);
                shellList.add(shell3);
                
                plugin.runTaskLater(player, () -> shellMap.put(player, shellList), 1);
                
                if (player.getInventory().getItem(8) == null) {
                    ShellShooter shellshooter = new ShellShooter();
                    player.getInventory().setItem(8, shellshooter.getItem());
                }
                else {
                    player.sendMessage(ChatColor.RED + "Clear the 9th slot of your hotbar to equip the Shell Shooter!");
                }

            }
            else {
                purchaseItem.put(player, "Green Shells"); //Input Name
                purchasePrice.put(player, 400); //Input Price
                PurchaseConstructor.purchaseGui(player, purchaseItem.get(player), purchasePrice.get(player));
            }
        }
        
        //Add Dazed Gadget
        if (event.getSlot() == 12) {
            if (plugin.dataCosmetics.exists(player.getUniqueId(), "Dazed")) {
                List<Entity> parrotList = new ArrayList<>();
                
                Entity parrot1 = player.getWorld().spawnEntity(player.getLocation().add(0, 1.7, -0.8), EntityType.PARROT);
                Entity parrot2 = player.getWorld().spawnEntity(player.getLocation().add(0.8/Math.sqrt(2), 1.7, 0.8/Math.sqrt(2)), EntityType.PARROT);
                Entity parrot3 = player.getWorld().spawnEntity(player.getLocation().add(-0.8/Math.sqrt(2), 1.7, 0.8/Math.sqrt(2)), EntityType.PARROT);    
                
                parrot1.setInvulnerable(true);
                parrot2.setInvulnerable(true);
                parrot3.setInvulnerable(true);
                
                parrotList.add(parrot1);
                parrotList.add(parrot2);
                parrotList.add(parrot3);
                
                plugin.runTaskLater(player, () -> parrotMap.put(player, parrotList), 1);
            }
            else {
                purchaseItem.put(player, "Dazed"); //Input Name
                purchasePrice.put(player, 300); //Input Price
                PurchaseConstructor.purchaseGui(player, purchaseItem.get(player), purchasePrice.get(player));
            }
            
        }
        
        //Add Air Strike Gadget
        if (event.getSlot() == 13) {
            if (plugin.dataCosmetics.exists(player.getUniqueId(), "Air Strike")) {
                
                if (player.getInventory().getItem(8) == null) {
                    AirStrike airstrike = new AirStrike();     
                    player.getInventory().setItem(8, airstrike.getItem());
                }
                else {
                    player.sendMessage(ChatColor.RED + "Clear the 9th slot of your hotbar to equip the Air Strike Gadget!");
                }
            }
            else {
                purchaseItem.put(player, "Air Strike"); //Input Name
                purchasePrice.put(player, 300); //Input Price
                PurchaseConstructor.purchaseGui(player, purchaseItem.get(player), purchasePrice.get(player));
            }
        }
        
        //Add Firework Gadget
        if (event.getSlot() == 14) {
            if (plugin.dataCosmetics.exists(player.getUniqueId(), "Firework Gadget")) {
                
                if (player.getInventory().getItem(8) == null) {
                    FireworkSpawn fireworkSpawn = new FireworkSpawn();     
                    player.getInventory().setItem(8, fireworkSpawn.getItem());
                }
                else {
                    player.sendMessage(ChatColor.RED + "Clear the 9th slot of your hotbar to equip the Firework Launcher!");
                }
            }
            else {
                purchaseItem.put(player, "Firework Gadget"); //Input Name
                purchasePrice.put(player, 200); //Input Price
                PurchaseConstructor.purchaseGui(player, purchaseItem.get(player), purchasePrice.get(player));
            }
        }
        
        //Open Trails Menu
        if (event.getSlot() == 15) {
            plugin.runTask(player, () -> player.openInventory(new TrailsGui(plugin, player).getInventory()));
        }
         
        // Return to cosmetic window
        if (event.getSlot() == 39) {
            plugin.runTask(player, () -> player.openInventory(new CosmeticGui(plugin, player).getInventory()));
        }
        
        // Remove Gadget Option
        if (event.getSlot() == 40) {
            RemoveEffectsOnQuit.ClearEffects(player);
        }
        
        //Close menu
        player.closeInventory();
    }
    
    

    

    
    
    
    
    

    
    
    
    
}





