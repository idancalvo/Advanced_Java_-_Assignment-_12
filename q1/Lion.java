/**
 * Class which represent lion from the mammal family
 *
 * @author Idan Calvo
 * @version 1.0
 */
public class Lion extends Mammal {

//#Constructor
	public Lion(String name, int age, String color) {
		super(name, age, color);
	}

//#Methods
	// clone the lion
	@Override
	public Object clone() throws CloneNotSupportedException {
		return (Lion) super.clone();
	}

	// Makes the lion eat
	@Override
	public void toEat() {
		System.out.println("I'm a lion and I like to eat zebras");
	}

	// Makes the lion sleep
	@Override
	public void toSleep() {
		System.out.println("I'm a lion and I like sleeping in Savannah");
	}

	// Makes the lion walk
	@Override
	public void walk() {
		System.out.println("I'm a lion, I have four legs and I like to run");
	}

}// Lion
