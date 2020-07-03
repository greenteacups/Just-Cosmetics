package cosmetics.gadgets.listeners;

import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

public class GadgetGeneralListeners implements Listener {
    
    @EventHandler
    public void onClick(PlayerInteractEvent event) {
        
        Player player = (Player) event.getPlayer();
        
        if (player.getInventory().getItemInMainHand() != null 
                && player.getInventory().getItemInMainHand().getItemMeta().getDisplayName().contains("Jump Stick")) {
            if (player.getInventory().getItemInMainHand().getItemMeta().hasLore()) {
                if (player.getLocation().subtract(0, 1, 0).getBlock().getType() != Material.AIR) {
                    player.setVelocity(player.getLocation().getDirection().multiply(2).setY(2));
                    
                    event.getPlayer().getWorld().spawnParticle(Particle.EXPLOSION_HUGE,
                            event.getPlayer().getLocation().getX(), event.getPlayer().getLocation().getY(),
                            event.getPlayer().getLocation().getZ(), 0);
                    event.getPlayer().getWorld().playSound(event.getPlayer().getLocation(), Sound.ENTITY_DRAGON_FIREBALL_EXPLODE,
                            3.0F, 0.533F);
                }
            }
        }
        
    }

}
