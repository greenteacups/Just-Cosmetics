package cosmetics.particles.listeners;

import java.util.HashMap;

import org.bukkit.Particle;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import cosmetics.CosmeticGui;
import cosmetics.Cosmetics;
import cosmetics.PurchaseConstructor;
import cosmetics.PurchaseGui;
import cosmetics.particles.ParticlePatternGui;
import cosmetics.particles.ParticleTypeGui;
import cosmetics.particles.ParticleTypeGui2;

public class ParticleGuiListeners implements Listener {

    public CosmeticGui maingui = Cosmetics.maingui;
    public ParticleTypeGui particletypegui = Cosmetics.particletypegui;
    public ParticleTypeGui2 particletypegui2 = Cosmetics.particletypegui2;
    public ParticlePatternGui particlepatterngui = Cosmetics.particlepatterngui;
    
    public PurchaseGui purchasegui = Cosmetics.purchasegui;
    public PurchaseConstructor PurchaseConstructor = Cosmetics.PurchaseConstructor;
    public HashMap<Player, String> purchaseItem = Cosmetics.purchaseItem;
    public HashMap<Player, Integer> purchasePrice = Cosmetics.purchasePrice;

    private Cosmetics plugin;
    public ParticleGuiListeners(Cosmetics b) {
        plugin = b;
    }
    
    public static HashMap<Player, Particle> currentParticleType = new HashMap<>();
    public static HashMap<Player, String> currentParticlePattern = new HashMap<>();
    
    //Particle Type Equipper Gui
    public void ParticleEquip1(Player player, Particle particle, int price, String name) {
        if (plugin.dataCosmetics.exists(player.getUniqueId(), name)) {
            currentParticleType.put(player, particle);
            
            particlepatterngui.ExampleGui(player);
            plugin.getServer().getScheduler().runTask(plugin, () -> {
                player.openInventory(particlepatterngui.inv);
            });
        }
        else {
            purchaseItem.put(player, name); //Input Name
            purchasePrice.put(player, price); //Input Price
            PurchaseConstructor.purchaseGui(player, purchaseItem.get(player), purchasePrice.get(player));
        }
    }
    
    //Particle Pattern Equipper Gui
    public void PatternEquip(Player player, String pattern, int price, String name) {
        if (plugin.dataCosmetics.exists(player.getUniqueId(), name)) {
            currentParticlePattern.put(player, pattern);
        }
        else {
            purchaseItem.put(player, name); //Input Name
            purchasePrice.put(player, price); //Input Price
            PurchaseConstructor.purchaseGui(player, purchaseItem.get(player), purchasePrice.get(player));
        }
    }
    
    
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
            ParticleEquip1(player, Particle.COMPOSTER, 20, "Composter Particle");
        }
        
        if (event.getSlot() == 11) {
            ParticleEquip1(player, Particle.VILLAGER_ANGRY, 20, "Angry Villager Particle");
        }
        
        if (event.getSlot() == 12) {
            ParticleEquip1(player, Particle.ASH, 20, "Ash Particle");
        }
        
        if (event.getSlot() == 13) {
            ParticleEquip1(player, Particle.WATER_BUBBLE, 20, "Water Bubble Particle");
        }
        
        if (event.getSlot() == 14) {
            ParticleEquip1(player, Particle.BUBBLE_POP, 20, "Big Water Bubble Particle");
        }
        
        if (event.getSlot() == 15) {
            ParticleEquip1(player, Particle.SMOKE_NORMAL, 20, "Smoulder Particle");
        }
        
        if (event.getSlot() == 16) {
            ParticleEquip1(player, Particle.SMOKE_LARGE, 20, "Smoke Particle");
        }
        
        if (event.getSlot() == 19) {
            ParticleEquip1(player, Particle.CAMPFIRE_COSY_SMOKE, 20, "Campfire Smoke Particle");
        }
        
        if (event.getSlot() == 20) {
            ParticleEquip1(player, Particle.CLOUD, 20, "Cloud Particle");
        }
        
        if (event.getSlot() == 21) {
            ParticleEquip1(player, Particle.CRIMSON_SPORE, 20, "Crimson Spore Particle");
        }
        
        if (event.getSlot() == 22) {
            ParticleEquip1(player, Particle.WARPED_SPORE, 20, "Warped Spore Particle");
        }
        
        if (event.getSlot() == 23) {
            ParticleEquip1(player, Particle.CRIT, 20, "Critical Hit Particle");
        }
        
        if (event.getSlot() == 24) {
            ParticleEquip1(player, Particle.DAMAGE_INDICATOR, 20, "Damage Particle");
        }
        
        if (event.getSlot() == 25) {
            ParticleEquip1(player, Particle.DRAGON_BREATH, 20, "Dragon Breath Particle");
        }
        
        if (event.getSlot() == 28) {
            ParticleEquip1(player, Particle.FALLING_HONEY, 20, "Honey Drops Particle");
        }
        
        if (event.getSlot() == 29) {
            ParticleEquip1(player, Particle.DRIP_WATER, 20, "Water Drops Particle");
        }
        
        if (event.getSlot() == 30) {
            ParticleEquip1(player, Particle.DRIP_LAVA, 20, "Lava Drops Particle");
        }
        
        if (event.getSlot() == 31) {
            ParticleEquip1(player, Particle.FALLING_OBSIDIAN_TEAR, 20, "Obsidian Tears Particle");
        }
        
        if (event.getSlot() == 32) {
            ParticleEquip1(player, Particle.SPELL, 20, "White Spell Particle");
        }
        
        if (event.getSlot() == 33) {
            ParticleEquip1(player, Particle.SPELL_MOB, 20, "Black Spell Particle");
        }
        
        if (event.getSlot() == 34) {
            ParticleEquip1(player, Particle.SPELL_WITCH, 20, "Purple Spell Particle");
        }
        
        // Next Particle Type Gui
        if (event.getSlot() == 41) {
            particletypegui2.ExampleGui(player);
            plugin.getServer().getScheduler().runTask(plugin, () -> {
                player.openInventory(particletypegui2.inv);
            });
        }
        
        // Remove Particle Effect
        if (event.getSlot() == 40) {
            currentParticleType.remove(player);
            currentParticlePattern.remove(player);
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
            ParticleEquip1(player, Particle.ENCHANTMENT_TABLE, 20, "Enchant Glyph Particle");
        }
        
        if (event.getSlot() == 11) {
            ParticleEquip1(player, Particle.END_ROD, 20, "End Rod Particle");
        }
        
        if (event.getSlot() == 12) {
            ParticleEquip1(player, Particle.EXPLOSION_LARGE, 20, "Explosion Particle");
        }
        
        if (event.getSlot() == 13) {
            ParticleEquip1(player, Particle.SOUL_FIRE_FLAME, 20, "Soul Fire Particle");
        }
        
        if (event.getSlot() == 14) {
            ParticleEquip1(player, Particle.FALLING_NECTAR, 20, "Nectar Particle");
        }
        
        if (event.getSlot() == 15) {
            ParticleEquip1(player, Particle.WATER_WAKE, 20, "Water Wake Particle");
        }
        
        if (event.getSlot() == 16) {
            ParticleEquip1(player, Particle.HEART, 20, "Heart Particle");
        }
        
        if (event.getSlot() == 19) {
            ParticleEquip1(player, Particle.SLIME, 20, "Slime Particle");
        }
        
        if (event.getSlot() == 20) {
            ParticleEquip1(player, Particle.SNOWBALL, 20, "Snowball Particle");
        }
        
        if (event.getSlot() == 21) {
            ParticleEquip1(player, Particle.NAUTILUS, 20, "Nautilus Particle");
        }
        
        if (event.getSlot() == 22) {
            ParticleEquip1(player, Particle.NOTE, 20, "Music Note Particle");
        }
        
        if (event.getSlot() == 23) {
            ParticleEquip1(player, Particle.SNEEZE, 20, "Contagious Particle");
        }
        
        if (event.getSlot() == 24) {
            ParticleEquip1(player, Particle.SQUID_INK, 20, "Ink Particle");
        }
        
        if (event.getSlot() == 25) {
            ParticleEquip1(player, Particle.TOTEM, 20, "Totem Particle");
        }
        
        if (event.getSlot() == 28) {
            ParticleEquip1(player, Particle.LAVA, 20, "Lava Burst Particle");
        }
        
        
        // Return to cosmetic window
        if (event.getSlot() == 39) {
            particletypegui.ExampleGui(player);
            plugin.getServer().getScheduler().runTask(plugin, () -> {
                player.openInventory(particletypegui.inv);
            });
        }
        
        // Remove Particle Effect
        if (event.getSlot() == 40) {
            currentParticleType.remove(player);
            currentParticlePattern.remove(player);
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
            PatternEquip(player, "Dot", 20, "Dot Pattern"); 
        }
        
        if (event.getSlot() == 11) {
            PatternEquip(player, "Halo", 20, "Halo Pattern"); 
        }
        
        if (event.getSlot() == 12) {
            PatternEquip(player, "Rings", 20, "Rings Pattern"); 
        }
        
        if (event.getSlot() == 13) {
            PatternEquip(player, "Sphere", 20, "Sphere Pattern"); 
        }
        
        if (event.getSlot() == 14) {
            PatternEquip(player, "Prism", 20, "Prism Pattern"); 
        }
        
        if (event.getSlot() == 15) {
            PatternEquip(player, "Burst", 20, "Burst Pattern"); 
        }
        
        if (event.getSlot() == 16) {
            PatternEquip(player, "Smiley", 20, "Smiley Pattern"); 
        }
        
        if (event.getSlot() == 19) {
            PatternEquip(player, "Heart", 20, "Heart Pattern"); 
        }
        
        if (event.getSlot() == 20) {
            PatternEquip(player, "Swirl Helix", 20, "Swirl Helix Pattern"); 
        }
        
        if (event.getSlot() == 21) {
            PatternEquip(player, "Cube", 20, "Cube Pattern"); 
        }
        
        if (event.getSlot() == 22) {
            PatternEquip(player, "Chains", 20, "Chains Pattern"); 
        }
        
        if (event.getSlot() == 23) {
            PatternEquip(player, "Stars", 20, "Stars Pattern"); 
        }
        
        if (event.getSlot() == 24) {
            PatternEquip(player, "Double Helix", 20, "Double Helix Pattern"); 
        }
        
        if (event.getSlot() == 25) {
            PatternEquip(player, "QuadraHelix", 20, "QuadraHelix Pattern"); 
        }
        
        if (event.getSlot() == 28) {
            PatternEquip(player, "Egg", 20, "Egg Pattern"); 
        }
        
        if (event.getSlot() == 29) {
            PatternEquip(player, "Big Ring", 20, "Big Ring Pattern"); 
        }
        
        if (event.getSlot() == 30) {
            PatternEquip(player, "Normal", 20, "Normal Pattern"); 
        }
        
        if (event.getSlot() == 31) {
            PatternEquip(player, "Beams", 20, "Beams Pattern"); 
        }
        
        if (event.getSlot() == 32) {
            PatternEquip(player, "Cage", 20, "Cage Pattern");  
        }
        
//        if (event.getSlot() == 33) {
//            currentParticlePattern.put(player, "Test");
//        }
        
        // Return to Particle Types window
        if (event.getSlot() == 39) {
            particletypegui.ExampleGui(player);
            plugin.getServer().getScheduler().runTask(plugin, () -> {
                player.openInventory(particletypegui.inv);
            });
        }
        
        // Remove Particle Effect
        if (event.getSlot() == 40) {
            currentParticleType.remove(player);
            currentParticlePattern.remove(player);
        }
        
        
        player.closeInventory();
    }
    
    
}