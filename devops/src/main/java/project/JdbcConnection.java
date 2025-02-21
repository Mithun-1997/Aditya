package project;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class JdbcConnection {
    private static Connection connection = null;

    public static Connection getConnection() throws SQLException, IOException {
        if (connection == null || connection.isClosed()) {
            Properties props = new Properties();

            try (InputStream fis = JdbcConnection.class.getClassLoader().getResourceAsStream("properties/environment.properties")) {
                if (fis == null) {
                    throw new IOException("Properties file not found: properties/environment.properties");
                }
                props.load(fis);
            }

            String url = props.getProperty("db.url");
            String user = props.getProperty("db.username");
            String password = props.getProperty("db.password");

            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                throw new SQLException("MySQL JDBC Driver not found!", e);
            }

            connection = DriverManager.getConnection(url, user, password);
        }
        return connection;
    }
}
