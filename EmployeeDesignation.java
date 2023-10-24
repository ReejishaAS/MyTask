import java.util.Scanner;

public class EmployeeDesignation {
    String name;
    int type;

    public static void Designation(String name) {
        System.out.println(name + " details:");

    }

    public static void main(String[] args) {
        EmployeeDesignation d = new EmployeeDesignation();

        Scanner sc = new Scanner(System.in);
        String name;
        int type;

        System.out.println(" Enter the Employee Name: ");
        name = sc.nextLine();
        d.Designation(name);
        System.out.println("Enter the Employee type: 1.Manager 2.Programmer 3.Tester");
        type = sc.nextInt();

        switch (type) {
            case 1:
                Manager d1 = new Manager();
                d1.Designation(name);
                break;
            case 2:
                Programmer d2 = new Programmer();
                d2.Designation(name);
                break;
            case 3:
                Tester d3 = new Tester();
                d3.Designation(name);
                break;
            default:
                System.out.println("No designation found!!!!!");
                break;
        }

    }
}

class Manager extends EmployeeDesignation {
    public static void Designation(String name) {

        System.out.println("Manager");
        System.out.println(name + " designation is Manager ");
    }
}

class Programmer extends EmployeeDesignation {
    public static void Designation(String name) {

        System.out.println("Programmer");
        System.out.println(name + " designation is Programmer ");

    }

}

class Tester extends EmployeeDesignation {
    public static void Designation(String name) {

        System.out.println("Tester");
        System.out.println(name + " designation is Tester ");

    }

}