package Main;

import Classes.*;
import GUI.MainFrame;

public class HMS_Main {

	public static void main(String[] args) {
		
		dataInput();
		
		MainFrame mf = new MainFrame();
		mf.setVisible(true);
		
	}
	
	// data input when "read data" button is pressed
	public static void dataInput() {
		
		// Hospital Name is Primary Key for Hospital objects (unique)
		// Doctor Id  is Primary Key for Doctor objects
		// Patient Ssn is Primary Key for Patient objects
		
		Hospital h1 = new Hospital("Ankara Hastanesi", 1996, "Ankara", 10001, "password");
		Hospital h2 = new Hospital("Istanbul Hastanesi", 1992, "Istanbul", 10002, "password");
		Hospital h3 = new Hospital("Bolu Hastanesi", 1234, "Orta Asya", 10003, "password");
		
		Doctor d1 = new Doctor("Kadir", "Aygumus", "Male", 20, 175, 67, 1111, 35000, "Neurology", "kadir123");
		Doctor d2 = new Doctor("Cristiano", "Ronaldo", "Male", 38, 170, 80, 7777, 300000, "Cardiology", "enes123");		
		Doctor d3 = new Doctor("Anonymous", "Doctor", "Female", 61, 150, 60, 3333, 100, "Brain Surgery", "anon123");
		Doctor d4 = new Doctor("Bera", "Ozer", "Male", 21, 180, 80, 4444, 15000, "Toxicology", "bera123");
		Doctor d5 = new Doctor("Enes", "Cakir", "Male", 45, 173, 75, 5555, 20000, "Nefrology", "enes123");
		Doctor d6 = new Doctor("Clever", "Doctor", "Female", 28, 177, 77, 9999, 120000, "Gastroentology", "imbest123");
		
		// we respect patients privacy, no name no private information
		Patient p1 = new Patient("Patient 1", "No Surname", "Male", 21, 161, 50, 193512, "Diheria");
		Patient p2 = new Patient("Patient 2", "Noo Surname", "Female", 21, 174, 80, 152591, "Diheria");
		Patient p3 = new Patient("Patient 3", "Nuo Surname", "Male", 21, 155, 40, 123433, "Diheria");
		Patient p4 = new Patient("Patient 4", "Neah Surname", "Female", 21, 180, 220, 542344, "Diheria");
		Patient p5 = new Patient("Patient 5", "Noou Surname", "Female", 21, 190, 100, 772385, "Diheria");
		Patient p6 = new Patient("Patient 6", "Nope Surname", "Male", 15, 150, 50, 942111, "Diheria");
		Patient p7 = new Patient("Patient 7", "N/A Surname", "Male", 77, 177, 77, 999999, "Diheria");
		Patient p8 = new Patient("Patient 8", "No Sirname", "Male", 15, 150, 50, 858821, "Diheria");
		Patient p9 = new Patient("Patient 9", "No Sir", "Female", 11, 111, 20, 334112, "Diheria");
		
		HospitalSys.addHospital(h1);
		HospitalSys.addHospital(h2);
		HospitalSys.addHospital(h3);
		
		HospitalSys.addDoctor("Ankara Hastanesi", d1);
		HospitalSys.addDoctor("Ankara Hastanesi", d2);
		HospitalSys.addDoctor("Istanbul Hastanesi", d3);
		HospitalSys.addDoctor("Istanbul Hastanesi", d4);
		HospitalSys.addDoctor("Bolu Hastanesi", d5);
		HospitalSys.addDoctor("Bolu Hastanesi", d6);
		
		HospitalSys.addPatient("Ankara Hastanesi", 1111, p1);
		HospitalSys.addPatient("Ankara Hastanesi", 1111, p2);
		HospitalSys.addPatient("Ankara Hastanesi", 7777, p3);
		
		HospitalSys.addPatient("Istanbul Hastanesi", 3333, p4);
		HospitalSys.addPatient("Istanbul Hastanesi", 4444, p5);
		HospitalSys.addPatient("Istanbul Hastanesi", 4444, p6);
		
		HospitalSys.addPatient("Bolu Hastanesi", 9999, p7);
		HospitalSys.addPatient("Bolu Hastanesi", 5555, p8);
		HospitalSys.addPatient("Bolu Hastanesi", 5555, p9);
		
	}
}