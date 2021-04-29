package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class YouTubePage extends AbstractPage {

    public YouTubePage(WebDriver driver) {
        super(driver);
    }

    By playBtn = By.xpath(".//*[@id=\"movie_player\"]/div[33]/div[2]/div[1]/button");

    public void clickPlay() {
        driver.findElement(playBtn).click();
    }
}
