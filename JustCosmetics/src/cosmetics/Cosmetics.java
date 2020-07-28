package cosmetics;

import java.sql.SQLException;
import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import cosmetics.disguises.listeners.DisguiseGeneralListeners;
import cosmetics.disguises.listeners.DisguiseGuiListeners;
import cosmetics.gadgets.GadgetRunnables;
import cosmetics.gadgets.listeners.GadgetGeneralListeners;
import cosmetics.gadgets.listeners.GadgetGuiListeners;
import cosmetics.particles.ParticleRunnable;
import cosmetics.particles.listeners.ParticleGeneralListeners;
import cosmetics.particles.listeners.ParticleGuiListeners;
import cosmetics.pets.listeners.PetGeneralListeners;
import cosmetics.pets.listeners.PetGuiListeners;
import cosmetics.sql.MySQL;
import cosmetics.sql.SQLGetterCosmetics;
import cosmetics.sql.SQLGetterParticles;
import cosmetics.sql.SQLGetterSlime;
import cosmetics.sql.SQLListeners;
import cosmetics.trails.TrailsConstructor;
import cosmetics.trails.TrailsGuiListeners;

public class Cosmetics extends JavaPlugin implements Listener {
    
    public MySQL SQL;
    public SQLGetterSlime dataSlime;
    public SQLGetterCosmetics dataCosmetics;
    public SQLGetterParticles dataParticles;
    
    public static RemoveEffects RemoveEffects = new RemoveEffects();
    
    public static PurchaseConstructor PurchaseConstructor;
    public static HashMap<Player, String> purchaseItem = new HashMap<>();
    public static HashMap<Player, Integer> purchasePrice = new HashMap<>();

    public static TestRunnable test = new TestRunnable();
    public static GadgetRunnables shellspin = new GadgetRunnables();
    public static ParticleRunnable PlayerRunnable = new ParticleRunnable();
    
    @Override
    public void onEnable() {
        
        this.saveDefaultConfig();
        this.SQL = new MySQL(this);
        this.dataSlime = new SQLGetterSlime(this);
        this.dataCosmetics = new SQLGetterCosmetics(this);
        this.dataParticles = new SQLGetterParticles(this);
        
        try {
            SQL.connect();
        } catch (ClassNotFoundException | SQLException e) {
            //e.printStackTrace();
            // ^ Login info is incorrect or not using a database
            Bukkit.getLogger().info("Database not connected");
        }
        
        if (SQL.isConnected()) {
            Bukkit.getLogger().info("Database is connected!");
            dataSlime.createTable();
            dataCosmetics.createTable();
            dataParticles.createTable();
            this.getServer().getPluginManager().registerEvents(this, this);
        }
    
        PurchaseConstructor = new PurchaseConstructor(this); //Purchase Constructor*
        
        this.getServer().getPluginManager().registerEvents(new SQLListeners(this), this); //Enable SQL Listeners
        
        this.getServer().getPluginManager().registerEvents(new CosmeticGuiListeners(this), this); //Main Cosmetic menu listeners
        this.getServer().getPluginManager().registerEvents(new PetGeneralListeners(this), this); //General Pet listeners
        this.getServer().getPluginManager().registerEvents(new PetGuiListeners(this), this); //Pet GUI Listeners
        
        this.getServer().getPluginManager().registerEvents(new DisguiseGuiListeners(this), this); //Disguise GUI Listeners
        this.getServer().getPluginManager().registerEvents(new DisguiseGeneralListeners(this), this); //General Disguise Listeners
        
        this.getServer().getPluginManager().registerEvents(new GadgetGuiListeners(this), this); //General Disguise Listeners
        this.getServer().getPluginManager().registerEvents(new GadgetGeneralListeners(this), this); //General Disguise Listeners
        
        this.getServer().getPluginManager().registerEvents(new ParticleGuiListeners(this), this); //Particle GUI Listeners
        this.getServer().getPluginManager().registerEvents(new ParticleGeneralListeners(this), this); //Particle General Listeners
        
        this.getServer().getPluginManager().registerEvents(new PurchaseGuiListeners(this), this); //Purchase Gui Listeners
        
        this.getServer().getPluginManager().registerEvents(new TrailsGuiListeners(this), this); //
        this.getServer().getPluginManager().registerEvents(new TrailsConstructor(), this); //

        try { // Paper only
            this.getServer().getPluginManager().registerEvents(new PaperListener(this), this);
        } catch (Exception ignored) {}
        
        getServer().getScheduler().runTaskTimer(this, () -> {
            for (Player p : Bukkit.getOnlinePlayers()) {
                //test.TestRun(p);
                ParticleRunnable.RunParticle(p);
                shellspin.SpinRunnable(p);
            }
        }, 1, 1);
        
        getServer().getScheduler().runTaskTimer(this, () -> {
            for (Player p : Bukkit.getOnlinePlayers()) {
                ParticleRunnable.RunParticleSlow(p);
            }
        }, 1, 30);
        
    }

    @Override
    public void onDisable() {
        
        SQL.disconnect();
        
        for (Player player : Bukkit.getOnlinePlayers()) {
            RemoveEffects.ClearEffects(player);
        }
        
    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        
        if (cmd.getName().equalsIgnoreCase("cosmetic")) {
            if (!(sender instanceof Player)) {
                sender.sendMessage("Console cannot run this command!");
                return true;
            }
            Player player = (Player) sender;
            
            // open the GUI
            player.openInventory(new CosmeticGui(this, player).getInventory());
            return true;
        }
        
        if (cmd.getName().equalsIgnoreCase("slime")) {
            if (!(sender instanceof Player)) {
                sender.sendMessage("Console cannot run this command!");
                return true;
            }
            Player player = (Player) sender;

            if (args.length == 0) {
                player.sendMessage(ChatColor.GOLD + "You have " + ChatColor.GREEN + dataSlime.getSlime(player.getUniqueId()) 
                    + ChatColor.GOLD + " Slime");
                return true;
            }
            
            if (args[0].equalsIgnoreCase("balance")) {
                try { 
                    if (args.length == 1) {
                        player.sendMessage(ChatColor.GOLD + "You have " + ChatColor.GREEN + dataSlime.getSlime(player.getUniqueId()) 
                        + ChatColor.GOLD + " Slime");
                    }
                    
                    if (args.length == 2) {
                        try {
                            player.sendMessage(ChatColor.GOLD + "" + Bukkit.getPlayer(args[1]).getDisplayName() + " has " 
                                    + ChatColor.GREEN + dataSlime.getSlime(Bukkit.getPlayer(args[1]).getUniqueId()) 
                                    + ChatColor.GOLD + " Slime"); 
                        } catch (NullPointerException exception) { player.sendMessage(ChatColor.RED + args[1].toString() + " is not online!"); }
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
                        dataSlime.addSlime(player.getUniqueId(), Integer.parseInt(args[1]));
                        player.sendMessage(ChatColor.GOLD + "You have " + ChatColor.GREEN + dataSlime.getSlime(player.getUniqueId()) 
                        + ChatColor.GOLD + " Slime"); 
                    }
                    
                    if (args.length == 3) {
                        try {
                            dataSlime.addSlime(Bukkit.getPlayer(args[2]).getUniqueId(), Integer.parseInt(args[1]));
                            player.sendMessage(ChatColor.GOLD + "" + Bukkit.getPlayer(args[2]).getDisplayName() + " has " 
                            + ChatColor.GREEN + dataSlime.getSlime(Bukkit.getPlayer(args[2]).getUniqueId()) 
                            + ChatColor.GOLD + " Slime"); 
                        } catch (NullPointerException exception) { player.sendMessage(ChatColor.RED + args[2].toString() + " is not online!"); }
                    } 
                } catch (NumberFormatException exception) { player.sendMessage(ChatColor.RED + "/slime add <amount> <player>"); }
                
                return true;
            }
            
            return true;
        }

        return false;
    }
    
}