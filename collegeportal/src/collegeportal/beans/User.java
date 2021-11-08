package collegeportal.beans;

public class User {
private int id;
private String userid;
private String password;
private String type;


public User(int id, String userid, String password, String type) {
	super();
	this.id = id;
	this.userid = userid;
	this.password = password;
	this.type = type;
}
public String getUserid() {
	return userid;
}
public void setUserid(String userid) {
	this.userid = userid;
}
public int getId() {
	return id;
}
public User(int id, String password, String type) {
	super();
	this.id = id;
	this.password = password;
	this.type = type;
}
public void setId(int id) {
	this.id = id;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getType() {
	return type;
}
public void setType(String type) {
	this.type = type;
}

}
