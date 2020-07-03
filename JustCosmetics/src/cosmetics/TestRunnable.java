package cosmetics;

import java.util.HashMap;
import java.util.List;

import org.bukkit.Particle;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

import cosmetics.gadgets.listeners.GadgetGuiListeners;

public class TestRunnable {
    
    public HashMap<Player, List<Entity>> shellMap = GadgetGuiListeners.shellMap;
    
    public void TestRun(Player player) {
        
        player.getLocation().getWorld().spawnParticle(Particle.COMPOSTER,
                player.getLocation().getX(), player.getLocation().add(0, 2, 0).getY(),
                player.getLocation().getZ(), 0);
        
        return;
    }
    
    public void EntityWiggle(Player player) {
        
     if (shellMap.containsKey(player)) {
         
         for (int i = 0; i <= 2; i++) {
             Entity shell = shellMap.get(player).get(i);
             
             double thetanew = 5*(Math.PI/180) + Math.atan2((shell.getLocation().getZ() - player.getLocation().getZ()),
                     (shell.getLocation().getX() - player.getLocation().getX()));
             
             //player.sendMessage("" + Math.toDegrees(theta) + Math.toDegrees(thetanew));
             
             shell.teleport(player.getLocation()
             .add(2.0*Math.cos(thetanew),
                     0, 2.0*Math.sin(thetanew)));
         }
                
         
         
//         if (shellMap.get(player).getLocation() == player.getLocation()) {
//             shellMap.get(player).teleport(player.getLocation().add(1, 0, 1));
//         }
//         else {
//
//             //double theta = Math.atan((shell.getLocation().getZ() - player.getLocation().getZ())/
//                     //(shell.getLocation().getX() - player.getLocation().getX()));
//             
//             double thetanew = 5*(Math.PI/180) + Math.atan2((shellMap.get(player).getLocation().getZ() - player.getLocation().getZ()),
//                     (shellMap.get(player).getLocation().getX() - player.getLocation().getX()));
//             
//             //player.sendMessage("" + Math.toDegrees(theta) + Math.toDegrees(thetanew));
//             
//             shellMap.get(player).teleport(player.getLocation()
//             .add(1.5*Math.cos(thetanew),
//                     0, 1.5*Math.sin(thetanew)));
//         }
         
         
                
     }
        
        

        
        return;
    }
}
