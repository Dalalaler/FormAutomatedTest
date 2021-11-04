package tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.WidgetsDatePickerPage;
import testutils.GetCurrentDate;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class WidgetsDatePickerTest extends BasicTest {
    private String errorMessage = "Date's doesn't match.";
    private String monthAndYearFormat ="MM/dd/yyyy";
    private String dateAndTimeFormat ="MMMM d, yyyy h:mm a";
    private String currentDate;
    private String receivedDate;

    @BeforeEach
    public void pagePreparation() throws IOException {
        widgetsDatePickerPage = new WidgetsDatePickerPage(driver);
        widgetsDatePickerPage.open();
    }

    @Test
    public void monthAndYearInputTest() {
        currentDate = GetCurrentDate.getCurrentDateWithFormat(monthAndYearFormat);
        widgetsDatePickerPage.enterMonthAndYear(currentDate);
        receivedDate = widgetsDatePickerPage.getMonthAndYear();
        assertTrue(currentDate.contains(receivedDate),errorMessage);
    }

    @Test
    public void dateAndYearInputTest() {
        currentDate = GetCurrentDate.getCurrentDateWithFormat(dateAndTimeFormat);
        widgetsDatePickerPage.enterMonthAndYear(currentDate);
        receivedDate = widgetsDatePickerPage.getDateAndTime();
        assertTrue(currentDate.contains(receivedDate),errorMessage);
    }
}
