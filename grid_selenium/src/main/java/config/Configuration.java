package config;

import java.util.Properties;

public class Configuration {
    private static final Properties properties;
    static {
        properties = new Properties();
        try {
            properties.load(Configuration.class.getResourceAsStream("/config.properties"));
        } catch (Exception e) {
            throw new RuntimeException("Could not load config.properties", e);
        }
    }

    public static String getProperties(String key) {
        return properties.getProperty(key);
    }
}
