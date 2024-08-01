package lesson4;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Employee[] team = getEmployees();

        LocalDate date1 = LocalDate.of(2024, 1, 1);
        congratulateEmployeesOnHoliday(team, getHoliday(date1));                // Dear Alan, Bob, Camila, Diana, Frank, Emily, Grace, we are happy to congratulate you on the New Year's Day!

        LocalDate date2 = LocalDate.of(2024, 1, 13);
        congratulateEmployeesOnHoliday(team, getHoliday(date2));                // There is nothing to celebrate. Get back to work!

        LocalDate date3 = LocalDate.of(2024, 2, 23);
        congratulateEmployeesOnHoliday(team, getHoliday(date3));                // Dear Alan, Bob, Frank, we are happy to congratulate you on the Men's Day!

        LocalDate date4 = LocalDate.of(2024, 3, 8);
        congratulateEmployeesOnHoliday(team, getHoliday(date4));                // Dear Camila, Diana, Emily, Grace, we are happy to congratulate you on the Women's Day!
    }

    private static Employee[] getEmployees() {
        Employee e1 = new Employee("Alan", Gender.MALE);
        Employee e2 = new Employee("Bob", Gender.MALE);
        Employee e3 = new Employee("Camila", Gender.FEMALE);
        Employee e4 = new Employee("Diana", Gender.FEMALE);
        Employee e5 = new Employee("Frank", Gender.MALE);
        Employee e6 = new Employee("Emily", Gender.FEMALE);
        Employee e7 = new Manager("Grace", Gender.FEMALE);

        return new Employee[]{e1, e2, e3, e4, e5, e6, e7};
    }

    /**
     * Gets holiday by date.
     *
     * @param date the date
     * @return the holiday
     */
    static Holiday getHoliday(LocalDate date) {
        List<Holiday> holidayList = new ArrayList<>(List.of(Holiday.values()));
        holidayList.remove(0);

        Holiday holiday = Holiday.NO_HOLIDAY;
        for (Holiday h : holidayList) {
            if (date.getMonthValue() == h.getHolidayDate().getMonthValue() &&
                    date.getDayOfMonth() == h.getHolidayDate().getDayOfMonth()) {
                holiday = h;
            }
        }
        return holiday;

    }

    /**
     * Congratulate employees on holiday.
     *
     * @param employees the employees
     * @param holiday   the holiday
     */
    static void congratulateEmployeesOnHoliday(Employee[] employees, Holiday holiday) {
        String congratulation = "Dear %swe are happy to congratulate you on the %s!%n";
        StringBuilder recipients = new StringBuilder();
        switch (holiday) {
            case NEW_YEARS_DAY:
                for (Employee e : employees) {
                    recipients.append(String.format("%s, ", e.getName()));
                }
                System.out.printf(congratulation, recipients, holiday.getTitle());
                break;
            case MENS_DAY:
                for (Employee e : employees) {
                    if (e.getGender().equals(Gender.MALE)) {
                        recipients.append(String.format("%s, ", e.getName()));
                    }
                }
                System.out.printf(congratulation, recipients, holiday.getTitle());
                break;
            case WOMENS_DAY:
                for (Employee e : employees) {
                    if (e.getGender().equals(Gender.FEMALE)) {
                        recipients.append(String.format("%s, ", e.getName()));
                    }
                }
                System.out.printf(congratulation, recipients, holiday.getTitle());
                break;
            default:
                System.out.println("There is nothing to celebrate. Get back to work!");
        }
    }
}
