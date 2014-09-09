/**
 * 
 */
package agenda.api;

/**
 * @author msluiter
 *
 */
public class Conference {
	private String m_name;
	private String m_location;
	
	public Conference() {
		super();
	}

	public Conference(String name, String location) {
		super();
		this.m_name = name;
		this.m_location = location;
	}
	
	public String getName() {
		return m_name;
	}
	public void setName(String name) {
		this.m_name = name;
	}
	public String getLocation() {
		return m_location;
	}
	public void setLocation(String location) {
		this.m_location = location;
	}

	@Override
	public String toString() {
		return "Conference [name=" + m_name + ", location=" + m_location + "]";
	}
	
	
	
}
