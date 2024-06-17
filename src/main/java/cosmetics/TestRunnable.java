package cosmetics;

import java.util.HashMap;
import java.util.List;

import com.github.puregero.multilib.MultiLib;
import org.bukkit.Particle;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

import cosmetics.gadgets.listeners.GadgetGeneralListeners;
import cosmetics.gadgets.listeners.GadgetGuiListeners;

public class TestRunnable {
    
    public HashMap<Player, List<Entity>> shellMap = GadgetGuiListeners.shellMap;
    public List<Entity> shotshell = GadgetGeneralListeners.shotshell;
    
    public void TestRun(Player player) {
        
        double thetanew = System.currentTimeMillis()/100.0 + Math.PI * 2 / 3;
        
//        player.getLocation().getWorld().spawnParticle(Particle.COMPOSTER,
//                player.getLocation().getX(), player.getLocation().add(0, 2, 0).getY(),
//                player.getLocation().getZ(), 0);
        
        player.getLocation().getWorld().spawnParticle(Particle.COMPOSTER,
                player.getLocation().add(0.5*Math.cos(thetanew), 0, 0).getX(),
                player.getLocation().add(0, 2, 0).getY(),
                player.getLocation().add(0, 0, 0.5*Math.sin(thetanew)).getZ(), 0);

    }
    
    public void EntityWiggle(Player player) {
        
     if (shellMap.containsKey(player)) {
         
         for (int i = 0; i <= 2; i++) {
             Entity shell = shellMap.get(player).get(i);
             
             double thetanew = System.currentTimeMillis()/1000.0 + i * Math.PI * 2 / 3;
             
             MultiLib.teleportAsync(shell, player.getLocation().add(2.0*Math.cos(thetanew), 0, 2.0*Math.sin(thetanew)));
         }
   
     }

    }
    

}
