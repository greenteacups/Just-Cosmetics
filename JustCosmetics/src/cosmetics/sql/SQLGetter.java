package cosmetics.sql;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

import org.bukkit.entity.Player;

import cosmetics.Cosmetics;


public class SQLGetter {

    private Cosmetics plugin;
    public SQLGetter(Cosmetics plugin) {
        this.plugin = plugin;
    }
    
    public void createTable() {
        PreparedStatement ps;
        try {
            ps = plugin.SQL.getConnection().prepareStatement("CREATE TABLE IF NOT EXISTS CosmeticCurrency " 
                    + "(NAME VARCHAR(100),UUID VARCHAR(100),SLIME INT(100),PRIMARY KEY (NAME))");
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void createPlayer(Player player) {
        try {
            UUID uuid = player.getUniqueId();
            if (!exists(uuid)) {
                PreparedStatement ps2 = plugin.SQL.getConnection().prepareStatement("INSERT INTO CosmeticCurrency"
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
    
    public boolean exists(UUID uuid) {
        try {
            PreparedStatement ps = plugin.SQL.getConnection().prepareStatement("SELECT * FROM CosmeticCurrency WHERE UUID=?");
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
    
    public void addSlime(UUID uuid, int slime) {
        try {
            PreparedStatement ps = plugin.SQL.getConnection().prepareStatement("UPDATE CosmeticCurrency SET SLIME=? WHERE UUID=?");
            ps.setInt(1, (getSlime(uuid) + slime));
            ps.setString(2, uuid.toString());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void removeSlime(UUID uuid, int slime) {
        try {
            PreparedStatement ps = plugin.SQL.getConnection().prepareStatement("UPDATE CosmeticCurrency SET SLIME=? WHERE UUID=?");
            ps.setInt(1, (getSlime(uuid) - slime));
            ps.setString(2, uuid.toString());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public int getSlime(UUID uuid) {
        try {
            PreparedStatement ps = plugin.SQL.getConnection().prepareStatement("SELECT SLIME FROM CosmeticCurrency WHERE UUID=?");
            ps.setString(1, uuid.toString());
            ResultSet rs = ps.executeQuery();
            int slime = 0;
            if (rs.next()) {
                slime = rs.getInt("SLIME");
                return slime;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
    
    
    //DELETE STUFF
    
    public void emptyTable() {
        try {
            PreparedStatement ps = plugin.SQL.getConnection().prepareStatement("TRUNCATE CosmeticCurrency");
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void remove(UUID uuid) {
        try {
            PreparedStatement ps = plugin.SQL.getConnection().prepareStatement("DELETE FROM CosmeticCurrency WHERE UUID=?");
            ps.setString(1, uuid.toString());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

