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
    protected static DialogsPage dialogsPage;
    protected static FormPage formPage;
    protected static FramesPages framesPages;
    protected static WindowPage windowPage;
    protected static UploadDownloadPage uploadDownloadPage;
    protected static WidgetsAccordianPage widgetsAccordianPage;
    protected static WidgetsAutoCompletePage widgetsAutoCompletePage;
    protected static WidgetsDatePickerPage widgetsDatePickerPage;
    protected static WidgetsMenuPage widgetsMenuPage;
    protected static WidgetsProgressBarPage widgetsProgressBarPage;
    protected static WidgetsSelectMenuPage widgetsSelectMenuPage;
    protected static SortablePage sortablePage;
    protected static DroppablePage droppablePage;

    @BeforeAll
    static void testSetup() throws IOException {
        driver = DriverFactory.getDriver(DriverNames.CHROME);
    }

    @AfterAll
    static void quitBrowser() {
        driver.quit();
    }
}
