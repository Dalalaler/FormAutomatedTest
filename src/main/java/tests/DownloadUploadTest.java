package tests;

import configreader.ConfigManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.UploadDownloadPage;
import testutils.PathGetter;
import testutils.fileDownloadWaiter;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class DownloadUploadTest extends BasicTest {
    private String pictureToUploadName = "kfc_fighter.jpg";
    private String pictureToDownloadName = "sampleFile.jpeg";
    private String downloadPath;
    boolean fileWasDownloaded = false;
    boolean fileWasUploaded = false;

    @BeforeEach
    public void pagePreparation() throws IOException {
        uploadDownloadPage = new UploadDownloadPage(driver);
        uploadDownloadPage.open();
    }

    @Test
    public void uploadTest() throws IOException {
        uploadDownloadPage.uploadPicture(PathGetter.getAbsoluteFilePath("picturesPath", pictureToUploadName));
        int waitingTime = Integer.parseInt(ConfigManager.getProperty("downloadTestWebDriverWait"));
        WebDriverWait wait = new WebDriverWait(driver, waitingTime);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("uploadedFilePath")));
        if (uploadDownloadPage.getUploadedPicturePath().endsWith(pictureToUploadName)) fileWasUploaded = true;

        assertTrue(fileWasUploaded, "File wasn't uploaded");
    }

    @Test
    public void downloadTest() throws IOException {
        downloadPath = PathGetter.getAbsoluteFolderPath("downloadPath").concat("\\");
        String expectedDownloadedFilePath = downloadPath.concat(pictureToDownloadName);
        File expectedFile = new File(expectedDownloadedFilePath);

        File downloadDirectory = new File(downloadPath);
        File[] files = downloadDirectory.listFiles();
        for (File file : files) {
            if (!file.delete()) {
                System.out.println("Failed to delete " + file);
            }
        }

        uploadDownloadPage.clickDownload();
        fileDownloadWaiter.waitForFile(driver, expectedFile, Integer.parseInt(ConfigManager.getProperty("pictureDownloadWait")));

        for (File file : downloadDirectory.listFiles()) {
            if (file.toString().endsWith(pictureToDownloadName)) {
                fileWasDownloaded = true;
            } else {
                System.out.println("File wasn't downloaded");
            }
        }

        assertTrue(fileWasDownloaded, "File wasn't downloaded or have unexpected name");
    }
}

