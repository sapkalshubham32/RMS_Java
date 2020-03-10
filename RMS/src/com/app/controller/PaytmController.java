package com.app.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.app.dao.IDinnerTable;
import com.app.dao.ITransactionDao;
import com.app.pojos.Dish;
import com.app.pojos.Transaction;
import com.app.services.EmailService;
import com.app.services.GeneratePDF;
import com.itextpdf.text.DocumentException;

@Controller
public class PaytmController {

	@Autowired
	ITransactionDao transactionDao;

	@Autowired
	IDinnerTable tableDao;

	@PostMapping("/paytm")
	public String makePayment(@RequestBody String email, HttpSession hs, Model map)
			throws DocumentException, IOException {
		email = email.replaceFirst("%40", "@");
		String Email[] = email.split("=");
		Transaction tr = (Transaction) hs.getAttribute("transaction");
		System.out.println(email);
		System.out.println(tr);
		List<Dish> dishList = (List<Dish>) hs.getAttribute("orderedlist");
		System.out.println(
				">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>Transaction passed>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		if (!email.equals(null)) {
			if (GeneratePDF.createPdf(tr,dishList)) {
				EmailService.sendEmail(email, tr);
				System.out.println(
						"*****************************Mail Has Been send to" + email + "***************************");
				map.addAttribute("msg", "Bill has been to your Email-Id   :" + Email[1]);
			} else {
				System.out.println("*****************************Mail sending has been failed*************");
				map.addAttribute("msg", "Bill sending has been failed! Please contact to admin");
			}

		}

		tableDao.makeTableVacant(tr.getDinnerTable().getTableNo());

		System.out.println(
				"********************************************inside paytm*************************************************");
		return "/transaction/logout";

	}

}
