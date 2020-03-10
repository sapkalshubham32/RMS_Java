package com.app.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.pojos.Category;

@Transactional
@Repository
public class CategoryDaoImpl implements ICategoryDao {

	@Autowired
	SessionFactory sf;

	@Override
	public List<Category> showCategory() {
		System.out.println("inside show category list method");
		String jpql = "select c from Category c order by categoryId";

		List<Category> s = new ArrayList<>();
		s = sf.getCurrentSession().createQuery(jpql, Category.class).getResultList();
		return s;
	}

}
