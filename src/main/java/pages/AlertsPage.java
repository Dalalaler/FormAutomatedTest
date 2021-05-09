package pages;

import configreader.ConfigManager;
import org.openqa.selenium.*;

import java.io.IOException;

public class AlertsPage extends AbstractPage {

    public AlertsPage(WebDriver driver) {
        super(driver);
    }

    private By alertButton = By.id("alertButton");
    private By timerAlertButton = By.id("timerAlertButton");
    private By confirmButton = By.id("confirmButton");
    private By promtButton = By.id("promtButton");

    public void pressAlertButton() {
        driver.findElement(alertButton).click();
    }

    public void pressTimerAlertButton() {
        driver.findElement(timerAlertButton).click();
    }

    public void pressConfirmButton() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click()", driver.findElement(confirmButton));
    }

    public void pressPromtButton() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click()", driver.findElement(promtButton));
    }

    public void acceptAlert() {
        Alert simpleAlert = driver.switchTo().alert();
        simpleAlert.accept();
    }

    public void acceptPromtAlert(String alertText){
        Alert promtAlert = driver.switchTo().alert();
        promtAlert.sendKeys(alertText);
        promtAlert.accept();
    }

    @Override
    public void open() throws IOException {
        driver.get(ConfigManager.getProperty("alertsUrl"));
    }
}
