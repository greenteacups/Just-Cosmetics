package cosmetics.particles.listeners;

import java.util.HashMap;

import org.bukkit.Particle;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import cosmetics.Cosmetics;

public class ParticleGeneralListeners implements Listener {

    private final Cosmetics plugin;
    public ParticleGeneralListeners(Cosmetics b) {
        this.plugin = b;
    }
    
    public static HashMap<Player, Particle> currentParticleType = ParticleGuiListeners.currentParticleType;
    public static HashMap<Player, String> currentParticlePattern = ParticleGuiListeners.currentParticlePattern;
    
    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        
        Player player = event.getPlayer();

        if (plugin.dataParticles.existsPlayer(player.getUniqueId())) {
            currentParticleType.put(player, Particle.valueOf(plugin.dataParticles.getType(player.getUniqueId())));
            currentParticlePattern.put(player, plugin.dataParticles.getPattern(player.getUniqueId()));

        }
    }
    
}
