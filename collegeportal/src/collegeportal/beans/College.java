package collegeportal.beans;

public class College {
	private int collegeid;
	private String name,email,phone,address;
	public College(int collegeid, String name, String email, String phone, String address) {
		super();
		this.collegeid = collegeid;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.address = address;
	}
	public College() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getCollegeid() {
		return collegeid;
	}
	public void setCollegeid(int collegeid) {
		this.collegeid = collegeid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	

}
