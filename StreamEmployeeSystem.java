import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Comparator;
import java.util.stream.Collectors;

class Employee {
    int id;
    String name;
    String type;

    public Employee(int id, String name, String type) {
        this.id = id;
        this.name = name;
        this.type = type;
    }
}

public class StreamEmployeeSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Employee> employees = new ArrayList<>();

        while (true) {
            System.out.println("1. Create\n2. Delete\n3. Search\n4. List Employees\n5. Sort\n6. Exit\n");
            System.out.println("Enter your choice: ");
            int ch = sc.nextInt();

            switch (ch) {
                case 1:
                    System.out.println("Enter the Employee id: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Enter the Employee name: ");
                    String name = sc.nextLine();
                    System.out.println("Enter the Employee type: ");
                    String type = sc.nextLine();
                    employees.add(new Employee(id, name, type));
                    break;
                case 2:
                    System.out.println("Enter the employee id to remove: ");
                    int empId = sc.nextInt();
                    employees.removeIf(employee -> employee.id == empId);
                    break;
                case 3:
                    System.out.println("Enter the employee id to search: ");
                    int searchId = sc.nextInt();
                    employees.stream()
                            .filter(employee -> employee.id == searchId)
                            .forEach(employee -> System.out
                                    .println(employee.id + " " + employee.name + " " + employee.type));

                    break;
                case 4:
                    employees.stream().forEach(
                            employee -> System.out.println(employee.id + " " + employee.name + " " + employee.type));
                    break;
                case 5:
                    System.out.println("Enter 1 to sort by ID, 2 to sort by Name:");
                    int sortChoice = sc.nextInt();
                    if (sortChoice == 1) {
                        System.out.println("Sort Results by ID: ");
                        employees.stream()
                                .sorted(Comparator.comparingInt(employee -> employee.id))
                                .forEach(employee -> System.out
                                        .println(employee.id + " " + employee.name + " " + employee.type));

                    } else if (sortChoice == 2) {
                        System.out.println("Sort Results by Name: ");
                        employees.stream()
                                .sorted(Comparator.comparing(employee -> employee.name))
                                .forEach(
                                        employee -> System.out
                                                .println(employee.id + " " + employee.name + " " + employee.type));

                    } else {
                        System.out.println("Invalid sort choice.");
                    }
                    break;
                case 6:
                    System.out.println("Exiting the system.");
                    sc.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
                    break;
            }
        }
    }
}
