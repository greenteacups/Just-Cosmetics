package cosmetics.gadgets;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.entity.TNTPrimed;

import cosmetics.gadgets.listeners.GadgetGeneralListeners;
import cosmetics.gadgets.listeners.GadgetGuiListeners;

public class GadgetRunnables {

    public HashMap<Player, List<Entity>> shellMap = GadgetGuiListeners.shellMap;
    public List<Entity> shotshell = GadgetGeneralListeners.shotshell;
    
    public HashMap<Player, List<Entity>> parrotMap = GadgetGuiListeners.parrotMap;
    
    public static HashMap<Player, Long> airstrike = GadgetGeneralListeners.airstrike;
    public static HashMap<Player, Entity> airturtlelist = new HashMap<>();
    public static List<Entity> tntList = new ArrayList<>();
    
    //Shell Spinning
    public void SpinRunnable(Player player) {
        
     if (shellMap.containsKey(player)) {
         
         for (int i = 0; i <= 2; i++) {
             Entity shell = shellMap.get(player).get(i);
             
             double thetanew = System.currentTimeMillis()/1000.0 + i * Math.PI * 2 / 3;
             
             shell.teleport(player.getLocation().add(2.0*Math.cos(thetanew), 0, 2.0*Math.sin(thetanew)));
         }
   
     }
     
     //Parrot spinning
     if (parrotMap.containsKey(player)) {
         
         if(!player.isSneaking()) {
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
         else {
             for (int i = 0; i <= 2; i++) {
                 Entity parrot = parrotMap.get(player).get(i);
                 
                 double thetanew = System.currentTimeMillis()/500.0 + i * Math.PI * 2 / 3;
                 
                 parrot.teleport(player.getLocation().add(0.8*Math.cos(thetanew), 1.3, 0.8*Math.sin(thetanew)));
             }
             
             for (int i = 0; i <= 1; i++) {
                 player.getLocation().getWorld().spawnParticle(Particle.COMPOSTER,
                         player.getLocation().add(Math.random()-0.5, 0, 0).getX(), player.getLocation().add(0, 1.7, 0).getY(),
                         player.getLocation().add(0, 0, Math.random()-0.5).getZ(), 0);
             }
         }
         

     }
     
     //Air Strike
     if (airstrike.containsKey(player)) {

         if (System.currentTimeMillis()/50 - airstrike.get(player) == 1) {
             player.sendMessage(ChatColor.DARK_GREEN + "Air Strike Confirmed");
         }
         if (System.currentTimeMillis()/50 - airstrike.get(player) == 50) {
             player.sendMessage(ChatColor.GOLD + "Air Strike Inbound");
         }
         if (System.currentTimeMillis()/50 - airstrike.get(player) == 100) {
             player.sendMessage(ChatColor.GOLD + "5");
         }
         if (System.currentTimeMillis()/50 - airstrike.get(player) == 120) {
             player.sendMessage(ChatColor.GOLD + "4");
         }
         if (System.currentTimeMillis()/50 - airstrike.get(player) == 140) {
             player.sendMessage(ChatColor.GOLD + "3");
         }
         if (System.currentTimeMillis()/50 - airstrike.get(player) == 160) {
             player.sendMessage(ChatColor.GOLD + "2");
         }
         if (System.currentTimeMillis()/50 - airstrike.get(player) == 180) {
             player.sendMessage(ChatColor.GOLD + "1");
         }
    
         if (System.currentTimeMillis()/50 - airstrike.get(player) > 145) {
             
             if (airturtlelist.containsKey(player) == false) {
                 
                 Location turtleLoc = player.getLocation().add(0, 10, -50);
                 turtleLoc.setYaw(0);
                 
                 LivingEntity airturtle = (LivingEntity) player.getWorld().spawnEntity(turtleLoc, EntityType.TURTLE);
                 airturtle.setInvulnerable(true);
                 airturtle.setAI(false);

                 airturtlelist.put(player, airturtle);
             }
             
             airturtlelist.get(player).teleport(airturtlelist.get(player).getLocation().add(0, 0, 1.5));
             
             for (int i = 0; i <= 4; i++ ) {
                 airturtlelist.get(player).getLocation().getWorld().spawnParticle(Particle.LAVA,
                         airturtlelist.get(player).getLocation().getX(), airturtlelist.get(player).getLocation().getY(),
                         airturtlelist.get(player).getLocation().getZ(), 0);
             }
                
             player.playSound(airturtlelist.get(player).getLocation(), Sound.ENTITY_LIGHTNING_BOLT_THUNDER,
                     10.0F, 0.533F);
             
             player.playSound(airturtlelist.get(player).getLocation(), Sound.ENTITY_ENDER_DRAGON_GROWL,
                     3.0F, 0.533F);
             
//             player.playSound(airturtlelist.get(0).getLocation(), Sound.ENTITY_GHAST_SCREAM,
//                     4.0F, 0.533F);
             
             player.playSound(airturtlelist.get(player).getLocation(), Sound.ENTITY_GHAST_SHOOT,
                     3.0F, 0.533F);
         }
 
         if (System.currentTimeMillis()/50 - airstrike.get(player) == 190) {
             Entity tnt = player.getWorld().spawn(airturtlelist.get(player).getLocation().subtract(0, 1, 0), TNTPrimed.class);
             ((TNTPrimed)tnt).setFuseTicks(50);
             tntList.add(tnt);
         }
         
         if (System.currentTimeMillis()/50 - airstrike.get(player) > 250) {
             airturtlelist.get(player).remove();
             airturtlelist.remove(player);
             airstrike.remove(player);
         }
         
     }
        
        return;
    }
}
