package tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.WindowPage;
import testutils.TabsUtil;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class WindowsTest extends BasicTest {
    private String parentPage;
    private boolean newTabWasOpened = false;
    private boolean newWindowsWasOpened = false;

    @BeforeEach
    public void pagePreparation() throws IOException {
        windowPage = new WindowPage(driver);
        windowPage.open();
        parentPage = driver.getWindowHandle();
    }

    @Test
    public void newTabTest() {
        windowPage.pressNewTabBtn();
        newTabWasOpened = TabsUtil.checkNewWindowCanBeOpen(driver, windowPage, parentPage);
        assertTrue(newTabWasOpened, "New tab wasn't opened");
    }


    @Test
    public void newWindowTest() {
        windowPage.pressWindowBtn();
        newWindowsWasOpened = TabsUtil.checkNewWindowCanBeOpen(driver, windowPage, parentPage);
        assertTrue(newWindowsWasOpened, "New tab wasn't opened");
    }

    @Test
    public void newWindowMessageTest() {
        windowPage.pressWindowMessageBtn();

        for (String windowHandle : driver.getWindowHandles()) {
            if (!parentPage.contentEquals(windowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
        String childPage = driver.getWindowHandle();

        System.out.print("Parent page handle: ");
        System.out.println(parentPage);
        System.out.print("Child page handle: ");
        System.out.println(childPage);
    }
}
