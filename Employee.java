import java.util.Scanner;

public class Employee {
    String employeename;
    int employeeage;
    float employeesalary;

    void setdata(String name, int age, float salary) {

        employeename = name;
        employeeage = age;
        employeesalary = salary;

    }

    void displaydata() {
        System.out.println("Emplyee name is " + employeename);
        System.out.println("Emplyee age is " + employeeage);
        System.out.println("Employee salary is " + employeesalary);
    }

    public static void main(String[] args) {
        Employee e = new Employee();
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the Employee name");
        String name = sc.nextLine();

        System.out.println("Enter the Employee age");
        int age = sc.nextInt();

        System.out.println("Enter the Employee salary");
        Float salary = sc.nextFloat();

        e.setdata(name, age, salary);
        e.displaydata();

    }
}