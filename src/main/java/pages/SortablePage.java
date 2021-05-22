package pages;

import configreader.ConfigManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.io.IOException;

public class SortablePage extends AbstractPage {
    public SortablePage(WebDriver driver) {
        super(driver);
    }

    private By listButton = By.xpath("//a[@id=\"demo-tab-list\"]");
    private By gridButton = By.xpath("//a[@id=\"demo-tab-grid\"]");
    private String droppableListElementByName =
            "//div[@class=\"vertical-list-container mt-4\"]//div[@class=\"list-group-item list-group-item-action\"][.=\"%s\"]";
    private String droppableListElementByIndex =
            "//div[@class=\"vertical-list-container mt-4\"]//div[@class=\"list-group-item list-group-item-action\"][%d]";

    private String droppableGridElementByName = "//div[@class=\"create-grid\"]/div[.=\"%s\"]";
    private String droppableGridElementByIndex = "//div[@class=\"create-grid\"]/div[%d]";

    public void pressListButton() {
        driver.findElement(listButton).click();
    }

    public void pressGridButton() {
        driver.findElement(gridButton).click();
    }

    public String getListElementNameByIndex(int elementIndex) {
        WebElement elementByIndex = driver.findElement(By.xpath(String.format(droppableListElementByIndex, elementIndex)));
        return elementByIndex.getText();
    }

    public void dropListElementToPosition(String elementName, int toPosition) {
        Actions dropper = new Actions(driver);
        WebElement from = driver.findElement(By.xpath(String.format(droppableListElementByName, elementName)));
        WebElement to = driver.findElement(By.xpath(String.format(droppableListElementByIndex, toPosition)));
        dropper.dragAndDrop(from, to).perform();
    }

    public String getGridElementNameByIndex(int elementIndex) {
        WebElement elementByIndex = driver.findElement(By.xpath(String.format(droppableGridElementByIndex, elementIndex)));
        return elementByIndex.getText();
    }

    public void dropGridElementToPosition(String elementName, int toPosition) {
        Actions dropper = new Actions(driver);
        WebElement from = driver.findElement(By.xpath(String.format(droppableGridElementByName, elementName)));
        WebElement to = driver.findElement(By.xpath(String.format(droppableGridElementByIndex, toPosition)));
        dropper.dragAndDrop(from, to).perform();
    }

    @Override
    public void open() throws IOException {
        driver.get(ConfigManager.getProperty("sortableUrl"));
    }
}
