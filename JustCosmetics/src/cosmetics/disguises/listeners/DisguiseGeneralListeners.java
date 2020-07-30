package cosmetics.disguises.listeners;

import java.util.HashMap;

import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Skeleton;
import org.bukkit.entity.Slime;
import org.bukkit.entity.Stray;
import org.bukkit.entity.Zombie;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.potion.PotionEffectType;

import cosmetics.Cosmetics;
import cosmetics.RemoveEffects;
import cosmetics.disguises.DisguiseGui;
import cosmetics.disguises.DisguiseGui2;


public class DisguiseGeneralListeners implements Listener {
    
    private Cosmetics plugin;
    public DisguiseGeneralListeners(Cosmetics b) {
        plugin = b;
    }

    public HashMap<Player, Entity> currentDisguise = DisguiseGuiListeners.currentDisguise;
    
    public static RemoveEffects RemoveEffects = new RemoveEffects();
    
    @EventHandler
    public void onMovetest(PlayerMoveEvent event) {
        Player player = (Player) event.getPlayer();
        
        if (currentDisguise.containsKey(player)) {
            
            currentDisguise.get(player).getLocation().setYaw(player.getLocation().getYaw());
            currentDisguise.get(player).getLocation().setPitch(player.getLocation().getPitch());
            
            if (currentDisguise.get(player) instanceof Slime) {
                // Put the pet behind the player
                currentDisguise.get(player).teleport(player.getLocation()
                        .add(2*Math.sin(Math.toRadians(player.getLocation().getYaw())),
                                0, -2*Math.cos(Math.toRadians(player.getLocation().getYaw()))));
            }
            else {
                // Put the pet behind the player
                currentDisguise.get(player).teleport(player.getLocation()
                        .add(Math.sin(Math.toRadians(player.getLocation().getYaw())),
                                0, -Math.cos(Math.toRadians(player.getLocation().getYaw()))));
            }

        } 
    }
    
    //Stop disguises burning
    @EventHandler
    public void onDisguiseDamage(EntityDamageEvent event) {
        if (currentDisguise.containsValue(event.getEntity())) {
            
            if (event.getEntity() != null && event.getCause() == DamageCause.FIRE_TICK) {
                if(event.getEntity() instanceof Zombie) {
                    event.getEntity().setFireTicks(0);;
                }
                if(event.getEntity() instanceof Skeleton) {
                    event.getEntity().setFireTicks(0);;
                }
                if(event.getEntity() instanceof Stray) {
                    event.getEntity().setFireTicks(0);;
                }
            }
            
            event.setCancelled(true);
        }
    }
    
    //Stop naming and colour disguises
    @EventHandler
    public void onMobInteract(PlayerInteractEntityEvent event) {
        if (currentDisguise.containsValue(event.getRightClicked())) {
            event.setCancelled(true);
        }
    }
    
    //Player death remove Everything
    @EventHandler
    public void onDeathEvent(PlayerDeathEvent event) {
        if (currentDisguise.containsKey(event.getEntity())) {
            RemoveEffects.ClearEffects(event.getEntity());
        }
    }
    
    //Player PvP remove Disguise
    @EventHandler
    public void onPvp(EntityDamageByEntityEvent event) {
        if (event.getDamager() instanceof Player && event.getEntity() instanceof Player) {
            
            Player player1 = (Player) event.getDamager();
            Player player2 = (Player) event.getEntity();
                        
            if (currentDisguise.containsKey(player1)) {
                player1.removePotionEffect(PotionEffectType.INVISIBILITY);
                currentDisguise.get(player1).remove();
                currentDisguise.remove(player1);
            }
            
            if (currentDisguise.containsKey(player2)) {
                player2.removePotionEffect(PotionEffectType.INVISIBILITY);
                currentDisguise.get(player2).remove();
                currentDisguise.remove(player2);
            }
            
        }
    }
    
    //Player Drink Milk remove Disguise
    @EventHandler
    public void DrinkMilk(PlayerItemConsumeEvent event) {
        if (event.getItem().getType().equals(Material.MILK_BUCKET)) {
            Player player = (Player) event.getPlayer();
            
            if (currentDisguise.containsKey(player)) {
                player.removePotionEffect(PotionEffectType.INVISIBILITY);
                currentDisguise.get(player).remove();
                currentDisguise.remove(player);
            }
        }
    }
    
    
    // Stop dragging of items out of disguise guis
    @EventHandler
    public void InvClick(InventoryClickEvent event) {
        if(event.getRawSlot() <= 53 && event.getInventory().getHolder() instanceof DisguiseGui) {
            plugin.getServer().getScheduler().runTask(plugin, () -> {
                event.getWhoClicked().getInventory().remove(event.getCurrentItem());
            });
            if (event.getClick().equals(ClickType.UNKNOWN)) {
                plugin.getServer().getScheduler().runTask(plugin, () -> {
                    event.getWhoClicked().getInventory().setItemInOffHand(null);
                });
            }
        }
        if(event.getRawSlot() <= 53 && event.getInventory().getHolder() instanceof DisguiseGui2) {
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
    
    @EventHandler
    public void onQuit(PlayerQuitEvent event) {
        Player player = event.getPlayer();
        RemoveEffects.ClearEffects(player);
    }
    

    
}
