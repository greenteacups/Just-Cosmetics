package cosmetics.pets;

import com.github.puregero.multilib.MultiLib;
import com.google.common.collect.HashBiMap;
import cosmetics.pets.listeners.PetGuiListeners;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

public class PathfinderRun {

    public static HashBiMap<Player, Entity> currentPet = PetGuiListeners.currentPet;
    
    //Teleport pet to Cat
    public void PetTeleport(Player player) {

        Entity pet = currentPet.get(player);

        if (pet != null) {
            
            if (pet.getWorld() != player.getWorld()) {
                // Different worlds, teleport to the player
                if (isChunkLoaded(player.getLocation())) {
                    MultiLib.teleportAsync(pet, player.getLocation());
                }
                return;
            }
            
            double x_dist = player.getLocation().getX() - pet.getLocation().getX();
            double z_dist = player.getLocation().getZ() - pet.getLocation().getZ();
            
            double dist = Math.sqrt(x_dist*x_dist + z_dist*z_dist);
            double theta = Math.atan2(z_dist, x_dist);

            // Teleport pet if far away
            if (dist > 25) {
                double tp_dist = 25;
                double tp_x_dist = tp_dist*Math.cos(theta);
                double tp_z_dist = tp_dist*Math.sin(theta);

                Location player_loc = player.getLocation();
                player_loc.setY(pet.getLocation().getY());
                player_loc.subtract(tp_x_dist, 0, tp_z_dist);

                if (isChunkLoaded(player_loc)) {
                    // Don't teleport if the location isn't loaded
                    MultiLib.teleportAsync(pet, player_loc);
                }

                return;
            }
            
            double new_dist = dist - 0.2;
            double new_x_dist = new_dist*Math.cos(theta);
            double new_z_dist = new_dist*Math.sin(theta);
            
            // Find block infront of entity
            Location blc_infront = player.getLocation().subtract(0.7*new_x_dist, 0, 0.7*new_z_dist);
            blc_infront.setY(pet.getLocation().getY());

            Location petLocation = pet.getLocation();
            
            if (dist > 3) {

                petLocation = player.getLocation();
                petLocation.setY(pet.getLocation().getY());

                petLocation = petLocation.subtract(new_x_dist, 0, new_z_dist);

                if (!isChunkLoaded(petLocation)) {
                    // Wait until the chunk is loaded
                    return;
                }

                // MultiLib.teleportAsync(pet, petLocation);
                             
            }

            
//            System.out.println(blc_infront.getBlock().getType());
//            //System.out.println(petLocation.add(0, -0.5, 0).getBlock().getType());
//            // Move pet up if block infront exists
//            if (blc_infront.getBlock().getType() != Material.AIR) {
//                petLocation = petLocation.add(0, 0.5, 0);
//            }
//            else if (petLocation.add(0, -0.5, 0).getBlock().getType() == Material.AIR) {
//                petLocation = petLocation.subtract(0, 0.5, 0);
//            }

            if (!isChunkLoaded(petLocation)) {
                // Wait until the chunk is loaded
                return;
            }
            
            
            
            if (petLocation.getBlock().getType() != Material.AIR && petLocation.getBlock().getType().isSolid() ) {
                petLocation = petLocation.add(0, 0.5, 0);
            }
//            else {
//                petLocation = petLocation.subtract(0, 0.5, 0);
//            }
            
            
            // Move pet down if standing on air
            if (petLocation.clone().add(0, -0.5, 0).getBlock().getType() == Material.AIR && blc_infront.getBlock().getType() == Material.AIR) {
                petLocation = petLocation.subtract(0, 0.5, 0);
            }

            if (petLocation.getY()%0.5 != 0) {
                petLocation.setY(Math.round(petLocation.getY()));
            }
            
            
//            if (petLocation.add(0, -0.45, 0).getBlock().getType() == Material.AIR && blc_infront.getBlock().getType() == Material.AIR) {
//                petLocation = petLocation.subtract(0, 0.45, 0));
//            }   


            // Set yaw to face pet owner
            float yaw = (float) Math.toDegrees(Math.atan2(pet.getLocation().getX() - player.getLocation().getX(), 
                    petLocation.getZ() - player.getLocation().getZ()) + Math.PI);
            petLocation.setYaw(-yaw);
            
            if ((System.currentTimeMillis()/10)%600 > 200) {
                petLocation.setPitch(-10);
            }
            else {
                petLocation.setPitch(-1);
            }
            
            MultiLib.teleportAsync(pet, petLocation);
            
            // System.out.println(petLocation.getY());
        }
        
//     if (currentpathfindcat.containsKey(player)) {
//         currentpathfindchicken.get(player).teleport(player.getLocation().add(0, 2, 0));
//         
//         currentnewpet.get(player).teleport(currentpathfindcat.get(player));
//     }
    }
    
    private boolean isChunkLoaded(Location loc) {
        return loc.getWorld().isChunkLoaded(loc.getBlockX() >> 4, loc.getBlockZ() >> 4);
    }
}
