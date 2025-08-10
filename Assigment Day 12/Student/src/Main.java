import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Username: ");
        String username = sc.nextLine();
        System.out.print("Password: ");
        String password = sc.nextLine();

        if (!LoginService.login(username, password)) {
            System.out.println("Login failed.");
            sc.close();
            return;
        }

        while (true) {
            System.out.println("\nStudent Management Menu");
            System.out.println("1. Register Student");
            System.out.println("2. View Students");
            System.out.println("3. Pay Fees");
            System.out.println("4. View Fees");
            System.out.println("5. Add Book");
            System.out.println("6. View Books");
            System.out.println("7. Borrow Book");
            System.out.println("8. View Borrowed Books");
            System.out.println("9. Exit");
            System.out.print("Choose option: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> StudentService.registerStudent(sc);
                case 2 -> StudentService.viewStudents();
                case 3 -> FeesService.payFees(sc);
                case 4 -> FeesService.viewFees();
                case 5 -> LibraryService.addBook(sc);
                case 6 -> LibraryService.viewBooks();
                case 7 -> LibraryService.borrowBook(sc);
                case 8 -> LibraryService.viewBorrowedBooks();
                case 9 -> {
                    System.out.println("Goodbye!");
                    sc.close();
                    return;
                }
                default -> System.out.println("Invalid option");
            }
        }
    }
}
