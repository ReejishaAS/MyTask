import java.util.*;
import java.util.stream.Collectors;

class StudentInfo {
    int id;
    String firstName;
    float cgpa;

    public StudentInfo(int id, String firstName, float cgpa) {
        this.id = id;
        this.firstName = firstName;
        this.cgpa = cgpa;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public float getCgpa() {
        return cgpa;
    }

    public String toString() {
        return firstName;
    }
}

public class Students {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number of students: ");
        int input = sc.nextInt();

        List<StudentInfo> studentList = new ArrayList<>();

        for (int i = 0; i < input; i++) {
            System.out.println("Enter the id of student: ");
            int id = sc.nextInt();

            System.out.println("Enter the student name: ");
            String firstName = sc.next();

            System.out.println("Enter the cgpa: ");
            float cgpa = sc.nextFloat();

            studentList.add(new StudentInfo(id, firstName, cgpa));
        }

        List<StudentInfo> sortedList = studentList.stream()
                .sorted(Comparator
                        .comparingDouble(StudentInfo::getCgpa)
                        .reversed()
                        .thenComparing(StudentInfo::getFirstName)
                        .thenComparingInt(StudentInfo::getId))
                .collect(Collectors.toList());

        sortedList.forEach(System.out::println);
    }
}

// 33 Rumpa 3.68
// 85 Ashis 3.85
// 56 Samiha 3.75
// 19 Samara 3.75
// 22 Fahim 3.76
