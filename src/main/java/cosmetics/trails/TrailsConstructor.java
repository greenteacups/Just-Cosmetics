package cosmetics.trails;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import java.util.*;

public class TrailsConstructor implements Listener {
    
    Random random = new Random();
    
    public static HashMap<Player, List<Location>> blockLocMap = new HashMap<>();
    
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
            Material[] discoTrail = new Material[]    {Material.DIRT,
                                                            Material.DIRT,
                                                            Material.COARSE_DIRT,
                                                            Material.COARSE_DIRT,
                                                            Material.GRAVEL};

            material = discoTrail[random.nextInt(discoTrail.length)];
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
    
    
    public boolean doesBlockExist(Block bloc) {
        boolean exists = false;
        
        for (List<Location> list : blockLocMap.values()) {
            if (list.contains(bloc.getLocation())) {
                exists = true;
            }
        }
        return !exists;
    }
    
    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event) {
        Player player = event.getPlayer();
        
        if (trailsMap.containsKey(player) && player.getGameMode() != GameMode.SPECTATOR) {

            if (Math.abs(Math.sqrt(Math.pow(player.getLocation().getX(), 2) + Math.pow(player.getLocation().getZ(), 2))
                    - Math.sqrt(Math.pow(trailsMap.get(player).getX(), 2) + Math.pow(trailsMap.get(player).getZ(), 2))) >= 0.3) {
                
                for (int i = 0; i <= 5; i++) {
                    
                    int x = random.nextInt(3) - 1;
                    int z = random.nextInt(3) - 1;
                    Material material = trailType(player);
                    
                    Block bloc = player.getLocation().add(x, -1, z).getBlock();

                    Collections.addAll(exempt, exemptMaterials);
                    
                    if (!bloc.getLocation().add(0, 1, 0).getBlock().getType().isOccluding() && bloc.getType().isSolid() &&
                            bloc.getType().isOccluding() && bloc.getType() != Material.AIR && !exempt.contains(bloc.getType())) {
                        
                        
                        if (blockLocMap.containsKey(player)) {
                            
                            if (doesBlockExist(bloc)) {
                                if (blockLocMap.get(player).size() >= 10) {
                                    hideBlock(blockLocMap.get(player).remove(0));
                                }
                                
                                blockLocMap.get(player).add(bloc.getLocation());

                                showBlock(bloc, material);
                            }
                        }

                        
                        else {
                            if (doesBlockExist(bloc)) {
                                List<Location> blockLocList = new ArrayList<>();
                                
                                blockLocList.add(bloc.getLocation());
                                
                                blockLocMap.put(player, blockLocList);

                                showBlock(bloc, material);
                            }
                        }  
                    }
                    

                }
                
                trailsMap.replace(player, player.getLocation());
            }
            
        }

    }
    
    private void showBlock(Block block, Material material) {
        block.getWorld().getPlayers().forEach(p -> {
            if (chunkDistance(block.getLocation(), p.getLocation()) <= Bukkit.getViewDistance()) {
                p.sendBlockChange(block.getLocation(), material.createBlockData());
            }
        });
    }
    
    public static void hideBlock(Location location) {
        if (location.getWorld() != null && location.getWorld().isChunkLoaded(location.getBlockX() >> 4, location.getBlockZ() >> 4)) {
            location.getBlock().getState().update(true, false);
        }
    }

    private int chunkDistance(Location loc1, Location loc2) {
        int cx1 = loc1.getBlockX() >> 4;
        int cz1 = loc1.getBlockZ() >> 4;
        int cx2 = loc2.getBlockX() >> 4;
        int cz2 = loc2.getBlockZ() >> 4;
        
        return Math.max(Math.abs(cx1 - cx2), Math.abs(cz1 - cz2));
    }
    
}
