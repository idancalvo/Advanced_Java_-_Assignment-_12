/**
 * Showing examples of Animal pensions 
 * Presentation the abilities of the animals
 * 
 * @author Idan Calvo
 * @version 1.0
 **/

public class Presentation {

	//Presentation Clone Animal (Pets) and switch owner
	public void PresentationClone() {
		Animal Squirtle1 = new Turtle("Squirtle", 21, "blue", new Owner("Ash.K", "0545589974"));

		Animal Squirtle2;
		try {
			Squirtle2 = (Animal) Squirtle1.clone();

			System.out.println("1) " + Squirtle1);
			System.out.println("2) " + Squirtle2);
			System.out.println("equals? " + Squirtle1.equals(Squirtle2) + "\n");

			System.out.println("Changing the details of the owner of an animal 2\n");
			((Pets) Squirtle2).getOwner().setName("misty");
			((Pets) Squirtle2).getOwner().setPhone("0521646632");

			System.out.println("1) " + Squirtle1);
			System.out.println("2) " + Squirtle2);
			System.out.println("equals? " + Squirtle1.equals(Squirtle2));
			System.out.println("\n--------------------------------------\n");

		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
	}

	//Presentation Pension of Animal 
	public void PresentationPension() {

		Pension pension = ExamPension();

		System.out.print("A show of all the animals in the Pension:\n");
		System.out.print(pension);
		System.out.println("\n--------------------------------------\n");

		System.out.println("We will feed them all:");
		pension.eatAll();
		System.out.println("\nWe will put them to sleep:");
		pension.sleepAll();
		System.out.println("\nWe'll take them on a trip:");
		pension.moveAll();

		System.out.println("\nWe will perform actions on individuals:");
		pension.iEat(5);
		pension.iSleep(8);
		pension.iMove(-1);

		System.out.println("\n--------------------------------------\n");
	}

	//Creating an example pension
	private Pension ExamPension() {
		Pension pension = new Pension("The new pension to animal");

		pension.addAnimal(new Lion("Simba", 15, "brown"));
		pension.addAnimal(new Lion("Nala", 7, "white"));
		pension.addAnimal(new Dog("Snoopy", 12, "grey", new Owner("Charlie.B", "0503020501")));
		pension.addAnimal(new Dog("Pluto", 9, "black", new Owner("Mickey.M", "0527897893")));
		pension.addAnimal(new Bird("Tweety", 3, "yellow"));
		pension.addAnimal(new Bird("Zazu", 17, "blue"));
		pension.addAnimal(new Chicken("Koko", 4, "red", new Owner("Charlie.B", "0503020501")));
		pension.addAnimal(new Chicken("Riko", 4, "black", new Owner("Ash.K", "0545589974")));
		pension.addAnimal(new Snake("Dratini", 3, "azure"));
		pension.addAnimal(new Snake("Ekans", 12, "purple"));
		pension.addAnimal(new Turtle("Squirtle", 21, "blue", new Owner("Ash.K", "0545589974")));
		pension.addAnimal(new Turtle("Donatello", 25, "green", new Owner("April.O", "0504456446")));

		return pension;
	}

}
