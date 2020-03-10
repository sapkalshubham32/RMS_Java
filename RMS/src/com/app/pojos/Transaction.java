package com.app.pojos;

import java.util.*;

import javax.persistence.*;

@Entity
@Table(name = "Transactions", schema = "shubh")
public class Transaction {
	private Integer transactionId;
	private Customer customer;
	private Integer memberCount;
	private String OTP;
	private DinnerTable dinnerTable;
	private List<Order> order = new ArrayList<Order>();
	private float totalBill;

	public Transaction() {
		super();
		System.out.println("inside transaction def constructor");
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Integer getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(Integer transactionId) {
		this.transactionId = transactionId;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Integer getMemberCount() {
		return memberCount;
	}

	public void setMemberCount(Integer memberCount) {
		this.memberCount = memberCount;
	}

	@Column(length = 10)
	public String getOTP() {
		return OTP;
	}

	public void setOTP(String oTP) {
		OTP = oTP;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "dinnerTable")
	public DinnerTable getDinnerTable() {
		return dinnerTable;
	}

	public void setDinnerTable(DinnerTable dinnerTable) {
		this.dinnerTable = dinnerTable;
	}

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(schema = "shubh", name = "order_transaction", joinColumns = @JoinColumn(name = "transaction_Id"), inverseJoinColumns = @JoinColumn(name = "order_Id"))
	public List<Order> getOrder() {
		return order;
	}

	public void setOrder(List<Order> order) {
		this.order = order;
	}

	@Column(nullable = true)
	public float getTotalBill() {
		return totalBill;
	}

	public void setTotalBill(float totalBill) {
		this.totalBill = totalBill;
	}

	public Transaction(Customer customer, Integer memberCount, String oTP, DinnerTable dinnerTable, Order order,
			float totalBill) {
		super();
		this.customer = customer;
		this.memberCount = memberCount;
		OTP = oTP;
		this.dinnerTable = dinnerTable;
		this.order.add(order);
		this.totalBill = totalBill;
	}

	public Transaction(Integer transactionId, Customer customer, Integer memberCount, String oTP,
			DinnerTable dinnerTable, Order order, float totalBill) {
		super();
		this.transactionId = transactionId;
		this.customer = customer;
		this.memberCount = memberCount;
		OTP = oTP;
		this.dinnerTable = dinnerTable;
		this.order.add(order);
		this.totalBill = totalBill;
	}

	@Override
	public String toString() {
		return "Transaction [transactionId=" + transactionId + ", customer=" + customer + ", memberCount=" + memberCount
				+ ", OTP=" + OTP + ", dinnerTable=" + dinnerTable + ", totalBill=" + totalBill + "]";
	}

}
