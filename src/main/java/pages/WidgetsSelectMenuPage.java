package pages;

import configreader.ConfigManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class WidgetsSelectMenuPage extends AbstractPage {
    public WidgetsSelectMenuPage(WebDriver driver) {
        super(driver);
    }

    private By selectValueInput = By.xpath("//input[@id=\"react-select-2-input\"]");
    private By selectedValueInput = By.xpath("//div[@id=\"withOptGroup\"]//div[@class=\" css-1uccc91-singleValue\"]");
    private By selectOneInput = By.xpath("//input[@id=\"react-select-3-input\"]");
    private By selectedOneInput = By.xpath("//div[@id=\"selectOne\"]//div[@class=\" css-1uccc91-singleValue\"]");
    private By multiSelectDropDown = By.xpath("//input[@id=\"react-select-4-input\"]");
    private By multiSelectedValues = By.xpath("//div[@class=\"css-1rhbuit-multiValue\"]");
    private By oldSelectMenu = By.xpath("//select[@id=\"oldSelectMenu\"]");
    private By standardMultiSelect = By.xpath("//select[@id=\"cars\"]");

    public void enterSelectValueInput(String valueToSelect) {
        driver.findElement(selectValueInput).sendKeys(valueToSelect);
        driver.findElement(selectValueInput).sendKeys(Keys.ENTER);
    }

    public void enterSelectOneInput(String valueToSelect) {
        driver.findElement(selectOneInput).sendKeys(valueToSelect);
        driver.findElement(selectOneInput).sendKeys(Keys.ENTER);
    }

    public void enterOldSelect(String valueToSelect) {
        Select select = new Select(driver.findElement(oldSelectMenu));
        select.selectByVisibleText(valueToSelect);
    }

    public void enterMultiSelectDropDown(String valueToSelect) {
        driver.findElement(multiSelectDropDown).sendKeys(valueToSelect);
        driver.findElement(multiSelectDropDown).sendKeys(Keys.ENTER);
    }

    public void enterStandardMultiSelect(String valueToSelect) {
        Select select = new Select(driver.findElement(standardMultiSelect));
        select.selectByVisibleText(valueToSelect);
    }

    public String getSelectedValues() {
        return driver.findElement(selectedValueInput).getText();
    }

    public String getSelectedOneInput() {
        return driver.findElement(selectedOneInput).getText();
    }

    public String getOldStyleSelectedOption() {
        Select select = new Select(driver.findElement(oldSelectMenu));
        return select.getFirstSelectedOption().getText();
    }

    public List<String> getMultipleInputtedData() {
        List<String> inputtedColors = new ArrayList<>();
        List<WebElement> webElements = driver.findElements(multiSelectedValues);
        for (WebElement webElement : webElements) {
            inputtedColors.add(webElement.getText());
        }
        return inputtedColors;
    }

    public String getStandardSelectedOption() {
        Select select = new Select(driver.findElement(standardMultiSelect));
        return select.getFirstSelectedOption().getText();
    }

    @Override
    public void open() throws IOException {
        driver.get(ConfigManager.getProperty("widgetsSelectMenuUrl"));
    }
}
