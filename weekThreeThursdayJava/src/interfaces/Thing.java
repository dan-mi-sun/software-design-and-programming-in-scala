package interfaces;

public interface Thing {
	public default boolean alive() {
		return false;
	}
}

interface Fly extends Thing {
	public String eat();
}

interface Person extends Thing {
	public String eat();
}

interface Huly extends Fly, Person {
}

class FlyImpl implements Fly {
	public String eat() {
		return "Vomit absorb... repeat";
	}
}

class PersonImpl implements Person {
	public boolean alive() {
		return true;
	}

	public String eat() {
		return "chewing and swallow";
	}
}

class HulyImpl implements Huly {
	private Person pi;

	public String eat() {
		return pi.eat();
	}
}