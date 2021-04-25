package tests;

import driverfactory.DriverFactory;
import enums.DriverNames;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.YouTubePage;
import java.io.IOException;

public class YouTubeTest {
    private static WebDriver webDriver;


    @BeforeClass
    public static void openBrowser() throws IOException {
        System.out.println("Starting test.");
    }

    @Test
    public void startChromeTest() throws IOException {
        webDriver = DriverFactory.getDriver(DriverNames.CHROME);
        YouTubePage youTubePage = new YouTubePage(webDriver);
        youTubePage.startTest();
    }

    @Test
    public void startOperaTest() throws IOException {
        webDriver = DriverFactory.getDriver(DriverNames.OPERA);
        YouTubePage youTubePage = new YouTubePage(webDriver);
        youTubePage.startTest();
    }

    @Test
    public void startEdgeTest() throws IOException {
        webDriver = DriverFactory.getDriver(DriverNames.EDGE);
        YouTubePage youTubePage = new YouTubePage(webDriver);
        youTubePage.startTest();
    }

    @Test
    public void startFireFoxTest() throws IOException {
        webDriver = DriverFactory.getDriver(DriverNames.FIREFOX);
        YouTubePage youTubePage = new YouTubePage(webDriver);
        youTubePage.startTest();
    }

    @AfterClass
    public static void closeBrowser() throws InterruptedException {
        Thread.sleep(10000);
        webDriver.quit();
    }
}
