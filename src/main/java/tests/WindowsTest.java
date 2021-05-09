package tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import testutils.TabsUtil;

import java.io.IOException;

public class WindowsTest extends BasicTest {
    private String parentPage;

    @BeforeEach
    public void pagePreparation() throws IOException {
        windowPage.open();
        parentPage = driver.getWindowHandle();
    }

    @Test
    public void newTabTest() {
        windowPage.pressNewTabBtn();
        TabsUtil.getNewPageData(driver, windowPage, parentPage);
    }


    @Test
    public void newWindowTest() {
        windowPage.pressWindowBtn();
        TabsUtil.getNewPageData(driver, windowPage, parentPage);
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
