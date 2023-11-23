interface Add {
    // public void add();
    public void add(int sum, int b);
    // public int add(int a, int b);

}

public class Lambda {
    public static void main(String[] args) {
        // Add ad = () -> System.out.println("Hello world");
        // ad.add();

        // Add ad = (sum) -> System.out.println(sum);
        // ad.add(20);

        // Add ad = (a, b) -> a + b;
        // System.out.println(ad.add(3, 6));

        Add ad = (a, b) -> {
            if (a > b) {
                throw new IllegalArgumentException("a should be less than or equal to b");
            } else {
                System.out.println(a + b);
            }
        };
        ad.add(20, 40);
    }
}
