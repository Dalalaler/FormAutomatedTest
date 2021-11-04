package tests;

import configreader.ConfigManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.ui.FluentWait;
import pages.WidgetsProgressBarPage;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WidgetsProgressBarTest extends BasicTest {
    private String hundredPercentsError = "Percent's value is not 100%";
    private String zeroPercentsError = "Percent's value is not 0%";

    @BeforeEach
    public void pagePreparation() throws IOException {
        widgetsProgressBarPage = new WidgetsProgressBarPage(driver);
        widgetsProgressBarPage.open();
    }

    @Test
    public void hundredPercentsTest() throws IOException {
        widgetsProgressBarPage.pressStartButton();
        waitForHundredPercents();
        assertEquals(widgetsProgressBarPage.getProgressBarValue(), 100, hundredPercentsError);
    }

    @Test
    public void resetTest() throws IOException {
        hundredPercentsTest();
        widgetsProgressBarPage.pressResetButton();
        assertEquals(widgetsProgressBarPage.getProgressBarValue(), 0, zeroPercentsError);
    }


    public void waitForHundredPercents() throws IOException {
        int timeOut = Integer.parseInt(ConfigManager.getProperty("progressBarPercentWait"));
        int poolingTime = Integer.parseInt(ConfigManager.getProperty("progressBarPercentPoolWait"));
        FluentWait wait = new FluentWait(driver)
                .withTimeout(timeOut, TimeUnit.SECONDS)
                .pollingEvery(poolingTime, TimeUnit.SECONDS);
        wait.until((webDriver) -> widgetsProgressBarPage.getProgressBarValue() >= 100);
    }
}
