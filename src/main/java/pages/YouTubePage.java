package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class YouTubePage extends AbstractPage {

    public YouTubePage(WebDriver driver) {
        super(driver);
    }

    By playBtn = By.xpath(".//button[@class='ytp-play-button ytp-button']");

    public void clickPlay() {
        driver.findElement(playBtn).click();
    }
}
