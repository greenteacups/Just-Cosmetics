package cosmetics.particles.listeners;

import java.util.HashMap;

import org.bukkit.Particle;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import cosmetics.CosmeticGui;
import cosmetics.Cosmetics;
import cosmetics.particles.ParticlePatternGui;
import cosmetics.particles.ParticleTypeGui;
import cosmetics.particles.ParticleTypeGui2;

public class ParticleGuiListeners implements Listener {

    public CosmeticGui maingui = Cosmetics.maingui;
    public ParticleTypeGui particletypegui = Cosmetics.particletypegui;
    public ParticleTypeGui2 particletypegui2 = Cosmetics.particletypegui2;
    public ParticlePatternGui particlepatterngui = Cosmetics.particlepatterngui;
    private Cosmetics plugin;

    public ParticleGuiListeners(Cosmetics b) {
        plugin = b;
    }
    
    public static HashMap<Player, Particle> currentParticleType = new HashMap<>();
    public static HashMap<Player, String> currentParticlePattern = new HashMap<>();
    
    //////
    //Clicking Inside the Particle Type Gui
    @EventHandler()
    public void onTypeGuiClick(InventoryClickEvent event) {
        if (!event.getInventory().equals(particletypegui.inv))
            return;
        if (event.getCurrentItem() == null) return;
        if (event.getCurrentItem().getItemMeta() == null) return;
        if (event.getCurrentItem().getItemMeta().getDisplayName() == null) return;
        
        event.setCancelled(true);
        
        Player player = (Player) event.getWhoClicked();
        
        if (event.getSlot() == 10) {
            currentParticleType.put(player, Particle.COMPOSTER);
            
            plugin.getServer().getScheduler().runTask(plugin, () -> {
                player.openInventory(particlepatterngui.inv);
            });
        }
        
        if (event.getSlot() == 11) {
            currentParticleType.put(player, Particle.VILLAGER_ANGRY);
            
            plugin.getServer().getScheduler().runTask(plugin, () -> {
                player.openInventory(particlepatterngui.inv);
            });
        }
        
        if (event.getSlot() == 12) {
            currentParticleType.put(player, Particle.ASH);
            
            plugin.getServer().getScheduler().runTask(plugin, () -> {
                player.openInventory(particlepatterngui.inv);
            });
        }
        
        if (event.getSlot() == 13) {
            currentParticleType.put(player, Particle.WATER_BUBBLE);
            
            plugin.getServer().getScheduler().runTask(plugin, () -> {
                player.openInventory(particlepatterngui.inv);
            });
        }
        
        if (event.getSlot() == 14) {
            currentParticleType.put(player, Particle.BUBBLE_POP);
            
            plugin.getServer().getScheduler().runTask(plugin, () -> {
                player.openInventory(particlepatterngui.inv);
            });
        }
        
        if (event.getSlot() == 15) {
            currentParticleType.put(player, Particle.SMOKE_NORMAL);
            
            plugin.getServer().getScheduler().runTask(plugin, () -> {
                player.openInventory(particlepatterngui.inv);
            });
        }
        
        if (event.getSlot() == 16) {
            currentParticleType.put(player, Particle.SMOKE_LARGE);
            
            plugin.getServer().getScheduler().runTask(plugin, () -> {
                player.openInventory(particlepatterngui.inv);
            });
        }
        
        if (event.getSlot() == 19) {
            currentParticleType.put(player, Particle.CAMPFIRE_COSY_SMOKE);
            
            plugin.getServer().getScheduler().runTask(plugin, () -> {
                player.openInventory(particlepatterngui.inv);
            });
        }
        
        if (event.getSlot() == 20) {
            currentParticleType.put(player, Particle.CLOUD);
            
            plugin.getServer().getScheduler().runTask(plugin, () -> {
                player.openInventory(particlepatterngui.inv);
            });
        }
        
        if (event.getSlot() == 21) {
            currentParticleType.put(player, Particle.CRIMSON_SPORE);
            
            plugin.getServer().getScheduler().runTask(plugin, () -> {
                player.openInventory(particlepatterngui.inv);
            });
        }
        
        if (event.getSlot() == 22) {
            currentParticleType.put(player, Particle.WARPED_SPORE);
            
            plugin.getServer().getScheduler().runTask(plugin, () -> {
                player.openInventory(particlepatterngui.inv);
            });
        }
        
        if (event.getSlot() == 23) {
            currentParticleType.put(player, Particle.CRIT);
            
            plugin.getServer().getScheduler().runTask(plugin, () -> {
                player.openInventory(particlepatterngui.inv);
            });
        }
        
        if (event.getSlot() == 24) {
            currentParticleType.put(player, Particle.DAMAGE_INDICATOR);
            
            plugin.getServer().getScheduler().runTask(plugin, () -> {
                player.openInventory(particlepatterngui.inv);
            });
        }
        
        if (event.getSlot() == 25) {
            currentParticleType.put(player, Particle.DRAGON_BREATH);
            
            plugin.getServer().getScheduler().runTask(plugin, () -> {
                player.openInventory(particlepatterngui.inv);
            });
        }
        
        if (event.getSlot() == 28) {
            currentParticleType.put(player, Particle.FALLING_HONEY);
            
            plugin.getServer().getScheduler().runTask(plugin, () -> {
                player.openInventory(particlepatterngui.inv);
            });
        }
        
        if (event.getSlot() == 29) {
            currentParticleType.put(player, Particle.DRIP_WATER);
            
            plugin.getServer().getScheduler().runTask(plugin, () -> {
                player.openInventory(particlepatterngui.inv);
            });
        }
        
        if (event.getSlot() == 30) {
            currentParticleType.put(player, Particle.DRIP_LAVA);
            
            plugin.getServer().getScheduler().runTask(plugin, () -> {
                player.openInventory(particlepatterngui.inv);
            });
        }
        
        if (event.getSlot() == 31) {
            currentParticleType.put(player, Particle.FALLING_OBSIDIAN_TEAR);
            
            plugin.getServer().getScheduler().runTask(plugin, () -> {
                player.openInventory(particlepatterngui.inv);
            });
        }
        
        if (event.getSlot() == 32) {
            currentParticleType.put(player, Particle.SPELL);
            
            plugin.getServer().getScheduler().runTask(plugin, () -> {
                player.openInventory(particlepatterngui.inv);
            });
        }
        
        if (event.getSlot() == 33) {
            currentParticleType.put(player, Particle.SPELL_MOB);
            
            plugin.getServer().getScheduler().runTask(plugin, () -> {
                player.openInventory(particlepatterngui.inv);
            });
        }
        
        if (event.getSlot() == 34) {
            currentParticleType.put(player, Particle.SPELL_WITCH);
            
            plugin.getServer().getScheduler().runTask(plugin, () -> {
                player.openInventory(particlepatterngui.inv);
            });
        }
        
        // Next Particle Type Gui
        if (event.getSlot() == 41) {
            plugin.getServer().getScheduler().runTask(plugin, () -> {
                player.openInventory(particletypegui2.inv);
            });
        }
        
        // Return to cosmetic window
        if (event.getSlot() == 39) {
            plugin.getServer().getScheduler().runTask(plugin, () -> {
                player.openInventory(maingui.inv);
            });
        }
        
        
        player.closeInventory();
    }
    
    //////
    //Clicking Inside the Particle Type Gui 2
    @EventHandler()
    public void onTypeGui2Click(InventoryClickEvent event) {
        if (!event.getInventory().equals(particletypegui2.inv))
            return;
        if (event.getCurrentItem() == null) return;
        if (event.getCurrentItem().getItemMeta() == null) return;
        if (event.getCurrentItem().getItemMeta().getDisplayName() == null) return;
        
        event.setCancelled(true);
        
        Player player = (Player) event.getWhoClicked();
        
        if (event.getSlot() == 10) {
            currentParticleType.put(player, Particle.ENCHANTMENT_TABLE);
            
            plugin.getServer().getScheduler().runTask(plugin, () -> {
                player.openInventory(particlepatterngui.inv);
            });
        }
        
        if (event.getSlot() == 11) {
            currentParticleType.put(player, Particle.END_ROD);
            
            plugin.getServer().getScheduler().runTask(plugin, () -> {
                player.openInventory(particlepatterngui.inv);
            });
        }
        
        if (event.getSlot() == 12) {
            currentParticleType.put(player, Particle.EXPLOSION_LARGE);
            
            plugin.getServer().getScheduler().runTask(plugin, () -> {
                player.openInventory(particlepatterngui.inv);
            });
        }
        
        if (event.getSlot() == 13) {
            currentParticleType.put(player, Particle.SOUL_FIRE_FLAME);
            
            plugin.getServer().getScheduler().runTask(plugin, () -> {
                player.openInventory(particlepatterngui.inv);
            });
        }
        
        if (event.getSlot() == 14) {
            currentParticleType.put(player, Particle.FALLING_NECTAR);
            
            plugin.getServer().getScheduler().runTask(plugin, () -> {
                player.openInventory(particlepatterngui.inv);
            });
        }
        
        if (event.getSlot() == 15) {
            currentParticleType.put(player, Particle.WATER_WAKE);
            
            plugin.getServer().getScheduler().runTask(plugin, () -> {
                player.openInventory(particlepatterngui.inv);
            });
        }
        
        if (event.getSlot() == 16) {
            currentParticleType.put(player, Particle.HEART);
            
            plugin.getServer().getScheduler().runTask(plugin, () -> {
                player.openInventory(particlepatterngui.inv);
            });
        }
        
        if (event.getSlot() == 19) {
            currentParticleType.put(player, Particle.SLIME);
            
            plugin.getServer().getScheduler().runTask(plugin, () -> {
                player.openInventory(particlepatterngui.inv);
            });
        }
        
        if (event.getSlot() == 20) {
            currentParticleType.put(player, Particle.SNOWBALL);
            
            plugin.getServer().getScheduler().runTask(plugin, () -> {
                player.openInventory(particlepatterngui.inv);
            });
        }
        
        if (event.getSlot() == 21) {
            currentParticleType.put(player, Particle.NAUTILUS);
            
            plugin.getServer().getScheduler().runTask(plugin, () -> {
                player.openInventory(particlepatterngui.inv);
            });
        }
        
        if (event.getSlot() == 22) {
            currentParticleType.put(player, Particle.NOTE);
            
            plugin.getServer().getScheduler().runTask(plugin, () -> {
                player.openInventory(particlepatterngui.inv);
            });
        }
        
        if (event.getSlot() == 23) {
            currentParticleType.put(player, Particle.SNEEZE);
            
            plugin.getServer().getScheduler().runTask(plugin, () -> {
                player.openInventory(particlepatterngui.inv);
            });
        }
        
        if (event.getSlot() == 24) {
            currentParticleType.put(player, Particle.SQUID_INK);
            
            plugin.getServer().getScheduler().runTask(plugin, () -> {
                player.openInventory(particlepatterngui.inv);
            });
        }
        
        if (event.getSlot() == 25) {
            currentParticleType.put(player, Particle.TOTEM);
            
            plugin.getServer().getScheduler().runTask(plugin, () -> {
                player.openInventory(particlepatterngui.inv);
            });
        }
        
        if (event.getSlot() == 28) {
            currentParticleType.put(player, Particle.LAVA);
            
            plugin.getServer().getScheduler().runTask(plugin, () -> {
                player.openInventory(particlepatterngui.inv);
            });
        }
        
        
        // Return to cosmetic window
        if (event.getSlot() == 39) {
            plugin.getServer().getScheduler().runTask(plugin, () -> {
                player.openInventory(particletypegui.inv);
            });
        }
        
        
        player.closeInventory();
    }
    
    //////
    //Clicking Inside the Particle Pattern Gui
    @EventHandler()
    public void onPatternGuiClick(InventoryClickEvent event) {
        if (!event.getInventory().equals(particlepatterngui.inv))
            return;
        if (event.getCurrentItem() == null) return;
        if (event.getCurrentItem().getItemMeta() == null) return;
        if (event.getCurrentItem().getItemMeta().getDisplayName() == null) return;
        
        event.setCancelled(true);
        
        Player player = (Player) event.getWhoClicked();
        
        if (event.getSlot() == 10) {
            currentParticlePattern.put(player, "Dot");
        }
        
        if (event.getSlot() == 11) {
            currentParticlePattern.put(player, "Halo");
        }
        
        if (event.getSlot() == 12) {
            currentParticlePattern.put(player, "Rings");
        }
        
        if (event.getSlot() == 13) {
            currentParticlePattern.put(player, "Sphere");
        }
        
        if (event.getSlot() == 14) {
            currentParticlePattern.put(player, "Prism");
        }
        
        if (event.getSlot() == 15) {
            currentParticlePattern.put(player, "Burst");
        }
        
        if (event.getSlot() == 16) {
            currentParticlePattern.put(player, "Smiley");
        }
        
        if (event.getSlot() == 19) {
            currentParticlePattern.put(player, "Heart");
        }
        
        if (event.getSlot() == 20) {
            currentParticlePattern.put(player, "Swirl Helix");
        }
        
        if (event.getSlot() == 21) {
            currentParticlePattern.put(player, "Cube");
        }
        
        if (event.getSlot() == 22) {
            currentParticlePattern.put(player, "Chains");
        }
        
        if (event.getSlot() == 23) {
            currentParticlePattern.put(player, "Stars");
        }
        
        if (event.getSlot() == 24) {
            currentParticlePattern.put(player, "Double Helix");
        }
        
        if (event.getSlot() == 25) {
            currentParticlePattern.put(player, "QuadraHelix");
        }
        
        if (event.getSlot() == 28) {
            currentParticlePattern.put(player, "Egg");
        }
        
        if (event.getSlot() == 29) {
            currentParticlePattern.put(player, "Big Ring");
        }
        
        if (event.getSlot() == 30) {
            currentParticlePattern.put(player, "Normal");
        }
        
        if (event.getSlot() == 31) {
            currentParticlePattern.put(player, "Beams");
        }
        
        if (event.getSlot() == 32) {
            currentParticlePattern.put(player, "Cage");
        }
        
        if (event.getSlot() == 33) {
            currentParticlePattern.put(player, "Test");
        }
        
        // Return to cosmetic window
        if (event.getSlot() == 39) {
            plugin.getServer().getScheduler().runTask(plugin, () -> {
                player.openInventory(particletypegui.inv);
            });
        }
        
        
        player.closeInventory();
    }
    
    
}