package cosmetics.sql;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

import org.bukkit.entity.Player;

import cosmetics.Cosmetics;

public class SQLGetterCosmetics {

    private final Cosmetics plugin;
    public SQLGetterCosmetics(Cosmetics plugin) {
        this.plugin = plugin;
    }
    
    public void createTable() {
        PreparedStatement ps;
        try {
            ps = plugin.SQL.getConnection().prepareStatement("CREATE TABLE IF NOT EXISTS CosmeticItems " 
                    + "(NAME VARCHAR(100),UUID VARCHAR(100),ITEM VARCHAR(100))");
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void createPlayer(Player player) {
        try {
            UUID uuid = player.getUniqueId();
            if (!existsPlayer(uuid)) {
                PreparedStatement ps2 = plugin.SQL.getConnection().prepareStatement("INSERT INTO CosmeticItems"
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
            PreparedStatement ps = plugin.SQL.getConnection().prepareStatement("SELECT * FROM CosmeticItems WHERE UUID=?");
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
    
    public boolean exists(UUID uuid, String item) {
        try {
            PreparedStatement ps = plugin.SQL.getConnection().prepareStatement("SELECT * FROM CosmeticItems WHERE UUID=? AND ITEM=?");
            ps.setString(1,  uuid.toString());
            ps.setString(2, item);
           
            ResultSet results = ps.executeQuery();
            if (results.next()) {
                //item is found
                return true;
            }
            return false;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public void addItem(Player player, UUID uuid, String item) {
        try {
            PreparedStatement ps = plugin.SQL.getConnection().prepareStatement("INSERT INTO CosmeticItems"
                    + " (NAME,UUID,ITEM) VALUES (?,?,?)");
            ps.setString(1,  player.getName());
            ps.setString(2, uuid.toString());
            ps.setString(3, (item));
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
//    public void removeItem(UUID uuid, String item) {
//        try {
//            PreparedStatement ps = plugin.SQL.getConnection().prepareStatement("UPDATE CosmeticItems SET ITEM=? WHERE UUID=?");
//            ps.setString(1, (item));
//            ps.setString(2, uuid.toString());
//            ps.executeUpdate();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
    
    
    //DELETE STUFF
    
    public void emptyTable() {
        try {
            PreparedStatement ps = plugin.SQL.getConnection().prepareStatement("TRUNCATE CosmeticItems");
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void remove(UUID uuid) {
        try {
            PreparedStatement ps = plugin.SQL.getConnection().prepareStatement("DELETE FROM CosmeticItems WHERE UUID=?");
            ps.setString(1, uuid.toString());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}