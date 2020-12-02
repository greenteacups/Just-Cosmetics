package cosmetics.disguises.listeners;

import java.util.HashMap;

import org.bukkit.ChatColor;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import cosmetics.CosmeticGui;
import cosmetics.Cosmetics;
import cosmetics.PurchaseConstructor;
import cosmetics.RemoveEffectsOnQuit;
import cosmetics.disguises.DisguiseGui;
import cosmetics.disguises.DisguiseGui2;

public class DisguiseGuiListeners implements Listener {
    
    public PurchaseConstructor PurchaseConstructor = Cosmetics.PurchaseConstructor;
    public HashMap<Player, String> purchaseItem = Cosmetics.purchaseItem;
    public HashMap<Player, Integer> purchasePrice = Cosmetics.purchasePrice;
    
    private Cosmetics plugin;

    public DisguiseGuiListeners(Cosmetics b) {
        plugin = b;
    }
    
    public static RemoveEffectsOnQuit RemoveEffectsOnQuit = new RemoveEffectsOnQuit();
    
    public static HashMap<Player, Entity> currentDisguise = new HashMap<>();
    
    //Disguise Constructor
    public void DisguiseConstructor(Player player, EntityType entity) {
        player.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 999999999, 1, true, true));
        
        LivingEntity ent = (LivingEntity) player.getWorld().spawnEntity(player.getLocation(), entity);
        ent.setCustomName(ChatColor.GOLD + ""  + ChatColor.BOLD + player.getName() + "'s Disguise");
        ent.setCustomNameVisible(true);
        ent.setAI(false);
        
        currentDisguise.put(player, ent);
    }
    
    //Disguise Equipper
    public void DisguiseEquip(Player player, EntityType entity, int price, String name) {
        if (plugin.dataCosmetics.exists(player.getUniqueId(), name)) {
            DisguiseConstructor(player, entity);
        }
        else {
            purchaseItem.put(player, name); //Input Name
            purchasePrice.put(player, price); //Input Price
            PurchaseConstructor.purchaseGui(player, purchaseItem.get(player), purchasePrice.get(player));
        }
    }
    
    
    //////
    //Clicking Inside the main Main Gui
    @EventHandler()
    public void onDisguiseGuiClick(InventoryClickEvent event) {
        if (!(event.getInventory().getHolder() instanceof DisguiseGui))
            return;
        if (event.getCurrentItem() == null) return;
        if (event.getCurrentItem().getItemMeta() == null) return;
        if (event.getCurrentItem().getItemMeta().getDisplayName() == null) return;
        if (event.getRawSlot() > 53) return;
        
        event.setCancelled(true);
        
        Player player = (Player) event.getWhoClicked();
        
        // Remove Active Cosmetics when selecting new Disguise
        if (event.getSlot() < 35) {
            RemoveEffectsOnQuit.ClearEffects(player);
        }
        
        //Add Bee Disguise
        if (event.getSlot() == 10) {
            DisguiseEquip(player, EntityType.BEE, 200, "Bee Disguise");
        }
        
        //Add Blaze Disguise
        if (event.getSlot() == 11) {
            DisguiseEquip(player, EntityType.BLAZE, 200, "Blaze Disguise");
        }
        
        //Add Cat Disguise
        if (event.getSlot() == 12) {
            DisguiseEquip(player, EntityType.CAT, 200, "Cat Disguise");
        }
        
        //Add Chicken Disguise
        if (event.getSlot() == 13) {
            DisguiseEquip(player, EntityType.CHICKEN, 200, "Chicken Disguise");
        }
        
        //Add Cow Disguise
        if (event.getSlot() == 14) {
            DisguiseEquip(player, EntityType.COW, 200, "Cow Disguise");
        }
        
        //Add Creeper Disguise
        if (event.getSlot() == 15) {
            DisguiseEquip(player, EntityType.CREEPER, 200, "Creeper Disguise");
        }
        
        //Add Dolphin Disguise
        if (event.getSlot() == 16) {
            DisguiseEquip(player, EntityType.DOLPHIN, 200, "Dolphin Disguise");
        }

        //Add Donkey Disguise
        if (event.getSlot() == 19) {
            DisguiseEquip(player, EntityType.DONKEY, 200, "Donkey Disguise");
        }
        
        //Add Drowned Disguise
        if (event.getSlot() == 20) {
            DisguiseEquip(player, EntityType.DROWNED, 200, "Drowned Disguise");
        }
        
        //Add Enderman Disguise
        if (event.getSlot() == 21) {
            DisguiseEquip(player, EntityType.ENDERMAN, 200, "Enderman Disguise");
        }
        
        //Add Endermite Disguise
        if (event.getSlot() == 22) {
            DisguiseEquip(player, EntityType.ENDERMITE, 200, "Endermite Disguise");
        }
        
        //Add Evoker Disguise
        if (event.getSlot() == 23) {
            DisguiseEquip(player, EntityType.EVOKER, 200, "Evoker Disguise");
        }
        
        //Add Fox Disguise
        if (event.getSlot() == 24) {
            DisguiseEquip(player, EntityType.FOX, 200, "Fox Disguise");
        }
        
        //Add Guardian Disguise
        if (event.getSlot() == 25) {
            DisguiseEquip(player, EntityType.GUARDIAN, 200, "Guardian Disguise");
        }
        
        //Add Hoglin Disguise
        if (event.getSlot() == 28) {
            DisguiseEquip(player, EntityType.HOGLIN, 200, "Hoglin Disguise");
        }
        
        //Add Horse Disguise
        if (event.getSlot() == 29) {
            DisguiseEquip(player, EntityType.HORSE, 200, "Horse Disguise");
        }
        
        //Add Husk Disguise
        if (event.getSlot() == 30) {
            DisguiseEquip(player, EntityType.HUSK, 200, "Husk Disguise");
        }
        
        //Add Llama Disguise
        if (event.getSlot() == 31) {
            DisguiseEquip(player, EntityType.LLAMA, 200, "Llama Disguise");
        }
        
        //Add Magma Cube Disguise
        if (event.getSlot() == 32) {
            DisguiseEquip(player, EntityType.MAGMA_CUBE, 200, "Magma Cube Disguise");
        }
        
        //Add Ocelot Disguise
        if (event.getSlot() == 33) {
            DisguiseEquip(player, EntityType.OCELOT, 200, "Ocelot Disguise");
        }
        
        //Add Panda Disguise
        if (event.getSlot() == 34) {
            DisguiseEquip(player, EntityType.PANDA, 200, "Panda Disguise");
        }
        
        // Return to cosmetic window
        if (event.getSlot() == 39) {
            plugin.getServer().getScheduler().runTask(plugin, () -> {
                player.openInventory(new CosmeticGui(plugin, player).getInventory());
            });
        }
        
        // Next Page
        if (event.getSlot() == 41) {
            plugin.getServer().getScheduler().runTask(plugin, () -> {
                player.openInventory(new DisguiseGui2(plugin, player).getInventory());
            });
        }
        
        // Remove Disguise Option
        if (event.getSlot() == 40) {
            RemoveEffectsOnQuit.ClearEffects(player);
        }
        
        //Return to main menu
        player.closeInventory();
    }
    
    
    //////
    //Clicking Inside the main Main Gui
    @EventHandler()
    public void onDisguiseGui2Click(InventoryClickEvent event) {
        if (!(event.getInventory().getHolder() instanceof DisguiseGui2))
            return;
        if (event.getCurrentItem() == null) return;
        if (event.getCurrentItem().getItemMeta() == null) return;
        if (event.getCurrentItem().getItemMeta().getDisplayName() == null) return;
        if (event.getRawSlot() > 53) return;
        
        event.setCancelled(true);
        
        Player player = (Player) event.getWhoClicked();
        
        // Remove Active Cosmetics when selecting new Disguise
        if (event.getSlot() < 35) {
            RemoveEffectsOnQuit.ClearEffects(player);
        }
        
        //Add Parrot Disguise
        if (event.getSlot() == 10) {
            DisguiseEquip(player, EntityType.PARROT, 200, "Parrot Disguise");
        }
        
        //Add Pig Disguise
        if (event.getSlot() == 11) {
            DisguiseEquip(player, EntityType.PIG, 200, "Pig Disguise");
        }
        
        //Add Piglin Disguise
        if (event.getSlot() == 12) {
            DisguiseEquip(player, EntityType.PIGLIN, 200, "Piglin Disguise");
        }
        
        //Add Pillager Disguise
        if (event.getSlot() == 13) {
            DisguiseEquip(player, EntityType.PILLAGER, 200, "Pillager Disguise");
        }
        
        //Add Polar Bear Disguise
        if (event.getSlot() == 14) {
            DisguiseEquip(player, EntityType.POLAR_BEAR, 200, "Polar Bear Disguise");
        }
        
        //Add Rabbit Disguise
        if (event.getSlot() == 15) {
            DisguiseEquip(player, EntityType.RABBIT, 200, "Rabbit Disguise");
        }
        
        //Add Sheep Disguise
        if (event.getSlot() == 16) {
            DisguiseEquip(player, EntityType.SHEEP, 200, "Sheep Disguise");
        }

        //Add Silverfish Disguise
        if (event.getSlot() == 19) {
            DisguiseEquip(player, EntityType.SILVERFISH, 200, "Silverfish Disguise");
        }
        
        //Add Skeleton Disguise
        if (event.getSlot() == 20) {
            DisguiseEquip(player, EntityType.SKELETON, 200, "Skeleton Disguise");
        }
        
        //Add Slime Disguise
        if (event.getSlot() == 21) {
            DisguiseEquip(player, EntityType.SLIME, 200, "Slime Disguise");
        }
        
        //Add Spider Disguise
        if (event.getSlot() == 22) {
            DisguiseEquip(player, EntityType.SPIDER, 200, "Spider Disguise");
        }
        
        //Add Stray Disguise
        if (event.getSlot() == 23) {
            DisguiseEquip(player, EntityType.STRAY, 200, "Stray Disguise");
        }
        
        //Add Strider Disguise
        if (event.getSlot() == 24) {
            DisguiseEquip(player, EntityType.STRIDER, 200, "Strider Disguise");
        }
        
        //Add Turtle Disguise
        if (event.getSlot() == 25) {
            DisguiseEquip(player, EntityType.TURTLE, 200, "Turtle Disguise");
        }
        
        //Add Vex Disguise
        if (event.getSlot() == 28) {
            DisguiseEquip(player, EntityType.VEX, 200, "Vex Disguise");
        }
        
        //Add Vindicator Disguise
        if (event.getSlot() == 29) {
            DisguiseEquip(player, EntityType.VINDICATOR, 200, "Vindicator Disguise");
        }
        
        //Add Witch Disguise
        if (event.getSlot() == 30) {
            DisguiseEquip(player, EntityType.WITCH, 200, "Witch Disguise");
        }
        
        //Add Wither Skeleton Disguise
        if (event.getSlot() == 31) {
            DisguiseEquip(player, EntityType.WITHER_SKELETON, 200, "Wither Skeleton Disguise");
        }
        
        //Add Wolf Disguise
        if (event.getSlot() == 32) {
            DisguiseEquip(player, EntityType.WOLF, 200, "Wolf Disguise");
        }
        
        //Add Zoglin Disguise
        if (event.getSlot() == 33) {
            DisguiseEquip(player, EntityType.ZOGLIN, 200, "Zoglin Disguise");
        }
        
        //Add Zombie Disguise
        if (event.getSlot() == 34) {
            DisguiseEquip(player, EntityType.ZOMBIE, 200, "Zombie Disguise");
        }
        

        
        // Previous Page
        if (event.getSlot() == 39) {
            plugin.getServer().getScheduler().runTask(plugin, () -> {
                player.openInventory(new DisguiseGui(plugin, player).getInventory());
            });
        }
        
        // Next Page
        if (event.getSlot() == 41) {
            plugin.getServer().getScheduler().runTask(plugin, () -> {
                player.openInventory(new DisguiseGui2(plugin, player).getInventory());
            });
        }
        
        // Remove Disguise Option
        if (event.getSlot() == 40) {
            RemoveEffectsOnQuit.ClearEffects(player);
        }
        
        //Return to main menu
        player.closeInventory();
    }
    
    
}