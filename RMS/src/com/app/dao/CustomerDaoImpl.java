package com.app.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.pojos.Customer;
import com.app.pojos.DinnerTable;
import com.app.pojos.Order;
import com.app.pojos.Transaction;

@Transactional
@Repository
public class CustomerDaoImpl implements ICustomerDao {
	@Autowired
	private SessionFactory sf;
	@Autowired
	private ICustomerDao dao;
	Transaction t = new Transaction();

	Session s;

	public CustomerDaoImpl() {
		super();
		System.out.println("inside customerdaoimpl def constrctor");
	}

	@Override
	public Transaction validateCustomer(Customer c, int memberCount) {
		s = sf.getCurrentSession();
		String jpql = "select c from Customer c where c.mobileNo = :mn";
		try {
			c = sf.getCurrentSession().createQuery(jpql, Customer.class).setParameter("mn", c.getMobileNo())
					.getSingleResult();
		} catch (RuntimeException e) {
			int x = (int) s.save(c);
			c = s.get(Customer.class, x);
		}

		return dao.allocateTable(memberCount, c);

	}

	@Override
	public Transaction allocateTable(int memberCount, Customer c) {

		boolean flag = false;
		DinnerTable d = null;
		String jpql1 = "";
		String otp = geek_OTP(); // OTP call
		Order o = new Order();
		o.setQuantity(0);
		t = new Transaction(1, c, memberCount, otp, d, o, 0);
		System.out.println("Before if block" + t);
		if (memberCount <= 2) {
			jpql1 = "select d from DinnerTable d where d.tableCapacity = 2 and d.billStatus = 'v' and rownum = 1";
		} else if (memberCount <= 4 && memberCount > 2) {
			jpql1 = "select d from DinnerTable d where d.tableCapacity = 4 and d.billStatus = 'v' and rownum = 1";
		} else if (memberCount <= 6 && memberCount > 4) {
			jpql1 = "select d from DinnerTable d where d.tableCapacity = 6 and d.billStatus = 'v' and rownum = 1";
		}

		try {
			d = s.createQuery(jpql1, DinnerTable.class).getSingleResult();
			System.out.println(d);
			d.setBillStatus('i'); // processed if the table is allocated
		} catch (Exception e) {

			flag = true;
			System.out.println("inside allocate table  method catch block hiiiiii");
			d = s.get(DinnerTable.class, 100);
			System.out.println(d);
		}

		System.out.println("inside allocate table  after catch block 1");
		o.getTransaction().add(t);
		System.out.println("inside allocate table  after catch block 2");
		c.getTransaction().add(t);
		System.out.println("inside allocate table  after catch block 3");
		if (flag == true)
			d.setBillStatus('x');
		System.out.println("inside allocate table  after catch block 4");
		t.setDinnerTable(d);
		System.out.println(d);
		System.out.println(t);
		System.out.println("at the end of vadidate customer method 9");
		System.out.println(c);
		s.save(t);
		System.out.println("at the end of vadidate customer method 12");
		System.out.println(t);
		s.save(c);
		System.out.println(d.getTableNo());
		s.update(d);
		System.out.println("at the end of vadidate customer method 13");
		s.save(o);
		return t;
	}

	static String geek_OTP() {
		System.out.println("Generating password using random() : ");
		System.out.print("Your new password is : ");

		String Capital_chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String Small_chars = "abcdefghijklmnopqrstuvwxyz";
		String numbers = "0123456789";
		String symbols = "!@#$%^&*_=+-/.?<>)";

		String values = Capital_chars + Small_chars + numbers + symbols;

		// Using random method
		Random rndm_method = new Random();

		char[] otp = new char[6];

		for (int i = 0; i < 6; i++) {

			otp[i] = values.charAt(rndm_method.nextInt(values.length()));

		}

		String s = new String(otp);
		return s;

	}

	@Override
	public Customer getCustomer(Integer transactionId) {
		Customer c = new Customer();
		List<Object[]> o = sf.getCurrentSession().createSQLQuery(
				"select customerid,email,mobileno,name from customers c,transactions t where c.customerid = t.customer_customerid and t.transactionid =:id")
				.setParameter("id", transactionId).list();
		for (Object[] row : o) {

			c.setCustomerId(Integer.parseInt(row[0].toString()));
			c.setEmail(row[1].toString());
			c.setMobileNo(row[2].toString());
			c.setName(row[3].toString());
		}
		return c;
	}

}
