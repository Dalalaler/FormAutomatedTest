package tests;

import configreader.ConfigManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.AlertsPage;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class AlertsTest extends BasicTest {
    private boolean simpleAlertWasOpened = false;
    private boolean timerAlertWasOpened = false;
    private boolean acceptAlertWasOpened = false;
    private boolean acceptPromtAlertWasOpened = false;

    @BeforeEach
    public void pagePreparation() throws IOException {
        alertsPage = new AlertsPage(driver);
        alertsPage.open();
    }

    @Test
    public void simpleAlertTest() {
        alertsPage.pressAlertButton();
        simpleAlertWasOpened = alertsPage.acceptAlert();
        assertTrue(simpleAlertWasOpened, "Simple alert wasn't opened");
    }

    @Test
    public void timerAlertTest() throws IOException {
        alertsPage.pressTimerAlertButton();
        WebDriverWait wait = new WebDriverWait(driver, Integer.parseInt(ConfigManager.getProperty("alertsTestWebDriverWait")));
        wait.until(ExpectedConditions.alertIsPresent());
        timerAlertWasOpened = alertsPage.acceptAlert();
        assertTrue(timerAlertWasOpened, "Timer alert wasn't opened");
    }

    @Test
    public void acceptAlertTest() {
        alertsPage.pressConfirmButton();
        acceptAlertWasOpened = alertsPage.acceptAlert();
        assertTrue(acceptAlertWasOpened, "Accept alert wasn't opened");
    }

    @Test
    public void acceptPromtAlertTest() {
        alertsPage.pressPromtButton();
        acceptPromtAlertWasOpened = alertsPage.acceptPromtAlert("Simple text");
        assertTrue(acceptPromtAlertWasOpened, "Accept promt alert wasn't opened");
    }
}
