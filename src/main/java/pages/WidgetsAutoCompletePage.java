package pages;

import configreader.ConfigManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class WidgetsAutoCompletePage extends AbstractPage {
    public WidgetsAutoCompletePage(WebDriver driver) {
        super(driver);
    }

    private By multipleInput = By.xpath("//input[@id=\"autoCompleteMultipleInput\"]");
    private By singleInput = By.xpath("//input[@id=\"autoCompleteSingleInput\"]");
    private By multipleInputtedField = By.xpath("//div[@class=\"css-1rhbuit-multiValue auto-complete__multi-value\"]");
    private By singleInputtedField = By.xpath("//div[@class=\"auto-complete__single-value css-1uccc91-singleValue\"]");
    private String deleteInputtedField = "//*[.=\"%s\"]//following-sibling::div";

    public void enterMultipleInputData(String data) {
        driver.findElement(multipleInput).sendKeys(data);
        driver.findElement(multipleInput).sendKeys(Keys.ENTER);
    }

    public void enterSingleInputData(String data) {
        driver.findElement(singleInput).sendKeys(data);
        driver.findElement(singleInput).sendKeys(Keys.ENTER);
    }

    public List<String> getMultipleInputtedData() {
        List<String> inputtedColors = new ArrayList<>();
        List<WebElement> webElements = driver.findElements(multipleInputtedField);
        for (WebElement webElement : webElements) {
            inputtedColors.add(webElement.getText());
        }
        return inputtedColors;
    }

    public void deleteSelectedColor(String colorToDelete) {
        driver.findElement(By.xpath(String.format(deleteInputtedField, colorToDelete))).click();
    }

    public String getSingleInputtedData() {
        return driver.findElement(singleInputtedField).getText();
    }

    

    @Override
    public void open() throws IOException {
        driver.get(ConfigManager.getProperty("autoCompleteUrl"));
    }
}
