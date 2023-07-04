/**
 * Class which represent chicken from the fowl family. 
 * The chicken has an owner because he is a pet
 *
 * @author Idan Calvo
 * @version 1.0
 */
public class Chicken extends Fowl implements Pets, Cloneable {

// #Fields
	protected Owner owner;

	// #Constructor
	public Chicken(String name, int age, String color, Owner owner) {
		super(name, age, color);
		if (owner == null) {
			owner = new Owner("Street", "106");
		}
		this.owner = owner;
	}

// #Methods

	// clone the chicken
	@Override
	public Object clone() throws CloneNotSupportedException {
		Chicken chicken = null;
		chicken = (Chicken) super.clone();
		chicken.setOwner((Owner) (this.owner).clone());
		return chicken;

	}

	// Makes the chicken eat
	@Override
	public void toEat() {
		System.out.println("I'm Chicken and I like to eat grains");
	}

	// Makes the chicken sleep
	@Override
	public void toSleep() {
		System.out.println("I'm Chicken and I love sleeping in a coop");
	}

	// Makes the chicken move
	@Override
	public void toMove() {
		walk();
	}

	// Makes the chicken walk
	protected void walk() {
		System.out.println("I'm Chicken, I have wings but I can not fly");
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

}// Chicken