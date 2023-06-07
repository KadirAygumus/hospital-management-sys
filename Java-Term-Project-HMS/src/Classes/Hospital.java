package Classes;

import java.util.ArrayList;

public class Hospital {

	private String name;
	private int foundYear;
	private String city;
	private int managerId;
	private String passwordOfManager;
	private ArrayList<Doctor> doctors;

	public Hospital(String name, int foundYear, String city, int managerId, String passwordOfManager) {
		doctors = new ArrayList<Doctor>();
		
		this.name = name;
		this.foundYear = foundYear;
		this.city = city;
		this.managerId = managerId;
		this.passwordOfManager = passwordOfManager;
	}
	
	public int getManagerId() {
		return managerId;
	}

	public String getPasswordOfManager() {
		return passwordOfManager;
	}

	public ArrayList<Doctor> getDoctorAL() {
		return doctors;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getFoundYear() {
		return foundYear;
	}

	public void setFoundYear(int foundYear) {
		this.foundYear = foundYear;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	
	public boolean checkDoctor(int id) {
		
		for (int i = 0; i < doctors.size(); i++) {
			if (doctors.get(i).getId() == id)
				return true; // yes there is duplicate data
		}
		
		return false; // there is no duplication
	}
	
	public boolean addDoctor(Doctor doc) {
		
		if (checkDoctor(doc.getId()))
			return false; // yes there is duplicate data, cannot add (false) 
		
		doctors.add(doc);
		return true; // the new patient is added
		
	}
	
	public Doctor searchDoctor(int id) {
		
		for (int i = 0; i < doctors.size(); i++) {
			if (doctors.get(i).getId() == id)
				return doctors.get(i);
		}
		
		return null;
	}
	
	public boolean deleteDoctor(int id) {
		
		for (int i = 0; i < doctors.size(); i++)
			if (doctors.get(i).getId() == id) {
				doctors.remove(i);
				return true;
			}
		
		return false;
	}
	
	public String displayAllDoctors() {
		String str = "";
		
		for (Doctor doc : doctors) {
			str += "Doctor\n" + doc.doctorInfo() + "\n";
		}
		
		return str;
	}

	public String[] displayAllDoctorId() {
		String[] docIdArr = new String[doctors.size()];
		
		for (int i = 0; i < doctors.size(); i++) {
			docIdArr[i] = String.valueOf(doctors.get(i).getId());
		}
		// it will typecast Integer Id to String
		
		return docIdArr;
	}
	
	 public String HospitalInfo(){
	        return "Name=" + name + 
	               "\nFound Year=" + foundYear + 
	               "\nCity=" + city + 
	               "\nDoctors Count: " + doctors.size() + 
	               displayAllDoctors();
	 }
	
	@Override
	public String toString() {
		return "Name=" + name + 
				"\nFound Year=" + foundYear + 
				"\nCity=" + city + 
				"\n";
	}
}