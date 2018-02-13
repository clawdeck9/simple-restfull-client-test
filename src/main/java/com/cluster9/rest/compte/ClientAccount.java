package com.cluster9.rest.compte;

import java.io.Serializable;
import java.util.Date;

public class ClientAccount implements Serializable {
	// return new ClientAccount(code, name, townName, Age);
	private int code;
	private String name;
	private String townName;
	private int age;
	private Date creationDate;
	
	public ClientAccount() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ClientAccount(int code, String name, String townName, int age) {
		super();
		this.code = code;
		this.name = name;
		this.townName = townName;
		this.age = age;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTownName() {
		return townName;
	}

	public void setTownName(String townName) {
		this.townName = townName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

}
