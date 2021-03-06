package cosmetics.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import cosmetics.Cosmetics;

public class SlimeCommand implements CommandExecutor {
    
    private final Cosmetics plugin;
    public SlimeCommand(Cosmetics b) {
        this.plugin = b;
    }
    
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
            
            if (cmd.getName().equalsIgnoreCase("slime")) {
                if (!(sender instanceof Player)) {
                    sender.sendMessage("Console cannot run this command!");
                    return true;
                }
                Player player = (Player) sender;
    
                if (args.length == 0) {
                    player.sendMessage(ChatColor.GOLD + "You have " + ChatColor.GREEN + plugin.dataSlime.getSlime(player.getUniqueId()) 
                        + ChatColor.GOLD + " Slime");
                    return true;
                }
                
                if (args[0].equalsIgnoreCase("balance")) {
                    try { 
                        if (args.length == 1) {
                            player.sendMessage(ChatColor.GOLD + "You have " + ChatColor.GREEN + plugin.dataSlime.getSlime(player.getUniqueId()) 
                            + ChatColor.GOLD + " Slime");
                        }
                        
                        if (args.length == 2) {
                            try {
                                player.sendMessage(ChatColor.GOLD + "" + Bukkit.getPlayer(args[1]).getDisplayName() + " has " 
                                        + ChatColor.GREEN + plugin.dataSlime.getSlime(Bukkit.getPlayer(args[1]).getUniqueId()) 
                                        + ChatColor.GOLD + " Slime"); 
                            } catch (NullPointerException exception) { player.sendMessage(ChatColor.RED + args[1] + " is not online!"); }
                        } 
                    } catch (NumberFormatException exception) { player.sendMessage(ChatColor.RED + "/slime balance <player>"); }
                    
                    return true;
                }
                
                if (args[0].equalsIgnoreCase("add")) {
                    try { 
                        if (args.length == 1) {
                            player.sendMessage(ChatColor.RED + "/slime add <amount> <player>");
                        }
                        
                        if (args.length == 2) {
                            plugin.dataSlime.addSlime(player.getUniqueId(), Integer.parseInt(args[1]));
                            player.sendMessage(ChatColor.GOLD + "You have " + ChatColor.GREEN + plugin.dataSlime.getSlime(player.getUniqueId()) 
                            + ChatColor.GOLD + " Slime"); 
                        }
                        
                        if (args.length == 3) {
                            try {
                                plugin.dataSlime.addSlime(Bukkit.getPlayer(args[2]).getUniqueId(), Integer.parseInt(args[1]));
                                player.sendMessage(ChatColor.GOLD + "" + Bukkit.getPlayer(args[2]).getDisplayName() + " has " 
                                + ChatColor.GREEN + plugin.dataSlime.getSlime(Bukkit.getPlayer(args[2]).getUniqueId()) 
                                + ChatColor.GOLD + " Slime"); 
                            } catch (NullPointerException exception) { player.sendMessage(ChatColor.RED + args[2] + " is not online!"); }
                        } 
                    } catch (NumberFormatException exception) { player.sendMessage(ChatColor.RED + "/slime add <amount> <player>"); }
                    
                    return true;
                }
                
                return true;
            }
    
            return false;
        }
        
    
}
