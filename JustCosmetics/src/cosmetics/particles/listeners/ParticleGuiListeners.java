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
    private Cosmetics plugin;
    
    public PurchaseGui purchasegui = Cosmetics.purchasegui;
    public PurchaseConstructor PurchaseConstructor = Cosmetics.PurchaseConstructor;
    public HashMap<Player, String> purchaseItem = Cosmetics.purchaseItem;
    public HashMap<Player, Integer> purchasePrice = Cosmetics.purchasePrice;

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
            if (plugin.dataCosmetics.exists(player.getUniqueId(), "Composter Particle")) {
                currentParticleType.put(player, Particle.COMPOSTER);
                
                particlepatterngui.ExampleGui(player);
                plugin.getServer().getScheduler().runTask(plugin, () -> {
                    player.openInventory(particlepatterngui.inv);
                });
            }
            else {
                purchaseItem.put(player, "Composter Particle"); //Input Name
                purchasePrice.put(player, 20); //Input Price
                PurchaseConstructor.purchaseGui(player, purchaseItem.get(player), purchasePrice.get(player));
            }
        }
        
        if (event.getSlot() == 11) {
            if (plugin.dataCosmetics.exists(player.getUniqueId(), "Angry Villager Particle")) {
                currentParticleType.put(player, Particle.VILLAGER_ANGRY);
                
                particlepatterngui.ExampleGui(player);
                plugin.getServer().getScheduler().runTask(plugin, () -> {
                    player.openInventory(particlepatterngui.inv);
                });
            }
            else {
                purchaseItem.put(player, "Angry Villager Particle"); //Input Name
                purchasePrice.put(player, 20); //Input Price
                PurchaseConstructor.purchaseGui(player, purchaseItem.get(player), purchasePrice.get(player));
            }
        }
        
        if (event.getSlot() == 12) {
            if (plugin.dataCosmetics.exists(player.getUniqueId(), "Ash Particle")) {
                currentParticleType.put(player, Particle.ASH);
                
                particlepatterngui.ExampleGui(player);
                plugin.getServer().getScheduler().runTask(plugin, () -> {
                    player.openInventory(particlepatterngui.inv);
                });
            }
            else {
                purchaseItem.put(player, "Ash Particle"); //Input Name
                purchasePrice.put(player, 20); //Input Price
                PurchaseConstructor.purchaseGui(player, purchaseItem.get(player), purchasePrice.get(player));
            }
        }
        
        if (event.getSlot() == 13) {
            if (plugin.dataCosmetics.exists(player.getUniqueId(), "Water Bubble Particle")) {
                currentParticleType.put(player, Particle.WATER_BUBBLE);
                
                particlepatterngui.ExampleGui(player);
                plugin.getServer().getScheduler().runTask(plugin, () -> {
                    player.openInventory(particlepatterngui.inv);
                });
            }
            else {
                purchaseItem.put(player, "Water Bubble Particle"); //Input Name
                purchasePrice.put(player, 20); //Input Price
                PurchaseConstructor.purchaseGui(player, purchaseItem.get(player), purchasePrice.get(player));
            }
        }
        
        if (event.getSlot() == 14) {
            if (plugin.dataCosmetics.exists(player.getUniqueId(), "Big Water Bubble Particle")) {
                currentParticleType.put(player, Particle.BUBBLE_POP);
                
                particlepatterngui.ExampleGui(player);
                plugin.getServer().getScheduler().runTask(plugin, () -> {
                    player.openInventory(particlepatterngui.inv);
                });
            }
            else {
                purchaseItem.put(player, "Big Water Bubble Particle"); //Input Name
                purchasePrice.put(player, 20); //Input Price
                PurchaseConstructor.purchaseGui(player, purchaseItem.get(player), purchasePrice.get(player));
            }
        }
        
        if (event.getSlot() == 15) {
            if (plugin.dataCosmetics.exists(player.getUniqueId(), "Smoulder Particle")) {
                currentParticleType.put(player, Particle.SMOKE_NORMAL);
                
                particlepatterngui.ExampleGui(player);
                plugin.getServer().getScheduler().runTask(plugin, () -> {
                    player.openInventory(particlepatterngui.inv);
                });
            }
            else {
                purchaseItem.put(player, "Smoulder Particle"); //Input Name
                purchasePrice.put(player, 20); //Input Price
                PurchaseConstructor.purchaseGui(player, purchaseItem.get(player), purchasePrice.get(player));
            }
        }
        
        if (event.getSlot() == 16) {
            if (plugin.dataCosmetics.exists(player.getUniqueId(), "Smoke Particle")) {
                currentParticleType.put(player, Particle.SMOKE_LARGE);
                
                particlepatterngui.ExampleGui(player);
                plugin.getServer().getScheduler().runTask(plugin, () -> {
                    player.openInventory(particlepatterngui.inv);
                });
            }
            else {
                purchaseItem.put(player, "Smoke Particle"); //Input Name
                purchasePrice.put(player, 20); //Input Price
                PurchaseConstructor.purchaseGui(player, purchaseItem.get(player), purchasePrice.get(player));
            }
        }
        
        if (event.getSlot() == 19) {
            if (plugin.dataCosmetics.exists(player.getUniqueId(), "Campfire Smoke Particle")) {
                currentParticleType.put(player, Particle.CAMPFIRE_COSY_SMOKE);
                
                particlepatterngui.ExampleGui(player);
                plugin.getServer().getScheduler().runTask(plugin, () -> {
                    player.openInventory(particlepatterngui.inv);
                });
            }
            else {
                purchaseItem.put(player, "Campfire Smoke Particle"); //Input Name
                purchasePrice.put(player, 20); //Input Price
                PurchaseConstructor.purchaseGui(player, purchaseItem.get(player), purchasePrice.get(player));
            }
        }
        
        if (event.getSlot() == 20) {
            if (plugin.dataCosmetics.exists(player.getUniqueId(), "Cloud Particle")) {
                currentParticleType.put(player, Particle.CLOUD);
                
                particlepatterngui.ExampleGui(player);
                plugin.getServer().getScheduler().runTask(plugin, () -> {
                    player.openInventory(particlepatterngui.inv);
                });
            }
            else {
                purchaseItem.put(player, "Cloud Particle"); //Input Name
                purchasePrice.put(player, 20); //Input Price
                PurchaseConstructor.purchaseGui(player, purchaseItem.get(player), purchasePrice.get(player));
            }
        }
        
        if (event.getSlot() == 21) {
            if (plugin.dataCosmetics.exists(player.getUniqueId(), "Crimson Spore Particle")) {
                currentParticleType.put(player, Particle.CRIMSON_SPORE);
                
                particlepatterngui.ExampleGui(player);
                plugin.getServer().getScheduler().runTask(plugin, () -> {
                    player.openInventory(particlepatterngui.inv);
                });
            }
            else {
                purchaseItem.put(player, "Crimson Spore Particle"); //Input Name
                purchasePrice.put(player, 20); //Input Price
                PurchaseConstructor.purchaseGui(player, purchaseItem.get(player), purchasePrice.get(player));
            }
        }
        
        if (event.getSlot() == 22) {
            if (plugin.dataCosmetics.exists(player.getUniqueId(), "Warped Spore Particle")) {
                currentParticleType.put(player, Particle.WARPED_SPORE);
                
                particlepatterngui.ExampleGui(player);
                plugin.getServer().getScheduler().runTask(plugin, () -> {
                    player.openInventory(particlepatterngui.inv);
                });
            }
            else {
                purchaseItem.put(player, "Warped Spore Particle"); //Input Name
                purchasePrice.put(player, 20); //Input Price
                PurchaseConstructor.purchaseGui(player, purchaseItem.get(player), purchasePrice.get(player));
            }
        }
        
        if (event.getSlot() == 23) {
            if (plugin.dataCosmetics.exists(player.getUniqueId(), "Critical Hit Particle")) {
                currentParticleType.put(player, Particle.CRIT);
                
                particlepatterngui.ExampleGui(player);
                plugin.getServer().getScheduler().runTask(plugin, () -> {
                    player.openInventory(particlepatterngui.inv);
                });
            }
            else {
                purchaseItem.put(player, "Critical Hit Particle"); //Input Name
                purchasePrice.put(player, 20); //Input Price
                PurchaseConstructor.purchaseGui(player, purchaseItem.get(player), purchasePrice.get(player));
            }
        }
        
        if (event.getSlot() == 24) {
            if (plugin.dataCosmetics.exists(player.getUniqueId(), "Damage Particle")) {
                currentParticleType.put(player, Particle.DAMAGE_INDICATOR);
                
                particlepatterngui.ExampleGui(player);
                plugin.getServer().getScheduler().runTask(plugin, () -> {
                    player.openInventory(particlepatterngui.inv);
                });
            }
            else {
                purchaseItem.put(player, "Damage Particle"); //Input Name
                purchasePrice.put(player, 20); //Input Price
                PurchaseConstructor.purchaseGui(player, purchaseItem.get(player), purchasePrice.get(player));
            }
        }
        
        if (event.getSlot() == 25) {
            if (plugin.dataCosmetics.exists(player.getUniqueId(), "Dragon Breath Particle")) {
                currentParticleType.put(player, Particle.DRAGON_BREATH);
                
                particlepatterngui.ExampleGui(player);
                plugin.getServer().getScheduler().runTask(plugin, () -> {
                    player.openInventory(particlepatterngui.inv);
                });
            }
            else {
                purchaseItem.put(player, "Dragon Breath Particle"); //Input Name
                purchasePrice.put(player, 20); //Input Price
                PurchaseConstructor.purchaseGui(player, purchaseItem.get(player), purchasePrice.get(player));
            }
        }
        
        if (event.getSlot() == 28) {
            if (plugin.dataCosmetics.exists(player.getUniqueId(), "Honey Drops Particle")) {
                currentParticleType.put(player, Particle.FALLING_HONEY);
                
                particlepatterngui.ExampleGui(player);
                plugin.getServer().getScheduler().runTask(plugin, () -> {
                    player.openInventory(particlepatterngui.inv);
                });
            }
            else {
                purchaseItem.put(player, "Honey Drops Particle"); //Input Name
                purchasePrice.put(player, 20); //Input Price
                PurchaseConstructor.purchaseGui(player, purchaseItem.get(player), purchasePrice.get(player));
            }
        }
        
        if (event.getSlot() == 29) {
            if (plugin.dataCosmetics.exists(player.getUniqueId(), "Water Drops Particle")) {
                currentParticleType.put(player, Particle.DRIP_WATER);
                
                particlepatterngui.ExampleGui(player);
                plugin.getServer().getScheduler().runTask(plugin, () -> {
                    player.openInventory(particlepatterngui.inv);
                });
            }
            else {
                purchaseItem.put(player, "Water Drops Particle"); //Input Name
                purchasePrice.put(player, 20); //Input Price
                PurchaseConstructor.purchaseGui(player, purchaseItem.get(player), purchasePrice.get(player));
            }
        }
        
        if (event.getSlot() == 30) {
            if (plugin.dataCosmetics.exists(player.getUniqueId(), "Lava Drops Particle")) {
                currentParticleType.put(player, Particle.DRIP_LAVA);
                
                particlepatterngui.ExampleGui(player);
                plugin.getServer().getScheduler().runTask(plugin, () -> {
                    player.openInventory(particlepatterngui.inv);
                });
            }
            else {
                purchaseItem.put(player, "Lava Drops Particle"); //Input Name
                purchasePrice.put(player, 20); //Input Price
                PurchaseConstructor.purchaseGui(player, purchaseItem.get(player), purchasePrice.get(player));
            }
        }
        
        if (event.getSlot() == 31) {
            if (plugin.dataCosmetics.exists(player.getUniqueId(), "Obsidian Tears Particle")) {
                currentParticleType.put(player, Particle.FALLING_OBSIDIAN_TEAR);
                
                particlepatterngui.ExampleGui(player);
                plugin.getServer().getScheduler().runTask(plugin, () -> {
                    player.openInventory(particlepatterngui.inv);
                });
            }
            else {
                purchaseItem.put(player, "Obsidian Tears Particle"); //Input Name
                purchasePrice.put(player, 20); //Input Price
                PurchaseConstructor.purchaseGui(player, purchaseItem.get(player), purchasePrice.get(player));
            }
        }
        
        if (event.getSlot() == 32) {
            if (plugin.dataCosmetics.exists(player.getUniqueId(), "White Spell Particle")) {
                currentParticleType.put(player, Particle.SPELL);
                
                particlepatterngui.ExampleGui(player);
                plugin.getServer().getScheduler().runTask(plugin, () -> {
                    player.openInventory(particlepatterngui.inv);
                });
            }
            else {
                purchaseItem.put(player, "White Spell Particle"); //Input Name
                purchasePrice.put(player, 20); //Input Price
                PurchaseConstructor.purchaseGui(player, purchaseItem.get(player), purchasePrice.get(player));
            }
        }
        
        if (event.getSlot() == 33) {
            if (plugin.dataCosmetics.exists(player.getUniqueId(), "Black Spell Particle")) {
                currentParticleType.put(player, Particle.SPELL_MOB);
                
                particlepatterngui.ExampleGui(player);
                plugin.getServer().getScheduler().runTask(plugin, () -> {
                    player.openInventory(particlepatterngui.inv);
                });
            }
            else {
                purchaseItem.put(player, "Black Spell Particle"); //Input Name
                purchasePrice.put(player, 20); //Input Price
                PurchaseConstructor.purchaseGui(player, purchaseItem.get(player), purchasePrice.get(player));
            }
        }
        
        if (event.getSlot() == 34) {
            if (plugin.dataCosmetics.exists(player.getUniqueId(), "Purple Spell Particle")) {
                currentParticleType.put(player, Particle.SPELL_WITCH);
                
                particlepatterngui.ExampleGui(player);
                plugin.getServer().getScheduler().runTask(plugin, () -> {
                    player.openInventory(particlepatterngui.inv);
                });
            }
            else {
                purchaseItem.put(player, "Purple Spell Particle"); //Input Name
                purchasePrice.put(player, 20); //Input Price
                PurchaseConstructor.purchaseGui(player, purchaseItem.get(player), purchasePrice.get(player));
            }
        }
        
        // Next Particle Type Gui
        if (event.getSlot() == 41) {
            particletypegui2.ExampleGui(player);
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
            if (plugin.dataCosmetics.exists(player.getUniqueId(), "Enchant Glyph Particle")) {
                currentParticleType.put(player, Particle.ENCHANTMENT_TABLE);
                
                particlepatterngui.ExampleGui(player);
                plugin.getServer().getScheduler().runTask(plugin, () -> {
                    player.openInventory(particlepatterngui.inv);
                });
            }
            else {
                purchaseItem.put(player, "Enchant Glyph Particle"); //Input Name
                purchasePrice.put(player, 20); //Input Price
                PurchaseConstructor.purchaseGui(player, purchaseItem.get(player), purchasePrice.get(player));
            }
        }
        
        if (event.getSlot() == 11) {
            if (plugin.dataCosmetics.exists(player.getUniqueId(), "End Rod Particle")) {
                currentParticleType.put(player, Particle.END_ROD);
                
                particlepatterngui.ExampleGui(player);
                plugin.getServer().getScheduler().runTask(plugin, () -> {
                    player.openInventory(particlepatterngui.inv);
                });
            }
            else {
                purchaseItem.put(player, "End Rod Particle"); //Input Name
                purchasePrice.put(player, 20); //Input Price
                PurchaseConstructor.purchaseGui(player, purchaseItem.get(player), purchasePrice.get(player));
            }
        }
        
        if (event.getSlot() == 12) {
            if (plugin.dataCosmetics.exists(player.getUniqueId(), "Explosion Particle")) {
                currentParticleType.put(player, Particle.EXPLOSION_LARGE);
                
                particlepatterngui.ExampleGui(player);
                plugin.getServer().getScheduler().runTask(plugin, () -> {
                    player.openInventory(particlepatterngui.inv);
                });
            }
            else {
                purchaseItem.put(player, "Explosion Particle"); //Input Name
                purchasePrice.put(player, 20); //Input Price
                PurchaseConstructor.purchaseGui(player, purchaseItem.get(player), purchasePrice.get(player));
            }
        }
        
        if (event.getSlot() == 13) {
            if (plugin.dataCosmetics.exists(player.getUniqueId(), "Soul Fire Particle")) {
                currentParticleType.put(player, Particle.SOUL_FIRE_FLAME);
                
                particlepatterngui.ExampleGui(player);
                plugin.getServer().getScheduler().runTask(plugin, () -> {
                    player.openInventory(particlepatterngui.inv);
                });
            }
            else {
                purchaseItem.put(player, "Soul Fire Particle"); //Input Name
                purchasePrice.put(player, 20); //Input Price
                PurchaseConstructor.purchaseGui(player, purchaseItem.get(player), purchasePrice.get(player));
            }
        }
        
        if (event.getSlot() == 14) {
            if (plugin.dataCosmetics.exists(player.getUniqueId(), "Nectar Particle")) {
                currentParticleType.put(player, Particle.FALLING_NECTAR);
                
                particlepatterngui.ExampleGui(player);
                plugin.getServer().getScheduler().runTask(plugin, () -> {
                    player.openInventory(particlepatterngui.inv);
                });
            }
            else {
                purchaseItem.put(player, "Nectar Particle"); //Input Name
                purchasePrice.put(player, 20); //Input Price
                PurchaseConstructor.purchaseGui(player, purchaseItem.get(player), purchasePrice.get(player));
            }
        }
        
        if (event.getSlot() == 15) {
            if (plugin.dataCosmetics.exists(player.getUniqueId(), "Water Wake Particle")) {
                currentParticleType.put(player, Particle.WATER_WAKE);
                
                particlepatterngui.ExampleGui(player);
                plugin.getServer().getScheduler().runTask(plugin, () -> {
                    player.openInventory(particlepatterngui.inv);
                });
            }
            else {
                purchaseItem.put(player, "Water Wake Particle"); //Input Name
                purchasePrice.put(player, 20); //Input Price
                PurchaseConstructor.purchaseGui(player, purchaseItem.get(player), purchasePrice.get(player));
            }
        }
        
        if (event.getSlot() == 16) {
            if (plugin.dataCosmetics.exists(player.getUniqueId(), "Heart Particle")) {
                currentParticleType.put(player, Particle.HEART);
                
                particlepatterngui.ExampleGui(player);
                plugin.getServer().getScheduler().runTask(plugin, () -> {
                    player.openInventory(particlepatterngui.inv);
                });
            }
            else {
                purchaseItem.put(player, "Heart Particle"); //Input Name
                purchasePrice.put(player, 20); //Input Price
                PurchaseConstructor.purchaseGui(player, purchaseItem.get(player), purchasePrice.get(player));
            }
        }
        
        if (event.getSlot() == 19) {
            if (plugin.dataCosmetics.exists(player.getUniqueId(), "Slime Particle")) {
                currentParticleType.put(player, Particle.SLIME);
                
                particlepatterngui.ExampleGui(player);
                plugin.getServer().getScheduler().runTask(plugin, () -> {
                    player.openInventory(particlepatterngui.inv);
                });
            }
            else {
                purchaseItem.put(player, "Slime Particle"); //Input Name
                purchasePrice.put(player, 20); //Input Price
                PurchaseConstructor.purchaseGui(player, purchaseItem.get(player), purchasePrice.get(player));
            }
        }
        
        if (event.getSlot() == 20) {
            if (plugin.dataCosmetics.exists(player.getUniqueId(), "Snowball Particle")) {
                currentParticleType.put(player, Particle.SNOWBALL);
                
                particlepatterngui.ExampleGui(player);
                plugin.getServer().getScheduler().runTask(plugin, () -> {
                    player.openInventory(particlepatterngui.inv);
                });
            }
            else {
                purchaseItem.put(player, "Snowball Particle"); //Input Name
                purchasePrice.put(player, 20); //Input Price
                PurchaseConstructor.purchaseGui(player, purchaseItem.get(player), purchasePrice.get(player));
            }
        }
        
        if (event.getSlot() == 21) {
            if (plugin.dataCosmetics.exists(player.getUniqueId(), "Nautilus Particle")) {
                currentParticleType.put(player, Particle.NAUTILUS);
                
                particlepatterngui.ExampleGui(player);
                plugin.getServer().getScheduler().runTask(plugin, () -> {
                    player.openInventory(particlepatterngui.inv);
                });
            }
            else {
                purchaseItem.put(player, "Nautilus Particle"); //Input Name
                purchasePrice.put(player, 20); //Input Price
                PurchaseConstructor.purchaseGui(player, purchaseItem.get(player), purchasePrice.get(player));
            }
        }
        
        if (event.getSlot() == 22) {
            if (plugin.dataCosmetics.exists(player.getUniqueId(), "Music Note Particle")) {
                currentParticleType.put(player, Particle.NOTE);
                
                particlepatterngui.ExampleGui(player);
                plugin.getServer().getScheduler().runTask(plugin, () -> {
                    player.openInventory(particlepatterngui.inv);
                });
            }
            else {
                purchaseItem.put(player, "Music Note Particle"); //Input Name
                purchasePrice.put(player, 20); //Input Price
                PurchaseConstructor.purchaseGui(player, purchaseItem.get(player), purchasePrice.get(player));
            }
        }
        
        if (event.getSlot() == 23) {
            if (plugin.dataCosmetics.exists(player.getUniqueId(), "Contagious Particle")) {
                currentParticleType.put(player, Particle.SNEEZE);
                
                particlepatterngui.ExampleGui(player);
                plugin.getServer().getScheduler().runTask(plugin, () -> {
                    player.openInventory(particlepatterngui.inv);
                });
            }
            else {
                purchaseItem.put(player, "Contagious Particle"); //Input Name
                purchasePrice.put(player, 20); //Input Price
                PurchaseConstructor.purchaseGui(player, purchaseItem.get(player), purchasePrice.get(player));
            }
        }
        
        if (event.getSlot() == 24) {
            if (plugin.dataCosmetics.exists(player.getUniqueId(), "Ink Particle")) {
                currentParticleType.put(player, Particle.SQUID_INK);
                
                particlepatterngui.ExampleGui(player);
                plugin.getServer().getScheduler().runTask(plugin, () -> {
                    player.openInventory(particlepatterngui.inv);
                });
            }
            else {
                purchaseItem.put(player, "Ink Particle"); //Input Name
                purchasePrice.put(player, 20); //Input Price
                PurchaseConstructor.purchaseGui(player, purchaseItem.get(player), purchasePrice.get(player));
            }
        }
        
        if (event.getSlot() == 25) {
            if (plugin.dataCosmetics.exists(player.getUniqueId(), "Totem Particle")) {
                currentParticleType.put(player, Particle.TOTEM);
                
                particlepatterngui.ExampleGui(player);
                plugin.getServer().getScheduler().runTask(plugin, () -> {
                    player.openInventory(particlepatterngui.inv);
                });
            }
            else {
                purchaseItem.put(player, "Totem Particle"); //Input Name
                purchasePrice.put(player, 20); //Input Price
                PurchaseConstructor.purchaseGui(player, purchaseItem.get(player), purchasePrice.get(player));
            }
        }
        
        if (event.getSlot() == 28) {
            if (plugin.dataCosmetics.exists(player.getUniqueId(), "Lava Burst Particle")) {
                currentParticleType.put(player, Particle.LAVA);
                
                particlepatterngui.ExampleGui(player);
                plugin.getServer().getScheduler().runTask(plugin, () -> {
                    player.openInventory(particlepatterngui.inv);
                });
            }
            else {
                purchaseItem.put(player, "Lava Burst Particle"); //Input Name
                purchasePrice.put(player, 20); //Input Price
                PurchaseConstructor.purchaseGui(player, purchaseItem.get(player), purchasePrice.get(player));
            }
        }
        
        
        // Return to cosmetic window
        if (event.getSlot() == 39) {
            particletypegui.ExampleGui(player);
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
            if (plugin.dataCosmetics.exists(player.getUniqueId(), "Dot Pattern")) {
                currentParticlePattern.put(player, "Dot");
            }
            else {
                purchaseItem.put(player, "Dot Pattern"); //Input Name
                purchasePrice.put(player, 20); //Input Price
                PurchaseConstructor.purchaseGui(player, purchaseItem.get(player), purchasePrice.get(player));
            }   
        }
        
        if (event.getSlot() == 11) {
            if (plugin.dataCosmetics.exists(player.getUniqueId(), "Halo Pattern")) {
                currentParticlePattern.put(player, "Halo");
            }
            else {
                purchaseItem.put(player, "Halo Pattern"); //Input Name
                purchasePrice.put(player, 20); //Input Price
                PurchaseConstructor.purchaseGui(player, purchaseItem.get(player), purchasePrice.get(player));
            } 
        }
        
        if (event.getSlot() == 12) {
            if (plugin.dataCosmetics.exists(player.getUniqueId(), "Rings Pattern")) {
                currentParticlePattern.put(player, "Rings");
            }
            else {
                purchaseItem.put(player, "Rings Pattern"); //Input Name
                purchasePrice.put(player, 20); //Input Price
                PurchaseConstructor.purchaseGui(player, purchaseItem.get(player), purchasePrice.get(player));
            } 
        }
        
        if (event.getSlot() == 13) {
            if (plugin.dataCosmetics.exists(player.getUniqueId(), "Sphere Pattern")) {
                currentParticlePattern.put(player, "Sphere");
            }
            else {
                purchaseItem.put(player, "Sphere Pattern"); //Input Name
                purchasePrice.put(player, 20); //Input Price
                PurchaseConstructor.purchaseGui(player, purchaseItem.get(player), purchasePrice.get(player));
            } 
        }
        
        if (event.getSlot() == 14) {
            if (plugin.dataCosmetics.exists(player.getUniqueId(), "Prism Pattern")) {
                currentParticlePattern.put(player, "Prism");
            }
            else {
                purchaseItem.put(player, "Prism Pattern"); //Input Name
                purchasePrice.put(player, 20); //Input Price
                PurchaseConstructor.purchaseGui(player, purchaseItem.get(player), purchasePrice.get(player));
            } 
        }
        
        if (event.getSlot() == 15) {
            if (plugin.dataCosmetics.exists(player.getUniqueId(), "Burst Pattern")) {
                currentParticlePattern.put(player, "Burst");
            }
            else {
                purchaseItem.put(player, "Burst Pattern"); //Input Name
                purchasePrice.put(player, 20); //Input Price
                PurchaseConstructor.purchaseGui(player, purchaseItem.get(player), purchasePrice.get(player));
            } 
        }
        
        if (event.getSlot() == 16) {
            if (plugin.dataCosmetics.exists(player.getUniqueId(), "Smiley Pattern")) {
                currentParticlePattern.put(player, "Smiley");
            }
            else {
                purchaseItem.put(player, "Smiley Pattern"); //Input Name
                purchasePrice.put(player, 20); //Input Price
                PurchaseConstructor.purchaseGui(player, purchaseItem.get(player), purchasePrice.get(player));
            } 
        }
        
        if (event.getSlot() == 19) {
            if (plugin.dataCosmetics.exists(player.getUniqueId(), "Heart Pattern")) {
                currentParticlePattern.put(player, "Heart");
            }
            else {
                purchaseItem.put(player, "Hear Pattern"); //Input Name
                purchasePrice.put(player, 20); //Input Price
                PurchaseConstructor.purchaseGui(player, purchaseItem.get(player), purchasePrice.get(player));
            } 
        }
        
        if (event.getSlot() == 20) {
            if (plugin.dataCosmetics.exists(player.getUniqueId(), "Swirl Helix Pattern")) {
                currentParticlePattern.put(player, "Swirl Helix");
            }
            else {
                purchaseItem.put(player, "Swirl Helix Pattern"); //Input Name
                purchasePrice.put(player, 20); //Input Price
                PurchaseConstructor.purchaseGui(player, purchaseItem.get(player), purchasePrice.get(player));
            } 
        }
        
        if (event.getSlot() == 21) {
            if (plugin.dataCosmetics.exists(player.getUniqueId(), "Cube Pattern")) {
                currentParticlePattern.put(player, "Cube");
            }
            else {
                purchaseItem.put(player, "Cube Pattern"); //Input Name
                purchasePrice.put(player, 20); //Input Price
                PurchaseConstructor.purchaseGui(player, purchaseItem.get(player), purchasePrice.get(player));
            } 
        }
        
        if (event.getSlot() == 22) {
            if (plugin.dataCosmetics.exists(player.getUniqueId(), "Chains Pattern")) {
                currentParticlePattern.put(player, "Chains");
            }
            else {
                purchaseItem.put(player, "Chains Pattern"); //Input Name
                purchasePrice.put(player, 20); //Input Price
                PurchaseConstructor.purchaseGui(player, purchaseItem.get(player), purchasePrice.get(player));
            } 
        }
        
        if (event.getSlot() == 23) {
            if (plugin.dataCosmetics.exists(player.getUniqueId(), "Stars Pattern")) {
                currentParticlePattern.put(player, "Stars");
            }
            else {
                purchaseItem.put(player, "Stars Pattern"); //Input Name
                purchasePrice.put(player, 20); //Input Price
                PurchaseConstructor.purchaseGui(player, purchaseItem.get(player), purchasePrice.get(player));
            } 
        }
        
        if (event.getSlot() == 24) {
            if (plugin.dataCosmetics.exists(player.getUniqueId(), "Double Helix Pattern")) {
                currentParticlePattern.put(player, "Double Helix");
            }
            else {
                purchaseItem.put(player, "Double Helix Pattern"); //Input Name
                purchasePrice.put(player, 20); //Input Price
                PurchaseConstructor.purchaseGui(player, purchaseItem.get(player), purchasePrice.get(player));
            } 
        }
        
        if (event.getSlot() == 25) {
            if (plugin.dataCosmetics.exists(player.getUniqueId(), "QuadraHelix Pattern")) {
                currentParticlePattern.put(player, "QuadraHelix");
            }
            else {
                purchaseItem.put(player, "QuadraHelix Pattern"); //Input Name
                purchasePrice.put(player, 20); //Input Price
                PurchaseConstructor.purchaseGui(player, purchaseItem.get(player), purchasePrice.get(player));
            } 
        }
        
        if (event.getSlot() == 28) {
            if (plugin.dataCosmetics.exists(player.getUniqueId(), "Egg Pattern")) {
                currentParticlePattern.put(player, "Egg");
            }
            else {
                purchaseItem.put(player, "Egg Pattern"); //Input Name
                purchasePrice.put(player, 20); //Input Price
                PurchaseConstructor.purchaseGui(player, purchaseItem.get(player), purchasePrice.get(player));
            } 
        }
        
        if (event.getSlot() == 29) {
            if (plugin.dataCosmetics.exists(player.getUniqueId(), "Big Ring Pattern")) {
                currentParticlePattern.put(player, "Big Ring");
            }
            else {
                purchaseItem.put(player, "Big Ring Pattern"); //Input Name
                purchasePrice.put(player, 20); //Input Price
                PurchaseConstructor.purchaseGui(player, purchaseItem.get(player), purchasePrice.get(player));
            } 
        }
        
        if (event.getSlot() == 30) {
            if (plugin.dataCosmetics.exists(player.getUniqueId(), "Normal Pattern")) {
                currentParticlePattern.put(player, "Normal");
            }
            else {
                purchaseItem.put(player, "Normal Pattern"); //Input Name
                purchasePrice.put(player, 20); //Input Price
                PurchaseConstructor.purchaseGui(player, purchaseItem.get(player), purchasePrice.get(player));
            } 
        }
        
        if (event.getSlot() == 31) {
            if (plugin.dataCosmetics.exists(player.getUniqueId(), "Beams Pattern")) {
                currentParticlePattern.put(player, "Beams");
            }
            else {
                purchaseItem.put(player, "Beams Pattern"); //Input Name
                purchasePrice.put(player, 20); //Input Price
                PurchaseConstructor.purchaseGui(player, purchaseItem.get(player), purchasePrice.get(player));
            } 
        }
        
        if (event.getSlot() == 32) {
            if (plugin.dataCosmetics.exists(player.getUniqueId(), "Cage Pattern")) {
                currentParticlePattern.put(player, "Cage");
            }
            else {
                purchaseItem.put(player, "Cage Pattern"); //Input Name
                purchasePrice.put(player, 20); //Input Price
                PurchaseConstructor.purchaseGui(player, purchaseItem.get(player), purchasePrice.get(player));
            } 
        }
        
        if (event.getSlot() == 33) {
            currentParticlePattern.put(player, "Test");
        }
        
        // Return to Particle Types window
        if (event.getSlot() == 39) {
            particletypegui.ExampleGui(player);
            plugin.getServer().getScheduler().runTask(plugin, () -> {
                player.openInventory(particletypegui.inv);
            });
        }
        
        
        player.closeInventory();
    }
    
    
}