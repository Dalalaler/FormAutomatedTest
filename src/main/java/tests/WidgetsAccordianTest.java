package tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.WidgetsAccordianPage;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class WidgetsAccordianTest extends BasicTest {
    @BeforeEach
    public void pagePreparation() throws IOException {
        widgetsAccordianPage = new WidgetsAccordianPage(driver);
        widgetsAccordianPage.open();
    }

    @Test
    public void firstSectionTest() throws IOException {
        widgetsAccordianPage.openFirstSection();
        System.out.println(widgetsAccordianPage.getFirstSectionText());
        assertTrue(widgetsAccordianPage.getFirstSectionText().length() > 0, "There is no text in section #1");
    }

    @Test
    public void secondSectionTest() throws IOException {
        widgetsAccordianPage.openSecondSection();
        System.out.println(widgetsAccordianPage.getSecondSectionText());
        assertTrue(widgetsAccordianPage.getSecondSectionText().length() > 0, "There is no text in section #2");
    }

    @Test
    public void thirdSectionTest() throws IOException {
        widgetsAccordianPage.openThirdSection();
        System.out.println(widgetsAccordianPage.getThirdSectionText());
        assertTrue(widgetsAccordianPage.getThirdSectionText().length() > 0, "There is no text in section #3");
    }
}
