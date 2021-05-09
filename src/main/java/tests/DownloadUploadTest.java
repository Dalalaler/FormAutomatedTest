package tests;

import configreader.ConfigManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;

public class DownloadUploadTest extends BasicTest {
    private String picturePath = "D:\\java\\projects\\FormAutomatedTest\\src\\main\\resources\\kfc_fighter.jpg";

    @BeforeEach
    public void pagePreparation() throws IOException {
        uploadDownloadPage.open();
    }

    @Test
    public void uploadTest() {
        uploadDownloadPage.uploadPicture(picturePath);
        WebDriverWait wait = new WebDriverWait(driver, 2);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("uploadedFilePath")));
        System.out.println(uploadDownloadPage.getUploadedPicturePath());
    }

    @Test
    public void downloadTest() throws IOException {
        uploadDownloadPage.clickDownload();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("List of downloaded file: ");
        File folder = new File(ConfigManager.getProperty("downloadPath"));
        for (File file : folder.listFiles())
        {
            System.out.println(file.getName());
        }
    }
}
