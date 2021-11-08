package collegeportal.beans;

public class Student_bean 
{
	private String studentid,password,name,email,phone;

	public Student_bean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Student_bean(String studentid, String password, String name, String email, String phone) {
		super();
		this.studentid = studentid;
		this.password = password;
		this.name = name;
		this.email = email;
		this.phone = phone;
	}

	public String getStudentid() {
		return studentid;
	}

	public void setStudentid(String studentid) {
		this.studentid = studentid;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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
	
	

}
