package cosmetics;

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
import cosmetics.sql.*;
import cosmetics.trails.TrailsConstructor;
import cosmetics.trails.TrailsGuiListeners;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.SQLException;
import java.util.HashMap;

public class Cosmetics extends JavaPlugin {
    
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
        }
        
        getCommand("cosmetic").setExecutor(new CosmeticCommand(this));
        getCommand("slime").setExecutor(new SlimeCommand(this));
        getCommand("petname").setExecutor(new PetNameCommand(this));
    
        PurchaseConstructor = new PurchaseConstructor(this); //Purchase Constructor*
        RemoveEffects = new RemoveEffects(this);
        
        registerListener(new SQLListeners(this)); //Enable SQL Listeners
        
        registerListener(new CosmeticGuiListeners(this)); //Main Cosmetic menu listeners
        registerListener(new PetGeneralListeners(this)); //General Pet listeners
        registerListener(new PetGuiListeners(this)); //Pet GUI Listeners
        
        registerListener(new DisguiseGuiListeners(this)); //Disguise GUI Listeners
        registerListener(new DisguiseGeneralListeners(this)); //General Disguise Listeners
        
        registerListener(new GadgetGuiListeners(this)); //General Disguise Listeners
        registerListener(new GadgetGeneralListeners(this)); //General Disguise Listeners
        
        registerListener(new ParticleGuiListeners(this)); //Particle GUI Listeners
        registerListener(new ParticleGeneralListeners(this)); //Particle General Listeners
        
        registerListener(new PurchaseGuiListeners(this)); //Purchase Gui Listeners
        
        registerListener(new TrailsGuiListeners(this)); //
        registerListener(new TrailsConstructor()); //
        
        registerListener(new GuiTamper()); //

        try { // Paper only
            registerListener(new PaperListener(this));
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
    
    // Register a listener with the server and run any PlayerJoinEvents it has
    private void registerListener(Listener listener) {
        getServer().getPluginManager().registerEvents(listener, this);
        
        executeJoinEvent(listener);
    }

    // Execute PlayerJoinEvents for the given listener
    private void executeJoinEvent(Listener listener) {
        for (Method method : listener.getClass().getMethods()) {
            if (method.getAnnotation(EventHandler.class) != null
                    && method.getParameterCount() == 1
                    && method.getParameterTypes()[0] == PlayerJoinEvent.class) {
                invokeJoinEvent(method, listener);
            }
        }
    }

    // Call a method with a PlayerJoinEvent for each online player
    private void invokeJoinEvent(Method method, Object listener) {
        for (Player player : getServer().getOnlinePlayers()) {
            try {
                method.invoke(listener, new PlayerJoinEvent(player, null));
            } catch (IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void onDisable() {
        
        SQL.disconnect();
        
        for (Player player : Bukkit.getOnlinePlayers()) {
            RemoveEffects.ClearEffects(player);
        }
        
    }
    
}