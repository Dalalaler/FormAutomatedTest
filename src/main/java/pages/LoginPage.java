package pages;

import configreader.ConfigManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class LoginPage extends AbstractPage {

    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }

    private By uName = By.id("userName");
    private By pswd = By.id("password");
    private By loginBtn = By.id("login");


    public void enterUsername(String user) {
        driver.findElement(uName).sendKeys(user);
    }

    public void enterPassword(String pass) {
        driver.findElement(pswd).sendKeys(pass);
    }

    public void clickLogin() {
        driver.findElement(loginBtn).click();
    }

    @Override
    public void open() throws IOException {
        driver.get(ConfigManager.getProperty("loginUrl"));
    }
}
