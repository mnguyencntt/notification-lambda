package com.anz.platform.service;

import static com.anz.platform.util.Constants.EMAIL_SENT_SUCCESSFUL;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import com.anz.platform.domain.EmailInfo;
import com.anz.platform.domain.MessageInfo;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Setter
public class EmailService {
  private EmailInfo emailInfo;

  public EmailService(final EmailInfo emailInfo) {
    this.emailInfo = emailInfo;
  }

  public void sendEmailTLS(final MessageInfo messageInfo) {
    Properties prop = new Properties();
    prop.put("mail.smtp.host", "smtp.gmail.com");
    prop.put("mail.smtp.port", "587");
    prop.put("mail.smtp.auth", "true");
    prop.put("mail.smtp.starttls.enable", "true");

    Session session = Session.getInstance(prop, new javax.mail.Authenticator() {
      protected PasswordAuthentication getPasswordAuthentication() {
        return new PasswordAuthentication(emailInfo.getUsername(), emailInfo.getPassword());
      }
    });
    try {
      Message message = new MimeMessage(session);
      message.setFrom(new InternetAddress("anz.farmer.platform@gmail.com"));
      message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(messageInfo.getSesEmail()));
      message.setSubject(messageInfo.getSubject());
      message.setText(messageInfo.getContentBody());
      Transport.send(message);
      log.info(EMAIL_SENT_SUCCESSFUL);
    } catch (MessagingException e) {
      e.printStackTrace();
    }
  }

  public void sendEmailSSL(final MessageInfo messageInfo) {
    Properties prop = new Properties();
    prop.put("mail.smtp.host", "smtp.gmail.com");
    prop.put("mail.smtp.port", "465");
    prop.put("mail.smtp.auth", "true");
    prop.put("mail.smtp.socketFactory.port", "465");
    prop.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");

    Session session = Session.getInstance(prop, new javax.mail.Authenticator() {
      protected PasswordAuthentication getPasswordAuthentication() {
        return new PasswordAuthentication(emailInfo.getUsername(), emailInfo.getPassword());
      }
    });
    try {
      Message message = new MimeMessage(session);
      message.setFrom(new InternetAddress("anz.farmer.platform@gmail.com"));
      message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(messageInfo.getSesEmail()));
      message.setSubject(messageInfo.getSubject());
      message.setText(messageInfo.getContentBody());
      Transport.send(message);
      log.info(EMAIL_SENT_SUCCESSFUL);
    } catch (MessagingException e) {
      e.printStackTrace();
    }
  }
}
