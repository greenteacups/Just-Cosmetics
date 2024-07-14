package cosmetics.particles.listeners;

import java.util.HashMap;

import cosmetics.ParticleType;
import org.bukkit.ChatColor;
import org.bukkit.Particle;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import cosmetics.CosmeticGui;
import cosmetics.Cosmetics;
import cosmetics.PurchaseConstructor;
import cosmetics.particles.ParticlePatternGui;
import cosmetics.particles.ParticleTypeGui;
import cosmetics.particles.ParticleTypeGui2;

public class ParticleGuiListeners implements Listener {
    
    public PurchaseConstructor PurchaseConstructor = Cosmetics.PurchaseConstructor;
    public HashMap<Player, String> purchaseItem = Cosmetics.purchaseItem;
    public HashMap<Player, Integer> purchasePrice = Cosmetics.purchasePrice;

    private final Cosmetics plugin;
    public ParticleGuiListeners(Cosmetics b) {
        this.plugin = b;
    }
    
    public static HashMap<Player, Particle> currentParticleType = new HashMap<>();
    public static HashMap<Player, String> currentParticlePattern = new HashMap<>();
    
    //Particle Type Equipper Gui
    public void ParticleEquip1(Player player, Particle particle, int price, String name) {
        if (plugin.dataCosmetics.exists(player.getUniqueId(), name)) {
            currentParticleType.put(player, particle);
            
            plugin.runTask(player, () -> player.openInventory(new ParticlePatternGui(plugin, player).getInventory()));
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
        if (!(event.getInventory().getHolder() instanceof ParticleTypeGui))
            return;
        if (event.getCurrentItem() == null) return;
        if (event.getCurrentItem().getItemMeta() == null) return;
        if (event.getRawSlot() > 53) return;
        
        event.setCancelled(true);
        
        Player player = (Player) event.getWhoClicked();

        for (int i = 0; i < 21; i ++) {
            int particleIndex = i;
            if (particleIndex >= ParticleType.values().length) continue;

            int slot = 10 + (i % 7) + (i / 7) * 9;
            ParticleType particleType = ParticleType.values()[particleIndex];

            if (event.getSlot() == slot) {
                if (particleType.particle() == null) {
                    player.sendMessage(ChatColor.RED + particleType.title() + " is not available on this server!");
                    break;
                }

                ParticleEquip1(player, particleType.particle(), particleType.price(), particleType.title());
            }
        }
        
        // Auto equip Normal
        if (event.getSlot() <= 34 && currentParticleType.get(player) != null && currentParticlePattern.get(player) == null) {
            currentParticlePattern.put(player, "Normal");
        }
        
        // Save player to SQL
        if (event.getSlot() <= 34 && currentParticleType.get(player) != null && currentParticlePattern.get(player) != null) {
            if (plugin.dataParticles.existsPlayer(player.getUniqueId())) {
                plugin.dataParticles.remove(player.getUniqueId());
            }
            plugin.dataParticles.addParticle(player, player.getUniqueId(),
                    currentParticleType.get(player).toString(), currentParticlePattern.get(player));
        }
        
        // Next Particle Type Gui
        if (event.getSlot() == 41) {
            plugin.runTask(player, () -> player.openInventory(new ParticleTypeGui2(plugin, player).getInventory()));
        }
        
        // Remove Particle Effect
        if (event.getSlot() == 40) {
            currentParticleType.remove(player);
            currentParticlePattern.remove(player);
            if (plugin.dataParticles.existsPlayer(player.getUniqueId())) {
                plugin.dataParticles.remove(player.getUniqueId());
            }
        }
        
        // Return to cosmetic window
        if (event.getSlot() == 39) {
            plugin.runTask(player, () -> player.openInventory(new CosmeticGui(plugin, player).getInventory()));
        }
        
        
        player.closeInventory();
    }
    
    //////
    //Clicking Inside the Particle Type Gui 2
    @EventHandler()
    public void onTypeGui2Click(InventoryClickEvent event) {
        if (!(event.getInventory().getHolder() instanceof ParticleTypeGui2))
            return;
        if (event.getCurrentItem() == null) return;
        if (event.getCurrentItem().getItemMeta() == null) return;
        if (event.getRawSlot() > 53) return;
        
        event.setCancelled(true);
        
        Player player = (Player) event.getWhoClicked();

        for (int i = 0; i < 21; i ++) {
            int particleIndex = i + 21;
            if (particleIndex >= ParticleType.values().length) continue;

            int slot = 10 + (i % 7) + (i / 7) * 9;
            ParticleType particleType = ParticleType.values()[particleIndex];

            if (event.getSlot() == slot) {
                if (particleType.particle() == null) {
                    player.sendMessage(ChatColor.RED + particleType.title() + " is not available on this server!");
                    break;
                }

                ParticleEquip1(player, particleType.particle(), particleType.price(), particleType.title());
                break;
            }
        }
        
        // Auto equip Normal
        if (event.getSlot() <= 34 && currentParticleType.get(player) != null && currentParticlePattern.get(player) == null) {
            currentParticlePattern.put(player, "Normal");
        }
        
        // Save player to SQL
        if (event.getSlot() <= 34 && currentParticleType.get(player) != null && currentParticlePattern.get(player) != null) {
            if (plugin.dataParticles.existsPlayer(player.getUniqueId())) {
                plugin.dataParticles.remove(player.getUniqueId());
            }
            plugin.dataParticles.addParticle(player, player.getUniqueId(),
                    currentParticleType.get(player).toString(), currentParticlePattern.get(player));
        }
        
        // Return to cosmetic window
        if (event.getSlot() == 39) {
            plugin.runTask(player, () -> player.openInventory(new ParticleTypeGui(plugin, player).getInventory()));
        }
        
        // Remove Particle Effect
        if (event.getSlot() == 40) {
            currentParticleType.remove(player);
            currentParticlePattern.remove(player);
            if (plugin.dataParticles.existsPlayer(player.getUniqueId())) {
                plugin.dataParticles.remove(player.getUniqueId());
            }
        }
        
        
        player.closeInventory();
    }
    
    //////
    //Clicking Inside the Particle Pattern Gui
    @EventHandler()
    public void onPatternGuiClick(InventoryClickEvent event) {
        if (!(event.getInventory().getHolder() instanceof ParticlePatternGui))
            return;
        if (event.getCurrentItem() == null) return;
        if (event.getCurrentItem().getItemMeta() == null) return;
        if (event.getRawSlot() > 53) return;
        
        event.setCancelled(true);
        
        Player player = (Player) event.getWhoClicked();
        
        if (event.getSlot() == 10) {
            currentParticlePattern.put(player, "Normal");
        }
        
        if (event.getSlot() == 11) {
            PatternEquip(player, "Dot", 30, "Dot Pattern"); 
        }
        
        if (event.getSlot() == 12) {
            PatternEquip(player, "Halo", 30, "Halo Pattern"); 
        }
        
        if (event.getSlot() == 13) {
            PatternEquip(player, "Rings", 30, "Rings Pattern"); 
        }
        
        if (event.getSlot() == 14) {
            PatternEquip(player, "Sphere", 30, "Sphere Pattern"); 
        }
        
        if (event.getSlot() == 15) {
            PatternEquip(player, "Prism", 30, "Prism Pattern"); 
        }
        
        if (event.getSlot() == 16) {
            PatternEquip(player, "Smiley", 30, "Smiley Pattern"); 
        }
        
        if (event.getSlot() == 19) {
            PatternEquip(player, "Heart", 30, "Heart Pattern"); 
        }
        
        if (event.getSlot() == 20) {
            PatternEquip(player, "Swirl Helix", 30, "Swirl Helix Pattern"); 
        }
        
        if (event.getSlot() == 21) {
            PatternEquip(player, "Cube", 30, "Cube Pattern"); 
        }
        
        if (event.getSlot() == 22) {
            PatternEquip(player, "Chains", 30, "Chains Pattern"); 
        }
        
        if (event.getSlot() == 23) {
            PatternEquip(player, "Stars", 30, "Stars Pattern"); 
        }
        
        if (event.getSlot() == 24) {
            PatternEquip(player, "Double Helix", 30, "Double Helix Pattern"); 
        }
        
        if (event.getSlot() == 25) {
            PatternEquip(player, "QuadraHelix", 30, "QuadraHelix Pattern"); 
        }
        
        if (event.getSlot() == 28) {
            PatternEquip(player, "Wings", 30, "Wings Pattern");  
        }
        
        if (event.getSlot() == 29) {
            PatternEquip(player, "Lotus", 30, "Lotus Pattern"); 
        }
        
        if (event.getSlot() == 30) {
            PatternEquip(player, "Burst", 30, "Burst Pattern"); 
        }
        
        if (event.getSlot() == 31) {
            PatternEquip(player, "Beams", 30, "Beams Pattern"); 
        }
        
        if (event.getSlot() == 32) {
            PatternEquip(player, "Cage", 30, "Cage Pattern");  
        }
        
        if (event.getSlot() == 33) {
            PatternEquip(player, "Vortex", 30, "Vortex Pattern");  
        }
        
        // Save player to SQL
        if (event.getSlot() <= 34 && currentParticleType.get(player) != null && currentParticlePattern.get(player) != null) {
            if (plugin.dataParticles.existsPlayer(player.getUniqueId())) {
                plugin.dataParticles.remove(player.getUniqueId());
            }
            plugin.dataParticles.addParticle(player, player.getUniqueId(),
                    currentParticleType.get(player).toString(), currentParticlePattern.get(player));
        }

        
//        if (event.getSlot() == 33) {
//            currentParticlePattern.put(player, "Test");
//        }
        
        // Return to Particle Types window
        if (event.getSlot() == 39) {
            plugin.runTask(player, () -> player.openInventory(new ParticleTypeGui(plugin, player).getInventory()));
        }
        
        // Remove Particle Effect
        if (event.getSlot() == 40) {
            currentParticleType.remove(player);
            currentParticlePattern.remove(player);
            if (plugin.dataParticles.existsPlayer(player.getUniqueId())) {
                plugin.dataParticles.remove(player.getUniqueId());
            }
        }
        
        
        //Close Menu
        player.closeInventory();
    }
    
    
}