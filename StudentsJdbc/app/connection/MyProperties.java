package StudentsJdbc.app.connection;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public final class MyProperties {
    private MyProperties() {
    }

    ;

    private static final Properties PROPERTIES = new Properties();

    static {
        loadProperties();
    }

    public static String get(String key){
        return PROPERTIES.getProperty(key);
    }


    private static void loadProperties() {
        try (var stream = MyProperties.class.getClassLoader().getResourceAsStream("application.properties")) {
            PROPERTIES.load(stream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}
