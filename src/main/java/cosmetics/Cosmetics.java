package cosmetics;

import java.sql.SQLException;
import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import cosmetics.commands.CosmeticCommand;
import cosmetics.commands.PetNameCommand;
import cosmetics.commands.SlimeCommand;
import cosmetics.disguises.listeners.DisguiseGeneralListeners;
import cosmetics.disguises.listeners.DisguiseGuiListeners;
import cosmetics.gadgets.GadgetRunnables;
import cosmetics.gadgets.listeners.GadgetGeneralListeners;
import cosmetics.gadgets.listeners.GadgetGuiListeners;
import cosmetics.paper.PaperListener;
import cosmetics.particles.ParticleRunnable;
import cosmetics.particles.listeners.ParticleGeneralListeners;
import cosmetics.particles.listeners.ParticleGuiListeners;
import cosmetics.pets.PathfinderRun;
import cosmetics.pets.listeners.PetGeneralListeners;
import cosmetics.pets.listeners.PetGuiListeners;
import cosmetics.sql.MySQL;
import cosmetics.sql.SQLGetterCosmetics;
import cosmetics.sql.SQLGetterParticles;
import cosmetics.sql.SQLGetterPetNames;
import cosmetics.sql.SQLGetterPets;
import cosmetics.sql.SQLGetterSlime;
import cosmetics.sql.SQLListeners;
import cosmetics.trails.TrailsConstructor;
import cosmetics.trails.TrailsGuiListeners;

public class Cosmetics extends JavaPlugin implements Listener {
    
    public MySQL SQL;
    public SQLGetterSlime dataSlime;
    public SQLGetterCosmetics dataCosmetics;
    public SQLGetterParticles dataParticles;
    public SQLGetterPets dataPets;
    public SQLGetterPetNames dataPetNames;
    
    public RemoveEffects RemoveEffects;
    
    public static PurchaseConstructor PurchaseConstructor;
    public static HashMap<Player, String> purchaseItem = new HashMap<>();
    public static HashMap<Player, Integer> purchasePrice = new HashMap<>();

    public static TestRunnable test = new TestRunnable();
    public static GadgetRunnables shellspin = new GadgetRunnables();
    public static ParticleRunnable PlayerRunnable = new ParticleRunnable();
    public static PathfinderRun PetTeleport = new PathfinderRun();
    
    @Override
    public void onEnable() {
        
        this.saveDefaultConfig();
        this.SQL = new MySQL(this);
        this.dataSlime = new SQLGetterSlime(this);
        this.dataCosmetics = new SQLGetterCosmetics(this);
        this.dataParticles = new SQLGetterParticles(this);
        this.dataPets = new SQLGetterPets(this);
        this.dataPetNames = new SQLGetterPetNames(this);
        
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
            dataPets.createTable();
            dataPetNames.createTable();
            this.getServer().getPluginManager().registerEvents(this, this);
        }
        
        getCommand("cosmetic").setExecutor(new CosmeticCommand(this));
        getCommand("slime").setExecutor(new SlimeCommand(this));
        getCommand("petname").setExecutor(new PetNameCommand(this));
    
        PurchaseConstructor = new PurchaseConstructor(this); //Purchase Constructor*
        RemoveEffects = new RemoveEffects(this);
        
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
        
        this.getServer().getPluginManager().registerEvents(new GuiTamper(), this); //

        try { // Paper only
            this.getServer().getPluginManager().registerEvents(new PaperListener(this), this);
        } catch (Exception ignored) {}
        
        getServer().getScheduler().runTaskTimer(this, () -> {
            for (Player p : Bukkit.getOnlinePlayers()) {
                //test.TestRun(p);
                ParticleRunnable.RunParticle(p);
                shellspin.SpinRunnable(p);
                PetTeleport.PetTeleport(p);
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
    
}