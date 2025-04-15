package com.yt.SmartTasker.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class EmailUtil {

	@Autowired
	private JavaMailSender mailSender;
	
	public void sendMail(String to) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(to);
		message.setFrom("yashmadavi93@gmail.com");
		message.setSubject("Conformation email");
		message.setText("mail sented successfully");
		
		mailSender.send(message);
	}
}
