package cosmetics.gadgets.listeners;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.craftbukkit.v1_16_R1.CraftWorld;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import cosmetics.CosmeticGui;
import cosmetics.Cosmetics;
import cosmetics.PurchaseConstructor;
import cosmetics.RemoveEffects;
import cosmetics.gadgets.GadgetGui;
import cosmetics.gadgets.GadgetRunnables;
import cosmetics.gadgets.items.AirStrike;
import cosmetics.gadgets.items.FireworkSpawn;
import cosmetics.gadgets.items.JumpStick;
import cosmetics.gadgets.items.ParrotSpawn;
import cosmetics.gadgets.items.ShellShooter;
import cosmetics.gadgets.items.TurtleSpawn;
import cosmetics.trails.TrailsGui;
import net.minecraft.server.v1_16_R1.WorldServer;

public class GadgetGuiListeners implements Listener {
    
    public PurchaseConstructor PurchaseConstructor = Cosmetics.PurchaseConstructor;
    public HashMap<Player, String> purchaseItem = Cosmetics.purchaseItem;
    public HashMap<Player, Integer> purchasePrice = Cosmetics.purchasePrice;
    
    private Cosmetics plugin;
    public GadgetGuiListeners(Cosmetics b) {
        plugin = b;
    }
    
    public static RemoveEffects RemoveEffects = new RemoveEffects();
    
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
        if (event.getCurrentItem().getItemMeta().getDisplayName() == null) return;
        
        event.setCancelled(true);
        
        Player player = (Player) event.getWhoClicked();
        
        // Remove Active Cosmetics when selecting new Gadget
        if (event.getSlot() < 35) {
            RemoveEffects.ClearEffects(player);
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
                
                WorldServer world = ((CraftWorld) player.getWorld()).getHandle();
                
                TurtleSpawn shell1 = new TurtleSpawn(player.getLocation().add(0, 0, -2), player);
                TurtleSpawn shell2 = new TurtleSpawn(player.getLocation().add(2/Math.sqrt(2), 0, 2/Math.sqrt(2)), player);
                TurtleSpawn shell3 = new TurtleSpawn(player.getLocation().add(-2/Math.sqrt(2), 0, 2/Math.sqrt(2)), player);
                
                world.addEntity(shell1);
                world.addEntity(shell2);
                world.addEntity(shell3);
                
                shellList.add(shell1.getBukkitEntity());
                shellList.add(shell2.getBukkitEntity());
                shellList.add(shell3.getBukkitEntity());
                
                plugin.getServer().getScheduler().runTaskLater(plugin, () -> {
                shellMap.put(player, shellList);
                }, 1);
                
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
                
                WorldServer world = ((CraftWorld) player.getWorld()).getHandle();
                
                ParrotSpawn parrot1 = new ParrotSpawn(player.getLocation().add(0, 1.7, -0.8), player);
                ParrotSpawn parrot2 = new ParrotSpawn(player.getLocation().add(0.8/Math.sqrt(2), 1.7, 0.8/Math.sqrt(2)), player);
                ParrotSpawn parrot3 = new ParrotSpawn(player.getLocation().add(-0.8/Math.sqrt(2), 1.7, 0.8/Math.sqrt(2)), player);
                
                world.addEntity(parrot1);
                world.addEntity(parrot2);
                world.addEntity(parrot3);
                
                parrotList.add(parrot1.getBukkitEntity());
                parrotList.add(parrot2.getBukkitEntity());
                parrotList.add(parrot3.getBukkitEntity());
                
                plugin.getServer().getScheduler().runTaskLater(plugin, () -> {
                parrotMap.put(player, parrotList);
                }, 1);
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
            plugin.getServer().getScheduler().runTask(plugin, () -> {
                player.openInventory(new TrailsGui(plugin, player).getInventory());
            });
        }
         
        // Return to cosmetic window
        if (event.getSlot() == 39) {
            plugin.getServer().getScheduler().runTask(plugin, () -> {
                player.openInventory(new CosmeticGui(plugin, player).getInventory());
            });
        }
        
        // Remove Gadget Option
        if (event.getSlot() == 40) {
            RemoveEffects.ClearEffects(player);
        }
        
        player.closeInventory();
    }
    
    

    

    
    
    
    
    

    
    
    
    
}





