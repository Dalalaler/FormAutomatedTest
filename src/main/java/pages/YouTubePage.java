package pages;

import configreader.ConfigManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class YouTubePage extends AbstractPage {

    public YouTubePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void startTest() throws IOException {
        driver.get(ConfigManager.getInstance().getProps().get("baseUrl"));
        driver.manage().window().maximize();
        driver.findElement(By.xpath(".//*[@id=\"movie_player\"]/div[33]/div[2]/div[1]/button")).click();
    }
}
