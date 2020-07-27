package cosmetics;

import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

public class PurchaseConstructor {
    
    private Cosmetics plugin;

    public PurchaseConstructor(Cosmetics b) {
        plugin = b;
    }

    public void purchaseGui(Player player, String item, int price) {
        
//        System.out.println("plugin = " + plugin);
//        System.out.println("dataSlime = " + plugin.dataSlime);
//        System.out.println("player = " + player);
//        System.out.println("GUI = " + purchasegui);
        
        if (plugin.dataSlime.getSlime(player.getUniqueId()) >= price) {
            plugin.getServer().getScheduler().runTask(plugin, () -> {
                player.openInventory(new PurchaseGui(item).getInventory());
            });
        }
        else {
            player.sendMessage(ChatColor.RED + "You do not have enough Slime to buy this item!");
            player.sendMessage(ChatColor.AQUA + "Buy more Slime at: " + ChatColor.GOLD + ChatColor.BOLD + "http://justminecraft.buycraft.net/");
        }
    }
    
    public void purchaseFinal(Player player, String item, int price) {
      
        if (plugin.dataSlime.getSlime(player.getUniqueId()) >= price) {
            plugin.dataCosmetics.addItem(player, player.getUniqueId(), item);
            plugin.dataSlime.addSlime(player.getUniqueId(), -price);
            
            player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 5, 10);
            player.sendMessage("" + ChatColor.RED + ChatColor.UNDERLINE + item + ChatColor.GOLD + " can now be Equipped!");
            player.sendMessage(ChatColor.GOLD + "You have " + ChatColor.GREEN 
                    + ChatColor.UNDERLINE + plugin.dataSlime.getSlime(player.getUniqueId()) + ChatColor.GOLD + " Slime");
        }
        
        else {
            player.sendMessage(ChatColor.RED + "You do not have enough Slime to complete this transaction!");
            player.sendMessage(ChatColor.AQUA + "Buy more Slime at: " + ChatColor.GOLD + ChatColor.BOLD + "http://justminecraft.buycraft.net/");
        }
  }
    
}