package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends AbstractPage {

    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }

    By uName = By.id("userName");

    By pswd = By.id("password");

    By loginBtn = By.id("login");

    public void enterUsername(String user) {
        driver.findElement(uName).sendKeys(user);
    }

    public void enterPassword(String pass) {
        driver.findElement(pswd).sendKeys(pass);
    }

    public void clickLogin() {
        driver.findElement(loginBtn).click();
    }
}
