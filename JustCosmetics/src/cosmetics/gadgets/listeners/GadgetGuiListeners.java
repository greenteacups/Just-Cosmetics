package cosmetics.gadgets.listeners;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.bukkit.craftbukkit.v1_16_R1.CraftWorld;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import cosmetics.CosmeticGui;
import cosmetics.Cosmetics;
import cosmetics.gadgets.GadgetGui;
import cosmetics.gadgets.items.JumpStick;
import cosmetics.gadgets.items.TurtleSpawn;
import net.minecraft.server.v1_16_R1.WorldServer;

public class GadgetGuiListeners implements Listener {

    public CosmeticGui maingui = Cosmetics.maingui;
    public GadgetGui gadgetgui = Cosmetics.gadgetgui;
    private Cosmetics plugin;

    public GadgetGuiListeners(Cosmetics b) {
        plugin = b;
    }
    
    public static HashMap<Player, List<Entity>> shellMap = new HashMap<>();
    
    //////
    //Clicking Inside the main Main Gui
    @EventHandler()
    public void onPetGuiClick(InventoryClickEvent event) {
        if (!event.getInventory().equals(gadgetgui.inv))
            return;
        if (event.getCurrentItem() == null) return;
        if (event.getCurrentItem().getItemMeta() == null) return;
        if (event.getCurrentItem().getItemMeta().getDisplayName() == null) return;
        
        event.setCancelled(true);
        
        Player player = (Player) event.getWhoClicked();
        
        //Add Jump Stick Gadget
        if (event.getSlot() == 10) {
            
            JumpStick jumpstick = new JumpStick();
            
            player.getInventory().setItem(8, jumpstick.getItem());
        }
        
        //Add Shell Gadget
        if (event.getSlot() == 11) {
            
            List<Entity> shellList = new ArrayList<>();
            
            WorldServer world = ((CraftWorld) player.getWorld()).getHandle();
            
            TurtleSpawn shell1 = new TurtleSpawn(player.getLocation().add(0, 0, -2), player);
            TurtleSpawn shell2 = new TurtleSpawn(player.getLocation().add(2/Math.sqrt(2), 0, 2/Math.sqrt(2)), player);
            TurtleSpawn shell3 = new TurtleSpawn(player.getLocation().add(-2/Math.sqrt(2), 0, 2/Math.sqrt(2)), player);
            
            world.addEntity(shell1);
            world.addEntity(shell2);
            world.addEntity(shell3);
            
            shellList.add(shell1.getBukkitEntity());
            shellList.add(shell2.getBukkitEntity());
            shellList.add(shell3.getBukkitEntity());
            
            shellMap.put(player, shellList);
        }
         
        // Return to cosmetic window
        if (event.getSlot() == 39) {
            plugin.getServer().getScheduler().runTask(plugin, () -> {
                player.openInventory(maingui.inv);
            });
        }
        
        // Remove Disguise Option
        if (event.getSlot() == 40) {

        }
        
        player.closeInventory();
    }
    

}