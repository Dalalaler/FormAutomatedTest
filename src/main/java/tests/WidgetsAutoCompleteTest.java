package tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.WidgetsAutoCompletePage;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class WidgetsAutoCompleteTest extends BasicTest {
    private String colorWasntReceivedError = "Color %s wasn't received";
    private String colorWasReceivedError = "Deleted color %s was received";
    private String[] colors = new String[]{"Red", "Green", "Blue"};
    private String colorToDelete = colors[1];

    @BeforeEach
    public void pagePreparation() throws IOException {
        widgetsAutoCompletePage = new WidgetsAutoCompletePage(driver);
        widgetsAutoCompletePage.open();
    }

    @Test
    public void multipleInputEnterTest() {
        for (String color : colors) {
            widgetsAutoCompletePage.enterMultipleInputData(color);
        }

        List<String> receivedColors = widgetsAutoCompletePage.getMultipleInputtedData();
        for (String color : colors) {
            assertTrue(receivedColors.contains(color), String.format(colorWasntReceivedError, color));
        }
    }

    @Test
    public void multipleInputDeleteTest() {
        for (String color : colors) {
            widgetsAutoCompletePage.enterMultipleInputData(color);
        }

        widgetsAutoCompletePage.deleteSelectedColor(colorToDelete);

        List<String> receivedColors = widgetsAutoCompletePage.getMultipleInputtedData();
        assertFalse(receivedColors.contains(colorToDelete), String.format(colorWasReceivedError, colorToDelete));
    }

    @Test
    public void singleInputEnterTest() {
        widgetsAutoCompletePage.enterSingleInputData(colors[0]);

        System.out.println();
        assertTrue(widgetsAutoCompletePage.getSingleInputtedData().contains(colors[0]),
                String.format(colorWasntReceivedError, colors[0]));
    }
}
