package com.user;

public class User {
	
	private int id;
	
	private String full_name, imageBt, username, password;
	
	public User(int id, String fn, String imageBt, String un, String pass) {
		
		this.id = id;
		
		this.full_name = fn;
		
		this.imageBt = imageBt;
		
		this.username = un;
		
		this.password = pass;
		
	}
	
	public User(String fn, String imageBt, String un, String pass) {
		
		this.full_name = fn;
		
		this.imageBt = imageBt;
		
		this.username = un;
		
		this.password = pass;
		
	}

	public int getId() {
		
		return id;
		
	}

	public void setId(int id) {
		
		this.id = id;
		
	}

	public String getImageBt() {
		
		return imageBt;
		
	}

	public void setImageBt(String imageBt) {
		
		this.imageBt = imageBt;
		
	}

	public String getFull_name() {
		
		return full_name;
	}
	

	public void setFull_name(String full_name) {
		
		this.full_name = full_name;
		
	}

	public String getUsername() {
		
		return username;
		
	}

	public void setUsername(String username) {
		
		this.username = username;
		
	}

	public String getPassword() {
		
		return password;
		
	}

	public void setPassword(String password) {
		
		this.password = password;
		
	}

}
