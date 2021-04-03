package cosmetics.sql;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import cosmetics.Cosmetics;

public class SQLListeners implements Listener {
    
    private final Cosmetics plugin;
    
    public SQLListeners(Cosmetics b) {
        this.plugin = b;
    }
    
    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        
        if (!plugin.dataSlime.exists(player.getUniqueId())) {
            plugin.dataSlime.createPlayer(player);
            plugin.dataSlime.addSlime(player.getUniqueId(), 100);
        }
    }

}
