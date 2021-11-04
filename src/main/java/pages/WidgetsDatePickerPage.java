package pages;

import configreader.ConfigManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class WidgetsDatePickerPage extends AbstractPage {
    public WidgetsDatePickerPage(WebDriver driver) {
        super(driver);
    }

    private By monthAndYearInput = By.xpath("//input[@id=\"datePickerMonthYearInput\"]");
    private By dateAndTimeInput = By.xpath("//input[@id=\"dateAndTimePickerInput\"]");

    public void enterMonthAndYear(String dataToInput) {
        driver.findElement(monthAndYearInput).click();
        driver.findElement(monthAndYearInput).sendKeys(Keys.CONTROL + "a");
        driver.findElement(monthAndYearInput).sendKeys(Keys.DELETE);
        driver.findElement(monthAndYearInput).sendKeys(dataToInput);
    }

    public String getMonthAndYear() {
        return driver.findElement(monthAndYearInput).getAttribute("value");
    }

    public void enterDateAndTime(String dataToInput) {
        driver.findElement(dateAndTimeInput).click();
        driver.findElement(dateAndTimeInput).sendKeys(Keys.CONTROL + "a");
        driver.findElement(dateAndTimeInput).sendKeys(Keys.DELETE);
        driver.findElement(dateAndTimeInput).sendKeys(dataToInput);
    }

    public String getDateAndTime() {
        return driver.findElement(dateAndTimeInput).getAttribute("value");
    }

    @Override
    public void open() throws IOException {
        driver.get(ConfigManager.getProperty("dataPickerUrl"));
    }
}
