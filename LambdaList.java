import java.util.*;

public class LambdaList {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        list.forEach(
                (n) -> System.out.println(n));

    }
}