import java.sql.*;
import java.util.Scanner;

public class StudentService {

    public static void registerStudent(Scanner sc) {
        try (Connection con = DBConnection.getConnection()) {
            System.out.print("Name: ");
            String name = sc.nextLine();
            System.out.print("Age: ");
            int age = sc.nextInt();
            sc.nextLine();
            System.out.print("Gender: ");
            String gender = sc.nextLine();
            System.out.print("Phone: ");
            String phone = sc.nextLine();
            System.out.print("Address: ");
            String address = sc.nextLine();

            String sql = "INSERT INTO students (name, age, gender, phone, address) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, name);
            ps.setInt(2, age);
            ps.setString(3, gender);
            ps.setString(4, phone);
            ps.setString(5, address);
            ps.executeUpdate();

            System.out.println("Student registered.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void viewStudents() {
        try (Connection con = DBConnection.getConnection();
             Statement stmt = con.createStatement()) {

            ResultSet rs = stmt.executeQuery("SELECT * FROM students");
            System.out.printf("\n%-5s %-20s %-5s %-10s %-15s %-30s\n", "ID", "Name", "Age", "Gender", "Phone", "Address");
            while (rs.next()) {
                System.out.printf("%-5d %-20s %-5d %-10s %-15s %-30s\n",
                        rs.getInt("student_id"),
                        rs.getString("name"),
                        rs.getInt("age"),
                        rs.getString("gender"),
                        rs.getString("phone"),
                        rs.getString("address"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
