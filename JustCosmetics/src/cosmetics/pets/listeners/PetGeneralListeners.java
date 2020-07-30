package cosmetics.pets.listeners;

import java.util.HashMap;

import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Snowman;
import org.bukkit.entity.Zombie;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.EntityBlockFormEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.entity.EntitySpawnEvent;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import cosmetics.Cosmetics;
import cosmetics.RemoveEffects;
import cosmetics.pets.BabySheepColourGUI;
import cosmetics.pets.CatTypeGui;
import cosmetics.pets.PetGui;
import cosmetics.pets.PetGui2;
import cosmetics.pets.SheepColourGUI;

public class PetGeneralListeners implements Listener {
    
    private Cosmetics plugin;
    public PetGeneralListeners(Cosmetics b) {
        plugin = b;
    }
    
    public static RemoveEffects RemoveEffects = new RemoveEffects();
    
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
    
    //Stop pets burning
    @EventHandler
    public void onDisguiseDamage(EntityDamageEvent event) {
        if (currentPet.containsValue(event.getEntity())) {
            
            if (event.getEntity() != null && event.getCause() == DamageCause.FIRE_TICK) {
                if(event.getEntity() instanceof Zombie) {
                    event.getEntity().setFireTicks(0);;
                }
            }
            
            event.setCancelled(true);
        }
    }
    
    //Stop naming and colour pet
    @EventHandler
    public void onMobInteract(PlayerInteractEntityEvent event) {
        if (currentPet.containsValue(event.getRightClicked())) {
            event.setCancelled(true);
        }
    }
    
    // Stop dragging of items out of pet guis
    @EventHandler
    public void InvClick(InventoryClickEvent event) {
        if(event.getRawSlot() <= 53 && event.getInventory().getHolder() instanceof PetGui) {
            plugin.getServer().getScheduler().runTask(plugin, () -> {
                event.getWhoClicked().getInventory().remove(event.getCurrentItem());
            });
            if (event.getClick().equals(ClickType.UNKNOWN)) {
                plugin.getServer().getScheduler().runTask(plugin, () -> {
                    event.getWhoClicked().getInventory().setItemInOffHand(null);
                });
            }
        }
        if(event.getRawSlot() <= 53 && event.getInventory().getHolder() instanceof PetGui2) {
            plugin.getServer().getScheduler().runTask(plugin, () -> {
                event.getWhoClicked().getInventory().remove(event.getCurrentItem());
            });
            if (event.getClick().equals(ClickType.UNKNOWN)) {
                plugin.getServer().getScheduler().runTask(plugin, () -> {
                    event.getWhoClicked().getInventory().setItemInOffHand(null);
                });
            }
        }
        if(event.getRawSlot() <= 53 && event.getInventory().getHolder() instanceof SheepColourGUI) {
            plugin.getServer().getScheduler().runTask(plugin, () -> {
                event.getWhoClicked().getInventory().remove(event.getCurrentItem());
            });
            if (event.getClick().equals(ClickType.UNKNOWN)) {
                plugin.getServer().getScheduler().runTask(plugin, () -> {
                    event.getWhoClicked().getInventory().setItemInOffHand(null);
                });
            }
        }
        if(event.getRawSlot() <= 53 && event.getInventory().getHolder() instanceof BabySheepColourGUI) {
            plugin.getServer().getScheduler().runTask(plugin, () -> {
                event.getWhoClicked().getInventory().remove(event.getCurrentItem());
            });
            if (event.getClick().equals(ClickType.UNKNOWN)) {
                plugin.getServer().getScheduler().runTask(plugin, () -> {
                    event.getWhoClicked().getInventory().setItemInOffHand(null);
                });
            }
            
        }
        if(event.getRawSlot() <= 53 && event.getInventory().getHolder() instanceof CatTypeGui) {
            plugin.getServer().getScheduler().runTask(plugin, () -> {
                event.getWhoClicked().getInventory().remove(event.getCurrentItem());
            });
            if (event.getClick().equals(ClickType.UNKNOWN)) {
                plugin.getServer().getScheduler().runTask(plugin, () -> {
                    event.getWhoClicked().getInventory().setItemInOffHand(null);
                });
            }
            
        }
    }
    
    @EventHandler
    public void onQuit(PlayerQuitEvent event) {
        Player player = event.getPlayer();
        RemoveEffects.ClearEffects(player);
    }
    
    // Force pets/disguises/anything JustCosmetics to be spawned
    @EventHandler(priority=EventPriority.HIGHEST)
    public void onEntitySpawn(EntitySpawnEvent event) {
        if (event.isCancelled()) {
            for (StackTraceElement element : Thread.currentThread().getStackTrace()) {
                if (element.getClassName().contains("cosmetics")) {
                    // This has something to do with cosmetics, must be us
                    event.setCancelled(false);
                }
            }
        }
    }
}
