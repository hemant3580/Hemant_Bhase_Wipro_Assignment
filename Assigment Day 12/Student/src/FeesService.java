import java.sql.*;
import java.util.Scanner;

public class FeesService {

    public static void payFees(Scanner sc) {
        try (Connection con = DBConnection.getConnection()) {
            System.out.print("Student ID: ");
            int studentId = sc.nextInt();
            System.out.print("Amount: ");
            double amount = sc.nextDouble();
            sc.nextLine(); // consume newline
            System.out.print("Payment Date (YYYY-MM-DD): ");
            String date = sc.nextLine();
            System.out.print("Status (Paid/Pending): ");
            String status = sc.nextLine();

            String sql = "INSERT INTO fees (student_id, amount, payment_date, status) VALUES (?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, studentId);
            ps.setDouble(2, amount);
            ps.setDate(3, Date.valueOf(date));
            ps.setString(4, status);
            ps.executeUpdate();

            System.out.println("Fees record added.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void viewFees() {
        try (Connection con = DBConnection.getConnection();
             Statement stmt = con.createStatement()) {
            ResultSet rs = stmt.executeQuery(
                    "SELECT f.fee_id, s.name, f.amount, f.payment_date, f.status " +
                    "FROM fees f JOIN students s ON f.student_id = s.student_id");

            System.out.printf("\n%-5s %-20s %-10s %-12s %-10s\n", "FeeID", "Student Name", "Amount", "Date", "Status");
            while (rs.next()) {
                System.out.printf("%-5d %-20s %-10.2f %-12s %-10s\n",
                        rs.getInt("fee_id"),
                        rs.getString("name"),
                        rs.getDouble("amount"),
                        rs.getDate("payment_date").toString(),
                        rs.getString("status"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
