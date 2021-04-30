package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPage extends AbstractPage {

    public DashboardPage(WebDriver webDriver) {
        super(webDriver);
    }

    By heading = By.xpath("//div[@class=\"main-header\"]");
    By logoutBtn = By.id("submit");

    public String getHeadingText() {
        String head = driver.findElement(heading).getText();
        return head;
    }

    public void clickLogout() {
        driver.findElement(logoutBtn).click();
    }
}
