package Classes;
import Interfaces.*;

public abstract class Person implements PersonType {
	
	protected String name, surname, gender;
	protected int age;
	protected  double weight, height;
	
	public Person(String name, String surname, String gender, int age, double weight, double height) {
		this.name = name;
		this.surname = surname;
		this.gender = gender;
		this.age = age;
		this.weight = weight;
		this.height = height;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}
	
	public abstract void calculateAmount();

	@Override
	public String toString() {
		return "Name=" + name + 
			   "\nSurname=" + surname + 
			   "\nGender=" + gender + 
			   "\nAge=" + age + 
			   "\nWeight=" + weight + 
			   "\nHeight=" + height + 
			   "\n";
	}
}