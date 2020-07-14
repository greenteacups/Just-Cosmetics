package cosmetics;

import java.sql.SQLException;

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
import cosmetics.sql.SQLGetter;
import cosmetics.sql.SQLListeners;

public class Cosmetics extends JavaPlugin implements Listener {
    
    public MySQL SQL;
    public SQLGetter data;
    
    public static CosmeticGui maingui = new CosmeticGui();
    
    public static RemoveEffects RemoveEffects = new RemoveEffects();
    
    public static PetGui petgui = new PetGui();
    public static PetGui2 petgui2 = new PetGui2();
    public static SheepColourGUI colourgui = new SheepColourGUI();
    public static BabySheepColourGUI babycolourgui = new BabySheepColourGUI();
    
    public static DisguiseGui disguisegui = new DisguiseGui();
    
    public static GadgetGui gadgetgui = new GadgetGui();
    
    public static ParticleTypeGui particletypegui = new ParticleTypeGui();
    public static ParticleTypeGui2 particletypegui2 = new ParticleTypeGui2();
    public static ParticlePatternGui particlepatterngui = new ParticlePatternGui();

    public static TestRunnable test = new TestRunnable();
    public static GadgetRunnables shellspin = new GadgetRunnables();
    public static ParticleRunnable PlayerRunnable = new ParticleRunnable();
    
    @Override
    public void onEnable() {
        
        this.SQL = new MySQL();
        this.data = new SQLGetter(this);
        
        try {
            SQL.connect();
        } catch (ClassNotFoundException | SQLException e) {
            //e.printStackTrace();
            // ^ Login info is incorrect or not using a database
            Bukkit.getLogger().info("Database not connected");
        }
        
        if (SQL.isConnected()) {
            Bukkit.getLogger().info("Database is connected!");
            data.createTable();
            this.getServer().getPluginManager().registerEvents(this, this);
        }
    
        
        petgui.ExampleGui(); //Adds main pet gui P1/2
        petgui2.ExampleGui(); //Adds main pet gui P2/2
        colourgui.ExampleGui(); //Adds Adult sheep colour select gui
        babycolourgui.ExampleGui(); //Add Baby sheep colour select gui
        
        disguisegui.ExampleGui();
        
        gadgetgui.ExampleGui();
        
        particletypegui.ExampleGui();
        particletypegui2.ExampleGui();
        particlepatterngui.ExampleGui();
        
        this.getServer().getPluginManager().registerEvents(new SQLListeners(this), this); //Enable SQL Listeners
        
        this.getServer().getPluginManager().registerEvents(new CosmeticGuiListeners(this), this); //Main Cosmetic menu listeners
        this.getServer().getPluginManager().registerEvents(new PetGeneralListeners(this), this); //General Pet listeners
        this.getServer().getPluginManager().registerEvents(new PetGuiListeners(this), this); //Pet GUI Listeners
        
        this.getServer().getPluginManager().registerEvents(new DisguiseGuiListeners(this), this); //Disguise GUI Listeners
        this.getServer().getPluginManager().registerEvents(new DisguiseGeneralListeners(), this); //General Disguise Listeners
        
        this.getServer().getPluginManager().registerEvents(new GadgetGuiListeners(this), this); //General Disguise Listeners
        this.getServer().getPluginManager().registerEvents(new GadgetGeneralListeners(this), this); //General Disguise Listeners
        
        this.getServer().getPluginManager().registerEvents(new ParticleGuiListeners(this), this); //Particle GUI Listeners
        
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
                player.sendMessage(ChatColor.GOLD + "You have " + ChatColor.GREEN + data.getSlime(player.getUniqueId()) 
                    + ChatColor.GOLD + " slime");
                return true;
            }
            
            if (args[0].equalsIgnoreCase("add")) {
                data.addSlime(player.getUniqueId(), Integer.parseInt(args[1]));
                player.sendMessage(ChatColor.GOLD + "You have " + ChatColor.GREEN + data.getSlime(player.getUniqueId()) 
                + ChatColor.GOLD + " slime");
                return true;
            }
            
            return true;
        }
        return false;
    }
    
}