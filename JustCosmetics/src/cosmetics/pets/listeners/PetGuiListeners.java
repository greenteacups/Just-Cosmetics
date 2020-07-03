package cosmetics.pets.listeners;

import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.craftbukkit.v1_16_R1.CraftWorld;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import cosmetics.CosmeticGui;
import cosmetics.Cosmetics;
import cosmetics.pets.BabySheepColourGUI;
import cosmetics.pets.PetGui;
import cosmetics.pets.PetGui2;
import cosmetics.pets.SheepColourGUI;
import cosmetics.pets.custompets.BeePet;
import cosmetics.pets.custompets.BlazePet;
import cosmetics.pets.custompets.ChickenPet;
import cosmetics.pets.custompets.CowPet;
import cosmetics.pets.custompets.FoxPet;
import cosmetics.pets.custompets.HorsePet;
import cosmetics.pets.custompets.HuskPet;
import cosmetics.pets.custompets.IronGolemPet;
import cosmetics.pets.custompets.LlamaPet;
import cosmetics.pets.custompets.MooshroomPet;
import cosmetics.pets.custompets.OcelotPet;
import cosmetics.pets.custompets.PandaPet;
import cosmetics.pets.custompets.PigPet;
import cosmetics.pets.custompets.PolarbearPet;
import cosmetics.pets.custompets.RabbitPet;
import cosmetics.pets.custompets.SheepPet;
import cosmetics.pets.custompets.SnowmanPet;
import cosmetics.pets.custompets.TurtlePet;
import cosmetics.pets.custompets.WitchPet;
import cosmetics.pets.custompets.WolfPet;
import cosmetics.pets.custompets.ZombiePet;
import net.minecraft.server.v1_16_R1.ChatComponentText;
import net.minecraft.server.v1_16_R1.EnumColor;
import net.minecraft.server.v1_16_R1.WorldServer;

public class PetGuiListeners implements Listener {

    public CosmeticGui maingui = Cosmetics.maingui;
    public PetGui petgui = Cosmetics.petgui;
    public PetGui2 petgui2 = Cosmetics.petgui2;
    public SheepColourGUI colorgui = Cosmetics.colourgui;
    public BabySheepColourGUI babycolorgui = Cosmetics.babycolourgui;
    private Cosmetics plugin;

    public PetGuiListeners(Cosmetics b) {
        plugin = b;
    }
    
    //////
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
        
        //Add Baby Llama
        if (event.getSlot() == 11) {
            LlamaPet pet = new LlamaPet(player.getLocation(), player);
            pet.setCustomName(new ChatComponentText(ChatColor.GOLD + ""  
                    + ChatColor.BOLD + player.getName() + "'s Pet"));
            WorldServer world = ((CraftWorld) player.getWorld()).getHandle();
            world.addEntity(pet);
            pet.setAge(-99999999);
        }
        
        //Add Pig
        if (event.getSlot() == 12) {
            PigPet pet = new PigPet(player.getLocation(), player);
            pet.setCustomName(new ChatComponentText(ChatColor.GOLD + ""  
                    + ChatColor.BOLD + player.getName() + "'s Pet"));
            WorldServer world = ((CraftWorld) player.getWorld()).getHandle();
            world.addEntity(pet);
        }
        
        //Add Baby Pig
        if (event.getSlot() == 13) {
            PigPet pet = new PigPet(player.getLocation(), player);
            pet.setCustomName(new ChatComponentText(ChatColor.GOLD + ""  
                    + ChatColor.BOLD + player.getName() + "'s Pet"));
            WorldServer world = ((CraftWorld) player.getWorld()).getHandle();
            world.addEntity(pet);
            pet.setAge(-99999999);
        }
        
        //Add Chicken
        if (event.getSlot() == 14) {
            ChickenPet pet = new ChickenPet(player.getLocation(), player);
            pet.setCustomName(new ChatComponentText(ChatColor.GOLD + ""  
                    + ChatColor.BOLD + player.getName() + "'s Pet"));
            WorldServer world = ((CraftWorld) player.getWorld()).getHandle();
            world.addEntity(pet);
        }
        
        //Add Baby Chicken
        if (event.getSlot() == 15) {
            ChickenPet pet = new ChickenPet(player.getLocation(), player);
            pet.setCustomName(new ChatComponentText(ChatColor.GOLD + ""  
                    + ChatColor.BOLD + player.getName() + "'s Pet"));
            WorldServer world = ((CraftWorld) player.getWorld()).getHandle();
            world.addEntity(pet);
            pet.setAge(-99999999);
        }
        
        //Go to Sheep Gui
        if (event.getSlot() == 16) {
            plugin.getServer().getScheduler().runTask(plugin, () -> {
                player.openInventory(colorgui.inv);
            });
        }
        
        //Add Baby Sheep
        if (event.getSlot() == 19) {
            plugin.getServer().getScheduler().runTask(plugin, () -> {
                player.openInventory(babycolorgui.inv);
            });
        }
        
        //Add Cow
        if (event.getSlot() == 20) {
            CowPet pet = new CowPet(player.getLocation(), player);
            pet.setCustomName(new ChatComponentText(ChatColor.GOLD + ""  
                    + ChatColor.BOLD + player.getName() + "'s Pet"));
            WorldServer world = ((CraftWorld) player.getWorld()).getHandle();
            world.addEntity(pet);
        }
        
        //Add Baby Cow
        if (event.getSlot() == 21) {
            CowPet pet = new CowPet(player.getLocation(), player);
            pet.setCustomName(new ChatComponentText(ChatColor.GOLD + ""  
                    + ChatColor.BOLD + player.getName() + "'s Pet"));
            WorldServer world = ((CraftWorld) player.getWorld()).getHandle();
            world.addEntity(pet);
            pet.setAge(-99999999);
        }
        
        //Add Mooshroom
        if (event.getSlot() == 22) {
            MooshroomPet pet = new MooshroomPet(player.getLocation(), player);
            pet.setCustomName(new ChatComponentText(ChatColor.GOLD + ""  
                    + ChatColor.BOLD + player.getName() + "'s Pet"));
            WorldServer world = ((CraftWorld) player.getWorld()).getHandle();
            world.addEntity(pet);
        }
        
        //Add Fox
        if (event.getSlot() == 23) {
            FoxPet pet = new FoxPet(player.getLocation(), player);
            pet.setCustomName(new ChatComponentText(ChatColor.GOLD + ""  
                    + ChatColor.BOLD + player.getName() + "'s Pet"));
            WorldServer world = ((CraftWorld) player.getWorld()).getHandle();
            world.addEntity(pet);
        }
        
        //Add Baby Fox
        if (event.getSlot() == 24) {
            FoxPet pet = new FoxPet(player.getLocation(), player);
            pet.setCustomName(new ChatComponentText(ChatColor.GOLD + ""  
                    + ChatColor.BOLD + player.getName() + "'s Pet"));
            WorldServer world = ((CraftWorld) player.getWorld()).getHandle();
            world.addEntity(pet);
            pet.setAge(-99999999);
        }
        
        //Add Panda
        if (event.getSlot() == 25) {
            PandaPet pet = new PandaPet(player.getLocation(), player);
            pet.setCustomName(new ChatComponentText(ChatColor.GOLD + ""  
                    + ChatColor.BOLD + player.getName() + "'s Pet"));
            WorldServer world = ((CraftWorld) player.getWorld()).getHandle();
            world.addEntity(pet);
        }
        
        //Add Baby Panda
        if (event.getSlot() == 28) {
            PandaPet pet = new PandaPet(player.getLocation(), player);
            pet.setCustomName(new ChatComponentText(ChatColor.GOLD + ""  
                    + ChatColor.BOLD + player.getName() + "'s Pet"));
            WorldServer world = ((CraftWorld) player.getWorld()).getHandle();
            world.addEntity(pet);
            pet.setAge(-99999999);
        }
        
        //Add Wolf
        if (event.getSlot() == 29) {
            WolfPet pet = new WolfPet(player.getLocation(), player);
            pet.setCustomName(new ChatComponentText(ChatColor.GOLD + ""  
                    + ChatColor.BOLD + player.getName() + "'s Pet"));
            WorldServer world = ((CraftWorld) player.getWorld()).getHandle();
            world.addEntity(pet);
        }
        
        //Add Baby Wolf
        if (event.getSlot() == 30) {
            WolfPet pet = new WolfPet(player.getLocation(), player);
            pet.setCustomName(new ChatComponentText(ChatColor.GOLD + ""  
                    + ChatColor.BOLD + player.getName() + "'s Pet"));
            WorldServer world = ((CraftWorld) player.getWorld()).getHandle();
            world.addEntity(pet);
            pet.setAge(-99999999);
        }
        
        //Add Polar Bear
        if (event.getSlot() == 31) {
            PolarbearPet pet = new PolarbearPet(player.getLocation(), player);
            pet.setCustomName(new ChatComponentText(ChatColor.GOLD + ""  
                    + ChatColor.BOLD + player.getName() + "'s Pet"));
            WorldServer world = ((CraftWorld) player.getWorld()).getHandle();
            world.addEntity(pet);
        }
        
        //Add Baby Polar Bear
        if (event.getSlot() == 32) {
            PolarbearPet pet = new PolarbearPet(player.getLocation(), player);
            pet.setCustomName(new ChatComponentText(ChatColor.GOLD + ""  
                    + ChatColor.BOLD + player.getName() + "'s Pet"));
            WorldServer world = ((CraftWorld) player.getWorld()).getHandle();
            world.addEntity(pet);
            pet.setAge(-99999999);
        }
        
        //Add Rabbit
        if (event.getSlot() == 33) {
            RabbitPet pet = new RabbitPet(player.getLocation(), player);
            pet.setCustomName(new ChatComponentText(ChatColor.GOLD + ""  
                    + ChatColor.BOLD + player.getName() + "'s Pet"));
            WorldServer world = ((CraftWorld) player.getWorld()).getHandle();
            world.addEntity(pet);
        }
        
        //Add Ocelot
        if (event.getSlot() == 34) {
            OcelotPet pet = new OcelotPet(player.getLocation(), player);
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
        
        // Return to cosmetic window
        if (event.getSlot() == 39) {
            plugin.getServer().getScheduler().runTask(plugin, () -> {
                player.openInventory(maingui.inv);
            });
        }
        
        // Pet Gui Page 2
        if (event.getSlot() == 41) {
            plugin.getServer().getScheduler().runTask(plugin, () -> {
                player.openInventory(petgui2.inv);
            });
        }
        
        player.closeInventory();
    }
    
    //////
    //PetGui Page 2
    @EventHandler()
    public void onPetGui2Click(InventoryClickEvent event) {
        if (!event.getInventory().equals(petgui2.inv))
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
        
        //Add Turtle
        if (event.getSlot() == 10) {
            TurtlePet pet = new TurtlePet(player.getLocation(), player);
            pet.setCustomName(new ChatComponentText(ChatColor.GOLD + ""  
                    + ChatColor.BOLD + player.getName() + "'s Pet"));
            WorldServer world = ((CraftWorld) player.getWorld()).getHandle();
            world.addEntity(pet);
        }
        
        //Add Bee
        if (event.getSlot() == 11) {
            BeePet pet = new BeePet(player.getLocation(), player);
            pet.setCustomName(new ChatComponentText(ChatColor.GOLD + ""  
                    + ChatColor.BOLD + player.getName() + "'s Pet"));
            WorldServer world = ((CraftWorld) player.getWorld()).getHandle();
            world.addEntity(pet);
        }
        
        //Add Horse
        if (event.getSlot() == 12) {
            HorsePet pet = new HorsePet(player.getLocation(), player);
            pet.setCustomName(new ChatComponentText(ChatColor.GOLD + ""  
                    + ChatColor.BOLD + player.getName() + "'s Pet"));
            WorldServer world = ((CraftWorld) player.getWorld()).getHandle();
            world.addEntity(pet);
        }
        
        //Add Blaze
        if (event.getSlot() == 13) {
            BlazePet pet = new BlazePet(player.getLocation(), player);
            pet.setCustomName(new ChatComponentText(ChatColor.GOLD + ""  
                    + ChatColor.BOLD + player.getName() + "'s Pet"));
            WorldServer world = ((CraftWorld) player.getWorld()).getHandle();
            world.addEntity(pet);
        }
        
        //Add Witch
        if (event.getSlot() == 14) {
            WitchPet pet = new WitchPet(player.getLocation(), player);
            pet.setCustomName(new ChatComponentText(ChatColor.GOLD + ""  
                    + ChatColor.BOLD + player.getName() + "'s Pet"));
            WorldServer world = ((CraftWorld) player.getWorld()).getHandle();
            world.addEntity(pet);
        }
        
        //Add Husk
        if (event.getSlot() == 15) {
            HuskPet pet = new HuskPet(player.getLocation(), player);
            pet.setCustomName(new ChatComponentText(ChatColor.GOLD + ""  
                    + ChatColor.BOLD + player.getName() + "'s Pet"));
            WorldServer world = ((CraftWorld) player.getWorld()).getHandle();
            world.addEntity(pet);
        }
        
        //Add Baby Husk
        if (event.getSlot() == 16) {
            HuskPet pet = new HuskPet(player.getLocation(), player);
            pet.setCustomName(new ChatComponentText(ChatColor.GOLD + ""  
                    + ChatColor.BOLD + player.getName() + "'s Pet"));
            WorldServer world = ((CraftWorld) player.getWorld()).getHandle();
            world.addEntity(pet);
            pet.setBaby(true);
        }
        
        //Add Zombie
        if (event.getSlot() == 19) {
            ZombiePet pet = new ZombiePet(player.getLocation(), player);
            pet.setCustomName(new ChatComponentText(ChatColor.GOLD + ""  
                    + ChatColor.BOLD + player.getName() + "'s Pet"));
            WorldServer world = ((CraftWorld) player.getWorld()).getHandle();
            world.addEntity(pet);
        }
        
        //Add Baby Zombie
        if (event.getSlot() == 20) {
            ZombiePet pet = new ZombiePet(player.getLocation(), player);
            pet.setCustomName(new ChatComponentText(ChatColor.GOLD + ""  
                    + ChatColor.BOLD + player.getName() + "'s Pet"));
            WorldServer world = ((CraftWorld) player.getWorld()).getHandle();
            world.addEntity(pet);
            pet.setBaby(true);
        }
        
        //Add Snowman
        if (event.getSlot() == 21) {
            SnowmanPet pet = new SnowmanPet(player.getLocation(), player);
            pet.setCustomName(new ChatComponentText(ChatColor.GOLD + ""  
                    + ChatColor.BOLD + player.getName() + "'s Pet"));
            WorldServer world = ((CraftWorld) player.getWorld()).getHandle();
            world.addEntity(pet);
        }
        
        //Add Iron Golem
        if (event.getSlot() == 22) {
            IronGolemPet pet = new IronGolemPet(player.getLocation(), player);
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
        
        // Pet Gui Page 2
        if (event.getSlot() == 39) {
            plugin.getServer().getScheduler().runTask(plugin, () -> {
                player.openInventory(petgui.inv);
            });
        }
        
        player.closeInventory();
    }
    
    //////
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
    
    //////
    //Clicking Inside the main Baby Sheep Colour Selector GUI
    @EventHandler()
    public void onBabySheepColourGuiClick(InventoryClickEvent event) {
        if (!event.getInventory().equals(babycolorgui.inv))
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
        
        //Add Red Baby Sheep
        if (event.getSlot() == 10) {
            SheepPet pet = new SheepPet(player.getLocation(), player);
            pet.setCustomName(new ChatComponentText(ChatColor.GOLD + ""  
                    + ChatColor.BOLD + player.getName() + "'s Pet"));
            WorldServer world = ((CraftWorld) player.getWorld()).getHandle();
            world.addEntity(pet);
            pet.setAge(-99999999);
            pet.setColor(EnumColor.RED);
        }
        
        //Add Orange Baby Sheep
        if (event.getSlot() == 11) {
            SheepPet pet = new SheepPet(player.getLocation(), player);
            pet.setCustomName(new ChatComponentText(ChatColor.GOLD + ""  
                    + ChatColor.BOLD + player.getName() + "'s Pet"));
            WorldServer world = ((CraftWorld) player.getWorld()).getHandle();
            world.addEntity(pet);
            pet.setAge(-99999999);
            pet.setColor(EnumColor.ORANGE);
        }
        
        //Add Yellow Baby Sheep
        if (event.getSlot() == 12) {
            SheepPet pet = new SheepPet(player.getLocation(), player);
            pet.setCustomName(new ChatComponentText(ChatColor.GOLD + ""  
                    + ChatColor.BOLD + player.getName() + "'s Pet"));
            WorldServer world = ((CraftWorld) player.getWorld()).getHandle();
            world.addEntity(pet);
            pet.setAge(-99999999);
            pet.setColor(EnumColor.YELLOW);
        }
        
        //Add Green Baby Sheep
        if (event.getSlot() == 13) {
            SheepPet pet = new SheepPet(player.getLocation(), player);
            pet.setCustomName(new ChatComponentText(ChatColor.GOLD + ""  
                    + ChatColor.BOLD + player.getName() + "'s Pet"));
            WorldServer world = ((CraftWorld) player.getWorld()).getHandle();
            world.addEntity(pet);
            pet.setAge(-99999999);
            pet.setColor(EnumColor.GREEN);
        }
        
        //Add Lime Baby Sheep
        if (event.getSlot() == 14) {
            SheepPet pet = new SheepPet(player.getLocation(), player);
            pet.setCustomName(new ChatComponentText(ChatColor.GOLD + ""  
                    + ChatColor.BOLD + player.getName() + "'s Pet"));
            WorldServer world = ((CraftWorld) player.getWorld()).getHandle();
            world.addEntity(pet);
            pet.setAge(-99999999);
            pet.setColor(EnumColor.LIME);
        }
        
        //Add Blue Baby Sheep
        if (event.getSlot() == 15) {
            SheepPet pet = new SheepPet(player.getLocation(), player);
            pet.setCustomName(new ChatComponentText(ChatColor.GOLD + ""  
                    + ChatColor.BOLD + player.getName() + "'s Pet"));
            WorldServer world = ((CraftWorld) player.getWorld()).getHandle();
            world.addEntity(pet);
            pet.setAge(-99999999);
            pet.setColor(EnumColor.BLUE);
        }
        
        //Add Cyan Baby Sheep
        if (event.getSlot() == 16) {
            SheepPet pet = new SheepPet(player.getLocation(), player);
            pet.setCustomName(new ChatComponentText(ChatColor.GOLD + ""  
                    + ChatColor.BOLD + player.getName() + "'s Pet"));
            WorldServer world = ((CraftWorld) player.getWorld()).getHandle();
            world.addEntity(pet);
            pet.setAge(-99999999);
            pet.setColor(EnumColor.CYAN);
        }
        
        //Add Light Blue Baby Sheep
        if (event.getSlot() == 19) {
            SheepPet pet = new SheepPet(player.getLocation(), player);
            pet.setCustomName(new ChatComponentText(ChatColor.GOLD + ""  
                    + ChatColor.BOLD + player.getName() + "'s Pet"));
            WorldServer world = ((CraftWorld) player.getWorld()).getHandle();
            world.addEntity(pet);
            pet.setAge(-99999999);
            pet.setColor(EnumColor.LIGHT_BLUE);
        }
        
        //Add Purple Baby Sheep
        if (event.getSlot() == 20) {
            SheepPet pet = new SheepPet(player.getLocation(), player);
            pet.setCustomName(new ChatComponentText(ChatColor.GOLD + ""  
                    + ChatColor.BOLD + player.getName() + "'s Pet"));
            WorldServer world = ((CraftWorld) player.getWorld()).getHandle();
            world.addEntity(pet);
            pet.setAge(-99999999);
            pet.setColor(EnumColor.PURPLE);
        }
        
        //Add Magenta Baby Sheep
        if (event.getSlot() == 21) {
            SheepPet pet = new SheepPet(player.getLocation(), player);
            pet.setCustomName(new ChatComponentText(ChatColor.GOLD + ""  
                    + ChatColor.BOLD + player.getName() + "'s Pet"));
            WorldServer world = ((CraftWorld) player.getWorld()).getHandle();
            world.addEntity(pet);
            pet.setAge(-99999999);
            pet.setColor(EnumColor.MAGENTA);
        }
        
        //Add Pink Baby Sheep
        if (event.getSlot() == 22) {
            SheepPet pet = new SheepPet(player.getLocation(), player);
            pet.setCustomName(new ChatComponentText(ChatColor.GOLD + ""  
                    + ChatColor.BOLD + player.getName() + "'s Pet"));
            WorldServer world = ((CraftWorld) player.getWorld()).getHandle();
            world.addEntity(pet);
            pet.setAge(-99999999);
            pet.setColor(EnumColor.PINK);
        }
        
        //Add Brown Baby Sheep
        if (event.getSlot() == 23) {
            SheepPet pet = new SheepPet(player.getLocation(), player);
            pet.setCustomName(new ChatComponentText(ChatColor.GOLD + ""  
                    + ChatColor.BOLD + player.getName() + "'s Pet"));
            WorldServer world = ((CraftWorld) player.getWorld()).getHandle();
            world.addEntity(pet);
            pet.setAge(-99999999);
            pet.setColor(EnumColor.BROWN);
        }
        
        //Add Black Baby Sheep
        if (event.getSlot() == 24) {
            SheepPet pet = new SheepPet(player.getLocation(), player);
            pet.setCustomName(new ChatComponentText(ChatColor.GOLD + ""  
                    + ChatColor.BOLD + player.getName() + "'s Pet"));
            WorldServer world = ((CraftWorld) player.getWorld()).getHandle();
            world.addEntity(pet);
            pet.setAge(-99999999);
            pet.setColor(EnumColor.BLACK);
        }
        
        //Add Gray Baby Sheep
        if (event.getSlot() == 25) {
            SheepPet pet = new SheepPet(player.getLocation(), player);
            pet.setCustomName(new ChatComponentText(ChatColor.GOLD + ""  
                    + ChatColor.BOLD + player.getName() + "'s Pet"));
            WorldServer world = ((CraftWorld) player.getWorld()).getHandle();
            world.addEntity(pet);
            pet.setAge(-99999999);
            pet.setColor(EnumColor.GRAY);
        }
        
        //Add Light Gray Baby Sheep
        if (event.getSlot() == 28) {
            SheepPet pet = new SheepPet(player.getLocation(), player);
            pet.setCustomName(new ChatComponentText(ChatColor.GOLD + ""  
                    + ChatColor.BOLD + player.getName() + "'s Pet"));
            WorldServer world = ((CraftWorld) player.getWorld()).getHandle();
            world.addEntity(pet);
            pet.setAge(-99999999);
            pet.setColor(EnumColor.LIGHT_GRAY);
        }
        
        //Add White Baby Sheep
        if (event.getSlot() == 29) {
            SheepPet pet = new SheepPet(player.getLocation(), player);
            pet.setCustomName(new ChatComponentText(ChatColor.GOLD + ""  
                    + ChatColor.BOLD + player.getName() + "'s Pet"));
            WorldServer world = ((CraftWorld) player.getWorld()).getHandle();
            world.addEntity(pet);
            pet.setAge(-99999999);
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
    
    
}