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
import java.util.concurrent.TimeUnit;

public class YouTubeTest {
    private static WebDriver driver;
    private static YouTubePage youTubePage;

    @BeforeClass
    public static void openBrowser() throws IOException {
        driver = DriverFactory.getDriver(DriverNames.CHROME);
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        youTubePage = new YouTubePage(driver);
    }

    @AfterClass
    public static void closeBrowser() {
        driver.quit();
    }

    @Test
    public void loginTest() throws IOException, InterruptedException {
        driver.get(ConfigManager.getInstance().getProps().get("rickrollUrl"));
        youTubePage.clickPlay();
    }

}
