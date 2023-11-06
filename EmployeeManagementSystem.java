import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class EmployeeDetails {
    private String name;
    private int id;

    public EmployeeDetails(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public void displayInfo() {
        System.out.println("Employee Name: " + name);
        System.out.println("Employee ID: " + id);
    }
}

class PermanentEmployee extends EmployeeDetails {
    public PermanentEmployee(String name, int id) {
        super(name, id);
    }

    public void displayInfo() {
        super.displayInfo();
    }
}

class PartTimeEmployee extends EmployeeDetails {
    public PartTimeEmployee(String name, int id) {
        super(name, id);
    }

    public void displayInfo() {
        super.displayInfo();
    }
}

class ContractEmployee extends EmployeeDetails {
    public ContractEmployee(String name, int id) {
        super(name, id);
    }

    public void displayInfo() {
        super.displayInfo();
    }
}

class EmployeeManagementSystem {
    private HashMap<String, EmployeeDetails> employeeMap = new HashMap<>();
    private Scanner scanner = new Scanner(System.in);

    public void createEmployee(EmployeeDetails employee) {
        employeeMap.put(employee.getName(), employee);
        System.out.println("Employee created successfully.");
    }

    public void modifyEmployee(String name, int newId) {
        if (employeeMap.containsKey(name)) {
            EmployeeDetails employee = employeeMap.get(name);
            employeeMap.put(name, new EmployeeDetails(name, newId));
            System.out.println("Employee information updated.");
        } else {
            System.out.println("Employee with name " + name + " not found.");
        }
    }

    public void removeEmployee(String name) {
        if (employeeMap.containsKey(name)) {
            employeeMap.remove(name);
            System.out.println("Employee removed.");
        } else {
            System.out.println("Employee with name " + name + " not found.");
        }
    }

    public void listEmployees() {
        System.out.println("Employee List:");
        for (EmployeeDetails employee : employeeMap.values()) {
            employee.displayInfo();
            System.out.println();
        }
    }

    public void searchEmployee(String name) {
        if (employeeMap.containsKey(name)) {
            EmployeeDetails employee = employeeMap.get(name);
            System.out.println("Employee found:");
            employee.displayInfo();
        } else {
            System.out.println("Employee with name " + name + " not found.");
        }
    }

    public static void main(String[] args) {
        EmployeeManagementSystem employeeSystem = new EmployeeManagementSystem();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println(
                    "Employee Management System\n 1. Create Employee\n 2. Modify Employee\n 3. Remove Employee\n 4. List Employees\n 5. Search Employee\n 6. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter the employee name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter the employee ID: ");
                    int id = scanner.nextInt();
                    System.out.print("Enter the Employee Type:\n 1. Permanent\n 2. Part-Time\n 3. Contract\n ");
                    int employeeType = scanner.nextInt();

                    EmployeeDetails employee = null;
                    switch (employeeType) {
                        case 1:
                            employee = new PermanentEmployee(name, id);
                            break;
                        case 2:
                            employee = new PartTimeEmployee(name, id);
                            break;
                        case 3:
                            employee = new ContractEmployee(name, id);
                            break;
                        default:
                            System.out.println("Invalid employee type.");
                            break;
                    }

                    if (employee != null) {
                        employeeSystem.createEmployee(employee);
                    }
                    break;
                case 2:
                    System.out.print("Enter the name of the employee to modify: ");
                    String nameToModify = scanner.nextLine();
                    System.out.print("Enter the new employee ID: ");
                    int newId = scanner.nextInt();
                    employeeSystem.modifyEmployee(nameToModify, newId);
                    break;
                case 3:
                    System.out.print("Enter the name of the employee to remove: ");
                    String nameToRemove = scanner.nextLine();
                    employeeSystem.removeEmployee(nameToRemove);
                    break;
                case 4:
                    employeeSystem.listEmployees();
                    break;
                case 5:
                    System.out.print("Enter the name of the employee to search: ");
                    String nameToSearch = scanner.nextLine();
                    employeeSystem.searchEmployee(nameToSearch);
                    break;
                case 6:
                    System.out.println("Exiting Employee Management System.");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
