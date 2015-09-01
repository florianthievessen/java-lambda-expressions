package de.florianthievessen.lambdas;

public class Person {

	public enum Sex {
		MALE, FEMALE
	}

	String name = "";
	Sex gender = null;
	int age = 0;
	String emailAddress = "";

	public Person(String name, Sex gender, int age, String emailAddress) {
		this.name = name;
		this.gender = gender;
		this.age = age;
		this.emailAddress = emailAddress;
	}

	public void printPerson() {
		System.out.println(name + ", " + gender + ", " + age + ", " + emailAddress);
	}

	public Sex getGender() {
		return gender;
	}

	public void setGender(Sex gender) {
		this.gender = gender;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

}
