package hello;

public class Department {

	private long id;
	private String name, loc;

	public Department(long id, String name, String loc) {
		this.id = id;
		this.name = name;
		this.loc = loc;
	}

	public String toString() {
		return String.format("Department[id=%d, name='%s', loc='%s']", id, name, loc);
	}

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getLoc() {
		return loc;
	}
}
