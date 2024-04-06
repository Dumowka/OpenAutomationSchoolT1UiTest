package common;

import java.io.File;
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
            File localConfig = new File("local.properties");
            if (localConfig.exists()) {
                properties.load(new FileReader(localConfig));
            }

            System.getenv().forEach(properties::setProperty);

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
