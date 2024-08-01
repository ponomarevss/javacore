package lesson4;

import java.time.DateTimeException;
import java.time.LocalDate;

public enum Holiday {
    NO_HOLIDAY("no holiday", 0, 0),
    NEW_YEARS_DAY("New Year's Day", 1, 1),
    MENS_DAY("Men's Day", 2, 23),
    WOMENS_DAY("Women's Day", 3, 8);

    private final String title;
    private LocalDate holidayDate;

    Holiday(String title, int month, int day) {
        this.title = title;
        try {
            this.holidayDate = LocalDate.of(1900, month, day);
        } catch (DateTimeException e) {
            this.holidayDate = null;
        }

    }

    public String getTitle() {
        return title;
    }

    public LocalDate getHolidayDate() {
        return holidayDate;
    }
}
