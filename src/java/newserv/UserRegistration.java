package newserv;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserRegistration extends HttpServlet {

    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        Random rand = new Random();
        int RN = rand.nextInt(10000);
        String name = request.getParameter("username");
        String mobile = request.getParameter("mob");
        String Email = request.getParameter("email");
        String password = request.getParameter("pass");
        String dataToCheck[]={name,mobile,Email};

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/mrdoc", "root", "root");
            PreparedStatement pstm = con.prepareStatement("insert into regis values(?,?,?,?,?)");
            pstm.setInt(1, RN);
            pstm.setString(2, name);
            pstm.setString(3, mobile);
            pstm.setString(4, Email);
            pstm.setString(5, password);

            int row = pstm.executeUpdate();

            if (row == 1) {
                out.println("<h1>Registration Successfull</h1>"
                        +"<h1>hello user :"+name
                +"<br>Registration id :"+RN+"</h1>");
            } else {
                out.println("Data could not be inserted");
            }

        } catch (Exception e) {
            out.println(e);
        }
      
    }
}

        
