package Classes;

import java.util.ArrayList;

public class HospitalSys {

	private static ArrayList<Hospital> hospitals = new ArrayList<Hospital>();
	private static final int MAX_SIZE = 5;
	
	public static ArrayList<Hospital> getHospitalAL() {
		return hospitals;
	}

	
    //
    //Hospital data manipulation
    //
	
	public static String managerLogin(int manId, String pwd) {
		
		// searches all hospitals and finds & returns if any hospital's manager and pwd is found
		for (int i = 0; i < HospitalSys.getHospitalAL().size(); i++)
			if (HospitalSys.getHospitalAL().get(i).getManagerId() == manId && HospitalSys.getHospitalAL().get(i).getPasswordOfManager().equals(pwd))
				return HospitalSys.getHospitalAL().get(i).HospitalInfo();
		
		return null;
	}
	
	public static boolean checkHospital(Hospital h) {
		
		
		for (int i = 0; i < hospitals.size(); i++) {
			if (hospitals.get(i).getName().equalsIgnoreCase(h.getName()))
				return true; // yes there is duplicate data
		}
		
		return false;
	}
	
	public static boolean addHospital(Hospital h) {
		
		if (checkHospital(h) || hospitals.size() > 5)
			return false; // yes there is duplicate data, cannot add (means false) 
		
		// new patient is added
		hospitals.add(h);
		return true; // the new patient is added
		
	}
	
	public static Hospital searchHospital(String hospitalName) {
		
		for (int i = 0; i < hospitals.size(); i++) {
			if (hospitals.get(i).getName().equalsIgnoreCase(hospitalName))
				return hospitals.get(i);
		}
		
		return null;
	}
	
	public static boolean deleteHospital(String hospitalName) {
		
		if (searchHospital(hospitalName) != null) {
			hospitals.remove(searchHospital(hospitalName));
			return true;
		}
		
		return false;
	}
	
	public static String displayAllHospitals() {
		String str = "";
		
		for (Hospital h : hospitals) {
			str += "Hospital\n" + h.toString() + "\n";
		}
		
		return str;
	}
	
	public static String[] displayAllHospitalName() {
		String[] hospitalNameArr = new String[hospitals.size()];
		
		for (int i = 0; i < hospitals.size(); i++) {
			hospitalNameArr[i] = hospitals.get(i).getName();
		}
		
		if(hospitals.size() == 0) {
			String[] returnString = new String[1];
			returnString[0] = "No hospitals!";
			return returnString;
		}

		
		return hospitalNameArr;
	}
	
	// keep try to find a true way to clone an array
    public static String[] displayHospitalDoctorsId(String hospitalName) {
    	String[] docIdArr = searchHospital(hospitalName).displayAllDoctorId();
    	
    	if(searchHospital(hospitalName).displayAllDoctorId().length == 0) {
			String[] returnString = new String[1];
			returnString[0] = "No doctors!";
			return returnString;
		}
    	
    	return docIdArr;
    }
	
    
    //
	//Doctor data manipulation
    //
	
    public static String doctorLogin(int id, String pwd) {
    	
    	for (int i = 0; i < HospitalSys.getHospitalAL().size(); i++) {
    		
    		for (int d = 0; d < HospitalSys.getHospitalAL().get(i).getDoctorAL().size(); d++) {
    		
    			if (HospitalSys.getHospitalAL().get(i).getDoctorAL().get(d).getId() == id && HospitalSys.getHospitalAL().get(i).getDoctorAL().get(d).getPasswordOfDoc().equals(pwd))
    				return HospitalSys.getHospitalAL().get(i).getDoctorAL().get(d).doctorInfo();
    		}
    	}
    	
    	return null;
    }
    
    public static boolean addDoctor(String hospitalName,Doctor doc) {
        return searchHospital(hospitalName).addDoctor(doc);
    }
	
    public static boolean deleteDoctor(String hospitalName,int doctorID) {
        return searchHospital(hospitalName).deleteDoctor(doctorID);
    }
	
    public static String displayDoctor(String hospitalName,int doctorID){
        //display doctor and according to found/notfound returns
        String str = "";

        if(searchHospital(hospitalName).checkDoctor(doctorID))
            str=searchHospital(hospitalName).searchDoctor(doctorID).toString();

        if (str == null)
        	return "No such doctor found !!";
        
        return str;
    }
    
    public static String searchAndDisplayDoctor(int doctorID) {
    	
    	for (int i = 0; i < HospitalSys.getHospitalAL().size(); i++) {
    		
    		for (int k = 0; k < HospitalSys.getHospitalAL().get(i).getDoctorAL().size(); k++) {
    			
    			if (HospitalSys.getHospitalAL().get(i).getDoctorAL().get(k).getId() == doctorID)
    				return HospitalSys.getHospitalAL().get(i).getDoctorAL().get(k).toString();
    		}
    	}
    	
    	return null;
    }
	
	// keep try to find a true way to clone an array
    public static String[] displayDoctorPatientsSsn (String hospitalName, int doctorID){
    	
    	if (searchHospital(hospitalName).searchDoctor(doctorID).displayAllPatientSsn().length == 0) {
    		String[] returnString = new String[1];
    		returnString[0] = "No Patient Found!";
    		return returnString;
    	}
    	
        return searchHospital(hospitalName).searchDoctor(doctorID).displayAllPatientSsn();
    }
	
    
    //
    //Patient data manipulation
    //
    
    public static boolean addPatient(String hospitalName, int docId, Patient p) {
        return searchHospital(hospitalName).searchDoctor(docId).addPatient(p);
    }
    
    public static boolean deletePatient(String hospitalName, int docID, int patientSsn) {
        return searchHospital(hospitalName).searchDoctor(docID).deletePatient(patientSsn);
    }
    
    public static String displayPatient(String hospitalName,int docID, int patientSsn){
        String str = "No such a patient found !!";

        if(searchHospital(hospitalName).searchDoctor(docID).checkPatient(patientSsn))
            str = searchHospital(hospitalName).searchDoctor(docID).searchPatient(patientSsn).toString();

        return str;
    }
    
    public static String searchAndDisplayPatient(int ssn) {
    	
    	for (int i = 0; i < HospitalSys.getHospitalAL().size(); i++) {
    		
    		for (int k = 0; k < HospitalSys.getHospitalAL().get(i).getDoctorAL().size(); k++) {
    			
    			for (int p = 0; p < HospitalSys.getHospitalAL().get(i).getDoctorAL().get(k).getPatientAL().size(); p++) {
    			
    				if (HospitalSys.getHospitalAL().get(i).getDoctorAL().get(k).getPatientAL().get(p).getSsn() == ssn)
    					return HospitalSys.getHospitalAL().get(i).getDoctorAL().get(k).getPatientAL().get(p).toString();
    			}
    		}
    	}
    	
    	return null;
    }
    
    //
    // Manipulation of all content
    //
    
    public static String displayAllContent(){
        String str ="";
        for(Hospital h : hospitals){
            str += h.HospitalInfo();
        }
        return str;
    }
	
	public static void deleteAllDataStored() {
		
		// all hospitals therefore all people data will be deleted
		for (int i = 0; i < hospitals.size(); i++) {
			hospitals.remove(i);
		}
	}
	
}