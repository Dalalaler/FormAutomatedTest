package tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.WidgetsSelectMenuPage;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class WidgetsSelectMenuTest extends BasicTest {
    private String oldStyleSelect = "Aqua";
    private String standardSelect = "Saab";
    private String selectValueInput = "Another root option";
    private String selectOneInput = "Ms.";
    private String[] colors = new String[]{"Red", "Green", "Blue"};

    @BeforeEach
    public void pagePreparation() throws IOException {
        widgetsSelectMenuPage = new WidgetsSelectMenuPage(driver);
        widgetsSelectMenuPage.open();
    }

    @Test
    public void allFieldFilling() {
        widgetsSelectMenuPage.enterSelectValueInput(selectValueInput);
        widgetsSelectMenuPage.enterSelectOneInput(selectOneInput);
        widgetsSelectMenuPage.enterOldSelect(oldStyleSelect);
        for (String color : colors) {
            widgetsSelectMenuPage.enterMultiSelectDropDown(color);
        }
        widgetsSelectMenuPage.enterStandardMultiSelect(standardSelect);

        assertEquals(widgetsSelectMenuPage.getSelectedValues(), selectValueInput);
        assertEquals(widgetsSelectMenuPage.getSelectedOneInput(), selectOneInput);
        assertEquals(widgetsSelectMenuPage.getOldStyleSelectedOption(), oldStyleSelect);

        List<String> receivedColors = widgetsSelectMenuPage.getMultipleInputtedData();
        for (String color : colors) {
            assertTrue(receivedColors.contains(color));
        }
        assertEquals(widgetsSelectMenuPage.getStandardSelectedOption(), standardSelect);
    }
}
