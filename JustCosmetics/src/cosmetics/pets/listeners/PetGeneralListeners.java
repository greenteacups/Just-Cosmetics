package cosmetics.pets.listeners;

import java.util.HashMap;

import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Snowman;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.EntityBlockFormEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import cosmetics.Cosmetics;
import cosmetics.pets.BabySheepColourGUI;
import cosmetics.pets.PetGui;
import cosmetics.pets.PetGui2;
import cosmetics.pets.SheepColourGUI;

public class PetGeneralListeners implements Listener {
    
    public PetGui petgui = Cosmetics.petgui;
    public PetGui2 petgui2 = Cosmetics.petgui2;
    public SheepColourGUI colorgui = Cosmetics.colourgui;
    public BabySheepColourGUI babycolorgui = Cosmetics.babycolourgui;
    private Cosmetics plugin;
    
    public PetGeneralListeners(Cosmetics b) {
        plugin = b;
    }
    
    public HashMap<Player, Entity> currentPet = PetGuiListeners.currentPet;
    
    // Set Pets invunerable bc setinvun on spawn no work?
    @EventHandler
    public void onDamage(EntityDamageEvent event) {        
        if (event.getCause() != null) {
            for (Entity entity : currentPet.values()) {

                if (entity == event.getEntity()) {
                    event.setCancelled(true);  
                }
            }
        }
    }
    
    // Add particle to mobs
    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event) {
        Player player = (Player) event.getPlayer();
        
        for (Entity en : currentPet.values()) {
            player.getLocation().getWorld().spawnParticle(Particle.COMPOSTER,
                    en.getLocation().getX(), en.getLocation().add(0, 2, 0).getY(),
                    en.getLocation().getZ(), 0);
        }
    }
    
    
    // Right click on mob to make them delete
    @EventHandler
    public void onClick(PlayerInteractEntityEvent event) {
        Player player = event.getPlayer();
        
        if (currentPet.containsKey(player)) {
            if (event.getRightClicked() == currentPet.get(player)) {
                event.getPlayer().getWorld().spawnParticle(Particle.EXPLOSION_HUGE,
                        event.getPlayer().getLocation().getX(), event.getPlayer().getLocation().getY(),
                        event.getPlayer().getLocation().getZ(), 0);
                event.getPlayer().getWorld().playSound(event.getPlayer().getLocation(), Sound.ENTITY_DRAGON_FIREBALL_EXPLODE,
                        3.0F, 0.533F);
                event.getRightClicked().remove();
                currentPet.remove(player);
            }  
        }
        

    }
    
    // Stop Snowman forming snow
    @EventHandler
    public void removeSnow(EntityBlockFormEvent event) {

        for (Entity entity : currentPet.values()) {

            if (entity == event.getEntity() && event.getEntity() instanceof Snowman) {
                event.setCancelled(true);  
            }
        }
    }
    
    // Stop dragging of items out of gui
    @EventHandler
    public void InvClick(InventoryClickEvent event) {
        if(event.getInventory() == petgui.inv) {
            plugin.getServer().getScheduler().runTask(plugin, () -> {
                event.getWhoClicked().getInventory().remove(event.getCurrentItem());
            });
        }
        if(event.getInventory() == petgui2.inv) {
            plugin.getServer().getScheduler().runTask(plugin, () -> {
                event.getWhoClicked().getInventory().remove(event.getCurrentItem());
            });
        }
        if(event.getInventory() == colorgui.inv) {
            plugin.getServer().getScheduler().runTask(plugin, () -> {
                event.getWhoClicked().getInventory().remove(event.getCurrentItem());
            });
        }
        if(event.getInventory() == babycolorgui.inv) {
            plugin.getServer().getScheduler().runTask(plugin, () -> {
                event.getWhoClicked().getInventory().remove(event.getCurrentItem());
            });
            
        }
    }
    
    @EventHandler
    public void onQuit(PlayerQuitEvent event) {
        Player player = event.getPlayer();
        
        if (currentPet.containsKey(player)) {
            currentPet.get(player).remove();
            currentPet.remove(player);
        }
    }
    
    
}
