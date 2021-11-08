package collegeportal.beans;

public class City {
	private String name,id;

	public City() {
		super();
		// TODO Auto-generated constructor stub
	}

	public City(String name, String id) {
		super();
		this.name = name;
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}
