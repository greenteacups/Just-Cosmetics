package cosmetics.gadgets.listeners;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.FireworkEffect;
import org.bukkit.FireworkEffect.Type;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Firework;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.meta.FireworkMeta;

import cosmetics.Cosmetics;
import cosmetics.RemoveEffectsOnQuit;
import cosmetics.gadgets.GadgetRunnables;

public class GadgetGeneralListeners implements Listener {
    
    private Cosmetics plugin;
    public GadgetGeneralListeners(Cosmetics b) {
        plugin = b;
    }
    
    public static RemoveEffectsOnQuit RemoveEffectsOnQuit = new RemoveEffectsOnQuit();
    
    public HashMap<Player, List<Entity>> shellMap = GadgetGuiListeners.shellMap;
    public HashMap<Player, List<Entity>> parrotMap = GadgetGuiListeners.parrotMap;
    
    public static List<Entity> shotshell = new ArrayList<>();
    
    public static HashMap<Player, Long> airstrike = new HashMap<>();
    public static HashMap<Player, Entity> airturtlelist = GadgetRunnables.airturtlelist;
    public List<Entity> tntList = GadgetRunnables.tntList;

    @EventHandler
    public void onClick(PlayerInteractEvent event) {
        
        Player player = (Player) event.getPlayer();
        
        // Jump Stick
        if (player.getInventory().getItemInMainHand().getType() != Material.AIR) {
            if (player.getInventory().getItemInMainHand().getItemMeta().getDisplayName().contains("Jump Stick") && 
                    player.getInventory().getItemInMainHand().getItemMeta().hasLore()) {
                if (player.getInventory().getItemInMainHand().getItemMeta().hasLore()) {
                    if (player.getLocation().subtract(0, 1, 0).getBlock().getType() != Material.AIR) {
                        player.setVelocity(player.getLocation().getDirection().multiply(2).setY(2));
                        
                        event.getPlayer().getWorld().spawnParticle(Particle.EXPLOSION_HUGE,
                                event.getPlayer().getLocation().getX(), event.getPlayer().getLocation().getY(),
                                event.getPlayer().getLocation().getZ(), 0);
                        event.getPlayer().getWorld().playSound(event.getPlayer().getLocation(), Sound.ENTITY_DRAGON_FIREBALL_EXPLODE,
                                3.0F, 0.533F);
                    }
                }

            }   
        }
        
        
        // Green shell gun
        if (player.getInventory().getItemInMainHand().getType() != Material.AIR 
                && player.getInventory().getItemInMainHand().getItemMeta().getDisplayName().contains("Green Shell Gun")) {
            if (player.getInventory().getItemInMainHand().getItemMeta().hasLore()) {
                
                if (shotshell.isEmpty() == false) {
                    shotshell.get(0).remove();
                    
                    shotshell.get(0).getWorld().spawnParticle(Particle.EXPLOSION_HUGE,
                            shotshell.get(0).getLocation().getX(), shotshell.get(0).getLocation().getY(),
                            shotshell.get(0).getLocation().getZ(), 0);
                    
                    shotshell.clear();
                }
                
                
                LivingEntity shootshell = (LivingEntity) player.getWorld().spawnEntity(player.getLocation().add(0, 0, -2), EntityType.TURTLE);
                
                shootshell.setAI(true);
                shootshell.setHealth(1);
                shootshell.setVelocity(player.getLocation().getDirection().multiply(4));
                
                shotshell.add(shootshell);
                
                plugin.getServer().getScheduler().runTaskLater(plugin, () -> {
                    if (shotshell.size() > 0) {
                        shotshell.get(0).remove();
                      
                        shotshell.get(0).getWorld().spawnParticle(Particle.EXPLOSION_HUGE,
                              shotshell.get(0).getLocation().getX(), shotshell.get(0).getLocation().getY(),
                              shotshell.get(0).getLocation().getZ(), 0);
                      
                        shotshell.clear();
                    }
                }, 30);
            }
        }
        
        // Air Strike
        if (player.getInventory().getItemInMainHand().getType() != Material.AIR) {
            if (player.getInventory().getItemInMainHand().getItemMeta().getDisplayName().contains("Air Strike")) {
                if (player.getInventory().getItemInMainHand().getItemMeta().hasLore()) {

                    if (airstrike.containsKey(player)) {
                        player.sendMessage(ChatColor.DARK_RED + "You have already ordered an AirStrike");
                    }
                    else {
                        airstrike.put(player, System.currentTimeMillis()/50);
                    }
                    
                }

            }   
        }
        
        // Firework Gadget
        if (player.getInventory().getItemInMainHand().getType() != Material.AIR) {
            if (player.getInventory().getItemInMainHand().getItemMeta().getDisplayName().contains("Firework Gadget")) {
                if (player.getInventory().getItemInMainHand().getItemMeta().hasLore()) {
                    Random random = new Random();
                    
                    Color[] fwcolor = new Color[] {Color.AQUA,
                                                    Color.BLUE,
                                                    Color.FUCHSIA,
                                                    Color.GREEN,
                                                    Color.LIME,
                                                    Color.MAROON,
                                                    Color.ORANGE,
                                                    Color.PURPLE,
                                                    Color.RED,
                                                    Color.TEAL,
                                                    Color.YELLOW};
                    
                    Type[] fwtype = new Type[] {Type.BALL,
                                                Type.BALL_LARGE,
                                                Type.BURST,
                                                Type.CREEPER,
                                                Type.STAR}; 
                    

                    Firework fw = (Firework) player.getLocation().getWorld().spawnEntity(player.getLocation(), EntityType.FIREWORK);
                    FireworkMeta fwm = fw.getFireworkMeta();
                    
                    fwm.setPower(2);
                    fwm.addEffect(FireworkEffect.builder().withColor(fwcolor[random.nextInt(fwcolor.length)])
                            .flicker(true).with(fwtype[random.nextInt(fwtype.length)]).build());
                    
                    fw.setFireworkMeta(fwm);
                    //fw.detonate();
                }

            }   
        }
    }
    
    @EventHandler
    public void onGadgetDamage(EntityDamageEvent event) {
        if (event.getCause() != null) {
            for (List<Entity> list : shellMap.values()) {

                if (list.contains(event.getEntity())) {
                    event.setCancelled(true);  
                }
            }
            
            for (List<Entity> list : parrotMap.values()) {

                if (list.contains(event.getEntity())) {
                    event.setCancelled(true);
                }
            }
        }  
    }
    
    @EventHandler
    public void airstrikeTntExplodeBlocks(EntityExplodeEvent event) {
        if (event.getEntity() != null) {
            if (tntList.contains(event.getEntity())) {
                event.getEntity().getWorld().spawnParticle(Particle.EXPLOSION_HUGE,
                        event.getEntity().getLocation().getX(), event.getEntity().getLocation().getY(),
                        event.getEntity().getLocation().getZ(), 0);
                
                event.setCancelled(true);
                
                tntList.remove(event.getEntity());
            }
        }
    }
    
    @EventHandler
    public void airstrikeTntExplodeEntity(EntityDamageByEntityEvent event) {
        if (event.getDamager() != null) {
            if (tntList.contains(event.getDamager())) {
                event.setCancelled(true);
            }
        }
    }
    
    @EventHandler
    public void dropGadget(PlayerDropItemEvent event) {
        if (event.getItemDrop().getItemStack().getItemMeta().getDisplayName().contains("Jump Stick") && 
                event.getItemDrop().getItemStack().getItemMeta().hasLore()) {
            event.setCancelled(true);
        }
        if (event.getItemDrop().getItemStack().getItemMeta().getDisplayName().contains("Green Shell Gun") && 
                event.getItemDrop().getItemStack().getItemMeta().hasLore()) {
            event.setCancelled(true);
        }
        if (event.getItemDrop().getItemStack().getItemMeta().getDisplayName().contains("Air Strike") && 
                event.getItemDrop().getItemStack().getItemMeta().hasLore()) {
            event.setCancelled(true);
        }
        if (event.getItemDrop().getItemStack().getItemMeta().getDisplayName().contains("Firework Gadget") && 
                event.getItemDrop().getItemStack().getItemMeta().hasLore()) {
            event.setCancelled(true);
        }
    }
    
    //Player death remove Everything
    @EventHandler
    public void onDeathEvent(PlayerDeathEvent event) {
        for (int i = 0; i < event.getDrops().size(); i++) {
            if (event.getDrops().get(i).getItemMeta().getDisplayName().contains("Jump Stick") && 
                    event.getDrops().get(i).getItemMeta().hasLore()) {
                event.getDrops().get(i).setAmount(0);
                break;
            }
            if (event.getDrops().get(i).getItemMeta().getDisplayName().contains("Green Shell Gun") && 
                    event.getDrops().get(i).getItemMeta().hasLore()) {
                event.getDrops().get(i).setAmount(0);
                break;
            }
            if (event.getDrops().get(i).getItemMeta().getDisplayName().contains("Air Strike") && 
                    event.getDrops().get(i).getItemMeta().hasLore()) {
                event.getDrops().get(i).setAmount(0);
                break;
            }
            if (event.getDrops().get(i).getItemMeta().getDisplayName().contains("Firework Gadget") && 
                    event.getDrops().get(i).getItemMeta().hasLore()) {
                event.getDrops().get(i).setAmount(0);
                break;
            }
        }
    }
    
    @EventHandler
    public void placeGadget(BlockPlaceEvent event) {
        if (event.getItemInHand().getItemMeta().getDisplayName().contains("Jump Stick") && 
                event.getItemInHand().getItemMeta().hasLore()) {
            event.setCancelled(true);
        }
        if (event.getItemInHand().getItemMeta().getDisplayName().contains("Green Shell Gun") && 
                event.getItemInHand().getItemMeta().hasLore()) {
            event.setCancelled(true);
        }
        if (event.getItemInHand().getItemMeta().getDisplayName().contains("Air Strike") && 
                event.getItemInHand().getItemMeta().hasLore()) {
            event.setCancelled(true);
        }
        if (event.getItemInHand().getItemMeta().getDisplayName().contains("Firework Gadget") && 
                event.getItemInHand().getItemMeta().hasLore()) {
            event.setCancelled(true);
        }
    }
    
    @EventHandler
    public void InventoryClickEvent(InventoryClickEvent event){
        
        if (event.getCurrentItem() != null && event.getClick() == ClickType.NUMBER_KEY) {
            if (event.getWhoClicked().getInventory().getItem(8) != null && 
                    event.getWhoClicked().getInventory().getItem(8).getItemMeta().hasLore() &&
                    event.getWhoClicked().getInventory().getItem(8).getItemMeta().getDisplayName().contains("Jump Stick")) {
                event.getWhoClicked().sendMessage(ChatColor.RED + "Number Keys are disabled while Gadget Equipped");
                event.setCancelled(true);
            }
        }
        if (event.getCurrentItem() != null && event.getCurrentItem().getItemMeta() != null && event.getSlot() == 8 
                && (event.getClickedInventory().getType() == InventoryType.PLAYER)
                && event.getWhoClicked().getInventory().getItem(8).getItemMeta().hasLore()
                && event.getCurrentItem().getItemMeta().getDisplayName().contains("Jump Stick")){       
            event.setCancelled(true);
        }
        
        if (event.getCurrentItem() != null && event.getClick() == ClickType.NUMBER_KEY) {
            if (event.getWhoClicked().getInventory().getItem(8) != null && 
                    event.getWhoClicked().getInventory().getItem(8).getItemMeta().hasLore() &&
                    event.getWhoClicked().getInventory().getItem(8).getItemMeta().getDisplayName().contains("Green Shell Gun")) {
                event.getWhoClicked().sendMessage(ChatColor.RED + "Number Keys are disabled while Gadget Equipped");
                event.setCancelled(true);
            }
        }
        if (event.getCurrentItem() != null && event.getCurrentItem().getItemMeta() != null && event.getSlot() == 8 
                && (event.getClickedInventory().getType() == InventoryType.PLAYER)
                && event.getWhoClicked().getInventory().getItem(8).getItemMeta().hasLore()
                && event.getCurrentItem().getItemMeta().getDisplayName().contains("Green Shell Gun")){       
            event.setCancelled(true);
        }
        
        if (event.getCurrentItem() != null && event.getClick() == ClickType.NUMBER_KEY) {
            if (event.getWhoClicked().getInventory().getItem(8) != null && 
                    event.getWhoClicked().getInventory().getItem(8).getItemMeta().hasLore() &&
                    event.getWhoClicked().getInventory().getItem(8).getItemMeta().getDisplayName().contains("Air Strike")) {
                event.getWhoClicked().sendMessage(ChatColor.RED + "Number Keys are disabled while Gadget Equipped");
                event.setCancelled(true);
            }
        }
        if (event.getCurrentItem() != null && event.getCurrentItem().getItemMeta() != null && event.getSlot() == 8 
                && (event.getClickedInventory().getType() == InventoryType.PLAYER)
                && event.getWhoClicked().getInventory().getItem(8).getItemMeta().hasLore()
                && event.getCurrentItem().getItemMeta().getDisplayName().contains("Air Strike")){       
            event.setCancelled(true);
        }
        
        if (event.getCurrentItem() != null && event.getClick() == ClickType.NUMBER_KEY) {
            if (event.getWhoClicked().getInventory().getItem(8) != null && 
                    event.getWhoClicked().getInventory().getItem(8).getItemMeta().hasLore() &&
                    event.getWhoClicked().getInventory().getItem(8).getItemMeta().getDisplayName().contains("Firework Gadget")) {
                event.getWhoClicked().sendMessage(ChatColor.RED + "Number Keys are disabled while Gadget Equipped");
                event.setCancelled(true);
            }
        } 
        if (event.getCurrentItem() != null && event.getCurrentItem().getItemMeta() != null && event.getSlot() == 8 
                && (event.getClickedInventory().getType() == InventoryType.PLAYER)
                && event.getWhoClicked().getInventory().getItem(8).getItemMeta().hasLore()
                && event.getCurrentItem().getItemMeta().getDisplayName().contains("Firework Gadget")){       
            event.setCancelled(true);
        }
    }
        
    
    @EventHandler
    public void onQuit(PlayerQuitEvent event) {
        Player player = event.getPlayer();
        RemoveEffectsOnQuit.ClearEffects(player);
    }
    

}
