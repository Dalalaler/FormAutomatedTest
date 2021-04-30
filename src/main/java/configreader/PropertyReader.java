package configreader;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;

public class PropertyReader {
    private HashMap<String, String> propsResult = new HashMap<>();
    private FileInputStream inputStream;

    public HashMap<String, String> getPropValues() throws IOException {

        try {
            Properties prop = new Properties();
            inputStream = new FileInputStream("src/main/resources/config.properties");

            if (inputStream != null) {
                prop.load(inputStream);
            } else {
                throw new FileNotFoundException("property file not found in the directory");
            }

            propsResult.put("rickrollUrl", prop.getProperty("rickrollUrl"));
            propsResult.put("demoQaUrl", prop.getProperty("demoQaUrl"));
            propsResult.put("chromeDriverWindowsLocation", prop.getProperty("chromeDriverWindowsLocation"));
            propsResult.put("edgeDriverWindowsLocation", prop.getProperty("edgeDriverWindowsLocation"));
            propsResult.put("firefoxDriverWindowsLocation", prop.getProperty("firefoxDriverWindowsLocation"));
            propsResult.put("operaDriverWindowsLocation", prop.getProperty("operaDriverWindowsLocation"));
            propsResult.put("chromeDriverProperty", prop.getProperty("chromeDriverProperty"));
            propsResult.put("edgeDriverProperty", prop.getProperty("edgeDriverProperty"));
            propsResult.put("firefoxDriverProperty", prop.getProperty("firefoxDriverProperty"));
            propsResult.put("operaDriverProperty", prop.getProperty("operaDriverProperty"));
            propsResult.put("demoQaLogin", prop.getProperty("demoQaLogin"));
            propsResult.put("demoQaPassword", prop.getProperty("demoQaPassword"));

        } catch (Exception e) {
            System.out.println("Exception: " + e);
        } finally {
            inputStream.close();
        }
        return propsResult;
    }

}
