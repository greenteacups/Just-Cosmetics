package cosmetics.gadgets.items;

import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_16_R1.CraftWorld;
import org.bukkit.entity.Player;

import net.minecraft.server.v1_16_R1.EntityParrot;
import net.minecraft.server.v1_16_R1.EntityTypes;

public class ParrotSpawn extends EntityParrot {

    public ParrotSpawn(Location loc, Player player) {
        super(EntityTypes.PARROT, ((CraftWorld) loc.getWorld()).getHandle());
        
        this.setPosition(loc.getX(), loc.getY(), loc.getZ());
        
        //this.setCustomNameVisible(true);
        this.setInvulnerable(true);
        this.setNoAI(true);
    }
    
}