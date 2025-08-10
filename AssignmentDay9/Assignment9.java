package AssignmentDay9;

// Q9: Sort list of cities by population using Comparator
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Assignment9 {

    static class City {
        String name;
        int population;

        City(String name, int population) {
            this.name = name;
            this.population = population;
        }

        @Override
        public String toString() {
            return name + " - " + population;
        }
    }

    public static void main(String[] args) {
        List<City> cities = new ArrayList<>();
        cities.add(new City("Mumbai", 20411000));
        cities.add(new City("Delhi", 16787941));
        cities.add(new City("Bangalore", 8436675));

        System.out.println("Before sorting:");
        cities.forEach(System.out::println);

        cities.sort(Comparator.comparingInt(c -> c.population));

        System.out.println("\nAfter sorting (by population ascending):");
        cities.forEach(System.out::println);
    }
}
