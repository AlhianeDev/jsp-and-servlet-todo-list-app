package com.todo;

public class Todo {
	
	private int id, user_id;
	
	private String title, createdAt;
	
	private boolean is_checked;

	public Todo(int id, String title, String createdAt, boolean is_checked, int user_id) {
		
		this.id = id;
		
		this.title = title;
		
		this.createdAt = createdAt;
		
		this.is_checked = is_checked;
		
		this.user_id = user_id;
		
	}
	
	public Todo(String title, int user_id) {
		
		this.title = title;
		
		this.user_id = user_id;
		
	}

	public int getId() {
		
		return id;
		
	}

	public void setId(int id) {
		
		this.id = id;
		
	}

	public String getTitle() {
		
		return title;
		
	}

	public void setTitle(String title) {
		
		this.title = title;
		
	}

	public String getCreatedAt() {
		
		return createdAt;
		
	}

	public void setCreatedAt(String createdAt) {
		
		this.createdAt = createdAt;
		
	}
	
	public boolean getIs_checked() {
		
		return is_checked;
		
	}

	public void setIs_checked(boolean is_checked) {
		
		this.is_checked = is_checked;
		
	}
	
	public int getUser_id() {
		
		return user_id;
		
	}

	public void setUser_id(int user_id) {
		
		this.user_id = user_id;
		
	}

}
