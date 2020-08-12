package cosmetics.gadgets.items;

import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_16_R2.CraftWorld;
import org.bukkit.entity.Player;

import net.minecraft.server.v1_16_R2.EntityTurtle;
import net.minecraft.server.v1_16_R2.EntityTypes;

public class TurtleSpawn extends EntityTurtle {

    public TurtleSpawn(Location loc, Player player) {
        super(EntityTypes.TURTLE, ((CraftWorld) loc.getWorld()).getHandle());
        
        this.setPosition(loc.getX(), loc.getY(), loc.getZ());
        
        //this.setCustomNameVisible(true);
        this.setInvulnerable(true);
        this.setNoAI(true);
    }
    
}
