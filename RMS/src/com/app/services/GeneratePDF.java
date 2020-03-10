package com.app.services;

import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.ITransactionDao;
import com.app.dao.TransactionDaoImpl;
import com.app.pojos.Dish;
import com.app.pojos.Transaction;
import com.itextpdf.html2pdf.HtmlConverter;
import com.itextpdf.text.DocumentException;

@Transactional
@Repository
public class GeneratePDF {

	public static boolean createPdf(Transaction t, List<Dish> dishList) throws DocumentException, IOException {

		ITransactionDao transactionDao = new TransactionDaoImpl();

		// List<Dish> dishlist = transactionDao.getOrderedDishes(t.getTransactionId());
		Date date = new Date();
		SimpleDateFormat dateformat = new SimpleDateFormat("dd-MM-yyyy");
		System.out.println(dishList);
		System.out.println(
				"++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		String outputfile = "E:\\C-DAC\\Restaurant management system\\Bills\\" + t.getCustomer().getName() + "_"
				+ t.getTransactionId() + ".pdf";

		String html = "<!DOCTYPE html>" + "<html>" + "<head>" + "<meta charset=\"ISO-8859-1\">"
				+ "<title>Insert title here</title>" + "</head>" + "<body>"
				+ "	<form method='post' action= 'RMS/paytm' align='center'>"
				+ "<h1><center>	Mrignayani Restaurant,<br/>Pune.</center></h1><br/>" + "<h3>"
				+ "<text>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp"
				+ ";&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
				+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
				+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
				+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
				+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Date:" + dateformat.format(date)
				/* + "/" + date.getMonth() + "/" + date.getYear() */ + " </text><br/><left>Customer Id:"
				+ t.getCustomer().getCustomerId() + " </left></h3>" + "<h3><left>Customer Name:"
				+ t.getCustomer().getName() + "</left></h3>" + "<h3><left>Registered Email:"
				+ t.getCustomer().getEmail() + "</left></h3>" + "<h3><left>Contact:" + t.getCustomer().getMobileNo()
				+ "</left></h3>" + "<table cellpadding = '20' align='center'>" + "<tr>"
				+ "<th>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Item No&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</th>"
				+ "<th>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Description&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</th>"
				+ "<th>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Quantity&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</th>"
				+ "<th>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Price&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</th>" + "</tr>" + "<tr>";
		String dishrows = "";
		int srNo = 1;
		for (Dish dish : dishList) {
			dishrows += "<td align='center'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + srNo++
					+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>" + "<td align='center'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
					+ dish.getDishName() + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>"
					+ "<td align='center'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + 1 + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>"
					+ "<td align='center'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + dish.getDishPrice()
					+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>" + "</tr>";
		}
		dishrows += "<tr>" + "<td></td>" + "<td></td>"
				+ "<td align='center' ><h3>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;TOTAL:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</h3></td>"
				+ "<td align='center'><h3>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + t.getTotalBill()
				+ "&nbsp;&nbsp;&nbsp;&nbsp;</h3></td>" + "</tr>";

		System.out.println(outputfile);

		try {
			HtmlConverter.convertToPdf(html + dishrows, new FileOutputStream(outputfile));
			System.out.println("Done with pdf  ");
			return true;
		} catch (Exception e) {
			System.out.println(
					"=========================================Inside PDF generate method exception======================");
		}
		return false;
	}

}
