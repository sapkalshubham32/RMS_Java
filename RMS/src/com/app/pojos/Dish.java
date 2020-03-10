package com.app.pojos;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "dishes", schema = "shubh")
public class Dish {
	private Integer dishId = 0;
	private String dishName;
	private boolean availabilityStatus;
	private String dishDescription;
	private float dishPrice;
	private Category category;
	private Set<Order> order = new HashSet<Order>();

	@Column(length = 30)
	public String getDishDescription() {
		return dishDescription;
	}

	public void setDishDescription(String dishDescription) {
		this.dishDescription = dishDescription;
	}

	public Dish() {
		super();
		System.out.println("In side Dish def Constructor");
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(length = 10)
	public Integer getDishId() {
		return dishId;
	}

	public void setDishId(Integer dishId) {
		this.dishId = dishId;
	}

	@Column(unique = true, length = 30, nullable = false)
	public String getDishName() {
		return dishName;
	}

	public void setDishName(String dishName) {
		this.dishName = dishName;
	}

	@Column(length = 5, nullable = false)
	public boolean isAvailabilityStatus() {
		return availabilityStatus;
	}

	public void setAvailabilityStatus(boolean availabilityStatus) {
		this.availabilityStatus = availabilityStatus;
	}

	@Column(length = 10, nullable = false)
	public float getDishPrice() {
		return dishPrice;
	}

	public void setDishPrice(float dishPrice) {
		this.dishPrice = dishPrice;
	}

	@ManyToOne
	@JoinColumn(name = "CategoryId")
	public Category getCategory() {
		return category;
	}

	public void setCategory(Category categoryId) {
		this.category = categoryId;
	}

	@ManyToMany(mappedBy = "dish")
	public Set<Order> getOrder() {
		return order;
	}

	public void setOrder(Set<Order> order) {
		this.order = order;
	}

	public Dish(String dishName, boolean availabilityStatus, int quantity, String dishDescription, float dishPrice,
			Category category, Set<Order> order) {
		super();
		this.dishName = dishName;
		this.availabilityStatus = availabilityStatus;
		this.dishDescription = dishDescription;
		this.dishPrice = dishPrice;
		this.category = category;
		this.order = order;
	}

	public Dish(Integer dishId, String dishName, int quantity, boolean availabilityStatus, String dishDescription,
			float dishPrice, Category category, Set<Order> order) {
		super();
		this.dishId = dishId;
		this.dishName = dishName;
		this.availabilityStatus = availabilityStatus;
		this.dishDescription = dishDescription;
		this.dishPrice = dishPrice;
		this.category = category;
		this.order = order;
	}

	@Override
	public String toString() {
		return "Dish [dishId=" + dishId + ", dishName=" + dishName + ", availabilityStatus=" + availabilityStatus
				+ ", dishDescription=" + dishDescription + ", dishPrice=" + dishPrice + ", category=" + category + "]";
	}

}