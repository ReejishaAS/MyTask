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

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
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

    public void modifyEmployee(String name, String newName, int newId, int employeeType) {
        if (employeeMap.containsKey(name)) {
            EmployeeDetails employee = employeeMap.get(name);

            if (employee instanceof PermanentEmployee && employeeType == 1) {
                PermanentEmployee permanentEmployee = (PermanentEmployee) employee;
                permanentEmployee.setName(newName);
                permanentEmployee.setId(newId);
            } else if (employee instanceof PartTimeEmployee && employeeType == 2) {
                PartTimeEmployee partTimeEmployee = (PartTimeEmployee) employee;
                partTimeEmployee.setName(newName);
                partTimeEmployee.setId(newId);
            } else if (employee instanceof ContractEmployee && employeeType == 3) {
                ContractEmployee contractEmployee = (ContractEmployee) employee;
                contractEmployee.setName(newName);
                contractEmployee.setId(newId);
            } else {
                System.out.println("Invalid employee type for modification.");
                return;
            }

            System.out.println("Employee information updated.");
        } else {
            System.out.println("Employee with name " + name + " not found.");
        }
    }

    public void removeEmployee(String name, int employeeType) {
        if (employeeMap.containsKey(name)) {
            EmployeeDetails employee = employeeMap.get(name);

            if ((employeeType == 1 && employee instanceof PermanentEmployee) ||
                    (employeeType == 2 && employee instanceof PartTimeEmployee) ||
                    (employeeType == 3 && employee instanceof ContractEmployee)) {
                employeeMap.remove(name);
                System.out.println("Employee removed.");
            } else {
                System.out.println("Invalid employee type for removal.");
            }
        } else {
            System.out.println("Employee with name " + name + " not found.");
        }
    }

    public void listEmployeesByType(int employeeType) {
        System.out.println("Employees of Type:");
        for (EmployeeDetails employee : employeeMap.values()) {
            if (employeeType == 1 && employee instanceof PermanentEmployee) {
                PermanentEmployee permanentEmployee = (PermanentEmployee) employee;
                System.out.println("Employee found (Permanent):");
                permanentEmployee.displayInfo();
            } else if (employeeType == 2 && employee instanceof PartTimeEmployee) {
                PartTimeEmployee partTimeEmployee = (PartTimeEmployee) employee;
                System.out.println("Employee found (Part-Time):");
                partTimeEmployee.displayInfo();
            } else if (employeeType == 3 && employee instanceof ContractEmployee) {
                ContractEmployee contractEmployee = (ContractEmployee) employee;
                System.out.println("Employee found (Contract):");
                contractEmployee.displayInfo();
            }
        }
    }

    public void searchEmployee(String name, int employeeType) {
        if (employeeMap.containsKey(name)) {
            EmployeeDetails employee = employeeMap.get(name);

            if (employeeType == 1 && employee instanceof PermanentEmployee) {
                PermanentEmployee permanentEmployee = (PermanentEmployee) employee;
                System.out.println("Employee found (Permanent):");
                permanentEmployee.displayInfo();
            } else if (employeeType == 2 && employee instanceof PartTimeEmployee) {
                PartTimeEmployee partTimeEmployee = (PartTimeEmployee) employee;
                System.out.println("Employee found (Part-Time):");
                partTimeEmployee.displayInfo();
            } else if (employeeType == 3 && employee instanceof ContractEmployee) {
                ContractEmployee contractEmployee = (ContractEmployee) employee;
                System.out.println("Employee found (Contract):");
                contractEmployee.displayInfo();
            } else {
                System.out.println("Invalid employee type for search.");
                return;
            }
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
                    System.out.print("Enter the Employee Type (1. Permanent, 2. Part-Time, 3. Contract): ");
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
                    System.out.print("Enter the Employee Type (1. Permanent, 2. Part-Time, 3. Contract): ");
                    int modifyEmployeeType = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Enter the name of the employee to modify: ");
                    String nameToModify = scanner.nextLine();
                    System.out.print("Enter the new employee Name: ");
                    String newModifyName = scanner.nextLine();
                    System.out.print("Enter the new employee ID: ");
                    int newId = scanner.nextInt();

                    employeeSystem.modifyEmployee(nameToModify, newModifyName, newId, modifyEmployeeType);
                    break;
                case 3:
                    System.out.print("Enter the Employee Type (1. Permanent, 2. Part-Time, 3. Contract): ");
                    int removeEmployeeType = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Enter the name of the employee to remove: ");
                    String nameToRemove = scanner.nextLine();

                    employeeSystem.removeEmployee(nameToRemove, removeEmployeeType);
                    break;
                case 4:
                    System.out.print(
                            "Select the Employee Type for display the details (1. Permanent, 2. Part-Time, 3. Contract): ");
                    int listEmployeeType = scanner.nextInt();
                    scanner.nextLine();

                    employeeSystem.listEmployeesByType(listEmployeeType);
                    break;

                case 5:
                    System.out.print("Select the Employee Type (1. Permanent, 2. Part-Time, 3. Contract): ");
                    int searchEmployeeType = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Enter the name of the employee to search: ");
                    String nameToSearch = scanner.nextLine();

                    employeeSystem.searchEmployee(nameToSearch, searchEmployeeType);
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
