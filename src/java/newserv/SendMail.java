
package newserv;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class SendMail extends HttpServlet {


    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String emailid=request.getParameter("email");
        out.println(emailid);
        // Sender's email address and password
        String fromEmail = "rinkumanoj1983@gmail.com";
        String password = "1Nitesh2Nikhil";
        
        // Recipient's email address
        String toEmail = emailid;
        
        // Email subject and body
        String subject = "Mrdoc Admin";
        String body = "This is a test email sent from a Java EE servlet.";
        
        // Set mail properties
        Properties properties = new Properties();
        properties.put("mail.smpt.host", "smtp.gmail.com"); // Replace with your SMTP host
        properties.put("mail.smtp.port", "587"); // Replace with your SMTP port
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");

        // Create session object
        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(fromEmail, password);
            }
        });

        try {
            // Create MimeMessage object
            MimeMessage message = new MimeMessage(session);
            // Set sender's email address
            message.setFrom(new InternetAddress(fromEmail));
            // Set recipient's email address
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));
            // Set email subject
            message.setSubject(subject);
            // Set email body
            message.setText(body);

            // Send email
            Transport.send(message);
            
            // Display success message
            out.println("<h1>Email Sent Successfully!</h1>");
        } catch (MessagingException e) {
            // Display error message
            out.println("<h1>Error: Unable to Send Email</h1>");
            e.printStackTrace(out);
        }
    }


}
