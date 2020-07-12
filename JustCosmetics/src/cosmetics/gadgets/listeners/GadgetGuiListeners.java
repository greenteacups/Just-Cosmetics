package cosmetics.gadgets.listeners;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.bukkit.craftbukkit.v1_16_R1.CraftWorld;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import cosmetics.CosmeticGui;
import cosmetics.Cosmetics;
import cosmetics.disguises.listeners.DisguiseGuiListeners;
import cosmetics.gadgets.GadgetGui;
import cosmetics.gadgets.GadgetRunnables;
import cosmetics.gadgets.items.AirStrike;
import cosmetics.gadgets.items.JumpStick;
import cosmetics.gadgets.items.ParrotSpawn;
import cosmetics.gadgets.items.ShellShooter;
import cosmetics.gadgets.items.TurtleSpawn;
import cosmetics.pets.listeners.PetGuiListeners;
import net.minecraft.server.v1_16_R1.WorldServer;

public class GadgetGuiListeners implements Listener {

    public CosmeticGui maingui = Cosmetics.maingui;
    public GadgetGui gadgetgui = Cosmetics.gadgetgui;
    private Cosmetics plugin;

    public GadgetGuiListeners(Cosmetics b) {
        plugin = b;
    }
    
    public HashMap<Player, Entity> currentPet = PetGuiListeners.currentPet;
    public HashMap<Player, Entity> currentDisguise = DisguiseGuiListeners.currentDisguise;
    
    public static HashMap<Player, List<Entity>> shellMap = new HashMap<>();
    public static HashMap<Player, List<Entity>> parrotMap = new HashMap<>();
    public static HashMap<Player, Long> airstrike = GadgetRunnables.airstrike;
    public static HashMap<Player, Entity> airturtlelist = GadgetRunnables.airturtlelist;
    
    //////
    //Clicking Inside the main Main Gui
    @EventHandler()
    public void onPetGuiClick(InventoryClickEvent event) {
        if (!event.getInventory().equals(gadgetgui.inv))
            return;
        if (event.getCurrentItem() == null) return;
        if (event.getCurrentItem().getItemMeta() == null) return;
        if (event.getCurrentItem().getItemMeta().getDisplayName() == null) return;
        
        event.setCancelled(true);
        
        Player player = (Player) event.getWhoClicked();
        
        // Remove Active Cosmetics when selecting new Gadget
        if (event.getSlot() < 35) {
            player.getInventory().setItem(8, null);
            
            // Remove Turtles
            if (shellMap.containsKey(player)) {
                for (int i = 0; i <= 2; i++) {
                    shellMap.get(player).get(i).remove();
                }
                shellMap.remove(player);
            }
            
            // Remove Parrot Gadget
            if (parrotMap.containsKey(player)) {
                for (int i = 0; i <= 2; i++) {
                    parrotMap.get(player).get(i).remove();
                }
                parrotMap.remove(player);
            }
            
            // Remove AirStrike Gadget
            if (airstrike.containsKey(player)) {
                airturtlelist.get(player).remove();
                airturtlelist.remove(player);
                airstrike.remove(player);
            }
            
            // Remove Disguise
            if (currentDisguise.containsKey(player)) {
                currentDisguise.get(player).remove();
                currentDisguise.remove(player);
            }
            
            //Remove Pet
            if (currentPet.containsKey(player)) {
                currentPet.get(player).remove();
                currentPet.remove(player);
            }
        }
        
        //Add Jump Stick Gadget
        if (event.getSlot() == 10) {
            
            JumpStick jumpstick = new JumpStick();
            
            player.getInventory().setItem(8, jumpstick.getItem());
        }
        
        //Add Shell Gadget
        if (event.getSlot() == 11) {
            
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
            
            ShellShooter shellshooter = new ShellShooter();
            player.getInventory().setItem(8, shellshooter.getItem());
        }
        
        //Add Dazed Gadget
        if (event.getSlot() == 12) {
            
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
        
        //Add Air Strike Gadget
        if (event.getSlot() == 13) {
            
            AirStrike airstrike = new AirStrike();
            
            player.getInventory().setItem(8, airstrike.getItem());
        }
         
        // Return to cosmetic window
        if (event.getSlot() == 39) {
            plugin.getServer().getScheduler().runTask(plugin, () -> {
                player.openInventory(maingui.inv);
            });
        }
        
        // Remove Gadget Option
        if (event.getSlot() == 40) {
            
            player.getInventory().setItem(8, null);
            
            // Remove Turtles
            if (shellMap.containsKey(player)) {
                for (int i = 0; i <= 2; i++) {
                    shellMap.get(player).get(i).remove();
                }
                shellMap.remove(player);
            }
            
            // Remove Parrot Gadget
            if (parrotMap.containsKey(player)) {
                for (int i = 0; i <= 2; i++) {
                    parrotMap.get(player).get(i).remove();
                }
                parrotMap.remove(player);
            }
        }
        
        player.closeInventory();
    }
    
    

    

    
    
    
    
    

    
    
    
    
}





