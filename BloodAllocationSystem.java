import java.util.*;

class Donor {
    String donorName;
    int phoneNumber;
    String bloodGroup;

    public Donor(String donorName, int phoneNumber, String bloodGroup) {
        this.donorName = donorName;
        this.phoneNumber = phoneNumber;
        this.bloodGroup = bloodGroup;
    }
}

class Patient {
    String patientName;
    String patientPriority;
    int unitsNeeded;
    String bloodGroup;

    public Patient(String patientName, String patientPriority, int unitsNeeded, String bloodGroup) {
        this.patientName = patientName;
        this.patientPriority = patientPriority;
        this.unitsNeeded = unitsNeeded;
        this.bloodGroup = bloodGroup;
    }
}

class BloodBank {
    Map<String, Queue<Donor>> donors = new HashMap<>();
    List<Patient> patients = new ArrayList<>();
    Map<String, Integer> bloodReserve = new HashMap<>();

    public BloodBank() {
        bloodReserve.put("A", 5);
        bloodReserve.put("AB", 3);
        bloodReserve.put("B", 1);
        bloodReserve.put("O", 4);
    }

    public void addDonor(Donor donor) {
        donors.computeIfAbsent(donor.getBloodGroup(), d -> new LinkedList<>()).add(donor);
    }

    public void addPatient(Patient patient) {
        patients.add(patient);

        String bloodGroup = getPriorityBloodGroup(patient.patientPriority);
        int unitsNeeded = patient.unitsNeeded;

        Queue<Donor> donorQueue = donors.get(bloodGroup);
        if (donorQueue != null) {
            while (unitsNeeded > 0 && !donorQueue.isEmpty()) {
                Donor donor = donorQueue.poll();
                System.out
                        .println("Patient: " + patient.patientName + " received 1 unit from Donor: " + donor.donorName);
                unitsNeeded--;
            }
        }

        if (unitsNeeded > 0) {
            int reserve = bloodReserve.get(bloodGroup);
            if (unitsNeeded <= reserve) {
                System.out.println(
                        "Patient: " + patient.patientName + " received " + unitsNeeded + " units from Blood Reserve.");
                bloodReserve.put(bloodGroup, reserve - unitsNeeded);
            } else {
                System.out.println("Insufficient blood units available for Patient: " + patient.patientName);
            }
        }
    }

    /// private String getPriorityBloodGroup(String priority) {

    // switch (priority) {
    // case "P1":
    // return "A";
    // case "P2":
    // return "AB";
    // case "P3":
    // return "B";
    // case "P4":
    // case "P5":
    // return "O";
    // case "P6":
    // case "P7":
    // case "P8":
    // case "P9":
    // case "P10":

    // default:
    // return "O";
    // }
    // }
}

public class BloodAllocationSystem {
    public static void main(String[] args) {
        BloodBank bloodBank = new BloodBank();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("Entry details:\n 1.Add Donor\n 2.Add Patient\n 3.Exit");
            System.out.println("Enter your choice:");
            int ch = sc.nextInt();
            sc.nextLine();
            switch (ch) {
                case 1:
                    System.out.println("Donor Name: ");
                    String donorName = sc.nextLine();
                    System.out.println("Phone number: ");
                    int phoneNumber = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Blood group: ");
                    String bloodGroup = sc.nextLine();
                    bloodBank.addDonor(new Donor(donorName, phoneNumber, bloodGroup));
                    break;
                case 2:
                    System.out.println("Patient Name: ");
                    String patientName = sc.nextLine();
                    System.out.println("Priority: ");
                    String patientPriority = sc.nextLine();
                    System.out.println("Units need: ");
                    int units = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Blood group: ");
                    String patientBloodGroup = sc.nextLine();
                    bloodBank.addPatient(new Patient(patientName, patientPriority, units, patientBloodGroup));
                    break;
                case 3:
                    System.out.println("Exit");
                    sc.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }
}
