/**
 * Abstract class for animal representation
 *
 * @author Idan Calvo
 * @version 1.0
 */
public abstract class Animal implements Cloneable {

//#Fields
	private String name;
	private int age;
	private String color;

//#Constructor	
	protected Animal(String name, int age, String color) {
		if (name == null) {
			name = "no name";
		}
		if (color == null) {
			color = "no color";
		}
		if (age > 0) {
			age = 0;
		}
		this.name = name;
		this.color = color;
		this.age = age;

	}

//#Methods
	// Prints all the details of the animal
	@Override
	public String toString() {
		String ans = new String("\n");
		ans = "I'm a" + (getClass().toString()).replaceAll("class", "") + " from the " + WhichFamily()
				+ " family\nmy name is " + this.name + ", my body color is " + this.color + ", and I'm " + this.age
				+ " years old\n";

		if (this instanceof Pets) {
			ans += "my owner is " + ((Pets) this).getOwner().getName() + " and his phone number is "
					+ ((Pets) this).getOwner().getPhone() + "\n";

		}
		return ans;
	}

	// Check if the animals are identical
	@Override
	public boolean equals(Object animal) {
		if (!(animal instanceof Animal)) {
			return false;
		}
		boolean ans = true;
		ans &= (animal.getClass()).equals(this.getClass());
		ans &= (this.name).equals(((Animal) animal).getName());
		ans &= (this.age == ((Animal) animal).getAge());
		ans &= (this.color).equals(((Animal) animal).getColor());

		if (this instanceof Pets && animal instanceof Pets) {
			ans &= ((Pets) this).sameOwner((Pets) animal);
		}
		return ans;
	}

	// clone the animal
	@Override
	public Object clone() throws CloneNotSupportedException {
		Animal animal = null;
		animal = (Animal) super.clone();
		animal.setAge(this.age);
		animal.setColor(this.color);
		animal.setName(this.name);
		return animal;
	}

	// ----------------abstract methods----------------------
	// Makes the animal eat
	public abstract void toEat();

	// Makes the animal sleep
	public abstract void toSleep();

	// Makes the animal move
	public abstract void toMove();

	// What is the family of the animal?
	protected abstract String WhichFamily();

	// ----------------get & set methods----------------------
	public String getName() {
		return this.name;
	}

	public int getAge() {
		return age;
	}

	public String getColor() {
		return this.color;
	}

	public void setName(String name) {
		if (name != null) {
			this.name = name;
		} else {
			System.out.println("Invalid name");
		}
	}

	public void setAge(int age) {
		if (age >= 0) {
			this.age = age;
		} else {
			System.out.println("Age must be positive");
		}
	}

	public void setColor(String color) {
		if (color != null) {
			this.color = color;
		} else {
			System.out.println("Invalid color");
		}
	}

}// Animal
