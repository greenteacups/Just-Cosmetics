package cosmetics.particles.listeners;

import java.util.HashMap;

import org.bukkit.Particle;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import cosmetics.Cosmetics;
import cosmetics.RemoveEffects;

public class ParticleGeneralListeners implements Listener {

    private Cosmetics plugin;
    public ParticleGeneralListeners(Cosmetics b) {
        plugin = b;
    }
    
    public RemoveEffects RemoveEffects = new RemoveEffects(plugin);
    
    public static HashMap<Player, Particle> currentParticleType = ParticleGuiListeners.currentParticleType;
    public static HashMap<Player, String> currentParticlePattern = ParticleGuiListeners.currentParticlePattern;
    
    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        
        Player player = (Player) event.getPlayer();

        if (plugin.dataParticles.existsPlayer(player.getUniqueId())) {
            currentParticleType.put(player, Particle.valueOf(plugin.dataParticles.getType(player.getUniqueId())));
            currentParticlePattern.put(player, plugin.dataParticles.getPattern(player.getUniqueId()));

        }
    }
    
}
