package cosmetics.disguises.listeners;

import java.util.HashMap;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Skeleton;
import org.bukkit.entity.Slime;
import org.bukkit.entity.Stray;
import org.bukkit.entity.Zombie;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.*;
import org.bukkit.potion.PotionEffectType;

import cosmetics.Cosmetics;
import cosmetics.RemoveEffectsOnQuit;


public class DisguiseGeneralListeners implements Listener {

    private final Cosmetics plugin;

    public DisguiseGeneralListeners(Cosmetics b) {
        this.plugin = b;
    }

    public HashMap<Player, Entity> currentDisguise = DisguiseGuiListeners.currentDisguise;
    
    public static RemoveEffectsOnQuit RemoveEffectsOnQuit = new RemoveEffectsOnQuit();
    
    @EventHandler
    public void onMovetest(PlayerMoveEvent event) {
        Player player = event.getPlayer();
        
        if (currentDisguise.containsKey(player)) {
            
            currentDisguise.get(player).getLocation().setYaw(player.getLocation().getYaw());
            currentDisguise.get(player).getLocation().setPitch(player.getLocation().getPitch());
            
            if (currentDisguise.get(player) instanceof Slime) {
                // Put the pet behind the player
                currentDisguise.get(player).teleport(player.getLocation()
                        .add(2*Math.sin(Math.toRadians(player.getLocation().getYaw())),
                                0, -2*Math.cos(Math.toRadians(player.getLocation().getYaw()))));
            }
            else {
                // Put the pet behind the player
                currentDisguise.get(player).teleport(player.getLocation()
                        .add(Math.sin(Math.toRadians(player.getLocation().getYaw())),
                                0, -Math.cos(Math.toRadians(player.getLocation().getYaw()))));
            }

        } 
    }
    
    //Stop disguises burning
    @EventHandler
    public void onDisguiseDamage(EntityDamageEvent event) {
        if (currentDisguise.containsValue(event.getEntity())) {
            
            if (event.getCause() == DamageCause.FIRE_TICK) {
                if(event.getEntity() instanceof Zombie) {
                    event.getEntity().setFireTicks(0);
                }
                if(event.getEntity() instanceof Skeleton) {
                    event.getEntity().setFireTicks(0);
                }
                if(event.getEntity() instanceof Stray) {
                    event.getEntity().setFireTicks(0);
                }
            }
            
            event.setCancelled(true);
        }
    }
    
    //Stop naming and colour disguises
    @EventHandler
    public void onMobInteract(PlayerInteractEntityEvent event) {
        if (currentDisguise.containsValue(event.getRightClicked())) {
            event.setCancelled(true);
        }
    }
    
    //Player death remove Everything
    @EventHandler
    public void onDeathEvent(PlayerDeathEvent event) {
        if (currentDisguise.containsKey(event.getEntity())) {
            RemoveEffectsOnQuit.ClearEffects(event.getEntity());
        }
    }
    
    //Player PvP remove Disguise
    @EventHandler
    public void onPvp(EntityDamageByEntityEvent event) {
        if (event.getDamager() instanceof Player && event.getEntity() instanceof Player) {
            
            Player player1 = (Player) event.getDamager();
            Player player2 = (Player) event.getEntity();
                        
            if (currentDisguise.containsKey(player1)) {
                player1.removePotionEffect(PotionEffectType.INVISIBILITY);
                currentDisguise.get(player1).remove();
                currentDisguise.remove(player1);
            }
            
            if (currentDisguise.containsKey(player2)) {
                player2.removePotionEffect(PotionEffectType.INVISIBILITY);
                currentDisguise.get(player2).remove();
                currentDisguise.remove(player2);
            }
            
        }
    }
    
    //Player Drink Milk remove Disguise
    @EventHandler
    public void DrinkMilk(PlayerItemConsumeEvent event) {
        if (event.getItem().getType().equals(Material.MILK_BUCKET)) {
            Player player = event.getPlayer();
            
            if (currentDisguise.containsKey(player)) {
                player.removePotionEffect(PotionEffectType.INVISIBILITY);
                currentDisguise.get(player).remove();
                currentDisguise.remove(player);
            }
        }
    }
    
    
    @EventHandler
    public void onQuit(PlayerQuitEvent event) {
        Player player = event.getPlayer();
        RemoveEffectsOnQuit.ClearEffects(player);
    }

    @EventHandler
    public void onGamemodeChange(PlayerGameModeChangeEvent e) {
        Player player = e.getPlayer();
        Entity disguise = currentDisguise.get(player);
        if(disguise != null && e.getNewGameMode() == GameMode.SPECTATOR) {
            disguise.remove();
            currentDisguise.remove(player);
            player.removePotionEffect(PotionEffectType.INVISIBILITY);
            player.sendMessage(ChatColor.DARK_RED + "Your disguise was removed because you went into spectator mode!");
        }
    }
    
}
