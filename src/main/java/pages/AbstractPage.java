package pages;

import org.openqa.selenium.WebDriver;

abstract public class AbstractPage {
    protected WebDriver driver;

    public AbstractPage(WebDriver driver) {
        this.driver = driver;
    }
}
