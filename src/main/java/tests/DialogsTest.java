package tests;

import configreader.ConfigManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.DialogsPage;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DialogsTest extends BasicTest {
    private String expectedSmallDiaologText = "This is a small modal. It has very less content";
    private String expectedLargeDiaologText = "Lorem Ipsum is simply dummy text of the printing and typesetting industry.";
    private boolean largeDialogIncludeExpectedText = false;

    @BeforeEach
    public void pagePreparation() throws IOException {
        dialogsPage = new DialogsPage(driver);
        dialogsPage.open();
    }

    @Test
    public void smallModalTest() throws IOException {
        dialogsPage.clickSmallModal();
        WebDriverWait wait = new WebDriverWait(driver, Integer.parseInt(ConfigManager.getProperty("dialogTestWebDriverWait")));
        wait.until(ExpectedConditions.elementToBeClickable(By.id("closeSmallModal")));

        assertEquals(dialogsPage.getSmallModalText(), expectedSmallDiaologText, "Unexpected text");
        dialogsPage.closeSmallModal();
    }

    @Test
    public void largeModalTest() throws IOException {
        dialogsPage.clickLargeModal();
        WebDriverWait wait = new WebDriverWait(driver, Integer.parseInt(ConfigManager.getProperty("dialogTestWebDriverWait")));
        wait.until(ExpectedConditions.elementToBeClickable(By.id("closeLargeModal")));

        largeDialogIncludeExpectedText = dialogsPage.getLargeModalText().contains(expectedLargeDiaologText);
        assertTrue(largeDialogIncludeExpectedText, "Unexpected text");
        dialogsPage.closeLargeModal();
    }
}
