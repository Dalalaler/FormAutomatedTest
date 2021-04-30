package tests;

import configreader.ConfigManager;
import driverfactory.DriverFactory;
import enums.DriverNames;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.YouTubePage;

import java.io.IOException;

public class YouTubeTest {
    private static WebDriver driver;
    private static YouTubePage youTubePage;

    @BeforeClass
    public static void openBrowser() throws IOException {
        driver = DriverFactory.getDriver(DriverNames.CHROME);
        youTubePage = new YouTubePage(driver);
    }

    @AfterClass
    public static void closeBrowser() {
        driver.quit();
    }

    @Test
    public void rickrollTest() throws IOException {
        driver.get(ConfigManager.getProperty("rickrollUrl"));
        youTubePage.clickPlay();
    }
}
