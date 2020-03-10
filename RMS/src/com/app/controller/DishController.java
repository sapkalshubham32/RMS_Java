package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.app.dao.ICategoryDao;
import com.app.dao.IDishDao;
import com.app.pojos.Dish;

@Controller
@RequestMapping("/dish")
public class DishController {

	@Autowired
	ICategoryDao dao;
	@Autowired
	IDishDao dishDao;

	@GetMapping("/add")
	public String DishFormShow(Dish d, Model map) {
		map.addAttribute("category_list", dao.showCategory());
		return "/dish/add";
	}

	@GetMapping("/edit")
	public String EditDish(Dish d, Model map, @RequestParam int Id) {
	//	dishDao.getDish(Id);
		map.addAttribute("category_list", dao.showCategory());
		System.out.println("inside edit dish");
		map.addAttribute("dish", dishDao.getDish(Id));
		return "/dish/add";
	}

	@GetMapping("/delete")
	public String deleteDish(@RequestParam int Id,Model map) {
		if (dishDao.deleteDish(Id))
			map.addAttribute("dish_List", dishDao.ShowAllMenu());
			return "/dish/totalMenu";
	}

	@GetMapping("/add_dish")
	public String DishFormInsert(Dish d) {
		System.out.println("In side DishForm Insert");
		dishDao.addDish(d);
		return "redirect:/dish/showMenu";
	}

	@GetMapping("/showMenu")
	public String showMenu(Model map) {
		map.addAttribute("dish_List", dishDao.ShowAllMenu());
		return "/dish/totalMenu";
	}

}
