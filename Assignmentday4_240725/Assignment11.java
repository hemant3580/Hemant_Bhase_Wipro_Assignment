package Assignmentday4_240725;

/*2.Design an interface Bank with methods deposit(), withdraw(), and getBalance(). 
Implement this in SavingsAccount and CurrentAccount classes. 

Use inheritance to create a base Account class. 

Demonstrate method overriding with customized logic for withdrawal (e.g., minimum balance in SavingsAccount). 

Shape */
interface Bank1 {
    void deposit(double amount);
    void withdraw(double amount);
    double getBalance();
}

class Account {
    double balance = 0;
}

class SavingsAccount extends Account implements Bank1 {
    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) {
        if (balance - amount >= 500) {
            balance -= amount;
        } else {
            System.out.println("Minimum balance required");
        }
    }

    public double getBalance() {
        return balance;
    }
}

class CurrentAccount extends Account implements Bank1 {
    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) {
        balance -= amount;
    }

    public double getBalance() {
        return balance;
    }
}

public class Assignment11 {
    public static void main(String[] args) {
        Bank1 b1 = new SavingsAccount();
        b1.deposit(1000);
        b1.withdraw(600);
        System.out.println(b1.getBalance());

        Bank1 b2 = new CurrentAccount();
        b2.deposit(2000);
        b2.withdraw(1500);
        System.out.println(b2.getBalance());
    }
}
