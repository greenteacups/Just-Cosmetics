package cosmetics;

import java.util.HashMap;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffectType;

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

public class Cosmetics extends JavaPlugin implements Listener {
    
    public static CosmeticGui maingui = new CosmeticGui();
    
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
    
    public HashMap<Player, List<Entity>> shellMap = GadgetGuiListeners.shellMap;
    public HashMap<Player, List<Entity>> parrotMap = GadgetGuiListeners.parrotMap;
    public HashMap<Player, Long> airstrike = GadgetRunnables.airstrike;
    public HashMap<Player, Entity> airturtlelist = GadgetRunnables.airturtlelist;
    public HashMap<Player, Entity> currentDisguise = DisguiseGuiListeners.currentDisguise;
    public HashMap<Player, Entity> currentPet = PetGuiListeners.currentPet;
    
    @Override
    public void onEnable() {
        
        petgui.ExampleGui(); //Adds main pet gui P1/2
        petgui2.ExampleGui(); //Adds main pet gui P2/2
        colourgui.ExampleGui(); //Adds Adult sheep colour select gui
        babycolourgui.ExampleGui(); //Add Baby sheep colour select gui
        
        disguisegui.ExampleGui();
        
        gadgetgui.ExampleGui();
        
        particletypegui.ExampleGui();
        particletypegui2.ExampleGui();
        particlepatterngui.ExampleGui();
        
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
        
        for (Player player : Bukkit.getOnlinePlayers()) {
            
            // Remove player Pet
            if (currentPet.containsKey(player)) {
                currentPet.get(player).remove();
                currentPet.remove(player);
            }
            
            // Remove player Disguises
            if (currentDisguise.containsKey(player)) {
                player.removePotionEffect(PotionEffectType.INVISIBILITY);
                currentDisguise.get(player).remove();
                currentDisguise.remove(player);
            }
            
            // Remove Turtle Gadget
            if (shellMap.containsKey(player)) {
                for (int i = 0; i <= 2; i++) {
                    shellMap.get(player).get(i).remove();
                }
                shellMap.remove(player);
            }
            
            // Remove Parrot Gadget
            if (parrotMap.containsKey(player)) {
                for (int i = 0; i <= 2; i++) {
                    parrotMap.get(player).get(i).remove();
                }
                parrotMap.remove(player);
            }
            
            // Remove AirStrike Gadget
            if (airstrike.containsKey(player)) {
                airturtlelist.get(player).remove();
                airturtlelist.remove(player);
                airstrike.remove(player);
            }
            
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
        return false;
    }
    
}