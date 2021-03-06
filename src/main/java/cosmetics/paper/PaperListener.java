package cosmetics.paper;

import com.destroystokyo.paper.event.entity.EntityPathfindEvent;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;

import cosmetics.Cosmetics;

public class PaperListener implements Listener {

    public PaperListener(Cosmetics b) {
        ////
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onEntityPathfind(EntityPathfindEvent event) {
        try {
            // event.getEntity().getHandle()'s class is a cosmetics class
            boolean isCosmeticsEntity = event.getEntity().getClass().getMethod("getHandle").invoke(event.getEntity()).getClass().getName().contains("cosmetics");

            if (isCosmeticsEntity) {
                event.setCancelled(false);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

} 
