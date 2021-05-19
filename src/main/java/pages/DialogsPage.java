package pages;

import configreader.ConfigManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class DialogsPage extends AbstractPage {
    public DialogsPage(WebDriver driver) {
        super(driver);
    }

    private By smallModalBtn = By.id("showSmallModal");
    private By largeModalBtn = By.id("showLargeModal");
    private By closeSmallModal = By.id("closeSmallModal");
    private By closeLargeModal = By.id("closeLargeModal");
    private By smallModalText = By.xpath("//div[@class=\"modal-body\"]");
    private By largeModalText = By.xpath("//div[@class=\"modal-body\"]/p");


    public void clickSmallModal() {
        driver.findElement(smallModalBtn).click();
    }

    public void clickLargeModal() {
        driver.findElement(largeModalBtn).click();
    }

    public void closeSmallModal() {
        driver.findElement(closeSmallModal).click();
    }

    public void closeLargeModal() {
        driver.findElement(closeLargeModal).click();
    }

    public String getSmallModalText() {
        return driver.findElement(smallModalText).getText();
    }

    public String getLargeModalText() {
        return driver.findElement(largeModalText).getText();
    }

    @Override
    public void open() throws IOException {
        driver.get(ConfigManager.getProperty("dialogsUrl"));
    }

}
