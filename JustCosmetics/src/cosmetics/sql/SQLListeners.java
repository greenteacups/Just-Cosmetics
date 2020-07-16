package cosmetics.sql;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import cosmetics.Cosmetics;
import cosmetics.disguises.DisguiseGui;

public class SQLListeners implements Listener {
    
    private Cosmetics plugin;
    
    public SQLListeners(Cosmetics b) {
        plugin = b;
    }
    
    public DisguiseGui disguisegui = Cosmetics.disguisegui;
    
    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        plugin.dataSlime.createPlayer(player);
        //plugin.dataCosmetics.createPlayer(player);

    }

}
