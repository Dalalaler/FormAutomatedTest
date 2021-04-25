package driverfactory;

import configreader.ConfigManager;
import configreader.GetPropertyValues;
import enums.DriverNames;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;

import java.io.IOException;
import java.util.HashMap;

public class DriverFactory {
    public static WebDriver getDriver(DriverNames driverName) throws IOException {

        HashMap<String, String> props = ConfigManager.getInstance().getProps();
        WebDriver webDriver;

        switch (driverName) {
            case EDGE:
                System.setProperty(props.get("edgeDriverProperty"), props.get("edgeDriverWindowsLocation"));
                webDriver = new EdgeDriver();
                break;
            case OPERA:
                System.setProperty(props.get("operaDriverProperty"), props.get("operaDriverWindowsLocation"));
                webDriver = new OperaDriver();
                break;

            case CHROME:
                System.setProperty(props.get("chromeDriverProperty"), props.get("chromeDriverWindowsLocation"));
                webDriver = new ChromeDriver();
                break;
            case FIREFOX:
                System.setProperty(props.get("firefoxDriverProperty"), props.get("firefoxDriverWindowsLocation"));
                webDriver = new FirefoxDriver();
                break;

            default:
                throw new IllegalStateException("Unexpected value: " + driverName);
        }
        return webDriver;
    }
}
