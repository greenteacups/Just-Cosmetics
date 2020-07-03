package cosmetics;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import cosmetics.disguises.DisguiseGui;
import cosmetics.disguises.listeners.DisguiseGeneralListeners;
import cosmetics.disguises.listeners.DisguiseGuiListeners;
import cosmetics.gadgets.GadgetGui;
import cosmetics.gadgets.listeners.GadgetGeneralListeners;
import cosmetics.gadgets.listeners.GadgetGuiListeners;
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

    public static TestRunnable test = new TestRunnable();
    
    @Override
    public void onEnable() {
        
        petgui.ExampleGui(); //Adds main pet gui P1/2
        petgui2.ExampleGui(); //Adds main pet gui P2/2
        colourgui.ExampleGui(); //Adds Adult sheep colour select gui
        babycolourgui.ExampleGui(); //Add Baby sheep colour select gui
        
        disguisegui.ExampleGui();
        
        gadgetgui.ExampleGui();
        
        this.getServer().getPluginManager().registerEvents(new CosmeticGuiListeners(this), this); //Main Cosmetic menu listeners
        this.getServer().getPluginManager().registerEvents(new PetGeneralListeners(this), this); //General Pet listeners
        this.getServer().getPluginManager().registerEvents(new PetGuiListeners(this), this); //Pet GUI Listeners
        
        this.getServer().getPluginManager().registerEvents(new DisguiseGuiListeners(this), this); //Disguise GUI Listeners
        this.getServer().getPluginManager().registerEvents(new DisguiseGeneralListeners(), this); //General Disguise Listeners
        
        this.getServer().getPluginManager().registerEvents(new GadgetGuiListeners(this), this); //General Disguise Listeners
        this.getServer().getPluginManager().registerEvents(new GadgetGeneralListeners(), this); //General Disguise Listeners
        
        getServer().getScheduler().runTaskTimer(this, () -> {
            for (Player p : Bukkit.getOnlinePlayers()) {
                test.TestRun(p);
                test.EntityWiggle(p);
            }
        }, 1, 1);
        
    }

    @Override
    public void onDisable() {
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