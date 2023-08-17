package com.velocity.mailsender.service;

import java.io.IOException;
import java.io.StringWriter;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

	private final JavaMailSender mailSender;
	private final VelocityEngine velocityEngine;

	@Autowired
	public EmailService(JavaMailSender mailSender, VelocityEngine velocityEngine) {
		this.mailSender = mailSender;
		this.velocityEngine = velocityEngine;
	}

	public void sendEmail(String recipient, String name) throws MessagingException, IOException {
		MimeMessage message = mailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message, true);

		helper.setTo(recipient);
		helper.setSubject("Sample Email Using Velocity Template");

		VelocityContext velocityContext = new VelocityContext();
		velocityContext.put("name", name);

		Template template = velocityEngine.getTemplate("email-template.vm");

		String content = mergeTemplate(template, velocityContext);
		helper.setText(content, true);

		mailSender.send(message);
	}

	private String mergeTemplate(Template template, VelocityContext velocityContext) {
		StringWriter writer = new StringWriter();
		template.merge(velocityContext, writer);
		return writer.toString();
	}
}
