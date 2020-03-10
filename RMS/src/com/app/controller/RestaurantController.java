package com.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/rest")
@CrossOrigin(allowedHeaders = "*", origins = "*")
public class RestaurantController {

	@GetMapping("/login")
	public String restaurntLogin() {
		System.out.println("Inside rest login show 1 method");
		return "/RestUsers/homepage";
	}

	@PostMapping("/login")
	public String restaurntLogin(String username, String password, Model map) {
		System.out.println("Inside rest login show 2 method");

		System.out.println(username);
		System.out.println(password);
		if (username.equals("shubham") && password.equals("shubham")) {
			System.out.println();
			return "/RestUsers/loginhomepage";
		}
		map.addAttribute("msg", "Please Enter correct credentails");
		// return "/RestUsers/homepage";
		return "/RestUsers/loginhomepage";
	}

}
