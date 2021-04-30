package tests;

import configreader.ConfigManager;
import driverfactory.DriverFactory;
import enums.DriverNames;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.DashboardPage;
import pages.HomePage;
import pages.LoginPage;

import java.io.IOException;

public class LoginTest {
    private static WebDriver driver;
    private static HomePage home;
    private static LoginPage login;
    private static DashboardPage dashboardPage;

    @BeforeClass
    public static void openBrowser() throws IOException {
        driver = DriverFactory.getDriver(DriverNames.CHROME);
        home = new HomePage(driver);
        login = new LoginPage(driver);
        dashboardPage = new DashboardPage(driver);
    }

    @AfterClass
    public static void closeBrowser() {
        driver.quit();
    }


    @Test
    public void loginTest() throws IOException {
        driver.get(ConfigManager.getProperty("demoQaUrl"));
        home.clickLogin();

        login.enterUsername(ConfigManager.getProperty("demoQaLogin"));
        login.enterPassword(ConfigManager.getProperty("demoQaPassword"));
        login.clickLogin();

        dashboardPage.clickLogout();
    }
}
