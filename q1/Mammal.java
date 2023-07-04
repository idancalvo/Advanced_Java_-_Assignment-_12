/**
 * Class which represent the mammal family
 *
 * @author Idan Calvo
 * @version 1.0
 */
public abstract class Mammal extends Animal implements Cloneable{

	private final static String family = "mammal";

//#Constructor
	protected Mammal(String name, int age, String color) {
		super(name, age, color);
	}

//#Methods
	// clone the mammal
	@Override
	public Object clone() throws CloneNotSupportedException {
		return (Mammal) super.clone();
	}

	// Makes the mammal move (all the mammals are move by walking)
	public void toMove() {
		walk();
	}

	// Returns family name
	protected String WhichFamily() {
		return new String(family);
	}

	// ----------------abstract methods----------------------

	// Makes the mammal eat
	public abstract void toEat();

	// Makes the mammal sleep
	public abstract void toSleep();

	// Makes the mammal walk
	public abstract void walk();

}// Mammal
