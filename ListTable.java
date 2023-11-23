import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

class Product {
    int si;
    String name;
    float salary;

    public Product(int si, String name, float salary) {
        this.si = si;
        this.name = name;
        this.salary = salary;
    }
}

public class ListTable {
    public static void main(String[] args) {
        List<Product> productList = new ArrayList<Product>();

        productList.add(new Product(1, "Ami", 28000f));
        productList.add(new Product(2, "Ravi", 30000f));
        productList.add(new Product(3, "Devi", 40000f));

        System.out.println("Sorting Employee list on the basis of name:");

        Collections.sort(productList, (e1, e2) -> e1.name.compareTo(e2.name));

        for (Product e : productList) {
            System.out.println(e.si + " " + e.name + " " + e.salary);
        }
    }
}
