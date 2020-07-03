package cosmetics.disguises.customdisguises;

import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_16_R1.CraftWorld;
import org.bukkit.entity.Player;

import net.minecraft.server.v1_16_R1.EntityCow;
import net.minecraft.server.v1_16_R1.EntityTypes;

public class CowDisguise extends EntityCow {

    public CowDisguise(Location loc, Player player) {
        super(EntityTypes.COW, ((CraftWorld) loc.getWorld()).getHandle());
        
        this.setPosition(loc.getX(), loc.getY(), loc.getZ());
        
        this.setCustomNameVisible(true);
        this.setInvulnerable(true);
        this.setNoAI(true);
    }
    
}