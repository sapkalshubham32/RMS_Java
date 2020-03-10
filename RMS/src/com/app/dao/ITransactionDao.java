package com.app.dao;

import java.util.List;

import com.app.pojos.Dish;
import com.app.pojos.Transaction;

public interface ITransactionDao {
	boolean validateTransaction(Transaction t);

	Transaction getTransaction(int id);

	boolean saveTransaction(Transaction t);

	public List<Dish> getOrderedDishes(int t);
}
