package cosmetics;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

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

    @Override
    public void onEnable() {
        maingui.ExampleGui();
        petgui.ExampleGui(); //Adds main pet gui P1/2
        petgui2.ExampleGui(); //Adds main pet gui P2/2
        colourgui.ExampleGui(); //Adds Adult sheep colour select gui
        babycolourgui.ExampleGui(); //Add Baby sheep colour select gui
        
        this.getServer().getPluginManager().registerEvents(new CosmeticGuiListeners(this), this); //Main Cosmetic menu listeners
        this.getServer().getPluginManager().registerEvents(new PetGeneralListeners(this), this); //General Pet listeners
        this.getServer().getPluginManager().registerEvents(new PetGuiListeners(this), this); //Pet GUI Listeners
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
            // open the GUI
            player.openInventory(maingui.inv);
            return true;
        }
        return false;
    }
    
}