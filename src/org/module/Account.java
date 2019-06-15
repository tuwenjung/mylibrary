package org.module;

import java.io.Serializable;

public class Account implements Serializable{
	private Integer id;
	private String name;
	private String password;
	private Byte role;
	public Account() {}
	
	public Account(String name, String password, Byte role) {
		this.name = name;
		this.password = password;
		this.role = role;
	}

	public Account(Integer id, String name, String password, Byte role) {
		this.id = id;
		this.name = name;
		this.password = password;
		this.role = role;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Byte getRole() {
		return role;
	}
	public void setRole(Byte role) {
		this.role = role;
	}
	
}
