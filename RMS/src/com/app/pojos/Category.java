package com.app.pojos;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "categorys", schema = "shubh")
public class Category {

	private Integer categoryId;
	private String categoryName;
	private Set<Dish> dish = new HashSet<Dish>();

	@OneToMany(mappedBy = "category")
	public Set<Dish> getDish() {
		return dish;
	}

	public void setDish(Set<Dish> dish) {
		this.dish = dish;
	}

	public Category() {
		super();
		System.out.println("Inside category default constr");
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	@Column(unique = true, length = 30, nullable = false)
	@JoinColumn(name = "categoryId")
	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public Category(Integer categoryId, String categoryName, Set<Dish> dish) {
		super();
		this.categoryId = categoryId;
		this.categoryName = categoryName;
		this.dish = dish;
	}

	public Category(String categoryName, Set<Dish> dish) {
		super();
		this.categoryName = categoryName;
		this.dish = dish;
	}

	@Override
	public String toString() {
		return "Category [categoryId=" + categoryId + ", categoryName=" + categoryName + "]";
	}

}
