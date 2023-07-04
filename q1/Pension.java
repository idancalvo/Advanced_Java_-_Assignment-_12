
/**
 * Class which represent pension for animals
 *
 * @author Idan Calvo
 * @version 1.0
 */

import java.util.ArrayList;

public class Pension {

//#Fields	
	private String name;
	private ArrayList<Animal> rooms;

//#Constructor
	public Pension(String name) {
		this.rooms = new ArrayList<Animal>();
		this.name = "0";
		if (name != null) {
			this.name = name;
		}
	}

//#Methods	
	// Adding an animal to the pension
	public boolean addAnimal(Animal animal) {
		if (animal == null) {
			return false;
		}
		return rooms.add(animal);
	}

	// delete an animal from the pension
	public boolean delAnimal(Animal animal) {
		return rooms.remove(animal);
	}

	// toString of all the animals that are in the pension
	@Override
	public String toString() {
		String ans = new String("");
		ans += "\nname: " + this.name + "\n ";
		for (int i = 0; rooms.size() > i; i++) {
			ans += (i + 1) + ") " + rooms.get(i).toString();
		}
		return ans;
	}

	// Makes all the animals eat
	public void eatAll() {
		for (int i = 0; rooms.size() > i; i++) {
			iEat(i);
		}
	}

	// Makes all the animals sleep
	public void sleepAll() {
		for (int i = 0; rooms.size() > i; i++) {
			iSleep(i);
		}
	}

	// Makes all the animals move
	public void moveAll() {
		for (int i = 0; rooms.size() > i; i++) {
			iMove(i);
		}
	}

	// Makes the animals (i) eat
	public void iEat(int i) {
		if (i >= 0) {
			(rooms.get(i)).toEat();
		} else {
			System.out.println("The animal was not found");
		}
	}

	// Makes the animals (i) sleep
	public void iSleep(int i) {
		if (i >= 0) {
			(rooms.get(i)).toSleep();
		} else {
			System.out.println("The animal was not found");
		}
	}

	// Makes the animals (i) move
	public void iMove(int i) {
		if (i >= 0) {
			(rooms.get(i)).toMove();
		} else {
			System.out.println("The animal was not found");
		}
	}

}
