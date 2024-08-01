package lesson4;

public class Manager extends Employee {
    public static final double INITIAL_MANAGER_SALARY = 50_000;
    public Manager(String name, Gender gender) {
        super(name, gender);
        this.salary = INITIAL_MANAGER_SALARY;
    }

    public static void riseSalary(Employee employee, double percent) {
        if (employee.getClass() != Manager.class) {
            employee.setSalary(employee.getSalary() * (1 + percent / 100));
        }
    }
}
