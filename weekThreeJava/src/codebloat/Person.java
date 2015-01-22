package codebloat;

import lombok.Data;

@Data
public class Person {
	private String firstName;
	private String lastName;
	private Address address;
	private int age;
	private String gender;
	
	public static void main(String[] args) {
		Person p = new Person();
		p.setAge(34);
	}

}

class Address {
}