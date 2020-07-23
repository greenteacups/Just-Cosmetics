package cosmetics.pets.custompets;

import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_16_R1.CraftWorld;
import org.bukkit.craftbukkit.v1_16_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityTargetEvent.TargetReason;

import cosmetics.pets.PathfinderGoalPet;
import net.minecraft.server.v1_16_R1.EntityCreeper;
import net.minecraft.server.v1_16_R1.EntityHuman;
import net.minecraft.server.v1_16_R1.EntityLiving;
import net.minecraft.server.v1_16_R1.EntityTypes;
import net.minecraft.server.v1_16_R1.PathfinderGoalFloat;
import net.minecraft.server.v1_16_R1.PathfinderGoalLookAtPlayer;

public class CreeperPet extends EntityCreeper {

    public CreeperPet(Location loc, Player player) {
        super(EntityTypes.CREEPER, ((CraftWorld) loc.getWorld()).getHandle());
        this.setPosition(loc.getX(), loc.getY(), loc.getZ());
        
        this.setGoalTarget((EntityLiving)((CraftPlayer)player).getHandle(),
                TargetReason.CUSTOM, true);
    }
    
    @Override
    public void initPathfinder() { //removes all pathfinder goals
        this.goalSelector.a(0, new PathfinderGoalFloat(this));
        this.goalSelector.a(1, new PathfinderGoalPet(this, 1.5, 15));
        this.goalSelector.a(1, new PathfinderGoalLookAtPlayer(this, 
                EntityHuman.class, 8.0F));
        
    }
    
}
