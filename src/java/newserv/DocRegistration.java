
package newserv;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Random;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class DocRegistration extends HttpServlet {


    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter(); 
        Random rand = new Random();
        int Did = rand.nextInt(1000);
        String Name=request.getParameter("name");
        int pass=rand.nextInt(999999999);
        String mobno=request.getParameter("mob");
        String Email=request.getParameter("email");
        String dspetiality=request.getParameter("spl");
        String Experience=request.getParameter("exp");
        String Education=request.getParameter("edu");
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/mrdoc", "root", "root");
            PreparedStatement pstm = con.prepareStatement("insert into doctor_registration values(?,?,?,?,?,?,?,?)");
            pstm.setInt(1, Did);
            pstm.setString(2, Name);
            pstm.setInt(3, pass);
            pstm.setString(4, mobno);
            pstm.setString(5, Email);
            pstm.setString(6,dspetiality);
            pstm.setString(7, Experience);
            pstm.setString(8, Education);
            
            

            int row = pstm.executeUpdate();
            if (row == 1) {
                out.println("<h1>Registration Successfull</h1>"
                        +"<h1>hello user :"+Name
                +"<br>Registration id :"+Did+"</h1>");
                out.println("<a href='sendmail.html'>send mail</a>");
            } else {
                out.println("Data could not be inserted");
            }

        }
         catch (Exception e) {
            out.println(e);
        }
      
        
    }


}
