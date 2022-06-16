package mate.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionUtil {
    public static final String DB_BASE_NAME = "taxi";
    public static final String DB_USER_NAME = "dev";
    @SuppressWarnings("SpellCheckingInspection")
    public static final String DB_USER_PASSWORD = "Quaci_2sia0Me";
    public static final String DB_URL = "jdbc:mysql://localhost:3306/" + DB_BASE_NAME;

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Can't load JDBC driver for MySQL", e);
        }
    }

    public static Connection getConnection() {
        try {
            Properties dbProperties = new Properties();
            dbProperties.put("user", DB_USER_NAME);
            dbProperties.put("password", DB_USER_PASSWORD);
            return DriverManager.getConnection(DB_URL, dbProperties);
        } catch (SQLException e) {
            throw new RuntimeException("Can't create connection to DB", e);
        }
    }
}