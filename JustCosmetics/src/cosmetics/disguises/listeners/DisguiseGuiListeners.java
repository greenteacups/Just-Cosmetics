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
import cosmetics.PurchaseGui;
import cosmetics.RemoveEffects;
import cosmetics.disguises.DisguiseGui;
import cosmetics.disguises.DisguiseGui2;

public class DisguiseGuiListeners implements Listener {

    public CosmeticGui maingui = Cosmetics.maingui;
    public DisguiseGui disguisegui = Cosmetics.disguisegui;
    public DisguiseGui2 disguisegui2 = Cosmetics.disguisegui2;
    
    public PurchaseGui purchasegui = Cosmetics.purchasegui;
    public PurchaseConstructor PurchaseConstructor = Cosmetics.PurchaseConstructor;
    public HashMap<Player, String> purchaseItem = Cosmetics.purchaseItem;
    public HashMap<Player, Integer> purchasePrice = Cosmetics.purchasePrice;
    
    private Cosmetics plugin;

    public DisguiseGuiListeners(Cosmetics b) {
        plugin = b;
    }
    
    public static RemoveEffects RemoveEffects = new RemoveEffects();
    
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
        if (!event.getInventory().equals(disguisegui.inv))
            return;
        if (event.getCurrentItem() == null) return;
        if (event.getCurrentItem().getItemMeta() == null) return;
        if (event.getCurrentItem().getItemMeta().getDisplayName() == null) return;
        
        event.setCancelled(true);
        
        Player player = (Player) event.getWhoClicked();
        
        // Remove Active Cosmetics when selecting new Disguise
        if (event.getSlot() < 35) {
            RemoveEffects.ClearEffects(player);
        }
        
        //Add Bee Disguise
        if (event.getSlot() == 10) {
            DisguiseEquip(player, EntityType.BEE, 100, "Bee Disguise");
        }
        
        //Add Blaze Disguise
        if (event.getSlot() == 11) {
            DisguiseEquip(player, EntityType.BLAZE, 100, "Blaze Disguise");
        }
        
        //Add Cat Disguise
        if (event.getSlot() == 12) {
            DisguiseEquip(player, EntityType.CAT, 100, "Cat Disguise");
        }
        
        //Add Chicken Disguise
        if (event.getSlot() == 13) {
            DisguiseEquip(player, EntityType.CHICKEN, 100, "Chicken Disguise");
        }
        
        //Add Cow Disguise
        if (event.getSlot() == 14) {
            DisguiseEquip(player, EntityType.COW, 100, "Cow Disguise");
        }
        
        //Add Creeper Disguise
        if (event.getSlot() == 15) {
            DisguiseEquip(player, EntityType.CREEPER, 100, "Creeper Disguise");
        }
        
        //Add Dolphin Disguise
        if (event.getSlot() == 16) {
            DisguiseEquip(player, EntityType.DOLPHIN, 100, "Dolphin Disguise");
        }

        //Add Donkey Disguise
        if (event.getSlot() == 19) {
            DisguiseEquip(player, EntityType.DONKEY, 100, "Donkey Disguise");
        }
        
        //Add Drowned Disguise
        if (event.getSlot() == 20) {
            DisguiseEquip(player, EntityType.DROWNED, 100, "Drowned Disguise");
        }
        
        //Add Enderman Disguise
        if (event.getSlot() == 21) {
            DisguiseEquip(player, EntityType.ENDERMAN, 100, "Enderman Disguise");
        }
        
        //Add Endermite Disguise
        if (event.getSlot() == 22) {
            DisguiseEquip(player, EntityType.ENDERMITE, 100, "Endermite Disguise");
        }
        
        //Add Evoker Disguise
        if (event.getSlot() == 23) {
            DisguiseEquip(player, EntityType.EVOKER, 100, "Evoker Disguise");
        }
        
        //Add Fox Disguise
        if (event.getSlot() == 24) {
            DisguiseEquip(player, EntityType.FOX, 100, "Fox Disguise");
        }
        
        //Add Guardian Disguise
        if (event.getSlot() == 25) {
            DisguiseEquip(player, EntityType.GUARDIAN, 100, "Guardian Disguise");
        }
        
        //Add Hoglin Disguise
        if (event.getSlot() == 28) {
            DisguiseEquip(player, EntityType.HOGLIN, 100, "Hoglin Disguise");
        }
        
        //Add Horse Disguise
        if (event.getSlot() == 29) {
            DisguiseEquip(player, EntityType.HORSE, 100, "Horse Disguise");
        }
        
        //Add Husk Disguise
        if (event.getSlot() == 30) {
            DisguiseEquip(player, EntityType.HUSK, 100, "Husk Disguise");
        }
        
        //Add Llama Disguise
        if (event.getSlot() == 31) {
            DisguiseEquip(player, EntityType.LLAMA, 100, "Llama Disguise");
        }
        
        //Add Magma Cube Disguise
        if (event.getSlot() == 32) {
            DisguiseEquip(player, EntityType.MAGMA_CUBE, 100, "Magma Cube Disguise");
        }
        
        //Add Ocelot Disguise
        if (event.getSlot() == 33) {
            DisguiseEquip(player, EntityType.OCELOT, 100, "Ocelot Disguise");
        }
        
        //Add Panda Disguise
        if (event.getSlot() == 34) {
            DisguiseEquip(player, EntityType.PANDA, 100, "Panda Disguise");
        }
        
        // Return to cosmetic window
        if (event.getSlot() == 39) {
            plugin.getServer().getScheduler().runTask(plugin, () -> {
                player.openInventory(maingui.inv);
            });
        }
        
        // Next Page
        if (event.getSlot() == 41) {
            disguisegui2.ExampleGui(player);
            plugin.getServer().getScheduler().runTask(plugin, () -> {
                player.openInventory(disguisegui2.inv);
            });
        }
        
        // Remove Disguise Option
        if (event.getSlot() == 40) {
            RemoveEffects.ClearEffects(player);
        }
        
        player.closeInventory();
    }
    
    
    //////
    //Clicking Inside the main Main Gui
    @EventHandler()
    public void onDisguiseGui2Click(InventoryClickEvent event) {
        if (!event.getInventory().equals(disguisegui2.inv))
            return;
        if (event.getCurrentItem() == null) return;
        if (event.getCurrentItem().getItemMeta() == null) return;
        if (event.getCurrentItem().getItemMeta().getDisplayName() == null) return;
        
        event.setCancelled(true);
        
        Player player = (Player) event.getWhoClicked();
        
        // Remove Active Cosmetics when selecting new Disguise
        if (event.getSlot() < 35) {
            RemoveEffects.ClearEffects(player);
        }
        
        //Add Parrot Disguise
        if (event.getSlot() == 10) {
            DisguiseEquip(player, EntityType.PARROT, 100, "Parrot Disguise");
        }
        
        //Add Pig Disguise
        if (event.getSlot() == 11) {
            DisguiseEquip(player, EntityType.PIG, 100, "Pig Disguise");
        }
        
        //Add Piglin Disguise
        if (event.getSlot() == 12) {
            DisguiseEquip(player, EntityType.PIGLIN, 100, "Piglin Disguise");
        }
        
        //Add Pillager Disguise
        if (event.getSlot() == 13) {
            DisguiseEquip(player, EntityType.PILLAGER, 100, "Pillager Disguise");
        }
        
        //Add Polar Bear Disguise
        if (event.getSlot() == 14) {
            DisguiseEquip(player, EntityType.POLAR_BEAR, 100, "Polar Bear Disguise");
        }
        
        //Add Rabbit Disguise
        if (event.getSlot() == 15) {
            DisguiseEquip(player, EntityType.RABBIT, 100, "Rabbit Disguise");
        }
        
        //Add Sheep Disguise
        if (event.getSlot() == 16) {
            DisguiseEquip(player, EntityType.SHEEP, 100, "Sheep Disguise");
        }

        //Add Silverfish Disguise
        if (event.getSlot() == 19) {
            DisguiseEquip(player, EntityType.SILVERFISH, 100, "Silverfish Disguise");
        }
        
        //Add Skeleton Disguise
        if (event.getSlot() == 20) {
            DisguiseEquip(player, EntityType.SKELETON, 100, "Skeleton Disguise");
        }
        
        //Add Slime Disguise
        if (event.getSlot() == 21) {
            DisguiseEquip(player, EntityType.SLIME, 100, "Slime Disguise");
        }
        
        //Add Spider Disguise
        if (event.getSlot() == 22) {
            DisguiseEquip(player, EntityType.SPIDER, 100, "Spider Disguise");
        }
        
        //Add Stray Disguise
        if (event.getSlot() == 23) {
            DisguiseEquip(player, EntityType.STRAY, 100, "Stray Disguise");
        }
        
        //Add Strider Disguise
        if (event.getSlot() == 24) {
            DisguiseEquip(player, EntityType.STRIDER, 100, "Strider Disguise");
        }
        
        //Add Turtle Disguise
        if (event.getSlot() == 25) {
            DisguiseEquip(player, EntityType.TURTLE, 100, "Turtle Disguise");
        }
        
        //Add Vindicator Disguise
        if (event.getSlot() == 28) {
            DisguiseEquip(player, EntityType.VINDICATOR, 100, "Vindicator Disguise");
        }
        
        //Add Witch Disguise
        if (event.getSlot() == 29) {
            DisguiseEquip(player, EntityType.WITCH, 100, "Witch Disguise");
        }
        
        //Add Wither Skeleton Disguise
        if (event.getSlot() == 30) {
            DisguiseEquip(player, EntityType.WITHER_SKELETON, 100, "Wither Skeleton Disguise");
        }
        
        //Add Wolf Disguise
        if (event.getSlot() == 31) {
            DisguiseEquip(player, EntityType.WOLF, 100, "Wolf Disguise");
        }
        
        //Add Zoglin Disguise
        if (event.getSlot() == 32) {
            DisguiseEquip(player, EntityType.ZOGLIN, 100, "Zoglin Disguise");
        }
        
        //Add Zombie Disguise
        if (event.getSlot() == 33) {
            DisguiseEquip(player, EntityType.ZOMBIE, 100, "Zombie Disguise");
        }

        
        // Previous Page
        if (event.getSlot() == 39) {
            plugin.getServer().getScheduler().runTask(plugin, () -> {
                player.openInventory(disguisegui.inv);
            });
        }
        
        // Next Page
        if (event.getSlot() == 41) {
            disguisegui2.ExampleGui(player);
            plugin.getServer().getScheduler().runTask(plugin, () -> {
                player.openInventory(disguisegui2.inv);
            });
        }
        
        // Remove Disguise Option
        if (event.getSlot() == 40) {
            RemoveEffects.ClearEffects(player);
        }
        
        player.closeInventory();
    }
    
    
}