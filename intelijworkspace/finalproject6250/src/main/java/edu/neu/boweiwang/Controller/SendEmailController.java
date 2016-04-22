package edu.neu.boweiwang.Controller;

import edu.neu.boweiwang.Dao.ListingDao;
import edu.neu.boweiwang.proj.ListingPkg.Listing;
import org.springframework.beans.factory.annotation.Autowired;
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
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;

/**
 * Created by kym-1992 on 4/20/16.
 */
@Controller
@RequestMapping("/sendEmail.do")
public class SendEmailController {
    @Autowired
    ListingDao listingDao;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView handleGET(HttpServletRequest request, HttpServletResponse response){
        String listingID = request.getParameter("listingID");
        if(listingID != null) {
            Listing listing = listingDao.findRecordByID(Integer.parseInt(listingID));
            if(listing.getCombinedAccount().getEmailAddress()!=null) {
                ModelAndView mv = new ModelAndView("sendEmail", "emailAddress", listing.getCombinedAccount().getEmailAddress());

                return mv;
            }
            else{
                return new ModelAndView("buyerlisting.do");
            }
        }
        else{
            return new ModelAndView("buyerlisting.do");
        }
    }

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView handlePOST(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter out = response.getWriter();
        String title = request.getParameter("title");
        String content = request.getParameter("Content");
        String email = request.getParameter("email");

        String pass = "j-epyppsC5Qg";
        String toAddress = email;
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
            message.setSubject(title);

            // Now set the actual message
            message.setText(content);

            // Send message
            Transport transport = session.getTransport("smtp");
            transport.connect(host, fromAddress, pass);
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();

            out.println("<html>");
            out.println("<body>");
            out.println("<script>alert('Email send successfully!')</script>");
            out.println("<script>window.close();</script>");
            out.println("</body>");
            out.println("</html>");
        }catch (MessagingException mex) {
            mex.printStackTrace();
            out.println("<html>");
            out.println("<body>");
            out.println("<script>alert('Email System down, please try again later!')</script>");
            out.println("<script>window.close();</script>");
            out.println("</body>");
            out.println("</html>");
        }

        return null;
    }
}
