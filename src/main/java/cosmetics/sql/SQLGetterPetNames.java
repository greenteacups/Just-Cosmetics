package cosmetics.sql;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

import org.bukkit.entity.Player;

import cosmetics.Cosmetics;

public class SQLGetterPetNames {
    private final Cosmetics plugin;
    public SQLGetterPetNames(Cosmetics plugin) {
        this.plugin = plugin;
    }
    
    public void createTable() {
        PreparedStatement ps;
        try {
            ps = plugin.SQL.getConnection().prepareStatement("CREATE TABLE IF NOT EXISTS PETNAMES " 
                    + "(NAME VARCHAR(100),UUID VARCHAR(100),PETNAME VARCHAR(100))");
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void createPlayer(Player player) {
        try {
            UUID uuid = player.getUniqueId();
            if (!existsPlayer(uuid)) {
                PreparedStatement ps2 = plugin.SQL.getConnection().prepareStatement("INSERT INTO PETNAMES"
                        + " (NAME,UUID) VALUES (?,?)");
                ps2.setString(1,  player.getName());
                ps2.setString(2, uuid.toString());
                ps2.executeUpdate();

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public boolean existsPlayer(UUID uuid) {
        try {
            PreparedStatement ps = plugin.SQL.getConnection().prepareStatement("SELECT * FROM PETNAMES WHERE UUID=?");
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
    
    public boolean exists(UUID uuid, String petname) {
        try {
            PreparedStatement ps = plugin.SQL.getConnection().prepareStatement("SELECT * FROM PETNAMES WHERE UUID=? AND PETNAME=?");
            ps.setString(1,  uuid.toString());
            ps.setString(2, petname);
           
            ResultSet results = ps.executeQuery();
            if (results.next()) {
                //petname is found
                return true;
            }
            return false;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public void addPetName(Player player, UUID uuid, String petname) {
        try {
            PreparedStatement ps = plugin.SQL.getConnection().prepareStatement("INSERT INTO PETNAMES"
                    + " (NAME,UUID,PETNAME) VALUES (?,?,?)");
            ps.setString(1,  player.getName());
            ps.setString(2, uuid.toString());
            ps.setString(3, (petname));
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public String getPetName(UUID uuid) {
        try {
            PreparedStatement ps = plugin.SQL.getConnection().prepareStatement("SELECT PETNAME FROM PETNAMES WHERE UUID=?");
            ps.setString(1, uuid.toString());
            ResultSet rs = ps.executeQuery();
            String petname = null;
 
            if (rs.next()) {
                petname = rs.getString("PETNAME");
                return petname;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    
    //DELETE STUFF
    
    public void emptyTable() {
        try {
            PreparedStatement ps = plugin.SQL.getConnection().prepareStatement("TRUNCATE PETNAMES");
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void remove(UUID uuid) {
        try {
            PreparedStatement ps = plugin.SQL.getConnection().prepareStatement("DELETE FROM PETNAMES WHERE UUID=?");
            ps.setString(1, uuid.toString());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}