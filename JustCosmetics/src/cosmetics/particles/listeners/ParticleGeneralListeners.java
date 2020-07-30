package cosmetics.particles.listeners;

import java.util.HashMap;

import org.bukkit.GameMode;
import org.bukkit.Particle;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerGameModeChangeEvent;
import org.bukkit.event.player.PlayerJoinEvent;

import cosmetics.Cosmetics;
import cosmetics.RemoveEffects;
import cosmetics.particles.ParticlePatternGui;
import cosmetics.particles.ParticleTypeGui;
import cosmetics.particles.ParticleTypeGui2;

public class ParticleGeneralListeners implements Listener {
    
    public static RemoveEffects RemoveEffects = new RemoveEffects();

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

        }
    }
    
    // Stop dragging of items out of particle gui
    @EventHandler
    public void InvClick(InventoryClickEvent event) {
        if(event.getRawSlot() <= 53 && event.getInventory().getHolder() instanceof ParticleTypeGui) {
            plugin.getServer().getScheduler().runTask(plugin, () -> {
                event.getWhoClicked().getInventory().remove(event.getCurrentItem());
            });
            if (event.getClick().equals(ClickType.UNKNOWN)) {
                plugin.getServer().getScheduler().runTask(plugin, () -> {
                    event.getWhoClicked().getInventory().setItemInOffHand(null);
                });
            }
        }
        if(event.getRawSlot() <= 53 && event.getInventory().getHolder() instanceof ParticleTypeGui2) {
            plugin.getServer().getScheduler().runTask(plugin, () -> {
                event.getWhoClicked().getInventory().remove(event.getCurrentItem());
            });
            if (event.getClick().equals(ClickType.UNKNOWN)) {
                plugin.getServer().getScheduler().runTask(plugin, () -> {
                    event.getWhoClicked().getInventory().setItemInOffHand(null);
                });
            }
        }
        if(event.getRawSlot() <= 53 && event.getInventory().getHolder() instanceof ParticlePatternGui) {
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
    
    
    //Remove Effects on Gamemode Change
    @EventHandler
    public void onGamemodeChange(PlayerGameModeChangeEvent event) {
        if (event.getNewGameMode().equals(GameMode.SPECTATOR)) {
            RemoveEffects.ClearEffects(event.getPlayer());
            
            currentParticleType.remove(event.getPlayer());
            currentParticlePattern.remove(event.getPlayer());
        }
    }
    
}
