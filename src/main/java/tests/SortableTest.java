package tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.SortablePage;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SortableTest extends BasicTest {
    private String[] numberNames = new String[]{"One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};

    @BeforeEach
    public void pagePreparation() throws IOException {
        sortablePage = new SortablePage(driver);
        sortablePage.open();
    }

    @Test
    public void listSortTest() {
        sortablePage.pressListButton();
        for (int i = 0; i < 6; i++) {
            sortablePage.dropListElementToPosition(numberNames[i], 6 - i);
        }

        for (int i = 1; i < 7; i++) {
            assertEquals(sortablePage.getListElementNameByIndex(i), numberNames[6 - i]);
        }
    }

    @Test
    public void gridSortTest() {
        sortablePage.pressGridButton();
        for (int i = 0; i < 9; i++) {
            sortablePage.dropGridElementToPosition(numberNames[i], 9 - i);
        }

        for (int i = 1; i < 10; i++) {
            assertEquals(sortablePage.getGridElementNameByIndex(i), numberNames[9 - i]);
        }
    }
}
