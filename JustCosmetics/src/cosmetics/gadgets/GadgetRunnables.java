package cosmetics.gadgets;

import java.util.HashMap;
import java.util.List;

import org.bukkit.Particle;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

import cosmetics.gadgets.listeners.GadgetGeneralListeners;
import cosmetics.gadgets.listeners.GadgetGuiListeners;

public class GadgetRunnables {

    public HashMap<Player, List<Entity>> shellMap = GadgetGuiListeners.shellMap;
    public List<Entity> shotshell = GadgetGeneralListeners.shotshell;
    
    public HashMap<Player, List<Entity>> parrotMap = GadgetGuiListeners.parrotMap;
    
    //Shell Spinning
    public void ShellSpinning(Player player) {
        
     if (shellMap.containsKey(player)) {
         
         for (int i = 0; i <= 2; i++) {
             Entity shell = shellMap.get(player).get(i);
             
             double thetanew = System.currentTimeMillis()/1000.0 + i * Math.PI * 2 / 3;
             
             shell.teleport(player.getLocation().add(2.0*Math.cos(thetanew), 0, 2.0*Math.sin(thetanew)));
         }
   
     }
     
     //Parrot spinning
     if (parrotMap.containsKey(player)) {
         
         for (int i = 0; i <= 2; i++) {
             Entity parrot = parrotMap.get(player).get(i);
             
             double thetanew = System.currentTimeMillis()/500.0 + i * Math.PI * 2 / 3;
             
             parrot.teleport(player.getLocation().add(0.8*Math.cos(thetanew), 1.7, 0.8*Math.sin(thetanew)));
         }
         
         for (int i = 0; i <= 1; i++) {
             player.getLocation().getWorld().spawnParticle(Particle.COMPOSTER,
                     player.getLocation().add(Math.random()-0.5, 0, 0).getX(), player.getLocation().add(0, 2, 0).getY(),
                     player.getLocation().add(0, 0, Math.random()-0.5).getZ(), 0);
         }

   
     }
        
        return;
    }
}
