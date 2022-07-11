package sorces;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {

    private static final String PASSWORD_KEY = "db.password";
    private static final String USERNAME_KEY = "db.username";
    private static final String URL_KEY = "db.url";

    static {
        loadDriver();
    }

    private ConnectionManager() {

    }

    public static Connection connectOLD() throws SQLException {
        String password = "admin";
        String userName = "postgres";
        String url = "jdbc:postgresql://localhost:5432/postgres";
        Class<Driver> driverClass = Driver.class;
        return DriverManager.getConnection(url, userName, password);
    }


    private static void loadDriver() {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
