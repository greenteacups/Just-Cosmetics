package cosmetics.disguises.listeners;

import java.util.HashMap;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.craftbukkit.v1_16_R1.CraftWorld;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import cosmetics.CosmeticGui;
import cosmetics.Cosmetics;
import cosmetics.disguises.DisguiseGui;
import cosmetics.disguises.customdisguises.CowDisguise;
import cosmetics.disguises.customdisguises.SlimeDisguise;
import cosmetics.gadgets.GadgetRunnables;
import cosmetics.gadgets.listeners.GadgetGuiListeners;
import cosmetics.pets.listeners.PetGuiListeners;
import net.minecraft.server.v1_16_R1.ChatComponentText;
import net.minecraft.server.v1_16_R1.WorldServer;

public class DisguiseGuiListeners implements Listener {

    public CosmeticGui maingui = Cosmetics.maingui;
    public DisguiseGui disguisegui = Cosmetics.disguisegui;
    private Cosmetics plugin;

    public DisguiseGuiListeners(Cosmetics b) {
        plugin = b;
    }
    
    public HashMap<Player, List<Entity>> shellMap = GadgetGuiListeners.shellMap;
    public HashMap<Player, List<Entity>> parrotMap = GadgetGuiListeners.parrotMap;
    public HashMap<Player, Long> airstrike = GadgetRunnables.airstrike;
    public HashMap<Player, Entity> airturtlelist = GadgetRunnables.airturtlelist;
    public HashMap<Player, Entity> currentPet = PetGuiListeners.currentPet;
    
    public static HashMap<Player, Entity> currentDisguise = new HashMap<>();
    
    //////
    //Clicking Inside the main Main Gui
    @EventHandler()
    public void onPetGuiClick(InventoryClickEvent event) {
        if (!event.getInventory().equals(disguisegui.inv))
            return;
        if (event.getCurrentItem() == null) return;
        if (event.getCurrentItem().getItemMeta() == null) return;
        if (event.getCurrentItem().getItemMeta().getDisplayName() == null) return;
        
        event.setCancelled(true);
        
        Player player = (Player) event.getWhoClicked();
        
        // Remove Active Cosmetics when selecting new Disguise
        if (event.getSlot() < 35) {
            if (currentDisguise.containsKey(player)) {
                currentDisguise.get(player).remove();
                currentDisguise.remove(player);
            }
            
            if (currentPet.containsKey(player)) {
                currentPet.get(player).remove();
                currentPet.remove(player);
            }
            
            if (shellMap.containsKey(player)) {
                player.getInventory().setItem(8, null);
                for (int i = 0; i <= 2; i++) {
                    shellMap.get(player).get(i).remove();
                }
                shellMap.remove(player);
            }
            
            if (parrotMap.containsKey(player)) {
                player.getInventory().setItem(8, null);
                for (int i = 0; i <= 2; i++) {
                    parrotMap.get(player).get(i).remove();
                }
                parrotMap.remove(player);
            }
            
            if (airstrike.containsKey(player)) {
                airturtlelist.get(player).remove();
                airturtlelist.remove(player);
                airstrike.remove(player);
            }
        }
        
        //Add Cow Disguise
        if (event.getSlot() == 10) {
            player.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 999999999, 1, true, true));
            
            CowDisguise disguise = new CowDisguise(player.getLocation(), player);
            disguise.setCustomName(new ChatComponentText(ChatColor.GOLD + ""  
                    + ChatColor.BOLD + player.getName() + "'s Disguise"));
            WorldServer world = ((CraftWorld) player.getWorld()).getHandle();
            world.addEntity(disguise);
            
            currentDisguise.put(player, disguise.getBukkitEntity());
        }
        
        //Add Slime Disguise
        if (event.getSlot() == 11) {
            player.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 999999999, 1, true, true));
            
            SlimeDisguise disguise = new SlimeDisguise(player.getLocation(), player);
            disguise.setCustomName(new ChatComponentText(ChatColor.GOLD + ""  
                    + ChatColor.BOLD + player.getName() + "'s Disguise"));
            WorldServer world = ((CraftWorld) player.getWorld()).getHandle();
            world.addEntity(disguise);
            
            currentDisguise.put(player, disguise.getBukkitEntity());
        }
        
        // Return to cosmetic window
        if (event.getSlot() == 39) {
            plugin.getServer().getScheduler().runTask(plugin, () -> {
                player.openInventory(maingui.inv);
            });
        }
        
        // Remove Disguise Option
        if (event.getSlot() == 40) {
            player.removePotionEffect(PotionEffectType.INVISIBILITY);
            
            if (currentDisguise.containsKey(player)) {
                currentDisguise.get(player).remove();
                currentDisguise.remove(player);
            }

        }
        
        player.closeInventory();
    }
    
    
}