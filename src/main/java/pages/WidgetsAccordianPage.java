package pages;

import configreader.ConfigManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.FluentWait;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class WidgetsAccordianPage extends AbstractPage {
    public WidgetsAccordianPage(WebDriver driver) {
        super(driver);
    }

    private By firstSectionClick = By.xpath("//*[.=\"What is Lorem Ipsum?\"]");
    private By secondSectionClick = By.xpath("//*[.=\"Where does it come from?\"]");
    private By thirdSectionClick = By.xpath("//*[.=\"Why do we use it?\"]");


    private By firstSectionText = By.xpath("//div[@id=\"section1Content\"]/p");
    private By secondSectionText = By.xpath("//div[@id=\"section2Content\"]/p");
    private By thirdSectionText = By.xpath("//div[@id=\"section3Content\"]/p");

    public void openFirstSection() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click()", driver.findElement(firstSectionClick));
    }

    public void openSecondSection() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click()", driver.findElement(secondSectionClick));
    }

    public void openThirdSection() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click()", driver.findElement(thirdSectionClick));
    }

    public String getFirstSectionText() throws IOException {
        waitForTextToAppear(firstSectionText);
        return driver.findElement(firstSectionText).getText();
    }

    public String getSecondSectionText() throws IOException {
        waitForTextToAppear(secondSectionText);
        return driver.findElement(secondSectionText).getText();
    }

    public String getThirdSectionText() throws IOException {
        waitForTextToAppear(thirdSectionText);
        return driver.findElement(thirdSectionText).getText();
    }

    public void waitForTextToAppear(By textElement) throws IOException {
        int timeOut = Integer.parseInt(ConfigManager.getProperty("accordianPageTextWait"));
        int poolingTime = Integer.parseInt(ConfigManager.getProperty("accordianPageTextPoolWait"));
        FluentWait wait = new FluentWait(driver)
                .withTimeout(timeOut, TimeUnit.SECONDS)
                .pollingEvery(poolingTime, TimeUnit.SECONDS);
        wait.until((webDriver) -> driver.findElement(textElement).getText().length() > 0);
    }


    @Override
    public void open() throws IOException {
        driver.get(ConfigManager.getProperty("accordianUrl"));
    }
}
