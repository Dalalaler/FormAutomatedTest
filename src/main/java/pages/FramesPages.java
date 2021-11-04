package pages;

import configreader.ConfigManager;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class FramesPages extends AbstractPage {
    public FramesPages(WebDriver driver) {
        super(driver);
    }

    @Override
    public void open() throws IOException {
        driver.get(ConfigManager.getProperty("framesUrl"));
    }
}
