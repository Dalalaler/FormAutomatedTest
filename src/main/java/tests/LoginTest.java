package tests;

import configreader.ConfigManager;
import driverfactory.DriverFactory;
import enums.DriverNames;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.Dashboard;
import pages.HomePage;
import pages.LoginPage;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class LoginTest {
    private static WebDriver driver;
    private static HomePage home;
    private static LoginPage login;
    private static Dashboard dashboard;

    @BeforeClass
    public static void openBrowser() throws IOException {
        driver = DriverFactory.getDriver(DriverNames.CHROME);
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        home = new HomePage(driver);
        login = new LoginPage(driver);
        dashboard = new Dashboard(driver);
    }

    @AfterClass
    public static void closeBrowser() {
        driver.quit();
    }


    @Test
    public void loginTest() throws IOException {
        driver.get(ConfigManager.getInstance().getProps().get("demoQaUrl"));
        home.clickLogin();

        login.enterUsername(ConfigManager.getInstance().getProps().get("demoQaLogin"));
        login.enterPassword(ConfigManager.getInstance().getProps().get("demoQaPassword"));
        login.clickLogin();

        dashboard.clickLogout();
    }
}
