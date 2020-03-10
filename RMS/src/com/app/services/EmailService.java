package com.app.services;

import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import com.app.pojos.Transaction;

public class EmailService {

	public static Boolean sendEmail(String to, Transaction t) {
		System.out.println(to);
		to = to.replaceFirst("%40", "@");
		String too[] = to.split("=");
		System.out.println(too[0]);
		System.out.println(too[1]);
		System.out.println(
				"...............................................................................................");
		// Sender's email ID needs to be mentioned
		String from = "rmsproject123@gmail.com";

		final String username = "rmsproject123@gmail.com";// change accordingly
		final String password = "ajaynayakar";// change accordingly

//		String from = "ajaynayakarr@gmail.com";
//
//		final String username = "ajaynayakarr@gmail.com";// change accordingly
//		final String password = "ajaynayakar22101996";// change accordingly

		// Assuming you are sending email through relay.jangosmtp.net
		String host = "relay.jangosmtp.net";
		System.out.println(username);
		Properties props = new Properties();
		props.setProperty("mail.transport.protocol", "smtp");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.setProperty("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
		props.setProperty("mail.host", "smtp.gmail.com");
		// props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.socketFactory.fallback", "true");
		props.setProperty("mail.debug", "true");

		// Get the Session object.
		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});

		try {
			// Create a default MimeMessage object.
			Message message = new MimeMessage(session);

			// Set From: header field of the header.
			message.setFrom(new InternetAddress(from));

			// Set To: header field of the header.
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(too[1]));

			// Set Subject: head er field
			message.setSubject("Testing Subject");

			// Create the message part
			BodyPart messageBodyPart = new MimeBodyPart();

			// Now set the actual message
			messageBodyPart.setText("This is test Email from shubham sapkal");

			// Create a multipar message
			Multipart multipart = new MimeMultipart();

			// Set text message part
			multipart.addBodyPart(messageBodyPart);

			// Part two is attachment
			messageBodyPart = new MimeBodyPart();
			String filename = "E:\\C-DAC\\Restaurant management system\\Bills\\" + t.getCustomer().getName() + "_"
					+ t.getTransactionId() + ".pdf";
			DataSource source = new FileDataSource(filename);
			messageBodyPart.setDataHandler(new DataHandler(source));
			messageBodyPart.setFileName(filename);
			multipart.addBodyPart(messageBodyPart);

			// Send the complete message parts
			message.setContent(multipart);
			System.out.println("Sent message successfully....");
			// Send message
			Transport.send(message);

			System.out.println("Sent message successfully....");
			return true;
		} catch (MessagingException e) {
			System.out.println(
					"@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@Email Exception@@@@@@@@@@@@@@@@@@@@@@@@@@@");
			e.printStackTrace();
			return false;
		}
	}
}
