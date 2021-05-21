package tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.WidgetsMenuPage;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class WidgetsMenuTest extends BasicTest {
    private String errorMessage = "Element is not displayed.";

    @BeforeEach
    public void pagePreparation() throws IOException {
        widgetsMenuPage = new WidgetsMenuPage(driver);
        widgetsMenuPage.open();
    }

    @Test
    public void subSubItem2Test() {
        driver.manage().window().maximize();
        widgetsMenuPage.moveToMainItem2();
        widgetsMenuPage.moveToSubSubList();
        widgetsMenuPage.moveToSubSubItem2();

        assertTrue(widgetsMenuPage.checkAndClickSubSubItem2(), errorMessage);
    }
}
