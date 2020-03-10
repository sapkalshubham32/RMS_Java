package com.app.controller;

import java.io.FileNotFoundException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.dao.ICustomerDao;
import com.app.pojos.Customer;
import com.app.pojos.Transaction;
import com.app.services.GeneratePDF;
import com.itextpdf.text.DocumentException;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;

@Controller
@RequestMapping("/new")
public class ManagementController {

	public final String ACCOUNT_SID = "AC89997ba3f0f0c50343f3ead99f2e1008";
	//public final String ACCOUNT_SID = "AC4eeedb72df1874ce47d1fff64ef16690";
	public final String AUTH_TOKEN = "88609e947329e108d7810e55cfc4216e";
	@Autowired
	private ICustomerDao custDao;
	@Autowired
	GeneratePDF p;

	private Customer cust;
	private Transaction t = new Transaction();

	@GetMapping("/registration")
	public String validateCustomer(Customer c) throws FileNotFoundException, DocumentException {
		// p.createPdf();
		// System.out.println("inside validate customer controller method");
		return "/registration/customerForm";
	}

	@PostMapping("/registration")
	public String newCustomer(HttpSession hs, Customer c, @RequestParam int noOfMember, Model map) {
		this.t = custDao.validateCustomer(c, noOfMember);
		cust = c;
		sendSms();
		hs.setAttribute("transaction", t);
		System.out.println("empty dinner table status is " + t.getDinnerTable());
		if (t.getDinnerTable().getBillStatus() != 'x') {
			map.addAttribute("table_update_msg",
					"You have been allocated with a table!!!  " + t.getDinnerTable().getTableNo());
			return "/update";
		} else
			map.addAttribute("table_update_msg", "Sorry!!! We are full now you have to wait few minutes");
		return "/wait";
	}

	private void sendSms() {

		Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
		String SMS = "Dear " + cust.getName() + ".You have registered at XYZ restaurant with customer ID : "
				+ t.getTransactionId() + " and otp :" + t.getOTP() + ". Soon you will receive next update.";

		Message message = Message.creator(new com.twilio.type.PhoneNumber("+91" + cust.getMobileNo()),
				new com.twilio.type.PhoneNumber("+12017629116"), SMS).create();
		System.out.println(SMS);
		System.out.println(message.getSid());
	}
}
