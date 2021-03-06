package cosmetics.pets.listeners;

import java.util.HashMap;

import org.bukkit.ChatColor;
import org.bukkit.DyeColor;
import org.bukkit.GameMode;
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
import cosmetics.pets.BabySheepColourGUI;
import cosmetics.pets.CatTypeGui;
import cosmetics.pets.PetGui;
import cosmetics.pets.PetGui2;
import cosmetics.pets.SheepColourGUI;

public class PetGuiListeners implements Listener {

    private final Cosmetics plugin;
    
    public PurchaseConstructor PurchaseConstructor = Cosmetics.PurchaseConstructor;
    public HashMap<Player, String> purchaseItem = Cosmetics.purchaseItem;
    public HashMap<Player, Integer> purchasePrice = Cosmetics.purchasePrice;

    public PetGuiListeners(Cosmetics b) {
        this.plugin = b;
    }
    
    public static HashMap<Player, Entity> currentPet = new HashMap<>();
    
    
    //Pet Spawner
    public void PetSpawn(Player player, EntityType entity, Boolean isbaby) {
        
//        Location pet_loc = player.getLocation();
//        pet_loc.setY(Math.round(player.getLocation().getY()));
//        System.out.println(pet_loc);
        
        LivingEntity pet = (LivingEntity) player.getWorld().spawnEntity(player.getLocation(), entity);
        pet.setAI(false);
        
        //Code for baby pets
        if (isbaby) {
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
        
        if (plugin.dataPetNames.existsPlayer(player.getUniqueId())) {
            pet.setCustomName(ChatColor.GOLD + plugin.dataPetNames.getPetName(player.getUniqueId()));
        }
        else {
            pet.setCustomName(ChatColor.GOLD + ""  + ChatColor.BOLD + player.getName() + "'s Pet");
        }

        currentPet.put(player, pet);
    }
    
    //Pet Equiper
    public void PetEquip(Player player, EntityType entity, Boolean isbaby, int price, String name) {
        if (plugin.dataCosmetics.exists(player.getUniqueId(), name)) {
            if(isSpectator(player)) return;
            PetSpawn(player, entity, isbaby);
        }
        else {
            purchaseItem.put(player, name); //Input Name
            purchasePrice.put(player, price); //Input Price
            PurchaseConstructor.purchaseGui(player, purchaseItem.get(player), purchasePrice.get(player));
        }
        //currentPetName.put(player, name);
        if (plugin.dataPets.existsPlayer(player.getUniqueId())) {
            plugin.dataPets.remove(player.getUniqueId());
        } 
        plugin.dataPets.addPet(player, player.getUniqueId(), name);
    }
    
    
    //Sheep Spawner
    public void SheepSpawn(Player player, DyeColor sheepColor, Boolean isbaby) {
        LivingEntity pet = (LivingEntity) player.getWorld().spawnEntity(player.getLocation(), EntityType.SHEEP);
        pet.setAI(false);
        
        Sheep sheep = (Sheep) pet;
        sheep.setColor(sheepColor);
        
        //Code for baby pets
        if (isbaby) {
            Animals baby = (Animals) pet;
            baby.setBaby();
            baby.setAgeLock(true);
        }
        
        pet.setInvulnerable(true);
        
        if (plugin.dataPetNames.existsPlayer(player.getUniqueId())) {
            pet.setCustomName(ChatColor.GOLD + plugin.dataPetNames.getPetName(player.getUniqueId()));
        }
        else {
            pet.setCustomName(ChatColor.GOLD + ""  + ChatColor.BOLD + player.getName() + "'s Pet");
        }

        currentPet.put(player, pet);
    }
    
    //Sheep Equiper
    public void SheepEquip(Player player, DyeColor sheepColor, Boolean isbaby, int price, String name) {
        if (plugin.dataCosmetics.exists(player.getUniqueId(), name)) {
            if(isSpectator(player)) return;
            SheepSpawn(player, sheepColor, isbaby);
        }
        else {
            purchaseItem.put(player, name); //Input Name
            purchasePrice.put(player, price); //Input Price
            PurchaseConstructor.purchaseGui(player, purchaseItem.get(player), purchasePrice.get(player));
        }
        //currentPetName.put(player, name);
        if (plugin.dataPets.existsPlayer(player.getUniqueId())) {
            plugin.dataPets.remove(player.getUniqueId());
        } 
        plugin.dataPets.addPet(player, player.getUniqueId(), name);
    }
    
    
    //Cat Spawner
    public void CatSpawn(Player player, Cat.Type catType, Boolean isbaby) {
        LivingEntity pet = (LivingEntity) player.getWorld().spawnEntity(player.getLocation(), EntityType.CAT);
        pet.setAI(false);
        
        Cat cat = (Cat) pet;
        cat.setCatType(catType);
        
        //Code for baby pets
        if (isbaby) {
            Animals baby = (Animals) pet;
            baby.setBaby();
            baby.setAgeLock(true);
        }
        
        pet.setInvulnerable(true);
        
        if (plugin.dataPetNames.existsPlayer(player.getUniqueId())) {
            pet.setCustomName(ChatColor.GOLD + plugin.dataPetNames.getPetName(player.getUniqueId()));
        }
        else {
            pet.setCustomName(ChatColor.GOLD + ""  + ChatColor.BOLD + player.getName() + "'s Pet");
        }

        currentPet.put(player, pet);
    }
    
    //Cat Equiper
    public void CatEquip(Player player, Cat.Type catType, Boolean isbaby, int price, String name) {
        if (plugin.dataCosmetics.exists(player.getUniqueId(), name)) {
            if(isSpectator(player)) return;
            CatSpawn(player, catType, isbaby);
        }
        else {
            purchaseItem.put(player, name); //Input Name
            purchasePrice.put(player, price); //Input Price
            PurchaseConstructor.purchaseGui(player, purchaseItem.get(player), purchasePrice.get(player));
        }
        //currentPetName.put(player, name);
        if (plugin.dataPets.existsPlayer(player.getUniqueId())) {
            plugin.dataPets.remove(player.getUniqueId());
        } 
        plugin.dataPets.addPet(player, player.getUniqueId(), name);
    }
    
    
    // Pet Command
    public void Pet(Player player, String name) {
        if (name.equals("Llama Pet")) {
            PetEquip(player, EntityType.LLAMA, false, 200, "Llama Pet");
        }
        if (name.equals("Baby Llama Pet")) {
            PetEquip(player, EntityType.LLAMA, true, 200, "Baby Llama Pet");
        }
        if (name.equals("Pig Pet")) {
            PetEquip(player, EntityType.PIG, false, 200, "Pig Pet");
        }
        if (name.equals("Baby Pig Pet")) {
            PetEquip(player, EntityType.PIG, true, 200, "Baby Pig Pet");
        }
        if (name.equals("Chicken Pet")) {
            PetEquip(player, EntityType.CHICKEN, false, 200, "Chicken Pet");
        }
        if (name.equals("Baby Chicken Pet")) {
            PetEquip(player, EntityType.CHICKEN, true, 200, "Baby Chicken Pet");
        }
        if (name.equals("Cow Pet")) {
            PetEquip(player, EntityType.COW, false, 200, "Cow Pet");
        }
        if (name.equals("Baby Cow Pet")) {
            PetEquip(player, EntityType.COW, true, 200, "Baby Cow Pet");
        }
        if (name.equals("Mooshroom Pet")) {
            PetEquip(player, EntityType.MUSHROOM_COW, false, 200, "Mooshroom Pet");
        }
        if (name.equals("Fox Pet")) {
            PetEquip(player, EntityType.FOX, false, 200, "Fox Pet");
        }
        if (name.equals("Baby Fox Pet")) {
            PetEquip(player, EntityType.FOX, true, 200, "Baby Fox Pet");
        }
        if (name.equals("Panda Pet")) {
            PetEquip(player, EntityType.PANDA, false, 200, "Panda Pet");
        }
        if (name.equals("Baby Panda Pet")) {
            PetEquip(player, EntityType.PANDA, true, 200, "Baby Panda Pet");
        }
        if (name.equals("Wolf Pet")) {
            PetEquip(player, EntityType.WOLF, false, 200, "Wolf Pet");
        }
        if (name.equals("Baby Wolf Pet")) {
            PetEquip(player, EntityType.WOLF, true, 200, "Baby Wolf Pet");
        }
        if (name.equals("Polar Bear Pet")) {
            PetEquip(player, EntityType.POLAR_BEAR, false, 200, "Polar Bear Pet");
        }
        if (name.equals("Baby Polar Bear Pet")) {
            PetEquip(player, EntityType.POLAR_BEAR, true, 200, "Baby Polar Bear Pet");
        }
        if (name.equals("Ocelot Pet")) {
            PetEquip(player, EntityType.OCELOT, false, 200, "Ocelot Pet");
        }
        if (name.equals("Turtle Pet")) {
            PetEquip(player, EntityType.TURTLE, false, 200, "Turtle Pet");
        }
        if (name.equals("Creeper Pet")) {
            PetEquip(player, EntityType.CREEPER, false, 200, "Creeper Pet");
        }
        if (name.equals("Horse Pet")) {
            PetEquip(player, EntityType.HORSE, false, 200, "Horse Pet");
        }
        if (name.equals("Blaze Pet")) {
            PetEquip(player, EntityType.BLAZE, false, 200, "Blaze Pet");
        }
        if (name.equals("Witch Pet")) {
            PetEquip(player, EntityType.WITCH, false, 200, "Witch Pet");
        }
        if (name.equals("Husk Pet")) {
            PetEquip(player, EntityType.HUSK, false, 200, "Husk Pet");
        }
        if (name.equals("Baby Husk Pet")) {
            PetEquip(player, EntityType.HUSK, true, 200, "Baby Husk Pet");
        }
        if (name.equals("Zombie Pet")) {
            PetEquip(player, EntityType.ZOMBIE, false, 200, "Zombie Pet");
        }
        if (name.equals("Baby Zombie Pet")) {
            PetEquip(player, EntityType.ZOMBIE, true, 200, "Baby Zombie Pet");
        }
        if (name.equals("Snowman Pet")) {
            PetEquip(player, EntityType.SNOWMAN, false, 200, "Snowman Pet");
        }
        if (name.equals("Golem Pet")) {
            PetEquip(player, EntityType.IRON_GOLEM, false, 200, "Golem Pet");
        }
        if (name.equals("Rabbit Pet")) {
            PetEquip(player, EntityType.RABBIT, false, 200, "Rabbit Pet");
        }
        if (name.equals("Red Sheep Pet")) {
            SheepEquip(player, DyeColor.RED, false, 200, "Red Sheep Pet");
        }
        if (name.equals("Orange Sheep Pet")) {
            SheepEquip(player, DyeColor.ORANGE, false, 200, "Orange Sheep Pet");
        }
        if (name.equals("Yellow Sheep Pet")) {
            SheepEquip(player, DyeColor.YELLOW, false, 200, "Yellow Sheep Pet");
        }
        if (name.equals("Green Sheep Pet")) {
            SheepEquip(player, DyeColor.GREEN, false, 200, "Green Sheep Pet");
        }
        if (name.equals("Lime Sheep Pet")) {
            SheepEquip(player, DyeColor.LIME, false, 200, "Lime Sheep Pet");
        }
        if (name.equals("Blue Sheep Pet")) {
            SheepEquip(player, DyeColor.BLUE, false, 200, "Blue Sheep Pet");
        }
        if (name.equals("Cyan Sheep Pet")) {
            SheepEquip(player, DyeColor.CYAN, false, 200, "Cyan Sheep Pet");
        }
        if (name.equals("Light Blue Sheep Pet")) {
            SheepEquip(player, DyeColor.LIGHT_BLUE, false, 200, "Light Blue Sheep Pet");
        }
        if (name.equals("Purple Sheep Pet")) {
            SheepEquip(player, DyeColor.PURPLE, false, 200, "Purple Sheep Pet");
        }
        if (name.equals("Magenta Sheep Pet")) {
            SheepEquip(player, DyeColor.MAGENTA, false, 200, "Magenta Sheep Pet");
        }
        if (name.equals("Pink Sheep Pet")) {
            SheepEquip(player, DyeColor.PINK, false, 200, "Pink Sheep Pet");
        }
        if (name.equals("Brown Sheep Pet")) {
            SheepEquip(player, DyeColor.BROWN, false, 200, "Brown Sheep Pet");
        }
        if (name.equals("Black Sheep Pet")) {
            SheepEquip(player, DyeColor.BLACK, false, 200, "Black Sheep Pet");
        }
        if (name.equals("Gray Sheep Pet")) {
            SheepEquip(player, DyeColor.GRAY, false, 200, "Gray Sheep Pet");
        }
        if (name.equals("Light Gray Sheep Pet")) {
            SheepEquip(player, DyeColor.LIGHT_GRAY, false, 200, "Light Gray Sheep Pet");
        }
        if (name.equals("White Sheep Pet")) {
            SheepEquip(player, DyeColor.WHITE, false, 200, "White Sheep Pet");
        }
        if (name.equals("Red Baby Sheep Pet")) {
            SheepEquip(player, DyeColor.RED, true, 200, "Red Baby Sheep Pet");
        }
        if (name.equals("Orange Baby Sheep Pet")) {
            SheepEquip(player, DyeColor.ORANGE, true, 200, "Orange Baby Sheep Pet");
        }
        if (name.equals("Yellow Baby Sheep Pet")) {
            SheepEquip(player, DyeColor.YELLOW, true, 200, "Yellow Baby Sheep Pet");
        }
        if (name.equals("Green Baby Sheep Pet")) {
            SheepEquip(player, DyeColor.GREEN, true, 200, "Green Baby Sheep Pet");
        }
        if (name.equals("Lime Baby Sheep Pet")) {
            SheepEquip(player, DyeColor.LIME, true, 200, "Lime Baby Sheep Pet");
        }
        if (name.equals("Blue Baby Sheep Pet")) {
            SheepEquip(player, DyeColor.BLUE, true, 200, "Blue Baby Sheep Pet");
        }
        if (name.equals("Cyan Baby Sheep Pet")) {
            SheepEquip(player, DyeColor.CYAN, true, 200, "Cyan Baby Sheep Pet");
        }
        if (name.equals("Light Blue Baby Sheep Pet")) {
            SheepEquip(player, DyeColor.LIGHT_BLUE, true, 200, "Light Blue Baby Sheep Pet");
        }
        if (name.equals("Purple Baby Sheep Pet")) {
            SheepEquip(player, DyeColor.PURPLE, true, 200, "Purple Baby Sheep Pet");
        }
        if (name.equals("Magenta Baby Sheep Pet")) {
            SheepEquip(player, DyeColor.MAGENTA, true, 200, "Magenta Baby Sheep Pet");
        }
        if (name.equals("Pink Baby Sheep Pet")) {
            SheepEquip(player, DyeColor.PINK, true, 200, "Pink Baby Sheep Pet");
        }
        if (name.equals("Brown Baby Sheep Pet")) {
            SheepEquip(player, DyeColor.BROWN, true, 200, "Brown Baby Sheep Pet");
        }
        if (name.equals("Black Baby Sheep Pet")) {
            SheepEquip(player, DyeColor.BLACK, true, 200, "Black Baby Sheep Pet");
        }
        if (name.equals("Gray Baby Sheep Pet")) {
            SheepEquip(player, DyeColor.GRAY, true, 200, "Gray Baby Sheep Pet");
        }
        if (name.equals("Light Gray Baby Sheep Pet")) {
            SheepEquip(player, DyeColor.LIGHT_GRAY, true, 200, "Light Gray Baby Sheep Pet");
        }
        if (name.equals("White Baby Sheep Pet")) {
            SheepEquip(player, DyeColor.WHITE, true, 200, "White Baby Sheep Pet");
        }
        if (name.equals("Black Cat Pet")) {
            CatEquip(player, Cat.Type.ALL_BLACK, false, 200, "Black Cat Pet");
        }
        if (name.equals("British Shorthair Cat Pet")) {
            CatEquip(player, Cat.Type.BRITISH_SHORTHAIR, false, 200, "British Shorthair Cat Pet");
        }
        if (name.equals("Calico Cat Pet")) {
            CatEquip(player, Cat.Type.CALICO, false, 200, "Calico Cat Pet");
        }
        if (name.equals("Jellie Cat Pet")) {
            CatEquip(player, Cat.Type.JELLIE, false, 200, "Jellie Cat Pet");
        }
        if (name.equals("Persian Cat Pet")) {
            CatEquip(player, Cat.Type.PERSIAN, false, 200, "Persian Cat Pet");
        }
        if (name.equals("Ragdoll Cat Pet")) {
            CatEquip(player, Cat.Type.RAGDOLL, false, 200, "Ragdoll Cat Pet");
        }
        if (name.equals("Red Cat Pet")) {
            CatEquip(player, Cat.Type.RED, false, 200, "Red Cat Pet");
        }
        if (name.equals("Siamese Cat Pet")) {
            CatEquip(player, Cat.Type.SIAMESE, false, 200, "Siamese Cat Pet");
        }
        if (name.equals("Tabby Cat Pet")) {
            CatEquip(player, Cat.Type.TABBY, false, 200, "Tabby Cat Pet");
        }
        if (name.equals("Tuxedo Cat Pet")) {
            CatEquip(player, Cat.Type.BLACK, false, 200, "Tuxedo Cat Pet");
        }
        if (name.equals("White Cat Pet")) {
            CatEquip(player, Cat.Type.WHITE, false, 200, "White Cat Pet");
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
        if (event.getRawSlot() > 53) return;
        
        event.setCancelled(true);
        
        Player player = (Player) event.getWhoClicked();
        
        // Remove Active Cosmetics when selecting new pet
        if (event.getSlot() < 35 && event.getSlot() != 16 && event.getSlot() != 19 && event.getSlot() != 34) {
            plugin.RemoveEffects.ClearEffects(player);
        }

        //Add Llama
        if (event.getSlot() == 10) {
            Pet(player, "Llama Pet");
        }
        
        //Add Baby Llama
        if (event.getSlot() == 11) {
            Pet(player, "Baby Llama Pet");
        }
        
        //Add Pig
        if (event.getSlot() == 12) {
            Pet(player, "Pig Pet");
        }
        
        //Add Baby Pig
        if (event.getSlot() == 13) {
            Pet(player, "Baby Pig Pet");
        }
        
        //Add Chicken
        if (event.getSlot() == 14) {
            Pet(player, "Chicken Pet");
        }
        
        //Add Baby Chicken
        if (event.getSlot() == 15) {
            Pet(player, "Baby Chicken Pet");
        }
        
        //Go to Sheep Gui
        if (event.getSlot() == 16) {
            plugin.getServer().getScheduler().runTask(plugin, () -> player.openInventory(new SheepColourGUI(plugin, player).getInventory()));
        }
        
        //Add Baby Sheep
        if (event.getSlot() == 19) {
            plugin.getServer().getScheduler().runTask(plugin, () -> player.openInventory(new BabySheepColourGUI(plugin, player).getInventory()));
        }
        
        //Add Cow
        if (event.getSlot() == 20) {
            Pet(player, "Cow Pet");
        }
        
        //Add Baby Cow
        if (event.getSlot() == 21) {
            Pet(player, "Baby Cow Pet");
        }
        
        //Add Mooshroom
        if (event.getSlot() == 22) {
            Pet(player, "Mooshroom Pet");
        }
        
        //Add Fox
        if (event.getSlot() == 23) {
            Pet(player, "Fox Pet");
        }
        
        //Add Baby Fox
        if (event.getSlot() == 24) {
            Pet(player, "Baby Fox Pet");
        }
        
        //Add Panda
        if (event.getSlot() == 25) {
            Pet(player, "Panda Pet");
        }
        
        //Add Baby Panda
        if (event.getSlot() == 28) {
            Pet(player, "Baby Panda Pet");
        }
        
        //Add Wolf
        if (event.getSlot() == 29) {
            Pet(player, "Wolf Pet");
        }
        
        //Add Baby Wolf
        if (event.getSlot() == 30) {
            Pet(player, "Baby Wolf Pet");
        }
        
        //Add Polar Bear
        if (event.getSlot() == 31) {
            Pet(player, "Polar Bear Pet");
        }
        
        //Add Baby Polar Bear
        if (event.getSlot() == 32) {
            Pet(player, "Baby Polar Bear Pet");
        }
        
        //Add Ocelot
        if (event.getSlot() == 33) {
            Pet(player, "Ocelot Pet");
        }
        
        //Add Cat
        if (event.getSlot() == 34) {
            plugin.getServer().getScheduler().runTask(plugin, () -> player.openInventory(new CatTypeGui(plugin, player).getInventory()));
        }
        
        
        // Remove Pet Option
        if (event.getSlot() == 40) {
            plugin.RemoveEffects.ClearEffects(player);
        }
        
        // Return to cosmetic window
        if (event.getSlot() == 39) {
            plugin.getServer().getScheduler().runTask(plugin, () -> player.openInventory(new CosmeticGui(plugin, player).getInventory()));
        }
        
        // Pet Gui Page 2
        if (event.getSlot() == 41) {
            plugin.getServer().getScheduler().runTask(plugin, () -> player.openInventory(new PetGui2(plugin, player).getInventory()));
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
        if (event.getRawSlot() > 53) return;
        
        event.setCancelled(true);
        
        Player player = (Player) event.getWhoClicked();
        
        // Remove Active Cosmetics when selecting new pet
        if (event.getSlot() < 35) {
            plugin.RemoveEffects.ClearEffects(player);
        }
        
        //Add Turtle
        if (event.getSlot() == 10) {
            Pet(player, "Turtle Pet");
        }
        
        //Add Creeper
        if (event.getSlot() == 11) {
            Pet(player, "Creeper Pet");
        }
        
        //Add Horse
        if (event.getSlot() == 12) {
            Pet(player, "Horse Pet");
        }
        
        //Add Blaze
        if (event.getSlot() == 13) {
            Pet(player, "Blaze Pet");
        }
        
        //Add Witch
        if (event.getSlot() == 14) {
            Pet(player, "Witch Pet");
        }
        
        //Add Husk
        if (event.getSlot() == 15) {
            Pet(player, "Husk Pet");
        }
        
        //Add Baby Husk
        if (event.getSlot() == 16) {
            Pet(player, "Baby Husk Pet");
        }
        
        //Add Zombie
        if (event.getSlot() == 19) {
            Pet(player, "Zombie Pet");
        }
        
        //Add Baby Zombie
        if (event.getSlot() == 20) {
            Pet(player, "Baby Zombie Pet");
        }
        
        //Add Snowman
        if (event.getSlot() == 21) {
            Pet(player, "Snowman Pet");
        }
        
        //Add Iron Golem
        if (event.getSlot() == 22) {
            Pet(player, "Golem Pet");
        }
        
        //Add Rabbit
        if (event.getSlot() == 23) {
            Pet(player, "Rabbit Pet");
        }
        
    
        // Remove Pet Option
        if (event.getSlot() == 40) {
            plugin.RemoveEffects.ClearEffects(player);
        }
        
        // Pet Gui Page 2
        if (event.getSlot() == 39) {
            plugin.getServer().getScheduler().runTask(plugin, () -> player.openInventory(new PetGui(plugin, player).getInventory()));
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
        if (event.getRawSlot() > 53) return;
        
        event.setCancelled(true);
        
        Player player = (Player) event.getWhoClicked();
        
        // Remove Active Cosmetics when selecting new pet
        if (event.getSlot() < 35) {
            plugin.RemoveEffects.ClearEffects(player);
        }
        
        //Add Red Sheep
        if (event.getSlot() == 10) {
            Pet(player, "Red Sheep Pet");
        }
        
        //Add Orange Sheep
        if (event.getSlot() == 11) {
            Pet(player, "Orange Sheep Pet");
        }
        
        //Add Yellow Sheep
        if (event.getSlot() == 12) {
            Pet(player, "Yellow Sheep Pet");
        }
        
        //Add Green Sheep
        if (event.getSlot() == 13) {
            Pet(player, "Green Sheep Pet");
        }
        
        //Add Lime Sheep
        if (event.getSlot() == 14) {
            Pet(player, "Lime Sheep Pet");
        }
        
        //Add Blue Sheep
        if (event.getSlot() == 15) {
            Pet(player, "Blue Sheep Pet");
        }
        
        //Add Cyan Sheep
        if (event.getSlot() == 16) {
            Pet(player, "Cyan Sheep Pet");
        }
        
        //Add Light Blue Sheep
        if (event.getSlot() == 19) {
            Pet(player, "Light Blue Sheep Pet");
        }
        
        //Add Purple Sheep
        if (event.getSlot() == 20) {
            Pet(player, "Purple Sheep Pet");
        }
        
        //Add Magenta Sheep
        if (event.getSlot() == 21) {
            Pet(player, "Magenta Sheep Pet");
        }
        
        //Add Pink Sheep
        if (event.getSlot() == 22) {
            Pet(player, "Pink Sheep Pet");
        }
        
        //Add Brown Sheep
        if (event.getSlot() == 23) {
            Pet(player, "Brown Sheep Pet");
        }
        
        //Add Black Sheep
        if (event.getSlot() == 24) {
            Pet(player, "Black Sheep Pet");
        }
        
        //Add Gray Sheep
        if (event.getSlot() == 25) {
            Pet(player, "Gray Sheep Pet");
        }
        
        //Add Light Gray Sheep
        if (event.getSlot() == 28) {
            Pet(player, "Light Gray Sheep Pet");
        }
        
        //Add White Sheep
        if (event.getSlot() == 29) {
            Pet(player, "White Sheep Pet");
        }
        
        //Back Arrow
        if (event.getSlot() == 39) {
            plugin.getServer().getScheduler().runTask(plugin, () -> player.openInventory(new PetGui(plugin, player).getInventory()));
        }
        
        // Remove Pet Option
        if (event.getSlot() == 40) {
            plugin.RemoveEffects.ClearEffects(player);
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
        if (event.getRawSlot() > 53) return;
        
        event.setCancelled(true);
        
        Player player = (Player) event.getWhoClicked();
        
        // Remove Active Cosmetics when selecting new pet
        if (event.getSlot() < 35) {
            plugin.RemoveEffects.ClearEffects(player);
        }

        
        //Add Baby Red Sheep
        if (event.getSlot() == 10) {
            Pet(player,"Red Baby Sheep Pet");
        }
        
        //Add Baby Orange Sheep
        if (event.getSlot() == 11) {
            Pet(player,"Orange Baby Sheep Pet");
        }
        
        //Add Baby Yellow Sheep
        if (event.getSlot() == 12) {
            Pet(player,"Yellow Baby Sheep Pet");
        }
        
        //Add Baby Green Sheep
        if (event.getSlot() == 13) {
            Pet(player,"Green Baby Sheep Pet");
        }
        
        //Add Baby Lime Sheep
        if (event.getSlot() == 14) {
            Pet(player, "Lime Baby Sheep Pet");
        }
        
        //Add Baby Blue Sheep
        if (event.getSlot() == 15) {
            Pet(player, "Blue Baby Sheep Pet");
        }
        
        //Add Baby Cyan Sheep
        if (event.getSlot() == 16) {
            Pet(player, "Cyan Baby Sheep Pet");
        }
        
        //Add Baby Light Blue Sheep
        if (event.getSlot() == 19) {
            Pet(player, "Light Blue Baby Sheep Pet");
        }
        
        //Add Baby Purple Sheep
        if (event.getSlot() == 20) {
            Pet(player, "Purple Baby Sheep Pet");
        }
        
        //Add Baby Magenta Sheep
        if (event.getSlot() == 21) {
            Pet(player, "Magenta Baby Sheep Pet");
        }
        
        //Add Baby Pink Sheep
        if (event.getSlot() == 22) {
            Pet(player, "Pink Baby Sheep Pet");
        }
        
        //Add Baby Brown Sheep
        if (event.getSlot() == 23) {
            Pet(player, "Brown Baby Sheep Pet");
        }
        
        //Add Baby Black Sheep
        if (event.getSlot() == 24) {
            Pet(player, "Black Baby Sheep Pet");
        }
        
        //Add Baby Gray Sheep
        if (event.getSlot() == 25) {
            Pet(player, "Gray Baby Sheep Pet");
        }
        
        //Add Baby Light Gray Sheep
        if (event.getSlot() == 28) {
            Pet(player, "Light Gray Baby Sheep Pet");
        }
        
        //Add Baby White Sheep
        if (event.getSlot() == 29) {
            Pet(player, "White Baby Sheep Pet");
        }
        
        //Back Arrow
        if (event.getSlot() == 39) {
            plugin.getServer().getScheduler().runTask(plugin, () -> player.openInventory(new PetGui(plugin, player).getInventory()));
        }
        
        // Remove Pet Option
        if (event.getSlot() == 40) {
            plugin.RemoveEffects.ClearEffects(player);
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
        if (event.getRawSlot() > 53) return;
        
        event.setCancelled(true);
        
        Player player = (Player) event.getWhoClicked();
        
        // Remove Active Cosmetics when selecting new pet
        if (event.getSlot() < 35) {
            plugin.RemoveEffects.ClearEffects(player);
        }
        
        
        //Add Black Cat Pet
        if (event.getSlot() == 10) {
            Pet(player, "Black Cat Pet");
        }
        
        //Add British Shorthair Cat Pet
        if (event.getSlot() == 11) {
            Pet(player, "British Shorthair Cat Pet");
        }
        
        //Add Calico Cat Pet
        if (event.getSlot() == 12) {
            Pet(player, "Calico Cat Pet");
        }
        
        //Add Jellie Cat Pet
        if (event.getSlot() == 13) {
            Pet(player, "Jellie Cat Pet");
        }
        
        //Add Persian Cat Pet
        if (event.getSlot() == 14) {
            Pet(player, "Persian Cat Pet");
        }
        
        //Add Ragdoll Cat Pet
        if (event.getSlot() == 15) {
            Pet(player, "Ragdoll Cat Pet");
        }
        
        //Add Red Cat Pet
        if (event.getSlot() == 16) {
            Pet(player, "Red Cat Pet");
        }
        
        //Add Siamese Cat Pet
        if (event.getSlot() == 19) {
            Pet(player, "Siamese Cat Pet");
        }
        
        //Add Tabby Cat Pet
        if (event.getSlot() == 20) {
            Pet(player, "Tabby Cat Pet");
        }
        
        //Add Tuxedo Cat Pet
        if (event.getSlot() == 21) {
            Pet(player, "Tuxedo Cat Pet");
        }
        
        //Add White Cat Pet
        if (event.getSlot() == 22) {
            Pet(player, "White Cat Pet");
        }
        
        //Back Arrow
        if (event.getSlot() == 39) {
            plugin.getServer().getScheduler().runTask(plugin, () -> player.openInventory(new PetGui(plugin, player).getInventory()));
        }
        
        // Remove Pet Option
        if (event.getSlot() == 40) {
            plugin.RemoveEffects.ClearEffects(player);
        }
        
        //Close Menu
        player.closeInventory();
    }

    private boolean isSpectator(Player player) {
        if(player.getGameMode() != GameMode.SPECTATOR) {
            player.sendMessage(ChatColor.DARK_RED + "You cannot equip a pet in spectator mode!");
            return false;
        }
        return true;
    }
}
