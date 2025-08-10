package AssignmentDay9;

// Q25: Deserialize Student object from student.ser and display
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Assignment25 {

    static class Student implements java.io.Serializable {
        int id;
        String name;
        double marks;

        @Override
        public String toString() {
            return "Student{" + "id=" + id + ", name='" + name + '\'' + ", marks=" + marks + '}';
        }
    }

    public static void main(String[] args) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("student.ser"))) {
            Student s = (Student) ois.readObject();
            System.out.println("Deserialized Student object:");
            System.out.println(s);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
