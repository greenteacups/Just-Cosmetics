package cosmetics.trails;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.block.data.BlockData;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerMoveEvent;

public class TrailsConstructor implements Listener {
    
    Random random = new Random();
    
    public static HashMap<Player, List<Location>> blockLocMap = new HashMap<>();
    List<Location> blockLocList = new ArrayList<>();
    
    public static HashMap<Player, List<Material>> blockMatMap = new HashMap<>();
    List<Material> blockMatList = new ArrayList<>();
    
    public static HashMap<Player, List<BlockData>> blockDataMap = new HashMap<>();
    List<BlockData> blockDataList = new ArrayList<>();
    
    public static HashMap<Player, List<BlockState>> blockStateMap = new HashMap<>();
    List<BlockState> blockStateList = new ArrayList<>();
    
    public HashMap<Player, Location> trailsMap = TrailsGuiListeners.trailsMap;
    public HashMap<Player, String> trailTypeMap = TrailsGuiListeners.trailTypeMap;
    
    public Material trailType(Player player) {
        Material material = null;
        
        if (trailTypeMap.get(player).equals("Disco")) {
            Material[] discoTrail = new Material[]    {Material.BLUE_CONCRETE,
                                                            Material.CYAN_CONCRETE, 
                                                            Material.GREEN_CONCRETE,
                                                            Material.LIGHT_BLUE_CONCRETE, 
                                                            Material.LIME_CONCRETE, 
                                                            Material.MAGENTA_CONCRETE,
                                                            Material.ORANGE_CONCRETE,
                                                            Material.PINK_CONCRETE,
                                                            Material.PURPLE_CONCRETE,
                                                            Material.RED_CONCRETE,
                                                            Material.YELLOW_CONCRETE};
            
            material = discoTrail[random.nextInt(discoTrail.length)];
        }
        
        if (trailTypeMap.get(player).equals("Path")) {
            material = Material.GRASS_PATH;
        }
        
        if (trailTypeMap.get(player).equals("Utility")) {
            Material[] utilityTrail = new Material[]    {Material.CRAFTING_TABLE,
                                                            Material.FLETCHING_TABLE,
                                                            Material.CARTOGRAPHY_TABLE, 
                                                            Material.LOOM, 
                                                            Material.NOTE_BLOCK};
            
            material = utilityTrail[random.nextInt(utilityTrail.length)];
        }
        
        if (trailTypeMap.get(player).equals("Wealthy")) {
            Material[] weathlyTrail = new Material[]    {Material.DIAMOND_BLOCK,
                                                            Material.EMERALD_BLOCK,
                                                            Material.GOLD_BLOCK, 
                                                            Material.LAPIS_BLOCK,
                                                            Material.REDSTONE_BLOCK};
            
            material = weathlyTrail[random.nextInt(weathlyTrail.length)];
        }
        
        if (trailTypeMap.get(player).equals("Wood")) {
            Material[] woodTrail = new Material[]    {Material.ACACIA_PLANKS,
                                                            Material.BIRCH_PLANKS,
                                                            Material.CRIMSON_PLANKS, 
                                                            Material.DARK_OAK_PLANKS,
                                                            Material.JUNGLE_PLANKS,
                                                            Material.OAK_PLANKS,
                                                            Material.SPRUCE_PLANKS,
                                                            Material.WARPED_PLANKS};
            
            material = woodTrail[random.nextInt(woodTrail.length)];
        }
        
        if (trailTypeMap.get(player).equals("Ore")) {
            Material[] oreTrail = new Material[]    {Material.DIAMOND_ORE,
                                                            Material.EMERALD_ORE,
                                                            Material.GOLD_ORE, 
                                                            Material.LAPIS_ORE,
                                                            Material.REDSTONE_ORE,
                                                            Material.COAL_ORE};
            
            material = oreTrail[random.nextInt(oreTrail.length)];
        }
        
        if (trailTypeMap.get(player).equals("Nether")) {
            Material[] netherTrail = new Material[]    {Material.NETHERRACK,
                                                            Material.NETHER_BRICKS,
                                                            Material.NETHER_QUARTZ_ORE, 
                                                            Material.CRIMSON_NYLIUM,
                                                            Material.WARPED_NYLIUM,
                                                            Material.BLACKSTONE,
                                                            Material.SOUL_SOIL,
                                                            Material.NETHER_GOLD_ORE,
                                                            Material.CRIMSON_HYPHAE,
                                                            Material.WARPED_HYPHAE,
                                                            Material.NETHER_WART_BLOCK,
                                                            Material.WARPED_WART_BLOCK};
            
            material = netherTrail[random.nextInt(netherTrail.length)];
        }
        
        if (trailTypeMap.get(player).equals("End")) {
            Material[] endTrail = new Material[]    {Material.END_STONE,
                                                            Material.END_STONE,
                                                            Material.END_STONE_BRICKS,
                                                            Material.PURPUR_BLOCK, 
                                                            Material.OBSIDIAN};
            
            material = endTrail[random.nextInt(endTrail.length)];
        }
        
        if (trailTypeMap.get(player).equals("Melon")) {
            material = Material.MELON;
        }
        
        if (trailTypeMap.get(player).equals("Coral")) {
            Material[] coralTrail = new Material[]    {Material.BRAIN_CORAL_BLOCK,
                                                            Material.BUBBLE_CORAL_BLOCK,
                                                            Material.FIRE_CORAL_BLOCK,
                                                            Material.HORN_CORAL_BLOCK, 
                                                            Material.TUBE_CORAL_BLOCK};
            
            material = coralTrail[random.nextInt(coralTrail.length)];
        }
        
        return material;
    }
    
    
    List<Material> exempt = new ArrayList<>();
    
    Material[] exemptMaterials = new Material[]    {Material.CHEST, ///ADD blockstate.update
                                                    Material.TRAPPED_CHEST, 
                                                    Material.FURNACE,
                                                    Material.BLAST_FURNACE, 
                                                    Material.COMPOSTER, 
                                                    Material.DROPPER,
                                                    Material.DISPENSER,
                                                    Material.HOPPER,
                                                    Material.BREWING_STAND,
                                                    Material.FLOWER_POT,
                                                    Material.ARMOR_STAND,
                                                    Material.BARREL,
                                                    Material.LOOM,
                                                    Material.SMOKER,
                                                    Material.CARTOGRAPHY_TABLE,
                                                    Material.FLETCHING_TABLE,
                                                    Material.GRINDSTONE,
                                                    Material.LECTERN,
                                                    Material.SMITHING_TABLE,
                                                    Material.STONECUTTER,
                                                    };
    
    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event) {
        Player player = (Player) event.getPlayer();
        
        if (trailsMap.containsKey(player)) {

            if (Math.abs(Math.sqrt(Math.pow(player.getLocation().getX(), 2) + Math.pow(player.getLocation().getZ(), 2))
                    - Math.sqrt(Math.pow(trailsMap.get(player).getX(), 2) + Math.pow(trailsMap.get(player).getZ(), 2))) >= 0.3) {
                
                for (int i = 0; i <= 5; i++) {
                    
                    int x = random.nextInt(3) - 1;
                    int z = random.nextInt(3) - 1;
                    Material material = trailType(player);
                    
                    Block bloc = player.getLocation().add(x, -1, z).getBlock();
                    
                    //if (bloc.getLocation().add(0, 1, 0).getBlock().getType() != Material.AIR) return;
                    
                    for (int j = 0; j < exemptMaterials.length; j++) {
                        exempt.add(exemptMaterials[j]);
                    }

                    
                    if (bloc.getLocation().add(0, 1, 0).getBlock().getType() == Material.AIR && 
                            bloc.getType() != Material.AIR && !exempt.contains(bloc.getType())) {
                        
                        
                        if (blockLocMap.containsKey(player)) {
                            
                            for (List<Location> list : blockLocMap.values()) {
                                if (!list.contains(bloc.getLocation())) {
                                    if (blockLocMap.get(player).size() >= 10) {

                                        
                                        blockLocMap.get(player).get(0).getBlock().setType(blockMatMap.get(player).get(0));
                                        blockLocMap.get(player).get(0).getBlock().setBlockData(blockDataMap.get(player).get(0));
                                        blockStateMap.get(player).get(0).update();///
                                        
                                        blockLocMap.get(player).remove(0);
                                        blockMatMap.get(player).remove(0);
                                        blockDataMap.get(player).remove(0);
                                        blockStateMap.get(player).remove(0);///
                                    }
                                    
                                    blockLocMap.get(player).add(bloc.getLocation());
                                    blockMatMap.get(player).add(bloc.getType());
                                    blockDataMap.get(player).add(bloc.getBlockData());
                                    blockStateMap.get(player).add(bloc.getState());///
                                    
                                    bloc.setType(material);
                                }
                            }
                        }

                        
                        else {
                            
                            if (blockLocMap.isEmpty()) {
                                blockLocList.add(bloc.getLocation());
                                blockMatList.add(bloc.getType());
                                blockDataList.add(bloc.getBlockData());
                                blockStateList.add(bloc.getState());///
                                
                                blockLocMap.put(player, blockLocList);
                                blockMatMap.put(player, blockMatList);
                                blockDataMap.put(player, blockDataList);
                                blockStateMap.put(player, blockStateList);///
                                
                                bloc.setType(material);
                            }
                            
                            else {
                                for (List<Location> list : blockLocMap.values()) {/////
                                    if (!list.contains(bloc.getLocation())) {
                                        blockLocList.add(bloc.getLocation());
                                        blockMatList.add(bloc.getType());
                                        blockDataList.add(bloc.getBlockData());
                                        
                                        blockLocMap.put(player, blockLocList);
                                        blockMatMap.put(player, blockMatList);
                                        blockDataMap.put(player, blockDataList);
                                        
                                        bloc.setType(material);
                                    }
                                }
                            }
                            

                        }  
                    }
                    

                }
                
                trailsMap.replace(player, player.getLocation());
            }
            
        }

    }
    
    @EventHandler
    public void onTrailBreak(BlockBreakEvent event) {
        if (!blockLocMap.isEmpty()) {
            for (List<Location> list : blockLocMap.values()) {/////
                if (list.contains(event.getBlock().getLocation())) {
                    event.setCancelled(true);
                }
            }
        }

    }
    
}
