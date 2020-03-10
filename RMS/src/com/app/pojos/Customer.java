package com.app.pojos;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "customers", schema = "shubh")
public class Customer {
	private Integer customerId;
	private String mobileNo;
	private String name;
	private String email;
	private Set<Transaction> transaction = new HashSet<Transaction>();

	public Customer() {
		super();
		System.out.println("Inside Customer def constructor");

	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	@Column(nullable = false, unique = true)
	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@OneToMany(mappedBy = "customer")
	public Set<Transaction> getTransaction() {
		return transaction;
	}

	public void setTransaction(Set<Transaction> transaction) {
		this.transaction = transaction;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Customer(String mobileNo, String name, String email, Set<Transaction> transaction) {
		super();
		this.mobileNo = mobileNo;
		this.name = name;
		this.email = email;
		this.transaction = transaction;
	}

	public Customer(Integer customerId, String mobileNo, String name, String email, Set<Transaction> transaction) {
		super();
		this.customerId = customerId;
		this.mobileNo = mobileNo;
		this.name = name;
		this.email = email;
		this.transaction = transaction;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", mobileNo=" + mobileNo + ", name=" + name + ", email=" + email
				+ "]";
	}

}
