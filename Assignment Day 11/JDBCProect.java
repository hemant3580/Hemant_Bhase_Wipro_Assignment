package MiniProject;
import java.sql.*;

public class JDBCProect {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydb";
        String user = "root";
        String password = "1234";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, password);
            Statement stmt = con.createStatement();

            // 1. Create table
            String create = "create table if not exists student (" +
                            "rollno int PRIMARY KEY, " +
                            "name varchar(50), " +
                            "per int, " +
                            "city varchar(50))";
            stmt.executeUpdate(create);
            System.out.println("table created");

            ResultSet rs = stmt.executeQuery("select * from student");
            System.out.println("rollno\tname\t\tper\tcity");
            while (rs.next()) {
                System.out.println(rs.getInt("rollno") + "\t" +
                                   rs.getString("name") + "\t" +
                                   rs.getInt("per") + "\t" +
                                   rs.getString("city"));
            }
            rs.close();

            // 2. Insert records
            stmt.executeUpdate("delete from student");
            stmt.executeUpdate("insert into student values (101, 'Rahul Sharma', 85, 'Pune')");
            stmt.executeUpdate("insert into student values (102, 'Priya Singh', 90, 'Delhi')");
            stmt.executeUpdate("insert into student values (103, 'Amit Kumar', 72, 'Pune')");
            stmt.executeUpdate("insert into student values (104, 'Sneha Patel', 82, 'Mumbai')");
            stmt.executeUpdate("insert into student values (105, 'Ravi Gupta', 100, 'Delhi')");
            System.out.println("records inserted");

            rs = stmt.executeQuery("select * from student");
            System.out.println("rollno\tname\t\tper\tcity");
            while (rs.next()) {
                System.out.println(rs.getInt("rollno") + "\t" +
                                   rs.getString("name") + "\t" +
                                   rs.getInt("per") + "\t" +
                                   rs.getString("city"));
            }
            rs.close();

            // 4. Update table
            stmt.executeUpdate("update student set per = 95 where rollno = 101");
            System.out.println("record updated");

            rs = stmt.executeQuery("select * from student");
            System.out.println("rollno\tname\t\tper\tcity");
            while (rs.next()) {
                System.out.println(rs.getInt("rollno") + "\t" +
                                   rs.getString("name") + "\t" +
                                   rs.getInt("per") + "\t" +
                                   rs.getString("city"));
            }
            rs.close();

            ResultSet rs2 = stmt.executeQuery("select max(per) as maxper from student");
            int maxPer = 0;
            if (rs2.next()) maxPer = rs2.getInt("maxper");
            rs2.close();

            ResultSet rs3 = stmt.executeQuery("select * from student where per = " + maxPer);
            System.out.println("Students with highest percentage:");
            while (rs3.next()) {
                System.out.println(rs3.getInt("rollno") + " " + rs3.getString("name") +
                        " " + rs3.getInt("per") + " " + rs3.getString("city"));
            }
            rs3.close();

            // 6. Arrange records in ascending order (by per)
            ResultSet rs4 = stmt.executeQuery("select * from student order by per ASC");
            System.out.println("Records in ascending order of percentage:");
            while (rs4.next()) {
                System.out.println(rs4.getInt("rollno") + " " + rs4.getString("name") +
                        " " + rs4.getInt("per") + " " + rs4.getString("city"));
            }
            rs4.close();

            // 7. Find all students from Pune
            ResultSet rs5 = stmt.executeQuery("select * from student where city = 'Pune'");
            System.out.println("Students from Pune:");
            while (rs5.next()) {
                System.out.println(rs5.getInt("rollno") + " " + rs5.getString("name") +
                        " " + rs5.getInt("per") + " " + rs5.getString("city"));
            }
            rs5.close();

            // 8. add a new column
            stmt.executeUpdate("alter table student add column email varchar(50)");
            System.out.println("added new column email");

            // 9. Modify column datatype (making per into float)
            stmt.executeUpdate("alter table student modify per float");
            System.out.println("column 'per' datatype changed to float");

            // 10. Change the name of the table
            stmt.executeUpdate("rename table student to student_list");
            System.out.println("table renamed to student_list");

            rs = stmt.executeQuery("select * from student_list");
            System.out.println("rollno\tname\t\tper\tcity\temail");
            while (rs.next()) {
                System.out.println(rs.getInt("rollno") + "\t" +
                                   rs.getString("name") + "\t" +
                                   rs.getFloat("per") + "\t" +
                                   rs.getString("city") + "\t" +
                                   rs.getString("email"));
            }
            rs.close();

            // 11. Delete a column (removed email)
            stmt.executeUpdate("alter table student_list drop column email");
            System.out.println("column email deleted");

            // 12. Delete a single row
            stmt.executeUpdate("delete from student_list where rollno = 103");
            System.out.println("Deleted row with rollno 103");

            rs = stmt.executeQuery("select * from student_list");
            System.out.println("rollno\tname\t\tper\tcity");
            while (rs.next()) {
                System.out.println(rs.getInt("rollno") + "\t" +
                                   rs.getString("name") + "\t" +
                                   rs.getFloat("per") + "\t" +
                                   rs.getString("city"));
            }
            rs.close();

            // 13. Delete all records keep table
            stmt.executeUpdate("delete from student_list");
            System.out.println("all records deleted but table is there");

            rs = stmt.executeQuery("select * from student_list");
            System.out.println("Table after deleting all records:");
            if (!rs.next()) {
                System.out.println("No records found.");
            }
            rs.close();

            // 14. Delete entire table
            stmt.executeUpdate("drop table if exists student_list");
            System.out.println("student_list table dropped");

            stmt.close();
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
