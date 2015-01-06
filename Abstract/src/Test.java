public class Test {
	public static void main(String[] args) {

		Student s = new Student();
		Person p = (Person) s;
		Person p2 = new Person();

		s.print();
		p.print();
		p2.print();

	}
}
