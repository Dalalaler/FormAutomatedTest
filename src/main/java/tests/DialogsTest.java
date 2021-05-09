package tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;

public class DialogsTest extends BasicTest {
    @BeforeEach
    public void pagePreparation() throws IOException {
        dialogsPage.open();
    }

    @Test
    public void smallModalTest(){
        dialogsPage.clickSmallModal();
        System.out.println("Small modal text: ");
        WebDriverWait wait = new WebDriverWait(driver, 2);
        wait.until(ExpectedConditions.elementToBeClickable(By.id("closeSmallModal")));
        System.out.println(dialogsPage.getSmallModalText());
        dialogsPage.closeSmallModal();
    }

    @Test
    public void largeModalTest(){
        dialogsPage.clickLargeModal();
        System.out.println("Large modal text: ");
        WebDriverWait wait = new WebDriverWait(driver, 2);
        wait.until(ExpectedConditions.elementToBeClickable(By.id("closeLargeModal")));
        System.out.println(dialogsPage.getLargeModalText());
        dialogsPage.closeLargeModal();
    }

}
