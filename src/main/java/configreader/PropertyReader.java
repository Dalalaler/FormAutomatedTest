package configreader;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;

public class PropertyReader {
    private HashMap<String, String> propsResult = new HashMap<>();
    private FileInputStream inputStream;
    private Properties prop;
    private String configFileRelativePath = "src/main/resources/config.properties";

    public HashMap<String, String> getPropValues() throws IOException {

        try {
            prop = new Properties();
            inputStream = new FileInputStream(configFileRelativePath);

            if (inputStream != null) {
                prop.load(inputStream);
            } else {
                throw new FileNotFoundException("property file not found in the directory");
            }

            putProperty("rickrollUrl");
            putProperty("demoQaUrl");
            putProperty("chromeDriverWindowsLocation");
            putProperty("edgeDriverWindowsLocation");
            putProperty("operaDriverWindowsLocation");
            putProperty("chromeDriverProperty");
            putProperty("edgeDriverProperty");
            putProperty("firefoxDriverProperty");
            putProperty("operaDriverProperty");
            putProperty("demoQaLogin");
            putProperty("demoQaPassword");
            putProperty("loginUrl");
            putProperty("formUrl");
            putProperty("windowsUrl");
            putProperty("alertsUrl");
            putProperty("framesUrl");
            putProperty("dialogsUrl");
            putProperty("loadUrl");
            putProperty("downloadPath");
            putProperty("implicitlyWait");
            putProperty("dialogTestWebDriverWait");
            putProperty("picturesPath");
            putProperty("downloadTestWebDriverWait");
            putProperty("pictureDownloadWait");
            putProperty("alertsTestWebDriverWait");

        } catch (Exception e) {
            System.out.println("Exception: " + e);
        } finally {
            inputStream.close();
        }
        return propsResult;
    }

    public void putProperty(String property) {
        propsResult.put(property, prop.getProperty(property));
    }

}
