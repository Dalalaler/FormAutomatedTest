package tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;

public class AlertsTest extends BasicTest {
    @BeforeEach
    public void pagePreparation() throws IOException {
        alertsPage.open();
    }

    @Test
    public void simpleAlertTest() {
        alertsPage.pressAlertButton();
        alertsPage.acceptAlert();
    }

    @Test
    public void timerAlertTest() {
        alertsPage.pressTimerAlertButton();
        WebDriverWait wait = new WebDriverWait(driver, 6);
        wait.until(ExpectedConditions.alertIsPresent());
        alertsPage.acceptAlert();
    }

    @Test
    public void acceptAlertTest() {
        alertsPage.pressConfirmButton();
        alertsPage.acceptAlert();
    }

    @Test
    public void acceptPromtAlertTest() {
        alertsPage.pressPromtButton();
        alertsPage.acceptPromtAlert("Simple text");
    }
}
