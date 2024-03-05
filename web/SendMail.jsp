<%@page import="javax.mail.MessagingException"%>
<%@page import="javax.mail.Transport"%>
<%@page import="javax.mail.Message"%>
<%@page import="javax.mail.internet.InternetAddress"%>
<%@page import="javax.mail.internet.MimeMessage"%>
<%@page import="javax.mail.PasswordAuthentication"%>
<%@page import="javax.mail.Authenticator"%>
<%@page import="javax.mail.Session"%>
<%@page import="java.util.Properties"%>
<%@page import="java.io.PrintWriter"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
   
    String emailid = (String)request.getAttribute("name");
    String Dpass = (String)request.getAttribute("password");
    String Name = (String)request.getAttribute("docname");
    out.println("Email: " + emailid); 
    
   
    final String fromEmail = "rinkumanoj1983@gmail.com";
    final String password = "uart kwet vqxw fpuu";
    
   
    String toEmail = emailid;
    
   
    String subject = "Mrdoc Admin";
    String body = "hello "+Name+
            " Your User Name:"+emailid+
            "Password:"+Dpass;
    
    
    Properties properties = new Properties();
    properties.put("mail.smtp.host", "smtp.gmail.com");
    properties.put("mail.smtp.port", "587"); 
    properties.put("mail.smtp.auth", "true");
    properties.put("mail.smtp.starttls.enable", "true");
    
    
    Session session1 = Session.getInstance(properties, new Authenticator() {
        @Override
        protected PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication(fromEmail, password);
        }
    });
    
    try {
       
        MimeMessage message = new MimeMessage(session1);
        
       
        message.setFrom(new InternetAddress(fromEmail));
        
        message.addRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));
        
        message.setSubject(subject);
        
        message.setText(body);
        
        Transport.send(message);
        
        out.println("<h1>Email Sent Successfully!</h1>");
    } catch (MessagingException e) {
        out.println("<h1>Error Sending Email: " + e.getMessage() + "</h1>");
        e.printStackTrace();
    }
%>
