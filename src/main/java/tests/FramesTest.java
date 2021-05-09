package tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.io.IOException;

public class FramesTest extends BasicTest {
    @BeforeEach
    public void pagePreparation() throws IOException {
        framesPages.open();
        int size = driver.findElements(By.tagName("iframe")).size();
        System.out.println("Total Frames: " + size);
    }

    @Test
    public void firstFrameTest() {
        driver.switchTo().frame(0);
        System.out.println("First frame text: ");
        System.out.println(driver.findElement(By.id("sampleHeading")).getText());
    }

    @Test
    public void secondFrameTest() {
        driver.switchTo().frame(1);
        System.out.println("Second frame text: ");
        System.out.println(driver.findElement(By.id("sampleHeading")).getText());
    }
}
