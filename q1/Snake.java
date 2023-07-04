/**
 * Class which represent snake from the reptiles family
 *
 * @author Idan Calvo
 * @version 1.0
 */
public class Snake extends Reptiles {

//#Constructor
	public Snake(String name, int age, String color) {
		super(name, age, color);
	}

//#Methods
	// clone the snake
	@Override
	public Object clone() throws CloneNotSupportedException {
		return (Snake) super.clone();
	}

	// Makes the snake eat
	@Override
	public void toEat() {
		System.out.println("I'm a snake and I like to eat mice");
	}

	// Makes the snake sleep
	@Override
	public void toSleep() {
		System.out.println("I'm a snake and I like to sleep in burrows");
	}

	// Makes the snake crawl
	@Override
	public void crawl() {
		System.out.println("I'm a snake, I have no legs and I crawl on my stomach");
	}

}// Snake
