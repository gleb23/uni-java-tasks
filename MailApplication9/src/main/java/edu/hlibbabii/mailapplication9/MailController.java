package edu.hlibbabii.mailapplication9;

import javax.mail.*;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.Properties;

class MailController {

    private Session session;

    public void authenticate(String smtpServer, String accountEmail, String accountPassword) {
        Properties props = new Properties();
        props.put("mail.smtp.host", smtpServer);
        props.put("mail.smtp.port", "587");
        props.put("mail.from", accountEmail);
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.auth", "true");
        props.put("mail.debug", "false");

        session = Session.getInstance(props, new Authenticator() {

            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(accountEmail, accountPassword);
            }
        });
    }

    public void send(Email email) throws MessagingException {
            MimeMessage msg = new MimeMessage(session);
            msg.setFrom();
            msg.setRecipients(Message.RecipientType.TO,
                    email.getTo());
            msg.setSubject(email.getSubject());
            msg.setSentDate(new Date());
            msg.setText(email.getText());
            Transport.send(msg);
    }
}
