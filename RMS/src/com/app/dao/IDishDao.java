package com.app.dao;

import java.util.List;

import com.app.pojos.Dish;

public interface IDishDao {
	boolean addDish(Dish d);

	List<Dish> ShowAllMenu();

	Dish getDish(int id);

	List<Dish> ShowAllMenubyId(int categoryid);

	boolean deleteDish(int id);
}
