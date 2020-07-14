package cosmetics;

import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffectType;

import cosmetics.disguises.listeners.DisguiseGuiListeners;
import cosmetics.gadgets.listeners.GadgetGuiListeners;
import cosmetics.pets.listeners.PetGuiListeners;

public class RemoveEffects {

    public void ClearEffects(Player player) {

        if (DisguiseGuiListeners.currentDisguise.containsKey(player)) {
            player.removePotionEffect(PotionEffectType.INVISIBILITY);
            DisguiseGuiListeners.currentDisguise.get(player).remove();
            DisguiseGuiListeners.currentDisguise.remove(player);
        }

        
        if (PetGuiListeners.currentPet.containsKey(player)) {
            PetGuiListeners.currentPet.get(player).remove();
            PetGuiListeners.currentPet.remove(player);
        }
        
        if (GadgetGuiListeners.shellMap.containsKey(player)) {
            player.getInventory().setItem(8, null);
            for (int i = 0; i <= 2; i++) {
                GadgetGuiListeners.shellMap.get(player).get(i).remove();
            }
            GadgetGuiListeners.shellMap.remove(player);
        }
        
        if (GadgetGuiListeners.parrotMap.containsKey(player)) {
            player.getInventory().setItem(8, null);
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
        return;
    }
}
