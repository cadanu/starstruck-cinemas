package com.prog32578;

import java.io.Serializable;

public class User implements Serializable {
	
	private static final long serialVersionUID = 4464379913038868757L;
	
	private String idAcc;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	
	public User() {}
	
	public User(String firstName, String lastName, String email, String pass) {
		//this.idAcc = "SSC" + String.valueOf(count);
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = pass;
	}	
	
	public String getIdAcc() {
		return idAcc;
	}
	public void setIdAcc(String idAcc) {
		this.idAcc = idAcc;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
