package cosmetics.particles.listeners;

import java.util.HashMap;

import org.bukkit.Particle;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import cosmetics.Cosmetics;
import cosmetics.particles.ParticlePatternGui;
import cosmetics.particles.ParticleTypeGui;
import cosmetics.particles.ParticleTypeGui2;

public class ParticleGeneralListeners implements Listener {
    
    public ParticleTypeGui particletypegui = Cosmetics.particletypegui;
    public ParticleTypeGui2 particletypegui2 = Cosmetics.particletypegui2;
    public ParticlePatternGui particlepatterngui = Cosmetics.particlepatterngui;

    private Cosmetics plugin;
    public ParticleGeneralListeners(Cosmetics b) {
        plugin = b;
    }
    
    public static HashMap<Player, Particle> currentParticleType = ParticleGuiListeners.currentParticleType;
    public static HashMap<Player, String> currentParticlePattern = ParticleGuiListeners.currentParticlePattern;
    
    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        
        Player player = (Player) event.getPlayer();

        if (plugin.dataParticles.existsPlayer(player.getUniqueId())) {
            currentParticleType.put(player, Particle.valueOf(plugin.dataParticles.getType(player.getUniqueId())));
            currentParticlePattern.put(player, plugin.dataParticles.getPattern(player.getUniqueId()));

            plugin.dataParticles.remove(player.getUniqueId());
        }
    }
    
    @EventHandler
    public void onQuit(PlayerQuitEvent event) {

        Player player = (Player) event.getPlayer();
        
        if (currentParticleType != null && currentParticlePattern != null) {
            if (currentParticleType.containsKey(player) && currentParticlePattern.containsKey(player)) {
                
                plugin.dataParticles.addParticle(player, player.getUniqueId(),
                        currentParticleType.get(player).toString(), currentParticlePattern.get(player));
                
                currentParticleType.remove(player);
                currentParticlePattern.remove(player);
                
            }
        }
    }
    
    // Stop dragging of items out of particle gui
    @EventHandler
    public void InvClick(InventoryClickEvent event) {
        if(event.getInventory() == particletypegui.inv) {
            plugin.getServer().getScheduler().runTask(plugin, () -> {
                event.getWhoClicked().getInventory().remove(event.getCurrentItem());
            });
        }
        if(event.getInventory() == particletypegui2.inv) {
            plugin.getServer().getScheduler().runTask(plugin, () -> {
                event.getWhoClicked().getInventory().remove(event.getCurrentItem());
            });
        }
        if(event.getInventory() == particlepatterngui.inv) {
            plugin.getServer().getScheduler().runTask(plugin, () -> {
                event.getWhoClicked().getInventory().remove(event.getCurrentItem());
            });
        }
    }
    
}
