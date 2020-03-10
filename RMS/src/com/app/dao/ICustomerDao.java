package com.app.dao;

import com.app.pojos.Customer;
import com.app.pojos.Transaction;

public interface ICustomerDao {

	Transaction validateCustomer(Customer c, int memberCount);

	Transaction allocateTable(int memberCount, Customer c);

	Customer getCustomer(Integer transactionId);
}
