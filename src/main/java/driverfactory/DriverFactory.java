package driverfactory;

import configreader.ConfigManager;
import enums.DriverNames;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class DriverFactory {
    public static WebDriver getDriver(DriverNames driverName) throws IOException {
        WebDriver webDriver;

        switch (driverName) {
            case EDGE:
                System.setProperty(ConfigManager.getProperty("edgeDriverProperty"), ConfigManager.getProperty("edgeDriverWindowsLocation"));
                webDriver = new EdgeDriver();
                break;
            case OPERA:
                System.setProperty(ConfigManager.getProperty("operaDriverProperty"), ConfigManager.getProperty("operaDriverWindowsLocation"));
                webDriver = new OperaDriver();
                break;

            case CHROME:
                System.setProperty(ConfigManager.getProperty("chromeDriverProperty"), ConfigManager.getProperty("chromeDriverWindowsLocation"));
                webDriver = new ChromeDriver();
                break;
            case FIREFOX:
                System.setProperty(ConfigManager.getProperty("firefoxDriverProperty"), ConfigManager.getProperty("firefoxDriverWindowsLocation"));
                webDriver = new FirefoxDriver();
                break;

            default:
                throw new IllegalStateException("Unexpected value: " + driverName);
        }
        webDriver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        return webDriver;
    }
}
