package AssignmentDay9;

// Q2: Sort list of Products by price ascending using Comparable
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Assignment2 {

    static class Product implements Comparable<Product> {
        String name;
        double price;

        Product(String name, double price) {
            this.name = name;
            this.price = price;
        }

        @Override
        public int compareTo(Product o) {
            return Double.compare(this.price, o.price);
        }

        @Override
        public String toString() {
            return name + " - " + price;
        }
    }

    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();
        products.add(new Product("Laptop", 80000));
        products.add(new Product("Phone", 30000));
        products.add(new Product("Tablet", 25000));

        System.out.println("Before sorting (by price):");
        products.forEach(System.out::println);

        Collections.sort(products);

        System.out.println("\nAfter sorting (by price ascending):");
        products.forEach(System.out::println);
    }
}
