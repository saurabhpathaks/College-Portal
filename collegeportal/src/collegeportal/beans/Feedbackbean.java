package collegeportal.beans;

public class Feedbackbean 
{
 public String name,email,phone,feedback,rating;

public Feedbackbean(String name, String email, String phone, String feedback, String rating) {
	super();
	this.name = name;
	this.email = email;
	this.phone = phone;
	this.feedback = feedback;
	this.rating = rating;
}

public String getRating() {
	return rating;
}

public void setRating(String rating) {
	this.rating = rating;
}

public Feedbackbean() {
	super();
	// TODO Auto-generated constructor stub
}

public Feedbackbean(String name, String email, String phone, String feedback) {
	super();
	this.name = name;
	this.email = email;
	this.phone = phone;
	this.feedback = feedback;
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

public String getFeedback() {
	return feedback;
}

public void setFeedback(String feedback) {
	this.feedback = feedback;
}
 
	
	
	
}
