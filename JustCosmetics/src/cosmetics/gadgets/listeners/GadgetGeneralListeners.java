package cosmetics.gadgets.listeners;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.craftbukkit.v1_16_R1.CraftWorld;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import cosmetics.Cosmetics;
import cosmetics.RemoveEffects;
import cosmetics.gadgets.GadgetRunnables;
import cosmetics.gadgets.items.TurtleSpawn;
import net.minecraft.server.v1_16_R1.WorldServer;

public class GadgetGeneralListeners implements Listener {
    
    private Cosmetics plugin;

    public GadgetGeneralListeners(Cosmetics b) {
        plugin = b;
    }
    
    public static RemoveEffects RemoveEffects = new RemoveEffects();
    
    public HashMap<Player, List<Entity>> shellMap = GadgetGuiListeners.shellMap;
    public HashMap<Player, List<Entity>> parrotMap = GadgetGuiListeners.parrotMap;
    
    public static List<Entity> shotshell = new ArrayList<>();
    
    public static HashMap<Player, Long> airstrike = new HashMap<>();
    public static HashMap<Player, Entity> airturtlelist = GadgetRunnables.airturtlelist;
    public List<Entity> tntList = GadgetRunnables.tntList;

    @EventHandler
    public void onClick(PlayerInteractEvent event) {
        
        Player player = (Player) event.getPlayer();
        
        // Jump Stick
        if (player.getInventory().getItemInMainHand().getType() != Material.AIR) {
            if (player.getInventory().getItemInMainHand().getItemMeta().getDisplayName().contains("Jump Stick")) {
                if (player.getInventory().getItemInMainHand().getItemMeta().hasLore()) {
                    if (player.getLocation().subtract(0, 1, 0).getBlock().getType() != Material.AIR) {
                        player.setVelocity(player.getLocation().getDirection().multiply(2).setY(2));
                        
                        event.getPlayer().getWorld().spawnParticle(Particle.EXPLOSION_HUGE,
                                event.getPlayer().getLocation().getX(), event.getPlayer().getLocation().getY(),
                                event.getPlayer().getLocation().getZ(), 0);
                        event.getPlayer().getWorld().playSound(event.getPlayer().getLocation(), Sound.ENTITY_DRAGON_FIREBALL_EXPLODE,
                                3.0F, 0.533F);
                    }
                }

            }   
        }
        
        
        // Green shell gun
        if (player.getInventory().getItemInMainHand().getType() != Material.AIR 
                && player.getInventory().getItemInMainHand().getItemMeta().getDisplayName().contains("Green Shell Gun")) {
            if (player.getInventory().getItemInMainHand().getItemMeta().hasLore()) {
                
                if (shotshell.isEmpty() == false) {
                    shotshell.get(0).remove();
                    
                    shotshell.get(0).getWorld().spawnParticle(Particle.EXPLOSION_HUGE,
                            shotshell.get(0).getLocation().getX(), shotshell.get(0).getLocation().getY(),
                            shotshell.get(0).getLocation().getZ(), 0);
                    
                    shotshell.clear();
                }
                
                WorldServer world = ((CraftWorld) player.getWorld()).getHandle();
                TurtleSpawn shootshell = new TurtleSpawn(player.getLocation().add(0, 0, -2), player);
                world.addEntity(shootshell);
                
                shootshell.setNoAI(false);
                shootshell.setHealth(1);
                shootshell.getBukkitEntity().setVelocity(player.getLocation().getDirection().multiply(4));
                
                shotshell.add(shootshell.getBukkitEntity());
                
                plugin.getServer().getScheduler().runTaskLater(plugin, () -> {
                    if (shotshell.size() > 0) {
                        shotshell.get(0).remove();
                      
                        shotshell.get(0).getWorld().spawnParticle(Particle.EXPLOSION_HUGE,
                              shotshell.get(0).getLocation().getX(), shotshell.get(0).getLocation().getY(),
                              shotshell.get(0).getLocation().getZ(), 0);
                      
                        shotshell.clear();
                    }
                }, 30);
            }
        }
        
        // Air Strike
        if (player.getInventory().getItemInMainHand().getType() != Material.AIR) {
            if (player.getInventory().getItemInMainHand().getItemMeta().getDisplayName().contains("Air Strike")) {
                if (player.getInventory().getItemInMainHand().getItemMeta().hasLore()) {

                    if (airstrike.containsKey(player)) {
                        player.sendMessage(ChatColor.DARK_RED + "You have already ordered an AirStrike");
                    }
                    else {
                        airstrike.put(player, System.currentTimeMillis()/50);
                    }
                    
                }

            }   
        }
    }
    
    @EventHandler
    public void onGadgetDamage(EntityDamageEvent event) {
        if (event.getCause() != null) {
            for (List<Entity> list : shellMap.values()) {

                if (list.contains(event.getEntity())) {
                    event.setCancelled(true);  
                }
            }
            
            for (List<Entity> list : parrotMap.values()) {

                if (list.contains(event.getEntity())) {
                    event.setCancelled(true);
                }
            }
        }  
    }
    
    @EventHandler
    public void airstrikeTntExplode(EntityExplodeEvent event) {
        if (event.getEntity() != null) {
            if (tntList.contains(event.getEntity())) {
                event.getEntity().getWorld().spawnParticle(Particle.EXPLOSION_HUGE,
                        event.getEntity().getLocation().getX(), event.getEntity().getLocation().getY(),
                        event.getEntity().getLocation().getZ(), 0);
                
                event.setCancelled(true);
                
                tntList.remove(event.getEntity());
            }
        }
    }
        
    
    @EventHandler
    public void onQuit(PlayerQuitEvent event) {
        Player player = event.getPlayer();
        RemoveEffects.ClearEffects(player);
    }
    

}
