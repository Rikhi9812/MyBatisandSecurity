package com.example.demo.model;

public class Role {
	
	public Role() {
		
	}
	
	

	private int id;
	private String rolename;

	public int getId() {
		return id;
	}

	
	public void setId(int id) {
		this.id = id;
	}

	public String getRolename() {
		return rolename;
	}

	public void setRolename(String rolename) {
		this.rolename = rolename;
	}


	public Role(int id, String rolename) {
		this.id = id;
		this.rolename = rolename;
	}

		
}
