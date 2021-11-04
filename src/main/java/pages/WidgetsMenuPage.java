package pages;

import configreader.ConfigManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import java.io.IOException;

public class WidgetsMenuPage extends AbstractPage {
    public WidgetsMenuPage(WebDriver driver) {
        super(driver);
    }

    private By subSubItem2 = By.xpath("//ul[@id=\"nav\"]//a[.=\"Main Item 2\"]/following-sibling::ul//a[.=\"Sub Sub Item 2\"]");
    private By subSubList = By.xpath("//ul[@id=\"nav\"]//a[.=\"SUB SUB LIST »\"]");
    private By mainItem2 = By.xpath("//ul[@id=\"nav\"]//a[.=\"Main Item 2\"]");
    Actions actions = new Actions(driver);

    public void moveToMainItem2() {
        actions.moveToElement(driver.findElement(mainItem2)).perform();
    }

    public void moveToSubSubList() {
        actions.moveToElement(driver.findElement(subSubList)).perform();
    }

    public void moveToSubSubItem2() {
        actions.moveToElement(driver.findElement(subSubItem2)).perform();
    }

    public boolean checkAndClickSubSubItem2() {
        if (driver.findElement(subSubItem2).isDisplayed() && driver.findElement(subSubItem2).isEnabled()) {
            driver.findElement(subSubItem2).click();
            return true;
        }
        return false;
    }

    @Override
    public void open() throws IOException {
        driver.get(ConfigManager.getProperty("widgetsMenuUrl"));
    }
}
