/**
 * Class which represent Owner
 *
 * @author Idan Calvo
 * @version 1.0
 */
public class Owner implements Cloneable {

//#Fields	
	private String name;
	private String phone;

//#Constructor
	public Owner(String name, String phone) {
		if ((phone == null) || !(phone.matches("[0-9]+"))) {
			phone = "106";
			System.out.println("Invalid phone number");
		}
		if (name == null) {
			name = "Street";
			System.out.println("Invalid name");
		}
		this.phone = phone;
		this.name = name;
	}

//#Methods

	// Checking if the owners is equals
	@Override
	public boolean equals(Object owner) {
		if (!(owner instanceof Owner)) {
			return false;
		}
		boolean ans = true;
		ans &= (this.name).equals(((Owner) owner).getName());
		ans &= (this.phone).equals(((Owner) owner).getPhone());
		return ans;
	}

	// clone the owner
	@Override
	public Object clone() throws CloneNotSupportedException {
		Owner owner = null;
		owner = (Owner) super.clone();
		owner.setName(this.name);
		owner.setPhone(this.phone);
		return owner;
	}

	// ----------------get & set methods----------------------
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		if (name != null) {
			this.name = name;
		} else {
			System.out.println("Invalid name");
		}

	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		if ((phone != null) && (phone.matches("[0-9]+"))) {
			this.phone = phone;
		} else {
			System.out.println("Invalid phone number");
		}

	}

}
