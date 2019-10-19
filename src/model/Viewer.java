package model;

import java.util.Date;

public class Viewer {
	
	private String id; 
	private String name;
	private String lastName;
	private String email;
	private String gender;
	private String country;
	private Date dateBorn;
	
	public Viewer(String id, String name, String lastName, String email, String gender, String country, Date dateBorn) {
		this.id = id;
		this.name = name;
		this.lastName = lastName;
		this.email = email;
		this.gender = gender;
		this.country = country;
		this.dateBorn = dateBorn;
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

	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public Date getDateBorn() {
		return dateBorn;
	}
	public void setDateBorn(Date dateBorn) {
		this.dateBorn = dateBorn;
	}
	
	
	
	
}
