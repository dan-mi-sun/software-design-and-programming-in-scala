package bloat;

import lombok.Data;

@Data
public class Person {
	private String firstName;
	private String lastName;
	private int age;
	
	public static void main(String... args){
		Person p = new Person();
		p.setAge(12);
	}
}