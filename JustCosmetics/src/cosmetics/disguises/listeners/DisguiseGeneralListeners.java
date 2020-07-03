package cosmetics.disguises.listeners;

import java.util.HashMap;

import org.bukkit.ChatColor;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Slime;
import org.bukkit.entity.Zombie;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.potion.PotionEffectType;


public class DisguiseGeneralListeners implements Listener {

    public HashMap<Player, Entity> currentDisguise = DisguiseGuiListeners.currentDisguise;
    
    @EventHandler
    public void onMovetest(PlayerMoveEvent event) {
        Player player = (Player) event.getPlayer();
        
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
    
    @EventHandler
    public void onDisguiseDamage(EntityDamageEvent event) {
        if (event.getEntity().getCustomName() != null && event.getEntity().getCustomName().contains("'s Disguise") 
                && event.getEntity().getCustomName().contains(ChatColor.GOLD + "" + ChatColor.BOLD)) {
            
            if (event.getEntity() != null && event.getCause() == DamageCause.FIRE_TICK) {
                if(event.getEntity() instanceof Zombie) {
                    event.getEntity().setFireTicks(0);;
                }
            }
            
            event.setCancelled(true);
        }
    }
    
    @EventHandler
    public void onQuit(PlayerQuitEvent event) {
        Player player = event.getPlayer();
        
        player.removePotionEffect(PotionEffectType.INVISIBILITY);
        
        if (currentDisguise.containsKey(player)) {
            currentDisguise.get(player).remove();
            currentDisguise.remove(player);
        }
    }
    

    
}
