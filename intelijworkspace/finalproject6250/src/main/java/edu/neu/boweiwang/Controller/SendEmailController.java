package edu.neu.boweiwang.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Properties;

/**
 * Created by kym-1992 on 4/20/16.
 */
@Controller
@RequestMapping("/sendEmail.do")
public class SendEmailController {

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView handleGET(HttpServletRequest request, HttpServletResponse response){
        String pass = "j-epyppsC5Qg";
        String toAddress = "806874@gmail.com";
        String fromAddress = "wangbowei92@yahoo.com";
        String host = "smtp.mail.yahoo.com";
        Properties properties = System.getProperties();

        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.user", fromAddress);
        properties.put("mail.smtp.password", pass);
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.auth", "true");

        Session session = Session.getDefaultInstance(properties);

        try{
            // Create a default MimeMessage object.
            MimeMessage message = new MimeMessage(session);

            // Set From: header field of the header.
            message.setFrom(new InternetAddress(fromAddress));

            // Set To: header field of the header.
            message.addRecipient(Message.RecipientType.TO,
                    new InternetAddress(toAddress));

            // Set Subject: header field
            message.setSubject("This is the Subject Line!");

            // Now set the actual message
            message.setText("This is actual message");

            // Send message
            Transport transport = session.getTransport("smtp");
            transport.connect(host, fromAddress, pass);
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();
//            Transport.send(message);
            System.out.println("Sent message successfully....");
        }catch (MessagingException mex) {
            mex.printStackTrace();
        }

        return null;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView handlePOST(HttpServletRequest request, HttpServletResponse response){

        return null;
    }
}
