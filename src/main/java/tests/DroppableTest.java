package tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.DroppablePage;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class DroppableTest extends BasicTest {
    private String oldColor;
    private String newColor;
    private String droppedText = "Dropped!";
    private String colorError = "Color has not changed!";
    private String droppedTextError = "Dropped text not met!";

    @BeforeEach
    public void pagePreparation() throws IOException {
        droppablePage = new DroppablePage(driver);
        droppablePage.open();
    }

    @Test
    public void simpleDropTest() {
        droppablePage.pressSimpleButton();
        oldColor = droppablePage.getSimpleDroppableColor();
        droppablePage.dropSimpleDraggableToSimpleDroppable();
        newColor = droppablePage.getSimpleDroppableColor();

        assertNotEquals(oldColor, newColor, colorError);
        assertEquals(droppablePage.getSimpleDroppableText(), droppedText, droppedTextError);
    }

    @Test
    public void acceptDropTest() {
        droppablePage.pressAcceptButton();
        oldColor = droppablePage.getAcceptDroppableColor();
        droppablePage.dropAcceptDraggableToSimpleDroppable();
        newColor = droppablePage.getAcceptDroppableColor();

        assertNotEquals(oldColor, newColor, colorError);
        assertEquals(droppablePage.getAcceptDroppableText(), droppedText, droppedTextError);
    }

    @Test
    public void preventPropogationTest() {
        droppablePage.pressPreventPropogationButton();
        oldColor = droppablePage.getFirstOuterDroppableColor();
        droppablePage.dropPreventPropogationDraggableToFirstDroppable();
        newColor = droppablePage.getFirstOuterDroppableColor();

        assertNotEquals(oldColor, newColor, colorError);
        assertTrue(droppablePage.getFirstOuterDroppableText().contains(droppedText), droppedTextError);

        oldColor = droppablePage.getSecondInnerDroppableColor();
        droppablePage.dropPreventPropogationDraggableToSecondDroppable();
        newColor = droppablePage.getSecondInnerDroppableColor();

        assertNotEquals(oldColor, newColor, colorError);
        assertTrue(droppablePage.getSecondInnerDroppableText().contains(droppedText), droppedTextError);
    }

    @Test
    public void revertDraggableTest() {
        droppablePage.pressRevertDraggableButton();
        oldColor = droppablePage.getRevertDroppableColor();
        droppablePage.dropRevertDraggable();
        newColor = droppablePage.getRevertDroppableColor();

        assertNotEquals(oldColor, newColor, colorError);
        assertTrue(droppablePage.getRevertDroppableText().contains(droppedText), droppedTextError);
    }
}
