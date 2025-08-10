package AssignmentDay9;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Assignment7 {

    static class Product {
        String name;
        double price;

        Product(String name, double price) {
            this.name = name;
            this.price = price;
        }

        public double getPrice() {
            return price;
        }

        @Override
        public String toString() {
            return name + " - " + price;
        }
    }

    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();
        products.add(new Product("TV", 40000));
        products.add(new Product("Fridge", 25000));
        products.add(new Product("AC", 35000));

        System.out.println("Original list:");
        products.forEach(System.out::println);

        // Price ascending
        products.sort(Comparator.comparingDouble(p -> p.price));
        System.out.println("\nSorted by Price ascending:");
        products.forEach(System.out::println);

        // Price descending
        products.sort(Comparator.comparingDouble(Product::getPrice).reversed());
        System.out.println("\nSorted by Price descending:");
        products.forEach(System.out::println);

        // Name alphabetically
        products.sort(Comparator.comparing(p -> p.name));
        System.out.println("\nSorted by Name alphabetically:");
        products.forEach(System.out::println);
    }
}
