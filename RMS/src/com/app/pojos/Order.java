package com.app.pojos;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "orders", schema = "shubh")
public class Order {
	private Integer orderId;
	private boolean processingStatus;
	private Integer quantity;
	private Set<Dish> dish = new HashSet<Dish>();
	private Set<Transaction> transaction = new HashSet<Transaction>();

	public Order() {
		super();
		System.out.println("Inside order class def constructor");
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	@Column(length = 10, nullable = false)
	public boolean isProcessingStatus() {
		return processingStatus;
	}

	public void setProcessingStatus(boolean processingStatus) {
		this.processingStatus = processingStatus;
	}

	@Column(length = 5, nullable = false)
	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	@ManyToMany
	@JoinTable(schema = "shubh", name = "order_dish", joinColumns = @JoinColumn(name = "order_Id"), inverseJoinColumns = @JoinColumn(name = "dish_Id"))
	public Set<Dish> getDish() {
		return dish;
	}

	public void setDish(Set<Dish> dish) {
		this.dish = dish;
	}

	@ManyToMany(mappedBy = "order")
	public Set<Transaction> getTransaction() {
		return transaction;
	}

	public void setTransaction(Set<Transaction> transactionId) {
		this.transaction = transactionId;
	}

	public Order(boolean processingStatus, Integer quantity, Set<Dish> dish, Set<Transaction> transaction) {
		super();
		this.processingStatus = processingStatus;
		this.quantity = quantity;
		this.dish = dish;
		this.transaction = transaction;
	}

	public Order(Integer orderId, boolean processingStatus, Integer quantity, Set<Dish> dish,
			Set<Transaction> transaction) {
		super();
		this.orderId = orderId;
		this.processingStatus = processingStatus;
		this.quantity = quantity;
		this.dish = dish;
		this.transaction = transaction;
	}

}
