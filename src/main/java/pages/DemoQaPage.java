package pages;

import configreader.ConfigManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;

public class DemoQaPage extends AbstractPage {
    public DemoQaPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void startTest() throws IOException {
        driver.get(ConfigManager.getInstance().getProps().get("demoQaUrl"));
        driver.manage().window().maximize();
        String title = driver.getTitle();
        System.out.println("The page title is : " +title);
        WebElement uName = driver.findElement(By.xpath("//*[@id='userName']"));
        WebElement pswd = driver.findElement(By.xpath("//*[@id='password']"));
        WebElement loginBtn = driver.findElement(By.xpath("//*[@id='login']"));

        uName.sendKeys("testuser");
        pswd.sendKeys("Password@123");
        loginBtn.click();

        try {

            WebElement logoutBtn = driver.findElement(By.xpath("//div[@class='text-right col-md-5 col-sm-12']//button[@id='submit']"));

            if(logoutBtn.isDisplayed()){
                logoutBtn.click();
                System.out.println("LogOut Successful!");
            }
        }
        catch (Exception e) {
            System.out.println("Incorrect login....");
        }
    }
}
