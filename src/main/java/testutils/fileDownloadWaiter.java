package testutils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.FluentWait;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class fileDownloadWaiter {
    public static void waitForFile(WebDriver driver, File file, long timeout) {
        FluentWait wait = new FluentWait(driver)
                .withTimeout(timeout, TimeUnit.SECONDS)
                .pollingEvery(1, TimeUnit.SECONDS);
        wait.until((webDriver) -> file.exists());
    }
}
