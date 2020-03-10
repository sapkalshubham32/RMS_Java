package com.app.controller;

import java.io.FileNotFoundException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app.dao.ITransactionDao;
import com.app.pojos.Cart;
import com.app.pojos.Transaction;
import com.itextpdf.text.DocumentException;

@Controller
@RequestMapping("/cust")
public class CustomerController {

	@Autowired
	ITransactionDao tr;

	@GetMapping("/login")
	public String customerLogin(Transaction t) throws FileNotFoundException, DocumentException {
		System.out.println("inside getmethod");

		return "/login/CustomerLogin";
	}

	@PostMapping("/login")
	public String vaildateLogin(Transaction t, Model map, HttpSession hs) {
		Transaction t1 = tr.getTransaction(t.getTransactionId());
		System.out.println("Database transaction record is " + t1);
		hs.setAttribute("transaction", t1);
		hs.setAttribute("cart", new Cart());
		hs.setAttribute("totalcart", new Cart());
		System.out.println("Traction dtls  :" + t);
		System.out.println("inside validate method");
		if (tr.validateTransaction(t)) {
			return "redirect:/order/main";
		} else
			map.addAttribute("message", "Dear sir please enter valid credentials");
		return "redirect:/cust/login";
	}

}
