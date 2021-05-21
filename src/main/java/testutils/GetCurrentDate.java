package testutils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class GetCurrentDate {
    public static String getCurrentDateWithFormat(String dateFormat) {
        SimpleDateFormat monthAndYearFormat = new SimpleDateFormat(dateFormat, Locale.ENGLISH);
        Date date = new Date();
        return monthAndYearFormat.format(date);
    }
}
