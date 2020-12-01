package cosmetics.pets.listeners;

import java.util.HashMap;

import org.bukkit.ChatColor;
import org.bukkit.DyeColor;
import org.bukkit.entity.Ageable;
import org.bukkit.entity.Animals;
import org.bukkit.entity.Cat;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Sheep;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import cosmetics.CosmeticGui;
import cosmetics.Cosmetics;
import cosmetics.PurchaseConstructor;
import cosmetics.RemoveEffects;
import cosmetics.pets.BabySheepColourGUI;
import cosmetics.pets.CatTypeGui;
import cosmetics.pets.PetGui;
import cosmetics.pets.PetGui2;
import cosmetics.pets.SheepColourGUI;

public class PetGuiListeners implements Listener {

    private Cosmetics plugin;
    
    public PurchaseConstructor PurchaseConstructor = Cosmetics.PurchaseConstructor;
    public HashMap<Player, String> purchaseItem = Cosmetics.purchaseItem;
    public HashMap<Player, Integer> purchasePrice = Cosmetics.purchasePrice;

    public PetGuiListeners(Cosmetics b) {
        plugin = b;
    }
    
    public static RemoveEffects RemoveEffects = new RemoveEffects();
    
    public static HashMap<Player, Entity> currentPet = new HashMap<>();
    //public static HashMap<Player, Entity> currentnewpet = new HashMap<>();
    
    //Pet Spawner
    public void PetSpawn(Player player, EntityType entity, Boolean isbaby) {
        LivingEntity pet = (LivingEntity) player.getWorld().spawnEntity(player.getLocation(), entity);
        pet.setAI(false);
        
        //Code for baby pets
        if (isbaby == true) {
            if (entity == EntityType.ZOMBIE || entity == EntityType.HUSK) {
                Ageable zomb = (Ageable) pet;
                zomb.setBaby();
            }
            else {
                Animals baby = (Animals) pet;
                baby.setBaby();
                baby.setAgeLock(true);  
            }
        }
        
        pet.setInvulnerable(true);
        pet.setCustomName(ChatColor.GOLD + ""  + ChatColor.BOLD + player.getName() + "'s Pet");
        currentPet.put(player, pet);
    }
    
    //Pet Equiper
    public void PetEquip(Player player, EntityType entity, Boolean isbaby, int price, String name) {
        if (plugin.dataCosmetics.exists(player.getUniqueId(), name)) {
            PetSpawn(player, entity, isbaby);
        }
        else {
            purchaseItem.put(player, name); //Input Name
            purchasePrice.put(player, price); //Input Price
            PurchaseConstructor.purchaseGui(player, purchaseItem.get(player), purchasePrice.get(player));
        }
    }
    
    
    //Sheep Spawner
    public void SheepSpawn(Player player, DyeColor sheepColor, Boolean isbaby) {
        LivingEntity pet = (LivingEntity) player.getWorld().spawnEntity(player.getLocation(), EntityType.SHEEP);
        pet.setAI(false);
        
        Sheep sheep = (Sheep) pet;
        sheep.setColor(sheepColor);
        
        //Code for baby pets
        if (isbaby == true) {
            Animals baby = (Animals) pet;
            baby.setBaby();
            baby.setAgeLock(true);
        }
        
        pet.setInvulnerable(true);
        pet.setCustomName(ChatColor.GOLD + ""  + ChatColor.BOLD + player.getName() + "'s Pet");
        currentPet.put(player, pet);
    }
    
    //Sheep Equiper
    public void SheepEquip(Player player, DyeColor sheepColor, Boolean isbaby, int price, String name) {
        if (plugin.dataCosmetics.exists(player.getUniqueId(), name)) {
            SheepSpawn(player, sheepColor, isbaby);
        }
        else {
            purchaseItem.put(player, name); //Input Name
            purchasePrice.put(player, price); //Input Price
            PurchaseConstructor.purchaseGui(player, purchaseItem.get(player), purchasePrice.get(player));
        }
    }
    
    
    //Cat Spawner
    public void CatSpawn(Player player, Cat.Type catType, Boolean isbaby) {
        LivingEntity pet = (LivingEntity) player.getWorld().spawnEntity(player.getLocation(), EntityType.CAT);
        pet.setAI(false);
        
        Cat cat = (Cat) pet;
        cat.setCatType(catType);
        
        //Code for baby pets
        if (isbaby == true) {
            Animals baby = (Animals) pet;
            baby.setBaby();
            baby.setAgeLock(true);
        }
        
        pet.setInvulnerable(true);
        pet.setCustomName(ChatColor.GOLD + ""  + ChatColor.BOLD + player.getName() + "'s Pet");
        currentPet.put(player, pet);
    }
    
    //Cat Equiper
    public void CatEquip(Player player, Cat.Type catType, Boolean isbaby, int price, String name) {
        if (plugin.dataCosmetics.exists(player.getUniqueId(), name)) {
            CatSpawn(player, catType, isbaby);
        }
        else {
            purchaseItem.put(player, name); //Input Name
            purchasePrice.put(player, price); //Input Price
            PurchaseConstructor.purchaseGui(player, purchaseItem.get(player), purchasePrice.get(player));
        }
    }
    
    //////
    //Clicking Inside the main Pet Selector GUI Page 1/1
    @EventHandler()
    public void onPetGuiClick(InventoryClickEvent event) {
        if (!(event.getInventory().getHolder() instanceof PetGui))
            return;
        if (event.getCurrentItem() == null) return;
        if (event.getCurrentItem().getItemMeta() == null) return;
        if (event.getCurrentItem().getItemMeta().getDisplayName() == null) return;
        if (event.getRawSlot() > 53) return;
        
        event.setCancelled(true);
        
        Player player = (Player) event.getWhoClicked();
        
        // Remove Active Cosmetics when selecting new pet
        if (event.getSlot() < 35) {
            RemoveEffects.ClearEffects(player);
        }

        //Add Llama
        if (event.getSlot() == 10) {
            PetEquip(player, EntityType.LLAMA, false, 200, "Llama Pet");
        }
        
        //Add Baby Llama
        if (event.getSlot() == 11) {
            PetEquip(player, EntityType.LLAMA, true, 200, "Baby Llama Pet");
        }
        
        //Add Pig
        if (event.getSlot() == 12) {
            PetEquip(player, EntityType.PIG, false, 200, "Pig Pet");
        }
        
        //Add Baby Pig
        if (event.getSlot() == 13) {
            PetEquip(player, EntityType.PIG, true, 200, "Baby Pig Pet");
        }
        
        //Add Chicken
        if (event.getSlot() == 14) {
            PetEquip(player, EntityType.CHICKEN, false, 200, "Chicken Pet");
        }
        
        //Add Baby Chicken
        if (event.getSlot() == 15) {
            PetEquip(player, EntityType.CHICKEN, true, 200, "Baby Chicken Pet");
        }
        
        //Go to Sheep Gui
        if (event.getSlot() == 16) {
            plugin.getServer().getScheduler().runTask(plugin, () -> {
                player.openInventory(new SheepColourGUI(plugin, player).getInventory());
            });
        }
        
        //Add Baby Sheep
        if (event.getSlot() == 19) {
            plugin.getServer().getScheduler().runTask(plugin, () -> {
                player.openInventory(new BabySheepColourGUI(plugin, player).getInventory());
            });
        }
        
        //Add Cow
        if (event.getSlot() == 20) {
            PetEquip(player, EntityType.COW, false, 200, "Cow Pet");
        }
        
        //Add Baby Cow
        if (event.getSlot() == 21) {
            PetEquip(player, EntityType.COW, true, 200, "Baby Cow Pet");
        }
        
        //Add Mooshroom
        if (event.getSlot() == 22) {
            PetEquip(player, EntityType.MUSHROOM_COW, false, 200, "Mooshroom Pet");
        }
        
        //Add Fox
        if (event.getSlot() == 23) {
            PetEquip(player, EntityType.FOX, false, 200, "Fox Pet");
        }
        
        //Add Baby Fox
        if (event.getSlot() == 24) {
            PetEquip(player, EntityType.FOX, true, 200, "Baby Fox Pet");
        }
        
        //Add Panda
        if (event.getSlot() == 25) {
            PetEquip(player, EntityType.PANDA, false, 200, "Panda Pet");
        }
        
        //Add Baby Panda
        if (event.getSlot() == 28) {
            PetEquip(player, EntityType.PANDA, true, 200, "Baby Panda Pet");
        }
        
        //Add Wolf
        if (event.getSlot() == 29) {
            PetEquip(player, EntityType.WOLF, false, 200, "Wolf Pet");
        }
        
        //Add Baby Wolf
        if (event.getSlot() == 30) {
            PetEquip(player, EntityType.WOLF, true, 200, "Baby Wolf Pet");
        }
        
        //Add Polar Bear
        if (event.getSlot() == 31) {
            PetEquip(player, EntityType.POLAR_BEAR, false, 200, "Polar Bear Pet");
        }
        
        //Add Baby Polar Bear
        if (event.getSlot() == 32) {
            PetEquip(player, EntityType.POLAR_BEAR, true, 200, "Baby Polar Bear Pet");
        }
        
        //Add Ocelot
        if (event.getSlot() == 33) {
            PetEquip(player, EntityType.OCELOT, false, 200, "Ocelot Pet");
        }
        
        //Add Cat
        if (event.getSlot() == 34) {
            plugin.getServer().getScheduler().runTask(plugin, () -> {
                player.openInventory(new CatTypeGui(plugin, player).getInventory());
            });
        }
        
        
        // Remove Pet Option
        if (event.getSlot() == 40) {
            RemoveEffects.ClearEffects(player);
        }
        
        // Return to cosmetic window
        if (event.getSlot() == 39) {
            plugin.getServer().getScheduler().runTask(plugin, () -> {
                player.openInventory(new CosmeticGui(plugin, player).getInventory());
            });
        }
        
        // Pet Gui Page 2
        if (event.getSlot() == 41) {
            plugin.getServer().getScheduler().runTask(plugin, () -> {
                player.openInventory(new PetGui2(plugin, player).getInventory());
            });
        }
        
        //Close Menu
        player.closeInventory();
    }
    
    //////
    //PetGui Page 2
    @EventHandler()
    public void onPetGui2Click(InventoryClickEvent event) {
        if (!(event.getInventory().getHolder() instanceof PetGui2))
            return;
        if (event.getCurrentItem() == null) return;
        if (event.getCurrentItem().getItemMeta() == null) return;
        if (event.getCurrentItem().getItemMeta().getDisplayName() == null) return;
        if (event.getRawSlot() > 53) return;
        
        event.setCancelled(true);
        
        Player player = (Player) event.getWhoClicked();
        
        // Remove Active Cosmetics when selecting new pet
        if (event.getSlot() < 35) {
            RemoveEffects.ClearEffects(player);
        }
        
        //Add Turtle
        if (event.getSlot() == 10) {
            PetEquip(player, EntityType.TURTLE, false, 200, "Turtle Pet");
        }
        
        //Add Creeper
        if (event.getSlot() == 11) {
            PetEquip(player, EntityType.CREEPER, false, 200, "Creeper Pet");
        }
        
        //Add Horse
        if (event.getSlot() == 12) {
            PetEquip(player, EntityType.HORSE, false, 200, "Horse Pet");
        }
        
        //Add Blaze
        if (event.getSlot() == 13) {
            PetEquip(player, EntityType.BLAZE, false, 200, "Blaze Pet");
        }
        
        //Add Witch
        if (event.getSlot() == 14) {
            PetEquip(player, EntityType.WITCH, false, 200, "Witch Pet");
        }
        
        //Add Husk
        if (event.getSlot() == 15) {
            PetEquip(player, EntityType.HUSK, false, 200, "Husk Pet");
        }
        
        //Add Baby Husk
        if (event.getSlot() == 16) {
            PetEquip(player, EntityType.HUSK, true, 200, "Baby Husk Pet");
        }
        
        //Add Zombie
        if (event.getSlot() == 19) {
            PetEquip(player, EntityType.ZOMBIE, false, 200, "Zombie Pet");
        }
        
        //Add Baby Zombie
        if (event.getSlot() == 20) {
            PetEquip(player, EntityType.ZOMBIE, true, 200, "Baby Zombie Pet");
        }
        
        //Add Snowman
        if (event.getSlot() == 21) {
            PetEquip(player, EntityType.SNOWMAN, false, 200, "Snowman Pet");
        }
        
        //Add Iron Golem
        if (event.getSlot() == 22) {
            PetEquip(player, EntityType.IRON_GOLEM, false, 200, "Golem Pet");
        }
        
        //Add Rabbit
        if (event.getSlot() == 23) {
            PetEquip(player, EntityType.RABBIT, false, 200, "Rabbit Pet");
        }
        
    
        // Remove Pet Option
        if (event.getSlot() == 40) {
            RemoveEffects.ClearEffects(player);
        }
        
        // Pet Gui Page 2
        if (event.getSlot() == 39) {
            plugin.getServer().getScheduler().runTask(plugin, () -> {
                player.openInventory(new PetGui(plugin, player).getInventory());
            });
        }
        
        //Close Menu
        player.closeInventory();
    }
    
    //////
    //Clicking Inside the main Sheep Colour Selector GUI
    @EventHandler()
    public void onSheepColourGuiClick(InventoryClickEvent event) {
        if (!(event.getInventory().getHolder() instanceof SheepColourGUI))
            return;
        if (event.getCurrentItem() == null) return;
        if (event.getCurrentItem().getItemMeta() == null) return;
        if (event.getCurrentItem().getItemMeta().getDisplayName() == null) return;
        if (event.getRawSlot() > 53) return;
        
        event.setCancelled(true);
        
        Player player = (Player) event.getWhoClicked();
        
        // Remove Active Cosmetics when selecting new pet
        if (event.getSlot() < 35) {
            RemoveEffects.ClearEffects(player);
        }
        
        //Add Red Sheep
        if (event.getSlot() == 10) {
            SheepEquip(player, DyeColor.RED, false, 200, "Red Sheep Pet");
        }
        
        //Add Orange Sheep
        if (event.getSlot() == 11) {
            SheepEquip(player, DyeColor.ORANGE, false, 200, "Orange Sheep Pet");
        }
        
        //Add Yellow Sheep
        if (event.getSlot() == 12) {
            SheepEquip(player, DyeColor.YELLOW, false, 200, "Yellow Sheep Pet");
        }
        
        //Add Green Sheep
        if (event.getSlot() == 13) {
            SheepEquip(player, DyeColor.GREEN, false, 200, "Green Sheep Pet");
        }
        
        //Add Lime Sheep
        if (event.getSlot() == 14) {
            SheepEquip(player, DyeColor.LIME, false, 200, "Lime Sheep Pet");
        }
        
        //Add Blue Sheep
        if (event.getSlot() == 15) {
            SheepEquip(player, DyeColor.BLUE, false, 200, "Blue Sheep Pet");
        }
        
        //Add Cyan Sheep
        if (event.getSlot() == 16) {
            SheepEquip(player, DyeColor.CYAN, false, 200, "Cyan Sheep Pet");
        }
        
        //Add Light Blue Sheep
        if (event.getSlot() == 19) {
            SheepEquip(player, DyeColor.LIGHT_BLUE, false, 200, "Light Blue Sheep Pet");
        }
        
        //Add Purple Sheep
        if (event.getSlot() == 20) {
            SheepEquip(player, DyeColor.PURPLE, false, 200, "Purple Sheep Pet");
        }
        
        //Add Magenta Sheep
        if (event.getSlot() == 21) {
            SheepEquip(player, DyeColor.MAGENTA, false, 200, "Magenta Sheep Pet");
        }
        
        //Add Pink Sheep
        if (event.getSlot() == 22) {
            SheepEquip(player, DyeColor.PINK, false, 200, "Pink Sheep Pet");
        }
        
        //Add Brown Sheep
        if (event.getSlot() == 23) {
            SheepEquip(player, DyeColor.BROWN, false, 200, "Brown Sheep Pet");
        }
        
        //Add Black Sheep
        if (event.getSlot() == 24) {
            SheepEquip(player, DyeColor.BLACK, false, 200, "Black Sheep Pet");
        }
        
        //Add Gray Sheep
        if (event.getSlot() == 25) {
            SheepEquip(player, DyeColor.GRAY, false, 200, "Gray Sheep Pet");
        }
        
        //Add Light Gray Sheep
        if (event.getSlot() == 28) {
            SheepEquip(player, DyeColor.LIGHT_GRAY, false, 200, "Light Gray Sheep Pet");
        }
        
        //Add White Sheep
        if (event.getSlot() == 29) {
            SheepEquip(player, DyeColor.WHITE, false, 200, "White Sheep Pet");
        }
        
        //Back Arrow
        if (event.getSlot() == 39) {
            plugin.getServer().getScheduler().runTask(plugin, () -> {
                player.openInventory(new PetGui(plugin, player).getInventory());
            });
        }
        
        // Remove Pet Option
        if (event.getSlot() == 40) {
            RemoveEffects.ClearEffects(player);
        }
        
        //Close Menu
        player.closeInventory();
    }
    
    //////
    //Clicking Inside the main Baby Sheep Colour Selector GUI
    @EventHandler()
    public void onBabySheepColourGuiClick(InventoryClickEvent event) {
        if (!(event.getInventory().getHolder() instanceof BabySheepColourGUI))
            return;
        if (event.getCurrentItem() == null) return;
        if (event.getCurrentItem().getItemMeta() == null) return;
        if (event.getCurrentItem().getItemMeta().getDisplayName() == null) return;
        if (event.getRawSlot() > 53) return;
        
        event.setCancelled(true);
        
        Player player = (Player) event.getWhoClicked();
        
        // Remove Active Cosmetics when selecting new pet
        if (event.getSlot() < 35) {
            RemoveEffects.ClearEffects(player);
        }
        
        //Add Baby Red Sheep
        if (event.getSlot() == 10) {
            SheepEquip(player, DyeColor.RED, true, 200, "Red Baby Sheep Pet");
        }
        
        //Add Baby Orange Sheep
        if (event.getSlot() == 11) {
            SheepEquip(player, DyeColor.ORANGE, true, 200, "Orange Baby Sheep Pet");
        }
        
        //Add Baby Yellow Sheep
        if (event.getSlot() == 12) {
            SheepEquip(player, DyeColor.YELLOW, true, 200, "Yellow Baby Sheep Pet");
        }
        
        //Add Baby Green Sheep
        if (event.getSlot() == 13) {
            SheepEquip(player, DyeColor.GREEN, true, 200, "Green Baby Sheep Pet");
        }
        
        //Add Baby Lime Sheep
        if (event.getSlot() == 14) {
            SheepEquip(player, DyeColor.LIME, true, 200, "Lime Baby Sheep Pet");
        }
        
        //Add Baby Blue Sheep
        if (event.getSlot() == 15) {
            SheepEquip(player, DyeColor.BLUE, true, 200, "Blue Baby Sheep Pet");
        }
        
        //Add Baby Cyan Sheep
        if (event.getSlot() == 16) {
            SheepEquip(player, DyeColor.CYAN, true, 200, "Cyan Baby Sheep Pet");
        }
        
        //Add Baby Light Blue Sheep
        if (event.getSlot() == 19) {
            SheepEquip(player, DyeColor.LIGHT_BLUE, true, 200, "Light Blue Baby Sheep Pet");
        }
        
        //Add Baby Purple Sheep
        if (event.getSlot() == 20) {
            SheepEquip(player, DyeColor.PURPLE, true, 200, "Purple Baby Sheep Pet");
        }
        
        //Add Baby Magenta Sheep
        if (event.getSlot() == 21) {
            SheepEquip(player, DyeColor.MAGENTA, true, 200, "Magenta Baby Sheep Pet");
        }
        
        //Add Baby Pink Sheep
        if (event.getSlot() == 22) {
            SheepEquip(player, DyeColor.PINK, true, 200, "Pink Baby Sheep Pet");
        }
        
        //Add Baby Brown Sheep
        if (event.getSlot() == 23) {
            SheepEquip(player, DyeColor.BROWN, true, 200, "Brown Baby Sheep Pet");
        }
        
        //Add Baby Black Sheep
        if (event.getSlot() == 24) {
            SheepEquip(player, DyeColor.BLACK, true, 200, "Black Baby Sheep Pet");
        }
        
        //Add Baby Gray Sheep
        if (event.getSlot() == 25) {
            SheepEquip(player, DyeColor.GRAY, true, 200, "Gray Baby Sheep Pet");
        }
        
        //Add Baby Light Gray Sheep
        if (event.getSlot() == 28) {
            SheepEquip(player, DyeColor.LIGHT_GRAY, true, 200, "Light Gray Baby Sheep Pet");
        }
        
        //Add Baby White Sheep
        if (event.getSlot() == 29) {
            SheepEquip(player, DyeColor.WHITE, true, 200, "White Baby Sheep Pet");
        }
        
        //Back Arrow
        if (event.getSlot() == 39) {
            plugin.getServer().getScheduler().runTask(plugin, () -> {
                player.openInventory(new PetGui(plugin, player).getInventory());
            });
        }
        
        // Remove Pet Option
        if (event.getSlot() == 40) {
            RemoveEffects.ClearEffects(player);
        }
        
        //Close Menu
        player.closeInventory();
    }
    
    
    //////
    //Clicking Inside the main Cat Type Selector GUI
    @EventHandler()
    public void onCatGuiClick(InventoryClickEvent event) {
        if (!(event.getInventory().getHolder() instanceof CatTypeGui))
            return;
        if (event.getCurrentItem() == null) return;
        if (event.getCurrentItem().getItemMeta() == null) return;
        if (event.getCurrentItem().getItemMeta().getDisplayName() == null) return;
        if (event.getRawSlot() > 53) return;
        
        event.setCancelled(true);
        
        Player player = (Player) event.getWhoClicked();
        
        // Remove Active Cosmetics when selecting new pet
        if (event.getSlot() < 35) {
            RemoveEffects.ClearEffects(player);
        }
        
        //Add Black Cat Pet
        if (event.getSlot() == 10) {
            CatEquip(player, Cat.Type.ALL_BLACK, false, 200, "Black Cat Pet");
        }
        
        //Add British Shorthair Cat Pet
        if (event.getSlot() == 11) {
            CatEquip(player, Cat.Type.BRITISH_SHORTHAIR, false, 200, "British Shorthair Cat Pet");
        }
        
        //Add Calico Cat Pet
        if (event.getSlot() == 12) {
            CatEquip(player, Cat.Type.CALICO, false, 200, "Calico Cat Pet");
        }
        
        //Add Jellie Cat Pet
        if (event.getSlot() == 13) {
            CatEquip(player, Cat.Type.JELLIE, false, 200, "Jellie Cat Pet");
        }
        
        //Add Persian Cat Pet
        if (event.getSlot() == 14) {
            CatEquip(player, Cat.Type.PERSIAN, false, 200, "Persian Cat Pet");
        }
        
        //Add Ragdoll Cat Pet
        if (event.getSlot() == 15) {
            CatEquip(player, Cat.Type.RAGDOLL, false, 200, "Ragdoll Cat Pet");
        }
        
        //Add Red Cat Pet
        if (event.getSlot() == 16) {
            CatEquip(player, Cat.Type.RED, false, 200, "Red Cat Pet");
        }
        
        //Add Siamese Cat Pet
        if (event.getSlot() == 19) {
            CatEquip(player, Cat.Type.SIAMESE, false, 200, "Siamese Cat Pet");
        }
        
        //Add Tabby Cat Pet
        if (event.getSlot() == 20) {
            CatEquip(player, Cat.Type.TABBY, false, 200, "Tabby Cat Pet");
        }
        
        //Add Tuxedo Cat Pet
        if (event.getSlot() == 21) {
            CatEquip(player, Cat.Type.BLACK, false, 200, "Tuxedo Cat Pet");
        }
        
        //Add White Cat Pet
        if (event.getSlot() == 22) {
            CatEquip(player, Cat.Type.WHITE, false, 200, "White Cat Pet");
        }
        
        //Back Arrow
        if (event.getSlot() == 39) {
            plugin.getServer().getScheduler().runTask(plugin, () -> {
                player.openInventory(new PetGui(plugin, player).getInventory());
            });
        }
        
        // Remove Pet Option
        if (event.getSlot() == 40) {
            RemoveEffects.ClearEffects(player);
        }
        
        //Close Menu
        player.closeInventory();
    }
    
}
