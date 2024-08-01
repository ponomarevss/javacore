package lesson4;

import java.time.LocalDate;

public class Employee {
    public static final double INITIAL_EMPLOYEE_SALARY = 40_000;
    private String name;
    private Gender gender;
    private LocalDate employmentDate;
    protected Double salary;

    public Employee(String name, Gender gender) {
        this.name = name;
        this.gender = gender;
        this.employmentDate = LocalDate.now();
        this.salary = INITIAL_EMPLOYEE_SALARY;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getEmploymentDate() {
        return employmentDate;
    }

    public void setEmploymentDate(LocalDate employmentDate) {
        this.employmentDate = employmentDate;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public static int compareDates(LocalDate date1, LocalDate date2) {
        int year1 = date1.getYear();
        int month1 = date1.getMonthValue();
        int day1 = date1.getDayOfMonth();

        int year2 = date2.getYear();
        int month2 = date2.getMonthValue();
        int day2 = date2.getDayOfMonth();

        return year1 != year2 ? Integer.compare(year1, year2)
                : month1 != month2 ? Integer.compare(month1, month2)
                : Integer.compare(day1, day2);
    }

    @Override
    public String toString() {
        return String.format("Employee{name='%s', employmentDate=%s, salary=%.2f}%n",
                name, employmentDate, salary);
    }
}
