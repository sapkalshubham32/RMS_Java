package com.app.pojos;

import javax.persistence.*;

@Entity
@Table(name = "managementUsers", schema = "shubh")
public class Management {
	private Integer userId;
	private String name;
	private String email;
	private String password;
	private String phoneNo;
	private String role;

	public Management() {
		super();
		System.out.println("inside Management def constructor");
	}

	public Management(String name, String email, String password, String phoneNo, String role) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.phoneNo = phoneNo;
		this.role = role;
	}

	public Management(Integer userId, String name, String email, String password, String phoneNo, String role) {
		super();
		this.userId = userId;
		this.name = name;
		this.email = email;
		this.password = password;
		this.phoneNo = phoneNo;
		this.role = role;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	@Column(length = 30)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

}
