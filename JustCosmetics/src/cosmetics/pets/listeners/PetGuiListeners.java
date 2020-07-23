package cosmetics.pets.listeners;

import java.util.HashMap;

import org.bukkit.ChatColor;
import org.bukkit.craftbukkit.v1_16_R1.CraftWorld;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import cosmetics.CosmeticGui;
import cosmetics.Cosmetics;
import cosmetics.PurchaseConstructor;
import cosmetics.PurchaseGui;
import cosmetics.RemoveEffects;
import cosmetics.pets.BabySheepColourGUI;
import cosmetics.pets.PetGui;
import cosmetics.pets.PetGui2;
import cosmetics.pets.SheepColourGUI;
import cosmetics.pets.custompets.BlazePet;
import cosmetics.pets.custompets.ChickenPet;
import cosmetics.pets.custompets.CowPet;
import cosmetics.pets.custompets.CreeperPet;
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
    
    public PurchaseGui purchasegui = Cosmetics.purchasegui;
    public PurchaseConstructor PurchaseConstructor = Cosmetics.PurchaseConstructor;
    public HashMap<Player, String> purchaseItem = Cosmetics.purchaseItem;
    public HashMap<Player, Integer> purchasePrice = Cosmetics.purchasePrice;

    public PetGuiListeners(Cosmetics b) {
        plugin = b;
    }
    
    public static RemoveEffects RemoveEffects = new RemoveEffects();
    
    public static HashMap<Player, Entity> currentPet = new HashMap<>();
    
    
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
        
        // Remove Active Cosmetics when selecting new pet
        if (event.getSlot() < 35) {
            RemoveEffects.ClearEffects(player);
        }

        //Add Llama
        if (event.getSlot() == 10) {
            if (plugin.dataCosmetics.exists(player.getUniqueId(), "Llama Pet")) {
                LlamaPet pet = new LlamaPet(player.getLocation(), player);
                pet.setCustomName(new ChatComponentText(ChatColor.GOLD + ""  
                        + ChatColor.BOLD + player.getName() + "'s Pet"));
                WorldServer world = ((CraftWorld) player.getWorld()).getHandle();
                world.addEntity(pet);
                
                currentPet.put(player, pet.getBukkitEntity());
            }
            else {
                purchaseItem.put(player, "Llama Pet"); //Input Name
                purchasePrice.put(player, 100); //Input Price
                PurchaseConstructor.purchaseGui(player, purchaseItem.get(player), purchasePrice.get(player));
            }
        }
        
        //Add Baby Llama
        if (event.getSlot() == 11) {
            if (plugin.dataCosmetics.exists(player.getUniqueId(), "Baby Llama Pet")) {
                LlamaPet pet = new LlamaPet(player.getLocation(), player);
                pet.setCustomName(new ChatComponentText(ChatColor.GOLD + ""  
                        + ChatColor.BOLD + player.getName() + "'s Pet"));
                WorldServer world = ((CraftWorld) player.getWorld()).getHandle();
                world.addEntity(pet);
                pet.setAge(-99999999);
                
                currentPet.put(player, pet.getBukkitEntity());
            }
            else {
                purchaseItem.put(player, "Baby Llama Pet"); //Input Name
                purchasePrice.put(player, 100); //Input Price
                PurchaseConstructor.purchaseGui(player, purchaseItem.get(player), purchasePrice.get(player));
            }
        }
        
        //Add Pig
        if (event.getSlot() == 12) {
            if (plugin.dataCosmetics.exists(player.getUniqueId(), "Pig Pet")) {
                PigPet pet = new PigPet(player.getLocation(), player);
                pet.setCustomName(new ChatComponentText(ChatColor.GOLD + ""  
                        + ChatColor.BOLD + player.getName() + "'s Pet"));
                WorldServer world = ((CraftWorld) player.getWorld()).getHandle();
                world.addEntity(pet);
                
                currentPet.put(player, pet.getBukkitEntity());
            }
            else {
                purchaseItem.put(player, "Pig Pet"); //Input Name
                purchasePrice.put(player, 100); //Input Price
                PurchaseConstructor.purchaseGui(player, purchaseItem.get(player), purchasePrice.get(player));
            }
        }
        
        //Add Baby Pig
        if (event.getSlot() == 13) {
            if (plugin.dataCosmetics.exists(player.getUniqueId(), "Baby Pig Pet")) {
                PigPet pet = new PigPet(player.getLocation(), player);
                pet.setCustomName(new ChatComponentText(ChatColor.GOLD + ""  
                        + ChatColor.BOLD + player.getName() + "'s Pet"));
                WorldServer world = ((CraftWorld) player.getWorld()).getHandle();
                world.addEntity(pet);
                pet.setAge(-99999999);
                
                currentPet.put(player, pet.getBukkitEntity());
            }
            else {
                purchaseItem.put(player, "Baby Pig Pet"); //Input Name
                purchasePrice.put(player, 100); //Input Price
                PurchaseConstructor.purchaseGui(player, purchaseItem.get(player), purchasePrice.get(player));
            }
        }
        
        //Add Chicken
        if (event.getSlot() == 14) {
            if (plugin.dataCosmetics.exists(player.getUniqueId(), "Chicken Pet")) {
                ChickenPet pet = new ChickenPet(player.getLocation(), player);
                pet.setCustomName(new ChatComponentText(ChatColor.GOLD + ""  
                        + ChatColor.BOLD + player.getName() + "'s Pet"));
                WorldServer world = ((CraftWorld) player.getWorld()).getHandle();
                world.addEntity(pet);
                
                currentPet.put(player, pet.getBukkitEntity());
            }
            else {
                purchaseItem.put(player, "Chicken Pet"); //Input Name
                purchasePrice.put(player, 100); //Input Price
                PurchaseConstructor.purchaseGui(player, purchaseItem.get(player), purchasePrice.get(player));
            }
        }
        
        //Add Baby Chicken
        if (event.getSlot() == 15) {
            if (plugin.dataCosmetics.exists(player.getUniqueId(), "Baby Chicken Pet")) {
                ChickenPet pet = new ChickenPet(player.getLocation(), player);
                pet.setCustomName(new ChatComponentText(ChatColor.GOLD + ""  
                        + ChatColor.BOLD + player.getName() + "'s Pet"));
                WorldServer world = ((CraftWorld) player.getWorld()).getHandle();
                world.addEntity(pet);
                pet.setAge(-99999999);
                
                currentPet.put(player, pet.getBukkitEntity());
            }
            else {
                purchaseItem.put(player, "Baby Chicken Pet"); //Input Name
                purchasePrice.put(player, 100); //Input Price
                PurchaseConstructor.purchaseGui(player, purchaseItem.get(player), purchasePrice.get(player));
            }
        }
        
        //Go to Sheep Gui
        if (event.getSlot() == 16) {
            colorgui.ExampleGui(player);
            plugin.getServer().getScheduler().runTask(plugin, () -> {
                player.openInventory(colorgui.inv);
            });
        }
        
        //Add Baby Sheep
        if (event.getSlot() == 19) {
            babycolorgui.ExampleGui(player);
            plugin.getServer().getScheduler().runTask(plugin, () -> {
                player.openInventory(babycolorgui.inv);
            });
        }
        
        //Add Cow
        if (event.getSlot() == 20) {
            if (plugin.dataCosmetics.exists(player.getUniqueId(), "Cow Pet")) {
                CowPet pet = new CowPet(player.getLocation(), player);
                pet.setCustomName(new ChatComponentText(ChatColor.GOLD + ""  
                        + ChatColor.BOLD + player.getName() + "'s Pet"));
                WorldServer world = ((CraftWorld) player.getWorld()).getHandle();
                world.addEntity(pet);
                
                currentPet.put(player, pet.getBukkitEntity());
            }
            else {
                purchaseItem.put(player, "Cow Pet"); //Input Name
                purchasePrice.put(player, 100); //Input Price
                PurchaseConstructor.purchaseGui(player, purchaseItem.get(player), purchasePrice.get(player));
            }
        }
        
        //Add Baby Cow
        if (event.getSlot() == 21) {
            if (plugin.dataCosmetics.exists(player.getUniqueId(), "Baby Cow Pet")) {
                CowPet pet = new CowPet(player.getLocation(), player);
                pet.setCustomName(new ChatComponentText(ChatColor.GOLD + ""  
                        + ChatColor.BOLD + player.getName() + "'s Pet"));
                WorldServer world = ((CraftWorld) player.getWorld()).getHandle();
                world.addEntity(pet);
                pet.setAge(-99999999);
                
                currentPet.put(player, pet.getBukkitEntity());
            }
            else {
                purchaseItem.put(player, "Baby Cow Pet"); //Input Name
                purchasePrice.put(player, 100); //Input Price
                PurchaseConstructor.purchaseGui(player, purchaseItem.get(player), purchasePrice.get(player));
            }
        }
        
        //Add Mooshroom
        if (event.getSlot() == 22) {
            if (plugin.dataCosmetics.exists(player.getUniqueId(), "Mooshroom Pet")) {
                MooshroomPet pet = new MooshroomPet(player.getLocation(), player);
                pet.setCustomName(new ChatComponentText(ChatColor.GOLD + ""  
                        + ChatColor.BOLD + player.getName() + "'s Pet"));
                WorldServer world = ((CraftWorld) player.getWorld()).getHandle();
                world.addEntity(pet);
                
                currentPet.put(player, pet.getBukkitEntity());
            }
            else {
                purchaseItem.put(player, "Mooshroom Pet"); //Input Name
                purchasePrice.put(player, 100); //Input Price
                PurchaseConstructor.purchaseGui(player, purchaseItem.get(player), purchasePrice.get(player));
            }
        }
        
        //Add Fox
        if (event.getSlot() == 23) {
            if (plugin.dataCosmetics.exists(player.getUniqueId(), "Fox Pet")) {
                FoxPet pet = new FoxPet(player.getLocation(), player);
                pet.setCustomName(new ChatComponentText(ChatColor.GOLD + ""  
                        + ChatColor.BOLD + player.getName() + "'s Pet"));
                WorldServer world = ((CraftWorld) player.getWorld()).getHandle();
                world.addEntity(pet);
                
                currentPet.put(player, pet.getBukkitEntity());
            }
            else {
                purchaseItem.put(player, "Fox Pet"); //Input Name
                purchasePrice.put(player, 100); //Input Price
                PurchaseConstructor.purchaseGui(player, purchaseItem.get(player), purchasePrice.get(player));
            }
        }
        
        //Add Baby Fox
        if (event.getSlot() == 24) {
            if (plugin.dataCosmetics.exists(player.getUniqueId(), "Baby Fox Pet")) {
                FoxPet pet = new FoxPet(player.getLocation(), player);
                pet.setCustomName(new ChatComponentText(ChatColor.GOLD + ""  
                        + ChatColor.BOLD + player.getName() + "'s Pet"));
                WorldServer world = ((CraftWorld) player.getWorld()).getHandle();
                world.addEntity(pet);
                pet.setAge(-99999999);
                
                currentPet.put(player, pet.getBukkitEntity());
            }
            else {
                purchaseItem.put(player, "Baby Fox Pet"); //Input Name
                purchasePrice.put(player, 100); //Input Price
                PurchaseConstructor.purchaseGui(player, purchaseItem.get(player), purchasePrice.get(player));
            }
        }
        
        //Add Panda
        if (event.getSlot() == 25) {
            if (plugin.dataCosmetics.exists(player.getUniqueId(), "Panda Pet")) {
                PandaPet pet = new PandaPet(player.getLocation(), player);
                pet.setCustomName(new ChatComponentText(ChatColor.GOLD + ""  
                        + ChatColor.BOLD + player.getName() + "'s Pet"));
                WorldServer world = ((CraftWorld) player.getWorld()).getHandle();
                world.addEntity(pet);
                
                currentPet.put(player, pet.getBukkitEntity());
            }
            else {
                purchaseItem.put(player, "Panda Pet"); //Input Name
                purchasePrice.put(player, 100); //Input Price
                PurchaseConstructor.purchaseGui(player, purchaseItem.get(player), purchasePrice.get(player));
            }
        }
        
        //Add Baby Panda
        if (event.getSlot() == 28) {
            if (plugin.dataCosmetics.exists(player.getUniqueId(), "Baby Panda Pet")) {
                PandaPet pet = new PandaPet(player.getLocation(), player);
                pet.setCustomName(new ChatComponentText(ChatColor.GOLD + ""  
                        + ChatColor.BOLD + player.getName() + "'s Pet"));
                WorldServer world = ((CraftWorld) player.getWorld()).getHandle();
                world.addEntity(pet);
                pet.setAge(-99999999);
                
                currentPet.put(player, pet.getBukkitEntity());
            }
            else {
                purchaseItem.put(player, "Baby Panda Pet"); //Input Name
                purchasePrice.put(player, 100); //Input Price
                PurchaseConstructor.purchaseGui(player, purchaseItem.get(player), purchasePrice.get(player));
            }
        }
        
        //Add Wolf
        if (event.getSlot() == 29) {
            if (plugin.dataCosmetics.exists(player.getUniqueId(), "Wolf Pet")) {
                WolfPet pet = new WolfPet(player.getLocation(), player);
                pet.setCustomName(new ChatComponentText(ChatColor.GOLD + ""  
                        + ChatColor.BOLD + player.getName() + "'s Pet"));
                WorldServer world = ((CraftWorld) player.getWorld()).getHandle();
                world.addEntity(pet);
                
                currentPet.put(player, pet.getBukkitEntity());
            }
            else {
                purchaseItem.put(player, "Wolf Pet"); //Input Name
                purchasePrice.put(player, 100); //Input Price
                PurchaseConstructor.purchaseGui(player, purchaseItem.get(player), purchasePrice.get(player));
            }
        }
        
        //Add Baby Wolf
        if (event.getSlot() == 30) {
            if (plugin.dataCosmetics.exists(player.getUniqueId(), "Baby Wolf Pet")) {
                WolfPet pet = new WolfPet(player.getLocation(), player);
                pet.setCustomName(new ChatComponentText(ChatColor.GOLD + ""  
                        + ChatColor.BOLD + player.getName() + "'s Pet"));
                WorldServer world = ((CraftWorld) player.getWorld()).getHandle();
                world.addEntity(pet);
                pet.setAge(-99999999);
                
                currentPet.put(player, pet.getBukkitEntity());
            }
            else {
                purchaseItem.put(player, "Baby Wolf Pet"); //Input Name
                purchasePrice.put(player, 100); //Input Price
                PurchaseConstructor.purchaseGui(player, purchaseItem.get(player), purchasePrice.get(player));
            }
        }
        
        //Add Polar Bear
        if (event.getSlot() == 31) {
            if (plugin.dataCosmetics.exists(player.getUniqueId(), "Polar Bear Pet")) {
                PolarbearPet pet = new PolarbearPet(player.getLocation(), player);
                pet.setCustomName(new ChatComponentText(ChatColor.GOLD + ""  
                        + ChatColor.BOLD + player.getName() + "'s Pet"));
                WorldServer world = ((CraftWorld) player.getWorld()).getHandle();
                world.addEntity(pet);
                
                currentPet.put(player, pet.getBukkitEntity());
            }
            else {
                purchaseItem.put(player, "Polar Bear Pet"); //Input Name
                purchasePrice.put(player, 100); //Input Price
                PurchaseConstructor.purchaseGui(player, purchaseItem.get(player), purchasePrice.get(player));
            }
        }
        
        //Add Baby Polar Bear
        if (event.getSlot() == 32) {
            if (plugin.dataCosmetics.exists(player.getUniqueId(), "Baby Polar Bear Pet")) {
                PolarbearPet pet = new PolarbearPet(player.getLocation(), player);
                pet.setCustomName(new ChatComponentText(ChatColor.GOLD + ""  
                        + ChatColor.BOLD + player.getName() + "'s Pet"));
                WorldServer world = ((CraftWorld) player.getWorld()).getHandle();
                world.addEntity(pet);
                pet.setAge(-99999999);
                
                currentPet.put(player, pet.getBukkitEntity());
            }
            else {
                purchaseItem.put(player, "Baby Polar Bear Pet"); //Input Name
                purchasePrice.put(player, 100); //Input Price
                PurchaseConstructor.purchaseGui(player, purchaseItem.get(player), purchasePrice.get(player));
            }
        }
        
        //Add Rabbit
        if (event.getSlot() == 33) {
            if (plugin.dataCosmetics.exists(player.getUniqueId(), "Rabbit Pet")) {
                RabbitPet pet = new RabbitPet(player.getLocation(), player);
                pet.setCustomName(new ChatComponentText(ChatColor.GOLD + ""  
                        + ChatColor.BOLD + player.getName() + "'s Pet"));
                WorldServer world = ((CraftWorld) player.getWorld()).getHandle();
                world.addEntity(pet);
                
                currentPet.put(player, pet.getBukkitEntity());
            }
            else {
                purchaseItem.put(player, "Rabbit Pet"); //Input Name
                purchasePrice.put(player, 100); //Input Price
                PurchaseConstructor.purchaseGui(player, purchaseItem.get(player), purchasePrice.get(player));
            }
        }
        
        //Add Ocelot
        if (event.getSlot() == 34) {
            if (plugin.dataCosmetics.exists(player.getUniqueId(), "Ocelot Pet")) {
                OcelotPet pet = new OcelotPet(player.getLocation(), player);
                pet.setCustomName(new ChatComponentText(ChatColor.GOLD + ""  
                        + ChatColor.BOLD + player.getName() + "'s Pet"));
                WorldServer world = ((CraftWorld) player.getWorld()).getHandle();
                world.addEntity(pet);
                
                currentPet.put(player, pet.getBukkitEntity());
            }
            else {
                purchaseItem.put(player, "Ocelot Pet"); //Input Name
                purchasePrice.put(player, 100); //Input Price
                PurchaseConstructor.purchaseGui(player, purchaseItem.get(player), purchasePrice.get(player));
            }
        }
        
        // Remove Pet Option
        if (event.getSlot() == 40) {
            RemoveEffects.ClearEffects(player);
        }
        
        // Return to cosmetic window
        if (event.getSlot() == 39) {
            plugin.getServer().getScheduler().runTask(plugin, () -> {
                player.openInventory(maingui.inv);
            });
        }
        
        // Pet Gui Page 2
        if (event.getSlot() == 41) {
            petgui2.ExampleGui(player);
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
        
        // Remove Active Cosmetics when selecting new pet
        if (event.getSlot() < 35) {
            RemoveEffects.ClearEffects(player);
        }
        
        //Add Turtle
        if (event.getSlot() == 10) {
            if (plugin.dataCosmetics.exists(player.getUniqueId(), "Turtle Pet")) {
                TurtlePet pet = new TurtlePet(player.getLocation(), player);
                pet.setCustomName(new ChatComponentText(ChatColor.GOLD + ""  
                        + ChatColor.BOLD + player.getName() + "'s Pet"));
                WorldServer world = ((CraftWorld) player.getWorld()).getHandle();
                world.addEntity(pet);
                
                currentPet.put(player, pet.getBukkitEntity());
            }
            else {
                purchaseItem.put(player, "Turtle Pet"); //Input Name
                purchasePrice.put(player, 100); //Input Price
                PurchaseConstructor.purchaseGui(player, purchaseItem.get(player), purchasePrice.get(player));
            }
        }
        
        //Add Creeper
        if (event.getSlot() == 11) {
            if (plugin.dataCosmetics.exists(player.getUniqueId(), "Creeper Pet")) {
                CreeperPet pet = new CreeperPet(player.getLocation(), player);
                pet.setCustomName(new ChatComponentText(ChatColor.GOLD + ""  
                        + ChatColor.BOLD + player.getName() + "'s Pet"));
                WorldServer world = ((CraftWorld) player.getWorld()).getHandle();
                world.addEntity(pet);
                
                currentPet.put(player, pet.getBukkitEntity());
            }
            else {
                purchaseItem.put(player, "Creeper Pet"); //Input Name
                purchasePrice.put(player, 100); //Input Price
                PurchaseConstructor.purchaseGui(player, purchaseItem.get(player), purchasePrice.get(player));
            }
        }
        
        //Add Horse
        if (event.getSlot() == 12) {
            if (plugin.dataCosmetics.exists(player.getUniqueId(), "Horse Pet")) {
                HorsePet pet = new HorsePet(player.getLocation(), player);
                pet.setCustomName(new ChatComponentText(ChatColor.GOLD + ""  
                        + ChatColor.BOLD + player.getName() + "'s Pet"));
                WorldServer world = ((CraftWorld) player.getWorld()).getHandle();
                world.addEntity(pet);
                
                currentPet.put(player, pet.getBukkitEntity());
            }
            else {
                purchaseItem.put(player, "Horse Pet"); //Input Name
                purchasePrice.put(player, 100); //Input Price
                PurchaseConstructor.purchaseGui(player, purchaseItem.get(player), purchasePrice.get(player));
            }
        }
        
        //Add Blaze
        if (event.getSlot() == 13) {
            if (plugin.dataCosmetics.exists(player.getUniqueId(), "Blaze Pet")) {
                BlazePet pet = new BlazePet(player.getLocation(), player);
                pet.setCustomName(new ChatComponentText(ChatColor.GOLD + ""  
                        + ChatColor.BOLD + player.getName() + "'s Pet"));
                WorldServer world = ((CraftWorld) player.getWorld()).getHandle();
                world.addEntity(pet);
                
                currentPet.put(player, pet.getBukkitEntity());
            }
            else {
                purchaseItem.put(player, "Blaze Pet"); //Input Name
                purchasePrice.put(player, 100); //Input Price
                PurchaseConstructor.purchaseGui(player, purchaseItem.get(player), purchasePrice.get(player));
            }
        }
        
        //Add Witch
        if (event.getSlot() == 14) {
            if (plugin.dataCosmetics.exists(player.getUniqueId(), "Witch Pet")) {
                WitchPet pet = new WitchPet(player.getLocation(), player);
                pet.setCustomName(new ChatComponentText(ChatColor.GOLD + ""  
                        + ChatColor.BOLD + player.getName() + "'s Pet"));
                WorldServer world = ((CraftWorld) player.getWorld()).getHandle();
                world.addEntity(pet);
                
                currentPet.put(player, pet.getBukkitEntity());
            }
            else {
                purchaseItem.put(player, "Witch Pet"); //Input Name
                purchasePrice.put(player, 100); //Input Price
                PurchaseConstructor.purchaseGui(player, purchaseItem.get(player), purchasePrice.get(player));
            }
        }
        
        //Add Husk
        if (event.getSlot() == 15) {
            if (plugin.dataCosmetics.exists(player.getUniqueId(), "Husk Pet")) {
                HuskPet pet = new HuskPet(player.getLocation(), player);
                pet.setCustomName(new ChatComponentText(ChatColor.GOLD + ""  
                        + ChatColor.BOLD + player.getName() + "'s Pet"));
                WorldServer world = ((CraftWorld) player.getWorld()).getHandle();
                world.addEntity(pet);
                
                currentPet.put(player, pet.getBukkitEntity());
            }
            else {
                purchaseItem.put(player, "Husk Pet"); //Input Name
                purchasePrice.put(player, 100); //Input Price
                PurchaseConstructor.purchaseGui(player, purchaseItem.get(player), purchasePrice.get(player));
            }
        }
        
        //Add Baby Husk
        if (event.getSlot() == 16) {
            if (plugin.dataCosmetics.exists(player.getUniqueId(), "Baby Husk Pet")) {
                HuskPet pet = new HuskPet(player.getLocation(), player);
                pet.setCustomName(new ChatComponentText(ChatColor.GOLD + ""  
                        + ChatColor.BOLD + player.getName() + "'s Pet"));
                WorldServer world = ((CraftWorld) player.getWorld()).getHandle();
                world.addEntity(pet);
                pet.setBaby(true);
                
                currentPet.put(player, pet.getBukkitEntity());
            }
            else {
                purchaseItem.put(player, "Baby Husk Pet"); //Input Name
                purchasePrice.put(player, 100); //Input Price
                PurchaseConstructor.purchaseGui(player, purchaseItem.get(player), purchasePrice.get(player));
            }
        }
        
        //Add Zombie
        if (event.getSlot() == 19) {
            if (plugin.dataCosmetics.exists(player.getUniqueId(), "Zombie Pet")) {
                ZombiePet pet = new ZombiePet(player.getLocation(), player);
                pet.setCustomName(new ChatComponentText(ChatColor.GOLD + ""  
                        + ChatColor.BOLD + player.getName() + "'s Pet"));
                WorldServer world = ((CraftWorld) player.getWorld()).getHandle();
                world.addEntity(pet);
                
                currentPet.put(player, pet.getBukkitEntity());
            }
            else {
                purchaseItem.put(player, "Zombie Pet"); //Input Name
                purchasePrice.put(player, 100); //Input Price
                PurchaseConstructor.purchaseGui(player, purchaseItem.get(player), purchasePrice.get(player));
            }
        }
        
        //Add Baby Zombie
        if (event.getSlot() == 20) {
            if (plugin.dataCosmetics.exists(player.getUniqueId(), "Baby Zombie Pet")) {
                ZombiePet pet = new ZombiePet(player.getLocation(), player);
                pet.setCustomName(new ChatComponentText(ChatColor.GOLD + ""  
                        + ChatColor.BOLD + player.getName() + "'s Pet"));
                WorldServer world = ((CraftWorld) player.getWorld()).getHandle();
                world.addEntity(pet);
                pet.setBaby(true);
                
                currentPet.put(player, pet.getBukkitEntity());
            }
            else {
                purchaseItem.put(player, "Baby Zombie Pet"); //Input Name
                purchasePrice.put(player, 100); //Input Price
                PurchaseConstructor.purchaseGui(player, purchaseItem.get(player), purchasePrice.get(player));
            }
        }
        
        //Add Snowman
        if (event.getSlot() == 21) {
            if (plugin.dataCosmetics.exists(player.getUniqueId(), "Snowman Pet")) {
                SnowmanPet pet = new SnowmanPet(player.getLocation(), player);
                pet.setCustomName(new ChatComponentText(ChatColor.GOLD + ""  
                        + ChatColor.BOLD + player.getName() + "'s Pet"));
                WorldServer world = ((CraftWorld) player.getWorld()).getHandle();
                world.addEntity(pet);
                
                currentPet.put(player, pet.getBukkitEntity());
            }
            else {
                purchaseItem.put(player, "Snowman Pet"); //Input Name
                purchasePrice.put(player, 100); //Input Price
                PurchaseConstructor.purchaseGui(player, purchaseItem.get(player), purchasePrice.get(player));
            }
        }
        
        //Add Iron Golem
        if (event.getSlot() == 22) {
            if (plugin.dataCosmetics.exists(player.getUniqueId(), "Golem Pet")) {
                IronGolemPet pet = new IronGolemPet(player.getLocation(), player);
                pet.setCustomName(new ChatComponentText(ChatColor.GOLD + ""  
                        + ChatColor.BOLD + player.getName() + "'s Pet"));
                WorldServer world = ((CraftWorld) player.getWorld()).getHandle();
                world.addEntity(pet);
                
                currentPet.put(player, pet.getBukkitEntity());
            }
            else {
                purchaseItem.put(player, "Golem Pet"); //Input Name
                purchasePrice.put(player, 100); //Input Price
                PurchaseConstructor.purchaseGui(player, purchaseItem.get(player), purchasePrice.get(player));
            }
        }
    
        // Remove Pet Option
        if (event.getSlot() == 40) {
            RemoveEffects.ClearEffects(player);
        }
        
        // Pet Gui Page 2
        if (event.getSlot() == 39) {
            petgui.ExampleGui(player);
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
        
        // Remove Active Cosmetics when selecting new pet
        if (event.getSlot() < 35) {
            RemoveEffects.ClearEffects(player);
        }
        
        //Add Red Sheep
        if (event.getSlot() == 10) {
            if (plugin.dataCosmetics.exists(player.getUniqueId(), "Red Sheep Pet")) {
                SheepPet pet = new SheepPet(player.getLocation(), player);
                pet.setCustomName(new ChatComponentText(ChatColor.GOLD + ""  
                        + ChatColor.BOLD + player.getName() + "'s Pet"));
                WorldServer world = ((CraftWorld) player.getWorld()).getHandle();
                world.addEntity(pet);
                pet.setColor(EnumColor.RED);
                
                currentPet.put(player, pet.getBukkitEntity());
            }
            else {
                purchaseItem.put(player, "Red Sheep Pet"); //Input Name
                purchasePrice.put(player, 100); //Input Price
                PurchaseConstructor.purchaseGui(player, purchaseItem.get(player), purchasePrice.get(player));
            }
        }
        
        //Add Orange Sheep
        if (event.getSlot() == 11) {
            if (plugin.dataCosmetics.exists(player.getUniqueId(), "Orange Sheep Pet")) {
                SheepPet pet = new SheepPet(player.getLocation(), player);
                pet.setCustomName(new ChatComponentText(ChatColor.GOLD + ""  
                        + ChatColor.BOLD + player.getName() + "'s Pet"));
                WorldServer world = ((CraftWorld) player.getWorld()).getHandle();
                world.addEntity(pet);
                pet.setColor(EnumColor.ORANGE);
                
                currentPet.put(player, pet.getBukkitEntity());
            }
            else {
                purchaseItem.put(player, "Orange Sheep Pet"); //Input Name
                purchasePrice.put(player, 100); //Input Price
                PurchaseConstructor.purchaseGui(player, purchaseItem.get(player), purchasePrice.get(player));
            }
        }
        
        //Add Yellow Sheep
        if (event.getSlot() == 12) {
            if (plugin.dataCosmetics.exists(player.getUniqueId(), "Yellow Sheep Pet")) {
                SheepPet pet = new SheepPet(player.getLocation(), player);
                pet.setCustomName(new ChatComponentText(ChatColor.GOLD + ""  
                        + ChatColor.BOLD + player.getName() + "'s Pet"));
                WorldServer world = ((CraftWorld) player.getWorld()).getHandle();
                world.addEntity(pet);
                pet.setColor(EnumColor.YELLOW);
                
                currentPet.put(player, pet.getBukkitEntity());
            }
            else {
                purchaseItem.put(player, "Yellow Sheep Pet"); //Input Name
                purchasePrice.put(player, 100); //Input Price
                PurchaseConstructor.purchaseGui(player, purchaseItem.get(player), purchasePrice.get(player));
            }
        }
        
        //Add Green Sheep
        if (event.getSlot() == 13) {
            if (plugin.dataCosmetics.exists(player.getUniqueId(), "Green Sheep Pet")) {
                SheepPet pet = new SheepPet(player.getLocation(), player);
                pet.setCustomName(new ChatComponentText(ChatColor.GOLD + ""  
                        + ChatColor.BOLD + player.getName() + "'s Pet"));
                WorldServer world = ((CraftWorld) player.getWorld()).getHandle();
                world.addEntity(pet);
                pet.setColor(EnumColor.GREEN);
                
                currentPet.put(player, pet.getBukkitEntity());
            }
            else {
                purchaseItem.put(player, "Green Sheep Pet"); //Input Name
                purchasePrice.put(player, 100); //Input Price
                PurchaseConstructor.purchaseGui(player, purchaseItem.get(player), purchasePrice.get(player));
            }
        }
        
        //Add Lime Sheep
        if (event.getSlot() == 14) {
            if (plugin.dataCosmetics.exists(player.getUniqueId(), "Lime Sheep Pet")) {
                SheepPet pet = new SheepPet(player.getLocation(), player);
                pet.setCustomName(new ChatComponentText(ChatColor.GOLD + ""  
                        + ChatColor.BOLD + player.getName() + "'s Pet"));
                WorldServer world = ((CraftWorld) player.getWorld()).getHandle();
                world.addEntity(pet);
                pet.setColor(EnumColor.LIME);
                
                currentPet.put(player, pet.getBukkitEntity());
            }
            else {
                purchaseItem.put(player, "Lime Sheep Pet"); //Input Name
                purchasePrice.put(player, 100); //Input Price
                PurchaseConstructor.purchaseGui(player, purchaseItem.get(player), purchasePrice.get(player));
            }
        }
        
        //Add Blue Sheep
        if (event.getSlot() == 15) {
            if (plugin.dataCosmetics.exists(player.getUniqueId(), "Blue Sheep Pet")) {
                SheepPet pet = new SheepPet(player.getLocation(), player);
                pet.setCustomName(new ChatComponentText(ChatColor.GOLD + ""  
                        + ChatColor.BOLD + player.getName() + "'s Pet"));
                WorldServer world = ((CraftWorld) player.getWorld()).getHandle();
                world.addEntity(pet);
                pet.setColor(EnumColor.BLUE);
                
                currentPet.put(player, pet.getBukkitEntity());
            }
            else {
                purchaseItem.put(player, "Blue Sheep Pet"); //Input Name
                purchasePrice.put(player, 100); //Input Price
                PurchaseConstructor.purchaseGui(player, purchaseItem.get(player), purchasePrice.get(player));
            }
        }
        
        //Add Cyan Sheep
        if (event.getSlot() == 16) {
            if (plugin.dataCosmetics.exists(player.getUniqueId(), "Cyan Sheep Pet")) {
                SheepPet pet = new SheepPet(player.getLocation(), player);
                pet.setCustomName(new ChatComponentText(ChatColor.GOLD + ""  
                        + ChatColor.BOLD + player.getName() + "'s Pet"));
                WorldServer world = ((CraftWorld) player.getWorld()).getHandle();
                world.addEntity(pet);
                pet.setColor(EnumColor.CYAN);
                
                currentPet.put(player, pet.getBukkitEntity());
            }
            else {
                purchaseItem.put(player, "Cyan Sheep Pet"); //Input Name
                purchasePrice.put(player, 100); //Input Price
                PurchaseConstructor.purchaseGui(player, purchaseItem.get(player), purchasePrice.get(player));
            }
        }
        
        //Add Light Blue Sheep
        if (event.getSlot() == 19) {
            if (plugin.dataCosmetics.exists(player.getUniqueId(), "Light Blue Sheep Pet")) {
                SheepPet pet = new SheepPet(player.getLocation(), player);
                pet.setCustomName(new ChatComponentText(ChatColor.GOLD + ""  
                        + ChatColor.BOLD + player.getName() + "'s Pet"));
                WorldServer world = ((CraftWorld) player.getWorld()).getHandle();
                world.addEntity(pet);
                pet.setColor(EnumColor.LIGHT_BLUE);
                
                currentPet.put(player, pet.getBukkitEntity());
            }
            else {
                purchaseItem.put(player, "Light Blue Sheep Pet"); //Input Name
                purchasePrice.put(player, 100); //Input Price
                PurchaseConstructor.purchaseGui(player, purchaseItem.get(player), purchasePrice.get(player));
            }
        }
        
        //Add Purple Sheep
        if (event.getSlot() == 20) {
            if (plugin.dataCosmetics.exists(player.getUniqueId(), "Purple Sheep Pet")) {
                SheepPet pet = new SheepPet(player.getLocation(), player);
                pet.setCustomName(new ChatComponentText(ChatColor.GOLD + ""  
                        + ChatColor.BOLD + player.getName() + "'s Pet"));
                WorldServer world = ((CraftWorld) player.getWorld()).getHandle();
                world.addEntity(pet);
                pet.setColor(EnumColor.PURPLE);
                
                currentPet.put(player, pet.getBukkitEntity());
            }
            else {
                purchaseItem.put(player, "Purple Sheep Pet"); //Input Name
                purchasePrice.put(player, 100); //Input Price
                PurchaseConstructor.purchaseGui(player, purchaseItem.get(player), purchasePrice.get(player));
            }
        }
        
        //Add Magenta Sheep
        if (event.getSlot() == 21) {
            if (plugin.dataCosmetics.exists(player.getUniqueId(), "Magenta Sheep Pet")) {
                SheepPet pet = new SheepPet(player.getLocation(), player);
                pet.setCustomName(new ChatComponentText(ChatColor.GOLD + ""  
                        + ChatColor.BOLD + player.getName() + "'s Pet"));
                WorldServer world = ((CraftWorld) player.getWorld()).getHandle();
                world.addEntity(pet);
                pet.setColor(EnumColor.MAGENTA);
                
                currentPet.put(player, pet.getBukkitEntity());
            }
            else {
                purchaseItem.put(player, "Magenta Sheep Pet"); //Input Name
                purchasePrice.put(player, 100); //Input Price
                PurchaseConstructor.purchaseGui(player, purchaseItem.get(player), purchasePrice.get(player));
            }
        }
        
        //Add Pink Sheep
        if (event.getSlot() == 22) {
            if (plugin.dataCosmetics.exists(player.getUniqueId(), "Pink Sheep Pet")) {
                SheepPet pet = new SheepPet(player.getLocation(), player);
                pet.setCustomName(new ChatComponentText(ChatColor.GOLD + ""  
                        + ChatColor.BOLD + player.getName() + "'s Pet"));
                WorldServer world = ((CraftWorld) player.getWorld()).getHandle();
                world.addEntity(pet);
                pet.setColor(EnumColor.PINK);
                
                currentPet.put(player, pet.getBukkitEntity());
            }
            else {
                purchaseItem.put(player, "Pink Sheep Pet"); //Input Name
                purchasePrice.put(player, 100); //Input Price
                PurchaseConstructor.purchaseGui(player, purchaseItem.get(player), purchasePrice.get(player));
            }
        }
        
        //Add Brown Sheep
        if (event.getSlot() == 23) {
            if (plugin.dataCosmetics.exists(player.getUniqueId(), "Brown Sheep Pet")) {
                SheepPet pet = new SheepPet(player.getLocation(), player);
                pet.setCustomName(new ChatComponentText(ChatColor.GOLD + ""  
                        + ChatColor.BOLD + player.getName() + "'s Pet"));
                WorldServer world = ((CraftWorld) player.getWorld()).getHandle();
                world.addEntity(pet);
                pet.setColor(EnumColor.BROWN);
                
                currentPet.put(player, pet.getBukkitEntity());
            }
            else {
                purchaseItem.put(player, "Brown Sheep Pet"); //Input Name
                purchasePrice.put(player, 100); //Input Price
                PurchaseConstructor.purchaseGui(player, purchaseItem.get(player), purchasePrice.get(player));
            }
        }
        
        //Add Black Sheep
        if (event.getSlot() == 24) {
            if (plugin.dataCosmetics.exists(player.getUniqueId(), "Black Sheep Pet")) {
                SheepPet pet = new SheepPet(player.getLocation(), player);
                pet.setCustomName(new ChatComponentText(ChatColor.GOLD + ""  
                        + ChatColor.BOLD + player.getName() + "'s Pet"));
                WorldServer world = ((CraftWorld) player.getWorld()).getHandle();
                world.addEntity(pet);
                pet.setColor(EnumColor.BLACK);
                
                currentPet.put(player, pet.getBukkitEntity());
            }
            else {
                purchaseItem.put(player, "Black Sheep Pet"); //Input Name
                purchasePrice.put(player, 100); //Input Price
                PurchaseConstructor.purchaseGui(player, purchaseItem.get(player), purchasePrice.get(player));
            }
        }
        
        //Add Gray Sheep
        if (event.getSlot() == 25) {
            if (plugin.dataCosmetics.exists(player.getUniqueId(), "Gray Sheep Pet")) {
                SheepPet pet = new SheepPet(player.getLocation(), player);
                pet.setCustomName(new ChatComponentText(ChatColor.GOLD + ""  
                        + ChatColor.BOLD + player.getName() + "'s Pet"));
                WorldServer world = ((CraftWorld) player.getWorld()).getHandle();
                world.addEntity(pet);
                pet.setColor(EnumColor.GRAY);
                
                currentPet.put(player, pet.getBukkitEntity());
            }
            else {
                purchaseItem.put(player, "Gray Sheep Pet"); //Input Name
                purchasePrice.put(player, 100); //Input Price
                PurchaseConstructor.purchaseGui(player, purchaseItem.get(player), purchasePrice.get(player));
            }
        }
        
        //Add Light Gray Sheep
        if (event.getSlot() == 28) {
            if (plugin.dataCosmetics.exists(player.getUniqueId(), "Light Gray Sheep Pet")) {
                SheepPet pet = new SheepPet(player.getLocation(), player);
                pet.setCustomName(new ChatComponentText(ChatColor.GOLD + ""  
                        + ChatColor.BOLD + player.getName() + "'s Pet"));
                WorldServer world = ((CraftWorld) player.getWorld()).getHandle();
                world.addEntity(pet);
                pet.setColor(EnumColor.LIGHT_GRAY);
                
                currentPet.put(player, pet.getBukkitEntity());
            }
            else {
                purchaseItem.put(player, "Light Gray Sheep Pet"); //Input Name
                purchasePrice.put(player, 100); //Input Price
                PurchaseConstructor.purchaseGui(player, purchaseItem.get(player), purchasePrice.get(player));
            }
        }
        
        //Add White Sheep
        if (event.getSlot() == 29) {
            if (plugin.dataCosmetics.exists(player.getUniqueId(), "White Sheep Pet")) {
                SheepPet pet = new SheepPet(player.getLocation(), player);
                pet.setCustomName(new ChatComponentText(ChatColor.GOLD + ""  
                        + ChatColor.BOLD + player.getName() + "'s Pet"));
                WorldServer world = ((CraftWorld) player.getWorld()).getHandle();
                world.addEntity(pet);
                pet.setColor(EnumColor.WHITE);
                
                currentPet.put(player, pet.getBukkitEntity());
            }
            else {
                purchaseItem.put(player, "White Sheep Pet"); //Input Name
                purchasePrice.put(player, 100); //Input Price
                PurchaseConstructor.purchaseGui(player, purchaseItem.get(player), purchasePrice.get(player));
            }
        }
        
        //Back Arrow
        if (event.getSlot() == 39) {
            petgui.ExampleGui(player);
            plugin.getServer().getScheduler().runTask(plugin, () -> {
                player.openInventory(petgui.inv);
            });
        }
        
        // Remove Pet Option
        if (event.getSlot() == 40) {
            RemoveEffects.ClearEffects(player);
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
        
        // Remove Active Cosmetics when selecting new pet
        if (event.getSlot() < 35) {
            RemoveEffects.ClearEffects(player);
        }
        
        //Add Red Baby Sheep
        if (event.getSlot() == 10) {
            if (plugin.dataCosmetics.exists(player.getUniqueId(), "Red Baby Sheep Pet")) {
                SheepPet pet = new SheepPet(player.getLocation(), player);
                pet.setCustomName(new ChatComponentText(ChatColor.GOLD + ""  
                        + ChatColor.BOLD + player.getName() + "'s Pet"));
                WorldServer world = ((CraftWorld) player.getWorld()).getHandle();
                world.addEntity(pet);
                pet.setAge(-99999999);
                pet.setColor(EnumColor.RED);
                
                currentPet.put(player, pet.getBukkitEntity());
            }
            else {
                purchaseItem.put(player, "Red Baby Sheep Pet"); //Input Name
                purchasePrice.put(player, 100); //Input Price
                PurchaseConstructor.purchaseGui(player, purchaseItem.get(player), purchasePrice.get(player));
            }
        }
        
        //Add Orange Baby Sheep
        if (event.getSlot() == 11) {
            if (plugin.dataCosmetics.exists(player.getUniqueId(), "Orange Baby Sheep Pet")) {
                SheepPet pet = new SheepPet(player.getLocation(), player);
                pet.setCustomName(new ChatComponentText(ChatColor.GOLD + ""  
                        + ChatColor.BOLD + player.getName() + "'s Pet"));
                WorldServer world = ((CraftWorld) player.getWorld()).getHandle();
                world.addEntity(pet);
                pet.setAge(-99999999);
                pet.setColor(EnumColor.ORANGE);
                
                currentPet.put(player, pet.getBukkitEntity());
            }
            else {
                purchaseItem.put(player, "Orange Baby Sheep Pet"); //Input Name
                purchasePrice.put(player, 100); //Input Price
                PurchaseConstructor.purchaseGui(player, purchaseItem.get(player), purchasePrice.get(player));
            }
        }
        
        //Add Yellow Baby Sheep
        if (event.getSlot() == 12) {
            if (plugin.dataCosmetics.exists(player.getUniqueId(), "Yellow Baby Sheep Pet")) {
                SheepPet pet = new SheepPet(player.getLocation(), player);
                pet.setCustomName(new ChatComponentText(ChatColor.GOLD + ""  
                        + ChatColor.BOLD + player.getName() + "'s Pet"));
                WorldServer world = ((CraftWorld) player.getWorld()).getHandle();
                world.addEntity(pet);
                pet.setAge(-99999999);
                pet.setColor(EnumColor.YELLOW);
                
                currentPet.put(player, pet.getBukkitEntity());
            }
            else {
                purchaseItem.put(player, "Yellow Baby Sheep Pet"); //Input Name
                purchasePrice.put(player, 100); //Input Price
                PurchaseConstructor.purchaseGui(player, purchaseItem.get(player), purchasePrice.get(player));
            }
        }
        
        //Add Green Baby Sheep
        if (event.getSlot() == 13) {
            if (plugin.dataCosmetics.exists(player.getUniqueId(), "Green Baby Sheep Pet")) {
                SheepPet pet = new SheepPet(player.getLocation(), player);
                pet.setCustomName(new ChatComponentText(ChatColor.GOLD + ""  
                        + ChatColor.BOLD + player.getName() + "'s Pet"));
                WorldServer world = ((CraftWorld) player.getWorld()).getHandle();
                world.addEntity(pet);
                pet.setAge(-99999999);
                pet.setColor(EnumColor.GREEN);
                
                currentPet.put(player, pet.getBukkitEntity());
            }
            else {
                purchaseItem.put(player, "Green Baby Sheep Pet"); //Input Name
                purchasePrice.put(player, 100); //Input Price
                PurchaseConstructor.purchaseGui(player, purchaseItem.get(player), purchasePrice.get(player));
            }
        }
        
        //Add Lime Baby Sheep
        if (event.getSlot() == 14) {
            if (plugin.dataCosmetics.exists(player.getUniqueId(), "Lime Baby Sheep Pet")) {
                SheepPet pet = new SheepPet(player.getLocation(), player);
                pet.setCustomName(new ChatComponentText(ChatColor.GOLD + ""  
                        + ChatColor.BOLD + player.getName() + "'s Pet"));
                WorldServer world = ((CraftWorld) player.getWorld()).getHandle();
                world.addEntity(pet);
                pet.setAge(-99999999);
                pet.setColor(EnumColor.LIME);
                
                currentPet.put(player, pet.getBukkitEntity());
            }
            else {
                purchaseItem.put(player, "Lime Baby Sheep Pet"); //Input Name
                purchasePrice.put(player, 100); //Input Price
                PurchaseConstructor.purchaseGui(player, purchaseItem.get(player), purchasePrice.get(player));
            }
        }
        
        //Add Blue Baby Sheep
        if (event.getSlot() == 15) {
            if (plugin.dataCosmetics.exists(player.getUniqueId(), "Blue Baby Sheep Pet")) {
                SheepPet pet = new SheepPet(player.getLocation(), player);
                pet.setCustomName(new ChatComponentText(ChatColor.GOLD + ""  
                        + ChatColor.BOLD + player.getName() + "'s Pet"));
                WorldServer world = ((CraftWorld) player.getWorld()).getHandle();
                world.addEntity(pet);
                pet.setAge(-99999999);
                pet.setColor(EnumColor.BLUE);
                
                currentPet.put(player, pet.getBukkitEntity());
            }
            else {
                purchaseItem.put(player, "Blue Baby Sheep Pet"); //Input Name
                purchasePrice.put(player, 100); //Input Price
                PurchaseConstructor.purchaseGui(player, purchaseItem.get(player), purchasePrice.get(player));
            }
        }
        
        //Add Cyan Baby Sheep
        if (event.getSlot() == 16) {
            if (plugin.dataCosmetics.exists(player.getUniqueId(), "Cyan Baby Sheep Pet")) {
                SheepPet pet = new SheepPet(player.getLocation(), player);
                pet.setCustomName(new ChatComponentText(ChatColor.GOLD + ""  
                        + ChatColor.BOLD + player.getName() + "'s Pet"));
                WorldServer world = ((CraftWorld) player.getWorld()).getHandle();
                world.addEntity(pet);
                pet.setAge(-99999999);
                pet.setColor(EnumColor.CYAN);
                
                currentPet.put(player, pet.getBukkitEntity());
            }
            else {
                purchaseItem.put(player, "Cyan Baby Sheep Pet"); //Input Name
                purchasePrice.put(player, 100); //Input Price
                PurchaseConstructor.purchaseGui(player, purchaseItem.get(player), purchasePrice.get(player));
            }
        }
        
        //Add Light Blue Baby Sheep
        if (event.getSlot() == 19) {
            if (plugin.dataCosmetics.exists(player.getUniqueId(), "Light Blue Baby Sheep Pet")) {
                SheepPet pet = new SheepPet(player.getLocation(), player);
                pet.setCustomName(new ChatComponentText(ChatColor.GOLD + ""  
                        + ChatColor.BOLD + player.getName() + "'s Pet"));
                WorldServer world = ((CraftWorld) player.getWorld()).getHandle();
                world.addEntity(pet);
                pet.setAge(-99999999);
                pet.setColor(EnumColor.LIGHT_BLUE);
                
                currentPet.put(player, pet.getBukkitEntity());
            }
            else {
                purchaseItem.put(player, "Light Blue Baby Sheep Pet"); //Input Name
                purchasePrice.put(player, 100); //Input Price
                PurchaseConstructor.purchaseGui(player, purchaseItem.get(player), purchasePrice.get(player));
            }
        }
        
        //Add Purple Baby Sheep
        if (event.getSlot() == 20) {
            if (plugin.dataCosmetics.exists(player.getUniqueId(), "Purple Baby Sheep Pet")) {
                SheepPet pet = new SheepPet(player.getLocation(), player);
                pet.setCustomName(new ChatComponentText(ChatColor.GOLD + ""  
                        + ChatColor.BOLD + player.getName() + "'s Pet"));
                WorldServer world = ((CraftWorld) player.getWorld()).getHandle();
                world.addEntity(pet);
                pet.setAge(-99999999);
                pet.setColor(EnumColor.PURPLE);
                
                currentPet.put(player, pet.getBukkitEntity());
            }
            else {
                purchaseItem.put(player, "Purple Baby Sheep Pet"); //Input Name
                purchasePrice.put(player, 100); //Input Price
                PurchaseConstructor.purchaseGui(player, purchaseItem.get(player), purchasePrice.get(player));
            }
        }
        
        //Add Magenta Baby Sheep
        if (event.getSlot() == 21) {
            if (plugin.dataCosmetics.exists(player.getUniqueId(), "Magenta Baby Sheep Pet")) {
                SheepPet pet = new SheepPet(player.getLocation(), player);
                pet.setCustomName(new ChatComponentText(ChatColor.GOLD + ""  
                        + ChatColor.BOLD + player.getName() + "'s Pet"));
                WorldServer world = ((CraftWorld) player.getWorld()).getHandle();
                world.addEntity(pet);
                pet.setAge(-99999999);
                pet.setColor(EnumColor.MAGENTA);
                
                currentPet.put(player, pet.getBukkitEntity());
            }
            else {
                purchaseItem.put(player, "Magenta Baby Sheep Pet"); //Input Name
                purchasePrice.put(player, 100); //Input Price
                PurchaseConstructor.purchaseGui(player, purchaseItem.get(player), purchasePrice.get(player));
            }
        }
        
        //Add Pink Baby Sheep
        if (event.getSlot() == 22) {
            if (plugin.dataCosmetics.exists(player.getUniqueId(), "Pink Baby Sheep Pet")) {
                SheepPet pet = new SheepPet(player.getLocation(), player);
                pet.setCustomName(new ChatComponentText(ChatColor.GOLD + ""  
                        + ChatColor.BOLD + player.getName() + "'s Pet"));
                WorldServer world = ((CraftWorld) player.getWorld()).getHandle();
                world.addEntity(pet);
                pet.setAge(-99999999);
                pet.setColor(EnumColor.PINK);
                
                currentPet.put(player, pet.getBukkitEntity());
            }
            else {
                purchaseItem.put(player, "Pink Baby Sheep Pet"); //Input Name
                purchasePrice.put(player, 100); //Input Price
                PurchaseConstructor.purchaseGui(player, purchaseItem.get(player), purchasePrice.get(player));
            }
        }
        
        //Add Brown Baby Sheep
        if (event.getSlot() == 23) {
            if (plugin.dataCosmetics.exists(player.getUniqueId(), "Brown Baby Sheep Pet")) {
                SheepPet pet = new SheepPet(player.getLocation(), player);
                pet.setCustomName(new ChatComponentText(ChatColor.GOLD + ""  
                        + ChatColor.BOLD + player.getName() + "'s Pet"));
                WorldServer world = ((CraftWorld) player.getWorld()).getHandle();
                world.addEntity(pet);
                pet.setAge(-99999999);
                pet.setColor(EnumColor.BROWN);
                
                currentPet.put(player, pet.getBukkitEntity());
            }
            else {
                purchaseItem.put(player, "Brown Baby Sheep Pet"); //Input Name
                purchasePrice.put(player, 100); //Input Price
                PurchaseConstructor.purchaseGui(player, purchaseItem.get(player), purchasePrice.get(player));
            }
        }
        
        //Add Black Baby Sheep
        if (event.getSlot() == 24) {
            if (plugin.dataCosmetics.exists(player.getUniqueId(), "Black Baby Sheep Pet")) {
                SheepPet pet = new SheepPet(player.getLocation(), player);
                pet.setCustomName(new ChatComponentText(ChatColor.GOLD + ""  
                        + ChatColor.BOLD + player.getName() + "'s Pet"));
                WorldServer world = ((CraftWorld) player.getWorld()).getHandle();
                world.addEntity(pet);
                pet.setAge(-99999999);
                pet.setColor(EnumColor.BLACK);
                
                currentPet.put(player, pet.getBukkitEntity());
            }
            else {
                purchaseItem.put(player, "Black Baby Sheep Pet"); //Input Name
                purchasePrice.put(player, 100); //Input Price
                PurchaseConstructor.purchaseGui(player, purchaseItem.get(player), purchasePrice.get(player));
            }
        }
        
        //Add Gray Baby Sheep
        if (event.getSlot() == 25) {
            if (plugin.dataCosmetics.exists(player.getUniqueId(), "Gray Baby Sheep Pet")) {
                SheepPet pet = new SheepPet(player.getLocation(), player);
                pet.setCustomName(new ChatComponentText(ChatColor.GOLD + ""  
                        + ChatColor.BOLD + player.getName() + "'s Pet"));
                WorldServer world = ((CraftWorld) player.getWorld()).getHandle();
                world.addEntity(pet);
                pet.setAge(-99999999);
                pet.setColor(EnumColor.GRAY);
                
                currentPet.put(player, pet.getBukkitEntity());
            }
            else {
                purchaseItem.put(player, "Gray Baby Sheep Pet"); //Input Name
                purchasePrice.put(player, 100); //Input Price
                PurchaseConstructor.purchaseGui(player, purchaseItem.get(player), purchasePrice.get(player));
            }
        }
        
        //Add Light Gray Baby Sheep
        if (event.getSlot() == 28) {
            if (plugin.dataCosmetics.exists(player.getUniqueId(), "Light Gray Baby Sheep Pet")) {
                SheepPet pet = new SheepPet(player.getLocation(), player);
                pet.setCustomName(new ChatComponentText(ChatColor.GOLD + ""  
                        + ChatColor.BOLD + player.getName() + "'s Pet"));
                WorldServer world = ((CraftWorld) player.getWorld()).getHandle();
                world.addEntity(pet);
                pet.setAge(-99999999);
                pet.setColor(EnumColor.LIGHT_GRAY);
                
                currentPet.put(player, pet.getBukkitEntity());
            }
            else {
                purchaseItem.put(player, "Light Gray Baby Sheep Pet"); //Input Name
                purchasePrice.put(player, 100); //Input Price
                PurchaseConstructor.purchaseGui(player, purchaseItem.get(player), purchasePrice.get(player));
            }
        }
        
        //Add White Baby Sheep
        if (event.getSlot() == 29) {
            if (plugin.dataCosmetics.exists(player.getUniqueId(), "White Baby Sheep Pet")) {
                SheepPet pet = new SheepPet(player.getLocation(), player);
                pet.setCustomName(new ChatComponentText(ChatColor.GOLD + ""  
                        + ChatColor.BOLD + player.getName() + "'s Pet"));
                WorldServer world = ((CraftWorld) player.getWorld()).getHandle();
                world.addEntity(pet);
                pet.setAge(-99999999);
                pet.setColor(EnumColor.WHITE);
                
                currentPet.put(player, pet.getBukkitEntity());
            }
            else {
                purchaseItem.put(player, "White Baby Sheep Pet"); //Input Name
                purchasePrice.put(player, 100); //Input Price
                PurchaseConstructor.purchaseGui(player, purchaseItem.get(player), purchasePrice.get(player));
            }
        }
        
        //Back Arrow
        if (event.getSlot() == 39) {
            petgui.ExampleGui(player);
            plugin.getServer().getScheduler().runTask(plugin, () -> {
                player.openInventory(petgui.inv);
            });
        }
        
        // Remove Pet Option
        if (event.getSlot() == 40) {
            RemoveEffects.ClearEffects(player);
        }
        
        player.closeInventory();
    }
    
    
}
