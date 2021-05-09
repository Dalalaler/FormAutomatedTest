package pages;

import configreader.ConfigManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class WindowPage extends AbstractPage {
    public WindowPage(WebDriver driver) {
        super(driver);
    }

    private By newTabBtn = By.id("tabButton");
    private By newWindowBtn = By.id("windowButton");
    private By newWindowMessageBtn = By.id("messageWindowButton");
    private By sampleHeading = By.id("sampleHeading");
    private By bodyText = By.xpath(".//html/body/text()");

    public void pressNewTabBtn() {
        driver.findElement(newTabBtn).click();
    }

    public void pressWindowBtn() {
        driver.findElement(newWindowBtn).click();
    }

    public void pressWindowMessageBtn() {
        driver.findElement(newWindowMessageBtn).click();
    }

    public String getSampleHeading() {
       return driver.findElement(sampleHeading).getText();
    }

    @Override
    public void open() throws IOException {
        driver.get(ConfigManager.getProperty("windowsUrl"));
    }
}
