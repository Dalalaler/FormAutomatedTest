package pages;

import org.openqa.selenium.WebDriver;

import java.io.IOException;

abstract public class AbstractPage {
    protected WebDriver driver;

    public AbstractPage(WebDriver driver) {
        this.driver = driver;
    }

    public void startTest() throws IOException {

    }
}
