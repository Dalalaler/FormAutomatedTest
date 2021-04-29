package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends AbstractPage {

    public HomePage(WebDriver webDriver){
        super(webDriver);
    }

    By LoginBtn = By.id("login");

    public void clickLogin() {
        driver.findElement(LoginBtn).click();
    }
}
