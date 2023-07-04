/**
 * Class which represent the fowl family
 *
 * @author Idan Calvo
 * @version 1.0
 */

public abstract class Fowl extends Animal implements Cloneable{

	private final static String family = "fowl";

//#Constructor
	protected Fowl(String name, int age, String color) {
		super(name, age, color);
	}

//#Methods
	// clone the fowl
	@Override
	public Object clone() throws CloneNotSupportedException {
		return (Fowl) super.clone();
	}

	// Returns family name
	@Override
	protected String WhichFamily() {
		return new String(family);
	}

	// ----------------abstract methods----------------------

	// Makes the fowl eat
	public abstract void toEat();

	// Makes the fowl sleep
	public abstract void toSleep();

	// Makes the fowl move (not all the fowl can fly)
	public abstract void toMove();

}// Mammal