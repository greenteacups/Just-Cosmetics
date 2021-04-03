package cosmetics.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import cosmetics.Cosmetics;

public class MySQL {

    public MySQL(Cosmetics b) {

        host = b.getConfig().getString("SQL.host");
        port = b.getConfig().getString("SQL.port");
        database = b.getConfig().getString("SQL.database");
        username = b.getConfig().getString("SQL.username");
        password = b.getConfig().getString("SQL.password");
    }

    private final String host;
    private final String port;
    private final String database;
    private final String username;
    private final String password;
    
    private Connection connection;
    
    public boolean isConnected() {
        return (connection != null);
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
