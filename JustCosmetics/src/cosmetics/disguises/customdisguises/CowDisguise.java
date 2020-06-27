package cosmetics.disguises.customdisguises;

import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_15_R1.CraftWorld;
import org.bukkit.entity.Player;

import net.minecraft.server.v1_15_R1.EntityCow;
import net.minecraft.server.v1_15_R1.EntityTypes;
import net.minecraft.server.v1_15_R1.GenericAttributes;

public class CowDisguise extends EntityCow {

    public CowDisguise(Location loc, Player player) {
        super(EntityTypes.COW, ((CraftWorld) loc.getWorld()).getHandle());
        
        this.setPosition(loc.getX(), loc.getY(), loc.getZ());
        
        this.setCustomNameVisible(true);
        this.setInvulnerable(true);
        //this.setHealth(1);
        this.setNoAI(true);
        this.getAttributeInstance(GenericAttributes.MOVEMENT_SPEED).setValue(0.0D);
        this.setNoGravity(true);
    }
    
}