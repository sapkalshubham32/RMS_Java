package com.app.pojos;

import java.util.ArrayList;
import java.util.List;

public class Cart {

	private int cartId;
	private Transaction transaction;
	private List<Integer> list = new ArrayList<Integer>();

	public Cart() {
		System.out.println("In cart construtor");
	}

	public Cart(int cartId, Transaction transaction, List<Integer> list) {
		super();
		this.cartId = cartId;
		this.transaction = transaction;
		this.list = list;
	}

	public Cart(Transaction transaction, List<Integer> list) {
		super();
		this.transaction = transaction;
		this.list = list;
	}

	public int getCartId() {
		return cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	public Transaction getTransaction() {
		return transaction;
	}

	public void setTransaction(Transaction transaction) {
		this.transaction = transaction;
	}

	public List<Integer> getList() {
		return list;
	}

	public void setList(List<Integer> list) {
		this.list = list;
	}

	@Override
	public String toString() {
		return "Cart [cartId=" + cartId + ", transaction=" + transaction + ", list=" + list + "]";
	}

}
