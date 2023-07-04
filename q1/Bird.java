/**
 * Class which represent bird from the fowl family
 *
 * @author Idan Calvo
 * @version 1.0
 */
public class Bird extends Fowl {

// #Constructor
	public Bird(String name, int age, String color) {
		super(name, age, color);
	}

// #Methods
	
	// clone the bird
	@Override
	public Object clone() throws CloneNotSupportedException {
		return (Bird) super.clone();
	}

	// Makes the bird eat
	@Override
	public void toEat() {
		System.out.println("I'm a bird and I like to eat worms");
	}

	// Makes the bird sleep
	@Override
	public void toSleep() {
		System.out.println("I'm a bird and I like to sleep in a nest");
	}

	// Makes the bird move
	@Override
	public void toMove() {
		fly();
	}

	// Makes the bird fly
	protected void fly() {
		System.out.println("I'm a bird and I like to fly");
	}

}// Bird
