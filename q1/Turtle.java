/**
 * Class which represent turtle from the reptiles family. 
 * The turtle has an owner because he is a pet
 *
 * @author Idan Calvo
 * @version 1.0
 */

public class Turtle extends Reptiles implements Pets, Cloneable {

//#Fields
	protected Owner owner;

//#Constructor
	public Turtle(String name, int age, String color, Owner owner) {
		super(name, age, color);
		if (owner == null) {
			owner = new Owner("Street", "106");
		}
		this.owner = owner;
	}

//#Methods

	// clone the turtle
	@Override
	public Object clone() throws CloneNotSupportedException {
		Turtle turtle = null;
		turtle = (Turtle) super.clone();
		turtle.setOwner((Owner) (this.owner).clone());
		return turtle;
	}

	// Makes the turtle eat
	@Override
	public void toEat() {
		System.out.println("I'm Turtle and I like to eat lettuce");

	}

	// Makes the turtle sleep
	@Override
	public void toSleep() {
		System.out.println("I'm Turtle and I sleep in the house on my back");
	}

	// Makes the turtle crawl
	@Override
	public void crawl() {
		System.out.println("I am a Turtle, I have 4 legs and I crawl on my stomach");
	}

	// Checking if the owners are identical
	@Override
	public boolean sameOwner(Pets animal) {
		if (animal == null || this.owner == null) {
			return false;
		}
		return (this.owner).equals(animal.getOwner());
	}

	// ----------------get & set methods----------------------
	@Override
	public Owner getOwner() {
		return this.owner;
	}

	@Override
	public void setOwner(Owner owner) {
		if (owner != null) {
			this.owner = owner;
		} else {
			System.out.println("Invalid owner");
		}
	}

}// Turtle
