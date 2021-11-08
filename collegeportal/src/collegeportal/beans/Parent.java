package collegeportal.beans;

import java.io.File;
import java.io.InputStream;

public class Parent 
{
	private String id,name,phone,address,language,city,picname,gender;

	public Parent() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Parent(String id, String name, String phone, String language, String city,
			 String gender) {
		super();
		this.id = id;
		this.name = name;
        this.phone = phone;
		this.language = language;
		this.city = city;
		this.gender = gender;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPicname() {
		return picname;
	}

	public void setPicname(String picname) {
		this.picname = picname;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public boolean uploadpost(InputStream is, File f, String filename) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean updateProfile(String filename, String id2) {
		// TODO Auto-generated method stub
		return false;
	}

	

}
