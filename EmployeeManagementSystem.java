import java.util.HashMap;
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
    private String shiftTime;

    public PartTimeEmployee(String name, int id, String shiftTime) {
        super(name, id);
        this.shiftTime = shiftTime;
    }

    public void displayInfo() {
        super.displayInfo();
        System.out.println("Shift Time: " + shiftTime);
    }
}

class ContractEmployee extends EmployeeDetails {
    private String contractType;

    public ContractEmployee(String name, int id, String contractType) {
        super(name, id);
        this.contractType = contractType;
    }

    public void displayInfo() {
        super.displayInfo();
        System.out.println("Contract Type: " + contractType);
    }
}

public class EmployeeManagementSystem {
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
                    System.out.print("Enter the Employee Type:\n 1. Permanent\n 2. Part-Time\n 3. Contract\n ");
                    int employeeType = scanner.nextInt();
                    scanner.nextLine();

                    EmployeeDetails employee = null;
                    switch (employeeType) {
                        case 1:
                            System.out.print("Enter the employee name: ");
                            String name = scanner.nextLine();
                            System.out.print("Enter the employee ID: ");
                            int id = scanner.nextInt();
                            employee = new PermanentEmployee(name, id);
                            break;
                        case 2:
                            System.out.print("Enter the employee name: ");
                            String partEmName = scanner.nextLine();
                            System.out.print("Enter the employee ID: ");
                            int partEmId = scanner.nextInt();
                            System.out.println("Enter the shift time:");
                            String shiftTime = scanner.nextLine();
                            employee = new PartTimeEmployee(partEmName, partEmId, shiftTime);
                            break;
                        case 3:
                            System.out.print("Enter the employee name: ");
                            String conEmName = scanner.nextLine();
                            System.out.print("Enter the employee ID: ");
                            int conEmId = scanner.nextInt();
                            System.out.println("Enter the shift time:");
                            String type = scanner.nextLine();
                            employee = new ContractEmployee(conEmName, conEmId, type);
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
                    System.out.print("Enter the Employee Type:\n 1. Permanent\n 2. Part-Time\n 3. Contract\n ");
                    int modifyEmployeeType = scanner.nextInt();
                    scanner.nextLine();

                    EmployeeDetails modifyEmployee = null;
                    switch (modifyEmployeeType) {
                        case 1:
                            System.out.print("Enter the name of the employee to modify: ");
                            String permanentNameToModify = scanner.nextLine();
                            System.out.print("Enter the employee new ID: ");
                            int newId = scanner.nextInt();
                            modifyEmployeeType = new PermanentEmployee(permanentNameToModify, newId);
                            break;
                        case 2:
                            System.out.print("Enter the name of the employee to modify: ");
                            String nameToModify = scanner.nextLine();
                            System.out.print("Enter the employee new ID: ");
                            int partEmNewId = scanner.nextInt();
                            System.out.println("Enter the shift time:");
                            String shiftTime = scanner.nextLine();
                            modifyEmployeeType = new PartTimeEmployee(nameToModify, partEmId, shiftTime);
                            break;
                        case 3:
                            System.out.print("Enter the name of the employee to modify: ");
                            String contractNameToModify = scanner.nextLine();
                            System.out.print("Enter the employee new ID: ");
                            int conEmNewId = scanner.nextInt();
                            System.out.println("Enter the modify shift time:");
                            String type = scanner.nextLine();
                            modifyEmployeeType = new ContractEmployee(contractNameToModify, conEmNewId, type);
                            break;
                        default:
                            System.out.println("Invalid employee type.");
                            break;
                    }

                    if (modifyEmployee != null) {
                        employeeSystem.modifyEmployee(nameToModify, newId);
                    }
                    break;

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
