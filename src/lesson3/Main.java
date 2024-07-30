package lesson3;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Employee> femTeam = new ArrayList<>();
        femTeam.add(new Employee("Alan"));
        femTeam.add(new Employee("Bob"));
        femTeam.add(new Employee("Camila"));
        femTeam.add(new Employee("Diana"));
        femTeam.add(new Employee("Frank"));
        femTeam.add(new Employee("Emily"));
        femTeam.add(new Manager("Grace"));
        System.out.println(femTeam);

        for (Employee e : femTeam) {
            Manager.riseSalary(e, 5);
        }
        System.out.println(femTeam);
    }
}
