package AssignmentDay7;

import java.util.*;
import java.util.concurrent.*;
import java.time.LocalTime;

class WrapperTasks {
	void checkDigit() {
		char ch = '5';
		System.out.println("Is digit: " + Character.isDigit(ch));
	}

	void compareStrings() {
		String a = "Java";
		String b = "Java";
		System.out.println("Strings equal: " + a.equals(b));
	}

	void convertUsingValueOf() {
		int num = 100;
		String str = String.valueOf(num);
		System.out.println("ValueOf: " + str);
	}

	void booleanWrapperUsage() {
		Boolean bool = Boolean.TRUE;
		System.out.println("Boolean: " + bool);
	}

	void nullToWrapper() {
		Integer val = null;
		System.out.println("Null wrapper: " + val);
	}
}

class PassByValueRef {
	void changePrimitive(int num) {
		num += 10;
		System.out.println("Changed inside method: " + num);
	}

	void swap(int x, int y) {
		int temp = x;
		x = y;
		y = temp;
		System.out.println("Inside swap: x=" + x + ", y=" + y);
	}

	void passPrimitive(int val) {
		val = 50;
		System.out.println("Inside method: " + val);
	}

	void modifyBox(Box box) {
		box.length = 20;
	}

	void updateStudent(Student s) {
		s.marks = 95;
	}

	void assignNewObj(Student s) {
		s = new Student("Changed", 0);
	}

	void simulateRefWithArray(int[] arr) {
		arr[0] = 999;
	}
}

class Box {
	int length = 10;
}

class Student {
	String name;
	int marks;
	Student(String n, int m) {
		name = n;
		marks = m;
	}
}

class MyThread1 extends Thread {
	public void run() {
		for (int j = 1; j <= 5; j++)
			System.out.println("Thread1: " + j);
	}
}

class MyRunnable implements Runnable {
	public void run() {
		System.out.println("Runnable Thread: " + Thread.currentThread().getName());
	}
}

class EvenThread extends Thread {
	public void run() {
		for (int n = 0; n <= 10; n += 2)
			System.out.println("Even: " + n);
	}
}

class OddThread extends Thread {
	public void run() {
		for (int n = 1; n <= 10; n += 2)
			System.out.println("Odd: " + n);
	}
}

class JoinExample extends Thread {
	public void run() {
		System.out.println("Join thread started");
	}
}

class StopThread extends Thread {
	volatile boolean running = true;
	public void run() {
		while (running) {
			System.out.println("Running...");
			try { Thread.sleep(500); } catch (Exception e) {}
		}
		System.out.println("Stopped");
	}
	public void stopThread() {
		running = false;
	}
}

class Counter {
	int count = 0;
	void increment() { count++; }
}

class SyncCounter {
	int count = 0;
	synchronized void increment() { count++; }
}

class BankAccountSync {
	int balance = 1000;
	synchronized void deposit(int amt) {
		balance += amt;
		System.out.println("Deposited: " + amt + ", Balance: " + balance);
	}
	synchronized void withdraw(int amt) {
		if (balance >= amt) {
			balance -= amt;
			System.out.println("Withdrawn: " + amt + ", Balance: " + balance);
		} else {
			System.out.println("Insufficient Balance");
		}
	}
}

class ProducerConsumer {
	int value;
	boolean available = false;

	synchronized void produce(int val) throws InterruptedException {
		while (available) wait();
		value = val;
		available = true;
		System.out.println("Produced: " + value);
		notify();
	}

	synchronized int consume() throws InterruptedException {
		while (!available) wait();
		available = false;
		System.out.println("Consumed: " + value);
		notify();
		return value;
	}
}

class AZPrinter {
	Object lock = new Object();
	boolean printLetter = true;
	
	void printLetter() {
		for (char ch = 'A'; ch <= 'Z'; ch++) {
			synchronized(lock) {
				while (!printLetter) {
					try { lock.wait(); } catch (InterruptedException e) {}
				}
				System.out.println(ch);
				printLetter = false;
				lock.notify();
			}
		}
	}
	
	void printNumber() {
		for (int j = 1; j <= 26; j++) {
			synchronized(lock) {
				while (printLetter) {
					try { lock.wait(); } catch (InterruptedException e) {}
				}
				System.out.println(j);
				printLetter = true;
				lock.notify();
			}
		}
	}
}

class DaemonClock extends Thread {
	public void run() {
		while (!Thread.currentThread().isInterrupted()) {
			System.out.println("Time: " + LocalTime.now());
			try { Thread.sleep(1000); } catch (InterruptedException e) {
				break;
			}
		}
		System.out.println("Daemon thread exiting.");
	}
}

class MultiplyTask implements Callable<Integer> {
	public Integer call() {
		return 5 * 4;
	}
}

public class Assignment1 {
	public static void main(String[] args) throws Exception {
		WrapperTasks wt = new WrapperTasks();
		wt.checkDigit();
		wt.compareStrings();
		wt.convertUsingValueOf();
		wt.booleanWrapperUsage();
		wt.nullToWrapper();

		PassByValueRef ref = new PassByValueRef();
		int val = 10;
		System.out.println("Before change: " + val);
		ref.changePrimitive(val);
		System.out.println("After change: " + val);
		ref.swap(10, 20);
		ref.passPrimitive(val);

		Box box = new Box();
		ref.modifyBox(box);
		System.out.println("Box length: " + box.length);

		Student st = new Student("John", 90);
		ref.updateStudent(st);
		System.out.println("Student Marks: " + st.marks);
		ref.assignNewObj(st);
		System.out.println("Student still same: " + st.name);

		int[] arr = {1};
		ref.simulateRefWithArray(arr);
		System.out.println("Modified array: " + arr[0]);

		new MyThread1().start();
		new Thread(new MyRunnable()).start();

		Thread msg1 = new Thread(() -> {
			for (int j = 0; j < 5; j++)
				System.out.println("Message 1");
		});
		Thread msg2 = new Thread(() -> {
			for (int j = 0; j < 5; j++)
				System.out.println("Message 2");
		});
		msg1.start(); msg2.start();

		Thread sleepThread = new Thread(() -> {
			for (int j = 1; j <= 3; j++) {
				System.out.println(j);
				try { Thread.sleep(1000); } catch (Exception e) {}
			}
		});
		sleepThread.start();

		Thread yieldThread1 = new Thread(() -> {
			Thread.yield();
			System.out.println("Yielded");
		});
		yieldThread1.start();

		new EvenThread().start();
		new OddThread().start();

		Thread high = new Thread(() -> System.out.println("High priority"));
		high.setPriority(Thread.MAX_PRIORITY);
		high.start();

		JoinExample jex = new JoinExample();
		jex.start();
		jex.join();
		System.out.println("Main resumes");

		StopThread st1 = new StopThread();
		st1.start();
		Thread.sleep(1500);
		st1.stopThread();

		Counter c = new Counter();
		Thread r1 = new Thread(() -> {
			for (int j = 0; j < 1000; j++) c.increment();
		});
		Thread r2 = new Thread(() -> {
			for (int j = 0; j < 1000; j++) c.increment();
		});
		r1.start(); r2.start(); r1.join(); r2.join();
		System.out.println("Race count: " + c.count);

		SyncCounter sc = new SyncCounter();
		Thread s1 = new Thread(() -> {
			for (int j = 0; j < 1000; j++) sc.increment();
		});
		Thread s2 = new Thread(() -> {
			for (int j = 0; j < 1000; j++) sc.increment();
		});
		s1.start(); s2.start(); s1.join(); s2.join();
		System.out.println("Sync count: " + sc.count);

		BankAccountSync bas = new BankAccountSync();
		Thread dep = new Thread(() -> bas.deposit(500));
		Thread with = new Thread(() -> bas.withdraw(700));
		dep.start(); with.start();

		ProducerConsumer pc = new ProducerConsumer();
		Thread prod = new Thread(() -> {
			try { pc.produce(10); } catch (Exception e) {}
		});
		Thread cons = new Thread(() -> {
			try { pc.consume(); } catch (Exception e) {}
		});
		prod.start(); cons.start();

		AZPrinter printer = new AZPrinter();
		Thread letter = new Thread(() -> printer.printLetter());
		Thread number = new Thread(() -> printer.printNumber());
		letter.start(); number.start();
		letter.join(); number.join();

		DaemonClock dc = new DaemonClock();
		dc.setDaemon(true);
		dc.start();
		Thread.sleep(3000);
		dc.interrupt();

		Thread status = new Thread(() -> System.out.println("Check alive"));
		System.out.println("Alive before start: " + status.isAlive());
		status.start();
		status.join();
		System.out.println("Alive after finish: " + status.isAlive());

		ThreadGroup group = new ThreadGroup("Group1");
		Thread g1 = new Thread(group, () -> System.out.println("In group 1"));
		g1.start();

		ExecutorService exec = Executors.newSingleThreadExecutor();
		Future<Integer> result = exec.submit(new MultiplyTask());
		System.out.println("Callable Result: " + result.get());
		exec.shutdown();
	}
}
