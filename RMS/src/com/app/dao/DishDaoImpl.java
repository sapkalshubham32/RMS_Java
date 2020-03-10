package com.app.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.pojos.Dish;

@Transactional
@Repository
public class DishDaoImpl implements IDishDao {

	@Autowired
	SessionFactory sf;
	@Autowired
	ICategoryDao catDao;
	
	@Override
	public boolean addDish(Dish d) {
		System.out.println("inside add dish method"+d);
		Dish d1=new Dish();
		if(!d.getDishId().equals(0))
			d1 = sf.getCurrentSession().get(Dish.class, d.getDishId());
		d1.setCategory(d.getCategory());
		d1.setDishDescription(d.getDishDescription());
		d1.setDishName(d.getDishName());
		d1.setDishPrice(d.getDishPrice());
		sf.getCurrentSession().saveOrUpdate(d1);

		return true;
	}

	@Override
	public List<Dish> ShowAllMenu() {
		String jpql = "select d from Dish d";
		List<Dish> dishlist = sf.getCurrentSession().createQuery(jpql, Dish.class).getResultList();
		return dishlist;
	}

	@Override
	public List<Dish> ShowAllMenubyId(int categoryid) {
		String jpql = "select d from Dish d where categoryId=:catId";
		List<Dish> dishlist = sf.getCurrentSession().createQuery(jpql, Dish.class).setParameter("catId", categoryid)
				.getResultList();
		return dishlist;
	}

	@Override
	public Dish getDish(int id) {
		return sf.getCurrentSession().get(Dish.class, id);
	}

	@Override
	public boolean deleteDish(int id) {
		Session s = sf.getCurrentSession();
		Dish d = s.get(Dish.class, id);
		s.delete(d);
		return true;
	}

}
