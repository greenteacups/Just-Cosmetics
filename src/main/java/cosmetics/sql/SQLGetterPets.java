package cosmetics.sql;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

import org.bukkit.entity.Player;

import cosmetics.Cosmetics;

public class SQLGetterPets {
    private final Cosmetics plugin;
    public SQLGetterPets(Cosmetics plugin) {
        this.plugin = plugin;
    }
    
    public void createTable() {
        PreparedStatement ps;
        try {
            ps = plugin.SQL.getConnection().prepareStatement("CREATE TABLE IF NOT EXISTS PETS " 
                    + "(NAME VARCHAR(100),UUID VARCHAR(100),PET VARCHAR(100))");
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void createPlayer(Player player) {
        try {
            UUID uuid = player.getUniqueId();
            if (!existsPlayer(uuid)) {
                PreparedStatement ps2 = plugin.SQL.getConnection().prepareStatement("INSERT INTO PETS"
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
            PreparedStatement ps = plugin.SQL.getConnection().prepareStatement("SELECT * FROM PETS WHERE UUID=?");
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
    
    public boolean exists(UUID uuid, String pet) {
        try {
            PreparedStatement ps = plugin.SQL.getConnection().prepareStatement("SELECT * FROM PETS WHERE UUID=? AND PET=?");
            ps.setString(1,  uuid.toString());
            ps.setString(2, pet);
           
            ResultSet results = ps.executeQuery();
            if (results.next()) {
                //pet is found
                return true;
            }
            return false;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public void addPet(Player player, UUID uuid, String pet) {
        try {
            PreparedStatement ps = plugin.SQL.getConnection().prepareStatement("INSERT INTO PETS"
                    + " (NAME,UUID,PET) VALUES (?,?,?)");
            ps.setString(1,  player.getName());
            ps.setString(2, uuid.toString());
            ps.setString(3, (pet));
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public String getPet(UUID uuid) {
        try {
            PreparedStatement ps = plugin.SQL.getConnection().prepareStatement("SELECT PET FROM PETS WHERE UUID=?");
            ps.setString(1, uuid.toString());
            ResultSet rs = ps.executeQuery();
            String pet = null;
 
            if (rs.next()) {
                pet = rs.getString("PET");
                return pet;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    
    //DELETE STUFF
    
    public void emptyTable() {
        try {
            PreparedStatement ps = plugin.SQL.getConnection().prepareStatement("TRUNCATE PETS");
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void remove(UUID uuid) {
        try {
            PreparedStatement ps = plugin.SQL.getConnection().prepareStatement("DELETE FROM PETS WHERE UUID=?");
            ps.setString(1, uuid.toString());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}