package Assignmentday4_240725;
//Create Hierarchical inheritance for hospital

class Hospital2 {
	Hospital2(String name) {
		System.out.println("Welcome to " + name);
	}
}

class Doctor extends Hospital2{
	Doctor(String name, String specialization) {
		super(name);
		System.out.println(specialization + " Doctor at " + name);
	}
}

class Gynac extends Doctor {
	Gynac(String name) {
		super(name, "Gynecologist");
	}
}

class Endo extends Doctor {
	Endo(String name) {
		super(name, "Endocrinologist");
	}
}

class Cardiac extends Doctor {
	Cardiac(String name) {
		super(name, "Cardiologist");
	}
}

class Operation extends Cardiac {
	Operation(String name) {
		super(name);
		System.out.println("Belongs to Operation Theatre");
	}
}

class Opd extends Cardiac {
	Opd(String name) {
		super(name);
		System.out.println("Belongs to Outpatient Department");
	}
}

class Nurse extends Hospital2 {
	Nurse(String name) {
		super(name);
		System.out.println("Nursing Staff at " + name);
	}
}

class Accountant extends Hospital2 {
	Accountant(String name) {
		super(name);
		System.out.println("Accounts Department at " + name);
	}
}

class Payments extends Accountant {
	Payments(String name) {
		super(name);
		System.out.println("Handles Payments and Billing");
	}
}

class Documentation extends Accountant {
	Documentation(String name) {
		super(name);
		System.out.println("Handles Patient Documentation");
	}
}

public class Assignment5 {
	public static void main(String[] args) {
		String hospitalName = "XYZ Hospital";

		Hospital2 h = new Hospital2(hospitalName);
		Doctor d = new Doctor(hospitalName, "General");
		Gynac g = new Gynac(hospitalName);
		Endo e = new Endo(hospitalName);
		Cardiac c = new Cardiac(hospitalName);
		Operation op = new Operation(hospitalName);
		Opd o = new Opd(hospitalName);
		Nurse n = new Nurse(hospitalName);
		Accountant a = new Accountant(hospitalName);
		Payments p = new Payments(hospitalName);
		Documentation doc = new Documentation(hospitalName);
	}
}
