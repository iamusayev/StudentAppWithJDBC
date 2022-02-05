package StudentsJdbc.app.connection;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class ConnectionManager {
    private ConnectionManager() {
    }

    ;

    public static final String URL_KEY = "db.url";
    public static final String USERNAME_KEY = "db.username";
    public static final String PASSWORD_KEY = "db.password";


    public static Connection open() {
        try {
            return DriverManager.getConnection(MyProperties.get(URL_KEY),
                    MyProperties.get(USERNAME_KEY),
                    MyProperties.get(PASSWORD_KEY));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}
