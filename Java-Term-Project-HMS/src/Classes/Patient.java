package Classes;

public class Patient extends Person {

	private int ssn;
	private String disease;
	private double fee;
	
	public Patient(String name, String surname, String gender, int age, double weight, double height, int ssn, String disease) {
		super(name, surname, gender, age, weight, height);
		this.ssn = ssn;
		this.disease = disease;
	}
	
	public double getFee() {
		return fee;
	}
	
	public void setFee(double fee) {
		this.fee = fee;
	}
	
	public int getSsn() {
		return ssn;
	}

	public void setSsn(int ssn) {
		this.ssn = ssn;
	}

	public String getDisease() {
		return disease;
	}

	public void setDisease(String disease) {
		this.disease = disease;
	}

	@Override
	public void calculateAmount() {
		this.fee = ssn * 5;
	}

	@Override
	public String toString() {
		return returnType() + "\n" +super.toString() + 
				"Ssn=" + ssn + 
				"\nDisease=" + disease + 
				"\n";
	}

	@Override
	public String returnType() {
		return "Patient";
	}
}