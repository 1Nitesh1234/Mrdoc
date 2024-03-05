package newserv;

import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Doc_Mail extends HttpServlet {

    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String doid = request.getParameter("id");
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/mrdoc", "root", "root");
            PreparedStatement pstm = con.prepareStatement("select Demail,Dpass,Dname from doctor_registration where DID=?");

            pstm.setString(1, doid);

            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {
                String email = rs.getString("Demail");
                String pass = rs.getString("Dpass");
                String Name = rs.getString("Dname");
                out.println("Doctor's Email: " + email);
                out.println("Doctor's pass: " + pass);
                request.setAttribute("name",email);
                request.setAttribute("password",pass);
                request.setAttribute("docname",Name);
                RequestDispatcher rd = request.getRequestDispatcher("SendMail.jsp");
                rd.forward(request, response);
                

                // Send email after retrieving the email address
                out.println("<br>Email sent successfully.");
            } else {
                out.println("Doctor with ID " + doid + " not found.");
            }
            

            con.close(); // Close the connection
        } catch (Exception e) {
            out.println(e);
        }
    }

}
