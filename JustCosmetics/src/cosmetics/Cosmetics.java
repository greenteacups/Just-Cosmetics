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

import cosmetics.disguises.DisguiseGui;
import cosmetics.disguises.listeners.DisguiseGeneralListeners;
import cosmetics.disguises.listeners.DisguiseGuiListeners;
import cosmetics.gadgets.GadgetGui;
import cosmetics.gadgets.GadgetRunnables;
import cosmetics.gadgets.listeners.GadgetGeneralListeners;
import cosmetics.gadgets.listeners.GadgetGuiListeners;
import cosmetics.particles.ParticlePatternGui;
import cosmetics.particles.ParticleRunnable;
import cosmetics.particles.ParticleTypeGui;
import cosmetics.particles.ParticleTypeGui2;
import cosmetics.particles.listeners.ParticleGuiListeners;
import cosmetics.pets.BabySheepColourGUI;
import cosmetics.pets.PetGui;
import cosmetics.pets.PetGui2;
import cosmetics.pets.SheepColourGUI;
import cosmetics.pets.listeners.PetGeneralListeners;
import cosmetics.pets.listeners.PetGuiListeners;
import cosmetics.sql.MySQL;
import cosmetics.sql.SQLGetterCosmetics;
import cosmetics.sql.SQLGetterSlime;
import cosmetics.sql.SQLListeners;

public class Cosmetics extends JavaPlugin implements Listener {
    
    public MySQL SQL;
    public SQLGetterSlime dataSlime;
    public SQLGetterCosmetics dataCosmetics;
    
    public static CosmeticGui maingui = new CosmeticGui();
    
    public static RemoveEffects RemoveEffects = new RemoveEffects();
    
    public static PurchaseGui purchasegui = new PurchaseGui();
    public static PurchaseConstructor PurchaseConstructor;
    public static HashMap<Player, String> purchaseItem = new HashMap<>();
    public static HashMap<Player, Integer> purchasePrice = new HashMap<>();
    
    public static PetGui petgui;
    public static PetGui2 petgui2;
    public static SheepColourGUI colourgui;
    public static BabySheepColourGUI babycolourgui;
    
    public static DisguiseGui disguisegui;
    
    public static GadgetGui gadgetgui;
    
    public static ParticleTypeGui particletypegui;
    public static ParticleTypeGui2 particletypegui2;
    public static ParticlePatternGui particlepatterngui;

    public static TestRunnable test = new TestRunnable();
    public static GadgetRunnables shellspin = new GadgetRunnables();
    public static ParticleRunnable PlayerRunnable = new ParticleRunnable();
    
    @Override
    public void onEnable() {
        
        this.SQL = new MySQL();
        this.dataSlime = new SQLGetterSlime(this);
        this.dataCosmetics = new SQLGetterCosmetics(this);
        
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
            this.getServer().getPluginManager().registerEvents(this, this);
        }
    
        PurchaseConstructor = new PurchaseConstructor(this); //Purchase Constructor*
        
        petgui = new PetGui(this); //Adds main pet gui P1/2
        petgui2 = new PetGui2(this); //Adds main pet gui P2/2
        colourgui = new SheepColourGUI(this); //Adds Adult sheep colour select gui
        babycolourgui = new BabySheepColourGUI(this); //Add Baby sheep colour select gui
        
        disguisegui = new DisguiseGui(this);
        
        gadgetgui = new GadgetGui(this);
        
        particletypegui = new ParticleTypeGui(this);
        particletypegui2 = new ParticleTypeGui2(this);
        particlepatterngui = new ParticlePatternGui(this);
        
        this.getServer().getPluginManager().registerEvents(new SQLListeners(this), this); //Enable SQL Listeners
        
        this.getServer().getPluginManager().registerEvents(new CosmeticGuiListeners(this), this); //Main Cosmetic menu listeners
        this.getServer().getPluginManager().registerEvents(new PetGeneralListeners(this), this); //General Pet listeners
        this.getServer().getPluginManager().registerEvents(new PetGuiListeners(this), this); //Pet GUI Listeners
        
        this.getServer().getPluginManager().registerEvents(new DisguiseGuiListeners(this), this); //Disguise GUI Listeners
        this.getServer().getPluginManager().registerEvents(new DisguiseGeneralListeners(), this); //General Disguise Listeners
        
        this.getServer().getPluginManager().registerEvents(new GadgetGuiListeners(this), this); //General Disguise Listeners
        this.getServer().getPluginManager().registerEvents(new GadgetGeneralListeners(this), this); //General Disguise Listeners
        
        this.getServer().getPluginManager().registerEvents(new ParticleGuiListeners(this), this); //Particle GUI Listeners
        
        this.getServer().getPluginManager().registerEvents(new PurchaseGuiListeners(this), this); //Purchase Gui Listeners
        
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
        }, 1, 40);
        
    }

    @Override
    public void onDisable() {
        
        SQL.disconnect();
        
        for (Player player : Bukkit.getOnlinePlayers()) {
            RemoveEffects.ClearEffects(player);
        }
        
    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        
        if (label.equalsIgnoreCase("cosmetic")) {
            if (!(sender instanceof Player)) {
                sender.sendMessage("Console cannot run this command!");
                return true;
            }
            Player player = (Player) sender;
            maingui.ExampleGui(player);
            
            // open the GUI
            player.openInventory(maingui.inv);
            return true;
        }
        
        if (label.equalsIgnoreCase("slime")) {
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
            
            if (args[0].equalsIgnoreCase("add")) {
                dataSlime.addSlime(player.getUniqueId(), Integer.parseInt(args[1]));
                player.sendMessage(ChatColor.GOLD + "You have " + ChatColor.GREEN + dataSlime.getSlime(player.getUniqueId()) 
                + ChatColor.GOLD + " Slime");
                return true;
            }
            
            return true;
        }

        return false;
    }
    
}