import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Comparator;
import java.util.stream.Collectors;

class Employee {
    int id;
    String name;

    public Employee(int id, String name) {
        this.name = name;
        this.id = id;

    }
}

class EmployeeClass {
    List<Employee> employees = new ArrayList<>();

    public void addEmployee(Employee employee) {

        employees.add(employee);
        System.out.println("Sucessfully create employee details.");
    }

    public void removeEmployee(int id) {

        employees.removeIf(emp -> emp.id == id);
        System.out.println("Sucessfully remove employee details.");
    }

    public void listEmployee() {
        for (Employee emp : employees) {
            System.out.println(emp);
        }

    }

    public void searchEmployee(int id) {
        employees.stream()
                .filter(emp -> emp.id == id)
                .forEach(emp -> System.out.println(emp.id + " " + emp.name));
    }

    public void sortById() {
        employees.stream()
                .sorted(Comparator.comparingInt(emp -> emp.id))
                .forEach(emp -> System.out.println(emp.id + " " + emp.name));
    }

    public void sortByName() {
        employees.stream()
                .sorted(Comparator.comparing(emp -> emp.name))
                .forEach(emp -> System.out.println(emp.id + " " + emp.name));
    }
}

public class EmployeeSystem {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        EmployeeClass employeeClass = new EmployeeClass();
        while (true) {
            System.out.println("Enter your number:");
            int num = input.nextInt();

            if (num == 1) {
                System.out.println("Enter the is Employee id:");
                int id = input.nextInt();
                input.nextLine();
                System.out.println("Enter the Employee name:");
                String name = input.nextLine();
                employeeClass.addEmployee(new Employee(id, name));
            } else if (num == 2) {
                System.out.println("Enter the id number to remove");
                int emp_id = input.nextInt();
                employeeClass.removeEmployee(emp_id);
            } else if (num == 3) {
                System.out.println("Enter the employee id to search");
                int search_id = input.nextInt();
                employeeClass.searchEmployee(search_id);
            } else if (num == 4) {
                System.out.println("Sorted by Employee id:");
                employeeClass.sortById();
            } else if (num == 5) {
                System.out.println("Sorted by Employee name:");
                employeeClass.sortByName();
            } else {
                System.out.println("Invalid number:");
            }
        }

    }

}