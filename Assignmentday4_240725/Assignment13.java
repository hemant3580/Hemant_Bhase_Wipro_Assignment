package Assignmentday4_240725;

/*4. 

Design an abstract class Person with fields like name, age, and abstract method getRoleInfo(). 
Create subclasses: 

Student: has course and roll number. 

Professor: has subject and salary. 

TeachingAssistant: extends Student and implements getRoleInfo() in a hybrid way. 

Create and print info for all roles using overridden getRoleInfo(). */
abstract class Person {
    String name;
    int age;

    abstract void getRoleInfo();
}

class Student extends Person {
    String course;
    int rollNo;

    void getRoleInfo() {
        System.out.println("Student: " + course + " " + rollNo);
    }
}

class Professor extends Person {
    String subject;
    double salary;

    void getRoleInfo() {
        System.out.println("Professor: " + subject + " " + salary);
    }
}

class TeachingAssistant extends Student {
    void getRoleInfo() {
        System.out.println("Teaching Assistant: " + course + " " + rollNo);
    }
}

public class Assignment13 {
    public static void main(String[] args) {
        Person p1 = new Student();
        ((Student)p1).course = "AI";
        ((Student)p1).rollNo = 101;
        p1.getRoleInfo();

        Person p2 = new Professor();
        ((Professor)p2).subject = "Math";
        ((Professor)p2).salary = 50000;
        p2.getRoleInfo();

        Person p3 = new TeachingAssistant();
        ((TeachingAssistant)p3).course = "DSA";
        ((TeachingAssistant)p3).rollNo = 202;
        p3.getRoleInfo();
    }
}
