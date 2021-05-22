package pages;

import configreader.ConfigManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.io.IOException;

public class DroppablePage extends AbstractPage {
    public DroppablePage(WebDriver driver) {
        super(driver);
    }

    private By simpleButton = By.xpath("//a[@id=\"droppableExample-tab-simple\"]");
    private By simpleDraggable = By.xpath("//div[@id=\"draggable\"]");
    private By simpleDroppable = By.xpath("//div[@id=\"simpleDropContainer\"]//div[@id=\"droppable\"]");

    private By acceptButton = By.xpath("//a[@id=\"droppableExample-tab-accept\"]");
    private By acceptDraggable = By.xpath("//div[@id=\"acceptable\"]");
    private By acceptDroppable = By.xpath("//div[@id=\"droppableExample-tabpane-accept\"]//div[@id=\"droppable\"]");

    private By preventPropogationButton = By.xpath("//a[@id=\"droppableExample-tab-preventPropogation\"]");
    private By propogationDraggable = By.xpath("//div[@id=\"dragBox\"]");
    private By firstOuterDroppable = By.xpath("//div[@id=\"notGreedyDropBox\"]");
    private By secondInnerDroppable = By.xpath("//div[@id=\"greedyDropBoxInner\"]");

    private By revertDraggableButton = By.xpath("//a[@id=\"droppableExample-tab-revertable\"]");
    private By revertDraggable = By.xpath("//div[@id=\"revertable\"]");
    private By revertDroppable = By.xpath("//div[@class=\"revertable-drop-container\"]//div[@id=\"droppable\"]");

    public void pressSimpleButton() {
        driver.findElement(simpleButton).click();
    }

    public void dropSimpleDraggableToSimpleDroppable() {
        Actions dropper = new Actions(driver);
        WebElement from = driver.findElement(simpleDraggable);
        WebElement to = driver.findElement(simpleDroppable);
        dropper.dragAndDrop(from, to).perform();
    }

    public String getSimpleDroppableColor() {
        return driver.findElement(simpleDroppable).getCssValue("background-color");
    }

    public String getSimpleDroppableText() {
        return driver.findElement(simpleDroppable).getText();
    }

    public void pressAcceptButton() {
        driver.findElement(acceptButton).click();
    }

    public void dropAcceptDraggableToSimpleDroppable() {
        Actions dropper = new Actions(driver);
        WebElement from = driver.findElement(acceptDraggable);
        WebElement to = driver.findElement(acceptDroppable);
        dropper.dragAndDrop(from, to).perform();
    }

    public String getAcceptDroppableColor() {
        return driver.findElement(acceptDroppable).getCssValue("background-color");
    }

    public String getAcceptDroppableText() {
        return driver.findElement(acceptDroppable).getText();
    }

    public void pressPreventPropogationButton() {
        driver.findElement(preventPropogationButton).click();
    }

    public void dropPreventPropogationDraggableToFirstDroppable() {
        Actions dropper = new Actions(driver);
        WebElement from = driver.findElement(propogationDraggable);
        WebElement to = driver.findElement(firstOuterDroppable);
        dropper.dragAndDrop(from, to).perform();
    }

    public void dropPreventPropogationDraggableToSecondDroppable() {
        Actions dropper = new Actions(driver);
        WebElement from = driver.findElement(propogationDraggable);
        WebElement to = driver.findElement(secondInnerDroppable);
        dropper.dragAndDrop(from, to).perform();
    }

    public String getFirstOuterDroppableText() {
        return driver.findElement(firstOuterDroppable).getText();
    }

    public String getFirstOuterDroppableColor() {
        return driver.findElement(firstOuterDroppable).getCssValue("background-color");
    }

    public String getSecondInnerDroppableText() {
        return driver.findElement(secondInnerDroppable).getText();
    }

    public String getSecondInnerDroppableColor() {
        return driver.findElement(secondInnerDroppable).getCssValue("background-color");
    }

    public void pressRevertDraggableButton() {
        driver.findElement(revertDraggableButton).click();
    }

    public void dropRevertDraggable() {
        Actions dropper = new Actions(driver);
        WebElement from = driver.findElement(revertDraggable);
        WebElement to = driver.findElement(revertDroppable);
        dropper.dragAndDrop(from, to).perform();
    }

    public String getRevertDroppableText() {
        return driver.findElement(revertDroppable).getText();
    }

    public String getRevertDroppableColor() {
        return driver.findElement(revertDroppable).getCssValue("background-color");
    }

    @Override
    public void open() throws IOException {
        driver.get(ConfigManager.getProperty("droppableUrl"));
    }
}
