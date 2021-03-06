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
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import cosmetics.Cosmetics;
import cosmetics.RemoveEffectsOnQuit;

public class PetGeneralListeners implements Listener {
    
    @SuppressWarnings("unused")
    private final Cosmetics plugin;
    public PetGeneralListeners(Cosmetics b) {
        this.plugin = b;
        PetSpawn = new PetGuiListeners(plugin);
    }

    public PetGuiListeners PetSpawn;

    public static RemoveEffectsOnQuit RemoveEffectsOnQuit = new RemoveEffectsOnQuit();
    
    public HashMap<Player, Entity> currentPet = PetGuiListeners.currentPet;
    
    // Set Pets invunerable bc setinvun on spawn no work?
    @EventHandler
    public void onDamage(EntityDamageEvent event) {
        for (Entity entity : currentPet.values()) {
            if (entity == event.getEntity()) {
                event.setCancelled(true);
            }
        }
    }
    
    // Add particle to mobs
    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event) {
        Player player = event.getPlayer();
        
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
            
            if (event.getCause() == DamageCause.FIRE_TICK) {
                if(event.getEntity() instanceof Zombie) {
                    event.getEntity().setFireTicks(0);
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
    
    
    @EventHandler
    public void onQuit(PlayerQuitEvent event) {
        Player player = event.getPlayer();        
        RemoveEffectsOnQuit.ClearEffects(player);
    }
    
    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        
        Player player = event.getPlayer();

        if (plugin.dataPets.existsPlayer(player.getUniqueId())) {
            PetSpawn.Pet(player, plugin.dataPets.getPet(player.getUniqueId()));
            //plugin.dataPets.remove(player.getUniqueId());
        }
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
