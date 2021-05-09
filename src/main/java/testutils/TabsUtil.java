package testutils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.WindowPage;

public class TabsUtil {
    private static String testResult = "New page title: %s\nNew page url: %s\nNew page text: %s";

    public static void getNewPageData(WebDriver driver, WindowPage windowPage, String parentPage) {
        if (new WebDriverWait(driver, 3).until(ExpectedConditions.numberOfWindowsToBe(2))) {
            for (String windowHandle : driver.getWindowHandles()) {
                if (!parentPage.contentEquals(windowHandle)) {
                    driver.switchTo().window(windowHandle);
                    break;
                }
            }
            System.out.println(String.format(testResult, driver.getTitle(), driver.getCurrentUrl(), windowPage.getSampleHeading()));
        } else {
            System.out.println("New tab didn't open");
        }
    }
}
