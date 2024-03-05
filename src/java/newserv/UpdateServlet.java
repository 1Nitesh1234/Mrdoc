
package newserv;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class UpdateServlet extends HttpServlet {

 
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String name = request.getParameter("username");
        String mobile = request.getParameter("mob");
        String Email = request.getParameter("email");
        String password = request.getParameter("pass");
        String userid = request.getParameter("uid");

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/mrdoc", "root", "root");
            PreparedStatement pstm = con.prepareStatement("UPDATE regis = ? WHERE id = userid");
            
            pstm.setString(1, name);
            pstm.setString(2, mobile);
            pstm.setString(3, Email);
            pstm.setString(4, password);

            int row = pstm.executeUpdate();

            if (row == 1) {
                out.println("<h1>Registration Successfull</h1>");
            } else {
                out.println("Data could not be inserted");
            }

        } catch (Exception e) {
            out.println(e);
        }
      
    }
           
    }



