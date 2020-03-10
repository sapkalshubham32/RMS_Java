package com.app.pojos;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "dinnertables",schema = "shubh")
public class DinnerTable {
	private Integer tableNo;
	private Integer tableCapacity;
	private char billStatus;		//v = vacant , e = engaged , i = in-process , w = waiting
	private Set<Transaction> transaction = new HashSet<Transaction>();
	
	public DinnerTable(Integer tableCapacity, char billStatus, Set<Transaction> transaction) {
		super();
		this.tableCapacity = tableCapacity;
		this.billStatus = billStatus;
		this.transaction = transaction;
	}

	public DinnerTable(Integer tableNo, Integer tableCapacity, char billStatus, Set<Transaction> transaction) {
		super();
		this.tableNo = tableNo;
		this.tableCapacity = tableCapacity;
		this.billStatus = billStatus;
		this.transaction = transaction;
	}

	public DinnerTable() {
		super();
		System.out.println("Inside dinnertable def constructor");
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Integer getTableNo() {
		return tableNo;
	}

	public void setTableNo(Integer tableNo) {
		this.tableNo = tableNo;
	}

	@Column(length = 5, nullable = false)
	public Integer getTableCapacity() {
		return tableCapacity;
	}

	public void setTableCapacity(Integer tableCapacity) {
		this.tableCapacity = tableCapacity;
	}

	@OneToMany
	@JoinColumn(name = "dinnerTable")
	public Set<Transaction> getTransaction() {
		return transaction;
	}

	public void setTransaction(Set<Transaction> transaction) {
		this.transaction = transaction;
	}

	public char getBillStatus() {
		return billStatus;
	}

	public void setBillStatus(char billStatus) {
		this.billStatus = billStatus;
	}

	@Override
	public String toString() {
		return "DinnerTable [tableNo=" + tableNo + ", tableCapacity=" + tableCapacity + ", billStatus=" + billStatus
				+ "]";
	}

}
