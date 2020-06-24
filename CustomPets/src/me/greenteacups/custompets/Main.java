package me.greenteacups.custompets;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import me.greenteacups.custompets.listeners.GuiListeners;
import me.greenteacups.custompets.listeners.Listeners;

public class Main extends JavaPlugin implements Listener {
    
    public static PetGui petgui = new PetGui();
    public static SheepColourGUI colourgui = new SheepColourGUI();

    @Override
    public void onEnable() {
        petgui.ExampleGui();
        colourgui.ExampleGui();
        this.getServer().getPluginManager().registerEvents(new Listeners(), this);
        this.getServer().getPluginManager().registerEvents(new GuiListeners(this), this);
    }

    @Override
    public void onDisable() {
    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        
        if (label.equalsIgnoreCase("pet")) {
            if (!(sender instanceof Player)) {
                sender.sendMessage("Console cannot run this command!");
                return true;
            }
            Player player = (Player) sender;
            // open the GUI
            player.openInventory(petgui.inv);
            return true;
        }
        return false;
    }
    
}


