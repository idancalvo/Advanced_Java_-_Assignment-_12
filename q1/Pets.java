/**
 * Pet interface All pets have owners.
 * 
 * @author Idan Calvo
 * @version 1.0
 **/

public interface Pets {
	// We both have the same owners
	public boolean sameOwner(Pets animal);

	public Owner getOwner();

	public void setOwner(Owner owner);
}
