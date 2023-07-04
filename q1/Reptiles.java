/**
 * Class which represent the reptiles family
 *
 * @author Idan Calvo
 * @version 1.0
 */

public abstract class Reptiles extends Animal implements Cloneable{

	private final static String family = "reptiles";

//#Constructor
	protected Reptiles(String name, int age, String color) {
		super(name, age, color);
	}

//#Methods

	// clone the reptiles
	@Override
	public Object clone() throws CloneNotSupportedException {
		return (Reptiles) super.clone();
	}

	// Makes the reptiles move (all the reptiles are move by crawl)
	@Override
	public void toMove() {
		crawl();
	}

	// Returns family name
	@Override
	protected String WhichFamily() {
		return new String(family);
	}

	// ----------------abstract methods----------------------

	// Makes the reptiles eat
	public abstract void toEat();

	// Makes the reptile sleep
	public abstract void toSleep();

	// Makes the reptile crawl
	public abstract void crawl();

}// Reptiles
