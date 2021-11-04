package pages;

import configreader.ConfigManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class WidgetsProgressBarPage extends AbstractPage {
    public WidgetsProgressBarPage(WebDriver driver) {
        super(driver);
    }

    private By startButton = By.xpath("//button[@id=\"startStopButton\"]");
    private By resetButton = By.xpath("//button[@id=\"resetButton\"]");
    private By progressBar = By.xpath("//div[@role=\"progressbar\"]");
    private By progressBarValue = By.xpath("//div[@role=\"progressbar\"]");

    public void pressStartButton() {
        if (driver.findElement(startButton).isDisplayed()) {
            driver.findElement(startButton).click();
        }
    }

    public void pressResetButton() {
        if (driver.findElement(resetButton).isDisplayed()) {
            driver.findElement(resetButton).click();
        }
    }

    public int getProgressBarValue() {
        String progressValueString = driver.findElement(progressBar).getAttribute("aria-valuenow");
        return Integer.parseInt(progressValueString);
    }

    @Override
    public void open() throws IOException {
        driver.get(ConfigManager.getProperty("progressBarUrl"));
    }
}
