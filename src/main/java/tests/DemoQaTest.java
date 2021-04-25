package tests;

import driverfactory.DriverFactory;
import enums.DriverNames;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.DemoQaPage;
import java.io.IOException;

public class DemoQaTest {
    private static WebDriver webDriver;

    @BeforeClass
    public static void openBrowser() throws IOException {
        System.out.println("Starting test.");
    }

    @Test
    public void startChromeTest() throws IOException {
        webDriver = DriverFactory.getDriver(DriverNames.CHROME);
        DemoQaPage demoQaPage = new DemoQaPage(webDriver);
        demoQaPage.startTest();
    }

    @Test
    public void startOperaTest() throws IOException {
        webDriver = DriverFactory.getDriver(DriverNames.OPERA);
        DemoQaPage demoQaPage = new DemoQaPage(webDriver);
        demoQaPage.startTest();
    }

    @Test
    public void startEdgeTest() throws IOException {
        webDriver = DriverFactory.getDriver(DriverNames.EDGE);
        DemoQaPage demoQaPage = new DemoQaPage(webDriver);
        demoQaPage.startTest();
    }

    @Test
    public void startFireFoxTest() throws IOException {
        webDriver = DriverFactory.getDriver(DriverNames.FIREFOX);
        DemoQaPage demoQaPage = new DemoQaPage(webDriver);
        demoQaPage.startTest();
    }

    @AfterClass
    public static void closeBrowser() throws InterruptedException {
        webDriver.quit();
    }
}
