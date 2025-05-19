package config;

import java.util.Properties;

public class Configuration {
    private static Properties properties;
    static {
        properties = new Properties();
        try {
            properties.load(Configuration.class.getResourceAsStream("/config.properties"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getProperties(String key) {
        return properties.getProperty(key);
    }
}
