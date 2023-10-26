import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;

public class MapCopy {
    public static void main(String[] args) {
        Map<String, String> sourceMap = new HashMap<>();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.print("Enter a key (or type 'exit' to stop): ");
            String key = sc.nextLine();

            if (key.equalsIgnoreCase("exit")) {
                break;
            }

            System.out.print("Enter a value: ");
            String value = sc.nextLine();

            sourceMap.put(key, value);
        }

        System.out.println("Source Map:" + sourceMap);

        System.out.println("Copy the all of the mapping from SouceMap to DestinationMap:");
        Map<String, String> destinationMap = new HashMap<>();

        for (Map.Entry<String, String> entry : sourceMap.entrySet()) {
            destinationMap.put(entry.getKey(), entry.getValue());
        }

        System.out.println("Destination Map: " + destinationMap);

    }
}
