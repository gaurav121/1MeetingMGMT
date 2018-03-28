package com.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="UserDetail")
public class User {

	
	@Id
	private String userID;

	public User() {
		// TODO Auto-generated constructor stub
	}
	
	public User(String i) {
		this.userID=i;
	
	}
	
	
	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}
	
	
	
}
