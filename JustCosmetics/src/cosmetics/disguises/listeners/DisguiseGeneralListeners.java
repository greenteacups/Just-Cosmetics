package cosmetics.disguises.listeners;

import java.util.HashMap;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.craftbukkit.v1_15_R1.entity.CraftEntity;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Zombie;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.player.PlayerMoveEvent;


public class DisguiseGeneralListeners implements Listener {

    public HashMap<Player, Entity> currentDisguise = DisguiseGuiListeners.currentDisguise;
    
    //private HashMap<Player, Location> playerLoc = new HashMap<>();
    
    @EventHandler
    public void onMovetest(PlayerMoveEvent event) {
        Player player = (Player) event.getPlayer();
        
        if (currentDisguise.containsKey(player)) {
            //currentDisguise.get(player).teleport(player.getLocation());
            
            currentDisguise.get(player).getLocation().setYaw(player.getLocation().getYaw());
            currentDisguise.get(player).getLocation().setPitch(player.getLocation().getPitch());
                  
            //player.sendMessage("" + player.getLocation().getYaw());
              
            // Teleport the mob to behind the player
            // This is so big to increase the resolution - super messy though :/
            if (player.getLocation().getYaw() < 0 && player.getLocation().getYaw() >= -11.25) {
                currentDisguise.get(player).teleport(player.getLocation().subtract(0, 0, 1));
            }
              
            if (player.getLocation().getYaw() < -11.25 && player.getLocation().getYaw() >= -22.5) {
                currentDisguise.get(player).teleport(player.getLocation().subtract(0.2, 0, 0.92));
            }
            if (player.getLocation().getYaw() < -22.5 && player.getLocation().getYaw() >= -33.75) {
                currentDisguise.get(player).teleport(player.getLocation().subtract(0.5, 0, 0.87));
            }
              
            if (player.getLocation().getYaw() < -33.75 && player.getLocation().getYaw() >= -56.25) {
                currentDisguise.get(player).teleport(player.getLocation().subtract(0.8, 0, 0.8));
            }
              
            if (player.getLocation().getYaw() < -56.25 && player.getLocation().getYaw() >= -67.5) {
                currentDisguise.get(player).teleport(player.getLocation().subtract(0.87, 0, 0.5));
            }
            if (player.getLocation().getYaw() < -67.5 && player.getLocation().getYaw() >= -78.75) {
                currentDisguise.get(player).teleport(player.getLocation().subtract(0.94, 0, 0.2));
            }
              
            if (player.getLocation().getYaw() < -78.75 && player.getLocation().getYaw() >= -101.25) {
                currentDisguise.get(player).teleport(player.getLocation().subtract(1, 0, 0));
            }
              
            if (player.getLocation().getYaw() < -101.25 && player.getLocation().getYaw() >= -112.5) {
                currentDisguise.get(player).teleport(player.getLocation().subtract(0.94, 0, -0.2));
            }
            if (player.getLocation().getYaw() < -112.5 && player.getLocation().getYaw() >= -123.75) {
                currentDisguise.get(player).teleport(player.getLocation().subtract(0.87, 0, -0.5));
            }
              
            if (player.getLocation().getYaw() < -123.75 && player.getLocation().getYaw() >= -146.25) {
                currentDisguise.get(player).teleport(player.getLocation().subtract(0.8, 0, -0.8));
            }
              
            if (player.getLocation().getYaw() < -146.25 && player.getLocation().getYaw() >= -157.5) {
                currentDisguise.get(player).teleport(player.getLocation().subtract(0.5, 0, -0.87));
            }
            if (player.getLocation().getYaw() < -157.5 && player.getLocation().getYaw() >= -168.75) {
                currentDisguise.get(player).teleport(player.getLocation().subtract(0.2, 0, -0.94));
            }
              
            if (player.getLocation().getYaw() < -168.75 && player.getLocation().getYaw() >= -191.25) {
                currentDisguise.get(player).teleport(player.getLocation().add(0, 0, 1));
            }
              
            if (player.getLocation().getYaw() < -191.25 && player.getLocation().getYaw() >= -202.5) {
                currentDisguise.get(player).teleport(player.getLocation().add(0.2, 0, 0.94));
            }
            if (player.getLocation().getYaw() < -202.5 && player.getLocation().getYaw() >= -213.75) {
                currentDisguise.get(player).teleport(player.getLocation().add(0.5, 0, 0.87));
            }
              
            if (player.getLocation().getYaw() < -213.75 && player.getLocation().getYaw() >= -236.25) {
                currentDisguise.get(player).teleport(player.getLocation().add(0.8, 0, 0.8));
            }
              
            if (player.getLocation().getYaw() < -236.25 && player.getLocation().getYaw() >= -247.5) {
                currentDisguise.get(player).teleport(player.getLocation().add(0.87, 0, 0.5));
            }
            if (player.getLocation().getYaw() < -247.5 && player.getLocation().getYaw() >= -258.75) {
                currentDisguise.get(player).teleport(player.getLocation().add(0.92, 0, 0.2));
            }
              
            if (player.getLocation().getYaw() < -258.75 && player.getLocation().getYaw() >= -281.25) {
                currentDisguise.get(player).teleport(player.getLocation().add(1, 0, 0));
            }
              
            if (player.getLocation().getYaw() < -281.25 && player.getLocation().getYaw() >= -292.5) {
                currentDisguise.get(player).teleport(player.getLocation().add(0.92, 0, -0.2));
            }
            if (player.getLocation().getYaw() < -292.5 && player.getLocation().getYaw() >= -303.75) {
                currentDisguise.get(player).teleport(player.getLocation().add(0.87, 0, -0.5));
            }
              
            if (player.getLocation().getYaw() < -303.75 && player.getLocation().getYaw() >= -326.25) {
                currentDisguise.get(player).teleport(player.getLocation().add(0.8, 0, -0.8));
            }
              
            if (player.getLocation().getYaw() < -326.25 && player.getLocation().getYaw() >= -337.5) {
                currentDisguise.get(player).teleport(player.getLocation().add(0.5, 0, -0.87));
            }
            if (player.getLocation().getYaw() < -337.5 && player.getLocation().getYaw() >= -348.75) {
                currentDisguise.get(player).teleport(player.getLocation().add(0.2, 0, -0.92));
            }
              
            if (player.getLocation().getYaw() < -348.75 && player.getLocation().getYaw() >= -360) {
                currentDisguise.get(player).teleport(player.getLocation().subtract(0, 0, 1));
            }
              
    
              
              //en.get(i).teleport(player.getLocation());
              
              player.setCollidable(false);
        }
        
    }

    
//    @EventHandler
//    public void onMove(PlayerMoveEvent event) {
//        Player player = (Player) event.getPlayer();
//        
//        List<Entity> en = event.getPlayer().getNearbyEntities(20, 20, 20);
//            
//        for (int i = 0; i < en.size(); i++) {
//
//            if (((CraftEntity) en.get(i)).isCustomNameVisible()) {
//
//                if (((CraftEntity) en.get(i)).getCustomName().contains(ChatColor.GOLD + ""  + ChatColor.BOLD) && 
//                        ((CraftEntity) en.get(i)).getCustomName().contains(player.getName()) &&
//                        ((CraftEntity) en.get(i)).getCustomName().contains("'s Disguise")) {
//                        
//                    en.get(i).getLocation().setYaw(player.getLocation().getYaw());
//                    en.get(i).getLocation().setPitch(player.getLocation().getPitch());
//                        
//                    //player.sendMessage("" + player.getLocation().getYaw());
//                    
//                    // Teleport the mob to behind the player
//                    // This is so big to increase the resolution - super messy though :/
//                    if (player.getLocation().getYaw() < 0 && player.getLocation().getYaw() >= -11.25) {
//                        en.get(i).teleport(player.getLocation().subtract(0, 0, 1));
//                    }
//                    
//                    if (player.getLocation().getYaw() < -11.25 && player.getLocation().getYaw() >= -22.5) {
//                        en.get(i).teleport(player.getLocation().subtract(0.2, 0, 0.92));
//                    }
//                    if (player.getLocation().getYaw() < -22.5 && player.getLocation().getYaw() >= -33.75) {
//                        en.get(i).teleport(player.getLocation().subtract(0.5, 0, 0.87));
//                    }
//                    
//                    if (player.getLocation().getYaw() < -33.75 && player.getLocation().getYaw() >= -56.25) {
//                        en.get(i).teleport(player.getLocation().subtract(0.8, 0, 0.8));
//                    }
//                    
//                    if (player.getLocation().getYaw() < -56.25 && player.getLocation().getYaw() >= -67.5) {
//                        en.get(i).teleport(player.getLocation().subtract(0.87, 0, 0.5));
//                    }
//                    if (player.getLocation().getYaw() < -67.5 && player.getLocation().getYaw() >= -78.75) {
//                        en.get(i).teleport(player.getLocation().subtract(0.94, 0, 0.2));
//                    }
//                    
//                    if (player.getLocation().getYaw() < -78.75 && player.getLocation().getYaw() >= -101.25) {
//                        en.get(i).teleport(player.getLocation().subtract(1, 0, 0));
//                    }
//                    
//                    if (player.getLocation().getYaw() < -101.25 && player.getLocation().getYaw() >= -112.5) {
//                        en.get(i).teleport(player.getLocation().subtract(0.94, 0, -0.2));
//                    }
//                    if (player.getLocation().getYaw() < -112.5 && player.getLocation().getYaw() >= -123.75) {
//                        en.get(i).teleport(player.getLocation().subtract(0.87, 0, -0.5));
//                    }
//                    
//                    if (player.getLocation().getYaw() < -123.75 && player.getLocation().getYaw() >= -146.25) {
//                        en.get(i).teleport(player.getLocation().subtract(0.8, 0, -0.8));
//                    }
//                    
//                    if (player.getLocation().getYaw() < -146.25 && player.getLocation().getYaw() >= -157.5) {
//                        en.get(i).teleport(player.getLocation().subtract(0.5, 0, -0.87));
//                    }
//                    if (player.getLocation().getYaw() < -157.5 && player.getLocation().getYaw() >= -168.75) {
//                        en.get(i).teleport(player.getLocation().subtract(0.2, 0, -0.94));
//                    }
//                    
//                    if (player.getLocation().getYaw() < -168.75 && player.getLocation().getYaw() >= -191.25) {
//                        en.get(i).teleport(player.getLocation().add(0, 0, 1));
//                    }
//                    
//                    if (player.getLocation().getYaw() < -191.25 && player.getLocation().getYaw() >= -202.5) {
//                        en.get(i).teleport(player.getLocation().add(0.2, 0, 0.94));
//                    }
//                    if (player.getLocation().getYaw() < -202.5 && player.getLocation().getYaw() >= -213.75) {
//                        en.get(i).teleport(player.getLocation().add(0.5, 0, 0.87));
//                    }
//                    
//                    if (player.getLocation().getYaw() < -213.75 && player.getLocation().getYaw() >= -236.25) {
//                        en.get(i).teleport(player.getLocation().add(0.8, 0, 0.8));
//                    }
//                    
//                    if (player.getLocation().getYaw() < -236.25 && player.getLocation().getYaw() >= -247.5) {
//                        en.get(i).teleport(player.getLocation().add(0.87, 0, 0.5));
//                    }
//                    if (player.getLocation().getYaw() < -247.5 && player.getLocation().getYaw() >= -258.75) {
//                        en.get(i).teleport(player.getLocation().add(0.92, 0, 0.2));
//                    }
//                    
//                    if (player.getLocation().getYaw() < -258.75 && player.getLocation().getYaw() >= -281.25) {
//                        en.get(i).teleport(player.getLocation().add(1, 0, 0));
//                    }
//                    
//                    if (player.getLocation().getYaw() < -281.25 && player.getLocation().getYaw() >= -292.5) {
//                        en.get(i).teleport(player.getLocation().add(0.92, 0, -0.2));
//                    }
//                    if (player.getLocation().getYaw() < -292.5 && player.getLocation().getYaw() >= -303.75) {
//                        en.get(i).teleport(player.getLocation().add(0.87, 0, -0.5));
//                    }
//                    
//                    if (player.getLocation().getYaw() < -303.75 && player.getLocation().getYaw() >= -326.25) {
//                        en.get(i).teleport(player.getLocation().add(0.8, 0, -0.8));
//                    }
//                    
//                    if (player.getLocation().getYaw() < -326.25 && player.getLocation().getYaw() >= -337.5) {
//                        en.get(i).teleport(player.getLocation().add(0.5, 0, -0.87));
//                    }
//                    if (player.getLocation().getYaw() < -337.5 && player.getLocation().getYaw() >= -348.75) {
//                        en.get(i).teleport(player.getLocation().add(0.2, 0, -0.92));
//                    }
//                    
//                    if (player.getLocation().getYaw() < -348.75 && player.getLocation().getYaw() >= -360) {
//                        en.get(i).teleport(player.getLocation().subtract(0, 0, 1));
//                    }
//                    
//
//                    
//                    //en.get(i).teleport(player.getLocation());
//                    
//                    player.setCollidable(false);
//                }
//            }
//
//        }
//
//    }
    
//    //Make mobs fly
//    @EventHandler
//    public void onPlayerFly(PlayerMoveEvent event) {
//        Player player = (Player) event.getPlayer();
//        
//        if (player.isFlying() == true) {
//            List<Entity> en = event.getPlayer().getNearbyEntities(20, 20, 20);
//            
//            for (int i = 0; i < en.size(); i++) {
//
//                if (((CraftEntity) en.get(i)).isCustomNameVisible()) {
//
//                    if (((CraftEntity) en.get(i)).getCustomName().contains(ChatColor.GOLD + ""  + ChatColor.BOLD) && 
//                            ((CraftEntity) en.get(i)).getCustomName().contains(player.getName()) &&
//                            ((CraftEntity) en.get(i)).getCustomName() != null) {
//                        en.get(i).setGravity(false);
//                    }
//                }
//            }
//        }
//    }
    
    @EventHandler
    public void onDisguiseDamage(EntityDamageEvent event) {
        if (event.getEntity().getCustomName() != null && event.getEntity().getCustomName().contains("'s Disguise") 
                && event.getEntity().getCustomName().contains(ChatColor.GOLD + "" + ChatColor.BOLD)) {
            
            if (event.getEntity() != null && event.getCause() == DamageCause.FIRE_TICK) {
                if(event.getEntity() instanceof Zombie) {
                    event.getEntity().setFireTicks(0);;
                }
            }
            event.setCancelled(true);
        }
    }
    

    
}
