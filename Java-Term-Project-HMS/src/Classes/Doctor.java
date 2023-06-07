package Classes;

import java.util.ArrayList;

public class Doctor extends Person {
	
	private int id;
	private double salary;
	private String department;
	private static int patientCount = 0;
	private String passwordOfDoc;
	private ArrayList<Patient> patients;
	
	public Doctor(String name, String surname, String gender, int age, double weight, double height, int id, double salary, String department, String passwordOfDoc) {
		super(name, surname, gender, age, weight, height);
		
		patients = new ArrayList<Patient>();
		this.id = id;
		this.salary = salary;
		this.department = department;
		this.passwordOfDoc = passwordOfDoc;
	}
	
	public String getPasswordOfDoc() {
		return this.passwordOfDoc;
	}

	public ArrayList<Patient> getPatientAL() {
		return patients;
	}

	public static int getPatientCount() {
		return patientCount;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public boolean addPatient(Patient pt) {
		
		if (checkPatient(pt.getSsn()))
			return false; // yes there is duplicate data, cannot add (false) 
		else {
			patients.add(pt);
			patientCount++;
			return true; // the new patient is added
		}
	}
	
	public boolean checkPatient(int ssn) {
		
		for (int i = 0; i < patients.size(); i++) {
			if (patients.get(i).getSsn() == ssn)
				return true; // yes there is duplicate data
		}
		
		return false; // there is no duplication
	}
	
	public Patient searchPatient(int ssn) {
		
		for (int i = 0; i < patients.size(); i++) {
			if (patients.get(i).getSsn() == ssn)
				return patients.get(i);
		}
		
		return null;
	}
	
	public boolean deletePatient(int ssn) {
		
		if (searchPatient(ssn) != null) {
			patients.remove(searchPatient(ssn));
			return true;
		}
		
		return false;
	}
	
	public String[] displayAllPatientSsn() {
		String[] patientSsnArr = new String[patients.size()];
		
		for (int i = 0; i < patients.size(); i++) {
			patientSsnArr[i] = String.valueOf(patients.get(i).getSsn());
		}
		// it will typecast integer Ssn to String
		
		return patientSsnArr;
	}
 	
	public String displayAllPatients() {
		String str = "";
		
		for (Patient pt : patients) {
			str += "Patient\n" + pt.toString() + "\n"; 
		}
		
		return str;
	}
	
	// we havent decided how to implement a solid method, so this is useless now
	@Override
	public void calculateAmount() {
		this.salary = patientCount * 200;
	}

	public String doctorInfo(){
        return super.toString() + 
        "Id=" + id + 
        "\nSalary=" + salary + 
        "\nDepartment=" + department + 
        "\nPatients"+ displayAllPatients();
	}
	
	@Override
	public String toString() {
		return returnType() + "\n" + super.toString() + 
				"Id=" + id + 
				"\nSalary=" + salary + 
				"\nDepartment=" + department + 
				"\nPatient Number= " + patientCount + 
				"\n";
	}

	@Override
	public String returnType() {
		return "Doctor";
	}	
}