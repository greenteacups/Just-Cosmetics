package cosmetics.commands;

import java.util.HashMap;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import cosmetics.CosmeticGui;
import cosmetics.Cosmetics;

public class CosmeticCommand implements CommandExecutor {
    
    private Cosmetics plugin;
    public CosmeticCommand(Cosmetics b) {
        plugin = b;
    }
    
    public static HashMap<Player, Inventory> inventorySave = new HashMap<>();
    
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
            
            if (cmd.getName().equalsIgnoreCase("cosmetic")) {
                if (!(sender instanceof Player)) {
                    sender.sendMessage("Console cannot run this command!");
                    return true;
                }
                Player player = (Player) sender;
                
                //inventorySave.put(player, player.getInventory());
                
                // open the GUI
                player.openInventory(new CosmeticGui(plugin, player).getInventory());
                return true;
            }
            return false;
    }
}
