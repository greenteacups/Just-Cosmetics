package cosmetics;

import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffectType;

import cosmetics.disguises.listeners.DisguiseGuiListeners;
import cosmetics.gadgets.listeners.GadgetGuiListeners;
import cosmetics.pets.listeners.PetGuiListeners;
import cosmetics.trails.TrailsConstructor;
import cosmetics.trails.TrailsGuiListeners;

public class RemoveEffects {
    
    private final Cosmetics plugin;
    public RemoveEffects(Cosmetics b) {
        this.plugin = b;
    }

    public void ClearEffects(Player player) {

        if (DisguiseGuiListeners.currentDisguise.containsKey(player)) {
            player.removePotionEffect(PotionEffectType.INVISIBILITY);
            DisguiseGuiListeners.currentDisguise.get(player).remove();
            DisguiseGuiListeners.currentDisguise.remove(player);
        }

        
        if (PetGuiListeners.currentPet.containsKey(player)) {
            PetGuiListeners.currentPet.get(player).remove();
            PetGuiListeners.currentPet.remove(player);
            
            if (plugin.dataPets.existsPlayer(player.getUniqueId())) {
                plugin.dataPets.remove(player.getUniqueId());
            }  
        }

        
        
        if (player.getInventory().getItem(8) != null && player.getInventory().getItem(8).getItemMeta().hasLore() &&
                player.getInventory().getItem(8).getItemMeta().getDisplayName().contains("Jump Stick")) {
            player.getInventory().clear(8);
        }
        
        if (player.getInventory().getItem(8) != null && player.getInventory().getItem(8).getItemMeta().hasLore() &&
                player.getInventory().getItem(8).getItemMeta().getDisplayName().contains("Green Shell Gun")) {
            player.getInventory().clear(8);
        }
        
        if (player.getInventory().getItem(8) != null && player.getInventory().getItem(8).getItemMeta().hasLore() && 
                player.getInventory().getItem(8).getItemMeta().getDisplayName().contains("Air Strike")) {
            player.getInventory().clear(8);
        }
        
        if (player.getInventory().getItem(8) != null && player.getInventory().getItem(8).getItemMeta().hasLore() && 
                player.getInventory().getItem(8).getItemMeta().getDisplayName().contains("Firework Gadget")) {
            player.getInventory().clear(8);
        }
        
        if (GadgetGuiListeners.shellMap.containsKey(player)) {
            for (int i = 0; i <= 2; i++) {
                GadgetGuiListeners.shellMap.get(player).get(i).remove();
            }
            GadgetGuiListeners.shellMap.remove(player);
        }
        
        if (GadgetGuiListeners.parrotMap.containsKey(player)) {
            for (int i = 0; i <= 2; i++) {
                GadgetGuiListeners.parrotMap.get(player).get(i).remove();
            }
            GadgetGuiListeners.parrotMap.remove(player);
        }
        
        if (GadgetGuiListeners.airstrike.containsKey(player)) {
            GadgetGuiListeners.airturtlelist.get(player).remove();
            GadgetGuiListeners.airturtlelist.remove(player);
            GadgetGuiListeners.airstrike.remove(player);
        }
        
        if (TrailsConstructor.blockLocMap.containsKey(player)) {
            TrailsConstructor.blockLocMap.get(player).forEach(TrailsConstructor::hideBlock);
            
            TrailsConstructor.blockLocMap.remove(player);
            
            TrailsGuiListeners.trailsMap.remove(player);
            TrailsGuiListeners.trailTypeMap.remove(player);
        }

    }
}
