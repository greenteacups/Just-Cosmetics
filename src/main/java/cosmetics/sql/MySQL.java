package cosmetics.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import cosmetics.Cosmetics;

public class MySQL {
    
    private final Cosmetics plugin;

    public MySQL(Cosmetics b) {
        this.plugin = b;
        
        host = plugin.getConfig().getString("SQL.host");
        port = plugin.getConfig().getString("SQL.port");
        database = plugin.getConfig().getString("SQL.database");
        username = plugin.getConfig().getString("SQL.username");
        password = plugin.getConfig().getString("SQL.password");
    }

    private String host;
    private String port;
    private String database;
    private String username;
    private String password;
    
    private Connection connection;
    
    public boolean isConnected() {
        return (connection == null ? false : true);
    }
    
    public void connect() throws ClassNotFoundException, SQLException {
        if (!isConnected()) {
            connection = DriverManager.getConnection("jdbc:mysql://" +
                    host + ":" + port + "/" + database + "?useSSL=false",
                    username, password);
        }
    }
    
    public void disconnect() {
        if (isConnected()) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
        
    public Connection getConnection() {
        return connection;
    }
}
