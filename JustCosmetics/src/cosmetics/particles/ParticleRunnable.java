package cosmetics.particles;

import java.util.HashMap;

import org.bukkit.Particle;
import org.bukkit.entity.Player;

import cosmetics.particles.listeners.ParticleGuiListeners;

public class ParticleRunnable  {

    public static HashMap<Player, Particle> currentParticleType = ParticleGuiListeners.currentParticleType;
    public static HashMap<Player, String> currentParticlePattern = ParticleGuiListeners.currentParticlePattern;
    
    public static void RunParticle(Player player) {
        
        if (currentParticleType.containsKey(player) && currentParticlePattern.containsKey(player)) {
            
            if (currentParticlePattern.get(player) == "Dot") {
                
                player.getLocation().getWorld().spawnParticle(currentParticleType.get(player),
                        player.getLocation().getX(),
                        player.getLocation().add(0, 2, 0).getY(),
                        player.getLocation().getZ(), 0);
            }
            
            if (currentParticlePattern.get(player) == "Halo") {
                
                double thetanew = System.currentTimeMillis()/100.0 + Math.PI * 2 / 3;
                
                player.getLocation().getWorld().spawnParticle(currentParticleType.get(player),
                        player.getLocation().add(0.5*Math.cos(thetanew), 0, 0).getX(),
                        player.getLocation().add(0, 2, 0).getY(),
                        player.getLocation().add(0, 0, 0.5*Math.sin(thetanew)).getZ(), 0);
            }
            
            if (currentParticlePattern.get(player) == "Rings") {
                
                double thetanew = System.currentTimeMillis()/200.0 + Math.PI * 2 / 3;
                
                player.getLocation().getWorld().spawnParticle(currentParticleType.get(player),
                        player.getLocation().add(1.0*Math.cos(thetanew), 0, 0).getX(),
                        player.getLocation().add(0, 1.0*Math.cos(thetanew) + 1, 0).getY(),
                        player.getLocation().add(0, 0, 1.0*Math.sin(thetanew)).getZ(), 0);
                
                player.getLocation().getWorld().spawnParticle(currentParticleType.get(player),
                        player.getLocation().add(1.0*Math.sin(thetanew), 0, 0).getX(),
                        player.getLocation().add(0, -1.0*Math.sin(thetanew) + 1, 0).getY(),
                        player.getLocation().add(0, 0, 1.0*Math.cos(thetanew)).getZ(), 0);
            }
            
            if (currentParticlePattern.get(player) == "Sphere") {
                
                for (double j = 0; j <= 1; j = j + 0.33) {
                    for (int i = 0; i < 360; i = i + 30) {
                        player.getLocation().getWorld().spawnParticle(currentParticleType.get(player),
                                player.getLocation().add((j+0.2)*Math.cos(Math.toRadians(i)), 0, 0).getX(),
                                player.getLocation().add(0, j*j-0.2, 0).getY(),
                                player.getLocation().add(0, 0, (j+0.2)*Math.sin(Math.toRadians(i))).getZ(), 0);
                        
                        player.getLocation().getWorld().spawnParticle(currentParticleType.get(player),
                                player.getLocation().add((j+0.2)*Math.cos(Math.toRadians(i)), 0, 0).getX(),
                                player.getLocation().add(0, 2.2-j*j, 0).getY(),
                                player.getLocation().add(0, 0, (j+0.2)*Math.sin(Math.toRadians(i))).getZ(), 0);
                    }
                }
            }
            
            if (currentParticlePattern.get(player) == "Prism") {
                
                for (double j = -0.2; j <= 1.0; j = j + 0.2) {
                    for (int i = 0; i < 360; i = i + 30) {
                        player.getLocation().getWorld().spawnParticle(currentParticleType.get(player),
                                player.getLocation().add((j+0.2)*Math.cos(Math.toRadians(i)), 0, 0).getX(),
                                player.getLocation().add(0, j, 0).getY(),
                                player.getLocation().add(0, 0, (j+0.2)*Math.sin(Math.toRadians(i))).getZ(), 0);
                        
                        player.getLocation().getWorld().spawnParticle(currentParticleType.get(player),
                                player.getLocation().add((j+0.2)*Math.cos(Math.toRadians(i)), 0, 0).getX(),
                                player.getLocation().add(0, 2.2-j, 0).getY(),
                                player.getLocation().add(0, 0, (j+0.2)*Math.sin(Math.toRadians(i))).getZ(), 0);
                    }
                }
            }
            
            if (currentParticlePattern.get(player) == "Swirl Helix") {
                
                double thetanew = System.currentTimeMillis()/250.0 + Math.PI * 2 / 3;
                
                player.getLocation().getWorld().spawnParticle(currentParticleType.get(player),
                        player.getLocation().add(Math.sin(thetanew/2)*Math.cos(thetanew), 0, 0).getX(),
                        player.getLocation().add(0, Math.cos(thetanew/2) + 1, 0).getY(),
                        player.getLocation().add(0, 0, Math.sin(thetanew/2 )*Math.sin(thetanew)).getZ(), 0);
                
                player.getLocation().getWorld().spawnParticle(currentParticleType.get(player),
                        player.getLocation().add(-Math.sin(thetanew/2)*Math.cos(thetanew), 0, 0).getX(),
                        player.getLocation().add(0, Math.cos(thetanew/2) + 1, 0).getY(),
                        player.getLocation().add(0, 0, -Math.sin(thetanew/2 )*Math.sin(thetanew)).getZ(), 0);
            }
            
            if (currentParticlePattern.get(player) == "Cube") {
                
                int arr[] = {-1, 1};
                
                for (int i : arr) {
                    for (double j = -1; j <= 1; j = j + 0.1) {
                        for (int k = 0; k <= 2; k = k + 2) {
                            player.getLocation().getWorld().spawnParticle(currentParticleType.get(player),
                                    player.getLocation().add(i, 0, 0).getX(),
                                    player.getLocation().add(0, k, 0).getY(),
                                    player.getLocation().add(0, 0, j).getZ(), 0);
                            
                            player.getLocation().getWorld().spawnParticle(currentParticleType.get(player),
                                    player.getLocation().add(j, 0, 0).getX(),
                                    player.getLocation().add(0, k, 0).getY(),
                                    player.getLocation().add(0, 0, i).getZ(), 0);
                            
                            player.getLocation().getWorld().spawnParticle(currentParticleType.get(player),
                                    player.getLocation().add(i, 0, 0).getX(),
                                    player.getLocation().add(0, j + 1, 0).getY(),
                                    player.getLocation().add(0, 0, 1).getZ(), 0);
                            
                            player.getLocation().getWorld().spawnParticle(currentParticleType.get(player),
                                    player.getLocation().add(i, 0, 0).getX(),
                                    player.getLocation().add(0, j + 1, 0).getY(),
                                    player.getLocation().add(0, 0, -1).getZ(), 0);
                        }
                    }
                }
            }
            
            if (currentParticlePattern.get(player) == "Chains") {
                
                for (double i = 0; i <= 0.8; i = i + 0.1) {
                    player.getLocation().getWorld().spawnParticle(currentParticleType.get(player),
                            player.getLocation().add((1.2-i)*Math.sin(Math.toRadians(player.getLocation().getYaw()+90)), 0, 0).getX(),
                            player.getLocation().add(0, i, 0).getY(),
                            player.getLocation().add(0, 0, -(1.2-i)*Math.cos(Math.toRadians(player.getLocation().getYaw() + 130))).getZ(), 0);
                    
                    player.getLocation().getWorld().spawnParticle(currentParticleType.get(player),
                            player.getLocation().add((1.2-i)*Math.sin(Math.toRadians(player.getLocation().getYaw()-90)), 0, 0).getX(),
                            player.getLocation().add(0, i, 0).getY(),
                            player.getLocation().add(0, 0, -(1.2-i)*Math.cos(Math.toRadians(player.getLocation().getYaw() - 130))).getZ(), 0);
                    
                    player.getLocation().getWorld().spawnParticle(currentParticleType.get(player),
                            player.getLocation().add((1.2-i)*Math.sin(Math.toRadians(player.getLocation().getYaw()+90)), 0, 0).getX(),
                            player.getLocation().add(0, i, 0).getY(),
                            player.getLocation().add(0, 0, -(1.2-i)*Math.cos(Math.toRadians(player.getLocation().getYaw() + 50))).getZ(), 0);
                    
                    player.getLocation().getWorld().spawnParticle(currentParticleType.get(player),
                            player.getLocation().add((1.2-i)*Math.sin(Math.toRadians(player.getLocation().getYaw()-90)), 0, 0).getX(),
                            player.getLocation().add(0, i, 0).getY(),
                            player.getLocation().add(0, 0, -(1.2-i)*Math.cos(Math.toRadians(player.getLocation().getYaw() - 50))).getZ(), 0);
                } 
            }
            
            if (currentParticlePattern.get(player) == "Stars") { //Made by accident*
                double thetanew = System.currentTimeMillis()/100.0 + Math.PI * 2 / 3;
                
                double pos =  Math.floorMod(System.currentTimeMillis(), 11);
                
                player.getLocation().getWorld().spawnParticle(currentParticleType.get(player),
                        player.getLocation().add(pos*Math.cos(thetanew), 0, 0).getX(),
                        player.getLocation().add(0, Math.floorMod(System.currentTimeMillis(), 11), 0).getY(),
                        player.getLocation().add(0, 0, pos*Math.sin(thetanew)).getZ(), 0);
            }
            
            if (currentParticlePattern.get(player) == "Hourglass") {
                
                double thetanew = System.currentTimeMillis()/250.0 + Math.PI * 2 / 3;
                
                player.getLocation().getWorld().spawnParticle(currentParticleType.get(player),
                        player.getLocation().add(Math.cos(thetanew), 0, 0).getX(),
                        player.getLocation().add(0, Math.cos(thetanew/2) + 1, 0).getY(),
                        player.getLocation().add(0, 0, Math.sin(thetanew)).getZ(), 0);
            
            }
            
            if (currentParticlePattern.get(player) == "Double Helix") {
                
                double thetanew = System.currentTimeMillis()/400.0 + Math.PI * 2 / 3;
                
                player.getLocation().getWorld().spawnParticle(currentParticleType.get(player),
                        player.getLocation().add(Math.cos(thetanew), 0, 0).getX(),
                        player.getLocation().add(0, 1.2*Math.cos(thetanew/4) + 1.2, 0).getY(),
                        player.getLocation().add(0, 0, Math.sin(thetanew)).getZ(), 0);
                
                player.getLocation().getWorld().spawnParticle(currentParticleType.get(player),
                        player.getLocation().add(-Math.cos(thetanew), 0, 0).getX(),
                        player.getLocation().add(0, 1.2*Math.cos(thetanew/4) + 1.2, 0).getY(),
                        player.getLocation().add(0, 0, -Math.sin(thetanew)).getZ(), 0);
            }
            
            if (currentParticlePattern.get(player) == "QuadraHelix") {
                
                double thetanew = System.currentTimeMillis()/1000.0 + Math.PI * 2 / 3;
                double y = Math.abs(Math.cos(thetanew/2))*-1;
                
                player.getLocation().getWorld().spawnParticle(currentParticleType.get(player),
                        player.getLocation().add(0.7*Math.sin(thetanew/2)*Math.cos(thetanew), 0, 0).getX(),
                        player.getLocation().add(0, y + 1, 0).getY(),
                        player.getLocation().add(0, 0, 0.7*Math.sin(thetanew/2)*Math.sin(thetanew)).getZ(), 0);
                
                player.getLocation().getWorld().spawnParticle(currentParticleType.get(player),
                        player.getLocation().add(-0.7*Math.sin(thetanew/2)*Math.cos(thetanew), 0, 0).getX(),
                        player.getLocation().add(0, y + 1, 0).getY(),
                        player.getLocation().add(0, 0, -0.7*Math.sin(thetanew/2)*Math.sin(thetanew)).getZ(), 0);
                
                player.getLocation().getWorld().spawnParticle(currentParticleType.get(player),
                        player.getLocation().add(0.7*Math.sin(thetanew/2)*Math.sin(thetanew), 0, 0).getX(),
                        player.getLocation().add(0, y + 1, 0).getY(),
                        player.getLocation().add(0, 0, 0.7*Math.sin(thetanew/2)*Math.cos(thetanew)).getZ(), 0);
                
                player.getLocation().getWorld().spawnParticle(currentParticleType.get(player),
                        player.getLocation().add(-0.7*Math.sin(thetanew/2)*Math.sin(thetanew), 0, 0).getX(),
                        player.getLocation().add(0, y + 1, 0).getY(),
                        player.getLocation().add(0, 0, -0.7*Math.sin(thetanew/2)*Math.cos(thetanew)).getZ(), 0);
            }
            
            if (currentParticlePattern.get(player) == "Egg") {
                
                for (int i = 0; i <= 360; i = i + 15) {
                    
                    player.getLocation().getWorld().spawnParticle(currentParticleType.get(player),
                            player.getLocation().add(0.8*Math.sin(i/2)*Math.cos(i), 0, 0).getX(),
                            player.getLocation().add(0, Math.cos(i/2) + 1, 0).getY(),
                            player.getLocation().add(0, 0, 0.8*Math.sin(i/2)*Math.sin(i)).getZ(), 0);
                    
                    player.getLocation().getWorld().spawnParticle(currentParticleType.get(player),
                            player.getLocation().add(-0.8*Math.sin(i/2)*Math.cos(i), 0, 0).getX(),
                            player.getLocation().add(0, Math.cos(i/2) + 1, 0).getY(),
                            player.getLocation().add(0, 0, -0.8*Math.sin(i/2)*Math.sin(i)).getZ(), 0);
                    
                    player.getLocation().getWorld().spawnParticle(currentParticleType.get(player),
                            player.getLocation().add(0.8*Math.sin(i/2)*Math.sin(i), 0, 0).getX(),
                            player.getLocation().add(0, Math.cos(i/2) + 1, 0).getY(),
                            player.getLocation().add(0, 0, 0.8*Math.sin(i/2)*Math.cos(i)).getZ(), 0);
                    
                    player.getLocation().getWorld().spawnParticle(currentParticleType.get(player),
                            player.getLocation().add(-0.8*Math.sin(i/2)*Math.sin(i), 0, 0).getX(),
                            player.getLocation().add(0, Math.cos(i/2) + 1, 0).getY(),
                            player.getLocation().add(0, 0, -0.8*Math.sin(i/2)*Math.cos(i)).getZ(), 0);
                }
            }
                
            if (currentParticlePattern.get(player) == "Big Ring") {
                
                for (int i = 0; i <= 360; i = i + 5) {
                    player.getLocation().getWorld().spawnParticle(currentParticleType.get(player),
                            player.getLocation().add(5*Math.cos(Math.toRadians(i)), 0, 0).getX(),
                            player.getLocation().add(0, 0, 0).getY(),
                            player.getLocation().add(0, 0, 5*Math.sin(Math.toRadians(i))).getZ(), 0);
                }
                
                for (int i = 130; i <= 230; i = i + 5) {

                    player.getLocation().getWorld().spawnParticle(currentParticleType.get(player),
                            player.getLocation().add(5*Math.cos(Math.toRadians(i)) + 6, 0, 0).getX(),
                            player.getLocation().add(0, 0, 0).getY(),
                            player.getLocation().add(0, 0, 5*Math.sin(Math.toRadians(i))).getZ(), 0);
                }
                
                for (int i = 220; i <= 320; i = i + 5) {

                    player.getLocation().getWorld().spawnParticle(currentParticleType.get(player),
                            player.getLocation().add(5*Math.cos(Math.toRadians(i)), 0, 0).getX(),
                            player.getLocation().add(0, 0, 0).getY(),
                            player.getLocation().add(0, 0, 5*Math.sin(Math.toRadians(i)) + 6).getZ(), 0);
                }
                
                for (int i = 40; i <= 140; i = i + 5) {

                    player.getLocation().getWorld().spawnParticle(currentParticleType.get(player),
                            player.getLocation().add(5*Math.cos(Math.toRadians(i)), 0, 0).getX(),
                            player.getLocation().add(0, 0, 0).getY(),
                            player.getLocation().add(0, 0, 5*Math.sin(Math.toRadians(i)) - 6).getZ(), 0);
                }
                
                for (int i = 310; i <= 410; i = i + 5) {

                    player.getLocation().getWorld().spawnParticle(currentParticleType.get(player),
                            player.getLocation().add(5*Math.cos(Math.toRadians(i)) - 6, 0, 0).getX(),
                            player.getLocation().add(0, 0, 0).getY(),
                            player.getLocation().add(0, 0, 5*Math.sin(Math.toRadians(i))).getZ(), 0);
                }
                
                for (int i = 0; i <= 90; i = i + 5) {

                    player.getLocation().getWorld().spawnParticle(currentParticleType.get(player),
                            player.getLocation().add(5*Math.cos(Math.toRadians(i)) - 5, 0, 0).getX(),
                            player.getLocation().add(0, 0, 0).getY(),
                            player.getLocation().add(0, 0, 5*Math.sin(Math.toRadians(i)) - 5).getZ(), 0);
                }
                
                for (int i = 90; i <= 180; i = i + 5) {

                    player.getLocation().getWorld().spawnParticle(currentParticleType.get(player),
                            player.getLocation().add(5*Math.cos(Math.toRadians(i)) + 5, 0, 0).getX(),
                            player.getLocation().add(0, 0, 0).getY(),
                            player.getLocation().add(0, 0, 5*Math.sin(Math.toRadians(i)) - 5).getZ(), 0);
                }
                
                for (int i = 180; i <= 270; i = i + 5) {

                    player.getLocation().getWorld().spawnParticle(currentParticleType.get(player),
                            player.getLocation().add(5*Math.cos(Math.toRadians(i)) + 5, 0, 0).getX(),
                            player.getLocation().add(0, 0, 0).getY(),
                            player.getLocation().add(0, 0, 5*Math.sin(Math.toRadians(i)) + 5).getZ(), 0);
                }
                
                for (int i = 270; i <= 360; i = i + 5) {

                    player.getLocation().getWorld().spawnParticle(currentParticleType.get(player),
                            player.getLocation().add(5*Math.cos(Math.toRadians(i)) - 5, 0, 0).getX(),
                            player.getLocation().add(0, 0, 0).getY(),
                            player.getLocation().add(0, 0, 5*Math.sin(Math.toRadians(i)) + 5).getZ(), 0);
                }
                
                
            }
            
            if (currentParticlePattern.get(player) == "Normal") {
                
                if (Math.random() < 0.3) {
                    for (int i = 0; i <= 1; i++) {
                        player.getLocation().getWorld().spawnParticle(currentParticleType.get(player),
                                player.getLocation().add(Math.random()*2 - 1, 0, 0).getX(),
                                player.getLocation().add(0, Math.random()*2, 0).getY(),
                                player.getLocation().add(0, 0, Math.random()*2 - 1).getZ(), 0);
                    }
                }  
            }
            
            if (currentParticlePattern.get(player) == "Beams") {
                
                double thetanew = System.currentTimeMillis()/200.0 + Math.PI * 2 / 3;
                
                for (int i = 0; i <= 360; i = i + 30) {
                    player.getLocation().getWorld().spawnParticle(currentParticleType.get(player),
                            player.getLocation().add(Math.cos(Math.toRadians(i)), 0, 0).getX(),
                            player.getLocation().add(0, 1.2*Math.cos(thetanew/4) + 1.2, 0).getY(),
                            player.getLocation().add(0, 0, Math.sin(Math.toRadians(i))).getZ(), 0);
                }
            }
            
            if (currentParticlePattern.get(player) == "Cage") {
                
                for (int i = 0; i <= 360; i = i + 40) {
                    for (double j = 0; j <= 2.2; j = j + 0.2) {
                        
                        player.getLocation().getWorld().spawnParticle(currentParticleType.get(player),
                                player.getLocation().add(Math.cos(Math.toRadians(i)), 0, 0).getX(),
                                player.getLocation().add(0, j, 0).getY(),
                                player.getLocation().add(0, 0, Math.sin(Math.toRadians(i))).getZ(), 0); 

                        player.getLocation().getWorld().spawnParticle(currentParticleType.get(player),
                                player.getLocation().add(0.7*Math.cos(Math.toRadians(i)), 0, 0).getX(),
                                player.getLocation().add(0, 2.2, 0).getY(),
                                player.getLocation().add(0, 0, 0.7*Math.sin(Math.toRadians(i))).getZ(), 0); 
                            
                        player.getLocation().getWorld().spawnParticle(currentParticleType.get(player),
                                player.getLocation().add(0.7*Math.cos(Math.toRadians(i)), 0, 0).getX(),
                                player.getLocation().add(0, 0, 0).getY(),
                                player.getLocation().add(0, 0, 0.7*Math.sin(Math.toRadians(i))).getZ(), 0);
                        
                        player.getLocation().getWorld().spawnParticle(currentParticleType.get(player),
                                player.getLocation().add(0.4*Math.cos(Math.toRadians(i)), 0, 0).getX(),
                                player.getLocation().add(0, 2.2, 0).getY(),
                                player.getLocation().add(0, 0, 0.4*Math.sin(Math.toRadians(i))).getZ(), 0); 
                            
                        player.getLocation().getWorld().spawnParticle(currentParticleType.get(player),
                                player.getLocation().add(0.4*Math.cos(Math.toRadians(i)), 0, 0).getX(),
                                player.getLocation().add(0, 0, 0).getY(),
                                player.getLocation().add(0, 0, 0.4*Math.sin(Math.toRadians(i))).getZ(), 0);
                        
                    }
                }
            }
            
            if (currentParticlePattern.get(player) == "Test") {
                for (int i = 0; i <= 180; i = i + 30) {
                    player.getLocation().getWorld().spawnParticle(currentParticleType.get(player),
                            player.getLocation().add(0.9*Math.cos(Math.toRadians(i))*Math.sin(Math.toRadians(player.getLocation().getYaw()))-1, 0, 0).getX(),
                            player.getLocation().add(0, 0.9*Math.sin(Math.toRadians(i)) + 4.1, 0).getY(),
                            player.getLocation().add(0, 0, 0.9*Math.sin(Math.toRadians(i))*Math.cos(Math.toRadians(player.getLocation().getYaw()))-1).getZ(), 0);
                    
                    player.getLocation().getWorld().spawnParticle(currentParticleType.get(player),
                            player.getLocation().add(0.9*Math.cos(Math.toRadians(i))+1, 0, 0).getX(),
                            player.getLocation().add(0, 0.9*Math.sin(Math.toRadians(i)) + 4.1, 0).getY(),
                            player.getLocation().add(0, 0, 0).getZ(), 0);
                }
                
                for (double i = 2; i <= 4.0; i = i + 0.2) {
                    player.getLocation().getWorld().spawnParticle(currentParticleType.get(player),
                            player.getLocation().add(i-2, 0, 0).getX(),
                            player.getLocation().add(0, i, 0).getY(),
                            player.getLocation().add(0, 0, 0).getZ(), 0);
                    
                    player.getLocation().getWorld().spawnParticle(currentParticleType.get(player),
                            player.getLocation().add(-i+2, 0, 0).getX(),
                            player.getLocation().add(0, i, 0).getY(),
                            player.getLocation().add(0, 0, 0).getZ(), 0);
                }
            }


            
        }
        return;
    }
        
    public static void RunParticleSlow(Player player) {
        
        if (currentParticleType.containsKey(player) && currentParticlePattern.containsKey(player)) {
            if (currentParticlePattern.get(player) == "Burst") {
                
                double x = (Math.random()-0.5)*2;
                double z = (Math.random()-0.5)*2;
                
                for (int i = 0; i < 7; i++) {
                    player.getLocation().getWorld().spawnParticle(currentParticleType.get(player),
                            player.getLocation().add(x + Math.random()/2, 0, 0).getX(),
                            player.getLocation().add(0, 2 - Math.random(), 0).getY(),
                            player.getLocation().add(0, 0, z + Math.random()/2).getZ(), 0);
                }
                

            }
            
            
            if (currentParticlePattern.get(player) == "Smiley") {
                
                for (int i = 0; i < 360; i = i + 30) {
                    player.getLocation().getWorld().spawnParticle(currentParticleType.get(player),
                            player.getLocation().add(1.5*Math.cos(Math.toRadians(i)), 0, 0).getX(),
                            player.getLocation().add(0, 1.5*Math.sin(Math.toRadians(i)) + 4, 0).getY(),
                            player.getLocation().add(0, 0, 0).getZ(), 0);
                }
                
                for (int i = 210; i <= 330; i = i + 30) {
                    player.getLocation().getWorld().spawnParticle(currentParticleType.get(player),
                            player.getLocation().add(0.9*Math.cos(Math.toRadians(i)), 0, 0).getX(),
                            player.getLocation().add(0, 0.9*Math.sin(Math.toRadians(i)) + 4.1, 0).getY(),
                            player.getLocation().add(0, 0, 0).getZ(), 0);
                }
                
                player.getLocation().getWorld().spawnParticle(currentParticleType.get(player),
                player.getLocation().add(0.5, 0, 0).getX(),
                player.getLocation().add(0, 4.6, 0).getY(),
                player.getLocation().add(0, 0, 0).getZ(), 0);
                
                player.getLocation().getWorld().spawnParticle(currentParticleType.get(player),
                player.getLocation().add(-0.5, 0, 0).getX(),
                player.getLocation().add(0, 4.6, 0).getY(),
                player.getLocation().add(0, 0, 0).getZ(), 0);

            
            }
        }
        
        if (currentParticlePattern.get(player) == "Heart") {
            for (int i = 0; i <= 180; i = i + 30) {
                player.getLocation().getWorld().spawnParticle(currentParticleType.get(player),
                        player.getLocation().add(0.9*Math.cos(Math.toRadians(i))-1, 0, 0).getX(),
                        player.getLocation().add(0, 0.9*Math.sin(Math.toRadians(i)) + 4.1, 0).getY(),
                        player.getLocation().add(0, 0, 0).getZ(), 0);
                
                player.getLocation().getWorld().spawnParticle(currentParticleType.get(player),
                        player.getLocation().add(0.9*Math.cos(Math.toRadians(i))+1, 0, 0).getX(),
                        player.getLocation().add(0, 0.9*Math.sin(Math.toRadians(i)) + 4.1, 0).getY(),
                        player.getLocation().add(0, 0, 0).getZ(), 0);
            }
            
            for (double i = 2; i <= 4.0; i = i + 0.2) {
                player.getLocation().getWorld().spawnParticle(currentParticleType.get(player),
                        player.getLocation().add(i-2, 0, 0).getX(),
                        player.getLocation().add(0, i, 0).getY(),
                        player.getLocation().add(0, 0, 0).getZ(), 0);
                
                player.getLocation().getWorld().spawnParticle(currentParticleType.get(player),
                        player.getLocation().add(-i+2, 0, 0).getX(),
                        player.getLocation().add(0, i, 0).getY(),
                        player.getLocation().add(0, 0, 0).getZ(), 0);
            }
        }
        
        return; 
    }
        

        
        
    

}