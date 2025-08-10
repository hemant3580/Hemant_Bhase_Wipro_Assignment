// Assignment 4: Inner Class Encapsulation: Secure Locker
package AssignmentDay5;

public class Assignment4 {
	public static void main(String[] args) {
		Locker l = new Locker("L123", "pass");
		System.out.println("Locked: " + l.isLocked());
		l.unlock("pass");
		System.out.println("Locked: " + l.isLocked());
	}
}

class Locker {
	private String lockerId;
	private boolean isLocked;
	private String passcode;

	public Locker(String lockerId, String passcode) {
		this.lockerId = lockerId;
		this.passcode = passcode;
		this.isLocked = true;
	}

	private class SecurityManager {
		private boolean verify(String code) {
			return passcode.equals(code);
		}
	}

	public void lock() {
		isLocked = true;
	}

	public void unlock(String code) {
		SecurityManager sm = new SecurityManager();
		if (sm.verify(code)) {
			isLocked = false;
		}
	}

	public boolean isLocked() {
		return isLocked;
	}
}
