package oltiv.service.Impl;

import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;

/**
 * Created by pankaj on 27/12/16.
 */
public class EmailServiceImpl {

    public static void main(String gmailId) {
        String to = gmailId;

        System.out.print("\n\n\n\n\n\n\n\n"+gmailId+"\n\n\n\n\n\n");

        String from = "pankaj19nov@gmail.com";
        String password="9610939634";
        String host = "smtp.gmail.com";

        Properties properties = System.getProperties();

        properties.put( "mail.smtp.auth", "true" );
        properties.put("mail.smtp.starttls.enable", "true");
        properties.setProperty("mail.smtp.host",host);
        properties.setProperty("mail.smtp.port","25");

        Session session = Session.getInstance(properties,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(from,password);
                    }
                });

        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

            message.setSubject("Police Department Reset Password");
            message.setText("Your OTP for resetting password is '612493'");

            Transport.send(message);
        }catch (MessagingException mex) {
            mex.printStackTrace();
        }
    }
}
