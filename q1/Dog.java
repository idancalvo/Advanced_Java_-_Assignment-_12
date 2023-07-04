/**
 * Class which represent dog from the mammal family 
 * The dog has an owner because he is a pet 
 *
 * @author Idan Calvo
 * @version 1.0
 */
public class Dog extends Mammal implements Pets, Cloneable {

//#Fields
	protected Owner owner;

//#Constructor
	public Dog(String name, int age, String color, Owner owner) {
		super(name, age, color);
		if (owner == null) {
			owner = new Owner("Street", "106");
		}
		this.owner = owner;
	}

//#Methods
	// clone the dog
	@Override

	public Object clone() throws CloneNotSupportedException {
		Dog dog = null;
		dog = (Dog) super.clone();
		dog.setOwner((Owner) (this.owner).clone());
		return dog;

	}

	// Makes the dog eat
	@Override
	public void toEat() {
		System.out.println("I'm a dog and I like to eat bonzo");
	}

	// Makes the dog sleep
	@Override
	public void toSleep() {
		System.out.println("I'm a dog and I like to sleep in a kennel");
	}

	// Makes the dog walk
	@Override
	public void walk() {
		System.out.println("I am a dog, I have 4 legs and I love to run and jump");
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

}// Dog
