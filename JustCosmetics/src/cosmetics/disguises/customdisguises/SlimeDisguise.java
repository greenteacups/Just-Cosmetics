package cosmetics.disguises.customdisguises;

import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_16_R1.CraftWorld;
import org.bukkit.entity.Player;

import net.minecraft.server.v1_16_R1.EntitySlime;
import net.minecraft.server.v1_16_R1.EntityTypes;

public class SlimeDisguise extends EntitySlime {

    public SlimeDisguise(Location loc, Player player) {
        super(EntityTypes.SLIME, ((CraftWorld) loc.getWorld()).getHandle());
        
        this.setPosition(loc.getX(), loc.getY(), loc.getZ());
        
        this.setCustomNameVisible(true);
        this.setInvulnerable(true);
        this.setNoAI(true);
        
        this.setSize(4, true);
    }
    
}