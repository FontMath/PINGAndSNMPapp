
package mailsender;

import java.util.ArrayList;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

//Author: FontMath
//Github: https://github.com/FontMath/JavaMailSender

public class SendMailTLS {

    public static boolean SendEmail(String recipient, ArrayList<String> devices) {

        System.setProperty("java.net.preferIPv6Stack", "true");

        final String username = "gerardo.mathus94@gmail.com";
        final String password = "We<3Quagga";

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "2607:f8b0:4003:c14::6d");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
             @Override
             protected PasswordAuthentication getPasswordAuthentication() {
             return new PasswordAuthentication(username, password);
             }   
         });
        try {

                Message message = new MimeMessage(session);
                message.setFrom(new InternetAddress(username));
                message.setRecipients(Message.RecipientType.TO,
                        InternetAddress.parse(recipient));
                message.setSubject("Unavailable Hosts in 172.25.150.X");

                //MENSAJE CON HTML
                String messageText = "<h1>Dispositivos no disponibles</h1> En el segmento 172.25.150.X, los dispostivos <b>NO</b> disponibles son:<br><br> ";
                for (String dev: devices) {
                    messageText += dev + "<br>";
                }
                message.setContent(messageText, "text/html; charset=utf-8");

                

                Transport.send(message);
                return true;

        } catch (MessagingException e) {
                return false;
        }
    }
}
