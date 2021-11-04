package pages;

import configreader.ConfigManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class HomePage extends AbstractPage {


    public HomePage(WebDriver webDriver){
        super(webDriver);
    }

    By LoginBtn = By.id("login");

    public void clickLogin() {
        driver.findElement(LoginBtn).click();
    }

    @Override
    public void open() throws IOException {
        driver.get(ConfigManager.getProperty("demoQaUrl"));
    }
}
