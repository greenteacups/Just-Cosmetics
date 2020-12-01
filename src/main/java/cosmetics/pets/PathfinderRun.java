package cosmetics.pets;

import java.util.HashMap;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

import cosmetics.pets.listeners.PetGuiListeners;

public class PathfinderRun {

    public static HashMap<Player, Entity> currentPet = PetGuiListeners.currentPet;
    
    //Teleport pet to Cat
    public void PetTeleport(Player player) {
        
        if (currentPet.containsKey(player)) {
            
            Entity pet = currentPet.get(player);
            
            double x_dist = player.getLocation().getX() - pet.getLocation().getX();
            double z_dist = player.getLocation().getZ() - pet.getLocation().getZ();
            
            double dist = Math.sqrt(x_dist*x_dist + z_dist*z_dist);
            double theta = Math.atan2(z_dist, x_dist);
            
            double new_dist = dist - 0.2;
            double new_x_dist = new_dist*Math.cos(theta);
            double new_z_dist = new_dist*Math.sin(theta);
            
            // Find block infront of entity
            Location blc_infront = player.getLocation().subtract(0.8*new_x_dist, 0, 0.8*new_z_dist);
            blc_infront.setY(pet.getLocation().getY());
            
            if (dist > 3) {
                        
                Location player_loc = player.getLocation();
                player_loc.setY(pet.getLocation().getY());
                
                currentPet.get(player).teleport(player_loc.subtract(new_x_dist, 0, new_z_dist));
                             
            }
            
//            else {
//                Long test = System.currentTimeMillis()%200;
//                if (test <= 100) {
//                    Location wander_loc = player.getLocation().add(Math.round((System.currentTimeMillis()%60000)/10000), 0, Math.round((System.currentTimeMillis()%50000)/10000));
//                    
//                    double x_distt = player.getLocation().getX() - wander_loc.getX();
//                    double z_distt = player.getLocation().getZ() - wander_loc.getZ();
//                    
//                    double distt = Math.sqrt(x_distt*x_distt + z_distt*z_distt);
//                    double thetat = Math.atan2(z_distt, x_distt);
//                    
//                    double new_distt = distt - 0.05;
//                    double new_x_distt = new_distt*Math.cos(thetat);
//                    double new_z_distt = new_distt*Math.sin(thetat);
//                    
//                    
//                    currentnewpet.get(player).teleport(player.getLocation().subtract(new_x_distt, 0, new_z_distt));
//                }
//                
//            }
            
            // Move pet up if block infront exists
            if (blc_infront.getBlock().getType() != Material.AIR && blc_infront.getBlock().getType().isSolid() &&
                    blc_infront.getBlock().getType().isOccluding()) {
                pet.teleport(pet.getLocation().add(0, 1, 0));
            }
            
            // Move pet down if standing on air
            if (pet.getLocation().add(0, -0.5, 0).getBlock().getType() == Material.AIR && blc_infront.getBlock().getType() == Material.AIR) {
                pet.teleport(pet.getLocation().subtract(0, 0.5, 0));
            }
//            if (pet.getLocation().add(0, -0.45, 0).getBlock().getType() == Material.AIR && blc_infront.getBlock().getType() == Material.AIR) {
//                pet.teleport(pet.getLocation().subtract(0, 0.45, 0));
//            }   
            
            
            // Set yaw to face pet owner
            float yaw = (float) Math.toDegrees(Math.atan2(pet.getLocation().getX() - player.getLocation().getX(), 
                    pet.getLocation().getZ() - player.getLocation().getZ()) + Math.PI);
            Location pet_loc = pet.getLocation();
            pet_loc.setYaw(-yaw);
            
            if ((System.currentTimeMillis()/10)%600 > 200) {
                pet_loc.setPitch(-10);
            }
            else {
                pet_loc.setPitch(-1);
            }
            
            pet.teleport(pet_loc);
            
            // Teleport pet if far away
            if (dist > 25) {
                double tp_dist = dist - 22;
                double tp_x_dist = tp_dist*Math.cos(theta);
                double tp_z_dist = tp_dist*Math.sin(theta);
                        
                Location player_loc = player.getLocation();
                player_loc.setY(pet.getLocation().getY());
                
                currentPet.get(player).teleport(player_loc.subtract(tp_x_dist, 0, tp_z_dist));
            }
        }
        
//     if (currentpathfindcat.containsKey(player)) {
//         currentpathfindchicken.get(player).teleport(player.getLocation().add(0, 2, 0));
//         
//         currentnewpet.get(player).teleport(currentpathfindcat.get(player));
//     }
    }
}
