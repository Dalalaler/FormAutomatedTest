package tests;

import driverfactory.DriverFactory;
import enums.DriverNames;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import pages.*;

import java.io.IOException;

public abstract class BasicTest {
    protected static WebDriver driver;
    protected static AlertsPage alertsPage;
    protected static DashboardPage dashboardPage;
    protected static DialogsPage dialogsPage;
    protected static FormPage formPage;
    protected static FramesPages framesPages;
    protected static HomePage homePage;
    protected static LoginPage loginPage;
    protected static WindowPage windowPage;
    protected static UploadDownloadPage uploadDownloadPage;

    @BeforeAll
    static void testSetup() throws IOException {
        driver = DriverFactory.getDriver(DriverNames.CHROME);

        alertsPage = new AlertsPage(driver);
        dashboardPage = new DashboardPage(driver);
        dialogsPage = new DialogsPage(driver);
        formPage = new FormPage(driver);
        framesPages = new FramesPages(driver);
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        windowPage = new WindowPage(driver);
        uploadDownloadPage = new UploadDownloadPage(driver);

    }

    @AfterAll
    static void quitBrowser() {
        driver.quit();
    }
}
