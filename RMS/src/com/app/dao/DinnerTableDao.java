package com.app.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.pojos.DinnerTable;


@Transactional
@Repository
public class DinnerTableDao implements IDinnerTable {

	@Autowired
	SessionFactory sf;

	@Override
	public boolean makeTableVacant(int id) {
		DinnerTable d = sf.getCurrentSession().get(DinnerTable.class, id);
		d.setBillStatus('v');
		return false;
	}

}
