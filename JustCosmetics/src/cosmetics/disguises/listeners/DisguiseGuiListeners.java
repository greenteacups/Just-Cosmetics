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

public class DisguiseGuiListeners implements Listener {

    public CosmeticGui maingui = Cosmetics.maingui;
    public DisguiseGui disguisegui = Cosmetics.disguisegui;
    
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
        
        //Add Cow Disguise
        if (event.getSlot() == 10) {
            DisguiseEquip(player, EntityType.COW, 100, "Cow Disguise");
        }
        
        //Add Slime Disguise
        if (event.getSlot() == 11) {
            DisguiseEquip(player, EntityType.SLIME, 100, "Slime Disguise");
        }
        
        //Add Pig Disguise
        if (event.getSlot() == 12) {
            DisguiseEquip(player, EntityType.PIG, 100, "Pig Disguise");
        }
        
        //Add Chicken Disguise
        if (event.getSlot() == 13) {
            DisguiseEquip(player, EntityType.CHICKEN, 100, "Chicken Disguise");
        }
        
        // Return to cosmetic window
        if (event.getSlot() == 39) {
            plugin.getServer().getScheduler().runTask(plugin, () -> {
                player.openInventory(maingui.inv);
            });
        }
        
        // Remove Disguise Option
        if (event.getSlot() == 40) {
            RemoveEffects.ClearEffects(player);
        }
        
        player.closeInventory();
    }
    
    
}