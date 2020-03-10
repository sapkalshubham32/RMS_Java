package com.app.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.dao.ICustomerDao;
import com.app.dao.IDishDao;
import com.app.dao.IOrderDao;
import com.app.dao.ITransactionDao;
import com.app.pojos.Cart;
import com.app.pojos.Dish;
import com.app.pojos.Order;
import com.app.pojos.Transaction;

@Controller
@RequestMapping("/order")
public class OrderController {

	List<Dish> list;

	@Autowired
	IDishDao dishDao;

	@Autowired
	ITransactionDao transactionDao;

	@Autowired
	ICustomerDao custDao;

	@Autowired
	IOrderDao orderDao;

	@GetMapping("/main")
	public String showMenu(Order o, Model map) {
		System.out.println(
				"**********************************************Start of Show menu Method*********************************");
		System.out.println("inside order controller and show menu method");
		map.addAttribute("dish_List1", dishDao.ShowAllMenubyId(1));
		map.addAttribute("dish_List2", dishDao.ShowAllMenubyId(2));
		map.addAttribute("dish_List3", dishDao.ShowAllMenubyId(3));
		map.addAttribute("dish_List4", dishDao.ShowAllMenubyId(4));
		map.addAttribute("dish_List5", dishDao.ShowAllMenubyId(5));
		map.addAttribute("dish_List6", dishDao.ShowAllMenubyId(6));
		System.out.println(
				"**********************************************End of Show menu Method*********************************");
		return "/menu/display";
	}

	@GetMapping("/add")
	public String addToCart(@RequestParam int[] dish, HttpSession hs, Model map) {

		if (dish[0] == 0 && dish.length == 1) {
			map.addAttribute("dish_List1", dishDao.ShowAllMenubyId(1));
			map.addAttribute("dish_List2", dishDao.ShowAllMenubyId(2));
			map.addAttribute("dish_List3", dishDao.ShowAllMenubyId(3));
			map.addAttribute("dish_List4", dishDao.ShowAllMenubyId(4));
			map.addAttribute("dish_List5", dishDao.ShowAllMenubyId(5));
			map.addAttribute("dish_List6", dishDao.ShowAllMenubyId(6));

			map.addAttribute("Message", "Dear sir <br/> Please select Dishes you want to order");
			return "/menu/display";
		}
		System.out.println(
				"**********************************************Start of Add to cart method*********************************");
		Cart tcart = (Cart) hs.getAttribute("totalcart");
		Cart cart = (Cart) hs.getAttribute("cart");
		for (int x : dish) {
			System.out.println("Value of Dish " + x);
			{
				if (x != 0)
					cart.getList().add(x);
				else
					System.out.println(
							"~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			}
		}

		tcart.getList().addAll(cart.getList());
		System.out.println(cart);
		hs.setAttribute("totalcart", tcart);
		hs.setAttribute("cart", cart);
		System.out.println(
				"**********************************************End of add to cart Method*********************************");
		return "redirect:/order/main";
	}

	@GetMapping("/show")
	public String showCart(HttpSession hs, Model map) throws SQLException {
		System.out.println(
				"**********************************************start of Show cart Method*********************************");
		List<Dish> list = new ArrayList<>();
		Transaction tr = (Transaction) hs.getAttribute("transaction");
		Cart cart = (Cart) hs.getAttribute("cart");
		for (int x : cart.getList()) {
			System.out.println("Value of Dish " + x);
			list.add(dishDao.getDish(x));
		}
		System.out.println(cart);
		hs.setAttribute("bill", orderDao.showTotal(tr.getTransactionId()));
		map.addAttribute("cartList", list);
		System.out.println(
				"**********************************************Start of Show menu Method*********************************");
		return "/menu/showcart";
	}

	@PostMapping("/show")
	public String PlaceOrder(HttpSession hs, Model map, @RequestParam int[] qty) throws SQLException {
		System.out.println(
				"-------------------------------------------------------------------------------------------------------------");
		Transaction tr = (Transaction) hs.getAttribute("transaction");
		System.out.println("Session scope wala tr" + tr);
		Cart cart = (Cart) hs.getAttribute("cart");
		Order o = new Order();
		System.out.println(qty);
		int q = 0;
		for (int x : cart.getList()) {
			System.out.println("Value of Dish " + x);
			Dish d = dishDao.getDish(x);
			o.getDish().add(d);
		
			o.setQuantity(qty[q]);
			q++;
		}
		

		System.out.println("Order is " + o);
		o.getTransaction().add(tr);
		System.out.println("Order is " + o);
		o.getTransaction().add(tr);
		System.out.println(o);
		System.out.println(tr);
		if (orderDao.saveOrder(o)) {
			System.out.println("Inside Save order true branch");
			map.addAttribute("msg", "Your order is under process");
		} else {
			System.out.println("Inside Save order false branch");
			map.addAttribute("msg", "Your order failed");
		}
		tr.getOrder().add(o);
		transactionDao.saveTransaction(tr);
		System.out.println(tr);
		System.out.println(cart);
		map.addAttribute("cartList", list);
		hs.setAttribute("cart", new Cart());
		tr.setTotalBill(orderDao.showTotal(tr.getTransactionId()));
		hs.setAttribute("transaction", tr);

		System.out.println(map.getAttribute("bill"));
		hs.setAttribute("cartList", list);
		System.out.println(
				"**********************************************End of place order*********************************");
		return "redirect:/order/showbill";

	}

	@GetMapping("/delete")
	public String deleteFromCart(@RequestParam int id, HttpSession hs, Model map) {

		list = new ArrayList<>();
		System.out.println("inside delete from cart ");
		Cart cart = (Cart) hs.getAttribute("cart");
		cart.getList().remove((Object) id);
		System.out.println(cart);
		for (int x : cart.getList()) {
			System.out.println("Value of Dish " + x);
			Dish d = dishDao.getDish(x);
			list.add(d);
		}
		System.out.println(cart);

		map.addAttribute("cartList", list);
		return "/menu/showcart";
	}

	@GetMapping("/showbill")
	public String showBill(HttpSession hs, Model map) {

		List<Dish> placedOrder = new ArrayList<Dish>();

		Cart cart = (Cart) hs.getAttribute("totalcart");
		for (int x : cart.getList()) {
			System.out.println("Value of Dish " + x);
			Dish d = dishDao.getDish(x);
			placedOrder.add(d);
		}

		map.addAttribute("placedorder", placedOrder);

		return "/order/showbill";
	}

	@PostMapping("/showbill")
	public String checkOut(HttpSession hs, Model map) throws SQLException {
		Transaction tr = (Transaction) hs.getAttribute("transaction");
		map.addAttribute("cust", custDao.getCustomer(tr.getTransactionId()));
		hs.setAttribute("orderedlist", transactionDao.getOrderedDishes(tr.getTransactionId()));
		tr.setTotalBill(orderDao.showTotal(tr.getTransactionId()));
		transactionDao.saveTransaction(tr);
		return "/transaction/checkout";

	}

}
