/**
 * 
 */
package agenda.api;

/**
 * @author msluiter
 *
 */
public class Conference {
	private String name;
	private String location;
	
	public Conference() {
		super();
	}

	public Conference(String name, String location) {
		super();
		this.name = name;
		this.location = location;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}

	@Override
	public String toString() {
		return "Conference [name=" + name + ", location=" + location + "]";
	}
	
	
	
}
