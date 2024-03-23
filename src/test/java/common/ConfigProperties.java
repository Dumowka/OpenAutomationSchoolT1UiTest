package common;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigProperties {

    private static final Properties properties = new Properties();
    private static volatile ConfigProperties instance;

    private ConfigProperties() {}

    public static synchronized ConfigProperties getInstance() {
        if (instance == null) {
            instance = new ConfigProperties();
        }
        return instance;
    }

    static {
        try {
            properties.load(new FileReader("config.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getConfigParameter(String key) {
        if(properties.containsKey(key)) {
            return properties.getProperty(key);
        } else {
            return null;
        }
    }
}
