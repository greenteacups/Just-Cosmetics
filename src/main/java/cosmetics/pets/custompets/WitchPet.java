package cosmetics.pets.custompets;

import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_16_R3.CraftWorld;
import org.bukkit.craftbukkit.v1_16_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityTargetEvent.TargetReason;

import cosmetics.pets.PathfinderGoalPet;
import net.minecraft.server.v1_16_R3.EntityHuman;
import net.minecraft.server.v1_16_R3.EntityLiving;
import net.minecraft.server.v1_16_R3.EntityTypes;
import net.minecraft.server.v1_16_R3.EntityWitch;
import net.minecraft.server.v1_16_R3.PathfinderGoalFloat;
import net.minecraft.server.v1_16_R3.PathfinderGoalLookAtPlayer;

public class WitchPet extends EntityWitch {

    public WitchPet(Location loc, Player player) {
        super(EntityTypes.WITCH, ((CraftWorld) loc.getWorld()).getHandle());
        this.setPosition(loc.getX(), loc.getY(), loc.getZ());
        
        this.setGoalTarget((EntityLiving)((CraftPlayer)player).getHandle(),
                TargetReason.CUSTOM, true);
    }
    
    @Override
    public void initPathfinder() { //removes all pathfinder goals
        
        super.initPathfinder(); //runs mobs pathfinder before custom pathfinder
        
        this.goalSelector.a(0, new PathfinderGoalFloat(this));
        this.goalSelector.a(1, new PathfinderGoalPet(this, 1.5, 15));
        this.goalSelector.a(1, new PathfinderGoalLookAtPlayer(this, 
                EntityHuman.class, 8.0F));
        
    }
    
}