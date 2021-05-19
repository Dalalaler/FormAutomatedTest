package tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import pages.FramesPages;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FramesTest extends BasicTest {
    private String frameText = "This is a sample page";

    @BeforeEach
    public void pagePreparation() throws IOException {
        framesPages = new FramesPages(driver);
        framesPages.open();
        int framesCount = driver.findElements(By.tagName("iframe")).size();
        assertEquals(framesCount, 2, "Number of pages is not 2");
    }

    @Test
    public void firstFrameTest() {
        frameTextTest(0, frameText);
    }

    @Test
    public void secondFrameTest() {
        frameTextTest(0, frameText);
    }

    public void frameTextTest(int frameIndex, String expectedText) {
        driver.switchTo().frame(frameIndex);
        assertEquals(driver.findElement(By.id("sampleHeading")).getText(), frameText);
    }
}
