package com.app.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.pojos.Order;

import utils.DBUtils;

@Repository
@Transactional
public class OrderDaoImpl implements IOrderDao {

	@Autowired
	SessionFactory sf;

	@Override
	public boolean saveOrder(Order o) {
		try {
			sf.getCurrentSession().saveOrUpdate(o);
			return true;
		} catch (Exception e) {
			System.out.println(
					"00000000000000000000000000000000Error in save order methods0000000000000000000000000000000000000000000000000000");
			e.printStackTrace();
			return false;
		}

	}

	@Override
	public float showTotal(int id) throws SQLException {
		System.out.println("inside show total method");
		String query = "select sum(d.dishprice) from order_transaction ot,order_dish od,dishes d where ot.order_id = od.order_id and od.dish_id=d.dishid and ot.transaction_id="
				+ id;

		Connection con = null;
		try {
			con = DBUtils.getConnection();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		java.sql.PreparedStatement ps = con.prepareStatement(query);
		try (ResultSet rst = ps.executeQuery()) {
			if (rst.next()) {
				return (float) rst.getFloat(1);
			}
		}
		return 0.0f;
	}

}
