package cosmetics.pets.listeners;

import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Snowman;
import org.bukkit.entity.Zombie;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.EntityBlockFormEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerMoveEvent;

import cosmetics.Cosmetics;
import cosmetics.pets.BabySheepColourGUI;
import cosmetics.pets.PetGui;
import cosmetics.pets.PetGui2;
import cosmetics.pets.SheepColourGUI;

public class PetGeneralListeners implements Listener {
    
    public PetGui petgui = Cosmetics.petgui;
    public PetGui2 petgui2 = Cosmetics.petgui2;
    public SheepColourGUI colorgui = Cosmetics.colourgui;
    public BabySheepColourGUI babycolorgui = Cosmetics.babycolourgui;
    private Cosmetics plugin;
    
    public PetGeneralListeners(Cosmetics b) {
        plugin = b;
    }
    
    // Set Pets invunerable bc setinvun on spawn no work?
    @EventHandler
    public void onDamage(EntityDamageEvent event) {
        if (event.getEntity().getCustomName().contains("'s Pet") 
                && event.getEntity().getCustomName().contains(ChatColor.GOLD + "" + ChatColor.BOLD)) {
            
            if (event.getCause() == DamageCause.FIRE_TICK) {
                if(event.getEntity() instanceof Zombie) {
                    event.getEntity().setFireTicks(0);;
                }
            }
            event.setCancelled(true);
        }
    }
    
    // Add particle to mobs
    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event) {
        Player player = (Player) event.getPlayer();
        List<Entity> en = player.getNearbyEntities(30, 30, 30);
        for (int i = 0; i < en.size(); i++) {
            if (en.get(i).getCustomName() != null 
                    && en.get(i).getCustomName().contains(player.getName() + "'s Pet")) {
                player.getLocation().getWorld().spawnParticle(Particle.COMPOSTER,
                        en.get(i).getLocation().getX(), en.get(i).getLocation().add(0, 2, 0).getY(),
                        en.get(i).getLocation().getZ(), 0);
            }
        }
    }
    
    
    // Right click on mob to make them delete
    @EventHandler
    public void onClick(PlayerInteractEntityEvent event) {
        if (event.getRightClicked().getCustomName() == null)
            return;
        if (event.getRightClicked().getCustomName().contains(event.getPlayer().getName() + "'s Pet")) {
            event.getPlayer().getWorld().spawnParticle(Particle.EXPLOSION_HUGE,
                    event.getPlayer().getLocation().getX(), event.getPlayer().getLocation().getY(),
                    event.getPlayer().getLocation().getZ(), 0);
            event.getPlayer().getWorld().playSound(event.getPlayer().getLocation(), Sound.ENTITY_DRAGON_FIREBALL_EXPLODE,
                    3.0F, 0.533F);
            event.getRightClicked().remove();
        }
    }
    
    // Stop Snowman forming snow
    @EventHandler
    public void removeSnow(EntityBlockFormEvent event) {
    
        if(event.getEntity() instanceof Snowman) {
            event.setCancelled(true);
        }
    }
    
    // Stop Removal of items
    @EventHandler
    public void InvClick(InventoryClickEvent event) {
        if(event.getInventory() == petgui.inv) {
            plugin.getServer().getScheduler().runTask(plugin, () -> {
                event.getWhoClicked().getInventory().remove(event.getCurrentItem());
            });
        }
        if(event.getInventory() == petgui2.inv) {
            plugin.getServer().getScheduler().runTask(plugin, () -> {
                event.getWhoClicked().getInventory().remove(event.getCurrentItem());
            });
        }
        if(event.getInventory() == colorgui.inv) {
            plugin.getServer().getScheduler().runTask(plugin, () -> {
                event.getWhoClicked().getInventory().remove(event.getCurrentItem());
            });
        }
        if(event.getInventory() == babycolorgui.inv) {
            plugin.getServer().getScheduler().runTask(plugin, () -> {
                event.getWhoClicked().getInventory().remove(event.getCurrentItem());
            });
            
        }
    }
    
    
}
