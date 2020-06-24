package me.greenteacups.custompets.listeners;

import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.craftbukkit.v1_15_R1.CraftWorld;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryDragEvent;

import me.greenteacups.custompets.Main;
import me.greenteacups.custompets.PetGui;
import me.greenteacups.custompets.SheepColourGUI;
import me.greenteacups.custompets.pets.BeePet;
import me.greenteacups.custompets.pets.BlazePet;
import me.greenteacups.custompets.pets.ChickenPet;
import me.greenteacups.custompets.pets.CowPet;
import me.greenteacups.custompets.pets.EndermanPet;
import me.greenteacups.custompets.pets.FoxPet;
import me.greenteacups.custompets.pets.HorsePet;
import me.greenteacups.custompets.pets.LlamaPet;
import me.greenteacups.custompets.pets.MooshroomPet;
import me.greenteacups.custompets.pets.OcelotPet;
import me.greenteacups.custompets.pets.PandaPet;
import me.greenteacups.custompets.pets.PigPet;
import me.greenteacups.custompets.pets.PolarbearPet;
import me.greenteacups.custompets.pets.RabbitPet;
import me.greenteacups.custompets.pets.SheepPet;
import me.greenteacups.custompets.pets.SkeletonPet;
import me.greenteacups.custompets.pets.TurtlePet;
import me.greenteacups.custompets.pets.WitchPet;
import me.greenteacups.custompets.pets.WitherSkeletonPet;
import me.greenteacups.custompets.pets.WolfPet;
import me.greenteacups.custompets.pets.ZombiePet;
import net.minecraft.server.v1_15_R1.ChatComponentText;
import net.minecraft.server.v1_15_R1.EnumColor;
import net.minecraft.server.v1_15_R1.WorldServer;

public class GuiListeners implements Listener {

    public PetGui petgui = Main.petgui;
    public SheepColourGUI colorgui = Main.colourgui;
    private Main plugin;

    public GuiListeners(Main b) {
        plugin = b;
    }
    
    //Clicking Inside the main Pet Selector GUI Page 1/1
    @EventHandler()
    public void onPetGuiClick(InventoryClickEvent event) {
        if (!event.getInventory().equals(petgui.inv))
            return;
        if (event.getCurrentItem() == null) return;
        if (event.getCurrentItem().getItemMeta() == null) return;
        if (event.getCurrentItem().getItemMeta().getDisplayName() == null) return;
        
        event.setCancelled(true);
        
        Player player = (Player) event.getWhoClicked();
        
        // Remove Existing Pet
        List<Entity> en = player.getNearbyEntities(30, 30, 30);
        for (int i = 0; i < en.size(); i++) {
            if (en.get(i).getCustomName() != null 
                    && en.get(i).getCustomName().contains(player.getName() + "'s Pet")) {
                en.get(i).remove();
            }
        }

        //Add Llama
        if (event.getSlot() == 10) {
            LlamaPet pet = new LlamaPet(player.getLocation(), player);
            pet.setCustomName(new ChatComponentText(ChatColor.GOLD + ""  
                    + ChatColor.BOLD + player.getName() + "'s Pet"));
            WorldServer world = ((CraftWorld) player.getWorld()).getHandle();
            world.addEntity(pet);
        }
        
        //Add Pig
        if (event.getSlot() == 11) {
            PigPet pet = new PigPet(player.getLocation(), player);
            pet.setCustomName(new ChatComponentText(ChatColor.GOLD + ""  
                    + ChatColor.BOLD + player.getName() + "'s Pet"));
            WorldServer world = ((CraftWorld) player.getWorld()).getHandle();
            world.addEntity(pet);
        }
        
        //Add Chicken
        if (event.getSlot() == 12) {
            ChickenPet pet = new ChickenPet(player.getLocation(), player);
            pet.setCustomName(new ChatComponentText(ChatColor.GOLD + ""  
                    + ChatColor.BOLD + player.getName() + "'s Pet"));
            WorldServer world = ((CraftWorld) player.getWorld()).getHandle();
            world.addEntity(pet);
        }
        
        //Go to Sheep Gui
        if (event.getSlot() == 13) {
            plugin.getServer().getScheduler().runTask(plugin, () -> {
                player.openInventory(colorgui.inv);
            });
        }
        
        //Add Cow
        if (event.getSlot() == 14) {
            CowPet pet = new CowPet(player.getLocation(), player);
            pet.setCustomName(new ChatComponentText(ChatColor.GOLD + ""  
                    + ChatColor.BOLD + player.getName() + "'s Pet"));
            WorldServer world = ((CraftWorld) player.getWorld()).getHandle();
            world.addEntity(pet);
        }
        
        //Add Mooshroom
        if (event.getSlot() == 15) {
            MooshroomPet pet = new MooshroomPet(player.getLocation(), player);
            pet.setCustomName(new ChatComponentText(ChatColor.GOLD + ""  
                    + ChatColor.BOLD + player.getName() + "'s Pet"));
            WorldServer world = ((CraftWorld) player.getWorld()).getHandle();
            world.addEntity(pet);
        }
        
        //Add Fox
        if (event.getSlot() == 16) {
            FoxPet pet = new FoxPet(player.getLocation(), player);
            pet.setCustomName(new ChatComponentText(ChatColor.GOLD + ""  
                    + ChatColor.BOLD + player.getName() + "'s Pet"));
            WorldServer world = ((CraftWorld) player.getWorld()).getHandle();
            world.addEntity(pet);
        }
        
        //Add Panda
        if (event.getSlot() == 19) {
            PandaPet pet = new PandaPet(player.getLocation(), player);
            pet.setCustomName(new ChatComponentText(ChatColor.GOLD + ""  
                    + ChatColor.BOLD + player.getName() + "'s Pet"));
            WorldServer world = ((CraftWorld) player.getWorld()).getHandle();
            world.addEntity(pet);
        }
        
        //Add Wolf
        if (event.getSlot() == 20) {
            WolfPet pet = new WolfPet(player.getLocation(), player);
            pet.setCustomName(new ChatComponentText(ChatColor.GOLD + ""  
                    + ChatColor.BOLD + player.getName() + "'s Pet"));
            WorldServer world = ((CraftWorld) player.getWorld()).getHandle();
            world.addEntity(pet);
        }
        
        //Add Polar Bear
        if (event.getSlot() == 21) {
            PolarbearPet pet = new PolarbearPet(player.getLocation(), player);
            pet.setCustomName(new ChatComponentText(ChatColor.GOLD + ""  
                    + ChatColor.BOLD + player.getName() + "'s Pet"));
            WorldServer world = ((CraftWorld) player.getWorld()).getHandle();
            world.addEntity(pet);
        }
        
        //Add Rabbit
        if (event.getSlot() == 22) {
            RabbitPet pet = new RabbitPet(player.getLocation(), player);
            pet.setCustomName(new ChatComponentText(ChatColor.GOLD + ""  
                    + ChatColor.BOLD + player.getName() + "'s Pet"));
            WorldServer world = ((CraftWorld) player.getWorld()).getHandle();
            world.addEntity(pet);
        }
        
        //Add Ocelot
        if (event.getSlot() == 23) {
            OcelotPet pet = new OcelotPet(player.getLocation(), player);
            pet.setCustomName(new ChatComponentText(ChatColor.GOLD + ""  
                    + ChatColor.BOLD + player.getName() + "'s Pet"));
            WorldServer world = ((CraftWorld) player.getWorld()).getHandle();
            world.addEntity(pet);
        }
        
        //Add Turtle
        if (event.getSlot() == 24) {
            TurtlePet pet = new TurtlePet(player.getLocation(), player);
            pet.setCustomName(new ChatComponentText(ChatColor.GOLD + ""  
                    + ChatColor.BOLD + player.getName() + "'s Pet"));
            WorldServer world = ((CraftWorld) player.getWorld()).getHandle();
            world.addEntity(pet);
        }
        
        //Add Bee
        if (event.getSlot() == 25) {
            BeePet pet = new BeePet(player.getLocation(), player);
            pet.setCustomName(new ChatComponentText(ChatColor.GOLD + ""  
                    + ChatColor.BOLD + player.getName() + "'s Pet"));
            WorldServer world = ((CraftWorld) player.getWorld()).getHandle();
            world.addEntity(pet);
        }
        
        //Add Horse
        if (event.getSlot() == 28) {
            HorsePet pet = new HorsePet(player.getLocation(), player);
            pet.setCustomName(new ChatComponentText(ChatColor.GOLD + ""  
                    + ChatColor.BOLD + player.getName() + "'s Pet"));
            WorldServer world = ((CraftWorld) player.getWorld()).getHandle();
            world.addEntity(pet);
        }
        
        //Add Blaze
        if (event.getSlot() == 29) {
            BlazePet pet = new BlazePet(player.getLocation(), player);
            pet.setCustomName(new ChatComponentText(ChatColor.GOLD + ""  
                    + ChatColor.BOLD + player.getName() + "'s Pet"));
            WorldServer world = ((CraftWorld) player.getWorld()).getHandle();
            world.addEntity(pet);
        }
        
        //Add Witch
        if (event.getSlot() == 30) {
            WitchPet pet = new WitchPet(player.getLocation(), player);
            pet.setCustomName(new ChatComponentText(ChatColor.GOLD + ""  
                    + ChatColor.BOLD + player.getName() + "'s Pet"));
            WorldServer world = ((CraftWorld) player.getWorld()).getHandle();
            world.addEntity(pet);
        }
        
        //Add Enderman
        if (event.getSlot() == 31) {
            EndermanPet pet = new EndermanPet(player.getLocation(), player);
            pet.setCustomName(new ChatComponentText(ChatColor.GOLD + ""  
                    + ChatColor.BOLD + player.getName() + "'s Pet"));
            WorldServer world = ((CraftWorld) player.getWorld()).getHandle();
            world.addEntity(pet);
        }
        
        //Add Skeleton
        if (event.getSlot() == 32) {
            SkeletonPet pet = new SkeletonPet(player.getLocation(), player);
            pet.setCustomName(new ChatComponentText(ChatColor.GOLD + ""  
                    + ChatColor.BOLD + player.getName() + "'s Pet"));
            WorldServer world = ((CraftWorld) player.getWorld()).getHandle();
            world.addEntity(pet);
        }
        
        //Add Zombie
        if (event.getSlot() == 33) {
            ZombiePet pet = new ZombiePet(player.getLocation(), player);
            pet.setCustomName(new ChatComponentText(ChatColor.GOLD + ""  
                    + ChatColor.BOLD + player.getName() + "'s Pet"));
            WorldServer world = ((CraftWorld) player.getWorld()).getHandle();
            world.addEntity(pet);
        }
        
        //Add Wither Skeleton
        if (event.getSlot() == 34) {
            WitherSkeletonPet pet = new WitherSkeletonPet(player.getLocation(), player);
            pet.setCustomName(new ChatComponentText(ChatColor.GOLD + ""  
                    + ChatColor.BOLD + player.getName() + "'s Pet"));
            WorldServer world = ((CraftWorld) player.getWorld()).getHandle();
            world.addEntity(pet);
        }
        
        // Remove Pet Option
        if (event.getSlot() == 40) {
            for (int i = 0; i < en.size(); i++) {
                if (en.get(i).getCustomName() != null 
                        && en.get(i).getCustomName().contains(player.getName() + "'s Pet")) {
                    en.get(i).remove();
                }
            }
        }
        
        player.closeInventory();
    }
    
    //Clicking Inside the main Sheep Colour Selector GUI
    @EventHandler()
    public void onSheepColourGuiClick(InventoryClickEvent event) {
        if (!event.getInventory().equals(colorgui.inv))
            return;
        if (event.getCurrentItem() == null) return;
        if (event.getCurrentItem().getItemMeta() == null) return;
        if (event.getCurrentItem().getItemMeta().getDisplayName() == null) return;
        
        event.setCancelled(true);
        
        Player player = (Player) event.getWhoClicked();
        
        // Remove Existing Pet
        List<Entity> en = player.getNearbyEntities(30, 30, 30);
        for (int i = 0; i < en.size(); i++) {
            if (en.get(i).getCustomName() != null 
                    && en.get(i).getCustomName().contains(player.getName() + "'s Pet")) {
                en.get(i).remove();
            }
        }
        
        //Add Red Sheep
        if (event.getSlot() == 10) {
            SheepPet pet = new SheepPet(player.getLocation(), player);
            pet.setCustomName(new ChatComponentText(ChatColor.GOLD + ""  
                    + ChatColor.BOLD + player.getName() + "'s Pet"));
            WorldServer world = ((CraftWorld) player.getWorld()).getHandle();
            world.addEntity(pet);
            pet.setColor(EnumColor.RED);
        }
        
        //Add Orange Sheep
        if (event.getSlot() == 11) {
            SheepPet pet = new SheepPet(player.getLocation(), player);
            pet.setCustomName(new ChatComponentText(ChatColor.GOLD + ""  
                    + ChatColor.BOLD + player.getName() + "'s Pet"));
            WorldServer world = ((CraftWorld) player.getWorld()).getHandle();
            world.addEntity(pet);
            pet.setColor(EnumColor.ORANGE);
        }
        
        //Add Yellow Sheep
        if (event.getSlot() == 12) {
            SheepPet pet = new SheepPet(player.getLocation(), player);
            pet.setCustomName(new ChatComponentText(ChatColor.GOLD + ""  
                    + ChatColor.BOLD + player.getName() + "'s Pet"));
            WorldServer world = ((CraftWorld) player.getWorld()).getHandle();
            world.addEntity(pet);
            pet.setColor(EnumColor.YELLOW);
        }
        
        //Add Green Sheep
        if (event.getSlot() == 13) {
            SheepPet pet = new SheepPet(player.getLocation(), player);
            pet.setCustomName(new ChatComponentText(ChatColor.GOLD + ""  
                    + ChatColor.BOLD + player.getName() + "'s Pet"));
            WorldServer world = ((CraftWorld) player.getWorld()).getHandle();
            world.addEntity(pet);
            pet.setColor(EnumColor.GREEN);
        }
        
        //Add Lime Sheep
        if (event.getSlot() == 14) {
            SheepPet pet = new SheepPet(player.getLocation(), player);
            pet.setCustomName(new ChatComponentText(ChatColor.GOLD + ""  
                    + ChatColor.BOLD + player.getName() + "'s Pet"));
            WorldServer world = ((CraftWorld) player.getWorld()).getHandle();
            world.addEntity(pet);
            pet.setColor(EnumColor.LIME);
        }
        
        //Add Blue Sheep
        if (event.getSlot() == 15) {
            SheepPet pet = new SheepPet(player.getLocation(), player);
            pet.setCustomName(new ChatComponentText(ChatColor.GOLD + ""  
                    + ChatColor.BOLD + player.getName() + "'s Pet"));
            WorldServer world = ((CraftWorld) player.getWorld()).getHandle();
            world.addEntity(pet);
            pet.setColor(EnumColor.BLUE);
        }
        
        //Add Cyan Sheep
        if (event.getSlot() == 16) {
            SheepPet pet = new SheepPet(player.getLocation(), player);
            pet.setCustomName(new ChatComponentText(ChatColor.GOLD + ""  
                    + ChatColor.BOLD + player.getName() + "'s Pet"));
            WorldServer world = ((CraftWorld) player.getWorld()).getHandle();
            world.addEntity(pet);
            pet.setColor(EnumColor.CYAN);
        }
        
        //Add Light Blue Sheep
        if (event.getSlot() == 19) {
            SheepPet pet = new SheepPet(player.getLocation(), player);
            pet.setCustomName(new ChatComponentText(ChatColor.GOLD + ""  
                    + ChatColor.BOLD + player.getName() + "'s Pet"));
            WorldServer world = ((CraftWorld) player.getWorld()).getHandle();
            world.addEntity(pet);
            pet.setColor(EnumColor.LIGHT_BLUE);
        }
        
        //Add Purple Sheep
        if (event.getSlot() == 20) {
            SheepPet pet = new SheepPet(player.getLocation(), player);
            pet.setCustomName(new ChatComponentText(ChatColor.GOLD + ""  
                    + ChatColor.BOLD + player.getName() + "'s Pet"));
            WorldServer world = ((CraftWorld) player.getWorld()).getHandle();
            world.addEntity(pet);
            pet.setColor(EnumColor.PURPLE);
        }
        
        //Add Magenta Sheep
        if (event.getSlot() == 21) {
            SheepPet pet = new SheepPet(player.getLocation(), player);
            pet.setCustomName(new ChatComponentText(ChatColor.GOLD + ""  
                    + ChatColor.BOLD + player.getName() + "'s Pet"));
            WorldServer world = ((CraftWorld) player.getWorld()).getHandle();
            world.addEntity(pet);
            pet.setColor(EnumColor.MAGENTA);
        }
        
        //Add Pink Sheep
        if (event.getSlot() == 22) {
            SheepPet pet = new SheepPet(player.getLocation(), player);
            pet.setCustomName(new ChatComponentText(ChatColor.GOLD + ""  
                    + ChatColor.BOLD + player.getName() + "'s Pet"));
            WorldServer world = ((CraftWorld) player.getWorld()).getHandle();
            world.addEntity(pet);
            pet.setColor(EnumColor.PINK);
        }
        
        //Add Brown Sheep
        if (event.getSlot() == 23) {
            SheepPet pet = new SheepPet(player.getLocation(), player);
            pet.setCustomName(new ChatComponentText(ChatColor.GOLD + ""  
                    + ChatColor.BOLD + player.getName() + "'s Pet"));
            WorldServer world = ((CraftWorld) player.getWorld()).getHandle();
            world.addEntity(pet);
            pet.setColor(EnumColor.BROWN);
        }
        
        //Add Black Sheep
        if (event.getSlot() == 24) {
            SheepPet pet = new SheepPet(player.getLocation(), player);
            pet.setCustomName(new ChatComponentText(ChatColor.GOLD + ""  
                    + ChatColor.BOLD + player.getName() + "'s Pet"));
            WorldServer world = ((CraftWorld) player.getWorld()).getHandle();
            world.addEntity(pet);
            pet.setColor(EnumColor.BLACK);
        }
        
        //Add Gray Sheep
        if (event.getSlot() == 25) {
            SheepPet pet = new SheepPet(player.getLocation(), player);
            pet.setCustomName(new ChatComponentText(ChatColor.GOLD + ""  
                    + ChatColor.BOLD + player.getName() + "'s Pet"));
            WorldServer world = ((CraftWorld) player.getWorld()).getHandle();
            world.addEntity(pet);
            pet.setColor(EnumColor.GRAY);
        }
        
        //Add Light Gray Sheep
        if (event.getSlot() == 28) {
            SheepPet pet = new SheepPet(player.getLocation(), player);
            pet.setCustomName(new ChatComponentText(ChatColor.GOLD + ""  
                    + ChatColor.BOLD + player.getName() + "'s Pet"));
            WorldServer world = ((CraftWorld) player.getWorld()).getHandle();
            world.addEntity(pet);
            pet.setColor(EnumColor.LIGHT_GRAY);
        }
        
        //Add White Sheep
        if (event.getSlot() == 29) {
            SheepPet pet = new SheepPet(player.getLocation(), player);
            pet.setCustomName(new ChatComponentText(ChatColor.GOLD + ""  
                    + ChatColor.BOLD + player.getName() + "'s Pet"));
            WorldServer world = ((CraftWorld) player.getWorld()).getHandle();
            world.addEntity(pet);
            pet.setColor(EnumColor.WHITE);
        }
        
        //Back Arrow
        if (event.getSlot() == 39) {
            plugin.getServer().getScheduler().runTask(plugin, () -> {
                player.openInventory(petgui.inv);
            });
        }
        
        // Remove Pet Option
        if (event.getSlot() == 40) {
            for (int i = 0; i < en.size(); i++) {
                if (en.get(i).getCustomName() != null 
                        && en.get(i).getCustomName().contains(player.getName() + "'s Pet")) {
                    en.get(i).remove();
                }
            }
        }
        
        player.closeInventory();
    }
    
    
    // Cancel dragging out of inventory
    @EventHandler
    public void onInventoryClick(final InventoryDragEvent e) {
        if (e.getInventory() == petgui.inv) {
          e.setCancelled(true);
        }
    }
    
}
