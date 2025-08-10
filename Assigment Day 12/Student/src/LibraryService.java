import java.sql.*;
import java.util.Scanner;

public class LibraryService {

    public static void addBook(Scanner sc) {
        try (Connection con = DBConnection.getConnection()) {
            System.out.print("Title: ");
            String title = sc.nextLine();
            System.out.print("Author: ");
            String author = sc.nextLine();
            System.out.print("Total Copies: ");
            int totalCopies = sc.nextInt();
            sc.nextLine();

            String sql = "INSERT INTO library (title, author, total_copies) VALUES (?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, title);
            ps.setString(2, author);
            ps.setInt(3, totalCopies);
            ps.executeUpdate();

            System.out.println("Book added.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void viewBooks() {
        try (Connection con = DBConnection.getConnection();
             Statement stmt = con.createStatement()) {
            ResultSet rs = stmt.executeQuery("SELECT * FROM library");
            System.out.printf("\n%-5s %-30s %-25s %-10s\n", "ID", "Title", "Author", "Copies");
            while (rs.next()) {
                System.out.printf("%-5d %-30s %-25s %-10d\n",
                        rs.getInt("book_id"),
                        rs.getString("title"),
                        rs.getString("author"),
                        rs.getInt("total_copies"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void borrowBook(Scanner sc) {
        try (Connection con = DBConnection.getConnection()) {
            System.out.print("Student ID: ");
            int studentId = sc.nextInt();
            System.out.print("Book ID: ");
            int bookId = sc.nextInt();
            sc.nextLine();
            System.out.print("Borrow Date (YYYY-MM-DD): ");
            String borrowDate = sc.nextLine();

            String sql = "INSERT INTO borrowed_books (student_id, book_id, borrow_date) VALUES (?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, studentId);
            ps.setInt(2, bookId);
            ps.setDate(3, Date.valueOf(borrowDate));
            ps.executeUpdate();

            System.out.println("Book borrowed.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void viewBorrowedBooks() {
        try (Connection con = DBConnection.getConnection();
             Statement stmt = con.createStatement()) {
            String sql = "SELECT bb.borrow_id, s.name, l.title, bb.borrow_date, bb.return_date " +
                    "FROM borrowed_books bb " +
                    "JOIN students s ON bb.student_id = s.student_id " +
                    "JOIN library l ON bb.book_id = l.book_id";
            ResultSet rs = stmt.executeQuery(sql);

            System.out.printf("\n%-5s %-20s %-30s %-12s %-12s\n", "ID", "Student", "Book Title", "Borrow Date", "Return Date");
            while (rs.next()) {
                String returnDate = rs.getDate("return_date") != null ? rs.getDate("return_date").toString() : "Not Returned";
                System.out.printf("%-5d %-20s %-30s %-12s %-12s\n",
                        rs.getInt("borrow_id"),
                        rs.getString("name"),
                        rs.getString("title"),
                        rs.getDate("borrow_date").toString(),
                        returnDate);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
