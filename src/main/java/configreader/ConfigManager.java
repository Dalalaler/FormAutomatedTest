package configreader;

import java.io.IOException;
import java.util.HashMap;

public class ConfigManager {
    private static  ConfigManager instance;
    private static HashMap<String, String> props = new HashMap<>();

    public static ConfigManager getInstance() throws IOException {
        if (instance == null) {
            instance = new ConfigManager();
            PropertyReader properties = new PropertyReader();
            props = properties.getPropValues();
        }
        return instance;
    }

    public static HashMap<String, String> getProps() {
        return props;
    }

    public static String getProperty(String propertyName) throws IOException {
        String property = "";
        property = ConfigManager.getInstance().getProps().get(propertyName);

        return property;
    }
}
