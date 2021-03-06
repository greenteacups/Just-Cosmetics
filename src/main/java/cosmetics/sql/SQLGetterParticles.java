package cosmetics.sql;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

import org.bukkit.entity.Player;

import cosmetics.Cosmetics;

public class SQLGetterParticles {
    private final Cosmetics plugin;
    public SQLGetterParticles(Cosmetics plugin) {
        this.plugin = plugin;
    }
    
    public void createTable() {
        PreparedStatement ps;
        try {
            ps = plugin.SQL.getConnection().prepareStatement("CREATE TABLE IF NOT EXISTS PlayerParticle " 
                    + "(NAME VARCHAR(100),UUID VARCHAR(100),TYPE VARCHAR(100),PATTERN VARCHAR(100))");
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void createPlayer(Player player) {
        try {
            UUID uuid = player.getUniqueId();
            if (!existsPlayer(uuid)) {
                PreparedStatement ps2 = plugin.SQL.getConnection().prepareStatement("INSERT INTO PlayerParticle"
                        + " (NAME,UUID) VALUES (?,?)");
                ps2.setString(1,  player.getName());
                ps2.setString(2, uuid.toString());
                ps2.executeUpdate();
                
                return;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public boolean existsPlayer(UUID uuid) {
        try {
            PreparedStatement ps = plugin.SQL.getConnection().prepareStatement("SELECT * FROM PlayerParticle WHERE UUID=?");
            ps.setString(1,  uuid.toString());
           
            ResultSet results = ps.executeQuery();
            if (results.next()) {
                //player is found
                return true;
            }
            return false;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean exists(UUID uuid, String type) {
        try {
            PreparedStatement ps = plugin.SQL.getConnection().prepareStatement("SELECT * FROM PlayerParticle WHERE UUID=? AND TYPE=?");
            ps.setString(1,  uuid.toString());
            ps.setString(2, type);
           
            ResultSet results = ps.executeQuery();
            if (results.next()) {
                //type is found
                return true;
            }
            return false;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public void addParticle(Player player, UUID uuid, String type, String pattern) {
        try {
            PreparedStatement ps = plugin.SQL.getConnection().prepareStatement("INSERT INTO PlayerParticle"
                    + " (NAME,UUID,TYPE,PATTERN) VALUES (?,?,?,?)");
            ps.setString(1,  player.getName());
            ps.setString(2, uuid.toString());
            ps.setString(3, (type));
            ps.setString(4, (pattern));
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public String getType(UUID uuid) {
        try {
            PreparedStatement ps = plugin.SQL.getConnection().prepareStatement("SELECT TYPE FROM PlayerParticle WHERE UUID=?");
            ps.setString(1, uuid.toString());
            ResultSet rs = ps.executeQuery();
            String type = null;
 
            if (rs.next()) {
                type = rs.getString("TYPE");
                return type;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public String getPattern(UUID uuid) {
        try {
            PreparedStatement ps = plugin.SQL.getConnection().prepareStatement("SELECT PATTERN FROM PlayerParticle WHERE UUID=?");
            ps.setString(1, uuid.toString());
            ResultSet rs = ps.executeQuery();
            String pattern = null;
            if (rs.next()) {
                pattern = rs.getString("PATTERN");
                return pattern;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    
    //DELETE STUFF
    
    public void emptyTable() {
        try {
            PreparedStatement ps = plugin.SQL.getConnection().prepareStatement("TRUNCATE PlayerParticle");
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void remove(UUID uuid) {
        try {
            PreparedStatement ps = plugin.SQL.getConnection().prepareStatement("DELETE FROM PlayerParticle WHERE UUID=?");
            ps.setString(1, uuid.toString());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}