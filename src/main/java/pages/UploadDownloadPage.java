package pages;

import configreader.ConfigManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class UploadDownloadPage extends AbstractPage {
    public UploadDownloadPage(WebDriver driver) {
        super(driver);
    }

    private By downloadButton = By.id("downloadButton");
    private By uploadFile = By.id("uploadFile");
    private By uploadedFilePath = By.id("uploadedFilePath");

    public void uploadPicture(String filePath) {
        driver.findElement(uploadFile).sendKeys(filePath);
    }

    public String getUploadedPicturePath() {
        return driver.findElement(uploadedFilePath).getText();
    }

    public void clickDownload() {
        driver.findElement(downloadButton).click();
    }

    @Override
    public void open() throws IOException {
        driver.get(ConfigManager.getProperty("loadUrl"));
    }


}
