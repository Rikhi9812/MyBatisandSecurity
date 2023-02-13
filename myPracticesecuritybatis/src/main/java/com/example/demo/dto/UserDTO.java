package com.example.demo.dto;

import com.example.demo.model.Role;

public class UserDTO {

	private Long id;
	private String username;
	private String password;
	private byte b;
	private boolean enabled;
	private Role role;

	public Long getId() {
		return id;
	}
	

	public void setId(Long id) {
		this.id = id;
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

	public byte getB() {
		if(this.enabled == true) {
			b = 1;
		} else {
			b = 0;
		}
		return b;
	}

	public void setB(byte b) {
		this.b = b;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}


	

}
